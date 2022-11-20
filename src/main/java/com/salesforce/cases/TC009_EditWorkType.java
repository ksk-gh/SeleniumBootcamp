package com.salesforce.cases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.salesforce.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC009_EditWorkType extends ProjectSpecificMethods {
	@BeforeTest
	public void setData() {
		excelFileName = "TC009";
		testCaseName="TC009_EditWorkType";
		testDescription="Login to Salesforce and Edit worktype Positive scenario";
		testNodes="Worktypes";
		category="Regression";
		author="KSK";
		
	}

	@Test(dataProvider = "Dynamic_Data", enabled = true)
	public void tc009(String username, String password, String startTime, String endTime) {

		
		LoginPage loginPage = new LoginPage();

		loginPage.enterUserName(username)
		.enterPassword(password)
		.clickLogin()
		.clickAppLauncher()
		.clickViewAll()
		.clickWorkTypesLink()
		.clickOnFirstElement()
		.clickEditButton()
		.enterStartDay(startTime)
		.enterEndDay(endTime)
		.clickSaveButtonWorktype()
		.getSnackBarMessage();
		
		
		
		
		
		
		
		/*
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
		 * driver.findElement(By.xpath("//a[@title='Edit']")).click();
		 * driver.findElement(By.
		 * xpath("//span[text()='Timeframe Start']/parent::label/following-sibling::input"
		 * )).clear(); driver.findElement(By.
		 * xpath("//span[text()='Timeframe Start']/parent::label/following-sibling::input"
		 * )) .sendKeys(startTime);// ("9"); driver.findElement(By.
		 * xpath("//span[text()='Timeframe End']/parent::label/following-sibling::input"
		 * )).clear();
		 * 
		 * driver.findElement(By.
		 * xpath("//span[text()='Timeframe End']/parent::label/following-sibling::input"
		 * )) .sendKeys(endTime);// ("18");
		 * 
		 * // span[text()='Timeframe Start']/parent::label/following-sibling::input
		 * driver.findElement(By.xpath("(//*[@title='Save'])[1]")).click();
		 * 
		 * WebElement snackBar =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath(
		 * "(//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText'])[1]"
		 * ))); System.out.println(snackBar.getText());
		 */

	}
}
