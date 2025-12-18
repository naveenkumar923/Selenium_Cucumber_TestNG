package org.naveen.webUi.pages;

import org.naveen.webUi.stepDefinitions.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;

public class IbiboPage {

    private WebDriver driver;
    private Wait wt;

    @FindBy(how = How.CSS,using=".logSprite.icClose")
    WebElement popUp1;

    @FindBy(how = How.CSS,using = ".sc-jlwm9r-1.ewETUe")
    WebElement popUp2;

    @FindBy(how = How.CSS,using = ".sc-12foipm-6.erPfRs")
    WebElement inputBox;

    @FindBy(how = How.XPATH,using = "//input[@type='text']")
    WebElement enterText;

    @FindBy(how=How.XPATH,using="//ul[@id='autoSuggest-list']//*[@class='autoCompleteTitle ']")
    List<WebElement> suggestions;

    public IbiboPage(WebDriver driver){
        this.driver= driver;
        this.wt=Hooks.wt2;
        PageFactory.initElements(driver,this);
    }

    public void getIbiboPage(){
        driver.get("https://www.goibibo.com/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
    }

    public WebElement closepopUp1(){
        waitForElement();
        return popUp1;
    }


    public void closepopUp2(){
     waitForElement();
        popUp2.click();
    }
    public void getInputboxinput(){
        wt.until(ExpectedConditions.elementToBeClickable(inputBox));
        inputBox.click();
    }

    public void getEnterText(){
        waitForElement();
        enterText.sendKeys("MAA");
    }

    public List<WebElement> getSuggestions(){
        waitForElement();
        return suggestions;
    }

    public void waitForElement(){
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


}
