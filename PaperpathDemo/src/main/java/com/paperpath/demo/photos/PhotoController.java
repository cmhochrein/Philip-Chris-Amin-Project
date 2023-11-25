package com.paperpath.demo.photos;

import com.paperpath.demo.requests.RequestService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Chris
 */
@Controller
@RequestMapping("/photo")
public class PhotoController {

    @Autowired
    PhotoService photoService;

    @Autowired
    RequestService requestService;

    @GetMapping("/mainpage")
    public String getPhotoRequests(Model model) {
        model.addAttribute("requestList", requestService.getAllRequests());
        return "photo/photographer";
    }

    @GetMapping("/active-requests")
    public String getAcceptedRequests(Model model) {
        return "photo/accepted-page";
    }

    /**
     * @param requestId the id associated with a request in the "requests" table
     * @param model the model
     * @return The photo/submit-photo page populated 
     * with the selected request 
     */
    @GetMapping("/id={requestId}")
    public String accceptRequest(@PathVariable long requestId, Model model) {
        /*  RIGHT NOW THIS ONLY SHOWS THE UPLOAD BUTTONS, 
        MAKE IT SHOW THE ACTUAL REQUEST, USE THE CODE FROM 
        update-product.html PLUS THE CODE WE ALREADY HAVE 
        FROM photographer.html TO SHOW THE REQUEST*/
        model.addAttribute("request", requestService.getRequest(requestId));
        return "photo/submit-photo";
    }

    /**
     * Uploads a photo to the mySQL database
     * @param requestId the id associated with a request in the "requests" table
     * @param file the photo to be uploaded
     * @return the accepted requests page
     */ 
    @PostMapping("/submitphoto/id={requestId}")
    public String uploadImage(@PathVariable long requestId, @RequestParam("image") MultipartFile file) throws IOException {
        photoService.uploadPhoto(requestId, file);
        return "photo/accepted-page";
    }
}
