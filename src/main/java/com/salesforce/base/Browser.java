package com.salesforce.base;

import org.openqa.selenium.WebElement;

public interface Browser {

	/**
	 * Method to launch a browser
	 * 
	 * @author SankaraKarthikeyan K
	 * @return void
	 * @param browserName -The browser that you like to open(Chrome, Edge)
	 * @param url         - URL of the browser should be open (Its either http or
	 *                    https)
	 */
	public void startApp(String browserName, String url);

	public WebElement locateElement(String type, String value);

	public void close();

	public void closeAllBrowsers();

	public void click(WebElement ele);

	public void clickUsingJs(WebElement ele);

	public void clear(WebElement ele);

	public void clearAndType(WebElement ele, String value);

	public boolean verifyDisplayed(WebElement ele);

	public void type(WebElement ele, String data);

	public void getEnteredText(WebElement ele);

	public String getTextMessage(WebElement ele);

	public void waitUntilStalenessof(WebElement ele);

	public void clearAndTypeWithEnter(WebElement ele, String value);
	
	public void switchToFrame(String frame);
	
	public void switchToFrame(int index);
	
	public void switchToFrame(WebElement ele);

	/*
	 * public void switchToFrame(WebElement value); public void switchToFrame(String
	 * idOrName);
	 */

	// public void switchToFrame(WebElement value);
	/* public void defaultContent();
	 * 
	 * public void verifyURL();
	 * 
	 * public void verifyTitle();
	 */
	
}
