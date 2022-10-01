package com.salesforce.cases;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC018_ClassicNewEvent extends BaseClass {

	@Test
	public void tc018() throws InterruptedException {
	


		if (driver.getTitle().contains("Developer Edition")) {
			driver.findElement(By.xpath("//*[@class='switch-to-lightning']")).click();
			Thread.sleep(5000);
		}
		Thread.sleep(5000);

		WebElement profilePic = driver.findElement(By.xpath("//*[@data-aura-class='forceSocialPhoto']"));
		executor.executeScript("arguments[0].click();", profilePic);

		WebElement classicUILink = driver.findElement(By.xpath("//*[text()='Switch to Salesforce Classic']"));
		executor.executeScript("arguments[0].click();", classicUILink);

		driver.findElement(By.id("createNewButton")).click();

		driver.findElement(By.xpath("//*[@title='Event']")).click();

		driver.findElement(By.id("evt5")).sendKeys("Call");
		driver.findElement(By.id("StartDateTime")).click();
		driver.findElement(By.xpath("//*[contains(@class,'todayDate')]/following::td[1]")).click();

		driver.findElement(By.id("EndDateTime")).click();
		driver.findElement(By.xpath("//*[contains(@class,'todayDate')]/following::td[2]")).click();

		driver.findElement(By.id("whobtn")).click();

		
		
		
		
		  Set<String> windowHandles = driver.getWindowHandles(); ArrayList<String>
		  listOfWindows = new ArrayList<String>(windowHandles);
		  driver.switchTo().window(listOfWindows.get(1));
		  System.out.println(listOfWindows.size()); 
		  Thread.sleep(2000);
		
		
		/*String MainWindow = driver.getWindowHandle();
		

		// Here we will check if child window has other child windows and when child
		// window
		// is the main window it will come out of loop.
		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			if (MainWindow != ChildWindow) {
				driver.switchTo().window(ChildWindow);
				// driver.close();
				// System.out.println("Child window closed");
			}*/

		/*
		 * driver.findElement(By.xpath("//*[@placeholder='Search...']")).
		 * sendKeys("Neel Sourav");
		 * 
		 * driver.findElement(By.xpath("//*[@title='Go!']")).click();
		 * 
		 * driver.findElement(By.xpath("//*[contains(@class,'first')]/th/a")).click();
		 * driver.switchTo().window(listOfWindows.get(0));
		 */

			driver.findElement(By.xpath("//input[@value='Attach File']")).click();
					//.sendKeys("F:\\Trainings\\TestLeaf\\Selenium Bootcamp\\week3\\Dummy.txt");
			
			
			 Set<String> windowSecondHandles = driver.getWindowHandles(); 
			 ArrayList<String> listOfWindows2 = new ArrayList<String>(windowHandles);
			 driver.switchTo().window(listOfWindows2.get(1));
			 System.out.println(listOfWindows2.size()); //Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='file']")).sendKeys("F:\\Trainings\\TestLeaf\\Selenium Bootcamp\\week3\\Dummy.txt");
			

		}


	}

