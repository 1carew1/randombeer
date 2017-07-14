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
 * This is the class used for Bootstraping the Beer and Brewery Data
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
        Brewery boojum = new Brewery("BooJum", "Boojum Brewery (Production Facility), 357 Dayton Dr, Waynesville, NC 28786, USA");
        Beer paleAle = new Beer("Pale Ale", "Deliciously crisp & balanced with a strong hop flavor and aroma", 5.6d, boojum, "https://static1.squarespace.com/static/543af9bbe4b07b5d8ca951ff/t/5676b4b4a128e6372fa80a00/1450620090130/?format=500w");
        Beer blueberry = new Beer("Blueberry Coffee Porter", "Our smooth and roasty brown porter with cold brewed coffee and a subtle touch of blueberry", 5.0d, boojum, "https://static1.squarespace.com/static/543af9bbe4b07b5d8ca951ff/t/5676b906e0327c06bcd124c7/1450621194828/?format=500w");
        Beer belgian = new Beer("Belgian Tripel", "Strong, golden ale marked with complex & distinctive fruit & spice characteristics produced by the Belgian Trappist yeast. ", 9.0d, boojum, "http://static1.squarespace.com/static/543af9bbe4b07b5d8ca951ff/t/543afa65e4b0bb6f0dc59bf5/1497636754490/?format=1500w");
        Beer king = new Beer("King of the Mountain Double IPA", "Big, citrusy, hoppy West Coast Style Double bursting with hop flavor & aroma", 8.0d, boojum, "https://static.shoplightspeed.com/shops/609604/files/003032975/boojum-king-of-the-mountain-double-ipa-16oz-sgl-ca.jpg");
        Set boojumBeer = new HashSet<Beer>() {{
            add(paleAle);
            add(blueberry);
            add(belgian);
            add(king);
        }};
        boojum.setBeers(boojumBeer);
        repository.save(boojum);


        Brewery ocean = new Brewery("Ocean City", "Ocean City Brewing Company, 11706 Reisterstown Rd, Reisterstown, MD 21136, USA");
        Beer twisted = new Beer("Twisted Root", "Twisted Root is our non-alcoholic root beer made with real sugar cane.  Twisted Root is also used to make our killer Root Beer Float!", 0d, ocean, "http://4.bp.blogspot.com/-e8IrlQn2uxY/VVQX0qb3HJI/AAAAAAAAEWg/LTTKXzOi-XI/s1600/99BB46A7-C793-4299-938C-C17A6F5CBD5E.jpeg");
        Beer ogre = new Beer(" Ogre - Blood Orange I.P.A.", "Ogre is a smooth India Pale Ale made with a variety of hops.  It has a sweet citrusy taste with a mild finish.  Be aware or the Ogre will smash you!", 6.5d, ocean, "https://cdn.shopify.com/s/files/1/0390/4021/files/OGRE_medium.jpg?11189361851367943521");
        Set oceanBeer = new HashSet<Beer>() {{
            add(twisted);
            add(ogre);
        }};
        ocean.setBeers(oceanBeer);
        repository.save(ocean);

        Brewery moes = new Brewery("Moe's", "Moe's Tavern Springfield");
        // Should use default URL
        Beer duff = new Beer("Duff", "Pours copper amber with a massive thick nitro white head. Light toasted malt aroma light sweet maltay ambe Ale. Notes: on tap at Moe’s Tavern, Universal Studios Hollywood, June ’17", 5.1d, moes);
        Beer flamingMoe = new Beer("Flaming Moe", "On The Simpsons, Homer Simpson accidentally creates the Flaming Moe by emptying out his liquor cabinet and adding a vital dose of grape children’s cough syrup. The resulting popular flaming drink made Moe’s a brief hotspot.", 10.0d, moes, "https://vignette4.wikia.nocookie.net/simpsons/images/8/84/Flaming_Moe%27s.jpg/revision/latest?cb=20131212223337&path-prefix=pt");
        Set moesBeer = new HashSet<Beer>(){{
           add(duff);
           add(flamingMoe);
        }};
        moes.setBeers(moesBeer);
        repository.save(moes);

    }
}
