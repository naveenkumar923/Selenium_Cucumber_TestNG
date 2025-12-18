package org.naveen.webUi.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;

public class WebTableStepDef {

    private WebDriver driver;
    private WebElement element;
    private int totalCol=0,totalRow=0;
    private String name="";
    public static Wait<WebDriver> wt;

    public WebTableStepDef(){
        this.driver=Hooks.driver;
        this.wt=Hooks.wt;
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
    }

    @Given("User launches WebTable page")
    public void launchWebTablePage()  throws InterruptedException {
        driver.get("https://www.nseindia.com/ipo-tracker?type=gain_listing_date");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(18));
//        Thread.sleep(18000);
    }
    @When("User finds the name Kierra")
    public void getRowCol()  {

//        FluentWait wt=new FluentWait(driver)
//                .withTimeout(Duration.ofSeconds(20))
//                .pollingEvery(Duration.ofSeconds(1))

//                .ignoring(InvalidElementStateException.class);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8

        ));
//        wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*/tbody"))));
//       wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/tbody")));
        element= driver.findElement(By.xpath("//*/tbody"));

        totalRow=driver.findElements(By.xpath("//*/tbody/tr")).size();
        totalCol=driver.findElements(By.xpath("//*/tbody/tr[1]/td")).size();
        WebElement row=driver.findElement(By.xpath("//*/tbody/tr[1]/td[6]"));
        List<WebElement> rowItems=row.findElements(By.xpath("preceding-sibling::*"));
            for(WebElement rowItem:rowItems){
                System.out.println(rowItem.getText());
            }
//
//        for(int i=1;i<=totalRow;i++){
//            for(int j=1;j<=totalCol;j++){
//                String val=driver.findElement(By.xpath("//*/tbody/tr["+i+"]/td["+j+"]")).getText();
//                if(val.equals("AHCL")){
//                    name=driver.findElement(By.xpath("//*/tbody/tr["+i+"]/td["+(j-1)+"]")).getText();
//
//                    break;
//                }
//
//            }
//        }
        System.out.println(rowItems.size());


        }
    @Then("User prints the name")
    public void printName(){
//        System.out.println(name);
//        Assert.assertEquals(name,"Anlon Healthcare Limited");

    }
}

