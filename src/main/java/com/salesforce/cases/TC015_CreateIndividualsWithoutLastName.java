package com.salesforce.cases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.salesforce.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC015_CreateIndividualsWithoutLastName extends ProjectSpecificMethods {

	@BeforeTest
	public void setData() {
		excelFileName = "TC015";
	}

	@Test(dataProvider = "Dynamic_Data",enabled = true)
	public void tc015(String username, String password,String firstName, String errorText) {
		//String errorText = "Complete this field.";

		
		LoginPage login = new LoginPage();

		login.enterUserName(username)
		.enterPassword(password)
		.clickLogin()
		.clickAppLauncher()
		.clickViewAll()
		.clickIndividualsLink()
		.clickDownArrow()
		.clickNewIndividualLink()
		.enterFirstName(firstName)
		.clickSaveButton()
		.validateLastNameErrormessage(errorText);
		
		
		/*
		 * driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		 * 
		 * driver.findElement(By.xpath("//button[text()='View All']")).click();
		 * 
		 * WebElement individualLink = driver .findElement(By.
		 * xpath("//*[contains(@class,'slds-truncate') and text()='Individuals']"));
		 * 
		 * executor.executeScript("arguments[0].click();", individualLink);
		 * 
		 * driver.findElement(By.xpath("(//*[@title='Individuals']/parent::/div)[1]")).
		 * click(); WebElement newIndividualLink =
		 * driver.findElement(By.xpath("//span[text()='New Individual']"));
		 * executor.executeScript("arguments[0].click();", newIndividualLink);
		 * 
		 * driver.findElement(By.
		 * xpath("//label/span[text()='First Name']/following::input[1]"))
		 * .sendKeys(firstName);
		 * 
		 * driver.findElement(By.xpath("(//*[@title='Save'])[1]")).click();
		 * 
		 * String getErrorMessage = driver.findElement(By.xpath(
		 * "//*[text()='Last Name']/parent::label/parent::div/parent::div//ul[contains(@class,'has-error')]"
		 * )) .getText();
		 * 
		 * System.out.println(getErrorMessage); Assert.assertEquals(errorText,
		 * getErrorMessage);
		 */	

	}
}
