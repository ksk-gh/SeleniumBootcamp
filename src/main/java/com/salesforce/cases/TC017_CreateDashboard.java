package com.salesforce.cases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.salesforce.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC017_CreateDashboard extends ProjectSpecificMethods {

	@BeforeTest
	public void setData() {
		excelFileName = "TC017";
		testCaseName="TC017_CreateDashboards";
		testDescription="Login to Salesforce and Create Dashboards";
		testNodes="Tasks";
		category="Regression";
		author="KSK";
	}

	@Test(dataProvider = "Dynamic_Data",enabled = true)
	public void tc017(String username, String password,String dashbaordName) throws InterruptedException {

		
		LoginPage login = new LoginPage();

		login.enterUserName(username)
		.enterPassword(password)
		.clickLogin()
		.clickAppLauncher()
		.clickViewAll()
		.clickDashboardLink()		
		.clickNewDashboard()
		.switchToIFrame()
		.enterDashboardName(dashbaordName);
		
		
		}
	
}
