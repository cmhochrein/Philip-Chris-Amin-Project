package com.paperpath.demo.photorequests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
    public String createRequest(PhotoRequest request) {
        return "writer/photo-request";
    }
    
    @PostMapping("/submitRequest")
    public String submitRequest (@PathVariable String title, @PathVariable String requestBody){
        photoRequestService.uploadNewRequest(title, requestBody);
        return "redirect:/writer/writer";
    }
}
