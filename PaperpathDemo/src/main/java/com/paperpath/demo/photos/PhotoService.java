package com.paperpath.demo.photos;

import com.paperpath.demo.requests.RequestService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Chris
 */
@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepo;
    @Autowired
    private RequestService requestService;

    /**
     * Gets a single photo entity by its ID in the database.
     *
     * @param photoId the id associated with a photo in the "photo" table
     * @return the photo
     */
    public Photo getPhoto(long photoId) {
        return photoRepo.getReferenceById(photoId);
    }

    /**
     * Creates a photo object from a multipart file, and then hands that object
     * to requestService.savePhoto
     *
     * @param requestId The id of the request to link the photo to
     * @param picture The file object (photo) to be stored on the database
     * @throws IOException
     */
    public void uploadPhoto(long requestId, MultipartFile picture) throws IOException {
        // Create the photo object 
        String fileName = StringUtils.cleanPath(picture.getOriginalFilename());
        Photo photo = new Photo(fileName, picture.getContentType(), picture.getBytes());
        // Send it to RequestService to get saved
        requestService.savePhoto(requestId, photo);
    }
}
