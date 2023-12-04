package com.paperpath.demo.photorequests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Chris & Amin
 */
@Controller
@RequestMapping("/request")
public class PhotoRequestController {

    @Autowired
    PhotoRequestService photoRequestService;

    @GetMapping("/create")
    public String createRequest(Model model) {
        return "writer/photo-request";
    }
    
    @PostMapping("/submitRequest")
    public String submitRequest (PhotoRequest photoRequest){
        photoRequestService.uploadNewRequest(photoRequest);
        return "redirect:/writer/writer";
    }
}
