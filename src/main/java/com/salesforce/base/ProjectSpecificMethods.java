package com.salesforce.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;*/
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.salesforce.utils.ReadExcel;

public class ProjectSpecificMethods extends SeleniumBase {

	public String excelFileName;
	public static Properties prop_lang;
	public static Properties prop;


	@BeforeSuite
	public void initSuite() {
		createTestReport();
		
	}
	
	@BeforeClass
	public void beforeClass() {
	//	createTestcaseEntry(testCaseName, testDescription, author, category);
		createTestcaseEntry();
	}
	
	
	@BeforeMethod
	public void BeforeMethod() throws IOException {
		prop = new Properties();
		FileInputStream file = new FileInputStream(new File("src/main/resources/AppConfig.properties"));
		prop.load(file);
		String url = prop.getProperty("appURL");
		String browser = prop.getProperty("browser");
		//test=startIteration(testNodes);
		startIteration();
		startApp(browser, url);
	}

	@AfterSuite
	public void afterSuite(){
		publishReport();
		//getDriver().quit();
	}
	
	
	@AfterMethod(enabled = true)
	public void AfterMethod() {
		
	getDriver().quit();
	}
	
	@AfterTest
	public void AfterTest() {
		//closeAllBrowsers();
	}
	
	
	public void invoke() {
	
		
	}

	@DataProvider(name = "Dynamic_Data")
	public String[][] testData() throws IOException {
		String[][] data = ReadExcel.getData(excelFileName);
		return data;

	}

}
