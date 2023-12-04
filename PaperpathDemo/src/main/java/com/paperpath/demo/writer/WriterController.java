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


/**
 *
 * @author Amin
 */
@Controller
@RequestMapping("/writer")
public class WriterController {

    @GetMapping("/main-page")
    public String writerMain(Model model) {
        return "writer/writer";
    }

    @GetMapping("/create")
    public String writerCreate(Model model) {
        return "writer/createDraft";
    }
    
    
   @RestController
public class QuillController {
    @Autowired
    private WriterService quillService;

    @PostMapping("/save-content")
    public String saveContent(@RequestBody String content) {
        quillService.saveContent(content);
        return "writer/writer";
    }
        
}
}







