package com.salesforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.salesforce.base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods {

	public HomePage clickAppLauncher() {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		return this;

	}

	public HomePage clickViewAll() {
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		return this;

	}

	public SalesPage clickSalesLink() throws InterruptedException {
		driver.findElement(By.xpath("//*[text()='Sales']")).click();
		Thread.sleep(5000);
		return new SalesPage();

	}


}
