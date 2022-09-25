package com.salesforce.cases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_CreateOpportunity {

	@Test
	public static void tc01() throws InterruptedException {

		/*
		 * 1. Login to https://login.salesforce.com 
		 * 2. Click on toggle menu button from the left corner 
		 * 3. Click view All and click Sales from App Launcher 
		 * 4. Click on Opportunity tab 
		 * 5. Click on New button 
		 * 6. Enter Opportunity name as 'Salesforce Automation by Your Name,Get the text and Store it 
		 * 7. Choose close date as Today 
		 * 8. Select 'Stage' as Need Analysis 
		 * 9. click Save and VerifyOppurtunity Name 
		 * Expected Result: New Opportunity should be created with name as 'Salesforce Automation by Your Name'
		 */

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		RemoteWebDriver driver = new ChromeDriver(options);
		//WebDriver driver = new WebDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		driver.findElement(By.id("Login")).click();
		
		if(driver.getTitle().contains("Developer Edition")) {
			driver.findElement(By.xpath("//*[@class='switch-to-lightning']")).click();
		}
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//*[text()='Sales']")).click();
		Thread.sleep(2000);
		WebElement opportunityLink = driver.findElement(By.xpath("//a[@title='Opportunities']/span"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		// driver.executeScript();
		executor.executeScript("arguments[0].click();", opportunityLink);
		
		driver.findElement(By.xpath("//div[@title='New']")).click();
		WebElement opportunityName = driver.findElement(By.xpath("//input[@name='Name']"));
		opportunityName.sendKeys("Salesforce Automation by Sankarakarthikeyan");

		String opportunityValue = opportunityName.getAttribute("value");
		System.out.println(opportunityValue);
		WebElement datePicker = driver.findElement(By.xpath("//input[@name='CloseDate']"));
		executor.executeScript("arguments[0].click();", datePicker);

		driver.findElement(By.xpath("//button[@name='today']")).click();

		WebElement stageDropdown = driver.findElement(By.xpath("//*[contains(@aria-label,'Stage,')]"));
		stageDropdown.click();
		WebElement needAnalysisValue = driver.findElement(By.xpath("//span[@title='Needs Analysis']"));
		needAnalysisValue.click();
		WebElement saveButton = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
		saveButton.click();
		//WebElement snackBar = driver.findElement(By.xpath("//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText']"));
		WebElement snackBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText']")));
		System.out.println(snackBar.getText());
		String validateText = driver.findElement(By.xpath("//*[@slot='primaryField']")).getText();

		Assert.assertEquals(opportunityValue, validateText);
		executor.executeScript("arguments[0].click();", opportunityLink);
		Thread.sleep(2000);
		WebElement searchOpportunity = driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"));
		Thread.sleep(2000);
		searchOpportunity.sendKeys("sankarakarthikeyan",Keys.ENTER);
		Thread.sleep(2000);
	

		WebElement refreshButton = driver.findElement(By.xpath("//button[@name='refreshButton']"));
		refreshButton.click();
		
		String verifyText = driver.findElement(By.xpath("//tbody/tr[1]/th/span/a")).getText();
		System.out.println("Text verified is " + verifyText);

		Assert.assertEquals(opportunityValue, verifyText);
	}

}
