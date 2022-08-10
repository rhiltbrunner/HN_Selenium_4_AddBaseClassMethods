package com.novaproduction.hellonerd.selenium.javascript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.novaproduction.hellonerd.selenium.BaseClass;

public class ExecuteJavaScript extends BaseClass {
	/**
	 * arguments[0].click();
	 * @param runOnElement
	 * @param javascriptCode
	 */
	public static String executeJavascriptCode(By runOnElement, String javascriptCode) {
	    //Creating the JavascriptExecutor interface object by Type casting
	    JavascriptExecutor js = (JavascriptExecutor) wDriver;
	    //Button Element
	    WebElement button = wDriver.findElement(runOnElement);
	    //Executing JavaScript to click on element
	    js.executeScript(javascriptCode, button);
	    //Get return value from script
	    String text = (String) js.executeScript("return arguments[0].innerText", button);
	    return text;
	}
	
}
