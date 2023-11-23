package com.testDay3;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CookiesDemo {
    @Test(priority = 1)
    public void testCookies(){
        given()
                .when()
                .get("https://www.google.com/")

                .then()
                .cookie("AEC","Ackid1SZPmGBKSjZ4Ouz7Mo_E1kHI3DunTDZoy3LCDmMWfppkLMxQO02Hg")
                .log().all()
                ;

    }
    @Test(priority = 2)
    public void getCookieInfo(){
        Response res = given()
                .when()
                .get("https://www.google.com/");

        // get single cookie
//       String cookie_value = res.getCookie("AEC");

       // get all cookies info
        Map<String,String> cookies_values = res.getCookies();
//        System.out.println(cookies_values.keySet());
        for (String k:cookies_values.keySet()) {
            String cookie_value =res.cookie(k);
            System.out.println(k+"        "+cookie_value);

        }
    }
}
