package com.automation.hooks;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.automation.utils.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	@Before
    public void setUp() {
        DriverFactory.getDriver(); // Initialize driver before scenario
        System.out.println("Running in " + 
            ("true".equalsIgnoreCase(System.getProperty("headless")) ? "HEADLESS" : "UI") + " mode");
    }
    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
    
    @After
    public void addScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver())
                    .getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        }
    }

    @AfterStep
    public void addScreenshotStep(Scenario scenario) {
        byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver())
                .getScreenshotAs(OutputType.BYTES);

        scenario.attach(screenshot, "image/png", "Step Screenshot");
    }
}