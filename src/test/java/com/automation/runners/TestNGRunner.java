package com.automation.runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {
                        "com.automation.stepdefinitions",
                        "com.automation.hooks"
                },
        plugin = {
                "pretty",
                "html:target/cucumber-report.html"
        },
        monochrome = true
)
public class TestNGRunner extends AbstractTestNGCucumberTests {
    	 @Override
	    @DataProvider(parallel = false)
	    public Object[][] scenarios() {
	        return super.scenarios();
}
}    	 