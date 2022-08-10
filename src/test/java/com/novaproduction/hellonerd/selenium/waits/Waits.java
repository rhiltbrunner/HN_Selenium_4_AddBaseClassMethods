package com.novaproduction.hellonerd.selenium.waits;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import com.google.common.base.Function;
import com.novaproduction.hellonerd.selenium.BaseClass;

public class Waits extends BaseClass {
	
	public static void fluentWaitUntilElementIsFound(By identifier, int secondsToWait, long pulltimeInSeconds) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(wDriver)
				  .withTimeout(Duration.ofSeconds(secondsToWait))
				  .pollingEvery(Duration.ofSeconds(pulltimeInSeconds))
				  .ignoring(NoSuchElementException.class);
		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
		  public WebElement apply(WebDriver driver) {
		    return driver.findElement(identifier);
		  }
		});
	}
	
	public static void implicitWait( int secondsToWait) {
		wDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secondsToWait));
	}
	
	/**
     * Compare the text of the given webElement with the prefix text.
     * Compare only the beginning text.
     * 
     * @author hir
     * @param webElementLocator used to locate elements within a document. See documentation: {@link org.openqa.selenium.By}.
     * @param prefix to compare with the found text of the given webElement.
     */
    /*public void waitUntilTextIsVisible(final By webElementLocator, String prefix) throws TimeoutException {
        String failedMessage = "Text: '"+prefix+"' not exists in element: "+webElementLocator;
        try {
            WebElement webElement=getElementIfFound(webElementLocator);
            if(webElement!=null) {
                if( webElement.getText().length()>0 && webElement.getText().contains(prefix)) {
                    LOGGER.info("Text: '"+prefix+"' found in element: "+webElementLocator);
                }else {
                	LOGGER.info(failedMessage);
                    Assert.fail(failedMessage);
                }
            }
        }catch(Exception ex) {
        	LOGGER.info(failedMessage);
            Assert.fail(failedMessage);
        }
    }*/
}
