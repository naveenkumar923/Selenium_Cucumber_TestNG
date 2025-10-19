package org.naveen.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    private WebDriver driver;
    private By homeLink=By.xpath("//a[@href='/products']");
   @FindBy(how=How.XPATH,using="//a[@href='/products']")
   WebElement element;

    public LoginPage(WebDriver driver){
        this.driver= driver;
    }

    public String getTitle(){
        return driver.getTitle();


    }

    public void launchPage(){
        driver.get("https://www.automationexercise.com/");
    }

    public WebElement homeLinkPresent(){
        return driver.findElement(homeLink);   }

}
