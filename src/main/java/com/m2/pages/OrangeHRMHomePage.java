package com.m2.pages;

import org.openqa.selenium.By;

import com.m2.enums.WaitStrategy;

/* This is page layer class for Home page.
 * Don't call any Assertions in page layer class.
 * Make sure all page methods has return type. This is needed for method chaining.
*/
public final class OrangeHRMHomePage extends BasePage {
	
	// Creating elements
	private final By linkUser = By.className("oxd-userdropdown-name");
	private final By linkLogout = By.linkText("Logout");
	
	// Creating methods to take action on stored elements
	public OrangeHRMHomePage clickUserLink() {
		click(linkUser, WaitStrategy.PRESENCE);
		return this;
	}
	
	public OrangeHRMLoginPage clickLogoutLink() {
		click(linkLogout, WaitStrategy.CLICKABLE);
		return new OrangeHRMLoginPage();
	}

}
