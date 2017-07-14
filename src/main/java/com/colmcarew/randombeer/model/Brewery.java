package com.colmcarew.randombeer.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by colmcarew on 13/07/2017.
 * The Brewery Domain Class
 */

@Entity
@Table(name = "brewery")
public class Brewery {
    private @Id
    @GeneratedValue
    Long id;
    private String name;
    private String location;
    // The Eager fetch is a bad idea in general - used as the test "testCreatingABeer" was failing without it
    // I would prefer if Brewery knew nothing about Beer and Beer pointed to the Brewery incase a Brewery has a very large number of beers
    // As then it is a bad idea for a brewery to have many beers, unfortunately this was the only way I could figure out how to get an Entity to have
    // Another Entity in Spring, for now
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "brewery", cascade = CascadeType.ALL)
    private Set<Beer> beers;

    public Brewery(){}

    public Brewery(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Set<Beer> getBeers() {
        return beers;
    }

    public void setBeers(Set<Beer> beers) {
        this.beers = beers;
    }

}
