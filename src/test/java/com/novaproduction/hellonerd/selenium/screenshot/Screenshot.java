package com.novaproduction.hellonerd.selenium.screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.print.PrintOptions;

import com.novaproduction.hellonerd.selenium.BaseClass;

public class Screenshot extends BaseClass {
	public static void takeScreenshotOfPage(String saveScreenShotPath, String pageToScreenShot) throws IOException {
		wDriver.get(pageToScreenShot);
        File scrFile = ((TakesScreenshot)wDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(saveScreenShotPath));
        wDriver.quit();
	}
	
	public static void takeScreenshotOfElement(String saveScreenShotPath, String pageToScreenShot, By elementToScreenShot) throws IOException {
		wDriver.get(pageToScreenShot);
		WebElement element = wDriver.findElement(elementToScreenShot);
        File scrFile = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(saveScreenShotPath));
        wDriver.quit();
	}
	
	public static String printChromiumPageAndGetContent(String url) {
		wDriver.get(url);
	    PrintsPage printer = (PrintsPage) wDriver;

	    PrintOptions printOptions = new PrintOptions();
	    printOptions.setPageRanges("1-2");

	    Pdf pdf = printer.print(printOptions);
	    String content = pdf.getContent();
	    return content;
	}
}
