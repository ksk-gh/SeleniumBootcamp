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
	public void tc004(String userName, String passWord, String accountName, String ownership, String snackMsg) throws InterruptedException {

		/*if (driver.getTitle().contains("Developer Edition")) {
			driver.findElement(By.xpath("//*[@class='switch-to-lightning']")).click();
		}*/
		// String accountName="Sankarakarthikeyan";

		// 2. Click on toggle menu button from the left corner
		
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
		
		
		
		
		

		/*
		 * driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		 * 
		 * // 3. Click view All and click Sales from App Launcher
		 * 
		 * driver.findElement(By.xpath("//button[text()='View All']")).click();
		 * driver.findElement(By.xpath("//*[text()='Sales']")).click();
		 * Thread.sleep(2000);
		 * 
		 * WebElement accountsLink =
		 * driver.findElement(By.xpath("//a[@title='Accounts']")); // JavascriptExecutor
		 * executor = (JavascriptExecutor)driver;
		 * executor.executeScript("arguments[0].click();", accountsLink);
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath("//div[@title='New']")).click();
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(accountName);
		 * 
		 * WebElement ownershipTextbox =
		 * driver.findElement(By.xpath("//button[contains(@aria-label,'Ownership')]"));
		 * executor.executeScript("arguments[0].click();", ownershipTextbox);
		 * 
		 * WebElement publicDropdownValue =
		 * driver.findElement(By.xpath("//*[@data-value='Public']"));
		 * 
		 * executor.executeScript("arguments[0].click();", publicDropdownValue);
		 * 
		 * Thread.sleep(2000);
		 * 
		 * driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		 * WebElement snackBar =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath(
		 * "//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText']"
		 * ))); System.out.println(snackBar.getText());
		 * 
		 * Thread.sleep(3000); String getAccountName =
		 * driver.findElement(By.xpath("(//*[@class='custom-truncate'])[1]")).getText();
		 * // System.out.println("Got the Account Name: "+getAccountName);
		 * Assert.assertEquals(accountName, getAccountName);
		 */
	}
}
