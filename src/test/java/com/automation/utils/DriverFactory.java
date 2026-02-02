package com.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
        	String browser = ConfigReader.get("browser").toLowerCase();
        	switch(browser) {
        	case "chrome":
        		WebDriverManager.chromedriver().setup();
        		driver = new ChromeDriver();
        		driver.manage().window().maximize();
        		break;
        	case "firefox":
        		WebDriverManager.firefoxdriver().setup();
        		driver = new FirefoxDriver();
        		break;
        	case "edge":
        		WebDriverManager.edgedriver().setup();
        		driver = new EdgeDriver();
        		break;
        	default:
        		System.out.println("Browser not supported: " + browser + ". Using Chrome as default.");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }
        	
        driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}