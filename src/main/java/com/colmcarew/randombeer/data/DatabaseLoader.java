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
        Brewery brewery = new Brewery("Test", "anywhere");
        Beer hopHouse = new Beer("Hop House 13", "Anything", 5.1d, brewery);
        Beer lag = new Beer("Laginitos", "great", 12.2d, brewery);
        Beer metal = new Beer("Metalman", "something else", 8.3d, brewery);
        Set beers = new HashSet<Beer>(){{
            add(hopHouse);
            add(lag);
            add(metal);
        }};
        brewery.setBeers(beers);
        repository.save(brewery);
    }
}
