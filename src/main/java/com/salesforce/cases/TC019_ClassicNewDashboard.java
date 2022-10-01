package com.salesforce.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC019_ClassicNewDashboard extends BaseClass {

	@Test
	public void tc019() throws InterruptedException {
		
		if (driver.getCurrentUrl().contains("qeagle-dev-ed.my.salesforce.com")) {

			driver.findElement(By.xpath("//*[@class='switch-to-lightning']")).click();
			Thread.sleep(5000);
		}
		Thread.sleep(5000);
		if (driver.getCurrentUrl()
				.equals("https://qeagle-dev-ed.lightning.force.com/lightning/setup/SetupOneHome/home")) {
			WebElement profilePic = driver.findElement(By.xpath("//*[@data-aura-class='forceSocialPhoto']"));
			executor.executeScript("arguments[0].click();", profilePic);
		}
		WebElement classicUILink = driver.findElement(By.xpath("//*[text()='Switch to Salesforce Classic']"));
		executor.executeScript("arguments[0].click();", classicUILink);

	}

}
