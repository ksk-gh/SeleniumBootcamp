package com.salesforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.salesforce.base.ProjectSpecificMethods;

public class IndividualsPage extends ProjectSpecificMethods {

	public IndividualsPage clickDownArrow() {
		click(locateElement("xpath", prop.getProperty("individuals.individualsdownarrow.xpath")));
		return this;
	}

	public IndividualsPage clickNewIndividualLink() {
		clickUsingJs(locateElement("xpath", prop.getProperty("individuals.newindividuals.xpath")));
		return this;
	}

	public IndividualsPage enterlastName(String lName) {
		type(locateElement("xpath", prop.getProperty("individuals.lastname.xpath")), lName);
		return this;
	}

	public IndividualsPage clickSaveButton() {
		click(locateElement("xpath", prop.getProperty("individuals.savebtn.xpath")));
		return this;
	}

	public IndividualsPage validateSnackBarMsg(String toastMessage) {
		waitUntilElementLocated("xpath", prop.getProperty("individuals.snackbar.xpath"));
		Assert.assertEquals(toastMessage,
				getTextMessage(locateElement("xpath", prop.getProperty("individuals.snackbar.xpath"))));
		return this;
	}

	public IndividualsPage clickIndividualsMenu() {
		clickUsingJs(locateElement("xpath", prop.getProperty("individuals.individualsmenu.xpath")));
		return this;
	}

	public IndividualsPage enterSearchText(String searchText) throws InterruptedException {
		clearAndTypeWithEnter(locateElement("xpath", prop.getProperty("individuals.searhbox.xpath")), searchText);
		Thread.sleep(2000);
		return this;
	}

	public IndividualsPage clickRecentlyViewed() throws InterruptedException {
		click(locateElement("xpath", prop.getProperty("individuals.recentlyviewed.xpath")));
		Thread.sleep(2000);
		return this;
	}

	public IndividualsPage selectFirstElement() throws InterruptedException {
		waitUntilStalenessof(locateElement("xpath", prop.getProperty("individuals.firstelement.xpath")));
		clickUsingJs(locateElement("xpath", prop.getProperty("individuals.firstelement.xpath")));
		Thread.sleep(2000);
		return this;
	}

	public IndividualsPage clickEditButton() {
		click(locateElement("xpath", prop.getProperty("individuals.editbutton.xpath")));
		return this;
	}

	public IndividualsPage clickSalutationTextBox() {
		click(locateElement("xpath", prop.getProperty("individuals.salutation.xpath")));
		return this;
	}

	public IndividualsPage selectSalutationOption() {
		String salutation = "Mr.";
		WebElement salutationOption = getDriver().findElement(By.xpath("//a[@title='" + salutation + "']"));
		click(salutationOption);
		return this;
	}

	public IndividualsPage enterFirstName(String firstName) {
		type(locateElement("xpath", prop.getProperty("individuals.firstname.xpath")), firstName);
		return this;
	}

	public IndividualsPage clickDeleteButton() {
		click(locateElement("xpath", prop.getProperty("individuals.deletebutton.xpath")));
		return this;
	}

	public IndividualsPage acceptDelete() throws InterruptedException {
		waitUntilElementLocated("xpath", prop.getProperty("individuals.acceptdelete.xpath"));
		click(locateElement("xpath", prop.getProperty("individuals.acceptdelete.xpath")));
		Thread.sleep(5000);
		return this;
	}

	public IndividualsPage noItemDisplayed() {
		boolean isDisplayed = verifyDisplayed(locateElement("xpath", prop.getProperty("common.noitems.xpath")));
		Assert.assertTrue(isDisplayed);
		return this;
	}

	public IndividualsPage validateLastNameErrormessage(String errorText) {
		Assert.assertEquals(errorText,
				getTextMessage(locateElement("xpath", prop.getProperty("individuals.lastnameerrormsg.xpath"))));
		return this;
	}

	public IndividualsPage clickRefreshButton() {
		click(locateElement("xpath", prop.getProperty("individuals.refreshbtn.xpath")));
		return this;

	}
}
