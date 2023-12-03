package com.paperpath.demo.writer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author Amin
 */

@Controller 
@RequestMapping("/writer")
public class WriterController {
    
    @GetMapping ("/main-page")
    public String writerMain(Model model){
        return "writer/writer";
    }
    
    
}
