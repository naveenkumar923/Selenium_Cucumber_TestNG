package org.naveen.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PracticeExercise1 {

    private WebDriver driver;
    String url="https://demoqa.com/";
    String url2="https://demoqa.com/browser-windows/";
    private String pageTitle="",pageSource="";
    private int titleLength=0,pSL=0;
    private WebDriverWait wait;

    public PracticeExercise1(){
        this.driver=Hooks.driver;
    }

    @Given("Launch a new Chrome browser.")
    public void launchBrowser(){

    }
    @When("Open Shop.DemoQA.com")
    public void openPage(){
        driver.get(url);
    }
    @When("Open ToolsQA Practice Automation Page")
    public void launchPage(){
        driver.get(url2);
    }
    @Then("Get Page Title name and Title length")
    public void getPageTitleAndLength(){
       pageTitle= driver.getTitle();
       titleLength= driver.getTitle().length();
    }
    @And("Print Page Title and Title length on the Eclipse Console.")
    public void printPageTitleAndLength(){
        System.out.println("The Title of the Page is :"+pageTitle);
        System.out.println("The length of the Page Title is :"+titleLength);

    }
    @And("Get Page URL and verify if it is a correct page opened")
    public void checkPageUrl(){
        Assert.assertEquals(driver.getCurrentUrl(),url);

    }
    @And("Get Page Source and Page Source length")
    public void getPageSource(){
        pageSource=driver.getPageSource();
        pSL=pageSource.length();

    }
    @And("Print Page Length on Eclipse Console.")
    public void printPageLength(){
                System.out.println("Page length is :"+pSL);
    }
    @And("Close the Browser.")
    public void closeBrowser(){
        driver.close();
    }

    @Then("click on a New Browser Window button")
    public void clickElement(){
        wait=new WebDriverWait(driver, Duration.ofSeconds(25));

       wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("windowButton")));
       driver.findElement(By.id("windowButton")).click();
    }
}
