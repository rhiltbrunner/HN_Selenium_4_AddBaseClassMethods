package com.novaproduction.hellonerd.selenium.inputgadgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.novaproduction.hellonerd.selenium.BaseClass;

/**
 * https://www.selenium.dev/documentation/webdriver/actions_api/wheel/
 * @author renat
 *
 */
public class Wheel extends BaseClass {
	public static void scrollToElement(By element) {
		 WebElement iframe = wDriver.findElement(element);
	     new Actions(wDriver).moveToElement(iframe).perform();
	}
	
	public static void scrollByGivenAmount(By element) {
		 WebElement iframe = wDriver.findElement(element);
	     new Actions(wDriver).moveToElement(iframe).perform();
	}
}
