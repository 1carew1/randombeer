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


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAlcoholPercentage() {
        return alcoholPercentage;
    }

    public void setAlcoholPercentage(Double alcoholPercentage) {
        this.alcoholPercentage = alcoholPercentage;
    }
}
