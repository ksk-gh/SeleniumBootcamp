package com.salesforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.salesforce.base.ProjectSpecificMethods;

public class IndividualsPage extends ProjectSpecificMethods {

	public IndividualsPage clickDownArrow() {
		driver.findElement(By.xpath(prop.getProperty("individuals.individualsdownarrow.xpath"))).click();
		return this;
	}

	public IndividualsPage clickNewIndividualLink() {
		WebElement newIndividualLink = driver
				.findElement(By.xpath(prop.getProperty("individuals.newindividuals.xpath")));
		driver.executeScript("arguments[0].click();", newIndividualLink);
		return this;
	}

	public IndividualsPage enterlastName(String lName) {
		driver.findElement(By.xpath(prop.getProperty("individuals.lastname.xpath"))).sendKeys(lName);
		return this;
	}

	public IndividualsPage clickSaveButton() {
		driver.findElement(By.xpath(prop.getProperty("individuals.savebtn.xpath"))).click();
		return this;
	}

	public IndividualsPage validateSnackBarMsg(String toastMessage) {

		WebElement snackBar = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(prop.getProperty("individuals.snackbar.xpath"))));
		String snackMessage = snackBar.getText();

		Assert.assertEquals(toastMessage, snackMessage);
		return this;
	}

	public IndividualsPage clickIndividualsMenu() {
		WebElement individualsMenuLink = driver
				.findElement(By.xpath(prop.getProperty("individuals.individualsmenu.xpath")));
		driver.executeScript("arguments[0].click();", individualsMenuLink);
		return this;
	}

	public IndividualsPage enterSearchText(String searchText) throws InterruptedException {
		driver.findElement(By.xpath(prop.getProperty("individuals.searhbox.xpath"))).sendKeys(searchText);
		Thread.sleep(2000);
		return this;
	}

	public IndividualsPage clickRecentlyViewed() throws InterruptedException {
		driver.findElement(By.xpath(prop.getProperty("individuals.recentlyviewed.xpath"))).click();
		Thread.sleep(2000);
		return this;
	}

	public IndividualsPage selectFirstElement() throws InterruptedException {
		WebElement clickDropDown = driver.findElement(By.xpath(prop.getProperty("individuals.firstelement.xpath")));
		driver.executeScript("arguments[0].click();", clickDropDown);
		Thread.sleep(2000);
		return this;
	}

	public IndividualsPage clickEditButton() {
		WebElement editButton = driver.findElement(By.xpath(prop.getProperty("individuals.editbutton.xpath")));
		editButton.click();
		return this;
	}

	public IndividualsPage clickSalutationTextBox() {
		driver.findElement(By.xpath(prop.getProperty("individuals.salutation.xpath"))).click();
		return this;
	}

	public IndividualsPage selectSalutationOption() {
		String salutationOption = "Mr.";
		driver.findElement(By.xpath("//a[@title='" + salutationOption + "']")).click();
		return this;
	}

	public IndividualsPage enterFirstName(String firstName) {
		WebElement firstNameTextBox = driver.findElement(By.xpath(prop.getProperty("individuals.firstname.xpath")));
		firstNameTextBox.clear();
		firstNameTextBox.sendKeys(firstName);
		return this;
	}
	
	
	public IndividualsPage clickDeleteButton() {
		driver.findElement(By.xpath(prop.getProperty("individuals.deleteBtn.xpath"))).click();
		return this;
	}

	public IndividualsPage acceptDelete() {
		driver.findElement(By.xpath(prop.getProperty("individuals.acceptDelete.xpath"))).click();
		return this;
	}
	
	
	public IndividualsPage noItemDisplayed() {
		
		String Message = "No items to display.";
		WebElement noItem = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='"+Message+"']")));

		boolean displayed = noItem.isDisplayed();
		Assert.assertTrue(displayed);
		return this;
	}
	
	public IndividualsPage validateLastNameErrormessage(String errorText) {
		String getErrorMessage = driver.findElement(By.xpath(prop.getProperty("individuals.lastnameerrormsg.xpath")))
				.getText();

		System.out.println(getErrorMessage);
		Assert.assertEquals(errorText, getErrorMessage);
		return this;
	}
}
