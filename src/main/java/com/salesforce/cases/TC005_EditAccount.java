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
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC005_EditAccount {
	@Test
public static void tc005() throws InterruptedException
{
	String accountName="Sankarakarthikeyan";
	WebDriverManager.chromedriver().setup();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	WebDriver driver =new ChromeDriver(options);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));

	//String searchText="Sankarakarthikeyan";
	String mobileNumber="(952)451-6666";
	
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

	driver.findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys(accountName,Keys.ENTER);
	
	Thread.sleep(2000);
	//driver.findElement(By.xpath("//button[@name='refreshButton']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//tbody/tr[1]/td[6]//a")).click();
	Thread.sleep(1000);

	driver.findElement(By.xpath("//a[@title='Edit']")).click();
	
	
	
	WebElement typeDropdown = driver.findElement(By.xpath("//*[text()='Type']/following::div[1]//button"));
	executor.executeScript("arguments[0].click();", typeDropdown);


	driver.findElement(By.xpath("//*[@title='Technology Partner']")).click();
	
driver.findElement(By.xpath("//*[text()='Industry']/following::div[1]//button")).click();
	//industryDropdown.click();
	driver.findElement(By.xpath("//*[@data-value='Healthcare']")).click();
	driver.findElement(By.xpath("//*[text()='Billing Street']/following-sibling::div//textarea[@name='street']")).sendKeys("Billing address");
	driver.findElement(By.xpath("//*[text()='Billing City']/following-sibling::div/input")).sendKeys("Trichy");
	driver.findElement(By.xpath("//*[contains(text(),'Billing Zip')]/following-sibling::div/input")).sendKeys("620001");
	driver.findElement(By.xpath("//*[contains(text(),'Billing State')]/following-sibling::div/input")).sendKeys("Tamilnadu");
	driver.findElement(By.xpath("//*[text()='Billing Country']/following-sibling::div/input")).sendKeys("India");
	
	driver.findElement(By.xpath("//*[text()='Shipping Street']/following-sibling::div//textarea[@name='street'][1]")).sendKeys("Shipping address");
	driver.findElement(By.xpath("//*[text()='Shipping City']/following-sibling::div/input")).sendKeys("Trichy");
	driver.findElement(By.xpath("//*[contains(text(),'Shipping Zip')]/following-sibling::div/input")).sendKeys("620001");
	driver.findElement(By.xpath("//*[contains(text(),'Shipping State')]/following-sibling::div/input")).sendKeys("Tamilnadu");
	driver.findElement(By.xpath("//*[text()='Shipping Country']/following-sibling::div/input")).sendKeys("India",Keys.TAB);
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[contains(@aria-label,'Customer Priority')]")).click();
	driver.findElement(By.xpath("//*[@data-value='Low']")).click();
	
	driver.findElement(By.xpath("//button[contains(@aria-label,'SLA,')]")).click();
	driver.findElement(By.xpath("//*[@data-value='Silver']")).click();
	
	WebElement activeDropdown = driver.findElement(By.xpath("//button[contains(@aria-label,'Active')]"));
	
	executor.executeScript("arguments[0].click();",activeDropdown);
	driver.findElement(By.xpath("//span[@title='No']")).click();
	
	WebElement phoneNumber=driver.findElement(By.xpath("//label[text()='Phone']/following-sibling::div/input"));
	executor.executeScript("arguments[0].click();",phoneNumber);
	phoneNumber.clear();
	phoneNumber.sendKeys(mobileNumber);
	
	driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	
	WebElement snackBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText']")));
	System.out.println(snackBar.getText());
	
	Thread.sleep(2000);
	String getPhoneNumber = driver.findElement(By.xpath("//tbody/tr[1]/td[4]")).getText();

	Assert.assertEquals(mobileNumber, getPhoneNumber);

}
}
