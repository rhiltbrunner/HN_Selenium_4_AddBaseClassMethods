package com.novaproduction.hellonerd.selenium.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.novaproduction.hellonerd.selenium.logger.MyLogger;
import com.novaproduction.hellonerd.selenium.os.DetectingOS;
import com.novaproduction.hellonerd.selenium.properties.PropertyReader;

public class MyChromeDriver {

	private static MyChromeDriver chromeDriver = null;
	private static ChromeOptions options = null;

	public static WebDriver getConfiguredDriver(WebDriver _driver) {		
		chromeDriver = new MyChromeDriver();
		options = chromeDriver.setOptions(_driver);
		_driver = new ChromeDriver(options);
		chromeDriver.setCookies(_driver);
		chromeDriver.setProperties(_driver);
		return _driver;
	}

	public ChromeOptions setOptions(WebDriver _driver) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-popup-blocking");
		return options;
	}

	public void setCookies(WebDriver _driver) {

	}

	public void setProperties(WebDriver _driver) {
		/**
		 * This is the path to the effective browser, not the selenium driver.
		 */
		if (DetectingOS.getOS().equals(DetectingOS.OS_WINDOWS)) {
			System.setProperty("webdriver.chrome.driver", PropertyReader.loadProperties("driverpath_chrome_windows"));
		} else if (DetectingOS.getOS().equals(DetectingOS.OS_LINUX)) {
			System.setProperty("webdriver.chrome.driver", PropertyReader.loadProperties("driverpath_chrome_linux"));
		} else {
			MyLogger.error("no os found.");
		}
	}
}
