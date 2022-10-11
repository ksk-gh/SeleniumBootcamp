package com.salesforce.cases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.salesforce.base.BaseClass;

public class TC016_ClassicCreateAccount extends BaseClass {
	@BeforeTest
	public void setData() {
		excelFileName = "TC016";
	}

	@Test(dataProvider = "Dynamic_Data",enabled = true)
	public void tc016(String firstName,String street,String city,String state,String zipCode,String country) throws InterruptedException {
		/*
		 * String street = "Street"; String city = "Trichy"; String state = "Tamilnadu";
		 * String zipCode = "620001"; String country = "India";
		 * 
		 * String firstName = "Sankarakarthikeyan";
		 */

		if (driver.getCurrentUrl().contains("qeagle-dev-ed.my.salesforce.com")) {
			driver.findElement(By.xpath("//*[@class='switch-to-lightning']")).click();
		}

		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));
		WebElement profilePic = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-aura-class='forceEntityIcon']")));

		profilePic.click();
		// WebElement profilePic =
		// driver.findElement(By.xpath("//*[@data-aura-class='forceEntityIcon']/span/img"));
		// executor.executeScript("arguments[0].click();", profilePic);

		driver.findElement(By.xpath("//*[text()='Switch to Salesforce Classic']")).click();

		driver.findElement(By.id("createNewButton")).click();

		driver.findElement(By.xpath("//*[@title='Account']")).click();

		driver.findElement(By.xpath("//*[@class='requiredInput']/input")).sendKeys(firstName);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Billing Street']/parent::td/following-sibling::td[1]/textarea"))
				.sendKeys(street);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Billing City']/parent::td/following-sibling::td[1]/input"))
				.sendKeys(city);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Billing State/Province']/parent::td/following-sibling::td[1]/input"))
				.sendKeys(state);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Billing Zip/Postal Code']/parent::td/following-sibling::td[1]/input"))
				.sendKeys(zipCode);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Billing Country']/parent::td/following-sibling::td[1]/input"))
				.sendKeys(country);

		driver.findElement(By.xpath("//*[@class='bodySmall']/a")).click();

		String getStreet = driver
				.findElement(By.xpath("//*[text()='Shipping Street']/parent::td/following-sibling::td[1]/textarea"))
				.getAttribute("value");
		Assert.assertEquals(street, getStreet);

		String getCity = driver
				.findElement(By.xpath("//*[text()='Shipping City']/parent::td/following-sibling::td[1]/input"))
				.getAttribute("value");
		Assert.assertEquals(city, getCity);

		String getState = driver
				.findElement(
						By.xpath("//*[text()='Shipping State/Province']/parent::td/following-sibling::td[1]/input"))
				.getAttribute("value");
		Assert.assertEquals(state, getState);

		String getZipCode = driver
				.findElement(
						By.xpath("//*[text()='Shipping Zip/Postal Code']/parent::td/following-sibling::td[1]/input"))
				.getAttribute("value");
		Assert.assertEquals(zipCode, getZipCode);

		String getCountry = driver
				.findElement(By.xpath("//*[text()='Shipping Country']/parent::td/following-sibling::td[1]/input"))
				.getAttribute("value");
		Assert.assertEquals(country, getCountry);

		// driver.findElement(By.xpath("//*[contains(@class,'dateOnlyInput')]/input")).click();

		LocalDate addTwentyToCurrent = LocalDate.now().plusDays(20);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/YYYY");
		String twentyDaysAdded = formatter.format(addTwentyToCurrent);

		driver.findElement(By.xpath("//span[contains(@class,'dateInput')]/input")).sendKeys(twentyDaysAdded,
				Keys.ENTER);
		// driver.findElement(null)
		// driver.findElement(By.xpath("//*[@class='dateFormat']/a")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id='bottomButtonRow']/input[1]")).click();

		boolean displayed = driver
				.findElement(By.xpath("//*[contains(@class,'individualPalette')]//*[text()='" + firstName + "']"))
				.isDisplayed();
		Assert.assertTrue(displayed);

		boolean displayed2 = driver.findElement(By.xpath("//h2[text()='Account Detail']")).isDisplayed();
		Assert.assertTrue(displayed2);

		driver.findElement(By.xpath("//*[@class='switch-to-lightning']")).click();

		Thread.sleep(10000);

		//driver.close();

	}

}
