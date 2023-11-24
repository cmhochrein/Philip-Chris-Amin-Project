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
