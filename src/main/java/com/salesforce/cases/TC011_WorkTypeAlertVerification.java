package com.salesforce.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.salesforce.base.BaseClass;

public class TC011_WorkTypeAlertVerification extends BaseClass {

	@BeforeTest
	public void setData() {
		excelFileName = "TC011";
	}

	@Test(dataProvider = "Dynamic_Data", enabled = true)
	public void tc011(String workTpe, String reviewMsgTxt, String mainErrorMsg, String fieldErrorMsg) {

		if (driver.getTitle().contains("Developer Edition")) {
			driver.findElement(By.xpath("//*[@class='switch-to-lightning']")).click();
		}

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		driver.findElement(By.xpath("//button[text()='View All']")).click();

		WebElement workTypesLink = driver
				.findElement(By.xpath("//*[contains(@class,'slds-truncate') and text()='Work Types']"));

		executor.executeScript("arguments[0].click();", workTypesLink);

		driver.findElement(By.xpath("//div[@title='New']")).click();

		driver.findElement(By.xpath("//label/span[text()='Work Type Name']/following::input[1]")).sendKeys(workTpe);

		driver.findElement(By.xpath("(//*[@title='Save'])[1]")).click();
		WebElement errorMessage = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pageLevelErrors']//span")));
		String reviewText = errorMessage.getText();
		System.out.println(reviewText);
		Assert.assertEquals(reviewMsgTxt, reviewText);

		WebElement errorMessageText = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pageLevelErrors']//li")));
		String errormessagevalue = errorMessageText.getText();
		System.out.println(errormessagevalue);
		Assert.assertEquals(mainErrorMsg, errormessagevalue);

		String getFieldError = driver
				.findElement(By.xpath(
						"//span[text()='Estimated Duration']/ancestor::div[contains(@class,'slds-hint-parent')]//ul"))
				.getText();
		Assert.assertEquals(fieldErrorMsg, getFieldError);

	}
}
