package com.salesforce.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC014_DeleteIndividuals extends BaseClass {

	@BeforeTest
	public void setData() {
		excelFileName = "TC014";
	}

	@Test (dataProvider = "Dynamic_Data",enabled = true)
	public void tc014(String lastName) throws InterruptedException {

		//String firstName = "Sankarakarthi";

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		driver.findElement(By.xpath("//button[text()='View All']")).click();

		WebElement individualLink = driver
				.findElement(By.xpath("//p[contains(@class,'slds-truncate') and text()='Individuals']"));

		executor.executeScript("arguments[0].click();", individualLink);

		WebElement individualsMenuLink = driver.findElement(By.xpath("//*[@title='Not added to nav bar']/parent::a"));

		executor.executeScript("arguments[0].click();", individualsMenuLink);

		driver.findElement(By.xpath("//*[@class='slds-input']")).sendKeys(lastName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h1/span[text()='Recently Viewed']")).click();

		Thread.sleep(2000);

		WebElement clickDropDown = driver.findElement(By.xpath("//tbody/tr[1]/td[6]/span/div/a"));
		executor.executeScript("arguments[0].click();", clickDropDown);
		Thread.sleep(2000);

		WebElement deleteButton = driver.findElement(By.xpath("//a[@title='Delete']/parent::li"));
		deleteButton.click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@title='Delete']")).click();
		

		/*
		 * WebElement snackBar =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath(
		 * "(//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText'])[1]"
		 * ))); String snackMessage = snackBar.getText();
		 * System.out.println(snackMessage.contains(firstName));
		 * Assert.assertTrue(snackMessage.contains(firstName));
		 */
		
	//	boolean displayed = driver.findElement(By.xpath("//span[text()='No items to display.']"))
		WebElement noItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='No items to display.']")));
				
		boolean displayed = noItem.isDisplayed();
		Assert.assertTrue(displayed);
		
	}
}
