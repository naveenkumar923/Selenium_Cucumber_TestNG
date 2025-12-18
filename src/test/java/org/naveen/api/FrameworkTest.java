package org.naveen.api;

import com.google.gson.Gson;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.TestData;
import restassured.APIUtil;

import java.util.HashMap;
import java.util.Map;

public class FrameworkTest {

    @Test
    public void getFrameworkTest(){
        Map<String,String> headerMap=new HashMap<>();
        Map<String,Integer> pathParamMap=new HashMap<>();
        pathParamMap.put("userId",8196978);
        headerMap.put("Authorization","Bearer 9527aded9787305aaa0a4d63175cc24ebf16d11653825d42bffc184edffa5c37");
        TestData testData = new TestData();
        testData.setBaseUri("https://gorest.co.in/public/v2");
        testData.setContentType("application/json");
        testData.setHeaders(headerMap);
        testData.setRequestPath("/users/{userId}");
        testData.setRequestMethod("Get");
        testData.setPathParam(pathParamMap);

        APIUtil rq=new APIUtil();
        Response rps=rq.executeApiRequest(testData);
//        System.out.println(rps.body().prettyPrint());
        Gson gson=new Gson();
        ResponseUser res=gson.fromJson(rps.getBody().asString(),ResponseUser.class);
        System.out.println(res.getEmail());
        System.out.println(res.getGender());
        Assert.assertEquals(res.getId(),8196978);


    }
}
