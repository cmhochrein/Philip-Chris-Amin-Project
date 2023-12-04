package com.paperpath.demo.navbar;

import com.paperpath.demo.article_request.EditorController;
import com.paperpath.demo.photos.PhotoController;
import com.paperpath.demo.writer.WriterController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Chris, Amin, Philip
 */
@Controller
@RequestMapping("/navbar")
public class NavbarController {

    @Autowired
    PhotoController photoController;

    @Autowired
    EditorController editorController;

    @Autowired
    WriterController writerController;

    @GetMapping("/photo")
    public String getPhotographerMain(Model model) {
        return photoController.getPhotoRequests(model);
    }

    @GetMapping("/editor")
    public String getEditorMain(Model model) {
        return editorController.getAllEditors(model);
    }

    @GetMapping("/writer")
    public String getWriterMain(Model model) {
        return writerController.writerMain(model);
    }
}
