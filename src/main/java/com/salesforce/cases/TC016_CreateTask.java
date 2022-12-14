package com.salesforce.cases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.salesforce.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC016_CreateTask extends ProjectSpecificMethods{


	@BeforeTest
	public void setData() {
		excelFileName = "TC016";
		testCaseName="TC016_CreateTasks";
		testDescription="Login to Salesforce and Create Tasks";
		testNodes="Tasks";
		category="Regression";
		author="KSK";
	}

	@Test(dataProvider = "Dynamic_Data",enabled = true)
	public void tc015(String username, String password,String subject, String status,String snackmsg) throws InterruptedException {
		//String errorText = "Complete this field.";

		LoginPage login = new LoginPage();

		login.enterUserName(username)
		.enterPassword(password)
		.clickLogin()
		.clickAppLauncher()
		.clickSalesLink()
		.clickTasksMenu()
		.clickTasksDownArrow()
		.clickNewTasksLink()
		.enterSubject(subject)
		.clickStatus()
		.selectStatusOption(status)
		.clickSaveButton()
		.validateSnackBarMsg(snackmsg);

		}
}