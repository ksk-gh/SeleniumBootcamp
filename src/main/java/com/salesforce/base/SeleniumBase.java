package com.salesforce.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.salesforce.utils.ReadExcel;
import com.salesforce.utils.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

//public class SeleniumBase extends ReadExcel implements Browser {

public class SeleniumBase extends Reporter implements Browser {

	public static RemoteWebDriver driver;
	public static WebDriverWait wait;
	public Properties prop;

	public void startApp(String browser, String url) {
		try {
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
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			driver.get(url);
			reportStep("The Browser " + browser + " has been launched successfully", "PASS");
		} catch (WebDriverException e) {
			reportStep("The Browser " + browser + " could not be launched", "FAIL");

		}

	}

	public void click(WebElement ele) {
		String text = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			text = ele.getText();
			
			if(text.isEmpty()) {
				text=ele.getAttribute("value");
			}
			System.out.println("Test is :"+text);

			ele.click();
			reportStep("The element " + text + " is clicked", "PASS");
		} catch (InvalidElementStateException e) {
			reportStep("The element: " + text + " could not be clicked", "FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while clicking in the field :", "FAIL");
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
			default:
				System.err.println("Locator is not valid");
				break;

			}
		} catch (NoSuchElementException e) {
			reportStep("The element with locator " + locator + " not found.", "FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while finding " + locator + " with the value " + locValue, "FAIL");
		}
		return null;
	}

	@Override
	public void clear(WebElement ele) {
		try {
			ele.clear();
			reportStep("The text in the " + ele + " is cleared.", "info");

		} catch (InvalidElementStateException e) {
		} catch (WebDriverException e) {
		}
	}

	@Override
	public void clearAndType(WebElement ele, String data) {

		try {
			ele.clear();
			ele.sendKeys(data);

			//String x = "" + ele;
			reportStep("The data: " + data + " entered successfully in the field :" + ele, "PASS");
		} catch (InvalidElementStateException e) {
			reportStep("The data: " + data + " could not be entered in the field:" + ele, "FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while entering " + data + " in the field:" + ele, "FAIL");
		}
	}

	public void clearAndTypeWithEnter(WebElement ele, String data) {

		try {
			ele.clear();
			ele.sendKeys(data, Keys.ENTER);
			//String x = "" + ele;
			reportStep("The data: " + data + " entered successfully in the field :" + ele, "PASS");
		} catch (InvalidElementStateException e) {
			reportStep("The data: " + data + " could not be entered in the field:" + ele, "FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while entering " + data + " in the field:" + ele, "FAIL");
		}
	}

	public void typeWithTab(WebElement ele, String data) {

		try {
			ele.clear();
			ele.sendKeys(data, Keys.TAB);

			String x = "" + ele;
			reportStep("The data: " + data + " entered successfully in the field :" + ele, //
					"PASS");
		} catch (InvalidElementStateException e) {
			reportStep("The data: " + data + " could not be entered in the field:" + ele, "FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while entering " + data + " in the field :" + ele, "FAIL");
		}
	}

	@Override
	public boolean verifyDisplayed(WebElement ele) {
		try {
			if (ele.isDisplayed()) {
				 reportStep("The element " + ele + " is visible", "PASS");

				return true;
			} else {
				 reportStep("The element " + ele + " is not visible", "warnings");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException : \n" + e.getMessage(), "fail");
		}
		return false;
	}

	@Override
	public void close() {
		try {
			driver.close();
			reportStep("Browser is closed", "info");

		} catch (Exception e) {
			reportStep("Browser cannot be closed " + e.getMessage(), "fail");

		}
	}

	@Override
	public void quit() {
		try {
			driver.quit();
			reportStep("Browser is closed", "info");

		} catch (Exception e) {
			reportStep("Browser cannot be closed " + e.getMessage(), "fail");
		}
	}

	public void type(WebElement ele, String data) {
		try {
			wait.until(ExpectedConditions.visibilityOf(ele));
			ele.clear();
			ele.sendKeys("", "", data);
			reportStep("The " + data + " is entered", "pass");
		} catch (ElementNotInteractableException e) {
			reportStep("The Element " + ele + " is not Interactable \n" + e.getMessage(),"fail");
		} catch (WebDriverException e) {
			reportStep("The Element " + ele + " is not Interactable \n" + e.getMessage(),"fail");
		}

	}

	public void clickUsingJs(WebElement ele) {
		try {
			ele.isDisplayed();
		} catch (NoSuchElementException e) {

		}

		String text = "";
		try {
			try {
				driver.executeScript("arguments[0].click()", ele);
			} catch (Exception e) {
				boolean bFound = false;
				int totalTime = 0;
				while (!bFound && totalTime < 10000) {
					try {
						Thread.sleep(500);
						driver.executeScript("arguments[0].click()", ele);
						bFound = true;

					} catch (Exception e1) {
						bFound = false;
					}
					totalTime = totalTime + 500;
				}
				if (!bFound)
					driver.executeScript("arguments[0].click()", ele);
				reportStep("The " + ele + " is clicked", "pass");

			}
		} catch (StaleElementReferenceException e) {
			reportStep("The Element " + text + " could not be clicked due to:" +e.getMessage(), "fail");
		} catch (WebDriverException e) {
			reportStep("The Element " + ele + " could not be clicked due to: " +e.getMessage(), "fail");
		} catch (Exception e) {
			 reportStep("The Element " + ele + " could not be clicked due to: " +e.getMessage(), "fail");
		}
	}

	public void getEnteredText(WebElement ele) {

		try {
			String attributeText = ele.getAttribute("value");
			 reportStep("The entered text" + attributeText + " is retrived from the "+ele , "info");

		} catch (Exception e) {
		 reportStep("The Element " + ele + " could not get the text " +e.getMessage(), "fail");
		}

	}

	public String getTextMessage(WebElement ele) {
		String text = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(ele));
			text = ele.getText();
			reportStep("The "+text+" is fetched from the "+ele, "PASS");

		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Text \n" +e.getMessage(), "fail");
		}

		return text;
	}

	public void waitUntilClick(WebElement ele) {

		try {
			ele.isDisplayed();
		} catch (NoSuchElementException e) {

		}

		String text = null;
		try {
			try {
				driver.executeScript("arguments[0].click()", ele);
			} catch (Exception e) {
				boolean bFound = false;
				int totalTime = 0;
				while (!bFound && totalTime < 10000) {
					try {
						Thread.sleep(500);
						driver.executeScript("arguments[0].click()", ele);
						bFound = true;

					} catch (Exception e1) {
						bFound = false;
					}
					totalTime = totalTime + 500;
				}
				if (!bFound)
					driver.executeScript("arguments[0].click()", ele);
			}
		} catch (StaleElementReferenceException e) {

			reportStep("The Element " + text + " could not be clicked due to:" + e.getMessage(), "fail");
		} catch (WebDriverException e) {
			reportStep("The Element " + ele + " could not be clicked due to: " +e.getMessage(), "fail");
		} catch (Exception e) {
			reportStep("The Element " + ele + " could not be clicked due to: " +e.getMessage(), "fail");
		}

	}

	public void waitUntilStalenessof(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			wait.until(ExpectedConditions.stalenessOf(ele));
		} catch (WebDriverException e) {
			reportStep("The Element " + ele + " is not staled " +e.getMessage(), "fail");

		}

	}

	public By byLocator(String locator, String locValue) {

		try {
			switch (locator) {
			case ("id"):
				return By.id(locValue);
			case ("link"):
				return By.linkText(locValue);
			case ("xpath"):
				return By.xpath(locValue);
			case ("name"):
				return By.name(locValue);
			case ("class"):
				return By.className(locValue);
			case ("tag"):
				return By.tagName(locValue);
			}
		} catch (NoSuchElementException e) {
			reportStep("The element with locator "+locator+" not found.","FAIL");
		}
		return null;
	}

	public void waitUntilElementLocated(String locator, String locatorValue) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String loc = locator.toLowerCase();
		try {
			switch (loc) {
			case "id":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
			case "xpath":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
			}
		} catch (Exception e) {
			reportStep("The element with locator "+locator+" not found.","FAIL");

		}
	}

	public void waitUntilInvisibilityOfElement(String locator, String locatorValue) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			String loc = locator.toLowerCase();
			switch (loc) {
			case "id":

				wait.until(ExpectedConditions.invisibilityOf(locateElement(locator, locatorValue)));

			case "xpath":
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locatorValue)));
			}
		} catch (Exception e) {
			reportStep("The element is not disappeared.","FAIL");

		}
	}

	public void switchToFrame(WebElement value) {

	}

	@Override
	public long takeSnap() {
		long number = (long) Math.floor(Math.random() * 90000000) + 10000000L;
		File src = driver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(folder + "/" + number + ".png"));
		} catch (IOException e) {

		}

		return number;
	}

}
