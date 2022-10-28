package com.salesforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.salesforce.base.ProjectSpecificMethods;

public class AccountsPage extends ProjectSpecificMethods {

	public AccountsPage clickNewButton() {

		driver.findElement(By.xpath(prop.getProperty("accounts.newbtn.xpath"))).click();
		return this;

	}

	public AccountsPage sendAccountName(String accountName) {
		driver.findElement(By.xpath(prop.getProperty("accounts.name.xpath"))).sendKeys(accountName);
		return this;
	}

	public AccountsPage clickOwnershipTxtBx() {
		WebElement ownershipTextbox = driver.findElement(By.xpath(prop.getProperty("accounts.ownershiptxtbx.xpath")));
		driver.executeScript("arguments[0].click();", ownershipTextbox);
		return this;
	}

	public AccountsPage selectOwnershipOption(String ownership) {
		WebElement publicDropdownValue = driver.findElement(By.xpath("//*[@data-value='" + ownership + "']"));

		driver.executeScript("arguments[0].click();", publicDropdownValue);
		return this;
	}

	public AccountsPage clickSaveButton() {
		WebElement saveButton = driver.findElement(By.xpath(prop.getProperty("accounts.savebtn.xpath")));
		saveButton.click();
		return this;
	}

	public AccountsPage validateSnackBarMsg(String snackBarMsg) {
		WebElement snackBar = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(prop.getProperty("accounts.snackbarmsg.xpath"))));
		String getSnackBarMsg = snackBar.getText();
		Assert.assertEquals(snackBarMsg, getSnackBarMsg);
		return this;
	}

	public AccountsPage validateAccountName(String accountName) {
		String getAccountName = driver.findElement(By.xpath(prop.getProperty("accounts.getAccountName.xpath")))
				.getText();
		// System.out.println("Got the Account Name: "+getAccountName);
		Assert.assertEquals(accountName, getAccountName);
		return this;
	}

	public AccountsPage searchAccounts(String accountName) {
		driver.findElement(By.xpath(prop.getProperty("accounts.accountssearch.xpath"))).sendKeys(accountName, Keys.ENTER);
		return this;
	}

	public AccountsPage clickOnFirstSearchElement() {

		wait.until(ExpectedConditions
				.stalenessOf(driver.findElement(By.xpath(prop.getProperty("accounts.firstSearchedElement.xpath")))));

		WebElement firstElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(prop.getProperty("accounts.firstSearchedElement.xpath"))));

		firstElement.click();
		return this;
	}

	
	public AccountsPage clickRefreshButton() {
		WebElement refreshButton = driver.findElement(By.xpath(prop.getProperty("accounts.refreshbtn.xpath")));
		driver.executeScript("arguments[0].click();", refreshButton);
		//refreshButton.click();
		return this;

	}
	
	
	public AccountsPage clickOnEditButton() {
		driver.findElement(By.xpath(prop.getProperty("accounts.editBtn.xpath"))).click();
		return this;
	}

	public AccountsPage clickOnTypeDropdown() {
		WebElement typeDropdown = driver.findElement(By.xpath(prop.getProperty("accounts.typedropdown.xpath")));
		driver.executeScript("arguments[0].click();", typeDropdown);
		return this;
	}

	public AccountsPage selectTypeOptions(String typeOptions) {
		driver.findElement(By.xpath("//*[@title='" + typeOptions + "']")).click();
		return this;

	}

	public AccountsPage clickOnIndustryDropdown() {
		driver.findElement(By.xpath(prop.getProperty("accounts.industrydropdown.xpath"))).click();
		return this;

	}

	public AccountsPage selectIndustryOptions(String industryOptions) {
		driver.findElement(By.xpath("//*[@data-value='" + industryOptions + "']")).click();
		return this;

	}

	public AccountsPage enterBillingStreet(String billStreet) {
		WebElement billingStreet = driver
				.findElement(By.xpath(prop.getProperty("accounts.billingstreet.xpath")));
		billingStreet.clear();
		billingStreet.sendKeys(billStreet);
		return this;
	}

	public AccountsPage enterBillingCity(String billCity) {
		WebElement billingCity = driver
				.findElement(By.xpath(prop.getProperty("accounts.billingcity.xpath")));
		billingCity.clear();
		billingCity.sendKeys(billCity);
		return this;

	}

	public AccountsPage enterBillingZipCode(String billZipcode) {
		WebElement billingZipCode = driver
				.findElement(By.xpath(prop.getProperty("accounts.billingzipcode.xpath")));
		billingZipCode.clear();
		billingZipCode.sendKeys(billZipcode);
		return this;

	}

	public AccountsPage enterBillingState(String billState) {
		WebElement billingState = driver
				.findElement(By.xpath(prop.getProperty("accounts.billingstate.xpath")));
		billingState.clear();
		billingState.sendKeys(billState);
		return this;

	}

	public AccountsPage enterBillingCountry(String billCountry) {
		WebElement billingCountry = driver
				.findElement(By.xpath(prop.getProperty("accounts.billingcountry.xpath")));
		billingCountry.clear();
		billingCountry.sendKeys(billCountry);
		return this;
	}

	public AccountsPage enterShippingStreet(String shipStreet) {
		WebElement shippingStreet = driver.findElement(
				By.xpath(prop.getProperty("accounts.shippingstreet.xpath")));
		shippingStreet.clear();
		shippingStreet.sendKeys(shipStreet);
		return this;
	}

	public AccountsPage enterShippingCity(String shipCity) {
		WebElement shippingCity = driver
				.findElement(By.xpath(prop.getProperty("accounts.shippingcity.xpath")));
		shippingCity.clear();
		shippingCity.sendKeys(shipCity);
		return this;

	}

	public AccountsPage enterShippingZipCode(String shipZipcode) {
		WebElement shippingZipCode = driver
				.findElement(By.xpath(prop.getProperty("accounts.shippingzipcode.xpath")));
		shippingZipCode.clear();
		shippingZipCode.sendKeys(shipZipcode);
		return this;

	}

	public AccountsPage enterShippingState(String shipState) {
		WebElement shippingState = driver
				.findElement(By.xpath(prop.getProperty("accounts.shippingstate.xpath")));
		shippingState.clear();
		shippingState.sendKeys(shipState);
		return this;

	}

	public AccountsPage enterShippingCountry(String shipCountry) throws InterruptedException {
		WebElement shippingCountry = driver
				.findElement(By.xpath(prop.getProperty("accounts.shippingcountry.xpath")));
		shippingCountry.clear();
		shippingCountry.sendKeys(shipCountry, Keys.TAB);
		Thread.sleep(1000);
		return this;
	}

	public AccountsPage clickOnCustomerPriority() {
		driver.findElement(By.xpath(prop.getProperty("accounts.customerpriority.xpath"))).click();
		return this;
	}

	public AccountsPage selectCustomerPriorityOptions(String priorityOptions) {
		driver.findElement(By.xpath("//*[@data-value='" + priorityOptions + "']")).click();
		return this;

	}

	public AccountsPage clickOnSlaDropDown() {
		driver.findElement(By.xpath(prop.getProperty("accounts.slapriority.xpath"))).click();
		return this;
	}

	public AccountsPage selectSlaOptions(String slaOptions) {
		driver.findElement(By.xpath("//*[@data-value='" + slaOptions + "']")).click();
		return this;

	}

	public AccountsPage clickActiveDropDown() {

		WebElement activeDropdown = driver.findElement(By.xpath(prop.getProperty("accounts.activedropdown.xpath")));

		driver.executeScript("arguments[0].click();", activeDropdown);
	//	driver.findElement(By.xpath("//span[@title='No']")).click();
		return this;
	}

	public AccountsPage selectActiveOption(String activeOptions) {
		driver.findElement(By.xpath("//span[@title='" + activeOptions + "']")).click();
		return this;

	}
	

	public AccountsPage enterPhoneNumber(String mobileNumber) {

		WebElement phoneNumber = driver.findElement(By.xpath(prop.getProperty("accounts.phonenumber.xpath")));
		driver.executeScript("arguments[0].click();", phoneNumber);
		phoneNumber.clear();
		phoneNumber.sendKeys(mobileNumber);
		return this;
	}


	public AccountsPage validatePhoneNumber(String mobileNumber) {
		String getPhoneNumber = driver.findElement(By.xpath(prop.getProperty("accounts.phonenumberfirstrow.xpath"))).getText();

		Assert.assertEquals(mobileNumber, getPhoneNumber);
		return this;

	}
	
	public AccountsPage clickDeleteButton() {
		driver.findElement(By.xpath(prop.getProperty("accounts.deleteBtn.xpath"))).click();
		return this;
	}

	public AccountsPage acceptDelete() {
		driver.findElement(By.xpath(prop.getProperty("accounts.acceptDelete.xpath"))).click();
		return this;
	}
	

	public AccountsPage deleteSnackBarMessage(String noItems) {
		WebElement snackBar = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(prop.getProperty("accounts.snackbarmsg.xpath"))));
		System.out.println(snackBar.getText());
		boolean displayed = driver.findElement(By.xpath("//span[text()='" + noItems + "']")).isDisplayed();
		Assert.assertTrue(displayed);
		return this;
	}
	
	
	
}
