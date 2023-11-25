package com.paperpath.demo.photos;

//import com.paperpath.demo.requests.RequestService;
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
     * Get a single photo by ID
     *
     * @param photoId the id associated with a photo in the "photo" table
     * @return the photo
     */
    public Photo getPhoto(long photoId) {
        return photoRepo.getReferenceById(photoId);
    }

    public Photo uploadPhoto(long requestId, MultipartFile picture) throws IOException {
        String fileName = StringUtils.cleanPath(picture.getOriginalFilename());
        Photo photo = new Photo(fileName, picture.getContentType(), picture.getBytes());
        requestService.savePhoto(requestId, photo);
        return photo;
    }
}
