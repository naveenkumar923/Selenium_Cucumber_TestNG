package org.naveen.api;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tools.jackson.core.JsonParser;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class APIAutomation {

    @BeforeTest
    public void setUp(){
        baseURI="https://gorest.co.in/public/v2";
    }

    @Test
    public void getTest(){

        Response resp2= given().baseUri("https://gorest.co.in/public/v2/")
                .when()
                .get("users").then().extract().response();

       String resp= resp2.asString();
//                .get("users/8208148");
        ObjectMapper objectMapper=new ObjectMapper();
        List<ResponseUser> users=objectMapper.readValue(resp, new TypeReference<List<ResponseUser>>() {});
//        List<ResponseUser> resp3= resp2.
//        System.out.println(users.size());
        List<Integer> ids=new ArrayList<>() ;
        Map<Integer,String> pInfo=new HashMap<>();
        for(ResponseUser user:users){
           ids.add(user.getId());
           pInfo.put(user.getId(),user.getName());
        }
        Set<Map.Entry<Integer,String>> entrySet=pInfo.entrySet();

        for(Map.Entry<Integer,String> id:entrySet){
            System.out.println(id.getKey()+"\t"+id.getValue());

        }
//                System.out.println(resp2.body().as(ResponseUser.class));

    }

    @Test
    public void getSpecificUser(){
        int i=8208145;
      var resp=   given().baseUri("https://gorest.co.in/public/v2/")
                .pathParams("userId",i)
                .when()
                .get("users/{userId}")
                .getBody().asString()
              ;

        var resp2=   given().baseUri("https://gorest.co.in/public/v2/")
                .pathParams("userId",i)
                .when()
                .get("users/{userId}")
                .getBody().asString();
                ;

        ObjectMapper mapper = new ObjectMapper();
        Gson gson=new Gson();

       ResponseUser result=mapper.readValue( resp,ResponseUser.class);
       mapper.writeValueAsString("");
       System.out.println(result.getEmail());

       ResponseUser result2=gson.fromJson(resp2.toString(),ResponseUser.class);


        System.out.println(result2.getEmail());
    }

    @Test
    public void postTest(){

        Faker fr=new Faker();
        String name=fr.name().firstName()+" "+fr.name().lastName();
        String email=fr.bothify(name+"##@????????.net");
        System.out.println(email);
        String string = """
                { "name": 
                """;
        String requestBody= """
                 { "name": "+name+",
                    "email": "+email+",
                    "gender": "male",
                    "status": "inactive"
                    }
                """;

//        given().header("Authorization","Bearer 9527aded9787305aaa0a4d63175cc24ebf16d11653825d42bffc184edffa5c37")
//                .contentType("application/json")
//                .body(requestBody)
//                .when()
//                .post("/users")
//                .then()
//                .log().body()
//                .statusCode(201)
//                .body("gender",equalTo("male"));

//            given().post("/public/v2/users").req

    }

    @Test
    public void createuserMap(){
        Map<String, String> requestBody=new HashMap<>();
        Faker fr=new Faker();

        String fName=fr.name().firstName();
        String lName=fr.name().lastName();
        String name=fName+" "+lName;
        String email=fr.bothify(fName+"_"+lName+"##@????????.net");
        requestBody.put("name",name);
        requestBody.put("email",email);
        requestBody.put("gender","Male");
        requestBody.put("status","active");
//        System .out.println(requestBody);

        given().header("Authorization","Bearer 9527aded9787305aaa0a4d63175cc24ebf16d11653825d42bffc184edffa5c37")
                .contentType("application/json")
        .body(requestBody)
                .when().post("/users")
                .then().log().body();

    }

    @Test
    public void createPojoUserTest(){
        User inputUser=new User();
        Faker fr=new Faker();
        String fName=fr.name().firstName();
        String lName=fr.name().lastName();
        String name=fName+" "+lName;
        String email=fr.bothify(fName+"_"+lName+"##@????????.net");
        inputUser.setName(name);
        inputUser.setEmail(email);
        inputUser.setGender("Male");
        inputUser.setStatus("active");


        given().header("Authorization","Bearer 9527aded9787305aaa0a4d63175cc24ebf16d11653825d42bffc184edffa5c37")
                .contentType("application/json")
                .body(inputUser)
                .when().post("/users")
                .then().log().body();
    }

    @Test
    public void createFileUserTest() throws IOException {
        String request= FileUtils.readFileToString(new File("src/test/resources/api_resources/UserRequest.json"), Charsets.UTF_8);
        given().header("Authorization","Bearer 9527aded9787305aaa0a4d63175cc24ebf16d11653825d42bffc184edffa5c37")
                .contentType("application/json")
                .body(request)
                .when().post("/users")
                .then().log().body()
                .and().body("email",equalTo("Darwin_Stroman91@dfea.net"));
    }

    @Test
    public void hackerRank(){
        var matches=given().baseUri("https://jsonmock.hackerrank.com/api/football_matches?year=2012&page=20")
                .get().getBody()
                .jsonPath();


        System.out.println(matches.getString("total"));
    }
}
