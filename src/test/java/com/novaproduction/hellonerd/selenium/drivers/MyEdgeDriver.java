package com.novaproduction.hellonerd.selenium.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.novaproduction.hellonerd.selenium.logger.MyLogger;
import com.novaproduction.hellonerd.selenium.os.DetectingOS;
import com.novaproduction.hellonerd.selenium.properties.PropertyReader;

public class MyEdgeDriver {
	
	private static MyEdgeDriver edgeDriver = null;
	private static EdgeOptions options = null;
	
	public static WebDriver getConfiguredDriver(WebDriver _driver) {		
		edgeDriver = new MyEdgeDriver();
		options  = edgeDriver.setOptions(_driver);
		_driver = new EdgeDriver(options);
		edgeDriver.setCookies(_driver);
		edgeDriver.setProperties(_driver);
		return _driver;
	}
	
	public EdgeOptions setOptions(WebDriver _driver) {
		EdgeOptions options  = new EdgeOptions();
		options.addArguments("--disable-popup-blocking");
		return options;
	}

	public void setCookies(WebDriver _driver) {
		
	}

	public void setProperties(WebDriver _driver) {
		/**
		 * This is the path to the effective browser, not the selenium driver.
		 */
		if(DetectingOS.getOS().equals(DetectingOS.OS_WINDOWS)) {
			System.setProperty("webdriver.edge.driver", PropertyReader.loadProperties("driverpath_edge_windows"));
		} else if(DetectingOS.getOS().equals(DetectingOS.OS_LINUX)) {
			System.setProperty("webdriver.edge.driver", PropertyReader.loadProperties("driverpath_edge_linux"));
		}else {
			MyLogger.error("no os found.");
		}
	}
}
