package org.naveen.webUi.stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.naveen.webUi.pages.LoginPage;
import org.testng.Assert;

public class LoginPageStepDef {

        private LoginPage loginPage;
        private Hooks hks;
        public LoginPageStepDef(){

            this.loginPage=new LoginPage(Hooks.driver);
        }
    @Given("User launches the login page")
    public void launchURL(){
               loginPage.launchPage();

    }
    @Then("Login page should be displayed")
    public void checkPage(){

        Assert.assertEquals(loginPage.getTitle(),"Automation Exercise");
    }

    @Then("Home Link should be present")
    public void checkHomeLink(){

        Assert.assertTrue(loginPage.homeLinkPresent().isDisplayed());
    }
}
