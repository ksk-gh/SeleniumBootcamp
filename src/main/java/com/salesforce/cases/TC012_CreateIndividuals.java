package com.salesforce.cases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.salesforce.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC012_CreateIndividuals extends ProjectSpecificMethods {

	@BeforeTest
	public void setData() {
		excelFileName = "TC012";
		testCaseName="TC012_CreateIndividual";
		testDescription="Login to Salesforce and Create an Individuals";
		testNodes="Individuals";
		category="Regression";
		author="KSK";
	}

	@Test(dataProvider = "Dynamic_Data", enabled = true)
	public void tc012(String username, String password, String lName, String toastMessage) {

		LoginPage login = new LoginPage();

		login.enterUserName(username)
		.enterPassword(password)
		.clickLogin()
		.clickAppLauncher()
		.clickViewAll()
		.clickIndividualsLink()
		.clickDownArrow()
		.clickNewIndividualLink()
		.enterlastName(lName)
		.clickSaveButton()
		.validateSnackBarMsg(toastMessage);

		/*
		 * if (driver.getTitle().contains("Developer Edition")) {
		 * driver.findElement(By.xpath("//*[@class='switch-to-lightning']")).click(); }
		 */

		// String toastMessage = "Individual \"Kadirvelan\" was created.";

		/*
		 * driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		 * 
		 * driver.findElement(By.xpath("//button[text()='View All']")).click();
		 * 
		 * WebElement individualLink = driver .findElement(By.
		 * xpath("//*[contains(@class,'slds-truncate') and text()='Individuals']"));
		 * 
		 * executor.executeScript("arguments[0].click();", individualLink);
		 * 
		 * driver.findElement(By.xpath("(//*[@title='Individuals']/parent::/div)[1]")).
		 * click(); WebElement newIndividualLink =
		 * driver.findElement(By.xpath("//span[text()='New Individual']"));
		 * executor.executeScript("arguments[0].click();", newIndividualLink);
		 * 
		 * driver.findElement(By.
		 * xpath("//label/span[text()='Last Name']/following::input[1]")).sendKeys(lName
		 * );
		 * 
		 * driver.findElement(By.xpath("(//*[@title='Save'])[1]")).click();
		 * 
		 * WebElement snackBar =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath(
		 * "(//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText'])[1]"
		 * ))); String snackMessage = snackBar.getText();
		 * System.out.println(snackMessage);
		 * 
		 * Assert.assertEquals(toastMessage, snackMessage);
		 */
	}
}
