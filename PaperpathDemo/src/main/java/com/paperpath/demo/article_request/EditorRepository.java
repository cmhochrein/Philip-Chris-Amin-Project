package com.paperpath.demo.article_request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class EditorRepository {

    @Autowired
    NamedParameterJdbcTemplate template;

    List<Editor> findAll() {
        String query = "select id, user_name, request from article_request";
        return template.query(query,
                (result, rowNum) -> new Editor(
                        result.getLong("id"),
                        result.getString("user_name"),
                        result.getString("request")
                )
        );
    }

    public Editor getEditorById(long id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue(
                "id", id);
        String query = "select * from article_request where id=:id ";
        return template.queryForObject(query, namedParameters,
                BeanPropertyRowMapper.newInstance(Editor.class));
    }

    public int saveEditor(Editor editor) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("user_name", editor.getUserName());
        paramMap.put("request", editor.getRequest());
        String query = "INSERT INTO article_request(user_name, request) VALUES(:user_name, :request)";
        return template.update(query, paramMap);
    }

    void deleteEditorById(long id) {

        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue(
                "id", id);
        String query = "delete from article_request where id=:id";
        template.update(query, namedParameters);
    }

    void updateEditor(Editor editor) {

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", editor.getId());
        paramMap.put("user_name", editor.getUserName());
        paramMap.put("request", editor.getRequest());
        String query = "update article_request set user_name=:user_name, request=:request where id=:id ";
        template.update(query, paramMap);
    }
}
