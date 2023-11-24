package com.paperpath.demo.photos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 *
 * @author Chris
 */
@Controller
@RequestMapping("/photo")
//@RequestParam("image") MultipartFile multipartFile
public class PhotoController {

    @Autowired
    PhotoService photoService;

    @GetMapping("/mainpage")
    public String getPhotoRequests(Model model) {
        return "photo/photographer";
    }

    @GetMapping("/active-requests")
    public String getAcceptedRequests(Model model) {
        return "photo/accepted-page";
    }

    @PostMapping("/submitphoto")
    public String uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        photoService.uploadPhoto(file);
        return "photo/accepted-page";
    }
}
