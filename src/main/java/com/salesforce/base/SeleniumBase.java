package com.salesforce.base;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.salesforce.utils.ReadExcel;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumBase extends ReadExcel implements Browser {

	public static RemoteWebDriver driver;
	public static WebDriverWait wait;
	public Properties prop;

	public void startApp(String browser, String url) {
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

	public void click(WebElement ele) {

		String text = " ";

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			text = ele.getText();
			ele.click();
		} catch (StaleElementReferenceException e) {
			throw new RuntimeException();
		}

	}

	public WebElement locateElement(String locator, String locValue) {
		try {
			switch (locator) {
			case ("id"):
				return driver.findElement(By.id(locValue));
			case ("link"):
				return driver.findElement(By.linkText(locValue));
			case ("xpath"):
				return driver.findElement(By.xpath(locValue));
			case ("name"):
				return driver.findElement(By.name(locValue));
			case ("class"):
				return driver.findElement(By.className(locValue));
			case ("tag"):
				return driver.findElement(By.tagName(locValue));
			}
		} catch (NoSuchElementException e) {
			// reportStep("The element with locator "+locator+" not found.","FAIL");
		} catch (WebDriverException e) {
			// reportStep("Unknown exception occured while finding "+locator+" with the
			// value "+locValue, "FAIL");
		}
		return null;
	}

	@Override
	public void clear(WebElement ele) {
		try {
			ele.clear();

		} catch (InvalidElementStateException e) {
		} catch (WebDriverException e) {
		}
	}

	@Override
	public void clearAndType(WebElement ele, String data) {

		try {
			ele.clear();
			ele.sendKeys(data);
			// String x = ""+ele;
			// reportStep("The data: "+data+" entered successfully in the field :"+ele,
			// "PASS");
		} catch (InvalidElementStateException e) {
			// reportStep("The data: "+data+" could not be entered in the field
			// :"+ele,"FAIL");
		} catch (WebDriverException e) {
			// reportStep("Unknown exception occured while entering "+data+" in the field
			// :"+ele, "FAIL");
		}
	}

	@Override
	public boolean verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void close() {
		try {
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void quit() {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void type(WebElement ele, String data) {
		try {
			wait.until(ExpectedConditions.visibilityOf(ele));
			ele.clear();
			ele.sendKeys("", "", data);
		} catch (ElementNotInteractableException e) {
			//reportStep("The Element " + ele + " is not Interactable \n" + e.getMessage(), "fail");
		} catch (WebDriverException e) {
			//reportStep("The Element " + ele + " is not Interactable \n" + e.getMessage(), "fail");
		}

	}
	
	
	public void clickUsingJs(WebElement ele) {
		try {
			ele.isDisplayed(); // @FindBy return the proxy even if it does not exist !! 
		}catch (NoSuchElementException e) {
		//	reportStep("The Element " + ele + " is not found", "fail");
		}

		String text = "";
		try {
			try {
				driver.executeScript("arguments[0].click()", ele);
			} catch (Exception e) {
				boolean bFound = false;
				int totalTime = 0;
				while(!bFound && totalTime < 10000) {
					try {
						Thread.sleep(500);
						driver.executeScript("arguments[0].click()", ele);
						bFound = true;

					} catch (Exception e1) {
						bFound = false;
					}
					totalTime = totalTime+500;						
				}
				if(!bFound)
					driver.executeScript("arguments[0].click()", ele);
			}
		} catch (StaleElementReferenceException e) {
			//reportStep("The Element " + text + " could not be clicked due to:" + e.getMessage(), "fail");
		} catch (WebDriverException e) {
			//reportStep("The Element " + ele + " could not be clicked due to: " + e.getMessage(), "fail");
		} catch (Exception e) {
			//reportStep("The Element " + ele + " could not be clicked due to: " + e.getMessage(), "fail");
		}
	}
	
	
	public void getEnteredText(WebElement ele) {
		
		ele.getAttribute("value");
		
	}

	

	/*
	 * @Override public WebElement locateElement(String value) { // TODO
	 * Auto-generated method stub return null; }
	 */

}
