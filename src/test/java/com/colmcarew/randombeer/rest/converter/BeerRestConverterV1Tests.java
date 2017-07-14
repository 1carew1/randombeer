package com.colmcarew.randombeer.rest.converter;

import com.colmcarew.randombeer.model.Beer;
import com.colmcarew.randombeer.model.Brewery;
import com.colmcarew.randombeer.rest.v1.converter.BeerRestConverterV1;
import com.colmcarew.randombeer.rest.v1.model.RestBeerV1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by colmcarew on 14/07/2017.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class BeerRestConverterV1Tests {

    @Test
    public void ensureConversionWorksForIdealScenario(){
        Brewery brewery = new Brewery("name", "loc");
        Beer beer = new Beer("name", "desc", 1.1d, brewery);
        BeerRestConverterV1 restConverterV1 = new BeerRestConverterV1(beer);
        RestBeerV1 restBeerV1 = restConverterV1.obtainRestFriendlyBeer();
        assert restBeerV1.getName().equals("name");
        assert restBeerV1.getAlcoholPercentage().equals(1.1d);
        assert restBeerV1.getBreweryLocation().equals("loc");
        assert restBeerV1.getDescription().equals("desc");
    }
}
