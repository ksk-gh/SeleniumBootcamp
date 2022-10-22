package com.salesforce.pages;

import org.openqa.selenium.By;

import com.salesforce.base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods {

	public LoginPage() {

	}

	public LoginPage enterUserName(String userName) {
		driver.findElement(By.id(prop.getProperty("login.username.id"))).sendKeys(userName);
		return this;
	}

	public LoginPage enterPassword(String password) {
		driver.findElement(By.id(prop.getProperty("login.password.id"))).sendKeys(password);
		return this;

	}

	public HomePage clickLogin() {
		driver.findElement(By.id(prop.getProperty("login.loginbtn.id"))).click();
		return new HomePage();

	}

}
