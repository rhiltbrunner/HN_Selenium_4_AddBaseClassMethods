package com.novaproduction.hellonerd.selenium.inputgadgets;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.novaproduction.hellonerd.selenium.BaseClass;
import com.novaproduction.hellonerd.selenium.elements.Element;

/**
 * https://www.selenium.dev/documentation/webdriver/actions_api/mouse/
 * @author renat
 *
 */
public class Mouse extends BaseClass {
	
	public static void clickButton (By button) {
		WebElement searchButton = Element.findElement(button);
		searchButton.click();
	}
	
	public static void clickAndHold (By text) {
		WebElement element = wDriver.findElement(text);
	      Actions actionProvider = new Actions(wDriver);
	      // Perform click-and-hold action on the element
	      actionProvider.clickAndHold(element).build().perform();
	}
	
	public static void clickAndRelease (By text) {
		WebElement element = wDriver.findElement(text);
	      Actions actionProvider = new Actions(wDriver);
	      // Perform click-and-hold action on the element
	      actionProvider.click(element).build().perform();
	}
	
	public static void clickContext (By text) {
		WebElement element = wDriver.findElement(text);
	      Actions actionProvider = new Actions(wDriver);
	      // Perform click-and-hold action on the element
	      actionProvider.contextClick(element).build().perform();
	}
	
	public static void doubleClick (By text) {
		WebElement element = wDriver.findElement(text);
	      Actions actionProvider = new Actions(wDriver);
	      // Perform click-and-hold action on the element
	      actionProvider.doubleClick(element).build().perform();
	}
	
	public static void moveToElement (By text) {
		WebElement element = wDriver.findElement(text);
	      Actions actionProvider = new Actions(wDriver);
	      // Perform click-and-hold action on the element
	      actionProvider.moveToElement(element).build().perform();
	}
	
	public static void dragAndDrop (By text) {
        WebElement draggable = wDriver.findElement(text);
        Rectangle start = draggable.getRect();
        Rectangle finish = wDriver.findElement(text).getRect();
        new Actions(wDriver)
                .dragAndDropBy(draggable, finish.getX() - start.getX(), finish.getY() - start.getY())
                .perform();
	}
}
