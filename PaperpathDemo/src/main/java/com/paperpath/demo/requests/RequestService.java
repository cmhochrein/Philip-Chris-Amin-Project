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

    /**
     * Gets all requests in the database
     *
     * @return A List<> of all requests
     */
    public List<Request> getAllRequests() {
        return reqRepo.findAll();
    }

    /**
     * Gets a list of all requests which have been accepted by some
     * photographer
     *
     * @return
     */
    public List<Request> getAllActiveRequests() {
        return reqRepo.findActive();
    }

    /**
     * Gets a list of all requests which have yet to be accepted
     *
     * @return
     */
    public List<Request> getAllFreeRequests() {
        return reqRepo.findAllFree();
    }

    /**
     * Get a single request by ID
     *
     * @param requestId
     * @return the photo
     */
    public Request getRequest(long requestId) {
        return reqRepo.getReferenceById(requestId);
    }

    /*  TO-DO: THIS NEEDS TO BE COMPLETED BY AMIN TO MAKE THE PHOTO REQUEST CREATION CODE */
    public Request uploadNewRequest(String title, String requestBody) {
        Request request = new Request(title, requestBody, null);
        return request;
    }

    /**
     * Takes a photo entity and saves it to the request table; this is then
     * cascaded down to the photos table
     *
     * @param requestId the request the photo is linked to
     * @param photo a photo entity created from a user uploaded file
     */
    public void savePhoto(long requestId, Photo photo) {
        Request request = reqRepo.getReferenceById(requestId);
        request.SetPhoto(photo);
        reqRepo.save(request);
    }
}
