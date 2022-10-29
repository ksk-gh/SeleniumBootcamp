package com.salesforce.cases;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.salesforce.base.BaseClass;

public class TC021_ClassicNewEvent extends BaseClass {

	@BeforeTest
	public void setData() {
		excelFileName = "TC018";
	}

	@Test(dataProvider = "Dynamic_Data", enabled = true)
	public void tc018(String call, String searchName, String filePath, String verifyFile) throws InterruptedException {

		if (driver.getTitle().contains("Developer Edition")) {
			WebElement newUiLink = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='switch-to-lightning']")));

			newUiLink.click();

		}
		Thread.sleep(5000);

		if (driver.getCurrentUrl()
				.equals("https://qeagle-dev-ed.lightning.force.com/lightning/setup/SetupOneHome/home")) {

			WebElement profilePic = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@data-aura-class='forceSocialPhoto']")));

			executor.executeScript("arguments[0].click();", profilePic);

			WebElement classicUILink = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[text()='Switch to Salesforce Classic']")));
			executor.executeScript("arguments[0].click();", classicUILink);

		}

		driver.findElement(By.id("createNewButton")).click();

		driver.findElement(By.xpath("//*[@title='Event']")).click();

		driver.findElement(By.id("evt5")).sendKeys(call);
		driver.findElement(By.id("StartDateTime")).click();
		driver.findElement(By.xpath("//*[contains(@class,'todayDate')]/following::td[1]")).click();

		driver.findElement(By.id("EndDateTime")).click();
		driver.findElement(By.xpath("//*[contains(@class,'todayDate')]/following::td[2]")).click();

		driver.findElement(By.id("whobtn")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> listOfWindows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(listOfWindows.get(1));
		// driver.switchTo().window(listOfWindows.get(1));
		driver.switchTo().frame("searchFrame");
		// System.out.println(listOfWindows.size());
		// System.out.println("Title of Switched Window " + driver.getTitle());
		Thread.sleep(2000);

		/*
		 * String MainWindow = driver.getWindowHandle();
		 * 
		 * 
		 * // Here we will check if child window has other child windows and when child
		 * // window // is the main window it will come out of loop. while
		 * (i1.hasNext()) { String ChildWindow = i1.next(); if (MainWindow !=
		 * ChildWindow) { driver.switchTo().window(ChildWindow); // driver.close(); //
		 * System.out.println("Child window closed"); }
		 */

		driver.findElement(By.xpath("//*[@placeholder='Search...']")).sendKeys(searchName);

		driver.findElement(By.xpath("//*[@title='Go!']")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("resultsFrame");

		driver.findElement(By.xpath("//*[contains(@class,'first')]/th/a")).click();
		// driver.switchTo().defaultContent();
		driver.switchTo().window(listOfWindows.get(0));

		driver.findElement(By.xpath("//input[@value='Attach File']")).click();
		// .sendKeys("F:\\Trainings\\TestLeaf\\Selenium Bootcamp\\week3\\Dummy.txt");

		Set<String> windowSecondHandles = driver.getWindowHandles();
		ArrayList<String> listOfWindows2 = new ArrayList<String>(windowSecondHandles);
		driver.switchTo().window(listOfWindows2.get(1));
		System.out.println(listOfWindows2.size()); // Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='file']")).sendKeys(filePath);

		driver.findElement(By.id("Attach")).click();

		WebElement fileName = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='pbSubsection']/table/tbody/tr[1]/td[2]")));

		String getFileName = fileName.getText();

		Assert.assertEquals(verifyFile, getFileName);

		driver.findElement(By.name("cancel")).click();
		driver.switchTo().window(listOfWindows2.get(0));

		String getFileName2 = driver.findElement(By.xpath("//table[@class='list']//tr[2]/td[2]")).getText();

		Assert.assertEquals("Dummy.txt", getFileName2);

		driver.findElement(By.xpath("//td[@id='topButtonRow']/input[@name='save']")).click();

		String getRecentText = driver.findElement(By.xpath("(//*[@class='mruItem']/a[1]/span)[1]")).getText();

		Assert.assertEquals("Call", getRecentText);
		driver.findElement(By.xpath("//*[@class='switch-to-lightning']")).click();
	}

}
