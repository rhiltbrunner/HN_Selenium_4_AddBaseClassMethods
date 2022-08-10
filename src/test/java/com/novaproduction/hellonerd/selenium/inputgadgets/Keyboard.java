package com.novaproduction.hellonerd.selenium.inputgadgets;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.novaproduction.hellonerd.selenium.BaseClass;

public class Keyboard extends BaseClass {
	public static void clickEnter(String pageurl, By identifier) {
	    try {
	      // Navigate to Url
	    	wDriver.get(pageurl);

	      // Enter text "q" and perform keyboard action "Enter"
	    	wDriver.findElement(identifier).sendKeys("q" + Keys.ENTER);
	    } finally {
	    	wDriver.quit();
	    }
	}
	
	public static void addTextToInputElement(String pageurl, By identifier, String text) {
	    try {
	    	// Navigate to Url
	    	wDriver.get(pageurl);
	        // Store 'SearchInput' element
	        WebElement searchInput = wDriver.findElement(identifier);
	        searchInput.sendKeys(text);
	    } finally {
	    	wDriver.quit();
	    }
	}
	
	public static void clearInputElement(String pageurl, By identifier) {
	    try {
	    	// Navigate to Url
	    	wDriver.get(pageurl);
	        // Store 'SearchInput' element
	        WebElement searchInput = wDriver.findElement(identifier);
	        // Clears the entered text
	        searchInput.clear();
	    } finally {
	    	wDriver.quit();
	    }
	}
	
	public static void writeTextInElement(By identifier, String text) {
		wDriver.findElement(identifier).sendKeys(text + Keys.ENTER);
	}
	
	public static void keyDown(String key) {
        new Actions(wDriver)
        .keyDown(Keys.SHIFT)
        .sendKeys(key)
        .perform();
	}
	
	public static void keyUp(String key) {
        new Actions(wDriver)
        .keyUp(Keys.SHIFT)
        .sendKeys(key)
        .perform();
	}
}
