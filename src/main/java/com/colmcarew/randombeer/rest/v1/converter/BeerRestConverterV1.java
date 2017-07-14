package com.colmcarew.randombeer.rest.v1.converter;

import com.colmcarew.randombeer.data.BreweryRepository;
import com.colmcarew.randombeer.model.Beer;
import com.colmcarew.randombeer.model.Brewery;
import com.colmcarew.randombeer.rest.v1.model.RestBeerV1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by colmcarew on 13/07/2017.
 * The purpose of this class is to convert a Database Object of RestBeerV1 to a Rest Friendly (no db ids) RestBeerV1
 */
public class BeerRestConverterV1 {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    public BeerRestConverterV1() {
    }

    public RestBeerV1 obtainRestFriendlyBeer(Beer beer) {
        RestBeerV1 restBeer = new RestBeerV1(beer.getName(),
                beer.getDescription(),
                beer.getAlcoholPercentage(),
                beer.getBrewery().getLocation(),
                beer.getImageUrl());
        return restBeer;
    }

    public Beer saveOrFindBeerFromRestBeer(RestBeerV1 restBeerV1, BreweryRepository breweryRepository) {
        Brewery brewery = breweryRepository.findByLocation(restBeerV1.getBreweryLocation());
        Set<Beer> beers = new HashSet<>();
        Beer beer = null;
        // This method is probably too complex, should split it up
        if (brewery != null) {
            beers = brewery.getBeers();
            boolean beerExists = false;
            // This is not efficient, I would prefer if Beer pointed to Brewery rather than a bidirectional relationship as if there are many beers, it is a
            // bad idea to pass around Brewery who would have many DB Beer objects - it was done like this as this is my first attempt at a Spring Application
            for (Beer b : beers) {
                if (b.getName().equals(restBeerV1.getName())) {
                    logger.info("Beer with name : " + restBeerV1.getName() + " alreadt exists in " + restBeerV1.getBreweryLocation());
                    beerExists = true;
                }
            }
            if (!beerExists) {
                logger.info("Creating Beer with name : " + restBeerV1.getName() + " alreadt exists in " + restBeerV1.getBreweryLocation());
                beer = new Beer(restBeerV1.getName(), restBeerV1.getDescription(), restBeerV1.getAlcoholPercentage(), brewery, restBeerV1.getImageUrl());
                beers.add(beer);
            }
        } else {
            brewery = new Brewery(restBeerV1.getBreweryLocation(), restBeerV1.getBreweryLocation());
            beer = new Beer(restBeerV1.getName(), restBeerV1.getDescription(), restBeerV1.getAlcoholPercentage(), brewery, restBeerV1.getImageUrl());
            beers.add(beer);
            brewery.setBeers(beers);
        }
        brewery.setBeers(beers);
        breweryRepository.save(brewery);
        return beer;
    }
}
