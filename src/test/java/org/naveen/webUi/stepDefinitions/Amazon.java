package org.naveen.webUi.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Amazon {

    private WebDriver driver;
    private Wait<WebDriver> wt;

    public Amazon(){
        this.driver=Hooks.driver;
        this.wt=Hooks.wt;
    }

    @Given("User launches amazon page")
    public void launcAmazon() throws InterruptedException{
        driver.get("https://www.amazon.in/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
        Thread.sleep(7000);
    }
    @When("User clicks all menuitem")
    public void clickAll(){
        driver.findElement(By.className("hm-icon-label")).click();
    }
    @Then("User clicks on Alex")
    public void clicksAlexa(){
        Actions acts=new Actions(driver);
        wt.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='hmenu-item']/*[contains(text(),'Echo & Alexa')]/parent::a")));
       WebElement elt= driver.findElement(By.xpath("//*[@class='hmenu-item']/*[contains(text(),'Echo & Alexa')]/parent::a"));
       acts.moveToElement(elt).perform();
       acts.click().perform();

    }
    @And("User clicks on Meet Alexa")
    public void clickMeetAlexa(){
        Actions acts=new Actions(driver);
        wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Meet Alexa')]")));
        WebElement elt= driver.findElement(By.xpath("//*[@class='category-section']/*[@class='hmenu-item']/*[contains(text(),'Meet Alexa')]"));
        acts.moveToElement(elt).perform();
        acts.click().perform();
    }
    @And("print the title")
    public void printURL(){
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
    }
}
