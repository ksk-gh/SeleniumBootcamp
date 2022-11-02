package com.salesforce.cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.salesforce.pages.AccountsPage;

import io.cucumber.java.en.Given;

public class SalesPageStepdefinitions extends Base{
	@Given("Click on the opportunitylink")
	public void clickOpportunityLink() {
		WebElement opportunityLink = driver.findElement(By.xpath("//a[@title='Opportunities']/span"));
		// driver.executeScript();
		driver.executeScript("arguments[0].click();", opportunityLink);
	}
	
@Given("Click on the accountslink")
public AccountsPage clickAccountsLink() {
		
		WebElement accountsLink = driver.findElement(By.xpath("//a[@title='Accounts']"));
		driver.executeScript("arguments[0].click();", accountsLink);
		return new AccountsPage();

	}
}
