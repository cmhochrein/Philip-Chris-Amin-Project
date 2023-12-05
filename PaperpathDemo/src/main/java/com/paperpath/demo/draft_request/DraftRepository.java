package com.paperpath.demo.draft_request;

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
public class DraftRepository {

    @Autowired
    NamedParameterJdbcTemplate template;

    List<Draft> findAll() {
        String query = "select id, user_name, request from draft_request";
        return template.query(query,
                (result, rowNum) -> new Draft(
                        result.getLong("id"),
                        result.getString("user_name"),
                        result.getString("request")
                )
        );
    }

    public Draft getDraftById(long id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue(
                "id", id);
        String query = "select * from draft_request where id=:id ";
        return template.queryForObject(query, namedParameters,
                BeanPropertyRowMapper.newInstance(Draft.class));
    }

    public int saveDraft(Draft draft) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("user_name", draft.getUserName());
        paramMap.put("request", draft.getRequest());
        String query = "INSERT INTO draft_request(user_name, request) VALUES(:user_name, :request)";
        return template.update(query, paramMap);
    }

    void deleteDraftById(long id) {

        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue(
                "id", id);
        String query = "delete from draft_request where id=:id";
        template.update(query, namedParameters);
    }

    void updateDraft(Draft draft) {

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", draft.getId());
        paramMap.put("user_name", draft.getUserName());
        paramMap.put("request", draft.getRequest());
        String query = "update draft_request set user_name=:user_name, request=:request where id=:id ";
        template.update(query, paramMap);
    }
}
