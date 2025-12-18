package org.naveen.webUi.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.naveen.webUi.pages.IbiboPage;
import org.openqa.selenium.WebElement;

import java.util.List;

public class IbiboStepDef {

        private IbiboPage ibibo;

        public IbiboStepDef(){
            this.ibibo=new IbiboPage(Hooks.driver);
        }

    @Given("User launches Ibibo page")
    public void launchIbiboPage(){
        ibibo.getIbiboPage();

    }
    @And("User closes popup1")
    public void closePopup1(){

            ibibo.closepopUp1().click();

    }
    @And("User closes popup2")
    public void closePopUp2(){

            ibibo.closepopUp2();

    }
    @When("User inputs text in from city input")
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
