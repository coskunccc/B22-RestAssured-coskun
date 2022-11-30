package com.cydeo.Day1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class SimpleGetRequest {

    String url="http://34.227.152.208:8000/api/spartans";
    @Test
    public void test1(){
        //send request and save response in Response object
      Response response= RestAssured.get(url);

      //print status code
        System.out.println(response.statusCode());

        // print response body
        response.prettyPrint();

    }
}
