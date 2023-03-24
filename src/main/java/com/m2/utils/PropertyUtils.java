package com.m2.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Properties;

import com.m2.constants.FrameworkConstants;
import com.m2.enums.ConfigProperties;

/*
 * This class is used to read the Property files.
 * It is accepting the "key" as input, search this key in loaded property file and return the respective value.
 */
public final class PropertyUtils {
	
	private PropertyUtils() {}
	
	// Initialize variables at class level
	private static Properties property = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<>(); 
	
	// Define static block so that config.properties file will load only once at the start of class execution
	static {
		try {
			FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigfilepath());
			property.load(fis);
			
			// Running enhanced for loop to read the file and load into HashMap. Converting the key and value to String from Object.
			for(Entry<Object, Object> entry : property.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()),
						String.valueOf(entry.getValue()).trim()); //removes the trailing and leading spaces
			}
			
			// Running for loop using lambda expression
			// property.entrySet().forEach(entry -> CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue())));
		}
		catch(FileNotFoundException e) { // catching file not found exception
			e.printStackTrace();
		}
		catch(IOException e) { // catching input output exception
			e.printStackTrace();
		}
		
	}
	
	// Method to read data from HashMap CONFIGMAP
	public static String get(ConfigProperties key) throws Exception {
		
		// Adding the check to avoid NPE (Null Pointer Exception
		if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new Exception("Property name " + key + " is not found. Please check config.properties.");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}
	
	/* Method to use in place of HashMap
	 * public static String getValue(String key) throws Exception {
		// Adding the check to avoid NPE (Null Pointer Exception
		if(Objects.isNull(property.getProperty(key)) || Objects.isNull(key)) {
			throw new Exception("Property name " + key + " is not found. Please check config.properties.");
		}
		return property.getProperty(key);
	} */

}
