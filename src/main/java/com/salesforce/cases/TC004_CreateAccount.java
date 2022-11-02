package com.salesforce.cases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.salesforce.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC004_CreateAccount extends ProjectSpecificMethods {

	@BeforeTest
	public void setData() {
		excelFileName = "TC004";
	}

	@Test(dataProvider = "Dynamic_Data", enabled = true)
	public void tc004(String userName, String passWord, String accountName, String ownership, String snackMsg)
			throws InterruptedException {

		LoginPage login = new LoginPage();
		login.enterUserName(userName)
		.enterPassword(passWord)
		.clickLogin()
		.clickAppLauncher()
		.clickViewAll()
		.clickSalesLink()
		.clickAccountsLink()
		.clickNewButton()
		.sendAccountName(accountName)
		.clickOwnershipTxtBx()
		.selectOwnershipOption(ownership)
		.clickSaveButton()
		.validateSnackBarMsg(snackMsg)
		.validateAccountName(accountName);
	}
}
