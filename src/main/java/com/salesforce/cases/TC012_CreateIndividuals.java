package com.salesforce.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC012_CreateIndividuals extends BaseClass {

	@BeforeTest
	public void setData() {
		excelFileName = "TC012";
	}

	@Test(dataProvider = "Dynamic_Data",enabled = true)
	public void tc012() {

		String toastMessage = "Individual \"Kadirvelan\" was created.";

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		driver.findElement(By.xpath("//button[text()='View All']")).click();

		WebElement individualLink = driver
				.findElement(By.xpath("//*[contains(@class,'slds-truncate') and text()='Individuals']"));

		executor.executeScript("arguments[0].click();", individualLink);

		driver.findElement(By.xpath("(//*[@title='Individuals']/parent::*//div)[1]")).click();
		WebElement newIndividualLink = driver.findElement(By.xpath("//span[text()='New Individual']"));
		executor.executeScript("arguments[0].click();", newIndividualLink);

		driver.findElement(By.xpath("//label/span[text()='Last Name']/following::input[1]")).sendKeys("Kadirvelan");

		driver.findElement(By.xpath("(//*[@title='Save'])[1]")).click();

		WebElement snackBar = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText'])[1]")));
		String snackMessage = snackBar.getText();
		System.out.println(snackMessage);

		Assert.assertEquals(toastMessage, snackMessage);

	}
}
