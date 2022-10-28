package com.salesforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.salesforce.base.ProjectSpecificMethods;

public class SalesPage extends ProjectSpecificMethods {

	public OpportunityPage clickOpportunityLink() {
		// WebElement opportunityLink =
		// driver.findElement(By.xpath("//a[@title='Opportunities']/span"));
		WebElement opportunityLink = driver.findElement(By.xpath(prop.getProperty("sales.opportunitieslink.xpath")));

		driver.executeScript("arguments[0].click();", opportunityLink);
		return new OpportunityPage();

	}

	public AccountsPage clickAccountsLink() {
		// WebElement opportunityLink =
		// driver.findElement(By.xpath("//a[@title='Opportunities']/span"));
		WebElement accountsLink = driver.findElement(By.xpath(prop.getProperty("sales.accountslink.xpath")));
		// JavascriptExecutor executor = (JavascriptExecutor)driver;
		driver.executeScript("arguments[0].click();", accountsLink);
		return new AccountsPage();

	}



}
