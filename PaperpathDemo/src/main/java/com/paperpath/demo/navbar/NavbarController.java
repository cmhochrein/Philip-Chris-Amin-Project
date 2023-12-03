package com.paperpath.demo.navbar;

import com.paperpath.demo.editor.EditorController;
import com.paperpath.demo.photos.PhotoController;
import com.paperpath.demo.requests.RequestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Chris
 */
@Controller
@RequestMapping("/navbar")
public class NavbarController {

    @Autowired
    PhotoController photoController;

    @Autowired
    EditorController editorController;

    @Autowired
    RequestController requestController;

    @GetMapping("/photo")
    public String getPhotographerMain(Model model) {
        return photoController.getPhotoRequests(model);
    }

    @GetMapping("/editor")
    public String getEditorMain(Model model) {
        return editorController.getAllEditors(model);
    }

//    @GetMapping("/writer")
//    public String getWriterMain(Model model) {
//        return editorController.getAllEditors(model);
//    }
}
