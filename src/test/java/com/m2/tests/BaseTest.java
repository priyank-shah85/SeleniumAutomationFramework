package com.m2.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.m2.driver.Driver;

/*
 * This class is used as base class and contains methods which needs to execute before and after every test case.
 * It uses the methods from Driver class to initialize and quit the browser.
 */
public class BaseTest {
	
	protected BaseTest() {}
	
	// Method to execute before start of every test case
	@BeforeMethod
	protected void setUp() throws Exception {
		Driver.initDriver();
	}
	
	// Method to executer after end of every test case
	@AfterMethod
	protected void tearDown() {
		Driver.quiteDriver();
	}

}
