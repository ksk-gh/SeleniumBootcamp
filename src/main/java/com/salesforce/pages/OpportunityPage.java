package com.salesforce.pages;

import org.testng.Assert;

import com.salesforce.base.ProjectSpecificMethods;

public class OpportunityPage extends ProjectSpecificMethods {

	public OpportunityPage clickNewButton() {
		click(locateElement("xpath", prop.getProperty("opportunities.newbtn.xpath")));
		return this;

	}

	public OpportunityPage enterOpportunityName(String enterOpportunity) {
		type(locateElement("xpath", prop.getProperty("opportunities.opportunityname.xpath")), enterOpportunity);
		return this;

	}

	public OpportunityPage getEnteredOpportunityName() {
		getEnteredText(locateElement("xpath", prop.getProperty("opportunities.opportunityname.xpath")));
		return this;
	}

	public OpportunityPage clickCloseDate() {

		clickUsingJs(locateElement("xpath", prop.getProperty("opportunities.closedate.xpath")));

		return this;
	}

	public OpportunityPage clickTodayDateNumber() {
		click(locateElement("xpath", prop.getProperty("opportunities.todaydatenumber.xpath")));
		return this;

	}

	public OpportunityPage clickNextDay() {
		click(locateElement("xpath", prop.getProperty("opportunities.nextdate.xpath")));
		return this;

	}

	public OpportunityPage clickStageDropdown() {
		click(locateElement("xpath", prop.getProperty("opportunities.stagedropdown.xpath")));
		return this;

	}

	public OpportunityPage selectNeedAnalaysisValue() {
		click(locateElement("xpath", prop.getProperty("opportunities.stagevalueNeedanalysis.xpath")));
		return this;
	}

	public OpportunityPage selectPerceptionAnalysisValue() {
		click(locateElement("xpath", prop.getProperty("opportunities.stagevaluePerceptionAnalysis.xpath")));
		return this;
	}

	public OpportunityPage clickSaveButton() {
		click(locateElement("xpath", prop.getProperty("opportunities.savebtn.xpath")));
		return this;
	}

	public OpportunityPage validateSnackBarMessageWithTitleVerification(String snackBarValue, String labelTextValue)
			throws InterruptedException {

		Assert.assertEquals(snackBarValue,
				getTextMessage(locateElement("xpath", prop.getProperty("opportunities.snackbarmsg.xpath"))));
		Thread.sleep(2000);
		Assert.assertEquals(labelTextValue,
				getTextMessage(locateElement("xpath", prop.getProperty("opportunities.opportunitylabel.xpath"))));

		return this;

	}

	public OpportunityPage validateSnackBarMessage(String snackBarValue) {
		Assert.assertEquals(snackBarValue,
				getTextMessage(locateElement("xpath", prop.getProperty("opportunities.snackbarmsg.xpath"))));
		return this;

	}

	public OpportunityPage validateNoItemsText() {
		waitUntilInvisibilityOfElement("xpath", prop.getProperty("opportunities.snackbarmsg.xpath"));
		boolean verifyDisplayed = verifyDisplayed(locateElement("xpath", prop.getProperty("common.noitems.xpath")));
		Assert.assertTrue(verifyDisplayed);

		return this;
	}

	public OpportunityPage searchOpportunity(String searchText) throws InterruptedException {
		clearAndType(locateElement("xpath", prop.getProperty("opportunities.searchopportunity.xpath")), searchText);
		Thread.sleep(3000);
		return this;
	}

	public OpportunityPage clickOnOpportunityText() throws InterruptedException {
		click(locateElement("xpath", prop.getProperty("opportunities.opportunitytext.xpath")));
		Thread.sleep(2000);
		return this;
	}

	public OpportunityPage clickOnFirstSearchElement() {
		waitUntilStalenessof(locateElement("xpath", prop.getProperty("opportunities.firstSearchedElement.xpath")));
		click(locateElement("xpath", prop.getProperty("opportunities.firstSearchedElement.xpath")));
		return this;
	}

	public OpportunityPage clickOnEditButton() {
		click(locateElement("xpath", prop.getProperty("opportunities.editBtn.xpath")));
		return this;
	}

	public OpportunityPage clickDeleteButton() {
		click(locateElement("xpath", prop.getProperty("opportunities.deleteBtn.xpath")));
		return this;
	}

	public OpportunityPage acceptDelete() {
		click(locateElement("xpath", prop.getProperty("opportunities.acceptDelete.xpath")));
		return this;
	}

	public OpportunityPage clickDeliveryTextBox() throws InterruptedException {
		clickUsingJs(locateElement("xpath", prop.getProperty("opportunities.deliverytxtbx.xpath")));
		return this;
	}

	public OpportunityPage selectInprogressDeliveryOption() {
		clickUsingJs(locateElement("xpath", prop.getProperty("opportunities.inprogressDeliveryOption.xpath")));
		return this;
	}

	public OpportunityPage enterDescription(String enterDescription) {
		clearAndType(locateElement("xpath", prop.getProperty("opportunities.description.xpath")), enterDescription);
		return this;
	}

	public OpportunityPage validateStageText(String verifyStageText) {
		waitUntilStalenessof(locateElement("xpath", prop.getProperty("opportunities.firstSearchedElement.xpath")));
		Assert.assertEquals(verifyStageText,
				getTextMessage(locateElement("xpath", prop.getProperty("opportunities.stagetextresults.xpath"))));
		return this;
	}

	public OpportunityPage clickRefreshButton() {
		click(locateElement("xpath", prop.getProperty("opportunities.refreshbtn.xpath")));
		return this;
	}

}
