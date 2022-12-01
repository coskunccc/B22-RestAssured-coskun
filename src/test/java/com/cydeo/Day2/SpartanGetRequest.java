package com.cydeo.Day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SpartanGetRequest {
    String baseUrl = "http://34.227.152.208:8000";

    // Given Accept type application/json
    // When user send GET request to /api/spartans end point
    // Then status code must be 200
    // And response Content Type must be application/json
    // And response body should include spartan result

    @Test
    public void test1() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when()
                .get(baseUrl + "/api/spartans");

        System.out.println(response.statusCode());
        System.out.println(response.contentType());

        //response.prettyPrint();

        Assertions.assertEquals(response.contentType(),"application/json");
        Assertions.assertEquals(response.statusCode(),200);
    }

    @Test
    public void test2(){
        // Given Accept header is application/json
        // When user sends a GET request to /api/spartans/3
        // Then status code should be 200
        // And content type should be application/json
        // And json body should contain Fidole

        Response response=RestAssured.given().accept(ContentType.JSON)
                .when().get(baseUrl+"/api/spartans/3");

        Assertions.assertEquals(200,response.statusCode());
        Assertions.assertEquals("application/json",response.contentType());

        response.prettyPrint();
        Assertions.assertTrue(response.body().asString().contains("Fidole"));
    }

    @Test
    public void test3(){
        //Given no header provided
        //When user sends GET request to /api/hello
        //Then response status code should be 200
        //And header content type should be "text/plain;charset=UTF-8"
        //And header should contain date
        //And Content-Length should be 17
        //And body should be "Hello from Sparta"

        Response response=RestAssured.when().get(baseUrl+"/api/hello");
        response.prettyPrint();

        Assertions.assertEquals(200,response.statusCode());
        Assertions.assertEquals("text/plain;charset=UTF-8",response.contentType());
        Assertions.assertTrue(response.headers().hasHeaderWithName("date"));
        Assertions.assertEquals("17", response.header("Content-Length"));
        Assertions.assertEquals("Hello from Sparta", response.body().asString());


    }


}
