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

    /**
     * Displays the request bulletin populated by all free requests in the
     * database
     *
     * @param model the model
     * @return photo/photographer
     */
    @GetMapping("/mainpage")
    public String getPhotoRequests(Model model) {
        model.addAttribute("requestList", requestService.getAllFreeRequests());
        return "photo/bulletin";
    }

    /**
     * Displays the accepted requests page when the user clicks the "view active
     * requests" button
     *
     * @param model the model
     * @return photo/accepted-page
     */
    @GetMapping("/active-requests")
    public String getActiveRequests(Model model) {
        model.addAttribute("requestList", requestService.getAllActiveRequests());
        return "photo/active-page";
    }

    /**
     * Displays the "submit-photo" page when a user clicks a request to accept
     * it.
     *
     * @param requestId the id associated with a request in the "requests" table
     * @param model the model
     * @return photo/submit-photo
     */
    @GetMapping("/id={requestId}")
    public String accceptRequest(@PathVariable long requestId, Model model) {
        model.addAttribute("request", requestService.getRequest(requestId));
        return "photo/submit-photo";
    }

    /**
     * Uploads a photo to the mySQL database, the photo is linked to a specific
     * request on the database.
     *
     * @param requestId the id associated with a request in the "requests" table
     * @param file the photo to be uploaded
     * @return redirect:/photo/active-requests
     */
    @PostMapping("/submitphoto/id={requestId}")
    public String uploadImage(@PathVariable long requestId, @RequestParam("image") MultipartFile file) throws IOException {
        photoService.uploadPhoto(requestId, file);
        return "redirect:/photo/active-requests";
    }

    /**
     * Displays the "update-photo" page when a user clicks the "Upload new
     * photo" button on the active-requests page
     *
     * @param requestId The id of the request to be updated
     * @param model The model
     * @return photo/update-photo
     */
    @GetMapping("/updatephoto/id={requestId}")
    public String updateActiveRequest(@PathVariable long requestId, Model model) {
        model.addAttribute("request", requestService.getRequest(requestId));
        return "photo/update-photo";
    }

    /**
     * 
     * @param requestId The id of the request to be updated
     * @param file The photo to be uploaded
     * @return redirect:/photo/active-requests
     * @throws IOException 
     */
    @PostMapping("/submitphotoupdate/id={requestId}")
    public String updateRequestPhoto(@PathVariable long requestId, @RequestParam("image") MultipartFile file) throws IOException {
        photoService.uploadPhoto(requestId, file);
        return "redirect:/photo/active-requests";
    }
    
    @GetMapping("delete/id={requestId}")
    public String deletePhoto(@PathVariable long requestId){
        requestService.deletePhoto(requestId);
        return "redirect:/photo/active-requests";
    }
}
