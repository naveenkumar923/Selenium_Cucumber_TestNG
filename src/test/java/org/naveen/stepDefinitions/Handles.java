package org.naveen.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;

import javax.imageio.ImageTranscoder;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Handles {

    private WebDriver driver;
    private Wait<WebDriver> wt;
    private String cHandle="";
    private Set<String> allWindowHandles;
    private String nxt="";
    Iterator<String> itr;
    public Handles(){
        this.driver=Hooks.driver;
        this.wt=Hooks.wt;
    }

    @Given("a page is open")
    public void openHerokuPage(){
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
        cHandle=driver.getWindowHandle();

    }
    @When("User opens a new tab")
    public void openNewPage() throws AWTException {


//        driver.findElement(By.tagName("body")).sendKeys(Keys.chord(Keys.CONTROL,"t"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0],window.open();");

//        Robot rbt=new Robot();
//        rbt.keyPress(KeyEvent.VK_CONTROL);
//        rbt.keyPress(KeyEvent.VK_T);
//        rbt.keyRelease(KeyEvent.VK_CONTROL);
//        rbt.keyRelease(KeyEvent.VK_T);

        allWindowHandles=driver.getWindowHandles();
        itr= allWindowHandles.iterator();
    }
    @Then("print new tab's Title and url")
    public void switchWindow() throws AWTException {

        while(itr.hasNext()){
             nxt=itr.next();
            System.out.println(nxt);
            if(!nxt.equalsIgnoreCase(cHandle)){
                driver.switchTo().window(nxt);
            }

        }

        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println(nxt);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(9));

    }
    @And("closes the new page")
    public void closeCurrentTab(){
        System.out.println(nxt);

        driver.close();

        driver.switchTo().window(cHandle);


    }

    @Then("print the available page's title and url")
    public void printOGPage(){
    System.out.println(driver.getWindowHandle());

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
    }
}
