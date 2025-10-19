package org.naveen.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AlertsStepDef {

    private WebDriver driver;
    private Alert alert;

    private String input="";

    public AlertsStepDef(){
        this.driver=Hooks.driver;
    }

    @Given("Alert page is launched")
    public void launchAlertPage(){
        driver.get("https://demoqa.com/alerts");
    }
    @When("simple alert is clicked")
    public void clickSimpleAlert(){
        WebElement element = driver.findElement(By.id("alertButton"));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",element);

    }

    @When("timer alert is clicked")
    public void clickTimerAlert(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(9));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("timerAlertButton"))));
        driver.findElement(By.id("timerAlertButton")).click();
    }

    @When("confirmation alert is clicked")
    public void clickConfirmationAlert(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(19));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmButton")));
        WebElement element=driver.findElement(By.id("confirmButton"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
//        js.executeScript("Window.scrollBy(0,50)");
        js.executeScript("arguments[0].scrollIntoView(true);",element);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("confirmButton"))));

        driver.findElement(By.id("confirmButton")).click();
    }

    @When("prompt alert is clicked")
    public void clickPromptAlert(){
        WebElement element = driver.findElement(By.id("promtButton"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",element);
    }
    @Then("print the alert text")
    public void getAlertText(){
        try {
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(9));
            wait.until(ExpectedConditions.alertIsPresent());
            alert = driver.switchTo().alert();
            System.out.println(alert.getText());
        } catch (Exception e) {

        }
    }

    @And("enter some text")
    public void enterText(){
        input="Blah Blah";
        alert.sendKeys(input);
    }

    @And("accept the alert")
    public void acceptAlert(){
        alert.accept();
    }

    @Then("Validate the result")
    public void validateResult(){
        String actual=driver.findElement(By.id("promptResult")).getText();
        Assert.assertEquals(actual,"You entered "+input);
    }
    @And("print the selected option")
    public void printUserSelection(){
        System.out.println(driver.findElement(By.id("confirmResult")).getText());
    }

    @And("dismiss the alert")
    public void dismissAlert(){
        alert.dismiss();
    }
}
