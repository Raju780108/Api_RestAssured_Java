package com.testDay3;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class HeaderDemo {
    @Test(priority = 1)
    public void testHeader(){
        given()
                .when()
                .get("https://www.google.com/")

                .then()
                .header("Content-Type","text/html; charset=ISO-8859-1")
                .header("Server","gws");

    }
    @Test(priority = 2)
    public void testHeaderSingle(){
        Response res =given()
                .when()
                .get("https://www.google.com/")
                ;
        // get single header
//String header_value = res.getHeader("Content-Type");
//        System.out.println(header_value);
         // get all headers
        Headers myheaders_values = res.getHeaders();
        for (Header hd:myheaders_values) {
            System.out.println(hd.getName()+"       "+hd.getValue());
        }
    }
}
