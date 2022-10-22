package com.salesforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.salesforce.base.ProjectSpecificMethods;

public class SalesPage extends ProjectSpecificMethods{

	public OpportunityPage clickOpportunityLink() {
		//WebElement opportunityLink = driver.findElement(By.xpath("//a[@title='Opportunities']/span"));
		WebElement opportunityLink = driver.findElement(By.xpath(prop.getProperty("sales.opportunitieslink.xpath")));

		driver.executeScript("arguments[0].click();", opportunityLink);
		return new OpportunityPage();

	}
}
