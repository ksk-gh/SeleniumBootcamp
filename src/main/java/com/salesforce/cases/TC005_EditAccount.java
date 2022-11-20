package com.salesforce.cases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.salesforce.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC005_EditAccount extends ProjectSpecificMethods {
	@BeforeTest
	public void setData() {
		excelFileName = "TC005";
		testCaseName="TC005_EditAccounts";
		testDescription="Login to Salesforce and Edit an Accounts";
		testNodes="Accounts";
		category="Regression";
		author="KSK";
	}

	@Test(dataProvider = "Dynamic_Data", enabled = true)
	public void tc005(String userName, String password, String accountName, String typeOptions,String industryOptions, String mobileNumber, String billStreet, String billCity, String billZipcode,
			String billState, String billCountry, String shipStreet, String shipCity, String shipZipcode,
			String shipState, String shipCountry, String priorityOptions, String slaOptions, String activeOptions, String snackMsg) throws InterruptedException {
	
		LoginPage loginPage = new LoginPage();
		
		loginPage.enterUserName(userName)
		.enterPassword(password)
		.clickLogin()
		.clickAppLauncher()
		.clickViewAll()
		.clickSalesLink()
		.clickAccountsLink()
		.searchAccounts(accountName)
		.clickRefreshButton()
		.clickOnFirstSearchElement()
		.clickOnEditButton()
		.clickOnTypeDropdown()
		.selectTypeOptions(typeOptions)
		.clickOnIndustryDropdown()
		.selectIndustryOptions(industryOptions)
		.enterBillingStreet(billStreet)
		.enterBillingCity(billCity)
		.enterBillingZipCode(billZipcode)
		.enterBillingState(billState)
		.enterBillingCountry(billCountry)
		.enterShippingStreet(shipStreet)
		.enterShippingCity(shipCity)
		.enterShippingZipCode(shipZipcode)
		.enterShippingState(shipState)
		.enterShippingCountry(shipCountry)
		.clickOnCustomerPriority()
		.selectCustomerPriorityOptions(priorityOptions)
		.clickOnSlaDropDown()
		.selectSlaOptions(slaOptions)
		.clickActiveDropDown()
		.selectActiveOption(activeOptions)
		.enterPhoneNumber(mobileNumber)
		.clickSaveButton()
		.validateSnackBarMsg(snackMsg)
		.clickRefreshButton()
		.clickOnFirstSearchElement()
		.validatePhoneNumber(mobileNumber);
		
	}
}
