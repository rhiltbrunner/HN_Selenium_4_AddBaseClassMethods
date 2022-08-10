package com.novaproduction.hellonerd.selenium.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.novaproduction.hellonerd.selenium.BaseClass;

public class Alerts extends BaseClass {
	/**
	 * By.linkText("See an example alert")
	 * @param identifier
	 */
	public static void acceptAlerts(By identifier) {
		//Click the link to activate the alert
		wDriver.findElement(identifier).click();
		//Wait for the alert to be displayed and store it in a variable
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		//Press the OK button
		alert.accept();
	}
	
	public static void cancelAlerts(By identifier) {
		//Click the link to activate the alert
		wDriver.findElement(identifier).click();
		//Wait for the alert to be displayed
		wait.until(ExpectedConditions.alertIsPresent());
		//Store the alert in a variable
		Alert alert = wDriver.switchTo().alert();
		//Press the Cancel button
		alert.dismiss();
	}
	
	public static void acceptPrompt(By identifier) {
		//Click the link to activate the alert
		wDriver.findElement(identifier).click();
		//Wait for the alert to be displayed and store it in a variable
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		//Type your message
		alert.sendKeys("Selenium");
		//Press the OK button
		alert.accept();  
	}
	
}
