package com.salesforce.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.salesforce.base.BaseClass;
import com.salesforce.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC007_CreateWorkType extends ProjectSpecificMethods {

	@BeforeTest
	public void setData() {
		excelFileName = "TC007";
	}

	@Test(dataProvider = "Dynamic_Data", enabled = true)
	public void tc007(String username, String password, String projectName, String textArea, String shift,
			String shiftTimings, String snackBarMsg) {

		/*
		 * if (driver.getTitle().contains("Developer Edition")) {
		 * driver.findElement(By.xpath("//*[@class='switch-to-lightning']")).click(); }
		 * driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		 * 
		 * driver.findElement(By.xpath("//button[text()='View All']")).click();
		 */

		LoginPage loginPage = new LoginPage();

		loginPage.enterUserName(username)
		.enterPassword(password)
		.clickLogin()
		.clickAppLauncher()
		.clickViewAll()
		.clickWorkTypesLink()
		.clickNewButton()
		.enterWorkTypeName(projectName)
		.enterDescription(textArea)
		.clickOnOperatingHoursTxtBx()
		.clickOnOperatingHoursLink()
		.enterShitName(shift)
		.clickOperatingHoursSaveButton()
		.waitUntilInviisiblityOfSnackBar()
		.enterEstimatedDuration(shiftTimings)
		.clickSaveButtonWorktype()
		.validateSnackBar(snackBarMsg);

		/*
		 * WebElement workTypesLink = driver .findElement(By.
		 * xpath("//*[contains(@class,'slds-truncate') and text()='Work Types']"));
		 * 
		 * executor.executeScript("arguments[0].click();", workTypesLink);
		 * 
		 * driver.findElement(By.xpath("//div[@title='New']")).click();
		 * 
		 * driver.findElement(By.
		 * xpath("//label/span[text()='Work Type Name']/following::input[1]")).sendKeys(
		 * projectName); driver.findElement(By.xpath(
		 * "//span[text()='Description']/parent::label/following-sibling::textarea"))
		 * .sendKeys(textArea);
		 * 
		 * driver.findElement(By.xpath("//*[@placeholder='Search Operating Hours...']"))
		 * .click(); WebElement operatingHoursLInk = wait
		 * .until(ExpectedConditions.visibilityOfElementLocated(By.
		 * xpath("//span[@title='New Operating Hours']"))); operatingHoursLInk.click();
		 * 
		 * // span[text()='Name']/parent::label/following-sibling::input WebElement
		 * nameTextbox = wait.until(ExpectedConditions
		 * .visibilityOfElementLocated(By.xpath(
		 * "//span[text()='Name']/parent::label/following-sibling::input")));
		 * nameTextbox.sendKeys(shift);
		 * driver.findElement(By.xpath("(//*[@title='Save'])[2]")).click();
		 * 
		 * 
		 * WebElement snackBar1 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "(//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText'])[2]"
		 * )));
		 * 
		 * String getSnackBar1 =driver.findElement(By.xpath(
		 * "(//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText'])[2]"
		 * )).getText();
		 * 
		 * 
		 * 
		 * Assert.assertEquals(snackBarMsg1, getSnackBar1);
		 * 
		 * 
		 * // wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(
		 * "(//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText'])[2]"
		 * ))));
		 * 
		 * wait.until(ExpectedConditions.invisibilityOfElementLocated( By.xpath(
		 * "(//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText'])[2]"
		 * )));
		 * 
		 * WebElement estimatedDuration =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated( By.
		 * xpath("//span[text()='Estimated Duration']/parent::label/following-sibling::input"
		 * ))); estimatedDuration.sendKeys("7");
		 * 
		 * driver.findElement(By.xpath("(//*[@title='Save'])[1]")).click();
		 * 
		 * WebElement snackBar2 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath(
		 * "(//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText'])[1]"
		 * ))); String getSnackBar2 = snackBar2.getText();
		 * 
		 * Assert.assertEquals(snackBarMsg2, getSnackBar2);
		 */
	}
}
