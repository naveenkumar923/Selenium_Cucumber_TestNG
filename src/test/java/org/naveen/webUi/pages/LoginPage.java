package org.naveen.webUi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//a[@href='/products']")
    WebElement element;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return driver.getTitle();


    }

    public void launchPage() {
        driver.get("https://www.automationexercise.com/");
    }

    public WebElement homeLinkPresent() {
        return element;
    }

    public void printElement() {

    }

}
