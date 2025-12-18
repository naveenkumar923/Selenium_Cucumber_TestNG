package org.naveen.webUi.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import java.util.Iterator;
import java.util.Set;

public class SwitchingWindowsStepDef {

    private WebDriver driver;
    String currentHandle="";
    Set<String> allHandles;
    Iterator<String> iterator;
    Wait<WebDriver> wt;


    public  SwitchingWindowsStepDef(){
        this.driver=Hooks.driver;
        this.wt=Hooks.wt;

    }
    @Given("testing a scenario")
    public void nothing(){


    }

    @And("current window handle is stored")
    public void getCurrentHandle(){
        currentHandle=driver.getWindowHandle();
        System.out.println(currentHandle);
    }
    @Then("New Window button is clicked")
    public void openNewWindow(){
//        Wait<WebDriver> wt=new WebDriverWait(driver, Duration.ofSeconds(18));
        wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("windowButton")));
        System.out.println(driver.findElement(By.id("windowButton")));
        wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("windowButton"))));
        driver.findElement(By.id("windowButton")).click();

    }
    @And("new window handle is stored")
    public void getAllWindowHandles(){
//        new WebDriverWait(driver,Duration.ofSeconds(3)).until(driver -> driver.getWindowHandles().size()>1);
        allHandles=driver.getWindowHandles();

        iterator= allHandles.iterator();
    }
    @And("Switched to newly opened window")
    public void switchWindow(){
        while(iterator.hasNext()){
            String nxt=iterator.next();
//            System.out.println(nxt);
            if(!nxt.equalsIgnoreCase(currentHandle)){
                driver.switchTo().window(nxt);
            }
        }
    }

    @And("title of new window is validated")
    public void newWindowTitle(){
        System.out.println(driver.getCurrentUrl());
    }
    @And("newly opened window is closed")
    public void closeNewWindow(){
        driver.close();
    }
    @And("switched back to initial window")
    public void switchBack(){
        driver.switchTo().window(currentHandle);
    }
    @And("browser is closed")
    public void close(){
        driver.close();
    }
}
