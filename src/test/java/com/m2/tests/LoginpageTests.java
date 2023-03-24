package com.m2.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.m2.driver.DriverManager;

public final class LoginpageTests extends BaseTest{
	
	private LoginpageTests() {}
	
	// Using Test annotation from TestNG.
	@Test
	public void test2() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation", Keys.ENTER);
	}

}
