package com.salesforce.cases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.salesforce.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC008_EditWorkTypeNegative extends ProjectSpecificMethods {

	@BeforeTest
	public void setData() {
		excelFileName = "TC008";
	}

	@Test(dataProvider = "Dynamic_Data", enabled = true)
	public void tc008(String username, String password, String startTime, String endTime, String reviewMsg,
			String startError, String endError) {

		LoginPage loginPage = new LoginPage();

		loginPage.enterUserName(username).enterPassword(password)
		.clickLogin()
		.clickAppLauncher()
		.clickViewAll()
		.clickWorkTypesLink()
		.clickOnFirstElement()
		.clickEditButton()
		.enterStartDay(startTime)
		.enterEndDay(endTime)
		.clickSaveButtonWorktype()
		.validateReviewErrorMsg(reviewMsg)
		.validateStartErrorMsg(startError)
		.validateEndErrorMsg(endError);

	}
}
