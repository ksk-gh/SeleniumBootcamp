package com.salesforce.cases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC015_CreateIndividualsWithoutLastName {
	
		@Test
		public void tc015(){
		String errorText="Complete this field.";
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		String toastMessage = "Individual \"Kadirvelan\" was created.";

		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		driver.findElement(By.id("Login")).click();

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		driver.findElement(By.xpath("//button[text()='View All']")).click();

		WebElement individualLink = driver
				.findElement(By.xpath("//*[contains(@class,'slds-truncate') and text()='Individuals']"));

		executor.executeScript("arguments[0].click();", individualLink);

		driver.findElement(By.xpath("(//*[@title='Individuals']/parent::*//div)[1]")).click();
		WebElement newIndividualLink = driver.findElement(By.xpath("//span[text()='New Individual']"));
		executor.executeScript("arguments[0].click();", newIndividualLink);

		driver.findElement(By.xpath("//label/span[text()='First Name']/following::input[1]")).sendKeys("Sankarakarthikeyan");

		driver.findElement(By.xpath("(//*[@title='Save'])[1]")).click();
		
		String getErrorMessage = driver.findElement(By.xpath("//*[text()='Last Name']/parent::label/parent::div/parent::div//ul[contains(@class,'has-error')]")).getText();
		
		
		Assert.assertEquals(errorText, getErrorMessage);

		/*
		 * WebElement snackBar =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath(
		 * "(//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText'])[1]"
		 * ))); String snackMessage = snackBar.getText();
		 * System.out.println(snackMessage);
		 */

	//	Assert.assertEquals(toastMessage, snackMessage);

	}
}
