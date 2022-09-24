package com.salesforce.cases;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002_EditOpportunity {

	public static void main(String[] args) throws InterruptedException {
		String verifyText="Perception Analysis";
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver =new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String searchText="Salesforce Automation by Sankarakarthikeyan";
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));

		//1. Login to https://login.salesforce.com
		
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		driver.findElement(By.id("Login")).click();
		
		//2. Click on toggle menu button from the left corner
		
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
		
		WebElement today=driver.findElement(By.xpath("//*[contains(@class,'slds-is-today')]/span"));
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
