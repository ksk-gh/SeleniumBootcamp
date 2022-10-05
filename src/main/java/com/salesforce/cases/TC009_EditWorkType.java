package com.salesforce.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC009_EditWorkType extends BaseClass {
	@BeforeTest
	public void setData() {
		excelFileName = "TC009";
	}

	@Test(dataProvider = "Dynamic_Data", enabled = true)
	public void tc009(String startTime, String endTime) {

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		driver.findElement(By.xpath("//button[text()='View All']")).click();

		WebElement workTypesLink = driver
				.findElement(By.xpath("//*[contains(@class,'slds-truncate') and text()='Work Types']"));

		executor.executeScript("arguments[0].click();", workTypesLink);

		driver.findElement(By.xpath("//tbody/tr[1]/td[5]//a")).click();

		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		driver.findElement(By.xpath("//span[text()='Timeframe Start']/parent::label/following-sibling::input")).clear();
		driver.findElement(By.xpath("//span[text()='Timeframe Start']/parent::label/following-sibling::input"))
				.sendKeys(startTime);// ("9");
		driver.findElement(By.xpath("//span[text()='Timeframe End']/parent::label/following-sibling::input")).clear();

		driver.findElement(By.xpath("//span[text()='Timeframe End']/parent::label/following-sibling::input"))
				.sendKeys(endTime);// ("18");

		// span[text()='Timeframe Start']/parent::label/following-sibling::input
		driver.findElement(By.xpath("(//*[@title='Save'])[1]")).click();

		WebElement snackBar = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText'])[1]")));
		System.out.println(snackBar.getText());

	}
}
