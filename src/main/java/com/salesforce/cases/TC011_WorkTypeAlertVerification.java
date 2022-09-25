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
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC011_WorkTypeAlertVerification {

	@Test
	public static void tc011() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		driver.findElement(By.id("Login")).click();

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		driver.findElement(By.xpath("//button[text()='View All']")).click();

		WebElement workTypesLink = driver
				.findElement(By.xpath("//*[contains(@class,'slds-truncate') and text()='Work Types']"));

		executor.executeScript("arguments[0].click();", workTypesLink);

		driver.findElement(By.xpath("//div[@title='New']")).click();
		
		driver.findElement(By.xpath("//label/span[text()='Work Type Name']/following::input[1]")) .sendKeys("Bootcamp");

		 driver.findElement(By.xpath("(//*[@title='Save'])[1]")).click();
		 WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pageLevelErrors']//span")));
			String text = errorMessage.getText();
			System.out.println(text);
			 WebElement errorMessageText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pageLevelErrors']//li")));
				String errormessagevalue= errorMessageText.getText();
				System.out.println(errormessagevalue);
		
	}
}
