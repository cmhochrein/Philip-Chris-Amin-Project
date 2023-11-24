package com.example.demo.photos;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Chris
 */

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
