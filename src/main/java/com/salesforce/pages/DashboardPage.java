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


	
}
