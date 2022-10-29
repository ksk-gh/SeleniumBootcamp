package com.salesforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.salesforce.base.ProjectSpecificMethods;

public class WorkTypesPage extends ProjectSpecificMethods {

	public WorkTypesPage clickNewButton() {

		driver.findElement(By.xpath(prop.getProperty("accounts.newbtn.xpath"))).click();
		return this;

	}

	public WorkTypesPage enterWorkTypeName(String workTypeName) {
		driver.findElement(By.xpath(prop.getProperty("worktypes.worktypename.xpath"))).sendKeys(workTypeName);
		return this;
	}

	public WorkTypesPage enterDescription(String textArea) {
		driver.findElement(By.xpath(prop.getProperty("worktypes.description.xpath"))).sendKeys(textArea);
		return this;
	}

	public WorkTypesPage clickOnOperatingHoursTxtBx() {
		driver.findElement(By.xpath(prop.getProperty("worktypes.operatinghours.xpath"))).click();
		return this;
	}

	public WorkTypesPage clickOnOperatingHoursLink() {
		WebElement operatingHoursLInk = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(prop.getProperty("worktypes.newoperatinghours.xpath"))));
		operatingHoursLInk.click();
		return this;
	}

	public WorkTypesPage enterShitName(String shiftName) {
		WebElement nameTextbox = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(prop.getProperty("worktypes.operatinghourname.xpath"))));
		nameTextbox.sendKeys(shiftName);

		return this;
	}

	public WorkTypesPage clickOperatingHoursSaveButton() {
		driver.findElement(By.xpath(prop.getProperty("worktypes.saveshift.xpath"))).click();

		return this;
	}

	public WorkTypesPage waitUntilInviisiblityOfSnackBar() {

		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath(prop.getProperty("worktypes.shiftsnackbar.xpath"))));
		return this;
	}

	public WorkTypesPage enterEstimatedDuration(String hours) {
		WebElement estimatedDuration = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(prop.getProperty("worktypes.estimatedduration.xpath"))));
		estimatedDuration.sendKeys(hours);// "7");
		return this;

	}

	public WorkTypesPage clickSaveButtonWorktype() {
		driver.findElement(By.xpath(prop.getProperty("worktypes.saveworktype.xpath"))).click();
		return this;
	}

	public WorkTypesPage validateSnackBar(String snackBarMsg) {
		WebElement snackBar2 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("worktypes.snackbar.xpath"))));
		String getSnackBar2 = snackBar2.getText();
		Assert.assertEquals(snackBarMsg, getSnackBar2);

		return this;
	}

	public WorkTypesPage clickOnFirstElement() {
		driver.findElement(By.xpath(prop.getProperty("worktypes.firstelement.xpath"))).click();
		return this;
	}

	public WorkTypesPage clickEditButton() {
		driver.findElement(By.xpath(prop.getProperty("worktypes.editBtn.xpath"))).click();

		return this;
	}

	public WorkTypesPage enterStartDay(String startTime) {
		WebElement startDay = driver.findElement(By.xpath(prop.getProperty("worktypes.startday.xpath")));
		startDay.clear();
		startDay.sendKeys(startTime);
		return this;
	}

	public WorkTypesPage enterEndDay(String endTime) {
		WebElement endDay = driver.findElement(By.xpath(prop.getProperty("worktypes.endday.xpath")));
		endDay.clear();
		endDay.sendKeys(endTime);
		return this;
	}

	public WorkTypesPage validateReviewErrorMsg(String reviewError) {
		WebElement errorMessage = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("worktypes.reviewmsg.xpath"))));
		String reviewText = errorMessage.getText();
		Assert.assertEquals(reviewError, reviewText);
		return this;
	}

	public WorkTypesPage validateStartErrorMsg(String startError) {
		String getStartErrorMsg = driver.findElement(By.xpath(prop.getProperty("worktypes.starterror.xpath")))
				.getText();

		Assert.assertEquals(startError, getStartErrorMsg);
		return this;
	}

	public WorkTypesPage validateEndErrorMsg(String endError) {
		String getEndErrorMsg = driver.findElement(By.xpath(prop.getProperty("worktypes.enderror.xpath"))).getText();

		Assert.assertEquals(endError, getEndErrorMsg);
		return this;
	}

	public WorkTypesPage getSnackBarMessage() {
		WebElement snackBar = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("worktypes.snackbar.xpath"))));
		System.out.println(snackBar.getText());
		return this;
	}

	public WorkTypesPage clickDeleteButton() {
		driver.findElement(By.xpath(prop.getProperty("accounts.deleteBtn.xpath"))).click();
		return this;
	}

	public WorkTypesPage acceptDelete() {
		driver.findElement(By.xpath(prop.getProperty("accounts.acceptDelete.xpath"))).click();
		return this;
	}

	public WorkTypesPage validateSnackBarMsgContains(String snackBarText) {
		WebElement snackBar = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("worktypes.snackbar.xpath"))));
		String getDeletedText = snackBar.getText();
		System.out.println(getDeletedText);
		Assert.assertTrue(getDeletedText.contains(snackBarText));
		return this;
	}
public WorkTypesPage validateSpecificErrorMsg(String mainErrorMsg) {
	 WebElement errorMessageText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("worktypes.specificerrormsg.xpath")))); 
	 String errormessagevalue = errorMessageText.getText(); System.out.println(errormessagevalue);
	 Assert.assertEquals(mainErrorMsg, errormessagevalue);
	
	return this;
}

public WorkTypesPage validateFieldLevelErrorMsg(String fieldErrorMsg) {
	 String getFieldError = driver .findElement(By.xpath(prop.getProperty("worktypes.fieldlevelerror.xpath"))).getText(); 
	 Assert.assertEquals(fieldErrorMsg, getFieldError);
	return this;
}


}
