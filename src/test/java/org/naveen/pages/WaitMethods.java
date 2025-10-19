package org.naveen.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.lang.*;
@Test
public class WaitMethods {


    public void impWait() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\navee\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
    driver.get("https://www.nseindia.com/ipo-tracker?type=gain_listing_date");
        System.out.println(LocalDateTime.now());


//    Wait<WebDriver> wt=new WebDriverWait(driver,Duration.ofSeconds(12));
//    wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/tbody")));
//

        Wait<WebDriver> fw=new FluentWait<>(driver).withTimeout(Duration.ofSeconds(7))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
                ;
                fw.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/tbody")));


                System.out.println(LocalDateTime.now());



       int totalRow=driver.findElements(By.xpath("//*/tbody/tr")).size();
       int totalCol=driver.findElements(By.xpath("//*/tbody/tr[1]/td")).size();
        String name="";

        for(int i=1;i<=totalRow;i++){
            for(int j=1;j<=totalCol;j++){
                String val=driver.findElement(By.xpath("//*/tbody/tr["+i+"]/td["+j+"]")).getText();
                if(val.equals("AHCL")){
                    name=driver.findElement(By.xpath("//*/tbody/tr["+i+"]/td["+(j-1)+"]")).getText();
                    break;
                }

            }
        }

        System.out.println(name);
        Assert.assertEquals(name,"Anlon Healthcare Limited");
        driver.quit();

    }
}