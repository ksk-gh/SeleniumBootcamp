package com.salesforce.cases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.salesforce.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC010_DeleteWorkType extends ProjectSpecificMethods {

	@BeforeTest
	public void setData() {
		excelFileName = "TC010";
		testCaseName="TC010_DeleteWorkType";
		testDescription="Login to Salesforce and Delete a worktype";
		testNodes="Worktypes";
		category="Regression";
		author="KSK";
	}

	@Test(dataProvider = "Dynamic_Data", enabled = true)
	public void tc010(String username, String password,String snackBarText) {
		
	
		
		LoginPage loginPage = new LoginPage();

		loginPage.enterUserName(username)
		.enterPassword(password)
		.clickLogin()
		.clickAppLauncher()
		.clickViewAll()
		.clickWorkTypesLink()
		.clickOnFirstElement()
		.clickDeleteButton()
		.acceptDelete()
		.validateSnackBarMsgContains(snackBarText)
		;
		
		
		/*
		 * 
		 * 
		 * 
		 * 
		 * 
		 * driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		 * 
		 * driver.findElement(By.xpath("//button[text()='View All']")).click();
		 * 
		 * WebElement workTypesLink = driver .findElement(By.
		 * xpath("//*[contains(@class,'slds-truncate') and text()='Work Types']"));
		 * 
		 * driver.executeScript("arguments[0].click();", workTypesLink);
		 * 
		 * driver.findElement(By.xpath("//tbody/tr[1]/td[5]//a")).click();
		 * 
		 * driver.findElement(By.xpath("//a[@title='Delete']")).click();
		 * 
		 * driver.findElement(By.xpath("//button[@title='Delete']")).click();
		 * 
		 * WebElement snackBar =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath(
		 * "//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText']"
		 * ))); String getDeletedText = snackBar.getText();
		 * System.out.println(getDeletedText);
		 * Assert.assertTrue(getDeletedText.contains(snackBarText));
		 */

	}
}
