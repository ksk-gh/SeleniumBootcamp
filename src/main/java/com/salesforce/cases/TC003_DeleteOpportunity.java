package com.salesforce.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.salesforce.base.BaseClass;

public class TC003_DeleteOpportunity extends BaseClass {

	@BeforeTest
	public void setData() {
		excelFileName = "TC003";
	}

	@Test(dataProvider = "Dynamic_Data",enabled = true)
	public void tc003(String searchText, String noItemsText) throws InterruptedException {
		
		if (driver.getTitle().contains("Developer Edition")) {
			driver.findElement(By.xpath("//*[@class='switch-to-lightning']")).click();
		}

		// 2. Click on toggle menu button from the left corner

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		// 3. Click view All and click Sales from App Launcher

		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//*[text()='Sales']")).click();
		Thread.sleep(2000);

		WebElement opportunityLink = driver.findElement(By.xpath("//a[@title='Opportunities']/span"));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", opportunityLink);

		WebElement searchOpportunity = driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"));
		Thread.sleep(2000);
		searchOpportunity.sendKeys(searchText, Keys.ENTER);

		Thread.sleep(2000);
		driver.findElement(By.xpath("//lst-breadcrumbs//span[text()='Opportunities']"));
		driver.findElement(By.xpath("//tbody/tr[1]/td[8]//a")).click();
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@title='Delete']")).click();
		WebElement snackBar = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText']")));
		System.out.println(snackBar.getText());
		boolean displayed = driver.findElement(By.xpath("//span[text()='No items to display.']")).isDisplayed();
		Assert.assertTrue(displayed);

	}

}
