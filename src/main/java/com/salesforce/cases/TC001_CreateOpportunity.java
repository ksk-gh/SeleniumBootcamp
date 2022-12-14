package com.salesforce.cases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.salesforce.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC001_CreateOpportunity extends ProjectSpecificMethods {
	@BeforeTest
	public void setData() {
		excelFileName = "TC001";
		testCaseName="TC001_CreateOpportunity";
		testDescription="Login to Salesforce and Create an opportunity";
		testNodes="Opportunities";
		category="Regression";
		author="KSK";
		}

	@Test(dataProvider = "Dynamic_Data")

	public void runTC001(String userName, String passWord, String enterOpportunity, String snackBarMessage)
			throws InterruptedException {

		LoginPage loginPage = new LoginPage();
		loginPage.enterUserName(userName)
		.enterPassword(passWord)
		.clickLogin()
		.clickAppLauncher()
		.clickViewAll()
		.clickSalesLink()
		.clickOpportunityLink()
		.clickNewButton()
		.enterOpportunityName(enterOpportunity)
		.getEnteredOpportunityName()
		.clickCloseDate()
		.clickTodayDateNumber()
		.clickStageDropdown()
		.selectNeedAnalaysisValue()
		.clickSaveButton()
		.validateSnackBarMessageWithTitleVerification(snackBarMessage,enterOpportunity);

	}

}
