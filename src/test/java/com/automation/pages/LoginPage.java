package com.automation.pages;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Locator
	private By usernameField = By.id("username");
	private By passwordField = By.id("password");
	private By loginButton =By.id("submit");
	private By errorMessage = By.id("error");
	private By successMessage = By.xpath("//h1");
	
    //Actions 
	//Actions
	
	public void enterUsername(String username)
	{
		driver.findElement(usernameField).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
		
	}
	public String getErrorMessage()
	{
		WebDriverWait wait = new WebDriverWait(driver,java.time.Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(errorMessage)));
		
		return driver.findElement(errorMessage).getText();
	}
	public String getSuccessMessage() {
		return driver.findElement(successMessage).getText();
	}
	public void clickLogin() {
		driver.findElement(loginButton).click();
	}
	
	
	
}
