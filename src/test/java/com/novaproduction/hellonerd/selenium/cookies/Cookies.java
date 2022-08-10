package com.novaproduction.hellonerd.selenium.cookies;

import java.util.Set;
import org.openqa.selenium.Cookie;
import com.novaproduction.hellonerd.selenium.BaseClass;

public class Cookies extends BaseClass {

	public static void addCookie(String page, String setKey, String setValue) {
        try {
        	wDriver.get(page);

            // Adds the cookie into current browser context
            wDriver.manage().addCookie(new Cookie(setKey, setValue));
        } finally {
            wDriver.quit();
        }
	}
	
	public static Cookie getCookie(String page, String setKey) {
        try {
            wDriver.get(page);
            // Get cookie details with named cookie 'setKey'
            Cookie cookie1 = wDriver.manage().getCookieNamed(setKey);
            return cookie1;
        } finally {
            wDriver.quit();
        }
	}
	
	public static Set<Cookie> getAllCookies(String page) {
        try {
            wDriver.get(page);
            // Get All available cookies
            Set<Cookie> cookies = wDriver.manage().getCookies();
            return cookies;
        } finally {
            wDriver.quit();
        }
	}
	
	public static void deleteCookie(String page, String setKey) {
        try {
            wDriver.get(page);
            // Get cookie details with named cookie 'setKey'
            wDriver.manage().deleteCookieNamed(setKey);
        } finally {
            wDriver.quit();
        }
	}
	
	public static void deleteAllCookies(String page) {
        try {
            wDriver.get(page);
            // Get All available cookies
            wDriver.manage().deleteAllCookies();
        } finally {
            wDriver.quit();
        }
	}
	

}
