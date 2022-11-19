package com.salesforce.pages;

import com.salesforce.base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods {

	public LoginPage() {

	}

	public LoginPage enterUserName(String userName) {
		type(locateElement("id", prop.getProperty("login.username.id")),userName);
		return this;
	}

	public LoginPage enterPassword(String password) {
		type(locateElement("id", prop.getProperty("login.password.id")),password);
		return this;

	}

	public HomePage clickLogin() {
		click(locateElement("id", prop.getProperty("login.loginbtn.id")));
		return new HomePage();

	}

}
