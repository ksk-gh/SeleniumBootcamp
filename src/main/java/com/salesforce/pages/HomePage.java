package com.salesforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.salesforce.base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods {

	public HomePage clickAppLauncher() {
		// driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath(prop.getProperty("appLauncher_xpath"))).click();
		return this;

	}

	public HomePage clickViewAll() {
		//driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath(prop.getProperty("viewAllButton_xpath"))).click();

		return this;

	}

	public SalesPage clickSalesLink() throws InterruptedException {
		//driver.findElement(By.xpath("//*[text()='Sales']")).click();
		driver.findElement(By.xpath(prop.getProperty("salesMenu_xpath"))).click();

		Thread.sleep(5000);
		return new SalesPage();

	}

}
