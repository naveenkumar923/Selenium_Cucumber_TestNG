package org.naveen;

import com.google.gson.*;
import io.restassured.path.json.JsonPath;
import org.apache.http.HttpConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpClient;

public class APIConn {

public static void main(String[] args) throws IOException {
    URL url=new URL("https://gorest.co.in/public/v2/users");
    HttpURLConnection conn=(HttpURLConnection) url.openConnection();

    conn.setRequestMethod("GET");
    BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
    String input="";
    StringBuilder response= new StringBuilder();

    while ((input = br.readLine()) != null) {
        response.append(input);
    }
    br.close();
    String sResponse=response.toString();
    try{
//    JsonObject jsonObject = JsonParser.parseString(sResponse).getAsJsonObject();

//    System.out.println(response);
        Gson gson=new Gson();

        JsonArray convertedObject=gson.fromJson(sResponse,JsonArray.class);
        JsonObject job=null;
        for(int i=0;i<convertedObject.size();i++){
            job=convertedObject.get(i).getAsJsonObject();
            if(job.get("gender").getAsString().equalsIgnoreCase("male")){
                System.out.println(job.get("name")+"is a "+job.get("gender")+" and his email address is "+job.get("email"));
            }

        }


    } catch (JsonSyntaxException e) {
        System.out.println(e);
    }





}
}
