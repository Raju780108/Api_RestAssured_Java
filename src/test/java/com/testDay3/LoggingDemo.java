package com.testDay3;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class LoggingDemo {
    @Test(priority = 1)
    public void testLogs(){
        given()
                .when()
                .get("https://www.google.com/")

                .then()
                .log().body()
                //.log().all()
        ;

    }

}
