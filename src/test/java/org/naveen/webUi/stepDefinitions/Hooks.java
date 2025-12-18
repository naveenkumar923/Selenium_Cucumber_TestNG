package org.naveen.webUi.stepDefinitions;

import io.cucumber.core.gherkin.Step;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.messages.types.TestStepResult;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Hooks {
    public static WebDriver driver;


    //public static HtmlUnitDriver ud;
    public static Wait<WebDriver> wt;
    public static Wait wt2;
    static Properties properties;

    @Before
    public static void beforeAll() throws IOException {

//        driver=new ChromeDriver();
//        HTMLUnitDriver driver=new HTMLUnitDriver(true);
//            driver = new ChromeDriver(new ChromeOptions?().addArguments("headless"));

//        driver=new ChromeDriver((ChromeOptions) new ChromeOptions().setBrowserVersion("140"));
//
        ChromeOptions options = new ChromeOptions();
//            System.out.println(options.getBrowserVersion());
//        Capabilities capb=((RemoteWebDriver)driver).getCapabilities();
//        System.out.println(capb.getBrowserVersion());
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wt = new WebDriverWait(driver, Duration.ofSeconds(18));
        wt2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        File file = new File("src/test/resources/config.txt");
        FileInputStream iFile = new FileInputStream(file);
        properties = new Properties();
        properties.load(iFile);
    }

    @Before
    public void printTestName(Scenario scn) {
        Scenario scenario = scn;

        System.out.println("Executing test case " + scenario.getName());
    }

    @BeforeStep
    public void printTime() throws IOException {


        System.out.println(java.time.LocalDateTime.now());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    public void afterStep(TestStepResult r, Step step) throws IOException {

        Step s = step;
        TestStepResult res = r;
        System.out.println(s.getText());
        System.out.println(res.getStatus());
//        File ss=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//
//        FileUtils.copyFile(ss,new File("target\\screenshots\\ss"+ Math.random() +".png"));
//
//        Screenshot screenshot=new AShot().takeScreenshot(driver);
//        Screenshot str=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);

    }


    @After
    public void endTestCase() {

        driver.quit();
    }


}
