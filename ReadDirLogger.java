/******************************************************************************  

 *  Class              :   LoggingService.java
 @ Author               :     Sanjeev
 @ Version              :     1.0
 @ Created On           :     Jun 21, 2016
 @ LastModified By      :     
 @ LastModified On      :     Jun 21, 2016
 @ Change               :
 * Description		   : Main Logging class, will be used for logging from all other instances.
 Even though logger is disabled, it usually creates instance of logger classes which should not be required.
 The below implementation overrides the logger behaviour through application properties file". Here user can provide
 different log mode for development and production. Following statements describes logging behaviour.  
 
 If LOG_FOR_PRODUCTION_ENABLE is set enabled i.e. as "true", this will be given highest priority and will 
 override all other logging values mentioned for development. With below values, system will enable INFO level 
 for production mode only.

 LOG_FOR_PRODUCTION_ENABLE = true
 LOG_FOR_PRODUCTION_LEVEL = INFO
 The above settings will override all development settings.
 
 For development, there are two modes defined.  

 1) If ROOT_DEVELOPMENT_ENABLED: If set true, it will have highest priority in development. And, all 
 logger will take root logging level for logging. With below setting system will enable DEBUG level 
 for development mode only for root. 
 
 LOG_FOR_PRODUCTION_ENABLE = false
 ROOT_DEVELOPMENT_ENABLED = true
 ROOT_DEVELOPMENT_LEVEL = DEBUG
 The above settings may be required, when development need logger to be enabled at the root only.
 
 2)LOG_FOR_PRODUCTION_ENABLE: If ROOT_DEVELOPMENT_ENABLED is set false and LOG_FOR_PRODUCTION_ENABLE is 
 set true, all logger will take LOG_FOR_PRODUCTION_ENABLE level setting.
 
 LOG_FOR_PRODUCTION_ENABLE = false
 ROOT_DEVELOPMENT_ENABLED = false
 ROOT_DEVELOPMENT_ENABLED = true
 LOG_FOR_DEVELOPMENT_LEVEL= DEBUG
 The above settings may be required, when development does not need logger to be enabled at the root 
 *****************************************************************************/

package com.companyname.sortdirproject.common.logging;

import java.util.Properties;

import org.slf4j.Logger;

import com.companyname.sortdirproject.common.initialization.PropertyInitializationImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class ReadDirLogger.
 */
public class ReadDirLogger {

	/**
	 * The debug.
	 */
	public static boolean debug = true;

	/**
	 * The info.
	 */
	public static boolean info = true;

	/**
	 * The warn.
	 */
	public static boolean warn = true;

	/**
	 * The error.
	 */
	public static boolean error = true;

	/**
	 * The trace.
	 */
	public static boolean trace = true;

	/**
	 * The logmode.
	 */
	public static boolean logmode = true;

	/**
	 * The log for production enable.
	 */
	public static String LOG_FOR_PRODUCTION_ENABLE;

	/**
	 * The log for development enable.
	 */
	public static String LOG_FOR_DEVELOPMENT_ENABLE;

	/**
	 * The root qa enabled.
	 */
	public static String ROOT_QA_ENABLED;

	/**
	 * The instance.
	 */
	private static ReadDirLogger instance = null;

	/**
	 * The props.
	 */
	public static Properties props = null;

	static {
		configure();
	}

	/**
	 * Instantiates a new read dir logger.
	 */
	private ReadDirLogger() {
		super();
	}

	/**
	 * Gets the single instance of ReadDirLogger.
	 * 
	 * @return single instance of ReadDirLogger
	 */
	public static synchronized ReadDirLogger getInstance() {
		if (instance == null)
			instance = new ReadDirLogger();
		return instance;
	}

	/**
	 * Configure.
	 */
	public static void configure() {

		try {
			LOG_FOR_PRODUCTION_ENABLE = PropertyInitializationImpl
					.getProperty("LOG_FOR_PRODUCTION_ENABLE");
			ROOT_QA_ENABLED = PropertyInitializationImpl
					.getProperty("ROOT_QA_ENABLED");
			LOG_FOR_DEVELOPMENT_ENABLE = PropertyInitializationImpl
					.getProperty("LOG_FOR_DEVELOPMENT_ENABLE");

			if (LOG_FOR_PRODUCTION_ENABLE.length() != 0
					&& LOG_FOR_PRODUCTION_ENABLE.equalsIgnoreCase("true")) {
				setLogLevel(PropertyInitializationImpl
						.getProperty("LOG_FOR_PRODUCTION_LEVEL"));
			} else if (ROOT_QA_ENABLED.length() != 0
					&& ROOT_QA_ENABLED.equalsIgnoreCase("true")) {
				setLogLevel(PropertyInitializationImpl
						.getProperty("ROOT_QA_LEVEL"));
			} else {
				setLogLevel(PropertyInitializationImpl
						.getProperty("LOG_FOR_DEVELOPMENT_LEVEL"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sets the log level.
	 * 
	 * @param mode
	 *            the new log level
	 */
	private static void setLogLevel(String mode) {

		if (mode.length() != 0 && mode.equalsIgnoreCase("TRACE")) {
			trace = true;
			debug = true;
			info = true;
			warn = true;
			error = true;
		}
		if (mode.length() != 0 && mode.equalsIgnoreCase("DEBUG")) {
			trace = false;
			debug = true;
			info = true;
			warn = true;
			error = true;
		}
		if (mode.length() != 0 && mode.equalsIgnoreCase("INFO")) {
			trace = false;
			debug = false;
			info = true;
			warn = true;
			error = true;
		}
		if (mode.length() != 0 && mode.equalsIgnoreCase("WARN")) {
			trace = false;
			debug = false;
			info = false;
			warn = true;
			error = true;
		}

		if (mode.length() != 0 && mode.equalsIgnoreCase("ERROR")) {
			trace = false;
			debug = false;
			info = false;
			warn = false;
			error = true;
		}
		if (mode.length() != 0 && mode.equalsIgnoreCase("FATAL")) {
			debug = false;
			info = false;
			warn = false;
			error = false;
		}
	}

	/**
	 * Log trace.
	 * 
	 * @param callingObject
	 *            the calling object
	 * @param debugMessage
	 *            the debug message
	 */
	@SuppressWarnings("rawtypes")
	public static void logTrace(Class callingObject, String debugMessage) {
		if (trace) {
			log(callingObject).debug(
					buildString(callingObject, debugMessage).toString());
		}
	}

	/**
	 * Log debug.
	 * 
	 * @param callingObject
	 *            the calling object
	 * @param debugMessage
	 *            the debug message
	 */
	@SuppressWarnings("rawtypes")
	public static void logDebug(Class callingObject, String debugMessage) {
		if (debug) {
			log(callingObject).debug(
					buildString(callingObject, debugMessage).toString());
		}
	}

	/**
	 * Log info.
	 * 
	 * @param callingObject
	 *            the calling object
	 * @param message
	 *            the message
	 */
	@SuppressWarnings("rawtypes")
	public static void logInfo(Class callingObject, String message) {
		if (info) {
			log(callingObject).info(
					buildString(callingObject, message).toString());
		}
	}

	/**
	 * Log warn.
	 * 
	 * @param callingObject
	 *            the calling object
	 * @param message
	 *            the message
	 */
	@SuppressWarnings("rawtypes")
	public static void logWarn(Class callingObject, String message) {
		if (warn) {
			log(callingObject).warn(
					buildString(callingObject, message).toString());
		}
	}

	/**
	 * Log error.
	 * 
	 * @param callingObject
	 *            the calling object
	 * @param thrown
	 *            the thrown
	 * @param debugMessage
	 *            the debug message
	 */
	@SuppressWarnings("rawtypes")
	public static void logError(Class callingObject, Throwable thrown,
			String debugMessage) {
		if (error) {
			if (thrown == null) {
				log(callingObject).error(
						buildString(callingObject, debugMessage).toString());
			} else {
				log(callingObject).error(
						buildString(callingObject, debugMessage).toString(),
						thrown);
			}
		}
	}

	/**
	 * Builds the string.
	 * 
	 * @param callingObject
	 *            the calling object
	 * @param strMsg
	 *            the str msg
	 * @return the string buffer
	 */
	@SuppressWarnings("rawtypes")
	private static StringBuffer buildString(Class callingObject, String strMsg) {
		return (new StringBuffer()).append(callingObject).append(" --> ")
				.append(strMsg);
	}

	/**
	 * Log.
	 * 
	 * @param callingObject
	 *            the calling object
	 * @return the logger
	 */
	@SuppressWarnings("rawtypes")
	private static Logger log(Class callingObject) {

		if (callingObject == null) {
			callingObject = (new Object()).getClass();
		}
		// Logger logger = getLogger(callingObject);
		return getLogger(callingObject);
	}

	/**
	 * Gets the logger.
	 * 
	 * @param callingObject
	 *            the calling object
	 * @return the logger
	 */
	@SuppressWarnings("rawtypes")
	private static Logger getLogger(Class callingObject) {
		Logger logger = LoggingServiceFactory.getService(callingObject);
		return logger;
	}
}
