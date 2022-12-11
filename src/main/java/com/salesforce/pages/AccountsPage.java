package com.salesforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.salesforce.base.ProjectSpecificMethods;

public class AccountsPage extends ProjectSpecificMethods {

	public AccountsPage clickNewButton() {

		click(locateElement("xpath", prop.getProperty("accounts.newbtn.xpath")));
		return this;

	}

	public AccountsPage sendAccountName(String accountName) {
		type(locateElement("xpath", prop.getProperty("accounts.name.xpath")), accountName);
		return this;
	}

	public AccountsPage clickOwnershipTxtBx() {

		clickUsingJs(locateElement("xpath", prop.getProperty("accounts.ownershiptxtbx.xpath")));
		return this;
	}

	public AccountsPage selectOwnershipOption(String ownership) {
		WebElement publicDropdownValue = getDriver().findElement(By.xpath("//*[@data-value='" + ownership + "']"));
		clickUsingJs(publicDropdownValue);
		return this;
	}

	public AccountsPage clickSaveButton() {

		click(locateElement("xpath", prop.getProperty("accounts.savebtn.xpath")));
		return this;
	}

	public AccountsPage validateSnackBarMsg(String snackBarMsg) {

		Assert.assertEquals(snackBarMsg,
				getTextMessage(locateElement("xpath", prop.getProperty("accounts.snackbarmsg.xpath"))));
		return this;
	}

	public AccountsPage validateAccountName(String accountName) {
		Assert.assertEquals(accountName,
				getTextMessage(locateElement("xpath", prop.getProperty("accounts.getAccountName.xpath"))));
		return this;
	}

	public AccountsPage searchAccounts(String accountName) {
		type(locateElement("xpath", prop.getProperty("accounts.accountssearch.xpath")), accountName);
		return this;
	}

	public AccountsPage clickOnFirstSearchElement() {
		waitUntilStalenessof(locateElement("xpath", prop.getProperty("accounts.firstSearchedElement.xpath")));
		click(locateElement("xpath", prop.getProperty("accounts.firstSearchedElement.xpath")));
		return this;
	}

	public AccountsPage clickRefreshButton() {
		click(locateElement("xpath", prop.getProperty("accounts.refreshbtn.xpath")));
		return this;

	}

	public AccountsPage clickOnEditButton() {
		click(locateElement("xpath", prop.getProperty("accounts.editBtn.xpath")));
		return this;
	}

	public AccountsPage clickOnTypeDropdown() {
		clickUsingJs(locateElement("xpath", prop.getProperty("accounts.typedropdown.xpath")));
		return this;
	}

	public AccountsPage selectTypeOptions(String typeOptions) {
		WebElement selectType = getDriver().findElement(By.xpath("//*[@title='" + typeOptions + "']"));
		click(selectType);
		return this;

	}

	public AccountsPage clickOnIndustryDropdown() {

		click(locateElement("xpath", prop.getProperty("accounts.industrydropdown.xpath")));
		return this;

	}

	public AccountsPage selectIndustryOptions(String industryOptions) {
		WebElement industryOption = getDriver().findElement(By.xpath("//*[@data-value='" + industryOptions + "']"));
		click(industryOption);
		return this;

	}

	public AccountsPage enterBillingStreet(String billStreet) {

		type(locateElement("xpath", prop.getProperty("accounts.billingstreet.xpath")), billStreet);
		return this;
	}

	public AccountsPage enterBillingCity(String billCity) {

		type(locateElement("xpath", prop.getProperty("accounts.billingcity.xpath")), billCity);

		return this;

	}

	public AccountsPage enterBillingZipCode(String billZipcode) {

		type(locateElement("xpath", prop.getProperty("accounts.billingzipcode.xpath")), billZipcode);
		return this;

	}

	public AccountsPage enterBillingState(String billState) {

		type(locateElement("xpath", prop.getProperty("accounts.billingstate.xpath")), billState);
		return this;

	}

	public AccountsPage enterBillingCountry(String billCountry) {

		type(locateElement("xpath", prop.getProperty("accounts.billingcountry.xpath")), billCountry);
		return this;
	}

	public AccountsPage enterShippingStreet(String shipStreet) {
		type(locateElement("xpath", prop.getProperty("accounts.shippingstreet.xpath")), shipStreet);
		return this;
	}

	public AccountsPage enterShippingCity(String shipCity) {
		type(locateElement("xpath", prop.getProperty("accounts.shippingcity.xpath")), shipCity);
		return this;

	}

	public AccountsPage enterShippingZipCode(String shipZipcode) {
		type(locateElement("xpath", prop.getProperty("accounts.shippingzipcode.xpath")), shipZipcode);
		return this;

	}

	public AccountsPage enterShippingState(String shipState) {
		type(locateElement("xpath", prop.getProperty("accounts.shippingstate.xpath")), shipState);
		return this;

	}

	public AccountsPage enterShippingCountry(String shipCountry) throws InterruptedException {
		typeWithTab(locateElement("xpath", prop.getProperty("accounts.shippingcountry.xpath")), shipCountry);
		Thread.sleep(1000);
		return this;
	}

	public AccountsPage clickOnCustomerPriority() {
		click(locateElement("xpath", prop.getProperty("accounts.customerpriority.xpath")));
		return this;
	}

	public AccountsPage selectCustomerPriorityOptions(String priorityOptions) {
		WebElement priorityOption = getDriver().findElement(By.xpath("//*[@data-value='" + priorityOptions + "']"));// .click();
		click(priorityOption);
		return this;

	}

	public AccountsPage clickOnSlaDropDown() {
		click(locateElement("xpath", prop.getProperty("accounts.slapriority.xpath")));
		return this;
	}

	public AccountsPage selectSlaOptions(String slaOptions) {
		WebElement slaoOptions = getDriver().findElement(By.xpath("//*[@data-value='" + slaOptions + "']"));
		click(slaoOptions);
		return this;

	}

	public AccountsPage clickActiveDropDown() {
		clickUsingJs(locateElement("xpath", prop.getProperty("accounts.activedropdown.xpath")));
		return this;
	}

	public AccountsPage selectActiveOption(String activeOptions) {
		WebElement activeOption = getDriver().findElement(By.xpath("//span[@title='" + activeOptions + "']"));
		click(activeOption);
		return this;

	}

	public AccountsPage enterPhoneNumber(String mobileNumber) {
		clickUsingJs(locateElement("xpath", prop.getProperty("accounts.phonenumber.xpath")));
		type(locateElement("xpath", prop.getProperty("accounts.phonenumber.xpath")), mobileNumber);
		return this;
	}

	public AccountsPage validatePhoneNumber(String mobileNumber) {
		Assert.assertEquals(mobileNumber,
				getTextMessage(locateElement("xpath", prop.getProperty("accounts.phonenumberfirstrow.xpath"))));
		return this;

	}

	public AccountsPage clickDeleteButton() {
		click(locateElement("xpath", prop.getProperty("accounts.deleteBtn.xpath")));
		return this;
	}

	public AccountsPage acceptDelete() {
		click(locateElement("xpath", prop.getProperty("accounts.acceptDelete.xpath")));
		return this;
	}

	public AccountsPage deleteSnackBarMessage(String noItems) {
		waitUntilElementLocated("xpath", prop.getProperty("opportunities.snackbarmsg.xpath"));
		WebElement noItemsMsg = getDriver().findElement(By.xpath("//span[text()='" + noItems + "']"));
		Assert.assertTrue(verifyDisplayed(noItemsMsg));
		return this;
	}

}
