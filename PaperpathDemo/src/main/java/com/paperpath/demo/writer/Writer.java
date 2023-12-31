package com.paperpath.demo.writer;

import jakarta.persistence.Column;
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
 * @author Amin
 */
@Entity
@Table(name = "articles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Writer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
     @Column(name = "title", columnDefinition = "VARCHAR(255)")
    private String title;

    @Column(columnDefinition = "LONGTEXT")
    private String content;

    
public Writer (String title, String content){
    this.content = content;
    this.title = title;
}
    
}


