package com.paperpath.demo.requests;

import com.paperpath.demo.photos.Photo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Chris
 */
@Service
public class RequestService {

    @Autowired
    private RequestRepository reqRepo;

    public List<Request> getAllRequests() {
        return reqRepo.findAll();
    }
    
    /**
     * Get a single photo by ID
     *
     * @param requestId
     * @return the photo
     */
    public Request getRequest(long requestId) {
        return reqRepo.getReferenceById(requestId);
    }
    
    
    /*  TO-DO: THIS NEEDS TO BE COMPLETED BY AMIN TO MAKE THE PHOTO REQUEST CREATION CODE */
    public Request uploadNewRequest(String title, String requestBody){
        Request request = new Request(title, requestBody, null);
        return request;
    }
    
    public void savePhoto(long requestId, Photo photo){
        Request request = reqRepo.getReferenceById(requestId);
        request.SetPhoto(photo);
        reqRepo.save(request);
    }
}
