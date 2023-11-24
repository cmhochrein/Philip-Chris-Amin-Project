/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.paperpath.demo.requests;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Chris
 */
public interface RequestRepository extends JpaRepository<Request, Long>{
    
}
