package org.naveen.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

@Test
public class MakeMyTrip {


    public static void main(String[] args){
        WebDriver driver=new ChromeDriver();
        Wait wt=new WebDriverWait(driver,Duration.ofSeconds(15)).pollingEvery(Duration.ofSeconds(1))
                        .withTimeout(Duration.ofSeconds(12))
                                .ignoring(NoSuchElementException.class);
        driver.manage().window().maximize();

        driver.get("https://www.goibibo.com/");
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
//        wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-cy='closeModal']")));
//        WebElement close=driver.findElement(By.xpath("//*[@data-cy='closeModal']"));
//        if(close.isEnabled()){
//        close.click();
//        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        WebElement outsideModal=driver.findElement(By.cssSelector(".logSprite.icClose"));
        outsideModal.click();

//        driver.switchTo().alert().dismiss();
//        WebElement fromCity=driver.findElement(By.xpath("//*[@id='fromCity']"));
//        fromCity.click();
//        List<WebElement> suggestions=driver.findElements(By.xpath("//ul[@role='listbox']/li"));
//        for(WebElement suggestion : suggestions){
//                    System.out.println(suggestion);
//        }
        driver.findElement(By.cssSelector(".sc-jlwm9r-1.ewETUe")).click();
//        driver.findElement(By.xpath("//input[@type='text']")).click();
        driver.findElement(By.cssSelector(".sc-12foipm-6.erPfRs")).click();
        wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("MAA");
        List<WebElement> fromCitySuggestions=driver.findElements(By.xpath("//ul[@id='autoSuggest-list']//*[@class='autoCompleteTitle ']"));

        for(WebElement elt :fromCitySuggestions ){
            System.out.println(elt.getText());
        }

    }
}
