package com.automation.stepdefinitions;

import static org.junit.Assert.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APISteps {

	Response response;
	
	@Given("the API base URI is set")
	public void setBaseURI() {
		RestAssured.baseURI = "https://reqres.in";   
	}
	@When("I send a GET request to {string}")
	public void sendGetRequest(String endpoint) {
	   response = RestAssured
			   .given()
			   .header("x-api-key","reqres_51e67d49e42e45929ad8022ad0f87d61")
			   .header("Accept","application/json")
			   .when()
			   .get(endpoint);
		
	}
	@Then("the response status code should be {int}")
	public void validateStatusCode(int statusCode) {
	   response.then().statusCode(statusCode);
	}
	@Then("the response should contain {string}")
	public void validateResponseContains(String key) {
	   
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
	}	
}
