package com.paperpath.demo.requests;

import com.paperpath.demo.photos.Photo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    @Column(name = "request_id")
    private long requestId;

    @Column(name = "title", columnDefinition = "VARCHAR(255)")
    private String title;

    @Column(name = "request-body", columnDefinition = "LONGTEXT")
    private String requestBody;

    @OneToOne(mappedBy = "requestObjInPhoto")
    private Photo photoInRequest;

    public Request(String title, String requestBody) {
        this.title = title;
        this.requestBody = requestBody;
    }
}