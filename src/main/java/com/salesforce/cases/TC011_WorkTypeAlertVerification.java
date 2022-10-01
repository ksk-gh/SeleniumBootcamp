package com.salesforce.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class TC011_WorkTypeAlertVerification extends BaseClass{

	@Test
	public void tc011() {
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		driver.findElement(By.xpath("//button[text()='View All']")).click();

		WebElement workTypesLink = driver
				.findElement(By.xpath("//*[contains(@class,'slds-truncate') and text()='Work Types']"));

		executor.executeScript("arguments[0].click();", workTypesLink);

		driver.findElement(By.xpath("//div[@title='New']")).click();
		
		driver.findElement(By.xpath("//label/span[text()='Work Type Name']/following::input[1]")) .sendKeys("Bootcamp");

		 driver.findElement(By.xpath("(//*[@title='Save'])[1]")).click();
		 WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pageLevelErrors']//span")));
			String text = errorMessage.getText();
			System.out.println(text);
			 WebElement errorMessageText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pageLevelErrors']//li")));
				String errormessagevalue= errorMessageText.getText();
				System.out.println(errormessagevalue);
		
	}
}
