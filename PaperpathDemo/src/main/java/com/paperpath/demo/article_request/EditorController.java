package com.paperpath.demo.article_request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/editor")
public class EditorController {

    @Autowired
    private EditorService service;

    @GetMapping("/all")
    public String getAllEditors(Model model) {
        model.addAttribute("editorList", service.getAllEditors());
        return "editor/list-editors";
    }

    @GetMapping("/id={id}")
    public String getEditor(@PathVariable long id, Model model) {
        model.addAttribute("editor", service.getEditor(id));
        return "editor/editor-detail";
    }

    @DeleteMapping("/delete/id={id}")
    public String deleteEditor(@PathVariable long id, Model model) {
    service.deleteEditor(id);
    return "redirect:/editor/all";
}

    @PostMapping("/create")
    public String createEditor(Editor editor) {
        service.saveEditor(editor);
        return "redirect:/editor/all";
    }

    @PostMapping("/update")
    public String updateEditor(Editor editor) {
        service.updateEditor(editor);
        return "redirect:/editor/all";
    }

    @GetMapping("/new-editor")
    public String newEditorForm(Model model) {
        return "editor/new-editor";
    }

    @GetMapping("/update/id={id}")
    public String updateEditorForm(@PathVariable long id, Model model) {
        model.addAttribute("editor", service.getEditor(id));
        return "editor/update-editor";
    }

}