package com.salesforce.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.salesforce.cases.ReadExcel;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectSpecificMethods {
	public static RemoteWebDriver driver;
	public static WebDriverWait wait;
	public String excelFileName;
	public static Properties prop_lang;
	public static Properties prop;

	@BeforeMethod
	// @Parameters({ "browser", "url" })
	public void BeforeMethod() throws IOException {
		prop = new Properties();
		FileInputStream file = new FileInputStream(new File("src/main/resources/AppConfig.properties"));
		prop.load(file);
		String url = prop.getProperty("appURL");
		String browser = prop.getProperty("browser");
		// String language=prop.getProperty("language");
		/*
		 * prop_lang = new Properties(); FileInputStream file1 = new FileInputStream(new
		 * File("src/main/resources/"+language+".properties")); prop.load(file1);
		 */

		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	}

	@AfterMethod(enabled = true)
	public void AfterMethod() {
		driver.quit();
	}

	@DataProvider(name = "Dynamic_Data")
	public String[][] testData() throws IOException {
		String[][] data = ReadExcel.getData(excelFileName);
		return data;

	}

}
