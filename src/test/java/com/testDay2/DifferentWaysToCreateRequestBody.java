package com.testDay2;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DifferentWaysToCreateRequestBody {
//    //1. post request body using hashmap
//    @Test(priority = 1)
//    public void testPostRequestUsingHashmap(){
//        HashMap data = new HashMap();
//        data.put("name","Raju");
//        data.put("location","AP");
//        data.put("phone","12345");
//
//        String coursesArr[] ={"java","python"};
//        data.put("courses",coursesArr);
//
//         given()
//                .contentType("application/json")
//                .body(data)
//                .when()
//                .post("http://localhost:3000/students")
//                .then()
//                .statusCode(201)
//                .body("name",equalTo("Raju"))
//                .body("location",equalTo("AP"))
//                .body("phone",equalTo("12345"))
//                .body("courses[0]",equalTo("java"))
//                .body("courses[1]",equalTo("python"))
//                .header("content-type","application/json; charset=utf-8")
//        ;
//
//    }
//
//    @Test(priority = 2)
//    public void deletestudent(){
//        given()
//                .when()
//                .delete("http://localhost:3000/students/7")
//                .then()
//                .statusCode(200)
//                .log().all()
//                ;
//    }
//2. post request body using org.json
//@Test(priority = 1)
//public void testPostRequestUsigOrgJson(){
//    JSONObject data = new JSONObject();
//    data.put("name","Raju");
//    data.put("location","AP");
//    data.put("phone","12345");
//
//    String coursesArr[] ={"java","python"};
//    data.put("courses",coursesArr);
//
//    given()
//            .contentType("application/json")
//            .body(data.toString())
//            .when()
//            .post("http://localhost:3000/students")
//            .then()
//            .statusCode(201)
//            .body("name",equalTo("Raju"))
//            .body("location",equalTo("AP"))
//            .body("phone",equalTo("12345"))
//            .body("courses[0]",equalTo("java"))
//            .body("courses[1]",equalTo("python"))
//            .header("content-type","application/json; charset=utf-8")
//    ;
//
//}
//
//    @Test(priority = 2)
//    public void deletestudent(){
//        given()
//                .when()
//                .delete("http://localhost:3000/students/7")
//                .then()
//                .statusCode(200)
//                .log().all()
//        ;
//    }

//    //3. post request body using POJO class
//    @Test(priority = 1)
//public void testPostRequestUsigOrgJson(){
//    Pojo_PostRequest data = new Pojo_PostRequest();
//    data.setName("Raju");
//    data.setLocation("AP");
//    data.setPhone("12345");
//
//    String[] coursesArr ={"java","python"};
//    data.setCourses(coursesArr);
//
//    given()
//            .contentType("application/json")
//            .body(data)
//            .when()
//            .post("http://localhost:3000/students")
//            .then()
//            .statusCode(201)
//            .body("name",equalTo("Raju"))
//            .body("location",equalTo("AP"))
//            .body("phone",equalTo("12345"))
//            .body("courses[0]",equalTo("java"))
//            .body("courses[1]",equalTo("python"))
//            .header("content-type","application/json; charset=utf-8")
//    ;
//
//}
//3. post request body using external json file
@Test(priority = 1)
public void testPostRequestUsigExternalJsonFile() throws FileNotFoundException {
    File file = new File("C:\\Users\\DELL\\IdeaProjects\\ApiRestAssuredProject\\src\\test\\java\\com\\testDay2\\body.json");
        FileReader fileReader = new FileReader(file);
        JSONTokener jsonTokener = new JSONTokener(fileReader);
        JSONObject data = new JSONObject(jsonTokener);

    given()
            .contentType("application/json")
            .body(data.toString())
            .when()
            .post("http://localhost:3000/students")
            .then()
            .statusCode(201)
            .body("name",equalTo("Raju"))
            .body("location",equalTo("AP"))
            .body("phone",equalTo("12345"))
            .body("courses[0]",equalTo("java"))
            .body("courses[1]",equalTo("python"))
            .header("content-type","application/json; charset=utf-8")
    ;

}

    @Test(priority = 2)
    public void deletestudent(){
        given()
                .when()
                .delete("http://localhost:3000/students/17")
                .then()
                .statusCode(200)
                .log().all()
        ;
    }


}
