package com.automation.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.pages.LoginPage;
import com.automation.utils.DriverFactory;

public class LoginSteps {
	
	WebDriver driver;
	LoginPage loginPage;

 	@Given("user is on the login page")
	 public void user_is_on_the_login_page() {
	  	 driver = DriverFactory.getDriver();
	     driver.get("https://practicetestautomation.com/practice-test-login/");
	     loginPage = new LoginPage(driver);
	     System.out.println(driver.getTitle());
    }
	
 	 @When("user enters username {string} and password {string}")
     public void user_enters_username_and_password(String username, String password) {
 		 loginPage.enterUsername(username);
 	     loginPage.enterPassword(password);
     }
     
 	 @When("user clicks on login button")
 	 public void user_clicks_on_login_button() {
 		 loginPage.clickLogin();      
 	 }
 	 
 	@Then("login should be {string} with {string}")
 	public void login_should_be_with(String status, String expectedMessage) {
 	   String actualMessage="";
 		if(status.equals("success")) {
 	     actualMessage = loginPage.getSuccessMessage();
 	    }
 	    else if(status.equals("failure")) {
 	      actualMessage = loginPage.getErrorMessage();
 	    }
 		System.out.println(actualMessage);
 		System.out.println(expectedMessage);
 	   Assert.assertTrue(actualMessage.equals(expectedMessage));
 	}



    @Then("user should see {string}")
    public void user_should_see(String expectedMessage) {
    	
    	String actualMessage = loginPage.getErrorMessage();
    	Assert.assertEquals(actualMessage, expectedMessage);
    }



}