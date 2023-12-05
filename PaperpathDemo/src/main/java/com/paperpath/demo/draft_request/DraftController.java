package com.paperpath.demo.draft_request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/draft")
public class DraftController {

    @Autowired
    private DraftService service;

    @GetMapping("/all")
    public String getAllDrafts(Model model) {
        model.addAttribute("draftList", service.getAllDrafts());
        return "editor/list-editors";
    }
    

    @GetMapping("/id={id}")
    public String getDraft(@PathVariable long id, Model model) {
        model.addAttribute("draft", service.getDraft(id));
        return "editor/editor-detail";
    }

    @DeleteMapping("/delete/id={id}")
    public String deleteDraft(@PathVariable long id, Model model) {
    service.deleteDraft(id);
    return "redirect:/editor/all";
}

    @PostMapping("/create")

    public String createEditor(Draft draft) {
        service.saveDraft(draft);
        return "redirect:/writer/main-page";
    }

    public String createDraft(Draft Draft) {
        service.saveDraft(Draft);
        return "redirect:/draft/all";

    }

    @PostMapping("/update")
    public String updateDraft(Draft Draft) {
        service.updateDraft(Draft);
        return "redirect:/editor/all";
    }

    @GetMapping("/new-draft")
    public String newDraftForm(Model model) {
        return "writer/newDraftRequest";
    }

    @GetMapping("/update/id={id}")
    public String updateDraftForm(@PathVariable long id, Model model) {
        model.addAttribute("draft", service.getDraft(id));
        return "editor/update-editor";
    }

}