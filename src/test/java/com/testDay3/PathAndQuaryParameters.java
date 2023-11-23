package com.testDay3;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PathAndQuaryParameters {

    @Test
    public void testQueryAndPathParameter(){
        // https://reqres.in/api/users?page=2
        given()
                .pathParam("myPath","users")  //path parameter
                .queryParam("page",2)   //query parameter
                .queryParam("id",5)     //query parameter
                .when()
                .get("https://reqres.in/api/{myPath}")

                .then()
                .statusCode(200)
                .log().all()
                ;

    }
}
