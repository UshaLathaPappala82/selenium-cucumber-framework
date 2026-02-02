package com.automation.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.pages.LoginPage;
import com.automation.utils.DriverFactory;

public class LoginSteps {
	
	WebDriver driver;
	LoginPage loginPage;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        
        driver = DriverFactory.getDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        loginPage = new LoginPage(driver);
        System.out.println(driver.getTitle());
        
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
      loginPage.enterUsername(username);
      loginPage.enterPassword(password);
    }
    
    @When("I click login")
    public void i_click_login() {
    loginPage.clickLogin(); 
    }
    @SuppressWarnings("deprecation")
	@Then("I should see the dashboard")
    public void i_should_see_the_dashboard() {
    	String message = driver.findElement(By.xpath("//h1")).getText();
    	Assert.assertEquals("Logged In Successfully", message);
     }

}