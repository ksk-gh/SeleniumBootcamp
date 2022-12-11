package com.salesforce.cases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.salesforce.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC007_CreateWorkType extends ProjectSpecificMethods {

	@BeforeTest
	public void setData() {
		excelFileName = "TC007";
		testCaseName="TC007_CreateWorkType";
		testDescription="Login to Salesforce and create a worktype";
		testNodes="Worktypes";
		category="Regression";
		author="KSK";
	}

	@Test(dataProvider = "Dynamic_Data", enabled = true)
	public void tc007(String username, String password, String projectName, String textArea, String shift,
			String shiftTimings, String snackBarMsg) {

		LoginPage loginPage = new LoginPage();

		loginPage.enterUserName(username)
		.enterPassword(password)
		.clickLogin()
		.clickAppLauncher()
		.clickViewAll()
		.clickWorkTypesLink()
		.clickNewButton()
		.enterWorkTypeName(projectName)
		.enterDescription(textArea)
		.clickOnOperatingHoursTxtBx()
		.clickOnOperatingHoursLink()
		.enterShitName(shift)
		.clickOperatingHoursSaveButton()
		.waitUntilInviisiblityOfSnackBar()
		.enterEstimatedDuration(shiftTimings)
		.clickSaveButtonWorktype()
		.validateSnackBar(snackBarMsg);

		
	}
}
