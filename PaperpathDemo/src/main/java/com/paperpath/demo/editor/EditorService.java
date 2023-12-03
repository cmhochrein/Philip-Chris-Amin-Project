package com.paperpath.demo.editor;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditorService {

    @Autowired
    EditorRepository repo;

    public List<Editor> getAllEditors() {
        return repo.findAll();
    }

    public Editor getEditor(long id) {
        return repo.getEditorById(id);
    }

    public void deleteEditor(long id) {
        repo.deleteEditorById(id);
    }

    public void saveEditor(Editor editor) {
        repo.saveEditor(editor);
    }

    public void updateEditor(Editor editor) {
        repo.updateEditor(editor);
    }
}
