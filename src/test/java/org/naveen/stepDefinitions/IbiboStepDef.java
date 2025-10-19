package org.naveen.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.naveen.pages.IbiboPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;

public class IbiboStepDef {

        private IbiboPage ibibo;

        public IbiboStepDef(){
            this.ibibo=new IbiboPage(Hooks.driver);
        }

    @Given("user launches Ibibo page")
    public void launchIbiboPage(){
        ibibo.getIbiboPage();

    }
    @And("user closes popup1")
    public void closePopup1(){

            ibibo.closepopUp1().click();

    }
    @And("user closes popup2")
    public void closePopUp2(){

            ibibo.closepopUp2();

    }
    @When("user inputs text in from city input")
    public void inputText(){

            ibibo.getInputboxinput();
            ibibo.getEnterText();

    }
    @Then("print all the suggestions")
    public void printSuggestions(){
           List<WebElement> lst= ibibo.getSuggestions();
           for(WebElement elt : lst){
             if(elt.getText().contains("Chennai")){
                 System.out.println(elt.getText().substring(elt.getText().indexOf("C"),7));
             }
        }

    }
}
