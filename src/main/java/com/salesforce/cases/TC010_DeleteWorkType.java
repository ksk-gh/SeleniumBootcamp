package com.salesforce.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.salesforce.base.BaseClass;

public class TC010_DeleteWorkType extends BaseClass {

	@BeforeTest
	public void setData() {
		excelFileName = "TC010";
	}

	@Test(dataProvider = "Dynamic_Data", enabled = true)
	public void tc010(String snackBarText) {
		
		if (driver.getTitle().contains("Developer Edition")) {
			driver.findElement(By.xpath("//*[@class='switch-to-lightning']")).click();
		}

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		driver.findElement(By.xpath("//button[text()='View All']")).click();

		WebElement workTypesLink = driver
				.findElement(By.xpath("//*[contains(@class,'slds-truncate') and text()='Work Types']"));

		executor.executeScript("arguments[0].click();", workTypesLink);

		driver.findElement(By.xpath("//tbody/tr[1]/td[5]//a")).click();

		driver.findElement(By.xpath("//a[@title='Delete']")).click();

		driver.findElement(By.xpath("//button[@title='Delete']")).click();

		WebElement snackBar = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText']")));
		String getDeletedText = snackBar.getText();
		System.out.println(getDeletedText);
		Assert.assertTrue(getDeletedText.contains(snackBarText));

	}
}
