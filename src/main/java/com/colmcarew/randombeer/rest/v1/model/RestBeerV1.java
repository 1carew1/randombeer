package com.colmcarew.randombeer.rest.v1.model;

/**
 * Created by colmcarew on 13/07/2017.
 * The purpose of this class to expose Read only information on random RestBeerV1 - do not want to give away database ids
 */
public class RestBeerV1 {
    private String name;
    private String description;
    private Double alcoholPercentage;
    private String breweryLocation;

    public RestBeerV1(String name, String description, Double alcoholPercentage, String breweryLocation) {
        this.name = name;
        this.description = description;
        this.alcoholPercentage = alcoholPercentage;
        this.breweryLocation = breweryLocation;
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

    public String getBreweryLocation() {
        return breweryLocation;
    }
}
