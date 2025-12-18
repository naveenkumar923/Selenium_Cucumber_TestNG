package org.naveen.webUi.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FrameStepDef {

    private WebDriver driver;

    public FrameStepDef(){
        this.driver=Hooks.driver;
    }

    @Given("frames page is launched")
    public void launchFramesPage(){
        driver.get("https://demoqa.com/frames");
    }
    @Then("get first frame size")
    public void getFirstFrame(){
        driver.switchTo().frame("frame1");
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
    }
    @And("get second frame size")
    public void getSecondFrame(){
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame2");
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        driver.switchTo().parentFrame();
        System.out.println(driver.findElements(By.tagName("iframe")).size());
    }
}
