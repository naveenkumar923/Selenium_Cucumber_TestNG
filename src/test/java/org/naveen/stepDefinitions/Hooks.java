package org.naveen.stepDefinitions;

import io.cucumber.core.gherkin.Step;
import io.cucumber.java.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.Scenario;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Properties;

public class Hooks {
public static WebDriver driver;


//public static HtmlUnitDriver ud;
    public static Wait<WebDriver> wt;
    public static Wait wt2;
   static Properties properties;
    @Before
        public void setUp() throws IOException {

        driver=new ChromeDriver();
//        HTMLUnitDriver driver=new HTMLUnitDriver(true);
//            driver = new ChromeDriver(new ChromeOptions?().addArguments("headless"));

//        driver=new ChromeDriver((ChromeOptions) new ChromeOptions().setBrowserVersion("140"));
//
//            ChromeOptions options=new ChromeOptions();
//            System.out.println(options.getBrowserVersion());
//        Capabilities capb=((RemoteWebDriver)driver).getCapabilities();
//        System.out.println(capb.getBrowserVersion());
            driver.manage().window().maximize();
         wt=new WebDriverWait(driver, Duration.ofSeconds(18));
        wt2=new WebDriverWait(driver,Duration.ofSeconds(10));
        File file = new File("src/test/resources/config.txt");
        FileInputStream iFile=new FileInputStream(file);
        properties= new Properties();
        properties.load(iFile);
        }

    @BeforeStep
    public void printTime() throws IOException {


        System.out.println(java.time.LocalDateTime.now());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @AfterMethod
    public void afterStep() throws IOException {

        File ss=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(ss,new File("target\\screenshots\\ss"+ Math.random() +".png"));

        Screenshot screenshot=new AShot().takeScreenshot(driver);
//        Screenshot str=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);

    }


        @After
    public void tearDown(){
            driver.quit();
        }

}
