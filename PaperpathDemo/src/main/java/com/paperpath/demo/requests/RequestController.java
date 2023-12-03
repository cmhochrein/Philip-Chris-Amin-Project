package com.paperpath.demo.requests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class RequestController {

    @Autowired
    RequestService requestService;

    @GetMapping("/create")
    public String createRequest(Request request) {
        return "writer/photo-request";
    }
    
    @PostMapping("/submitRequest")
    public String submitRequest (@PathVariable String title, @PathVariable String requestBody){
        requestService.uploadNewRequest(title, requestBody);
        return "redirect:/writer/writer";
    }
}
