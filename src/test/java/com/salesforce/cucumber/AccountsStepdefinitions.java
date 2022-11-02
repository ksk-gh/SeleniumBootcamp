package com.salesforce.cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountsStepdefinitions extends Base {

	public void clickNewButton() {

		driver.findElement(By.xpath("//div[@title='New']")).click();
	}

	@And("Enter the accounts name as {string}")
	public void enterAccountName(String accountName) {
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(accountName);

	}

	@And("Click on the Ownership textbox")
	public void clickOwnershipTxtBx() {
		WebElement ownershipTextbox = driver.findElement(By.xpath("//button[contains(@aria-label,'Ownership')]"));
		driver.executeScript("arguments[0].click();", ownershipTextbox);

	}

	@And("Select the Ownership option as {string}")
	public void selectOwnershipOption(String ownership) {
		WebElement publicDropdownValue = driver.findElement(By.xpath("//*[@data-value='" + ownership + "']"));

		driver.executeScript("arguments[0].click();", publicDropdownValue);

	}

	@When("Click on the Save button to save the Accounts")
	public void clickSaveButton() {
		WebElement saveButton = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
		saveButton.click();

	}

	@Then("Validate the accounts snackbar value {string}")
	public void validateSnackBarMsg(String snackBarMsg) {
		WebElement snackBar = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText']")));
		String getSnackBarMsg = snackBar.getText();
		Assert.assertEquals(snackBarMsg, getSnackBarMsg);

	}

	public void validateAccountName(String accountName) {
		String getAccountName = driver.findElement(By.xpath("(//*[@class='custom-truncate'])[1]")).getText();
		// System.out.println("Got the Account Name: "+getAccountName);
		Assert.assertEquals(accountName, getAccountName);

	}

	@Given("Search for the Accounts as {string}")
	public void searchAccounts(String accountName) {
		driver.findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys(accountName, Keys.ENTER);

	}

	@And("Select the first result of Accounts")
	public void clickOnFirstSearchElement() {

		wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//tbody/tr[1]/td[6]//a"))));

		WebElement firstElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[6]//a")));

		firstElement.click();

	}

	@And("Click on the Refresh button in the Accounts search")
	public void clickRefreshButton() {
		WebElement refreshButton = driver.findElement(By.xpath("//button[@name='refreshButton']"));
		driver.executeScript("arguments[0].click();", refreshButton);
		// refreshButton.click();

	}

	@When("Click on the Edit button for Account data")
	public void clickOnEditButton() {
		driver.findElement(By.xpath("//a[@title='Edit']")).click();

	}

	@And("Click on the Type dropdown")
	public void clickOnTypeDropdown() {
		WebElement typeDropdown = driver.findElement(By.xpath("//*[text()='Type']/following::div[1]//button"));
		driver.executeScript("arguments[0].click();", typeDropdown);

	}

	@And("Select type option as {string}")
	public void selectTypeOptions(String typeOptions) {
		driver.findElement(By.xpath("//*[@title='" + typeOptions + "']")).click();
	}

	@And("Click on the Industry dropdown")
	public void clickOnIndustryDropdown() {
		driver.findElement(By.xpath("//*[text()='Industry']/following::div[1]//button")).click();
	}

	@And("Select the industry option as {string}")
	public void selectIndustryOptions(String industryOptions) {
		driver.findElement(By.xpath("//*[@data-value='" + industryOptions + "']")).click();

	}

	@And("Enter the Billing street as {string}")
	public void enterBillingStreet(String billStreet) {
		WebElement billingStreet = driver
				.findElement(By.xpath("//*[text()='Billing Street']/following-sibling::div//textarea[@name='street']"));
		billingStreet.clear();
		billingStreet.sendKeys(billStreet);

	}

	@And("Enter the Billing City as {string}")
	public void enterBillingCity(String billCity) {
		WebElement billingCity = driver
				.findElement(By.xpath("//*[text()='Billing City']/following-sibling::div/input"));
		billingCity.clear();
		billingCity.sendKeys(billCity);

	}

	@And("Enter the Billing zipcode as {string}")
	public void enterBillingZipCode(String billZipcode) {
		WebElement billingZipCode = driver
				.findElement(By.xpath("//*[contains(text(),'Billing Zip')]/following-sibling::div/input"));
		billingZipCode.clear();
		billingZipCode.sendKeys(billZipcode);

	}

	@And("Enter the Billing State as {string}")
	public void enterBillingState(String billState) {
		WebElement billingState = driver
				.findElement(By.xpath("//*[contains(text(),'Billing State')]/following-sibling::div/input"));
		billingState.clear();
		billingState.sendKeys(billState);

	}

	@And("Enter the Billing Country as {string}")
	public void enterBillingCountry(String billCountry) {
		WebElement billingCountry = driver
				.findElement(By.xpath("//*[text()='Billing Country']/following-sibling::div/input"));
		billingCountry.clear();
		billingCountry.sendKeys(billCountry);

	}

	@And("Enter the Shipping street as {string}")
	public void enterShippingStreet(String shipStreet) {
		WebElement shippingStreet = driver.findElement(
				By.xpath("//*[text()='Shipping Street']/following-sibling::div//textarea[@name='street']"));
		shippingStreet.clear();
		shippingStreet.sendKeys(shipStreet);

	}

	@And("Enter the Shipping City as {string}")
	public void enterShippingCity(String shipCity) {
		WebElement shippingCity = driver
				.findElement(By.xpath("//*[text()='Shipping City']/following-sibling::div/input"));
		shippingCity.clear();
		shippingCity.sendKeys(shipCity);

	}

	@And("Enter the Shipping zipcode as {string}")
	public void enterShippingZipCode(String shipZipcode) {
		WebElement shippingZipCode = driver
				.findElement(By.xpath("//*[contains(text(),'Shipping Zip')]/following-sibling::div/input"));
		shippingZipCode.clear();
		shippingZipCode.sendKeys(shipZipcode);

	}

	@And("Enter the Shipping State as {string}")
	public void enterShippingState(String shipState) {
		WebElement shippingState = driver
				.findElement(By.xpath("//*[contains(text(),'Shipping State')]/following-sibling::div/input"));
		shippingState.clear();
		shippingState.sendKeys(shipState);

	}

	@And("Enter the Shipping Country as {string}")
	public void enterShippingCountry(String shipCountry) throws InterruptedException {
		WebElement shippingCountry = driver
				.findElement(By.xpath("//*[text()='Shipping Country']/following-sibling::div/input"));
		shippingCountry.clear();
		shippingCountry.sendKeys(shipCountry, Keys.TAB);
		Thread.sleep(1000);

	}

	@And("Click on the Priority dropdown")
	public void clickOnCustomerPriority() {
		driver.findElement(By.xpath("//button[contains(@aria-label,'Customer Priority')]")).click();

	}

	@And("Select the Priority Option as {string}")
	public void selectCustomerPriorityOptions(String priorityOptions) {
		driver.findElement(By.xpath("//*[@data-value='" + priorityOptions + "']")).click();

	}

	@And("Click on the SLA Dropdown")
	public void clickOnSlaDropDown() {
		driver.findElement(By.xpath("//button[contains(@aria-label,'SLA,')]")).click();

	}

	@And("Select the SLA option as {string}")
	public void selectSlaOptions(String slaOptions) {
		driver.findElement(By.xpath("//*[@data-value='" + slaOptions + "']")).click();

	}

	@And("Click on the Active dropdown")
	public void clickActiveDropDown() {

		WebElement activeDropdown = driver.findElement(By.xpath("//button[contains(@aria-label,'Active')]"));

		driver.executeScript("arguments[0].click();", activeDropdown);
		// driver.findElement(By.xpath("//span[@title='No']")).click();

	}

	@And("Select the Active option as {string}")
	public void selectActiveOption(String activeOptions) {
		driver.findElement(By.xpath("//span[@title='" + activeOptions + "']")).click();

	}

	@And("Enter the Mobile Number as {string}")
	public void enterPhoneNumber(String mobileNumber) {

		WebElement phoneNumber = driver.findElement(By.xpath("//label[text()='Phone']/following-sibling::div/input"));
		driver.executeScript("arguments[0].click();", phoneNumber);
		phoneNumber.clear();
		phoneNumber.sendKeys(mobileNumber);

	}

	public void validatePhoneNumber(String mobileNumber) {
		String getPhoneNumber = driver.findElement(By.xpath("//tbody/tr[1]/td[4]")).getText();

		Assert.assertEquals(mobileNumber, getPhoneNumber);

	}
	@When("User Clicked the Delete button")
	public void clickDeleteButton() {
		driver.findElement(By.xpath("//a[@title='Delete']")).click();

	}
	@And("Accepts the Delete")
	public void acceptDelete() {
		driver.findElement(By.xpath("//button[@title='Delete']")).click();

	}

	public void deleteSnackBarMessage(String noItems) {
		WebElement snackBar = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText']")));
		System.out.println(snackBar.getText());
		boolean displayed = driver.findElement(By.xpath("//span[text()='" + noItems + "']")).isDisplayed();
		Assert.assertTrue(displayed);

	}

}
