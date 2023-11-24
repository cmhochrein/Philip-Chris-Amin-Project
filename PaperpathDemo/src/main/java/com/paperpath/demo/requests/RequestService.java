/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.paperpath.demo.requests;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Chris
 */
public class RequestService {

    @Autowired
    private RequestRepository repo;

    public List<Request> getAllRequests() {
        return repo.findAll();
    }
}
