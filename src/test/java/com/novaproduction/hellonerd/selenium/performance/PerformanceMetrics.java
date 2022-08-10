package com.novaproduction.hellonerd.selenium.performance;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v100.performance.Performance;
import org.openqa.selenium.devtools.v100.performance.model.Metric;

import com.novaproduction.hellonerd.selenium.BaseClass;

public class PerformanceMetrics extends BaseClass {
	
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static DevTools devTools = ((ChromeDriver) wDriver).getDevTools();
	
	/**
	 * Collect various performance metrics while navigating the application.
	 * @param pageUrl
	 * @return
	 */
	public static List<Metric> getCollectionOfPerformanceMetrics(String pageUrl) {
		devTools.createSession();
	    devTools.send(Performance.enable(Optional.empty()));
	    List<Metric> metricList = devTools.send(Performance.getMetrics());
	    wDriver.get(pageUrl);
	    wDriver.quit();
	    for(Metric m : metricList) {
	    	LOGGER.info(m.getName() + " = " + m.getValue());
	    }
	    return metricList;
	}
	
	public static String getCurrentDateTime() {
        SimpleDateFormat date_format = new SimpleDateFormat("MMM dd,yyyy HH:mm");
        Date resultdate = new Date();
        String currentBuildName=date_format.format(resultdate);
        return currentBuildName;
    }
    
    public static void resetTimer() {
        nonScientificTimer = new Date().getTime();
    }
    
    public static long elapsedSeconds() {
        return ((new Date().getTime()) - nonScientificTimer);
    }
}
