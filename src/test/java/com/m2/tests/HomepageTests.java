package com.m2.tests;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.m2.driver.DriverManager;

public final class HomepageTests extends BaseTest {
	
	private HomepageTests() {}
	
	// Using Test annotation from TestNG.
	@Test
	public void test3() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);
		String actualTitle = DriverManager.getDriver().getTitle();
		// Assertion using AssertJ
		assertThat(actualTitle)
			.as("Title is actually null.").isNotNull()
			.as("Title does not contain google search words.").containsIgnoringCase("Google Search")
			.as("Title does not contain google search words.").matches("\\w.*"+"Google Search")
			.as("Title length is outside 15 and 100.").hasSizeBetween(15, 100);
		
		List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//h3"));
		// Assertions using AssertJ
		assertThat(elements)
			.as("Total links on page are not 20.").hasSize(20)
			.extracting(WebElement::getText)
			.as("Any link from the results does not contain Selenium word.").contains("Selenium");
	}

}
