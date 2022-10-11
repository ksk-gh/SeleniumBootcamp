package com.salesforce.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.salesforce.base.BaseClass;

public class TC006_DeleteAccount extends BaseClass {
	@BeforeTest
	public void setData() {
		excelFileName = "TC006";
	}

	@Test(dataProvider = "Dynamic_Data", enabled = true)
	public void tc006(String accountName, String noItemsText) throws InterruptedException {

		if (driver.getTitle().contains("Developer Edition")) {
			driver.findElement(By.xpath("//*[@class='switch-to-lightning']")).click();
		}

//	String noItemsText = "No items to display.";
		// String accountName="Sankarakarthikeyan";

		// 2. Click on toggle menu button from the left corner

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		// 3. Click view All and click Sales from App Launcher

		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//*[text()='Sales']")).click();
		Thread.sleep(2000);

		WebElement accountsLink = driver.findElement(By.xpath("//a[@title='Accounts']"));
		// JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", accountsLink);
		Thread.sleep(4000);

		driver.findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys(accountName, Keys.ENTER);

		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@name='refreshButton']")).click();
		// driver.findElement(By.xpath("//button[@name='refreshButton']")).click();
		// Thread.sleep(1000);
		wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//tbody/tr[1]/td[6]//a"))));

		WebElement firstElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[6]//a")));

		firstElement.click();

		driver.findElement(By.xpath("//a[@title='Delete']")).click();

		// button[@title='Delete']
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@title='Delete']")).click();

		WebElement snackBar = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText']")));
		System.out.println(snackBar.getText());

		// String noItemsGetText = driver.findElement(By.xpath("//span[text()='No items
		// to display.']")).getText();
		// Assert.assertEquals(noItemsText, noItemsGetText);

		boolean displayed = driver.findElement(By.xpath("//span[text()='No items to display.']")).isDisplayed();
		Assert.assertTrue(displayed);

	}
}
