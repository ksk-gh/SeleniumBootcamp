package com.salesforce.cases;

import java.time.Duration;

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

public class TC003_DeleteOpportunity {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver =new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		String searchText="Salesforce Automation by Sankarakarthikeyan";
		String noItemsText = "No items to display.";
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
		
		WebElement opportunityLink = driver.findElement(By.xpath("//a[@title='Opportunities']/span"));

		//WebElement opportunitytxt = driver.findElement(By.xpath("//lst-breadcrumbs//span[text()='Opportunities']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", opportunityLink);
			
		WebElement searchOpportunity = driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"));
		Thread.sleep(2000);
		searchOpportunity.sendKeys(searchText,Keys.ENTER);
		

		Thread.sleep(2000);
		driver.findElement(By.xpath("//lst-breadcrumbs//span[text()='Opportunities']"));
		driver.findElement(By.xpath("//tbody/tr[1]/td[8]//a")).click();
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@title='Delete']")).click();
		WebElement snackBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText']")));
		System.out.println(snackBar.getText());
		String noItemsGetText = driver.findElement(By.xpath("//span[text()='No items to display.']")).getText();
Assert.assertEquals(noItemsText, noItemsGetText);		
		
	}

}
