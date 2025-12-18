package org.naveen.webUi.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsStepDef {


//    public ActionsStepDef(){
//        this.driver=Hooks.driver;
//    }
    @Test
    public  void main() throws InterruptedException{
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.google.com/");

        WebElement txt=driver.findElement(By.name("q"));
        driver.manage().window()
                .maximize();
        Actions a =new Actions(driver);

        a.keyDown(txt, Keys.SHIFT).sendKeys("today").keyUp(Keys.SHIFT).build().perform();
       Thread.sleep(9000);
        driver.quit();

    }


}
