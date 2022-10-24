package com.salesforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

	public OpportunityPage clickNextDay() {
		driver.findElement(By.xpath("//*[contains(@class,'slds-is-today')]/following::td[1]/span[1]")).click();
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

	public OpportunityPage getSnackBarMessageWithTitleVerification(String snackBarValue, String labelTextValue) {
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

	public OpportunityPage getSnackBarMessage(String snackBarValue) {
		WebElement snackBar = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText']")));
		String snackBarText = snackBar.getText();
		Assert.assertEquals(snackBarValue.toString(), snackBarText.toString());

		return this;

	}

	public OpportunityPage searchOpportunity(String searchText) throws InterruptedException {
		WebElement searchOpportunity = driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"));
		//
		searchOpportunity.clear();
		searchOpportunity.sendKeys(searchText, Keys.ENTER);
		Thread.sleep(3000);
		return this;
	}

	public OpportunityPage clickOnOpportunityText() throws InterruptedException {
		driver.findElement(By.xpath("//lst-breadcrumbs//span[text()='Opportunities']")).click();
		Thread.sleep(2000);
		return this;
	}

	public OpportunityPage clickOnFirstSearchElement() {

		/*
		 * WebElement snackBar =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(
		 * driver.findElement(By.xpath("//tbody/tr[1]/td[8]//a")).click();
		 */

		wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//tbody/tr[1]/td[8]//a"))));

		WebElement firstElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[8]//a")));

		firstElement.click();
		return this;
	}

	public OpportunityPage clickOnEditButton() {
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		return this;
	}

	public OpportunityPage clickDeleteButton() {
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		return this;
	}

	public OpportunityPage acceptDelete() {
		driver.findElement(By.xpath("//button[@title='Delete']")).click();
		return this;
	}

	public OpportunityPage deleteSnackBarMessage() {
		WebElement snackBar = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText']")));
		System.out.println(snackBar.getText());
		boolean displayed = driver.findElement(By.xpath("//span[text()='No items to display.']")).isDisplayed();
		Assert.assertTrue(displayed);
		return this;
	}

	public OpportunityPage selectPerceptionAnalysisValue() {
		WebElement perceptionAnalysisValue = driver.findElement(By.xpath("//span[@title='Perception Analysis']"));
		perceptionAnalysisValue.click();
		return this;
	}

	public OpportunityPage clickDeliveryTextBox() throws InterruptedException {
		WebElement deliveryTextbox = driver
				.findElement(By.xpath("//button[contains(@aria-label,'Delivery/Installation')]"));

		Thread.sleep(1000);
		driver.executeScript("arguments[0].click();", deliveryTextbox);
		return this;
	}

	public OpportunityPage selectInprogressDeliveryOption() {
		WebElement inProgress = driver.findElement(By.xpath("//*[@data-value='In progress']"));
		driver.executeScript("arguments[0].click();", inProgress);
		return this;

	}

	public OpportunityPage enterDescription(String enterDescription) {
		// driver.findElement(By.xpath("//*[@class='slds-textarea']")).sendKeys("Salesforce");
		driver.findElement(By.xpath("//*[@class='slds-textarea']")).clear();
		driver.findElement(By.xpath("//*[@class='slds-textarea']")).sendKeys(enterDescription);
		return this;

	}

	public OpportunityPage validateStageText(String verifyStageText) {
		String getText = driver.findElement(By.xpath("//tbody/tr[1]/td[5]")).getText();
		Assert.assertEquals(verifyStageText, getText);
		return this;
	}

	public OpportunityPage clickRefreshButton() {
		WebElement refreshButton = driver.findElement(By.xpath("//button[@name='refreshButton']"));
		refreshButton.click();
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
