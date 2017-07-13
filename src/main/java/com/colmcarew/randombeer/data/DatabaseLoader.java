package com.colmcarew.randombeer.data;

import com.colmcarew.randombeer.model.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by colmcarew on 13/07/2017.
 */
@Component
public class DatabaseLoader implements CommandLineRunner {

    private final BeerRepository repository;

    @Autowired
    public DatabaseLoader(BeerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.repository.save(new Beer("Hop House 13", "Anything", 5.1d));
        this.repository.save(new Beer("Metalman", "something else", 8.3d));
        this.repository.save(new Beer("Laginitos", "great", 12.2d));
    }
}
