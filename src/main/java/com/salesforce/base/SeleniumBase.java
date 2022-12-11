package com.salesforce.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
//import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.salesforce.utils.ReporterThread;

import io.github.bonigarcia.wdm.WebDriverManager;

//public class SeleniumBase extends ReadExcel implements Browser {

public class SeleniumBase extends ReporterThread implements Browser {

	// public static RemoteWebDriver driver;
//	public static WebDriverWait wait;
	public Properties prop;
	public static ChromeOptions chromeOptions;
	public static EdgeOptions edgeOptions;

	private static final ThreadLocal<RemoteWebDriver> remoteWebDriver = new ThreadLocal<RemoteWebDriver>();
	private static final ThreadLocal<WebDriverWait> wait = new  ThreadLocal<WebDriverWait>();

	public void setDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {

			chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--disable-notifications");
			remoteWebDriver.set(new ChromeDriver(chromeOptions));
		} else if (browser.equalsIgnoreCase("edge")) {
			edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("--disable-notifications");
			remoteWebDriver.set(new EdgeDriver(edgeOptions));

		}
	}

	public RemoteWebDriver getDriver() {
		return remoteWebDriver.get();
	}
	
	public void setWait() {
		wait.set(new WebDriverWait(getDriver(), Duration.ofSeconds(30)));
	}

	public WebDriverWait getWait() {
		return wait.get();
	}

	public void startApp(String browser, String url) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {

				WebDriverManager.chromedriver().setup();
				setDriver(browser);
				// driver = new ChromeDriver(options);
			} else if (browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				// driver = new EdgeDriver();
			}
			getDriver().manage().window().maximize();
			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//	wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
			setWait();
			getDriver().get(url);
			reportStep("The Browser " + browser + " has been launched successfully", "PASS");
		} catch (WebDriverException e) {
			reportStep("The Browser " + browser + " could not be launched", "FAIL");

		}

	}

	public void click(WebElement ele) {
		String text = null;
		try {
		//	WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
			getWait().until(ExpectedConditions.elementToBeClickable(ele));
			text = ele.getText();

			if (text.isEmpty()) {
				text = ele.getAttribute("value");
			}
			// System.out.println("Test is :"+text);

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
				return getDriver().findElement(By.id(locValue));
			case ("link"):
				return getDriver().findElement(By.linkText(locValue));
			case ("xpath"):
				return getDriver().findElement(By.xpath(locValue));
			case ("name"):
				return getDriver().findElement(By.name(locValue));
			case ("class"):
				return getDriver().findElement(By.className(locValue));
			case ("tag"):
				return getDriver().findElement(By.tagName(locValue));
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

			// String x = "" + ele;
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
			// String x = "" + ele;
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
				reportStep("The element " + ele + " is not visible", "fail");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException : \n" + e.getMessage(), "fail");
		}
		return false;
	}

	@Override
	public void close() {
		try {
			System.out.println("Browser closing");
			getDriver().close();
			reportStep("Browser is closed", "info");

		} catch (Exception e) {
			reportStep("Browser cannot be closed " + e.getMessage(), "fail");

		}
	}

	@Override
	public void closeAllBrowsers() {
		try {
			//getDriver().close();
		getDriver().quit();
			reportStep("Browser is closed", "info");

		} catch (Exception e) {
			reportStep("Browser cannot be closed " + e.getMessage(), "fail");
		}
	}

	public void type(WebElement ele, String data) {
		try {
		//	wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));

			getWait().until(ExpectedConditions.visibilityOf(ele));
			ele.clear();
			ele.sendKeys("", "", data);
			reportStep("The " + data + " is entered", "pass");
		} catch (ElementNotInteractableException e) {
			reportStep("The Element " + ele + " is not Interactable \n" + e.getMessage(), "fail");
		} catch (WebDriverException e) {
			reportStep("The Element " + ele + " is not Interactable \n" + e.getMessage(), "fail");
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
				getDriver().executeScript("arguments[0].click()", ele);
			} catch (Exception e) {
				boolean bFound = false;
				int totalTime = 0;
				while (!bFound && totalTime < 10000) {
					try {
						Thread.sleep(500);
						getDriver().executeScript("arguments[0].click()", ele);
						bFound = true;

					} catch (Exception e1) {
						bFound = false;
					}
					totalTime = totalTime + 500;
				}
				if (!bFound)
					getDriver().executeScript("arguments[0].click()", ele);
				reportStep("The " + ele + " is clicked", "pass");

			}
		} catch (StaleElementReferenceException e) {
			reportStep("The Element " + text + " could not be clicked due to:" + e.getMessage(), "fail");
		} catch (WebDriverException e) {
			reportStep("The Element " + ele + " could not be clicked due to: " + e.getMessage(), "fail");
		} catch (Exception e) {
			reportStep("The Element " + ele + " could not be clicked due to: " + e.getMessage(), "fail");
		}
	}

	public void getEnteredText(WebElement ele) {

		try {
			String attributeText = ele.getAttribute("value");
			reportStep("The entered text" + attributeText + " is retrived from the " + ele, "info");

		} catch (Exception e) {
			reportStep("The Element " + ele + " could not get the text " + e.getMessage(), "fail");
		}

	}

	public String getTextMessage(WebElement ele) {
		String text = "";
		try {
			//WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
			getWait().until(ExpectedConditions.visibilityOf(ele));
			text = ele.getText();
			reportStep("The " + text + " is fetched from the " + ele, "PASS");

		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Text \n" + e.getMessage(), "fail");
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
				getDriver().executeScript("arguments[0].click()", ele);
			} catch (Exception e) {
				boolean bFound = false;
				int totalTime = 0;
				while (!bFound && totalTime < 10000) {
					try {
						Thread.sleep(500);
						getDriver().executeScript("arguments[0].click()", ele);
						bFound = true;

					} catch (Exception e1) {
						bFound = false;
					}
					totalTime = totalTime + 500;
				}
				if (!bFound)
					getDriver().executeScript("arguments[0].click()", ele);
			}
		} catch (StaleElementReferenceException e) {

			reportStep("The Element " + text + " could not be clicked due to:" + e.getMessage(), "fail");
		} catch (WebDriverException e) {
			reportStep("The Element " + ele + " could not be clicked due to: " + e.getMessage(), "fail");
		} catch (Exception e) {
			reportStep("The Element " + ele + " could not be clicked due to: " + e.getMessage(), "fail");
		}

	}

	public void waitUntilStalenessof(WebElement ele) {
	//	WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

		try {
			getWait().until(ExpectedConditions.stalenessOf(ele));
		} catch (WebDriverException e) {
			reportStep("The Element " + ele + " is not staled " + e.getMessage(), "fail");

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
			reportStep("The element with locator " + locator + " not found.", "FAIL");
		}
		return null;
	}

	public void waitUntilElementLocated(String locator, String locatorValue) {
		//wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		String loc = locator.toLowerCase();
		try {
			switch (loc) {
			case "id":
				getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
			case "xpath":
				getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
			}
		} catch (Exception e) {
			reportStep("The element with locator " + locator + " not found.", "FAIL");

		}
	}

	public void waitUntilInvisibilityOfElement(String locator, String locatorValue) {
		try {
			//wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
			String loc = locator.toLowerCase();
			switch (loc) {
			case "id":

				getWait().until(ExpectedConditions.invisibilityOf(locateElement(locator, locatorValue)));

			case "xpath":
				getWait().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locatorValue)));
			}
		} catch (Exception e) {
			reportStep("The element is not disappeared.", "FAIL");

		}
	}

	public void switchToFrame(String frame) {
		try {
			Thread.sleep(100);
			getDriver().switchTo().frame(frame);
		} catch (NoSuchFrameException e) {
			reportStep("No such frame " + e.getMessage(), "warning", false);
		} catch (Exception e) {
			reportStep("No such frame " + e.getMessage(), "fail", false);
		}

	}

	public void switchToFrame(int index) {
		try {
			Thread.sleep(100);
			getDriver().switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			reportStep("No such frame " + e.getMessage(), "warning", false);
		} catch (Exception e) {
			reportStep("No such frame " + e.getMessage(), "fail", false);
		}

	}

	public void switchToFrame(WebElement ele) {
		try {
			getDriver().switchTo().frame(ele);
			System.out.println("switched successfully");
			reportStep("Frame switched successfully", "PASS");
		} catch (NoSuchFrameException e) {
			reportStep("No such frame " + e.getMessage(), "fail", true);
		} catch (Exception e) {
			reportStep("No such frame " + e.getMessage(), "fail", true);
		}

	}

	@Override
	public long takeSnap() {
		long number = (long) Math.floor(Math.random() * 90000000) + 10000000L;
		File src = getDriver().getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(folder + "/snaps/" + number + ".png"));
		} catch (IOException e) {

		}

		return number;
	}

}
