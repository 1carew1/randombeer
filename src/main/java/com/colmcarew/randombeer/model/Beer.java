package com.colmcarew.randombeer.model;

import javax.persistence.*;

/**
 * Created by colmcarew on 13/07/2017.
 */

@Entity
public class Beer {
    private @Id @GeneratedValue Long id;
    private String name;
    private String description;
    private Double alcoholPercentage;
    @ManyToOne
    @JoinColumn(name = "brewery_id")
    private Brewery brewery;

    private Beer() {}

    public Beer(String name, String description, Double alcoholPercentage, Brewery brewery) {
        this.name = name;
        this.description = description;
        this.alcoholPercentage = alcoholPercentage;
        this.brewery = brewery;
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

    public Brewery getBrewery() {
        return brewery;
    }

    public void setBrewery(Brewery brewery) {
        this.brewery = brewery;
    }
}
