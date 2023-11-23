package com.testDay4;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class ParsingJsonResponse {
    @Test(priority = 1)
    public void testJsonResponse(){
        given()
                .when()
                .get("https://www.google.com/")


        ;

    }

}
