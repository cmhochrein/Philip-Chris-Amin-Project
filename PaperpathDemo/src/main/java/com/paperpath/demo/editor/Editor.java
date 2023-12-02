package com.paperpath.demo.editor;

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
 * @author Philip Sijerkovic
 */
@Entity
@Table(name = "article_request")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Editor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String role;
    private String text;

    public Editor(String role, String text) {
        this.role = role;
        this.text = text;
    }

}