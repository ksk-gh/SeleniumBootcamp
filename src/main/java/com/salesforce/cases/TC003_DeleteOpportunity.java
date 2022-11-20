package com.salesforce.cases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.salesforce.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC003_DeleteOpportunity extends ProjectSpecificMethods {

	@BeforeTest
	public void setData() {
		excelFileName = "TC003";
		testCaseName="TC003_DeleteOpportunity";
		testDescription="Login to Salesforce and Delete an opportunity";
		testNodes="Opportunities";
		category="Regression";
		author="KSK";
	}

	@Test(dataProvider = "Dynamic_Data", enabled = true)
	public void tc003(String userName, String passWord, String enterOpportunity) throws InterruptedException {

		

		LoginPage login = new LoginPage();
		
		login.enterUserName(userName)
		.enterPassword(passWord)
		.clickLogin()
		.clickAppLauncher()
		.clickViewAll()
		.clickSalesLink()
		.clickOpportunityLink()
		.searchOpportunity(enterOpportunity)
		.clickRefreshButton()
		.clickOnFirstSearchElement()
		.clickDeleteButton()
		.acceptDelete()
		.validateNoItemsText();
		
	}

}
