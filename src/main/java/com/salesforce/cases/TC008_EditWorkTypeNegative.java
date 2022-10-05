package com.salesforce.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC008_EditWorkTypeNegative extends BaseClass {

	@BeforeTest
	public void setData() {
		excelFileName = "TC008";
	}

	@Test(dataProvider = "Dynamic_Data", enabled = true)
	public void tc008(String startTime, String endTime, String reviewMsg, String startError, String endError) {

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		driver.findElement(By.xpath("//button[text()='View All']")).click();

		WebElement workTypesLink = driver
				.findElement(By.xpath("//*[contains(@class,'slds-truncate') and text()='Work Types']"));

		executor.executeScript("arguments[0].click();", workTypesLink);

		driver.findElement(By.xpath("//tbody/tr[1]/td[5]//a")).click();

		driver.findElement(By.xpath("//a[@title='Edit']")).click();

		// driver.findElement(By.xpath("//span[text()='Timeframe
		// Start']/parent::label/following-sibling::input")).sendKeys(startTime);

		WebElement startDay = driver
				.findElement(By.xpath("//span[text()='Timeframe Start']/parent::label/following-sibling::input"));
		startDay.clear();
		startDay.sendKeys(startTime);

		// driver.findElement(By.xpath("//span[text()='Timeframe
		// End']/parent::label/following-sibling::input")).sendKeys(endTime);
		WebElement endDay = driver
				.findElement(By.xpath("//span[text()='Timeframe End']/parent::label/following-sibling::input"));
		endDay.clear();
		endDay.sendKeys(endTime);

		// span[text()='Timeframe Start']/parent::label/following-sibling::input
		driver.findElement(By.xpath("(//*[@title='Save'])[1]")).click();

		WebElement errorMessage = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pageLevelErrors']//span")));
		String reviewText = errorMessage.getText();
		Assert.assertEquals(reviewMsg, reviewText);
		String getStartErrorMsg = driver
				.findElement(By.xpath("(//ul[contains(@class,'has-error')]/parent::div//li)[1]")).getText();

		Assert.assertEquals(startError, getStartErrorMsg);

		String getEndErrorMsg = driver.findElement(By.xpath("(//ul[contains(@class,'has-error')]/parent::div//li)[2]"))
				.getText();

		Assert.assertEquals(endError, getEndErrorMsg);

	}
}
