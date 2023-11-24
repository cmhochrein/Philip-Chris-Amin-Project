package com.paperpath.demo.requests;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Chris
 */
public interface RequestRepository extends JpaRepository<Request, Long>{
    
}
