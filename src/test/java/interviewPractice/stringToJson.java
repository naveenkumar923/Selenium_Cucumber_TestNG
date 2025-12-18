package interviewPractice;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.openqa.selenium.json.Json;
import org.testng.annotations.Test;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.*;

import static io.restassured.RestAssured.given;

public class stringToJson {

    @Test
    public void stringToJson(){
        String resp="{\"page\":1,\"per_page\":10,\"total\":1951,\"total_pages\":196,\"data\":[{\"competition\":\"UEFA Champions League\",\"year\":2011,\"round\":\"GroupH\",\"team1\":\"Barcelona\",\"team2\":\"AC Milan\",\"team1goals\":\"2\",\"team2goals\":\"2\"},{\"competition\":\"UEFA Champions League\",\"year\":2011,\"round\":\"GroupG\",\"team1\":\"APOEL Nikosia\",\"team2\":\"Zenit St. Petersburg\",\"team1goals\":\"2\",\"team2goals\":\"1\"},{\"competition\":\"UEFA Champions League\",\"year\":2011,\"round\":\"GroupF\",\"team1\":\"Borussia Dortmund\",\"team2\":\"Arsenal\",\"team1goals\":\"1\",\"team2goals\":\"1\"},{\"competition\":\"UEFA Champions League\",\"year\":2011,\"round\":\"GroupH\",\"team1\":\"Viktoria Plzen\",\"team2\":\"BATE Borisov\",\"team1goals\":\"1\",\"team2goals\":\"1\"},{\"competition\":\"UEFA Champions League\",\"year\":2011,\"round\":\"GroupE\",\"team1\":\"Chelsea\",\"team2\":\"Bayer Leverkusen\",\"team1goals\":\"2\",\"team2goals\":\"0\"},{\"competition\":\"UEFA Champions League\",\"year\":2011,\"round\":\"GroupG\",\"team1\":\"FC Porto\",\"team2\":\"Shakhtar Donetsk\",\"team1goals\":\"2\",\"team2goals\":\"1\"},{\"competition\":\"UEFA Champions League\",\"year\":2011,\"round\":\"GroupE\",\"team1\":\"KRC Genk\",\"team2\":\"Valencia CF\",\"team1goals\":\"0\",\"team2goals\":\"0\"},{\"competition\":\"UEFA Champions League\",\"year\":2011,\"round\":\"GroupF\",\"team1\":\"Olympiacos\",\"team2\":\"Olympique Marseille\",\"team1goals\":\"0\",\"team2goals\":\"1\"},{\"competition\":\"UEFA Champions League\",\"year\":2011,\"round\":\"GroupD\",\"team1\":\"AFC Ajax\",\"team2\":\"Olympique Lyon\",\"team1goals\":\"0\",\"team2goals\":\"0\"},{\"competition\":\"UEFA Champions League\",\"year\":2011,\"round\":\"GroupC\",\"team1\":\"Basel\",\"team2\":\"Otelul Galati\",\"team1goals\":\"2\",\"team2goals\":\"1\"}]}";

        JsonPath jsonPath=new JsonPath(resp);
        System.out.println(jsonPath.getInt("per_page"));
        jsonPath.getJsonObject("data");
    }


    @Test
    public void stringRep(){
       Response response=given().baseUri("https://practice-automation.com/broken-links/missing-page.html")
               .when().get();
    }

    public static void main(String[] args) {
        String resp="{\"page\":1,\"per_page\":10,\"total\":1951,\"total_pages\":196,\"data\":[{\"competition\":\"UEFA Champions League\",\"year\":2011,\"round\":\"GroupH\",\"team1\":\"Barcelona\",\"team2\":\"AC Milan\",\"team1goals\":\"2\",\"team2goals\":\"2\"},{\"competition\":\"UEFA Champions League\",\"year\":2011,\"round\":\"GroupG\",\"team1\":\"APOEL Nikosia\",\"team2\":\"Zenit St. Petersburg\",\"team1goals\":\"2\",\"team2goals\":\"1\"},{\"competition\":\"UEFA Champions League\",\"year\":2011,\"round\":\"GroupF\",\"team1\":\"Borussia Dortmund\",\"team2\":\"Arsenal\",\"team1goals\":\"1\",\"team2goals\":\"1\"},{\"competition\":\"UEFA Champions League\",\"year\":2011,\"round\":\"GroupH\",\"team1\":\"Viktoria Plzen\",\"team2\":\"BATE Borisov\",\"team1goals\":\"1\",\"team2goals\":\"1\"},{\"competition\":\"UEFA Champions League\",\"year\":2011,\"round\":\"GroupE\",\"team1\":\"Chelsea\",\"team2\":\"Bayer Leverkusen\",\"team1goals\":\"2\",\"team2goals\":\"0\"},{\"competition\":\"UEFA Champions League\",\"year\":2011,\"round\":\"GroupG\",\"team1\":\"FC Porto\",\"team2\":\"Shakhtar Donetsk\",\"team1goals\":\"2\",\"team2goals\":\"1\"},{\"competition\":\"UEFA Champions League\",\"year\":2011,\"round\":\"GroupE\",\"team1\":\"KRC Genk\",\"team2\":\"Valencia CF\",\"team1goals\":\"0\",\"team2goals\":\"0\"},{\"competition\":\"UEFA Champions League\",\"year\":2011,\"round\":\"GroupF\",\"team1\":\"Olympiacos\",\"team2\":\"Olympique Marseille\",\"team1goals\":\"0\",\"team2goals\":\"1\"},{\"competition\":\"UEFA Champions League\",\"year\":2011,\"round\":\"GroupD\",\"team1\":\"AFC Ajax\",\"team2\":\"Olympique Lyon\",\"team1goals\":\"0\",\"team2goals\":\"0\"},{\"competition\":\"UEFA Champions League\",\"year\":2011,\"round\":\"GroupC\",\"team1\":\"Basel\",\"team2\":\"Otelul Galati\",\"team1goals\":\"2\",\"team2goals\":\"1\"}]}";


        JsonPath jsonPath=new JsonPath(resp);
        JsonArray jsonArray = new JsonArray();
//        jsonArray.add();
      List<Map<String,Object>> lists=jsonPath.getList("data");
      List<Map<String,Object>> barcelonaMatches=new ArrayList<>();
        Set<String> indTeam=new HashSet<>();
//        System.out.println(lists.get(0).get("team1"));
        for(Map<String,Object> match:lists){
            String team1=match.get("team1").toString();
            String team2=match.get("team2").toString();

            if(team1.equalsIgnoreCase("barcelona")|| team2.equalsIgnoreCase("barcelona")){
               barcelonaMatches.add(match);
            }
        }
        for(Map<String,Object> match:lists){
            String team1=match.get("team1").toString();
            String team2=match.get("team2").toString();

            indTeam.add(team1);
            indTeam.add(team2);
        }

        for(String match:indTeam){
            System.out.println(match);
        }

    }
}
