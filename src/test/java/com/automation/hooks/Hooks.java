package com.automation.hooks;

import com.automation.utils.DriverFactory;

import io.cucumber.java.After;

public class Hooks {

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}