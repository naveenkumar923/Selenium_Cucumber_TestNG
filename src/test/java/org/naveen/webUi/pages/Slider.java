package org.naveen.webUi.pages;

import org.apache.commons.io.FileDeleteStrategy;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

public class Slider {

    @Test
    public void slidermove() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        double desiredLength=-1.5;

        WebDriverWait wt=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
        WebElement range=driver.findElement(By.id("range"));
        WebElement slider=driver.findElement(By.tagName("input"));
//        driver.findElement(By.tagName("input")).click();
        Actions atc=new Actions(driver);
        atc.click(slider);
        while(Double.parseDouble(range.getText()) != desiredLength){
            if(desiredLength>5.0 || desiredLength<0){
                System.out.println("Invalid length");
                break;
            }
                if(Double.parseDouble(range.getText()) < desiredLength) {
                    atc.sendKeys(Keys.ARROW_RIGHT).perform();
                } else if(Double.parseDouble(range.getText()) > desiredLength) {
                    atc.sendKeys(Keys.ARROW_LEFT).perform();
                }
            takeScreenshot(driver);
        }
       closeTest(driver);


    }

    public void closeTest(WebDriver driver){
        driver.quit();

    }
    public void takeScreenshot(WebDriver driver) throws IOException {
        Random random = new Random();

        var camera=(TakesScreenshot)driver;
        File screenshot=camera.getScreenshotAs(OutputType.FILE);
//        screenshot.renameTo("target/Screenshots/"+LocalDateTime.now()+".png");
//        System.out.println(screenshot.toPath());
        Files.move(screenshot.toPath(), new File("target/Screenshots/"+random.nextInt(10)+".png").toPath());


    }
}
