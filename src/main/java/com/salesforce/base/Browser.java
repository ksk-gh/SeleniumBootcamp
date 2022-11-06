package com.salesforce.base;

import org.openqa.selenium.WebElement;

public interface Browser {


	public void startApp(String browser, String url);


	public WebElement locateElement(String type, String value);


	public void close();

	public void quit();

	public void click(WebElement ele);
	
	public void clickUsingJs(WebElement ele);

	public void clear(WebElement ele);

	public void clearAndType(WebElement ele, String value);
	
	public boolean verifyDisplayed(WebElement ele);
	
	public void type(WebElement ele, String data);
	
	public void getEnteredText(WebElement ele);


	/*
	 * public void selectDropDownUsingText(WebElement ele, String value);
	 * 
	 * public void selectDropDowmUsingIndex(WebElement ele, int value);
	 * 
	 * public void selectDropDownUsingValue(WebElement ele, String value);
	 * 
	 * 
	 * public boolean verifyEnabled(WebElement ele);
	 * 
	 * public boolean verifySelected(WebElement ele);
	 */
	
//	public List<WebElement> locateElements(String type, String value);

	/*
	 * public void switchToWindow(int value);
	 * 
	 * public void switchToWindow(String value);
	 * 
	 * public void switchToFrame(int value);
	 * 
	 * public void switchToFrame(WebElement value);
	 * 
	 * public void switchToFrame(String value);
	 * 
	 * public void defaultContent();
	 * 
	 * public void verifyURL();
	 * 
	 * public void verifyTitle();
	 */
}
