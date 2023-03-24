package com.m2.constants;

/* This class is used to defined constants variables.
 * Don't use this class to define URL, browser type or environment. Use property file instead.
 */

public final class FrameworkConstants {
	
	private FrameworkConstants() {}
	
	private static final String RESOURCESPATH = System.getProperty("user.dir")+"/src/test/resources";
	private static final String CONFIGFILEPATH = RESOURCESPATH+"/config/config.properties";
	private static final int EXPLICITWAIT = 20;
	
	// Method to get the value to wait explicitly
	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}

	// Method to get the file path of config.properties file
	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}

}
