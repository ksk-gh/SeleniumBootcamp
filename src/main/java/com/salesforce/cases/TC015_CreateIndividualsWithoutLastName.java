package com.salesforce.cases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.salesforce.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC015_CreateIndividualsWithoutLastName extends ProjectSpecificMethods {

	@BeforeTest
	public void setData() {
		excelFileName = "TC015";
		testCaseName="TC015_CreateIndividualsWithoutLastName";
		testDescription="Login to Salesforce and Create an Individuals without Lastname and error validations";
		testNodes="Individuals";
		category="Regression";
		author="KSK";
	}

	@Test(dataProvider = "Dynamic_Data",enabled = true)
	public void tc015(String username, String password,String firstName, String errorText) {
		//String errorText = "Complete this field.";

		
		LoginPage login = new LoginPage();

		login.enterUserName(username)
		.enterPassword(password)
		.clickLogin()
		.clickAppLauncher()
		.clickViewAll()
		.clickIndividualsLink()
		.clickDownArrow()
		.clickNewIndividualLink()
		.enterFirstName(firstName)
		.clickSaveButton()
		.validateLastNameErrormessage(errorText);

	}
}
