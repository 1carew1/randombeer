package com.colmcarew.randombeer.rest.converter;

import com.colmcarew.randombeer.data.BreweryRepository;
import com.colmcarew.randombeer.model.Beer;
import com.colmcarew.randombeer.model.Brewery;
import com.colmcarew.randombeer.rest.v1.converter.BeerRestConverterV1;
import com.colmcarew.randombeer.rest.v1.model.RestBeerV1;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    BreweryRepository breweryRepository;

    @Test
    public void ensureConversionWorksForIdealScenario(){
        Brewery brewery = new Brewery("name", "loc");
        Beer beer = new Beer("name", "desc", 1.1d, brewery);
        BeerRestConverterV1 restConverterV1 = new BeerRestConverterV1();
        RestBeerV1 restBeerV1 = restConverterV1.obtainRestFriendlyBeer(beer);
        assert restBeerV1.getName().equals("name");
        assert restBeerV1.getAlcoholPercentage().equals(1.1d);
        assert restBeerV1.getBreweryLocation().equals("loc");
        assert restBeerV1.getDescription().equals("desc");
    }

    @Test
    public void testCreatingNewBeers(){
        BeerRestConverterV1 restConverterV1 = new BeerRestConverterV1();
        String json = "{\"name\":\"Colms Beer 1\",\"description\":\"Exist\",\"alcoholPercentage\":2.0,\"breweryLocation\":\"Waterford\",\"imageUrl\":\"https://dc8gwjuur0w0x.cloudfront.net/lists/avatars/000/000/047/original_o-PINT-GLASS-BEER-facebook.jpg?1473216955\"}";
        Gson gson = new Gson();
        // Create the beer
        RestBeerV1 restBeer1 = gson.fromJson(json, RestBeerV1.class);
        Beer beer = restConverterV1.saveOrFindBeerFromRestBeer(restBeer1, breweryRepository);
        assert beer.getName().equals("Colms Beer 1");
        assert beer.getDescription().equals("Exist");


        // Create the Beer Again - should fail
        Beer beer2 = restConverterV1.saveOrFindBeerFromRestBeer(restBeer1, breweryRepository);
        assert  beer2 == null;

        //Create a beer in same brewery with different Name
        String json2 = "{\"name\":\"Colms Beer 3\",\"description\":\"Exist\",\"alcoholPercentage\":2.0,\"breweryLocation\":\"Waterford\",\"imageUrl\":\"https://dc8gwjuur0w0x.cloudfront.net/lists/avatars/000/000/047/original_o-PINT-GLASS-BEER-facebook.jpg?1473216955\"}";
        RestBeerV1 restBeer3 = gson.fromJson(json2, RestBeerV1.class);
        Beer beer3 = restConverterV1.saveOrFindBeerFromRestBeer(restBeer3, breweryRepository);
        assert beer3.getName().equals("Colms Beer 3");
    }
}
