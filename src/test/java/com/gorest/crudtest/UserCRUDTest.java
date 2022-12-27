package com.gorest.crudtest;

import com.gorest.model.PostsPojo;
import com.gorest.model.UserPojo;
import com.gorest.testbase.BaseTest;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UserCRUDTest extends BaseTest {


    @Test
    public void verifyUserCreatedSuccessfully(){
        List<String> userList = new ArrayList<>();
        userList.add("Selenium");
        userList.add("API");
        UserPojo userPojo=new UserPojo();
        userPojo.setId(1111);
        userPojo.setName("clair white");
        userPojo.setEmail("test123@gmail.com");
        userPojo.getGender("female");
        userPojo.setStatus("inactive");
        Response response=given().log().all()
                .headers("Content-Type","application/json")
                .when()
                .body(userPojo)
                .post();
        response.prettyPrint();
        response.then().log().all().statusCode(201);

    }

@Test
    public void verifyUserUpdateSuccessfully(){
    PostsPojo postsPojo=new PostsPojo();
    postsPojo.setId(2669);
    postsPojo.setUser_id(5240);
    postsPojo.setTitle("Via caveo coadunatio corrigo capio certus");
    postsPojo.setBody("Suffoco vesica sui. Cunabula colligo cum. Unde vix voveo. Stabilis concedo texo. " +
            "Vitiosus confugo vindico. Sollicito uter aut. Volubilis conculco quam. " +
            "Ciminatio sequi odit. Deinde deprimo architecto. Vulgo victus abscido. Atavus delego aspernatur. Avaritia tabernus animi. Amaritudo patrocinor capillus. Tribuo anser ater. Candidus suspendo alii. Quam sufficio colloco. Ambulo turbo aureus. " +
            "Speciosus vado triginta. Cuppedia strenuus vos. Tubineus in tunc.");

    Response response=given().log().all()
            .headers("Content-Type","application/json")
            .when()
            .body(postsPojo)
            .post();
    response.prettyPrint();
    response.then().log().all().statusCode(201);

    }




}
