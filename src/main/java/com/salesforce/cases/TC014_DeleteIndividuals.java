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

public class TC014_DeleteIndividuals {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		String firstName="Sankarakarthi";

		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		driver.findElement(By.id("Login")).click();

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		driver.findElement(By.xpath("//button[text()='View All']")).click();

		WebElement individualLink = driver
				.findElement(By.xpath("//p[contains(@class,'slds-truncate') and text()='Individuals']"));

		executor.executeScript("arguments[0].click();", individualLink);

		WebElement individualsMenuLink = driver.findElement(By.xpath("//*[@title='Not added to nav bar']/parent::a"));

		executor.executeScript("arguments[0].click();", individualsMenuLink);

		driver.findElement(By.xpath("//*[@class='slds-input']")).sendKeys("Kadirvelan");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h1/span[text()='Recently Viewed']")).click();
		
		Thread.sleep(2000);
		
		WebElement clickDropDown =		driver.findElement(By.xpath("//tbody/tr[1]/td[6]/span/div/a"));
	executor.executeScript("arguments[0].click();", clickDropDown);
		Thread.sleep(2000);
		
		WebElement deleteButton=driver.findElement(By.xpath("//a[@title='Delete']/parent::li"));
		deleteButton.click();

		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@title='Delete']")).click();
		/*
		 * driver.findElement(By.xpath(
		 * "//span[text()='Salutation']/parent::span/following-sibling::div//a")).click(
		 * ); driver.findElement(By.xpath("//a[@title='Mr.']")).click(); WebElement
		 * firstNameTextBox = driver.findElement(By.
		 * xpath("//label/span[text()='First Name']/following::input[1]"));
		 * firstNameTextBox.clear(); firstNameTextBox.sendKeys(firstName);
		 * 
		 * 
		 * driver.findElement(By.xpath("(//*[@title='Save'])[1]")).click();
		 */
		
		WebElement snackBar = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText'])[1]")));
		String snackMessage = snackBar.getText();
		System.out.println(snackMessage.contains(firstName));
		Assert.assertTrue(snackMessage.contains(firstName));
	}
}
