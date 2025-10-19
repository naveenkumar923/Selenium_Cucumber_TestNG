package org.naveen.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v137.overlay.model.LineStyle;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class Dropdowns {

    @Test
    public void dropdowns(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(22));

        WebDriverWait wt=new WebDriverWait(driver,Duration.ofSeconds(10));
        wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("withOptGroup")));
        WebElement drp=driver.findElement(By.id("withOptGroup"));
       drp.click();

        List<WebElement> options = wt.until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(By.cssSelector("div[class*='menu'] div[class*='option']")));

        for(WebElement o:options){
            System.out.println(o.getText());
        }

        driver.quit();

    }

    @Test
    public void dropdown2(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(22));

        WebDriverWait wt=new WebDriverWait(driver,Duration.ofSeconds(10));
        wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("selectOne")));
        WebElement drp=driver.findElement(By.id("selectOne"));
        drp.click();

        List<WebElement> options = wt.until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(By.cssSelector("div[class*='menu'] div[class*='option']")));

        for(WebElement o:options){
            System.out.println(o.getText());
        }

        driver.quit();
    }
}
