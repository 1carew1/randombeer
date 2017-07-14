package com.colmcarew.randombeer.rest.v1.converter;

import com.colmcarew.randombeer.model.Beer;
import com.colmcarew.randombeer.rest.v1.model.RestBeerV1;

/**
 * Created by colmcarew on 13/07/2017.
 * The purpose of this class is to convert a Database Object of RestBeerV1 to a Rest Friendly (no db ids) RestBeerV1
 */
public class BeerRestConverterV1 {

    private Beer beer;

    public BeerRestConverterV1(Beer beer) {
        this.beer = beer;
    }

    public RestBeerV1 obtainRestFriendlyBeer() {
        RestBeerV1 restBeer = new RestBeerV1(beer.getName(),
                beer.getDescription(),
                beer.getAlcoholPercentage(),
                beer.getBrewery().getLocation());
        return restBeer;
    }
}
