package com.colmcarew.randombeer.controller;

/**
 * Created by colmcarew on 13/07/2017.
 */
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.colmcarew.randombeer.data.BeerRepository;
import com.colmcarew.randombeer.model.Beer;
import com.colmcarew.randombeer.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    private BeerRepository repository;


    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        List<Beer> beerList = repository.findAll();
        for(Beer b : beerList) {
            System.out.println(b.getName());
        }
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}