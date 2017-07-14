package com.colmcarew.randombeer.controller.api.v1;

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
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class BeerRestV1Controller {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BreweryRepository repository;

    private final BeerRestConverterV1 beerRestConverter = new BeerRestConverterV1();


    @RequestMapping(value = "/beer", method = RequestMethod.GET)
    public RestBeerV1 obtainRandomBeer() {
        List<Brewery> breweryList = repository.findAll();
        int randBreweryIndex = obtainRandomIndex(breweryList.size());
        Brewery brewery = breweryList.get(randBreweryIndex);
        List<Beer> beers = new ArrayList<>();
        beers.addAll(brewery.getBeers());
        int randBeerIndex = obtainRandomIndex(beers.size());
        Beer beer = beers.get(randBeerIndex);
        RestBeerV1 restBeer = beerRestConverter.obtainRestFriendlyBeer(beer);
        return restBeer;
    }

    @RequestMapping(value = "/beer", method = RequestMethod.POST)
    public RestBeerV1 createBeer(@RequestBody String payload) {
        logger.debug("Post Payload : " + payload);
        Gson gson = new Gson();
        RestBeerV1 restBeerV1 = gson.fromJson(payload, RestBeerV1.class);
        Beer beer = beerRestConverter.saveOrFindBeerFromRestBeer(restBeerV1, repository);
        if (beer == null) {
            // If it fails to create return a blank rest beer
            restBeerV1 = new RestBeerV1();
        }
        return restBeerV1;
    }

    private int obtainRandomIndex(int size) {
        Random random = new Random();
        return random.nextInt(size);
    }
}