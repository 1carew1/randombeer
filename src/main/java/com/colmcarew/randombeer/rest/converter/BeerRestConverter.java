package com.colmcarew.randombeer.rest.converter;

import com.colmcarew.randombeer.model.Beer;
import com.colmcarew.randombeer.rest.model.RestBeer;

/**
 * Created by colmcarew on 13/07/2017.
 * The purpose of this class is to convert a Database Object of RestBeer to a Rest Friendly (no db ids) RestBeer
 */
public class BeerRestConverter {

    private Beer beer;

    public BeerRestConverter(Beer beer) {
        this.beer = beer;
    }

    public RestBeer obtainRestFriendlyBeer() {
        RestBeer restBeer = new RestBeer(beer.getName(),
                beer.getDescription(),
                beer.getAlcoholPercentage(),
                beer.getBrewery().getLocation());
        return restBeer;
    }
}
