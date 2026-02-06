package com.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    // Sequential driver
    private static WebDriver driverStatic;

    // Parallel driver
    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    /**
     * Get WebDriver instance
     * @param parallel true if running parallel scenarios
     * @return WebDriver
     */
    public static WebDriver getDriver(boolean parallel) {
        String headless = System.getProperty("headless");

        if (parallel) {
            if (driverThread.get() == null) {
                driverThread.set(createChromeDriver(headless));
            }
            return driverThread.get();
        } else {
            if (driverStatic == null) {
                driverStatic = createChromeDriver(headless);
            }
            return driverStatic;
        }
    }

    // Default method (sequential runs)
    public static WebDriver getDriver() {
        return getDriver(false);
    }

    private static WebDriver createChromeDriver(String headless) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        if ("true".equalsIgnoreCase(headless)) {
            options.addArguments("--headless=new");
        }
        return new ChromeDriver(options);
    }

    public static void quitDriver(boolean parallel) {
        if (parallel) {
            if (driverThread.get() != null) {
                driverThread.get().quit();
                driverThread.remove();
            }
        } else {
            if (driverStatic != null) {
                driverStatic.quit();
                driverStatic = null;
            }
        }
    }

    // Default quit (sequential)
    public static void quitDriver() {
        quitDriver(false);
    }
}
