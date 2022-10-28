package com.salesforce.pages;

import org.openqa.selenium.By;

import com.salesforce.base.ProjectSpecificMethods;

public class WorkTypesPage extends ProjectSpecificMethods {
	
	public WorkTypesPage clickNewButton() {

		driver.findElement(By.xpath(prop.getProperty("accounts.newbtn.xpath"))).click();
		return this;

	}

}
