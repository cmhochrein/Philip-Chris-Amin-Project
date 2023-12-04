package com.paperpath.demo.photorequests;

import com.paperpath.demo.photos.Photo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Chris
 */
@Service
public class PhotoRequestService {

    @Autowired
    private PhotoRequestRepository reqRepo;

    /**
     * Gets all requests in the database
     *
     * @return A List<> of all requests
     */
    public List<PhotoRequest> getAllRequests() {
        return reqRepo.findAll();
    }

    /**
     * Gets a list of all requests which have been accepted by some photographer
     *
     * @return
     */
    public List<PhotoRequest> getAllActiveRequests() {
        return reqRepo.findActive();
    }

    /**
     * Gets a list of all requests which have yet to be accepted
     *
     * @return
     */
    public List<PhotoRequest> getAllFreeRequests() {
        return reqRepo.findAllFree();
    }

    /**
     * Get a single request by ID
     *
     * @param requestId
     * @return the photo
     */
    public PhotoRequest getRequest(long requestId) {
        return reqRepo.getReferenceById(requestId);
    }

    /*  TO-DO: THIS NEEDS TO BE COMPLETED BY AMIN TO MAKE THE PHOTO REQUEST CREATION CODE */
    public void uploadNewRequest(PhotoRequest photoRequest) {
      
        reqRepo.save(photoRequest);
    }

    /**
     * Takes a photo entity and saves it to the request table; this is then
     * cascaded down to the photos table
     *
     * @param requestId the request the photo is linked to
     * @param photo a photo entity created from a user uploaded file
     */
    public void savePhoto(long requestId, Photo photo) {
        PhotoRequest request = reqRepo.getReferenceById(requestId);
        request.SetPhoto(photo);
        reqRepo.save(request);
    }

    public void deletePhoto(long requestId) {
        PhotoRequest request = reqRepo.getReferenceById(requestId);
        request.SetPhoto(null);
        reqRepo.save(request);
    }
}
