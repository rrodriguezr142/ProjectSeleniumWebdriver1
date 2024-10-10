package com.magento.logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

	public static final Logger Log= (Logger) LogManager.getLogger(Log.class) ;
		// TODO Auto-generated method stub

	public static void info(String message) {
		Log.info(message);
	}
	
	public static void warn(String message) {
		Log.warn(message);
	}
	
	public static void error(String message) {
		Log.error(message);
	}
	
	public static void fatal(String message) {
		Log.fatal(message);
	}
	
	public static void debug(String message) {
		Log.debug(message);
	}
}
