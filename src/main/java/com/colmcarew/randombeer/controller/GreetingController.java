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
import com.colmcarew.randombeer.rest.converter.BeerRestConverter;
import com.colmcarew.randombeer.rest.model.RestBeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    private BreweryRepository repository;


    @GetMapping("/greeting")
    public RestBeer greeting(@RequestParam(value="name", defaultValue="World") String name) {
        List<Brewery> breweryList = repository.findAll();
        int randBreweryIndex = obtainRandomIndex(breweryList.size());
        Brewery brewery = breweryList.get(randBreweryIndex);
        List<Beer> beers = new ArrayList<>();
        beers.addAll(brewery.getBeers());
        int randBeerIndex = obtainRandomIndex(beers.size());
        Beer beer = beers.get(randBeerIndex);
        BeerRestConverter beerRestConverter = new BeerRestConverter(beer);
        RestBeer restBeer = beerRestConverter.obtainRestFriendlyBeer();
        return restBeer;
    }

    private int obtainRandomIndex(int size) {
        Random random = new Random();
        return random.nextInt(size);
    }
}