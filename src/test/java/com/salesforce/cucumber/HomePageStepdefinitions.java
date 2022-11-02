package com.salesforce.cucumber;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;

public class HomePageStepdefinitions extends Base{

	@And("Click on the appLauncher")
	public void clickAppLauncher() {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

	}
	
	@And("Click on the ViewAll")
	public void clickViewAll() {
		driver.findElement(By.xpath("//button[text()='View All']")).click();
	}

	@And("Click on the Saleslink")
	public void clickSalesLink() {
		driver.findElement(By.xpath("//*[text()='Sales']")).click();
	}
}
