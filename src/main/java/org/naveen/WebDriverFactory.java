package org.naveen;

// Example WebDriverFactory.java
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setupDriver(String browserName, String browserVersion) {
        WebDriverManager wdm;
        switch (browserName.toLowerCase()) {
            case "chrome":
                wdm = WebDriverManager.chromedriver().browserVersion(browserVersion);
                break;
            case "firefox":
                wdm = WebDriverManager.firefoxdriver().browserVersion(browserVersion);
                break;
            case "edge":
                wdm = WebDriverManager.edgedriver().browserVersion(browserVersion);
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
        wdm.setup();

        // Initialize the actual WebDriver
        switch (browserName.toLowerCase()) {
            case "chrome":
                driver.set(new ChromeDriver());
                break;
            case "firefox":
                driver.set(new FirefoxDriver());
                break;
            case "edge":
                driver.set(new EdgeDriver());
                break;
        }
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}