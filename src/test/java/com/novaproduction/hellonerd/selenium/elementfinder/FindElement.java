package com.novaproduction.hellonerd.selenium.elementfinder;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.novaproduction.hellonerd.selenium.BaseClass;

public class FindElement extends BaseClass {
	public static WebElement findElement(By identifier) {
		WebElement foundElement = wDriver.findElement(identifier);
		return foundElement;
	}
	
	public static WebElement findElementByCss(String cssTags) {
		WebElement foundElement = wDriver.findElement(By.cssSelector(cssTags));
		return foundElement;
	}
	
	public static List<WebElement> findAllElements(By identifier) {
		List<WebElement> foundElements = wDriver.findElements(identifier);
		return foundElements;
	}
}
