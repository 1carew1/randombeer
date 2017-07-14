package com.colmcarew.randombeer.model;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;

/**
 * Created by colmcarew on 13/07/2017.
 */

@Entity
public class Beer {
    private @Id
    @GeneratedValue
    Long id;
    private String name;
    private String description;
    @URL
    private String imageUrl;
    private Double alcoholPercentage;
    @ManyToOne
    @JoinColumn(name = "brewery_id")
    private Brewery brewery;

    private Beer() {
    }

    public Beer(String name, String description, Double alcoholPercentage, Brewery brewery) {
        this.name = name;
        this.description = description;
        this.alcoholPercentage = alcoholPercentage;
        this.brewery = brewery;
    }

    public Beer(String name, String description, Double alcoholPercentage, Brewery brewery, String imageUrl) {
        this.name = name;
        this.description = description;
        this.alcoholPercentage = alcoholPercentage;
        this.brewery = brewery;
        this.imageUrl = imageUrl;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getAlcoholPercentage() {
        return alcoholPercentage;
    }

    public Brewery getBrewery() {
        return brewery;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}