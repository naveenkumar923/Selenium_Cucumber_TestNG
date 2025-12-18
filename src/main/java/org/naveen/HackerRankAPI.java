package org.naveen;

import io.restassured.RestAssured;
import static  io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HackerRankAPI {

    public static void main(String[] args) {
        RestAssured.baseURI="https://jsonmock.hackerrank.com/api/football_matches";
        RequestSpecification requestSpecification = given().queryParam("year",2011);
        Response r=requestSpecification.when().get();
        JsonPath jp=r.getBody().jsonPath();
        System.out.println(jp.getInt("total"));
        System.out.println(r.getBody().asString());

    }
}
