package com.colmcarew.randombeer.controller.api.v1;

import com.jayway.restassured.http.ContentType;
import com.yahoo.elide.core.HttpStatus;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;

/**
 * Created by colmcarew on 14/07/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BeerRestV1ControllerTests {

    @LocalServerPort
    private int port;

    @Test
    public void testObtainingRandomBeer() {
        given().port(port).when().get("/api/v1/beer").then().assertThat().contentType(ContentType.JSON);
    }
}
