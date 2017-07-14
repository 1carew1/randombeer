package com.colmcarew.randombeer.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by colmcarew on 13/07/2017.
 */

@Entity
@Table(name = "brewery")
public class Brewery {
    private @Id
    @GeneratedValue
    Long id;
    private String name;
    private String location;
    @OneToMany(mappedBy = "brewery", cascade = CascadeType.ALL)
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
