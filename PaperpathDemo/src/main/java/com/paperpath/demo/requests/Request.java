package com.paperpath.demo.requests;

import com.paperpath.demo.photos.Photo;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Chris
 */
@Entity
@Table(name = "Requests")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title", columnDefinition = "VARCHAR(255)")
    private String title;

    @Column(name = "request-body", columnDefinition = "LONGTEXT")
    private String requestBody;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "reqphoto_id", referencedColumnName = "photo_id")
    private Photo photoObjInRequest;

    public Request(String title, String requestBody, Photo photo) {
        this.title = title;
        this.requestBody = requestBody;
        this.photoObjInRequest = photo;
    }
    
    public void SetPhoto(Photo photo){
        this.photoObjInRequest = photo;
    }
}
