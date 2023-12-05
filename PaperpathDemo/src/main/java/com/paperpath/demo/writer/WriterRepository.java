package com.paperpath.demo.writer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Amin
 */
@Repository
public interface WriterRepository extends JpaRepository<Writer, Long> {
    
}



