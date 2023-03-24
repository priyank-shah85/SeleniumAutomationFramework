package com.m2.pages;

import org.openqa.selenium.By;

import com.m2.driver.DriverManager;
import com.m2.enums.WaitStrategy;
import com.m2.factories.ExplicitWaitFactory;

// This is base class which contains most or all the reusable methods.
public class BasePage {

	// Method to click on element
	protected void click(By by, WaitStrategy waitStrategy) {
		// Using the explicit wait strategy from ExplicitWaitFactory
		// ExplicitWaitFactory is returning WebElement, so chaining the action method
		ExplicitWaitFactory.performExplicitWait(waitStrategy, by).click();
	}

	// Method to enter text/value in element input area
	protected void sendKeys(By by, String value, WaitStrategy waitStrategy) {
		// Using the explicit wait strategy from ExplicitWaitFactory
		// ExplicitWaitFactory is returning WebElement, so chaining the action method
		ExplicitWaitFactory.performExplicitWait(waitStrategy, by).sendKeys(value);
	}

	// Method to get the current page title
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}

}
