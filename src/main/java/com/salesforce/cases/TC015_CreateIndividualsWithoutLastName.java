package com.salesforce.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC015_CreateIndividualsWithoutLastName extends BaseClass {

	@BeforeTest
	public void setData() {
		excelFileName = "TC015";
	}

	@Test(dataProvider = "Dynamic_Data",enabled = true)
	public void tc015(String firstName, String errorText) {
		//String errorText = "Complete this field.";

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		driver.findElement(By.xpath("//button[text()='View All']")).click();

		WebElement individualLink = driver
				.findElement(By.xpath("//*[contains(@class,'slds-truncate') and text()='Individuals']"));

		executor.executeScript("arguments[0].click();", individualLink);

		driver.findElement(By.xpath("(//*[@title='Individuals']/parent::*//div)[1]")).click();
		WebElement newIndividualLink = driver.findElement(By.xpath("//span[text()='New Individual']"));
		executor.executeScript("arguments[0].click();", newIndividualLink);

		driver.findElement(By.xpath("//label/span[text()='First Name']/following::input[1]"))
				.sendKeys(firstName);

		driver.findElement(By.xpath("(//*[@title='Save'])[1]")).click();

		String getErrorMessage = driver.findElement(By.xpath(
				"//*[text()='Last Name']/parent::label/parent::div/parent::div//ul[contains(@class,'has-error')]"))
				.getText();

		System.out.println(getErrorMessage);
		Assert.assertEquals(errorText, getErrorMessage);

		

	}
}
