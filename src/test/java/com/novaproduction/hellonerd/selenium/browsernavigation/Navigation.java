package com.novaproduction.hellonerd.selenium.browsernavigation;

import com.novaproduction.hellonerd.selenium.BaseClass;

public class Navigation extends BaseClass {
	public static void openBrowserUrl(String url) {
		wDriver.get(url);
	}
	
	public static void navigateToBrowserUrl(String url) {
		wDriver.navigate().to(url);
	}
	
	public static void navigateBrowserForward(String url) {
		wDriver.navigate().forward();
	}
	
	public static void navigateBrowserBack(String url) {
		wDriver.navigate().back();
	}
	
	public static void refreshBrowser(String url) {
		wDriver.navigate().refresh();
	}
	
}
