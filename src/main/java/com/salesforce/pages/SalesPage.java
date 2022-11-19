package com.salesforce.pages;

import com.salesforce.base.ProjectSpecificMethods;

public class SalesPage extends ProjectSpecificMethods {

	public OpportunityPage clickOpportunityLink() {
		clickUsingJs(locateElement("xpath", prop.getProperty("sales.opportunitieslink.xpath")));
		return new OpportunityPage();
	}

	public AccountsPage clickAccountsLink() {
		clickUsingJs(locateElement("xpath", prop.getProperty("sales.accountslink.xpath")));
		return new AccountsPage();
	}

	public TasksPage clickTasksMenu() {
		clickUsingJs(locateElement("xpath", prop.getProperty("sales.tasksmenulink.xpath")));
		return new TasksPage();
	}

}
