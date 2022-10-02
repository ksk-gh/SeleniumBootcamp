package com.salesforce.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC013_EditIndividuals extends BaseClass {
	@BeforeTest
	public void setData() {
		excelFileName = "TC013";
	}

	@Test(dataProvider = "Dynamic_Data",enabled = true)
	public void tc013() throws InterruptedException {

		String firstName = "Sankarakarthi";
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		driver.findElement(By.xpath("//button[text()='View All']")).click();

		WebElement individualLink = driver
				.findElement(By.xpath("//p[contains(@class,'slds-truncate') and text()='Individuals']"));

		executor.executeScript("arguments[0].click();", individualLink);

		WebElement individualsMenuLink = driver.findElement(By.xpath("//*[@title='Not added to nav bar']/parent::a"));

		executor.executeScript("arguments[0].click();", individualsMenuLink);

		driver.findElement(By.xpath("//*[@class='slds-input']")).sendKeys("Kadirvelan");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h1/span[text()='Recently Viewed']")).click();

		Thread.sleep(2000);

		WebElement clickDropDown = driver.findElement(By.xpath("//tbody/tr[1]/td[6]/span/div/a"));
		executor.executeScript("arguments[0].click();", clickDropDown);
		Thread.sleep(2000);

		WebElement editButton = driver.findElement(By.xpath("//a[@title='Edit']/parent::li"));
		editButton.click();

		driver.findElement(By.xpath("//span[text()='Salutation']/parent::span/following-sibling::div//a")).click();
		driver.findElement(By.xpath("//a[@title='Mr.']")).click();
		WebElement firstNameTextBox = driver
				.findElement(By.xpath("//label/span[text()='First Name']/following::input[1]"));
		firstNameTextBox.clear();
		firstNameTextBox.sendKeys(firstName);

		driver.findElement(By.xpath("(//*[@title='Save'])[1]")).click();

		WebElement snackBar = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText'])[1]")));
		String snackMessage = snackBar.getText();
		System.out.println(snackMessage.contains(firstName));
		Assert.assertTrue(snackMessage.contains(firstName));
	}
}
