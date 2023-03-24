package com.m2.driver;

import org.openqa.selenium.WebDriver;

/*
 * This class is used to create ThreadLocal mechanism and it's respective methods.
 * ThreadLocal is use to manage the exception while running the tests in parallel
 */
public final class DriverManager {
	
	private DriverManager() {}

	private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

	// Method to get the driver
	public static WebDriver getDriver() {
		return dr.get();
	}

	// Method to set the driver
	public static void setDriver(WebDriver driverref) {
		dr.set(driverref);
	}

	// Method to free up the ThreadLocal
	public static void unload() {
		dr.remove();
	}

}
