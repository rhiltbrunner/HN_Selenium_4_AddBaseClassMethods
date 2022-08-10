package com.novaproduction.hellonerd.selenium.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.novaproduction.hellonerd.selenium.BaseClass;

public class Element extends BaseClass {
	public static WebElement findElement(By byIdentifier) {
		return wDriver.findElement(byIdentifier);
	}
	
	public static boolean elementIsDesplayed(By byIdentifier) {
		return wDriver.findElement(byIdentifier).isDisplayed();
	}
	
	public static boolean elementIsEnabled(By byIdentifier) {
		return wDriver.findElement(byIdentifier).isEnabled();
	}
	
	public static boolean elementIsSelected(By byIdentifier) {
		return wDriver.findElement(byIdentifier).isSelected();
	}
	
	public static String getTagElement(By byIdentifier) {
		return wDriver.findElement(byIdentifier).getTagName();
	}
	
	public static Rectangle getRectangleOfPosition(By byIdentifier) {
		return wDriver.findElement(byIdentifier).getRect();
	}
	
	public static String getCssValue(By byIdentifier, String cssElementToGetFrom) {
		return wDriver.findElement(byIdentifier).getCssValue(cssElementToGetFrom);
	}
	
	public static String getTextContent(By byIdentifier) {
		return wDriver.findElement(byIdentifier).getText();
	}
	
	public static Select getSelectedElement(By byIdentifier) {
		WebElement selectElement = wDriver.findElement(byIdentifier);
		Select selectObject = new Select(selectElement);
		return selectObject;
	}
}
