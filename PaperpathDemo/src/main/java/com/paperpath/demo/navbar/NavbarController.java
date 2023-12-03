package com.paperpath.demo.navbar;

import com.paperpath.demo.editor.EditorController;
import com.paperpath.demo.photos.PhotoController;
<<<<<<< HEAD
import com.paperpath.demo.photorequests.PhotoRequestController;
=======
import com.paperpath.demo.requests.RequestController;
import com.paperpath.demo.writer.WriterController;
>>>>>>> 236b7eb5438255a7347f07d41025f679dc50ea41
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
<<<<<<< HEAD
    PhotoRequestController requestController;
=======
    RequestController requestController;
    
    @Autowired
    WriterController writerController;
>>>>>>> 236b7eb5438255a7347f07d41025f679dc50ea41

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
