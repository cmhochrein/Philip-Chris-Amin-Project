package com.paperpath.demo.requests;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private String title;
    private String requestBody;
    
    public Request(String title, String requestBody) {
        this.title = title;
        this.requestBody = requestBody;
    }

    public void SetTitle(String title) {
        this.title = title;
    }

    public void SetRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public String GetRequestBody() {
        return this.requestBody;
    }

    public String GetTitle() {
        return this.title;
    }
}
