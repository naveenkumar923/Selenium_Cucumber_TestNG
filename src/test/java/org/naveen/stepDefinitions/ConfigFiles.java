package org.naveen.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFiles {

    static Properties properties=new Properties();

    public ConfigFiles(){
        this.properties=Hooks.properties;
    }
    @Given("testing to be done using config files")
    public void nothing(){

    }
   @Then("print config file contents {string} and {string}")
    public void print(String s, String m) throws IOException {
//       File file = new File("src/test/resources/config.txt");
//       FileInputStream iFile=new FileInputStream(file);
//       Properties properties= new Properties();
//       properties.load(iFile);

       System.out.println(properties.getProperty(s).toString());
       System.out.println(properties.getProperty(m).toString());
   }

}
