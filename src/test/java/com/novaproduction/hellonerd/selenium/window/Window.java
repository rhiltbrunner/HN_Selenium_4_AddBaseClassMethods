package com.novaproduction.hellonerd.selenium.window;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import com.novaproduction.hellonerd.selenium.BaseClass;

public class Window extends BaseClass {
	public static void switchingWindowOrTabs() {
		//Store the ID of the original window
		String originalWindow = wDriver.getWindowHandle();

		//Check we don't have other windows open already
		assert wDriver.getWindowHandles().size() == 1;

		//Click the link which opens in a new window
		wDriver.findElement(By.linkText("new window")).click();

		//Loop through until we find a new window handle
		for (String windowHandle : wDriver.getWindowHandles()) {
		    if(!originalWindow.contentEquals(windowHandle)) {
		    	wDriver.switchTo().window(windowHandle);
		        break;
		    }
		}
	}
	
	public static void closeWindow(String originalWindow) {
		//Switch back to the old tab or window
		wDriver.switchTo().window(originalWindow);
	}
	
	public static void quitBrowserSession() {
		//Switch back to the old tab or window
		wDriver.quit();
	}
	
	
	public static int getWindowWidth() {
		int width = wDriver.manage().window().getSize().getWidth();
		return width;
	}
	
	public static int getWindowHeight() {
		int height = wDriver.manage().window().getSize().getHeight();
		return height;
	}
	
	public static Map getWindowPosition() {
		int x = wDriver.manage().window().getPosition().getX();
		int y = wDriver.manage().window().getPosition().getY();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("x", x);
		map.put("y", y);
		return map;
	}
	
	public static String getWindowTitle() {
		return wDriver.getTitle();
	}
	
	public static void maximizeWindow() {
		wDriver.manage().window().maximize();
	}
	
	public static void minimizeWindow() {
		wDriver.manage().window().minimize();
	}
	
	public static void fullscreenWindow() {
		wDriver.manage().window().fullscreen();
	}
	
}
