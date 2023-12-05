package com.paperpath.demo.draft_request;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DraftService {

    @Autowired
    DraftRepository repo;

    public List<Draft> getAllDrafts() {
        return repo.findAll();
    }

    public Draft getDraft(long id) {
        return repo.getDraftById(id);
    }

    public void deleteDraft(long id) {
        repo.deleteDraftById(id);
    }

    public void saveDraft(Draft draft) {
        repo.saveDraft(draft);
    }

    public void updateDraft(Draft draft) {
        repo.updateDraft(draft);
    }
}
