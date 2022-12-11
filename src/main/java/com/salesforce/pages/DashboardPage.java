package com.salesforce.pages;

import com.salesforce.base.ProjectSpecificMethods;

public class DashboardPage extends ProjectSpecificMethods{

	
public DashboardPage clickNewDashboard() {
	
	click(locateElement("xpath", prop.getProperty("dashboard.new.xpath")));
	return this;
}

public DashboardPage enterName(String dashboardName) {
	
	type(locateElement("id", prop.getProperty("dashboard.name.id")), dashboardName);
	return this;
}

public DashboardPage switchToIFrame() throws InterruptedException {

	switchToFrame(locateElement("xpath", prop.getProperty("dashboard.iframe.xpath")));
	Thread.sleep(5000);
	return this;
}

public DashboardPage enterDashboardName(String dashboardName) throws InterruptedException {
	type(locateElement("id", prop.getProperty("dashboard.name.id")), dashboardName);
	Thread.sleep(50000);
	
	return this;
}
	
}
