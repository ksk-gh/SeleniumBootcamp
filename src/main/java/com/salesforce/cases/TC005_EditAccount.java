package com.salesforce.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.salesforce.base.BaseClass;
import com.salesforce.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC005_EditAccount extends ProjectSpecificMethods {
	@BeforeTest
	public void setData() {
		excelFileName = "TC005";
	}

	@Test(dataProvider = "Dynamic_Data", enabled = true)
	public void tc005(String userName, String password, String accountName, String typeOptions,String industryOptions, String mobileNumber, String billStreet, String billCity, String billZipcode,
			String billState, String billCountry, String shipStreet, String shipCity, String shipZipcode,
			String shipState, String shipCountry, String priorityOptions, String slaOptions, String activeOptions, String snackMsg) throws InterruptedException {

		/*
		 * driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		 * 
		 * // 3. Click view All and click Sales from App Launcher
		 * 
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.
		 * xpath("//button[text()='View All']"))).click();
		 * driver.findElement(By.xpath("//*[text()='Sales']")).click();
		 * Thread.sleep(2000);
		 * 
		 * WebElement accountsLink =
		 * driver.findElement(By.xpath("//a[@title='Accounts']")); // JavascriptExecutor
		 * executor = (JavascriptExecutor)driver;
		 * executor.executeScript("arguments[0].click();", accountsLink);
		 * Thread.sleep(2000);
		 * 
		 * 
		 */
		
		
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
		
		

		/*
		 * driver.findElement(By.xpath("//input[@name='Account-search-input']")).
		 * sendKeys(accountName, Keys.ENTER);
		 * 
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath("//button[@name='refreshButton']")).click(); //
		 * Thread.sleep(1000);
		 * wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(
		 * "//tbody/tr[1]/td[6]//a"))));
		 * 
		 * WebElement firstElement = wait
		 * .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//tbody/tr[1]/td[6]//a")));
		 * 
		 * firstElement.click(); //
		 * driver.findElement(By.xpath("//tbody/tr[1]/td[6]//a")); Thread.sleep(1000);
		 * 
		 * driver.findElement(By.xpath("//a[@title='Edit']")).click();
		 * 
		 * WebElement typeDropdown =
		 * driver.findElement(By.xpath("//*[text()='Type']/following::div[1]//button"));
		 * executor.executeScript("arguments[0].click();", typeDropdown);
		 * 
		 * driver.findElement(By.xpath("//*[@title='Technology Partner']")).click();
		 * 
		 * driver.findElement(By.xpath(
		 * "//*[text()='Industry']/following::div[1]//button")).click(); //
		 * industryDropdown.click();
		 * driver.findElement(By.xpath("//*[@data-value='Healthcare']")).click();
		 * WebElement billingStreet = driver .findElement(By.
		 * xpath("//*[text()='Billing Street']/following-sibling::div//textarea[@name='street']"
		 * )); billingStreet.clear(); billingStreet.sendKeys(billStreet);
		 * 
		 * WebElement billingCity = driver .findElement(By.
		 * xpath("//*[text()='Billing City']/following-sibling::div/input"));
		 * billingCity.clear(); billingCity.sendKeys(billCity);
		 * 
		 * WebElement billingZipCode = driver .findElement(By.
		 * xpath("//*[contains(text(),'Billing Zip')]/following-sibling::div/input"));
		 * billingZipCode.clear(); billingZipCode.sendKeys(billZipcode);
		 * 
		 * WebElement billingState = driver .findElement(By.
		 * xpath("//*[contains(text(),'Billing State')]/following-sibling::div/input"));
		 * billingState.clear(); billingState.sendKeys(billState);
		 * 
		 * WebElement billingCountry = driver .findElement(By.
		 * xpath("//*[text()='Billing Country']/following-sibling::div/input"));
		 * billingCountry.clear(); billingCountry.sendKeys(billCountry);
		 * 
		 * WebElement shippingStreet = driver.findElement( By.
		 * xpath("//*[text()='Shipping Street']/following-sibling::div//textarea[@name='street'][1]"
		 * )); shippingStreet.clear(); shippingStreet.sendKeys(shipStreet);
		 * 
		 * WebElement shippingCity = driver .findElement(By.
		 * xpath("//*[text()='Shipping City']/following-sibling::div/input"));
		 * shippingCity.clear(); shippingCity.sendKeys(shipCity);
		 * 
		 * WebElement shippingZipcode = driver .findElement(By.
		 * xpath("//*[contains(text(),'Shipping Zip')]/following-sibling::div/input"));
		 * shippingZipcode.clear(); shippingZipcode.sendKeys(shipZipcode);
		 * 
		 * WebElement shippingState = driver .findElement(By.
		 * xpath("//*[contains(text(),'Shipping State')]/following-sibling::div/input"))
		 * ; shippingState.clear(); shippingState.sendKeys(shipState);
		 * 
		 * WebElement shippingCountry = driver .findElement(By.
		 * xpath("//*[text()='Shipping Country']/following-sibling::div/input"));
		 * shippingCountry.clear(); shippingCountry.sendKeys(shipCountry, Keys.TAB);
		 * Thread.sleep(1000);
		 * 
		 * driver.findElement(By.
		 * xpath("//button[contains(@aria-label,'Customer Priority')]")).click();
		 * driver.findElement(By.xpath("//*[@data-value='Low']")).click();
		 * 
		 * driver.findElement(By.xpath("//button[contains(@aria-label,'SLA,')]")).click(
		 * ); driver.findElement(By.xpath("//*[@data-value='Silver']")).click();
		 * 
		 * WebElement activeDropdown =
		 * driver.findElement(By.xpath("//button[contains(@aria-label,'Active')]"));
		 * 
		 * executor.executeScript("arguments[0].click();", activeDropdown);
		 * driver.findElement(By.xpath("//span[@title='No']")).click();
		 * 
		 * WebElement phoneNumber = driver.findElement(By.xpath(
		 * "//label[text()='Phone']/following-sibling::div/input"));
		 * executor.executeScript("arguments[0].click();", phoneNumber);
		 * phoneNumber.clear(); phoneNumber.sendKeys(mobileNumber);
		 * 
		 * driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		 * 
		 * WebElement snackBar =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath(
		 * "//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText']"
		 * ))); System.out.println(snackBar.getText());
		 * 
		 * Thread.sleep(2000); String getPhoneNumber =
		 * driver.findElement(By.xpath("//tbody/tr[1]/td[4]")).getText();
		 * 
		 * Assert.assertEquals(mobileNumber, getPhoneNumber);
		 */
	}
}
