package com.salesforce.cases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.salesforce.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC002_EditOpportunity extends ProjectSpecificMethods{
	@BeforeTest
	public void setData() {
		excelFileName="TC002";
	}

	@Test(dataProvider = "Dynamic_Data", enabled=true)
	public void tc002(String userName, String passWord, String enterOpportunity, String enterDescription, String verifySnackBarText, String stageName) throws InterruptedException {
		
		/*
		 * if (driver.getTitle().contains("Developer Edition")) {
		 * driver.findElement(By.xpath("//*[@class='switch-to-lightning']")).click(); }
		 */
		
		LoginPage login = new LoginPage();
		
		login.enterUserName(userName)
		.enterPassword(passWord)
		.clickLogin()
		.clickAppLauncher()
		.clickViewAll()
		.clickSalesLink()
		.clickOpportunityLink()
		.searchOpportunity(enterOpportunity)
		//.clickOnOpportunityText()
		.clickRefreshButton()
		.clickOnFirstSearchElement()
		.clickOnEditButton()
		.clickCloseDate()
		.clickNextDay()
		.clickStageDropdown()
		.selectPerceptionAnalysisValue()
		.clickDeliveryTextBox()
		.selectInprogressDeliveryOption()
		.enterDescription(enterDescription)
		.clickSaveButton()
		.getSnackBarMessage(verifySnackBarText)
		.validateStageText(stageName);
		
		
		
		
		
		/*
		 * LoginPage loginPage = new LoginPage(); loginPage.enterUserName(searchText);
		 * 
		 * 
		 * driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		 * 
		 * //3. Click view All and click Sales from App Launcher
		 * 
		 * driver.findElement(By.xpath("//button[text()='View All']")).click();
		 * driver.findElement(By.xpath("//*[text()='Sales']")).click();
		 * Thread.sleep(2000);
		 * 
		 * //4. Click on Opportunity tab
		 * 
		 * WebElement opportunityLink =
		 * driver.findElement(By.xpath("//a[@title='Opportunities']/span"));
		 * JavascriptExecutor executor = (JavascriptExecutor)driver;
		 * executor.executeScript("arguments[0].click();", opportunityLink);
		 * 
		 * 
		 * //click on search opportunity WebElement searchOpportunity =
		 * driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"));
		 * Thread.sleep(2000); searchOpportunity.sendKeys(searchText,Keys.ENTER);
		 * 
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath("//lst-breadcrumbs//span[text()='Opportunities']"
		 * )).click(); Thread.sleep(2000);
		 * driver.findElement(By.xpath("//tbody/tr[1]/td[8]//a")).click();
		 * driver.findElement(By.xpath("//a[@title='Edit']")).click();
		 * 
		 * 
		 * WebElement datePicker =
		 * driver.findElement(By.xpath("//input[@name='CloseDate']"));
		 * driver.executeScript("arguments[0].click();", datePicker);
		 * 
		 * 
		 * driver.findElement(By.xpath(
		 * "//*[contains(@class,'slds-is-today')]/following::td[1]/span[1]")).click();
		 * 
		 * WebElement stageDropdown =
		 * driver.findElement(By.xpath("//*[contains(@aria-label,'Stage,')]"));
		 * stageDropdown.click(); WebElement perceptionAnalysisValue =
		 * driver.findElement(By.xpath("//span[@title='Perception Analysis']"));
		 * perceptionAnalysisValue.click();
		 * 
		 * WebElement deliveryTextbox= driver.findElement(By.xpath(
		 * "//button[contains(@aria-label,'Delivery/Installation')]"));
		 * 
		 * Thread.sleep(1000);
		 * driver.executeScript("arguments[0].click();",deliveryTextbox);
		 * 
		 * WebElement inProgress =
		 * driver.findElement(By.xpath("//*[@data-value='In progress']"));
		 * 
		 * driver.executeScript("arguments[0].click();",inProgress);
		 * 
		 * 
		 * driver.findElement(By.xpath("//*[@class='slds-textarea']")).sendKeys(
		 * "Salesforce");
		 * 
		 * WebElement saveButton =
		 * driver.findElement(By.xpath("//button[@name='SaveEdit']"));
		 * saveButton.click();
		 * 
		 * WebElement snackBar =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText']"
		 * ))); System.out.println(snackBar.getText());
		 * 
		 * //Thread.sleep(2000); searchOpportunity.clear(); Thread.sleep(2000);
		 * 
		 * searchOpportunity.sendKeys(searchText,Keys.ENTER); Thread.sleep(2000);
		 * driver.findElement(By.xpath("//lst-breadcrumbs//span[text()='Opportunities']"
		 * )).click();
		 * 
		 * String getText =
		 * driver.findElement(By.xpath("//tbody/tr[1]/td[5]")).getText();
		 * System.out.println(getText); Assert.assertEquals(verifyStageText, getText);
		 */
		
	}
	
}
