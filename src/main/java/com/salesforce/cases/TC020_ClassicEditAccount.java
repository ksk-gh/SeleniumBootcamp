package com.salesforce.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.salesforce.base.BaseClassNonPOM;

public class TC020_ClassicEditAccount extends BaseClassNonPOM {
	@BeforeTest
	public void setData() {
		excelFileName = "TC017";
	}

	@Test(dataProvider = "Dynamic_Data", enabled = true)
	public void tc017(String street, String city, String state, String zipCode, String country)
			throws InterruptedException {

		if (driver.getTitle().contains("Developer Edition")) {
			driver.findElement(By.xpath("//*[@class='switch-to-lightning']")).click();
		}

		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));

		WebElement profilePic = driver.findElement(By.xpath("//*[@data-aura-class='forceSocialPhoto']"));
		executor.executeScript("arguments[0].click();", profilePic);

		driver.findElement(By.xpath("//*[text()='Switch to Salesforce Classic']")).click();
		driver.findElement(By.id("AllTab_Tab")).click();
		driver.findElement(By.xpath("//img[@title='Accounts']/parent::a")).click();

		driver.findElement(By.xpath("//th[contains(@class,'dataCell')]/a[text()='Sankarakarthi']")).click();

		driver.findElement(By.xpath("(//*[@title='Edit'])[1]")).click();

		WebElement shippingStreet = driver
				.findElement(By.xpath("//*[text()='Shipping Street']/parent::td/following-sibling::td[1]/textarea"));
		shippingStreet.clear();
		shippingStreet.sendKeys(street);

		WebElement shippingCity = driver
				.findElement(By.xpath("//*[text()='Shipping City']/parent::td/following-sibling::td[1]/input"));

		shippingCity.clear();
		shippingCity.sendKeys(city);

		WebElement shippingState = driver.findElement(
				By.xpath("//*[text()='Shipping State/Province']/parent::td/following-sibling::td[1]/input"));

		shippingState.clear();
		shippingState.sendKeys(state);

		WebElement ShippingZipCode = driver.findElement(
				By.xpath("//*[text()='Shipping Zip/Postal Code']/parent::td/following-sibling::td[1]/input"));
		ShippingZipCode.clear();
		ShippingZipCode.sendKeys(zipCode);

		WebElement ShippingCountry = driver
				.findElement(By.xpath("//*[text()='Shipping Country']/parent::td/following-sibling::td[1]/input"));
		ShippingCountry.clear();
		ShippingCountry.sendKeys(country);

		driver.findElement(By.xpath("//*[@id='bottomButtonRow']/input[1]")).click();

		String getAddressText = driver.findElement(By.xpath("//td[text()='Shipping Address']/following::td[1]/div"))
				.getText();

		boolean containsAddress = getAddressText.contains(street);

		Assert.assertTrue(containsAddress);
		driver.findElement(By.xpath("//*[@class='switch-to-lightning']")).click();
		Thread.sleep(50000);
		// driver.close();

	}

}
