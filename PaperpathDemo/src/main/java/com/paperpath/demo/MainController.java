package com.paperpath.demo;

import com.paperpath.demo.article_request.EditorController;
import com.paperpath.demo.photos.PhotoController;
import com.paperpath.demo.writer.WriterController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Chris
 */
@Controller
public class MainController {
    @GetMapping(value = {"", "/", "/home"})
    public String dashboard(Model model) {
        return "index";
    }
}
