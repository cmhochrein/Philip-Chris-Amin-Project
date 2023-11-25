package com.paperpath.demo.photos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Chris
 */
@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {
    
}
