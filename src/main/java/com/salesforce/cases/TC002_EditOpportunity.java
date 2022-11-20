package com.salesforce.cases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.salesforce.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC002_EditOpportunity extends ProjectSpecificMethods{
	@BeforeTest
	public void setData() {
		excelFileName="TC002";
		testCaseName="TC002_EditOpportunity";
		testDescription="Login to Salesforce and Edit an opportunity";
		testNodes="Opportunities";
		category="Regression";
		author="KSK";
	}

	@Test(dataProvider = "Dynamic_Data", enabled=true)
	public void tc002(String userName, String passWord, String enterOpportunity, String enterDescription, String verifySnackBarText, String stageName) throws InterruptedException {
		
		/*
		 * if (driver.getTitle().contains("Developer Edition")) {
		 * driver.findElement(By.xpath("//*[@class='switch-to-lightning']")).click(); }
		 */
		
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
		.clickOnEditButton()
		.clickCloseDate()
		.clickNextDay()
		.clickStageDropdown()
		.selectPerceptionAnalysisValue()
		.clickDeliveryTextBox()
		.selectInprogressDeliveryOption()
		.enterDescription(enterDescription)
		.clickSaveButton()
		.validateSnackBarMessage(verifySnackBarText)
		.clickRefreshButton()
		.validateStageText(stageName);
		
	}
	
}
