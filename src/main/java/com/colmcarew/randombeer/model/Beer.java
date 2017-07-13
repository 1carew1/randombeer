package com.colmcarew.randombeer.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by colmcarew on 13/07/2017.
 */

@Entity
@Data
public class Beer {
    private @Id @GeneratedValue Long id;
    private String name;
    private String description;
    private Double alcoholPercentage;

    private Beer() {}

    public Beer(String name, String description, Double alcoholPercentage) {
        this.name = name;
        this.description = description;
        this.alcoholPercentage = alcoholPercentage;
    }
}
