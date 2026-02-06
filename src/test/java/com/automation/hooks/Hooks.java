package com.automation.hooks;


import com.automation.utils.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;

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
   
}