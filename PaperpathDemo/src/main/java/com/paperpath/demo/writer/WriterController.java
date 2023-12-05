package com.paperpath.demo.writer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

/**
 *
 * @author Amin
 */
@Controller
@RequestMapping("/writer")
public class WriterController {

    @Autowired
    private WriterService quillService;

    @GetMapping("/main-page")
    public String writerMain(Model model) {
        return "writer/writer";
    }

    @GetMapping("/create")
    public String writerCreate(Model model) {
        return "writer/createDraft";
    }

    @GetMapping("/display")
    public String displayCOntent(Model model) {
        List<Writer> contentList = quillService.getAllContent();
        model.addAttribute("contentList", contentList);
        return "writer/displayDrafts"; // Thymeleaf template name
    }
}
