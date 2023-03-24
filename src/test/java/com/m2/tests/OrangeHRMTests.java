package com.m2.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.m2.pages.OrangeHRMLoginPage;

public final class OrangeHRMTests extends BaseTest{
	
	private OrangeHRMTests() {}
	
	@Test
	public void loginLogougTest() {
		// Calling methods from respective page class
		String title = new OrangeHRMLoginPage()
			.enterUserName("Admin")
			.enterPassword("admin123")
			.clickLoginButton()
			.clickUserLink()
			.clickLogoutLink()
			.getTitle();
		
		// Assert via AssertJ
		Assertions.assertThat(title)
			.isEqualTo("OrangeHRM");
	}

}
