package com.novaproduction.hellonerd.selenium.properties;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.novaproduction.hellonerd.selenium.logger.MyLogger;

public class PropertyReader {
	private static final String PATH_TO_PROPERTIES = "\\src\\main\\java\\resources\\config.properties";
	
	public static String loadProperties(String propertyKey) {
    	try (InputStream input = new FileInputStream(PATH_TO_PROPERTIES)) {
    		Properties prop = new Properties();
    		prop.load(input);
            String propertyFound = prop.getProperty(propertyKey);
            return propertyFound;
        } catch (Exception ex) {
        	MyLogger.error(ex.getMessage());
        }
		return null;
	}
}
