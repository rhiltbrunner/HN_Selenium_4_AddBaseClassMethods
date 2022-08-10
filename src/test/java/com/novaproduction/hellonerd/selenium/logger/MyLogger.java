package com.novaproduction.hellonerd.selenium.logger;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

public class MyLogger {
	private static Logger logger = Logger.getLogger(MyLogger.class.getName());
	
	public static void info(String text) {
		logger.info(getTimestamp()+", "+text);
	}
	
	public static void warning(String text) {
		logger.warning(getTimestamp()+", "+text);
	}
	
	public static void error(String text) {
		logger.severe(getTimestamp()+", "+text);
	}
	
	private static String getTimestamp() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(timestamp);
	}
}
