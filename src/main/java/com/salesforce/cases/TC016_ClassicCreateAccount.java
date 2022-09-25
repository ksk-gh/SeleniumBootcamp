package com.salesforce.cases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC016_ClassicCreateAccount {
	@Test
	public void tc016() {
		String street="Street";
		String city="Trichy";
		String state="Tamilnadu";
		String zipCode="620001";
		String country="India";
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
		
		//System.out.println(driver.getTitle().contains("Developer Edition"));
		if(driver.getTitle().contains("Developer Edition")) {
			driver.findElement(By.xpath("//*[@class='switch-to-lightning']")).click();
		}

		driver.findElement(By.xpath("//*[contains(@class,'photoContainer forceSocialPhoto')]")).click();
		driver.findElement(By.xpath("//*[text()='Switch to Salesforce Classic']")).click();
		
		driver.findElement(By.id("createNewButton")).click();
		
		driver.findElement(By.xpath("//*[@title='Account']")).click();
		
		driver.findElement(By.xpath("//*[@class='requiredInput']/input")).sendKeys("Sankarakarthi");
		driver.findElement(By.xpath("//*[text()='Billing Street']/parent::td/following-sibling::td[1]/textarea")).sendKeys(street);
		driver.findElement(By.xpath("//*[text()='Billing City']/parent::td/following-sibling::td[1]/input")).sendKeys(city);
		driver.findElement(By.xpath("//*[text()='Billing State/Province']/parent::td/following-sibling::td[1]/input")).sendKeys(state);
		driver.findElement(By.xpath("//*[text()='Billing Zip/Postal Code']/parent::td/following-sibling::td[1]/input")).sendKeys(zipCode);
		driver.findElement(By.xpath("//*[text()='Billing Country']/parent::td/following-sibling::td[1]/input")).sendKeys(country);
	
		
		driver.findElement(By.xpath("//*[@class='bodySmall']/a")).click();

		 
		 
		  String getStreet = driver.findElement(By.xpath("//*[text()='Shipping Street']/parent::td/following-sibling::td[1]/textarea")).getAttribute("value");
		  Assert.assertEquals(street, getStreet);
		  
		  String getCity=driver.findElement(By.
		  xpath("//*[text()='Shipping City']/parent::td/following-sibling::td[1]/input"
		  )).getAttribute("value");
		  Assert.assertEquals(city, getCity);
		  
		  String getState = driver.findElement(By.
		  xpath("//*[text()='Shipping State/Province']/parent::td/following-sibling::td[1]/input")).getAttribute("value");
		  Assert.assertEquals(state, getState);

		  
		  String getZipCode =driver.findElement(By.
		  xpath("//*[text()='Shipping Zip/Postal Code']/parent::td/following-sibling::td[1]/input"
		  )).getAttribute("value");
		  Assert.assertEquals(zipCode, getZipCode);
		  
		  String getCountry =driver.findElement(By.
		  xpath("//*[text()='Shipping Country']/parent::td/following-sibling::td[1]/input"
		  )).getAttribute("value");
		  Assert.assertEquals(country, getCountry);

		
	}

}
