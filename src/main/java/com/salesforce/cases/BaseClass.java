package com.salesforce.cases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public ChromeDriver driver;
	public static WebDriverWait wait;
	JavascriptExecutor executor;
	public String excelFileName;
	
	
	@BeforeMethod
	@Parameters("url")
	public void BeforeMethod(String url) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		executor = (JavascriptExecutor) driver;
		// WebDriver driver = new WebDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		driver.findElement(By.id("Login")).click();
	}

	@AfterMethod(enabled = true)
	public void AfterMethod() {
	driver.quit();
	}
	
	@DataProvider(name= "Dynamic_Data") 	
	public String[][] testData()throws IOException
	{
		String[][] data = ReadExcel.getData(excelFileName);
	//	System.out.println(data[0][0] + " " +data[0][1]);
		return data;
		
		
	}
}
