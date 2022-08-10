package com.novaproduction.hellonerd.selenium.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.novaproduction.hellonerd.selenium.BaseClass;
import com.novaproduction.hellonerd.selenium.browsernavigation.Navigation;
import com.novaproduction.hellonerd.selenium.elements.Element;
import com.novaproduction.hellonerd.selenium.inputgadgets.Keyboard;
import com.novaproduction.hellonerd.selenium.inputgadgets.Mouse;
import com.novaproduction.hellonerd.selenium.waits.Waits;
import com.novaproduction.hellonerd.selenium.window.Window;

import java.time.Duration;

public class Testclass extends BaseClass {
	private static WebDriver driver;
	
    @Test
    public void simpleTest() throws InterruptedException {
    	driver = super.startup();
    	Navigation.openBrowserUrl("https://google.com");       
        Thread.sleep(3000);
        Mouse.clickButton(By.xpath("//*[@id=\"L2AGLb\"]"));       
        Assertions.assertEquals("Google", Window.getWindowTitle());        
        Thread.sleep(3000);
        Waits.implicitWait(10);
        Keyboard.writeTextInElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"), "Selenium");        
        Thread.sleep(3000);
        WebElement searchBox = driver.findElement(By.name("q"));
        String value = searchBox.getAttribute("value");
        Assertions.assertEquals("Selenium", value);
        driver.quit();
    }
}
