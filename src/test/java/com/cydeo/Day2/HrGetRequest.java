package com.cydeo.Day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class HrGetRequest {
    //@BeforeAll is like @BeforeClass in testNG

    @BeforeAll
    public static void init() {
        baseURI = "http://34.227.152.208:1000/ords/hr";
    }

    @DisplayName("GET request to regions")
    @Test
    public void test1() {

        //Given Accept type is json
        //When user sends GET request to regions/2
        //Then response status codem must be 200
        //And body format is json
        //And response body contains Americas

        Response response = given().accept(ContentType.JSON)
                .when().get("/regions/2");

        // Response response=RestAssured.get("/regions/2"); also works

        response.prettyPrint();
        assertEquals(200, response.statusCode());
        assertEquals("application/json", response.contentType());
        assertTrue(response.body().asString().contains("Americas"));


    }

}
