package interviewPractice;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class restAssuredRequests {

    RequestSpecification req=given().baseUri("https://bookstore.toolsqa.com/");
    @Test
    public void getRequest(){
        Response response=req.when().
                queryParam("ue","980").get("BookStore/v1/Books")
                ;
        JsonPath jp=new JsonPath(response.body().asString());
        List<Map<String,Object>> lists=jp.getList("books");
        Map<String,Object> results=new HashMap<>();
        results= (Map<String, Object>) jp.getList("books").get(0);
//      System.out.println(jp.getList("books").get(0));
      System.out.println(results.get("isbn"));
      System.out.println(lists.get(0).get("isbn"));
    }

    public void postRequest(){
        Response response=req.contentType("application/json")
                .header("Authorization","Bearer: djkfajfda")
                .auth().oauth2("djf;jaa;j")
                .when().post();
    }

    public void putRequest(){
        Response response=req.contentType("")
                .header("auth","bearer")
                .when()
                .put("");
    }

    public void delete(){
        Response response=req.
                pathParam("abc","def")
                .when().delete();
    }
}
