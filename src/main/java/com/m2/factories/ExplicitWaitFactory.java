package com.m2.factories;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.m2.constants.FrameworkConstants;
import com.m2.driver.DriverManager;
import com.m2.enums.WaitStrategy;

/* A factory class to handle the explicit wait strategies
 * It uses WaitStrategy enum to call WebDriverWait.
 * It also uses ExplicitWait constant value from FrameworkConstants class.
 */
public class ExplicitWaitFactory {
	
	public static WebElement performExplicitWait(WaitStrategy waitStrategy, By by) {
		WebElement element = null;
		// Checking if the element is clickable on page
		if(waitStrategy == WaitStrategy.CLICKABLE) {
			element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
				.until(ExpectedConditions.elementToBeClickable(by));
		}
		// Checking if the element is present on page
		else if(waitStrategy == WaitStrategy.PRESENCE){
			element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
				.until(ExpectedConditions.presenceOfElementLocated(by));
		}
		// Checking if the element is visible on page
		else if(waitStrategy == WaitStrategy.VISIBLE) {
			element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
				.until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		// Not waiting for anything, instead just returning WebElement
		else if(waitStrategy == WaitStrategy.NONE) {
			DriverManager.getDriver().findElement(by);
		}
		return element;
	}

}
