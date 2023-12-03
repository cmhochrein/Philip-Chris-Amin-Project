package com.paperpath.demo.photorequests;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Chris
 */
@Repository
public interface PhotoRequestRepository extends JpaRepository<PhotoRequest, Long>{
    
    @Query("SELECT r FROM PhotoRequest r WHERE r.photoObjInRequest != null")
    public List<PhotoRequest> findActive();
    
    @Query("SELECT r FROM PhotoRequest r WHERE r.photoObjInRequest = null")
    public List<PhotoRequest> findAllFree();
}
