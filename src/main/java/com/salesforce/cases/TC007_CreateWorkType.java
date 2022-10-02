package com.salesforce.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC007_CreateWorkType extends BaseClass {

	@BeforeTest
	public void setData() {
		excelFileName = "TC007";
	}

	@Test(dataProvider = "Dynamic_Data",enabled = true)
	public void tc007() {
		/*
		 * WebDriverManager.chromedriver().setup(); ChromeOptions options = new
		 * ChromeOptions(); options.addArguments("--disable-notifications"); WebDriver
		 * driver = new ChromeDriver(options);
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 * 
		 * 
		 * driver.get("https://login.salesforce.com/");
		 * driver.manage().window().maximize();
		 * driver.findElement(By.id("username")).sendKeys(
		 * "hari.radhakrishnan@qeagle.com");
		 * driver.findElement(By.id("password")).sendKeys("India$321");
		 * driver.findElement(By.id("Login")).click();
		 */

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		driver.findElement(By.xpath("//button[text()='View All']")).click();

		WebElement workTypesLink = driver
				.findElement(By.xpath("//*[contains(@class,'slds-truncate') and text()='Work Types']"));

		executor.executeScript("arguments[0].click();", workTypesLink);

		driver.findElement(By.xpath("//div[@title='New']")).click();

		driver.findElement(By.xpath("//label/span[text()='Work Type Name']/following::input[1]"))
				.sendKeys("Salesforce Project");
		driver.findElement(By.xpath("//span[text()='Description']/parent::label/following-sibling::textarea"))
				.sendKeys("Specimen");

		driver.findElement(By.xpath("//*[@placeholder='Search Operating Hours...']")).click();
		WebElement operatingHoursLInk = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='New Operating Hours']")));
		operatingHoursLInk.click();

		// span[text()='Name']/parent::label/following-sibling::input
		WebElement nameTextbox = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Name']/parent::label/following-sibling::input")));
		nameTextbox.sendKeys("UK Shift");
		driver.findElement(By.xpath("(//*[@title='Save'])[2]")).click();

		WebElement estimatedDuration = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[text()='Estimated Duration']/parent::label/following-sibling::input")));
		estimatedDuration.sendKeys("7");

		wait.until(ExpectedConditions.invisibilityOfElementLocated(
				By.xpath("(//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText'])[2]")));

		driver.findElement(By.xpath("(//*[@title='Save'])[1]")).click();

		WebElement snackBar = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//*[@class='forceVisualMessageQueue']//span[@data-aura-class='forceActionsText'])[1]")));
		System.out.println(snackBar.getText());

	}
}
