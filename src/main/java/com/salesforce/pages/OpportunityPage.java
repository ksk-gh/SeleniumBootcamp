package com.salesforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.salesforce.base.ProjectSpecificMethods;

public class OpportunityPage extends ProjectSpecificMethods {

	public OpportunityPage clickNewButton() {

		driver.findElement(By.xpath("//div[@title='New']")).click();
		return this;

	}

	public OpportunityPage enterOpportunityName(String enterOpportunity) {
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(enterOpportunity);
		return this;

	}

	public OpportunityPage getEnteredOpportunityName() {
		String opportunityValue = driver.findElement(By.xpath("//input[@name='Name']")).getAttribute("value");
		System.out.println(opportunityValue);
		return this;
	}

	public OpportunityPage clickCloseDate() {
		WebElement datePicker = driver.findElement(By.xpath("//input[@name='CloseDate']"));
		driver.executeScript("arguments[0].click();", datePicker);
		return this;
	}

	public OpportunityPage clickTodayDateNumber() {
		driver.findElement(By.xpath("//*[@class='slds-is-today']")).click();
		return this;

	}

	public OpportunityPage clickStageDropdown() {
		WebElement stageDropdown = driver.findElement(By.xpath("//*[contains(@aria-label,'Stage,')]"));
		stageDropdown.click();
		return this;

	}

	public OpportunityPage selectNeedAnalaysisValue() {
		WebElement needAnalysisValue = driver.findElement(By.xpath("//span[@title='Needs Analysis']"));
		needAnalysisValue.click();
		return this;
	}

	public OpportunityPage clickSaveButton() {
		WebElement saveButton = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
		saveButton.click();
		return this;
	}

	public OpportunityPage getSnackBarMessage(String snackBarValue, String labelTextValue) {
		WebElement snackBar = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText']")));
		String snackBarText = snackBar.getText();
		System.out.println(snackBarText);
		String validateLabelText = driver.findElement(By.xpath("//*[@slot='primaryField']")).getText();
		System.out.println(validateLabelText);
		Assert.assertEquals(snackBarValue, snackBarText);
		Assert.assertEquals(labelTextValue, validateLabelText);

		return this;

	}

	/*
	 * public OpportunityPage enterOpportunity(String enterSearchOpportunity) throws
	 * InterruptedException { WebElement searchOpportunity =
	 * driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")); //
	 * Thread.sleep(2000); searchOpportunity.sendKeys(enterSearchOpportunity,
	 * Keys.ENTER); Thread.sleep(2000); return this; }
	 * 
	 * public OpportunityPage clickRefreshButton() { WebElement refreshButton =
	 * driver.findElement(By.xpath("//button[@name='refreshButton']"));
	 * refreshButton.click(); return this; }
	 * 
	 * public OpportunityPage verifyCreatedOpportunity(String opportunityValue) {
	 * String verifyText =
	 * driver.findElement(By.xpath("//tbody/tr[1]/th/span/a")).getText();
	 * System.out.println("Text verified is " + verifyText);
	 * Assert.assertEquals(opportunityValue, verifyText); return this; }
	 */}