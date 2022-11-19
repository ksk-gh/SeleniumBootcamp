package com.salesforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.salesforce.base.ProjectSpecificMethods;

public class TasksPage extends ProjectSpecificMethods {

	public TasksPage clickTasksDownArrow() {
		click(locateElement("xpath", prop.getProperty("tasks.tasksdownarrow.xpath")));
		return this;
	}

	public TasksPage clickNewTasksLink() {
		clickUsingJs(locateElement("xpath", prop.getProperty("tasks.newtasks.xpath")));
		return this;
	}

	public TasksPage enterSubject(String subject) {
		type(locateElement("xpath", prop.getProperty("tasks.subject.xpath")), subject);
		return this;
	}

	public TasksPage clickName() {
		click(locateElement("xpath", prop.getProperty("tasks.name.xpath")));
		return this;
	}

	public TasksPage selectContactNameFromList(String statusoption) {
		WebElement status = driver.findElement(By.xpath(prop.getProperty("//a[text()='" + statusoption + "']")));
		click(status);
		return this;
	}

	public TasksPage clickStatus() {
		click(locateElement("xpath", prop.getProperty("tasks.status.xpath")));
		return this;
	}

	public TasksPage selectStatusOption(String statusoption) {
		WebElement statusOptions = driver.findElement(By.xpath("//a[text()='" + statusoption + "']"));
		clickUsingJs(statusOptions);
		return this;
	}

	public TasksPage clickSaveButton() {
		click(locateElement("xpath", prop.getProperty("tasks.savebutton.xpath")));
		return this;
	}

	public TasksPage validateSnackBarMsg(String snackBarMsg) {
		waitUntilElementLocated("xpath", prop.getProperty("tasks.snackbarmsg.xpath"));
		Assert.assertEquals(snackBarMsg,
				getTextMessage(locateElement("xpath", prop.getProperty("tasks.snackbarmsg.xpath"))));
		return this;
	}

}
