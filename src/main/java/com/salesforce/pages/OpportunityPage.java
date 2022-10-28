package com.salesforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.salesforce.base.ProjectSpecificMethods;

public class OpportunityPage extends ProjectSpecificMethods {

	public OpportunityPage clickNewButton() {

		driver.findElement(By.xpath(prop.getProperty("opportunities.newbtn.xpath"))).click();
		return this;

	}

	public OpportunityPage enterOpportunityName(String enterOpportunity) {
		driver.findElement(By.xpath(prop.getProperty("opportunities.opportunityname.xpath")))
				.sendKeys(enterOpportunity);
		return this;

	}

	public OpportunityPage getEnteredOpportunityName() {
		String opportunityValue = driver.findElement(By.xpath(prop.getProperty("opportunities.opportunityname.xpath")))
				.getAttribute("value");
		System.out.println(opportunityValue);
		return this;
	}

	public OpportunityPage clickCloseDate() {
		WebElement datePicker = driver.findElement(By.xpath(prop.getProperty("opportunities.closedate.xpath")));
		driver.executeScript("arguments[0].click();", datePicker);
		return this;
	}

	public OpportunityPage clickTodayDateNumber() {
		driver.findElement(By.xpath(prop.getProperty("opportunities.todaydatenumber.xpath"))).click();
		return this;

	}

	public OpportunityPage clickNextDay() {
		driver.findElement(By.xpath(prop.getProperty("opportunities.nextdate.xpath"))).click();
		return this;

	}

	public OpportunityPage clickStageDropdown() {
		WebElement stageDropdown = driver.findElement(By.xpath(prop.getProperty("opportunities.stagedropdown.xpath")));
		stageDropdown.click();
		return this;

	}

	public OpportunityPage selectNeedAnalaysisValue() {
		WebElement needAnalysisValue = driver
				.findElement(By.xpath(prop.getProperty("opportunities.stagevalueNeedanalysis.xpath")));
		needAnalysisValue.click();
		return this;
	}

	public OpportunityPage selectPerceptionAnalysisValue() {
		WebElement perceptionAnalysisValue = driver
				.findElement(By.xpath(prop.getProperty("opportunities.stagevaluePerceptionAnalysis.xpath")));
		perceptionAnalysisValue.click();
		return this;
	}

	public OpportunityPage clickSaveButton() {
		WebElement saveButton = driver.findElement(By.xpath(prop.getProperty("opportunities.savebtn.xpath")));
		saveButton.click();
		return this;
	}

	public OpportunityPage getSnackBarMessageWithTitleVerification(String snackBarValue, String labelTextValue) {
		WebElement snackBar = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(prop.getProperty("opportunities.snackbarmsg.xpath"))));
		String snackBarText = snackBar.getText();
		System.out.println(snackBarText);
		String validateLabelText = driver
				.findElement(By.xpath(prop.getProperty("opportunities.opportunitylabel.xpath"))).getText();
		System.out.println(validateLabelText);
		Assert.assertEquals(snackBarValue, snackBarText);
		Assert.assertEquals(labelTextValue, validateLabelText);

		return this;

	}

	public OpportunityPage getSnackBarMessage(String snackBarValue) {
		WebElement snackBar = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(prop.getProperty("opportunities.snackbarmsg.xpath"))));
		String snackBarText = snackBar.getText();
		Assert.assertEquals(snackBarValue.toString(), snackBarText.toString());

		return this;

	}

	public OpportunityPage deleteSnackBarMessage(String noItems) {
		WebElement snackBar = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(prop.getProperty("opportunities.snackbarmsg.xpath"))));
		System.out.println(snackBar.getText());
		boolean displayed = driver.findElement(By.xpath("//span[text()='" + noItems + "']")).isDisplayed();
		Assert.assertTrue(displayed);
		return this;
	}

	public OpportunityPage searchOpportunity(String searchText) throws InterruptedException {
		WebElement searchOpportunity = driver
				.findElement(By.xpath(prop.getProperty("opportunities.searchopportunity.xpath")));

		searchOpportunity.clear();
		searchOpportunity.sendKeys(searchText, Keys.ENTER);
		Thread.sleep(3000);
		return this;
	}

	public OpportunityPage clickOnOpportunityText() throws InterruptedException {
		driver.findElement(By.xpath(prop.getProperty("opportunities.opportunitytext.xpath"))).click();
		Thread.sleep(2000);
		return this;
	}

	public OpportunityPage clickOnFirstSearchElement() {

		wait.until(ExpectedConditions.stalenessOf(
				driver.findElement(By.xpath(prop.getProperty("opportunities.firstSearchedElement.xpath")))));

		WebElement firstElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(prop.getProperty("opportunities.firstSearchedElement.xpath"))));

		firstElement.click();
		return this;
	}

	public OpportunityPage clickOnEditButton() {
		driver.findElement(By.xpath(prop.getProperty("opportunities.editBtn.xpath"))).click();
		return this;
	}

	public OpportunityPage clickDeleteButton() {
		driver.findElement(By.xpath(prop.getProperty("opportunities.deleteBtn.xpath"))).click();
		return this;
	}

	public OpportunityPage acceptDelete() {
		driver.findElement(By.xpath(prop.getProperty("opportunities.acceptDelete.xpath"))).click();
		return this;
	}

	public OpportunityPage clickDeliveryTextBox() throws InterruptedException {
		WebElement deliveryTextbox = driver
				.findElement(By.xpath(prop.getProperty("opportunities.deliverytxtbx.xpath")));

		Thread.sleep(1000);
		driver.executeScript("arguments[0].click();", deliveryTextbox);
		return this;
	}

	public OpportunityPage selectInprogressDeliveryOption() {
		WebElement inProgress = driver
				.findElement(By.xpath(prop.getProperty("opportunities.inprogressDeliveryOption.xpath")));
		driver.executeScript("arguments[0].click();", inProgress);
		return this;

	}

	public OpportunityPage enterDescription(String enterDescription) {
		// driver.findElement(By.xpath("//*[@class='slds-textarea']")).sendKeys("Salesforce");
		driver.findElement(By.xpath(prop.getProperty("opportunities.description.xpath"))).clear();
		driver.findElement(By.xpath(prop.getProperty("opportunities.description.xpath"))).sendKeys(enterDescription);
		return this;

	}

	public OpportunityPage validateStageText(String verifyStageText) {
		String getText = driver.findElement(By.xpath(prop.getProperty("opportunities.stagetextresults.xpath")))
				.getText();
		Assert.assertEquals(verifyStageText, getText);
		return this;
	}

	public OpportunityPage clickRefreshButton() {
		WebElement refreshButton = driver.findElement(By.xpath(prop.getProperty("opportunities.refreshbtn.xpath")));
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
