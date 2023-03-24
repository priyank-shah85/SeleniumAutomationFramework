package com.m2.driver;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.m2.enums.ConfigProperties;
import com.m2.utils.PropertyUtils;

/* This class is used to initialize the driver and assigning it with which browser to launch.
 * It is also used to quit the browser.
 * It uses the DriverManger class to get and set the driver values. And at end, it release the driver to set it back to null.
 */
public final class Driver {
	
	// Private constructor so that it cannot be called as object
	private Driver() {}
	
	public static void initDriver() throws Exception {
		// Checking if the driver is null or not
		if(Objects.isNull(DriverManager.getDriver())) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			DriverManager.setDriver(new ChromeDriver(options));
			
			// Getting the URL from the config.properties file
			DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
		}
		
	}
	
	public static void quiteDriver() {
		// Checking if the driver is not null
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			
			// Free up the ThreadLocal assigned to driver
			DriverManager.unload();
		}
	}

}
