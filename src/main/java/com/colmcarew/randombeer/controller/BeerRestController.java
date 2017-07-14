package com.colmcarew.randombeer.controller;

/**
 * Created by colmcarew on 13/07/2017.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.colmcarew.randombeer.data.BreweryRepository;
import com.colmcarew.randombeer.model.Beer;
import com.colmcarew.randombeer.model.Brewery;
import com.colmcarew.randombeer.rest.v1.converter.BeerRestConverterV1;
import com.colmcarew.randombeer.rest.v1.model.RestBeerV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeerRestController {

    @Autowired
    private BreweryRepository repository;


    @GetMapping("/greeting")
    public RestBeerV1 greeting(@RequestParam(value="name", defaultValue="World") String name) {
        List<Brewery> breweryList = repository.findAll();
        int randBreweryIndex = obtainRandomIndex(breweryList.size());
        Brewery brewery = breweryList.get(randBreweryIndex);
        List<Beer> beers = new ArrayList<>();
        beers.addAll(brewery.getBeers());
        int randBeerIndex = obtainRandomIndex(beers.size());
        Beer beer = beers.get(randBeerIndex);
        BeerRestConverterV1 beerRestConverter = new BeerRestConverterV1(beer);
        RestBeerV1 restBeer = beerRestConverter.obtainRestFriendlyBeer();
        return restBeer;
    }

    private int obtainRandomIndex(int size) {
        Random random = new Random();
        return random.nextInt(size);
    }
}