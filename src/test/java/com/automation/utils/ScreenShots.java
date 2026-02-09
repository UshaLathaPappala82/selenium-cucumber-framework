package com.automation.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShots {

	public byte[] takeScreenshot(WebDriver driver) {
	    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
}
