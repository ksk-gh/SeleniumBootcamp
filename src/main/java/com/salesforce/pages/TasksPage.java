package com.salesforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.salesforce.base.ProjectSpecificMethods;

public class TasksPage extends ProjectSpecificMethods {

	public TasksPage clickTasksDownArrow() {
		driver.findElement(By.xpath(prop.getProperty("tasks.tasksdownarrow.xpath"))).click();
		return this;
	}
	
	public TasksPage clickNewTasksLink() {
		WebElement newTasksLink = driver
				.findElement(By.xpath(prop.getProperty("tasks.newtasks.xpath")));
		driver.executeScript("arguments[0].click();", newTasksLink);
		return this;
	}
	
	public TasksPage enterSubject(String subject) {
		WebElement subjectTxtBx = driver.findElement(By.xpath(prop.getProperty("tasks.subject.xpath")));
		subjectTxtBx.sendKeys(subject);
		return this;
	}
	

	public TasksPage clickName() {
		driver.findElement(By.xpath(prop.getProperty("tasks.name.xpath"))).click();
		return this;
		
	}
	
	public TasksPage selectContactNameFromList(String statusoption) {
		driver.findElement(By.xpath(prop.getProperty("//a[text()='"+statusoption+"']"))).click();
		return this;
	}
	
	public TasksPage clickStatus() {
		driver.findElement(By.xpath(prop.getProperty("tasks.status.xpath"))).click();
		return this;
		
	}
	
	public TasksPage selectStatusOption(String statusoption) {
		WebElement statusOptions = driver.findElement(By.xpath("//a[text()='"+statusoption+"']"));
		driver.executeScript("arguments[0].click();", statusOptions);

		return this;
	}
	public TasksPage clickSaveButton() {
		WebElement saveButton = driver.findElement(By.xpath(prop.getProperty("tasks.savebutton.xpath")));
		saveButton.click();
		return this;
	}
	
	public TasksPage validateSnackBarMsg(String snackBarMsg) {
		WebElement snackBar = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(prop.getProperty("tasks.snackbarmsg.xpath"))));
		String getSnackBarMsg = snackBar.getText();
		Assert.assertEquals(snackBarMsg, getSnackBarMsg);
		return this;
	}
	
}
