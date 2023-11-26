package com.paperpath.demo.requests;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Chris
 */
@Repository
public interface RequestRepository extends JpaRepository<Request, Long>{
    
    @Query("SELECT r FROM Request r WHERE r.photoObjInRequest != null")
    public List<Request> findActive();
    
    @Query("SELECT r FROM Request r WHERE r.photoObjInRequest = null")
    public List<Request> findAllFree();
}
