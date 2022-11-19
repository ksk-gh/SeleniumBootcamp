package com.salesforce.pages;

import org.testng.Assert;

import com.salesforce.base.ProjectSpecificMethods;

public class WorkTypesPage extends ProjectSpecificMethods {

	public WorkTypesPage clickNewButton() {
		click(locateElement("xpath", prop.getProperty("accounts.newbtn.xpath")));
		return this;
	}

	public WorkTypesPage enterWorkTypeName(String workTypeName) {
		type(locateElement("xpath", prop.getProperty("worktypes.worktypename.xpath")), workTypeName);
		return this;
	}

	public WorkTypesPage enterDescription(String textArea) {
		type(locateElement("xpath", prop.getProperty("worktypes.description.xpath")), textArea);
		return this;
	}

	public WorkTypesPage clickOnOperatingHoursTxtBx() {
		click(locateElement("xpath", prop.getProperty("worktypes.operatinghours.xpath")));
		return this;
	}

	public WorkTypesPage clickOnOperatingHoursLink() {
		/*
		 * WebElement operatingHoursLInk = wait.until(ExpectedConditions
		 * .visibilityOfElementLocated(By.xpath(prop.getProperty(
		 * "worktypes.newoperatinghours.xpath")))); operatingHoursLInk.click();
		 */
		waitUntilElementLocated("xpath", prop.getProperty("worktypes.newoperatinghours.xpath"));
		click(locateElement("xpath", prop.getProperty("worktypes.newoperatinghours.xpath")));
		return this;
	}

	public WorkTypesPage enterShitName(String shiftName) {
		/*
		 * WebElement nameTextbox = wait.until(ExpectedConditions
		 * .visibilityOfElementLocated(By.xpath(prop.getProperty(
		 * "worktypes.operatinghourname.xpath")))); nameTextbox.sendKeys(shiftName);
		 */

		// waitUntilElementLocated("xpath",
		// prop.getProperty("worktypes.operatinghourname.xpath"));
		type(locateElement("xpath", prop.getProperty("worktypes.operatinghourname.xpath")), shiftName);
		return this;
	}

	public WorkTypesPage clickOperatingHoursSaveButton() {
		// driver.findElement(By.xpath(prop.getProperty("worktypes.saveshift.xpath"))).click();
		click(locateElement("xpath", prop.getProperty("worktypes.saveshift.xpath")));
		return this;
	}

	public WorkTypesPage waitUntilInviisiblityOfSnackBar() {

		/*
		 * wait.until(ExpectedConditions
		 * .invisibilityOfElementLocated(By.xpath(prop.getProperty(
		 * "worktypes.shiftsnackbar.xpath"))));
		 */
		waitUntilInvisibilityOfElement("xpath", prop.getProperty("worktypes.shiftsnackbar.xpath"));
		return this;
	}

	public WorkTypesPage enterEstimatedDuration(String hours) {
		/*
		 * WebElement estimatedDuration = wait.until(ExpectedConditions
		 * .visibilityOfElementLocated(By.xpath(prop.getProperty(
		 * "worktypes.estimatedduration.xpath")))); estimatedDuration.sendKeys(hours);
		 */

		waitUntilElementLocated("xpath", prop.getProperty("worktypes.estimatedduration.xpath"));
		type(locateElement("xpath", prop.getProperty("worktypes.estimatedduration.xpath")), hours);
		return this;

	}

	public WorkTypesPage clickSaveButtonWorktype() {
//		driver.findElement(By.xpath(prop.getProperty("worktypes.saveworktype.xpath"))).click();

		click(locateElement("xpath", prop.getProperty("worktypes.saveworktype.xpath")));
		return this;
	}

	public WorkTypesPage validateSnackBar(String snackBarMsg) {
		/*
		 * WebElement snackBar2 = wait.until(
		 * ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty(
		 * "worktypes.snackbar.xpath")))); String getSnackBar2 = snackBar2.getText();
		 * Assert.assertEquals(snackBarMsg, getSnackBar2);
		 */

		waitUntilElementLocated("xpath", prop.getProperty("worktypes.snackbar.xpath"));
		Assert.assertEquals(snackBarMsg,
				getTextMessage(locateElement("xpath", prop.getProperty("worktypes.snackbar.xpath"))));

		return this;
	}

	public WorkTypesPage clickOnFirstElement() {
		click(locateElement("xpath", prop.getProperty("worktypes.firstelement.xpath")));
		return this;
	}

	public WorkTypesPage clickEditButton() {
		click(locateElement("xpath", prop.getProperty("worktypes.editBtn.xpath")));
		return this;
	}

	public WorkTypesPage enterStartDay(String startTime) {
		type(locateElement("xpath", prop.getProperty("worktypes.startday.xpath")), startTime);
		return this;
	}

	public WorkTypesPage enterEndDay(String endTime) {
		type(locateElement("xpath", prop.getProperty("worktypes.endday.xpath")), endTime);
		return this;
	}

	public WorkTypesPage validateReviewErrorMsg(String reviewError) {
		waitUntilElementLocated("xpath", prop.getProperty("worktypes.reviewmsg.xpath"));
		Assert.assertEquals(reviewError,
				getTextMessage(locateElement("xpath", prop.getProperty("worktypes.reviewmsg.xpath"))));
		return this;
	}

	public WorkTypesPage validateStartErrorMsg(String startError) {
		Assert.assertEquals(startError,
				getTextMessage(locateElement("xpath", prop.getProperty("worktypes.starterror.xpath"))));
		return this;
	}

	public WorkTypesPage validateEndErrorMsg(String endError) {
		Assert.assertEquals(endError,
				getTextMessage(locateElement("xpath", prop.getProperty("worktypes.enderror.xpath"))));
		return this;
	}

	public WorkTypesPage getSnackBarMessage() {
		waitUntilElementLocated("xpath", prop.getProperty("worktypes.snackbar.xpath"));
		return this;
	}

	public WorkTypesPage clickDeleteButton() {
		click(locateElement("xpath", prop.getProperty("accounts.deleteBtn.xpath")));
		return this;
	}

	public WorkTypesPage acceptDelete() {
		click(locateElement("xpath", prop.getProperty("accounts.acceptDelete.xpath")));
		return this;
	}

	public WorkTypesPage validateSnackBarMsgContains(String snackBarText) {
		waitUntilElementLocated("xpath", prop.getProperty("worktypes.snackbar.xpath"));
		Assert.assertTrue(getTextMessage(locateElement("xpath", prop.getProperty("worktypes.snackbar.xpath")))
				.contains(snackBarText));
		return this;
	}

	public WorkTypesPage validateSpecificErrorMsg(String mainErrorMsg) {
		waitUntilElementLocated("xpath", prop.getProperty("worktypes.specificerrormsg.xpath"));
		Assert.assertEquals(mainErrorMsg,
				getTextMessage(locateElement("xpath", prop.getProperty("worktypes.specificerrormsg.xpath"))));
		return this;
	}

	public WorkTypesPage validateFieldLevelErrorMsg(String fieldErrorMsg) {
		getTextMessage(locateElement("xpath", prop.getProperty("worktypes.fieldlevelerror.xpath")));
		Assert.assertEquals(fieldErrorMsg,
				getTextMessage(locateElement("xpath", prop.getProperty("worktypes.fieldlevelerror.xpath"))));
		return this;
	}

}
