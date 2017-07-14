package com.colmcarew.randombeer.controller;

import com.jayway.restassured.http.ContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by colmcarew on 14/07/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomeControllerTests {

    @LocalServerPort
    private int port;

    @Test
    public void testObtainingRandomBeer() {
        given().port(port).when().get("/").then().assertThat().contentType(ContentType.HTML);
    }
}
