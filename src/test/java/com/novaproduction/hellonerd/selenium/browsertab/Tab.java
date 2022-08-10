package com.novaproduction.hellonerd.selenium.browsertab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import com.novaproduction.hellonerd.selenium.BaseClass;

public class Tab extends BaseClass {
	public static void openAndSwitchToNewTab() {
		// Opens a new tab and switches to new tab
		wDriver.switchTo().newWindow(WindowType.TAB);
	}
	
	public static void openAndSwitchToNewWindow() {
		// Opens a new window and switches to new window
		wDriver.switchTo().newWindow(WindowType.WINDOW);
	}
	
	public static void closeTab(WebDriver driver) {
		//Close the tab or window
		driver.close();
	}
}
