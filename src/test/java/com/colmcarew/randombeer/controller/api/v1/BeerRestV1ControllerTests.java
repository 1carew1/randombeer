package com.colmcarew.randombeer.controller.api.v1;

import com.jayway.restassured.http.ContentType;
import org.hamcrest.Matchers;
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
public class BeerRestV1ControllerTests {

    @LocalServerPort
    private int port;

    @Test
    public void testObtainingRandomBeer() {
        given()
                .port(port)
                .when()
                .get("/api/v1/beer")
                .then()
                .contentType(ContentType.JSON);
    }

    @Test
    public void testCreatingABeer() {
        String json = "{\"name\":\"Colms Beer 3\",\"description\":\"Doesnt Exists\",\"alcoholPercentage\":2.0,\"breweryLocation\":\"Waterford\",\"imageUrl\":\"https://dc8gwjuur0w0x.cloudfront.net/lists/avatars/000/000/047/original_o-PINT-GLASS-BEER-facebook.jpg?1473216955\"}";
        given()
                .port(port)
                .body(json)
                .when()
                .post("/api/v1/beer")
                .then()
                .contentType(ContentType.JSON)
                .body("name", Matchers.equalTo("Colms Beer 3"));
        // Test when it already exits
        given()
                .port(port)
                .body(json)
                .when()
                .post("/api/v1/beer")
                .then()
                .contentType(ContentType.JSON)
                .body("name", Matchers.nullValue());
    }
}
