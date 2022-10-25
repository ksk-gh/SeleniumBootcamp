package com.salesforce.cases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.salesforce.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC003_DeleteOpportunity extends ProjectSpecificMethods {

	@BeforeTest
	public void setData() {
		excelFileName = "TC003";
	}

	@Test(dataProvider = "Dynamic_Data", enabled = true)
	public void tc003(String userName, String passWord, String enterOpportunity, String noItemText) throws InterruptedException {

		

		LoginPage login = new LoginPage();
		
		login.enterUserName(userName)
		.enterPassword(passWord)
		.clickLogin()
		.clickAppLauncher()
		.clickViewAll()
		.clickSalesLink()
		.clickOpportunityLink()
		.searchOpportunity(enterOpportunity)
		.clickRefreshButton()
		.clickOnFirstSearchElement()
		.clickDeleteButton()
		.acceptDelete()
		.deleteSnackBarMessage(noItemText);
		
		
		/*
		 * driver.findElement(By.xpath("//tbody/tr[1]/td[8]//a")).click();
		 * driver.findElement(By.xpath("//a[@title='Delete']")).click();
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath("//button[@title='Delete']")).click(); WebElement
		 * snackBar = wait.until(ExpectedConditions.visibilityOfElementLocated(
		 * By.xpath(
		 * "//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText']"
		 * ))); System.out.println(snackBar.getText()); boolean displayed =
		 * driver.findElement(By.xpath("//span[text()='No items to display.']")).
		 * isDisplayed(); Assert.assertTrue(displayed);
		 */
	}

}
