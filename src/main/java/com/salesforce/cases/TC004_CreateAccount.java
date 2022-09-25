package com.salesforce.cases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC004_CreateAccount {
	
@Test
public static void tc004() throws InterruptedException
{
	String accountName="Sankarakarthikeyan";
	WebDriverManager.chromedriver().setup();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	WebDriver driver =new ChromeDriver(options);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));

	String searchText="Salesforce Automation by Sankarakarthikeyan";
	
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

	WebElement accountsLink = driver.findElement(By.xpath("//a[@title='Accounts']"));
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", accountsLink);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@title='New']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(accountName);
	
	WebElement ownershipTextbox = driver.findElement(By.xpath("//button[contains(@aria-label,'Ownership')]"));
	executor.executeScript("arguments[0].click();", ownershipTextbox);
	
	WebElement publicDropdownValue = driver.findElement(By.xpath("//*[@data-value='Public']"));
	
	executor.executeScript("arguments[0].click();",publicDropdownValue);
	
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	WebElement snackBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText']")));
	System.out.println(snackBar.getText());

	Thread.sleep(3000);
	String getAccountName = driver.findElement(By.xpath("(//*[@class='custom-truncate'])[1]")).getText();
	System.out.println("Got the Account Name: "+getAccountName);
	Assert.assertEquals(accountName, getAccountName);
	
}
}
