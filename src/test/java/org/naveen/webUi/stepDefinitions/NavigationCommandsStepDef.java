package org.naveen.webUi.stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavigationCommandsStepDef {

    private WebDriver driver;
    private String goToURL="https://demoqa.com/";
    String url2="https://demoqa.com/browser-windows/";
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(25));

    public NavigationCommandsStepDef(){
        this.driver=Hooks.driver;
    }

    @Then("Click on Registration link")
    public void registrationLink(){
//        wait.until(ExpectedConditions.titleContains("Google"));
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
    }
    @Then("Come back to Home page")
    public void backArrow(){
        driver.navigate().back();
        System.out.println(driver.getTitle());
    }
    @Then("Go back to Registration page")
    public void forward(){
        driver.navigate().forward();
        System.out.println(driver.getTitle());
    }
    @Then("Come back to Home Page using URL")
    public void setGoToURL(){
        driver.navigate().to(goToURL);
        System.out.println(driver.getTitle());
    }

    @Then("Refresh the browser")
    public void refresh(){
        driver.navigate().refresh();
        System.out.println(driver.getTitle());
    }

}
