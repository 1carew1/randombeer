package com.colmcarew.randombeer.data;

import com.colmcarew.randombeer.model.Beer;
import com.colmcarew.randombeer.model.Brewery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by colmcarew on 13/07/2017.
 */
@Component
public class DatabaseLoader implements CommandLineRunner {

    private final BreweryRepository repository;

    @Autowired
    public DatabaseLoader(BreweryRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Brewery boojum = new Brewery("BooJum", "Boojum Brewery (Production Facility), 357 Dayton Dr, Waynesville, NC 28786, USA");
        Beer paleAle = new Beer("Pale Ale", "Deliciously crisp & balanced with a strong hop flavor and aroma", 5.6d, boojum);
        Beer blueberry = new Beer("Blueberry Coffee Porter", "Our smooth and roasty brown porter with cold brewed coffee and a subtle touch of blueberry", 5.0d, boojum);
        Beer belgian = new Beer("Belgian Tripel", "Strong, golden ale marked with complex & distinctive fruit & spice characteristics produced by the Belgian Trappist yeast. ", 9.0d, boojum);
        Beer king = new Beer("King of the Mountain Double IPA", "Big, citrusy, hoppy West Coast Style Double bursting with hop flavor & aroma", 8.0d, boojum);
        Set boojumBeer = new HashSet<Beer>() {{
            add(paleAle);
            add(blueberry);
            add(belgian);
            add(king);
        }};
        boojum.setBeers(boojumBeer);
        repository.save(boojum);


        Brewery ocean = new Brewery("Ocean City", "Ocean City Brewing Company, 11706 Reisterstown Rd, Reisterstown, MD 21136, USA");
        Beer twisted = new Beer("Twisted Root", "Twisted Root is our non-alcoholic root beer made with real sugar cane.  Twisted Root is also used to make our killer Root Beer Float!", 0d, ocean);
        Beer ogre = new Beer(" Ogre - Blood Orange I.P.A.", "Ogre is a smooth India Pale Ale made with a variety of hops.  It has a sweet citrusy taste with a mild finish.  Be aware or the Ogre will smash you!", 6.5d, ocean);
        Set oceanBeer = new HashSet<Beer>() {{
            add(twisted);
            add(ogre);
        }};
        ocean.setBeers(oceanBeer);
        repository.save(ocean);


    }
}
