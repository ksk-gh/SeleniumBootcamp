package com.salesforce.pages;

import org.openqa.selenium.By;

import com.salesforce.base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods {

	public LoginPage() {

	}

	public LoginPage enterUserName(String userName) {
		driver.findElement(By.id("username")).sendKeys(userName);
		return this;
	}

	public LoginPage enterPassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
		return this;

	}

	public HomePage clickLogin() {
		driver.findElement(By.id("Login")).click();
		return new HomePage();

	}

}
