package org.naveen.api;

import com.google.errorprone.annotations.Var;
import com.google.gson.Gson;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import io.restassured.module.jsv.JsonSchemaValidator.*;

import java.io.File;

public class APIAutomation2 {

    @BeforeTest
    public void setUp(){
        baseURI="https://gorest.co.in/public/v2";
    }

    @Test
    public void getUserTest(){
//        given().header("Authorization","Bearer 9527aded9787305aaa0a4d63175cc24ebf16d11653825d42bffc184edffa5c37")
//                .when()
//                .pathParam("userId",8195944).get("/users/{userId}").then().log().body();

//        Response resp=given().header("Authorization","Bearer 9527aded9787305aaa0a4d63175cc24ebf16d11653825d42bffc184edffa5c37")
//                .when()
//                .pathParam("userId",8196978).get("/users/{userId}");
//
//      String dddd=resp.getBody().asString();
//
//
////System.out.println(resp.getHeaders());
//        JsonPath jp=resp.getBody().jsonPath();
//        Gson gson=new Gson();
        File schema=new File("src/main/java/org/naveen/response-schema.json");

//        ResponseUser respUser=gson.fromJson(resp.getBody().asString(),ResponseUser.class);
//        System.out.println(jp.getInt("id"));
//        System.out.println(respUser.getEmail());

//        System.out.println(resp.then().assertThat().body(matchesJsonSchema(schema)).extract().asString());

   given().header("Authorization","Bearer 9527aded9787305aaa0a4d63175cc24ebf16d11653825d42bffc184edffa5c37")
                .when()
                .pathParam("userId",8196978).get("/users/{userId}")
                .then()
           .log().body()
//                .assertThat()
//                .body(matchesJsonSchema(schema))
                ;

//       System.out.println(result.then().assertThat().body(matchesJsonSchema(schema)));




    }
}
