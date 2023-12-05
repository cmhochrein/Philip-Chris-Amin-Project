package com.paperpath.demo.draft_request;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "draft_request")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Draft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String request;

    public Draft(String userName, String request) {
        this.userName = userName;
        this.request = request;
    }
}
