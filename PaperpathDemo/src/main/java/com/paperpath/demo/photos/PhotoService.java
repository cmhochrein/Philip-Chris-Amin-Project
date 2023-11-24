/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.paperpath.demo.photos;

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
    private PhotoRepository repo;

    public Photo uploadPhoto(MultipartFile picture) throws IOException {
        String fileName = StringUtils.cleanPath(picture.getOriginalFilename());
        Photo photo = new Photo(fileName, picture.getContentType(), picture.getBytes());

        return repo.save(photo);
    }
}
