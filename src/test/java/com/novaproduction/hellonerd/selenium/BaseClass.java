package com.novaproduction.hellonerd.selenium;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.novaproduction.hellonerd.selenium.driver.DetectingDriver;
import com.novaproduction.hellonerd.selenium.logger.MyLogger;
import com.novaproduction.hellonerd.selenium.properties.PropertyReader;

/**
 * @author renat
 *
 */
public abstract class BaseClass {
	public static WebDriver wDriver;
	public static Wait<WebDriver> wait;
	public static long nonScientificTimer;
	
    public static WebDriver startup() {
    	try {
    		wDriver = DetectingDriver.getDriver();
    		if(wDriver != null) {
    			MyLogger.info("driver successfully found.");
    			return wDriver;    			
    		}
    	}catch(Exception ex) {
    		MyLogger.error(ex.getMessage());
    	}
    	int timeToWait = 0;
    	int timeToPull = 0;
    	timeToWait = Integer.parseInt(PropertyReader.loadProperties("time_wait"));
    	timeToPull = Integer.parseInt(PropertyReader.loadProperties("time_pull"));
    	if(timeToWait == 0 && timeToPull == 0) {
    		timeToWait = 10;
    		timeToPull = 5;
    		wait = new FluentWait<WebDriver>(wDriver)
    				.withTimeout(Duration.ofSeconds(10))
    				.pollingEvery(Duration.ofSeconds(5));
    	} else {
    		wait = new FluentWait<WebDriver>(wDriver)
    				.withTimeout(Duration.ofSeconds(timeToWait))
    				.pollingEvery(Duration.ofSeconds(timeToPull));	
    	}
    	return null;
    }
    
	@AfterEach
    public void teardown() {
        if (wDriver != null) {
        	wDriver.quit();
        }
	}
	
	public static void closeDriver() {
		 if (wDriver != null) {
			 wDriver.quit();
	     }
	}
    
    @AfterAll
    public static void afterall() {
       // save log file
    }
}