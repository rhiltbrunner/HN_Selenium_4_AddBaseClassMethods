package com.novaproduction.hellonerd.selenium.driver;

import org.openqa.selenium.WebDriver;
import com.novaproduction.hellonerd.selenium.drivers.MyChromeDriver;
import com.novaproduction.hellonerd.selenium.drivers.MyEdgeDriver;
import com.novaproduction.hellonerd.selenium.drivers.MyFirefoxDriver;
import com.novaproduction.hellonerd.selenium.logger.MyLogger;
import com.novaproduction.hellonerd.selenium.properties.PropertyReader;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * there are 3 browsertypes:
 * <li>BROWSER_CHROME</li>
 * <li>BROWSER_FIREFOX</li>
 * <li>BROWSER_EDGE</li>
 * 
 * The default browsertype is BROWSER_CHROME.
 * 
 * @author renat
 *
 */
public class DetectingDriver {
	private static final String BROWSER_CHROME = "BROWSER_CHROME";
	private static final String BROWSER_FIREFOX = "BROWSER_FIREFOX";
	private static final String BROWSER_EDGE = "BROWSER_EDGE";
	private static String browserType;
	
	public static WebDriver getDriver() throws Exception {
		WebDriver wDriver = null;
    	WebDriver _driver = null;
    	
    	browserType = PropertyReader.loadProperties("browserType");
    	
		if(browserType == null || browserType.equals(BROWSER_CHROME)) {
			/* BROWSER_CHROME */
			WebDriverManager.chromedriver().setup();
			wDriver = MyChromeDriver.getConfiguredDriver(_driver);
			MyLogger.info("browser chrome has been chosen.");
			
		} else if(browserType.equals(BROWSER_FIREFOX)) {
			/* BROWSER_FIREFOX */
			WebDriverManager.firefoxdriver().setup();
			wDriver = MyFirefoxDriver.getConfiguredDriver(_driver);
			MyLogger.info("browser firefox has been chosen.");
			
		} else if(browserType.equals(BROWSER_EDGE)) {
			/* BROWSER_EDGE */
			WebDriverManager.edgedriver().setup();
			wDriver = MyEdgeDriver.getConfiguredDriver(_driver);
			MyLogger.info("browser edge has been chosen.");
			
		} else {
			MyLogger.error("no appropriated browser found.");
			return null;
		}
		return wDriver;
    }
}
