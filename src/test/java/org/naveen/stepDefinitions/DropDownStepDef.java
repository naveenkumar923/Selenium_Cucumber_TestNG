package org.naveen.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownStepDef {

    private WebDriver driver;
    Select dropDown;

    public DropDownStepDef(){
        this.driver=Hooks.driver;
    }

    @When("Opens menu page")
    public void menuPage(){
        driver.get("https://demoqa.com/select-menu");
    }
    @And("Selects old style select menu")
    public void selectMenu(){
        dropDown=new Select(driver.findElement(By.id("oldSelectMenu")));
    }
    @Then("Prints all options")
    public void printOptions(){
        List<WebElement> options=dropDown.getOptions();
        for(int i=0;i<options.size();i++){
            System.out.println(options.get(i).getText());
        }
    }
    @And("Selects Purple using index")
    public void selectPurple(){
        dropDown.selectByIndex(4);
    }
    @And("Selects Magenta using visible text")

    public void selectMagenta(){
        dropDown.selectByVisibleText("Magenta");
    }
    @And("Selects an option using value")
    public void selectByValue(){
        dropDown.selectByValue("10");
    }
}
