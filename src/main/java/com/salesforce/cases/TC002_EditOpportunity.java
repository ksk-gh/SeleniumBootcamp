package com.salesforce.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002_EditOpportunity extends BaseClass{

	@Test//(dataProvider = "Dynamic_Data")
	public void tc002() throws InterruptedException {
		
		String verifyText="Perception Analysis";
		String searchText="Salesforce Automation by Sankarakarthikeyan";
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		
		//3. Click view All and click Sales from App Launcher
		
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//*[text()='Sales']")).click();
		Thread.sleep(2000);
		
		//4. Click on Opportunity tab
		
		WebElement opportunityLink = driver.findElement(By.xpath("//a[@title='Opportunities']/span"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", opportunityLink);
			
		WebElement searchOpportunity = driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"));
		Thread.sleep(2000);
		searchOpportunity.sendKeys(searchText,Keys.ENTER);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//lst-breadcrumbs//span[text()='Opportunities']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//tbody/tr[1]/td[8]//a")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		
		
		WebElement datePicker = driver.findElement(By.xpath("//input[@name='CloseDate']"));
		executor.executeScript("arguments[0].click();", datePicker);
		
	//	WebElement today=driver.findElement(By.xpath("//*[contains(@class,'slds-is-today')]/span"));
		/*
		 * String todayDate = today.getText(); int i=Integer.parseInt(todayDate)+1;
		 * driver.findElement(By.xpath("//span[text()='"+i+"']")).click();
		 */
		
		driver.findElement(By.xpath("//*[contains(@class,'slds-is-today')]/following::td[1]/span[1]")).click();
		
		WebElement stageDropdown = driver.findElement(By.xpath("//*[contains(@aria-label,'Stage,')]"));
		stageDropdown.click();
		WebElement needAnalysisValue = driver.findElement(By.xpath("//span[@title='Perception Analysis']"));
		needAnalysisValue.click();
		
		WebElement deliveryTextbox= driver.findElement(By.xpath("//button[contains(@aria-label,'Delivery/Installation')]"));
		
		Thread.sleep(1000);
		executor.executeScript("arguments[0].click();",deliveryTextbox);
		
		WebElement inProgress = driver.findElement(By.xpath("//*[@data-value='In progress']"));
		
		executor.executeScript("arguments[0].click();",inProgress);

		
		driver.findElement(By.xpath("//*[@class='slds-textarea']")).sendKeys("Salesforce");
		
		WebElement saveButton = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
		saveButton.click();
		
		WebElement snackBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText']")));
		System.out.println(snackBar.getText());
		
		//Thread.sleep(2000);
		searchOpportunity.clear();
		Thread.sleep(2000);

		searchOpportunity.sendKeys(searchText,Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//lst-breadcrumbs//span[text()='Opportunities']")).click();

		String getText = driver.findElement(By.xpath("//tbody/tr[1]/td[5]")).getText();
		System.out.println(getText);
		Assert.assertEquals(verifyText, getText);
		
	}
	
}
