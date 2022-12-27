package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserAssertionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        response = given()
                .when()
                .queryParam("page", "1")
                .queryParam("per_page", "20")
                .get("/users")
                .then().statusCode(200);
    }

    // 1. Verify the if the total record is 20
    @Test
    public void test001() {
        response.body("total.size", equalTo(20));
    }

    // 2. Verify the if the name of id = 5344 is equal to ”Amish Mehrotra I”5487
    @Test
    public void test002() {
        response.body("[4].name", equalTo("Subodh Menon"));
    }

    //3.Check the single ‘Name’ in the Array list (Subhashini Talwar)
    @Test
    public void test003() {
        response.body("[5].name", equalTo("Ganesh Kaniyar"));
    }

    //4. Check the multiple ‘Names’ in the ArrayList (Mrs. Menaka Bharadwaj, Msgr. Bodhan Guha, Karthik Dubashi IV)
    @Test
    public void test004() {
        response.body("name", hasItems("Ganesh Kaniyar", "Raj Patil", "Trilochan Gupta"));
    }

    //5.Verify the email of userid = 5471 is equal “adiga_aanjaneya_rep@jast.org”
    @Test
    public void test005() {
        response.body("[1].email", equalTo("bhattathiri_aashritha@gulgowski.com"));
    }

    //6.Verify the status is “Active” of user name is “Shanti Bhat V”
    @Test
    public void test006() {
        response.body("[2].status", equalTo("active"));
    }

    // 7. Verify the Gender = male of user name is “Niro Prajapa
    @Test
    public void test007() {
        response.body("[2].gender", equalTo("male"));
    }


}
