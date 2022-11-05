package com.salesforce.cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OpportunitiesStepdefinitions extends Base {

	@When("user click on the New button")
	public void clickNewButton() {
		driver.findElement(By.xpath("//div[@title='New']")).click();
	}

	@When("Enter the opportunity name as {string}")
	public void enter_the_opportunity_name(String enterOpportunity) {
		WebElement opportunityName = driver.findElement(By.xpath("//input[@name='Name']"));

		opportunityName.sendKeys(enterOpportunity);
	}

	@When("Click on the Todaydate")
	public void click_on_the_todaydate() {
		WebElement datePicker = driver.findElement(By.xpath("//input[@name='CloseDate']"));
		driver.executeScript("arguments[0].click();", datePicker);

		driver.findElement(By.xpath("//*[@class='slds-is-today']")).click();
	}

	@When("Click on the Stage option")
	public void click_on_the_stage_option() {
		WebElement stageDropdown = driver.findElement(By.xpath("//*[contains(@aria-label,'Stage,')]"));
		stageDropdown.click();
		WebElement needAnalysisValue = driver.findElement(By.xpath("//span[@title='Needs Analysis']"));
		needAnalysisValue.click();
	}

	@Then("Click on the Save button")
	public void click_on_the_save_button() {
		WebElement saveButton = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
		saveButton.click();
	}

	@Then("Verify the snackbar value {string}")
	public void verifyCreateSnackbar(String createsnackbar) {
		WebElement snackBar = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText']")));
		String text = snackBar.getText();

		Assert.assertEquals(createsnackbar, text);
	}

	@And("Search for the opportunity as {string}")
	public void searchOpportunity(String enterOpportunity) throws InterruptedException {

		WebElement searchOpportunity = driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"));
		Thread.sleep(2000);
		searchOpportunity.sendKeys(enterOpportunity);

	}

	@And("Click on the Refresh button")
	public void clickRefresh() {
		WebElement refreshButton = driver.findElement(By.xpath("//button[@name='refreshButton']"));
		refreshButton.click();
	}

	@And("Select the first result")
	public void selectFirstResult() {
		wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//tbody/tr[1]/td[8]//a"))));

		WebElement firstElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[8]//a")));

		firstElement.click();
	}

	@When("Click on the Edit button")
	public void clickEditButton() {
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
	}

	@And("Edit the close date to next date")
	public void editCloseDate() {
		WebElement datePicker = driver.findElement(By.xpath("//input[@name='CloseDate']"));
		driver.executeScript("arguments[0].click();", datePicker);
		driver.findElement(By.xpath("//*[contains(@class,'slds-is-today')]/following::td[1]/span[1]")).click();

	}

	@And("Edit the stage option")
	public void editStageOption() {
		WebElement stageDropdown = driver.findElement(By.xpath("//*[contains(@aria-label,'Stage,')]"));
		stageDropdown.click();
		WebElement needAnalysisValue = driver.findElement(By.xpath("//span[@title='Perception Analysis']"));
		needAnalysisValue.click();

	}

	@And("Edit the delivery option")
	public void enterDeliveryOption() throws InterruptedException {
		WebElement deliveryTextbox = driver
				.findElement(By.xpath("//button[contains(@aria-label,'Delivery/Installation')]"));

		Thread.sleep(1000);
		driver.executeScript("arguments[0].click();", deliveryTextbox);

		WebElement inProgress = driver.findElement(By.xpath("//*[@data-value='In progress']"));
		driver.executeScript("arguments[0].click();", inProgress);
	}

	@And("Enter the description")
	public void enterDescription() {

		driver.findElement(By.xpath("//*[@class='slds-textarea']")).clear();
		driver.findElement(By.xpath("//*[@class='slds-textarea']")).sendKeys("Salesforce");

	}

	@And("Validate the snackbar value as {string}")
	public void validateEditSnackBarMsg(String snackbarsave) {
		WebElement snackBar = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText']")));
		String snackBarText = snackBar.getText();
		Assert.assertEquals(snackbarsave, snackBarText.toString());
	}

	@When("Click on the Delete button")
	public void clickDeleteOption() {
		driver.findElement(By.xpath("//a[@title='Delete']")).click();

	}

	@And("Accept the confirmation message to Delete the opportunity")
	public void acceptDelete() {
		driver.findElement(By.xpath("//button[@title='Delete']")).click();

	}

	@Then("Validate the {string} text message")
	public void deleteSnackBarMessage(String noItems) {

		WebElement snackBar = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + noItems + "']")));

		boolean displayed = snackBar.isDisplayed();
		Assert.assertTrue(displayed);
	}

}
