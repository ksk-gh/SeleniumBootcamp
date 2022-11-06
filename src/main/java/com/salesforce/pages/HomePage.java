package com.salesforce.pages;

import com.salesforce.base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods {

	public HomePage clickAppLauncher() {
		click(locateElement("xpath", prop.getProperty("home.applauncher.xpath")));
		return this;

	}

	public HomePage clickViewAll() {
		click(locateElement("xpath", prop.getProperty("home.viewall.xpath")));

		return this;

	}

	public SalesPage clickSalesLink() throws InterruptedException {
	
		click(locateElement("xpath", prop.getProperty("home.saleslink.xpath")));

		Thread.sleep(5000);
		return new SalesPage();

	}

	public WorkTypesPage clickWorkTypesLink() {
		//WebElement workTypesLink = driver.findElement(By.xpath(prop.getProperty("home.worktypelink.xpath")));

	//	driver.executeScript("arguments[0].click();", workTypesLink);
		
		
		clickUsingJs(locateElement("xpath", prop.getProperty("home.worktypelink.xpath")));
		
		
		return new WorkTypesPage();
	}

	public IndividualsPage clickIndividualsLink() {

		/*
		 * WebElement individualLink =
		 * driver.findElement(By.xpath(prop.getProperty("home.individualslink.xpath")));
		 * 
		 * driver.executeScript("arguments[0].click();", individualLink);
		 */
		
		clickUsingJs(locateElement("xpath", prop.getProperty("home.individualslink.xpath")));

		return new IndividualsPage();
	}

}
