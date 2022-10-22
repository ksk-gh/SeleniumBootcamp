package com.salesforce.pages;

import org.openqa.selenium.By;

import com.salesforce.base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods {

	public LoginPage() {

	}

	public LoginPage enterUserName(String userName) {
		driver.findElement(By.id(prop.getProperty("username_id"))).sendKeys(userName);
		return this;
	}

	public LoginPage enterPassword(String password) {
		driver.findElement(By.id(prop.getProperty("password_id"))).sendKeys(password);
		return this;

	}

	public HomePage clickLogin() {
		driver.findElement(By.id(prop.getProperty("loginButton_id"))).click();
		return new HomePage();

	}

}
