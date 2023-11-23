package com.testDay1;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


/**
 * Given:
 *  -content type, set cookies,add auth,add param, set header info etc
 * When:
 *      - get,put,post,delete
 * Then:
 *      - validate status code, extract response, extract header cookies & response body
 */
public class HTTPrequests {
    int id;

    @Test(priority = 1)
    public void getUsers() {
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("page", equalTo(2))
                .log().all();

    }

    @Test(priority = 2)
    public void createUser() {
        HashMap data = new HashMap();
        data.put("name", "Raju");
        data.put("job", "SDET");


        id = given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("https://reqres.in/api/users")
                .jsonPath().getInt("id");
//                .then()
//                .statusCode(201)
//                .log().all();
    }

    @Test(priority = 3, dependsOnMethods = {"createUser"})
    public void updateUser() {
        HashMap data = new HashMap();
        data.put("name", "Raja");
        data.put("job", "QA");


        given()
                .contentType("application/json")
                .body(data)
                .when()
                .put("https://reqres.in/api/users/" + id)
                .then()
                .statusCode(200)
                .log().all();
    }
    @Test(priority = 4)
    public void deleteUser(){

        given()
                .when()
                .delete("https://reqres.in/api/users/"+id)

                .then()
                .statusCode(204)
                .log().all();

    }
}
