package org.naveen.webUi.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionsStepDef {

    private WebDriver driver;
    private Wait<WebDriver> wt;

    public ActionsStepDef(){
        this.driver=Hooks.driver;
        this.wt=Hooks.wt;

    }




    @Given("User access herokudraganddrop page")
    public void getDragandDropPage(){
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
    }
    @Then("Perform the Drag and drop action")
    public void dragAction(){

        WebElement colA=driver.findElement(By.id("column-a"));
        WebElement colB=driver.findElement(By.id("column-b"));

        WebDriverWait t=new WebDriverWait(driver
                ,Duration.ofSeconds(9));
        t.until(ExpectedConditions.visibilityOf(colA));
        Actions ats=new Actions(driver);
        ats.dragAndDrop(colA,colB).perform();

    }


    @Given("User access rightclick page")
    public void getRightClickPage(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
    }
    @When("User clicks on the box")
    public void clickBox(){
        wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("hot-spot")));
        Actions acts=new Actions(driver);
        acts.contextClick(driver.findElement(By.id("hot-spot"))).perform();

    }
    @Then("User switches to the alert and prints the text")
    public void accessAlert(){
       Alert at=driver.switchTo().alert();
        System.out.println(at.getText());
        at.accept();
    }
    @And("closes the browser")
    public void closeWindow(){
      try{
       System.out.println(driver.findElement(By.xpath("//*[@class='example']/p")).getText());
        driver.quit();
      } catch (Exception e) {
          System.out.println(e.getMessage().toString());
         System.out.println(e.getCause().toString());
      }
    }

    @Given("User is on slider page")
    public void getSliderPage(){
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
    }
    @When("User slides the bar")
    public void moveSlider(){
        wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='range']")));
        Actions acts=new Actions(driver);
        WebElement slider= driver.findElement(By.xpath("//input[@type='range']"));
        acts.moveToElement(slider,15,0).perform();
        slider.click();

    }
    @Then("print the slider value")
    public void printOffset(){
        System.out.println(driver.findElement(By.id("range")).getText());
    }
}
