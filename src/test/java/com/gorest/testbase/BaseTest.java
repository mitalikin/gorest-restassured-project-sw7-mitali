package com.gorest.testbase;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;

import static io.restassured.RestAssured.given;

public class BaseTest {
    @BeforeClass
    public static void inIt() {

        RestAssured.baseURI = "https://gorest.co.in/public/v2";
      //RestAssured.port = 8080;
        RestAssured.basePath = "/users";
    }



}
