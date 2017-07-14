package com.colmcarew.randombeer.model;

import com.colmcarew.randombeer.data.BreweryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by colmcarew on 14/07/2017.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class BreweryTests {
    @Autowired
    BreweryRepository breweryRepository;

    @Test
    public void testGetters(){
        Brewery brewery = new Brewery("name", "loc");
        Beer beer = new Beer("name", "decs", 1.1d, brewery);
        Set beers = new HashSet<Beer>(){{
            add(beer);
        }};
        brewery.setBeers(beers);
        breweryRepository.save(brewery);
        assert brewery.getId() > 0;
        assert brewery.getName().equals("name");
        assert  brewery.getBeers().size() == 1;
    }

}
