package com.m2.pages;

import org.openqa.selenium.By;

import com.m2.enums.WaitStrategy;

/* This is page layer class for Login page.
 * Don't call any Assertions in page layer class.
 * Make sure all page methods has return type. This is needed for method chaining.
*/
public final class OrangeHRMLoginPage extends BasePage{
	
	// Creating elements
	private final By textboxUsername = By.name("username");
	private final By textboxPassword = By.xpath("//input[@name='password' and @type='password']");
	private final By btnLogin = By.tagName("button");
	
	// Creating methods to take action on stored elements
	public OrangeHRMLoginPage enterUserName(String username) {
		sendKeys(textboxUsername, username, WaitStrategy.PRESENCE);
		return this;
	}
	
	public OrangeHRMLoginPage enterPassword(String password) {
		sendKeys(textboxPassword, password, WaitStrategy.PRESENCE);
		return this;
	}
	
	public OrangeHRMHomePage clickLoginButton() {
		click(btnLogin, WaitStrategy.CLICKABLE);
		return new OrangeHRMHomePage();
	}
	
	public String getTitle() {
		return getPageTitle();
	}

}
