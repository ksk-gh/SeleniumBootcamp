package com.salesforce.cucumber;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;

public class LoginStepdefinitions extends Base {

	@Given("Login to the application")
	public void loginApplication() {

		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");

		driver.findElement(By.id("password")).sendKeys("Testleaf$321");

		driver.findElement(By.id("Login")).click();
	}

}
