package org.naveen.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"org/naveen/webUi/stepDefinitions"},
        plugin = {
                "pretty",
//                "html:target\\reports\\html.html",
//                "json:target\\reports\\reportjson.json"
//                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                "json:C:\\Users\\navee\\OneDrive\\Desktop\\tc.json"

        },
        publish = true,
        dryRun = true,

        tags = "@login"
)
public class TestRunner extends AbstractTestNGCucumberTests {
//


    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }


}
