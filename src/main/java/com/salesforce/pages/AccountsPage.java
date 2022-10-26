package com.salesforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.salesforce.base.ProjectSpecificMethods;

public class AccountsPage extends ProjectSpecificMethods{
	
	public AccountsPage clickNewButton() {

		driver.findElement(By.xpath(prop.getProperty("accounts.newbtn.xpath"))).click();
		return this;

	}
	
	public AccountsPage sendAccountName(String accountName) {
		driver.findElement(By.xpath(prop.getProperty("accounts.name.xpath"))).sendKeys(accountName);
		return this;
	}

	public AccountsPage clickOwnershipTxtBx() {
		WebElement ownershipTextbox = driver.findElement(By.xpath("//button[contains(@aria-label,'Ownership')]"));
		driver.executeScript("arguments[0].click();", ownershipTextbox);
		return this;
	}
	
	public AccountsPage selectPublicOwnershipOption() {
		WebElement publicDropdownValue = driver.findElement(By.xpath("//*[@data-value='Public']"));

		driver.executeScript("arguments[0].click();", publicDropdownValue);
		return this;
	}
	
	public AccountsPage clickSaveButton() {
		WebElement saveButton = driver.findElement(By.xpath(prop.getProperty("accounts.savebtn.xpath")));
		saveButton.click();
		return this;
	}
	
}
