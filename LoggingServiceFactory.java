/******************************************************************************  

 *  Class              	:     LoggingServiceFactory.java
 @ Author               :     Sanjeev
 @ Version              :     1.0
 @ Created On           :     Jun 22, 2016
 @ LastModified By      :     
 @ LastModified On      :     Jun 22, 2016
 @ Change               : 
 * Description			: This class will for generating logging instances for different modules/classes.
 *****************************************************************************/

package com.companyname.sortdirproject.common.logging;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating LoggingService objects.
 */
public class LoggingServiceFactory {

	/**
	 * The logging service map.
	 */
	@SuppressWarnings("rawtypes")
	private static HashMap<Class, Logger> loggingServiceMap = new HashMap<Class, Logger>();
	
	/**
	 * The logging service object.
	 */
	private static Object loggingServiceObject = new Object();
	
	/**
	 * The instance.
	 */
	private static LoggingServiceFactory instance = null;

	/**
	 * Instantiates a new logging service factory.
	 */
	private LoggingServiceFactory() {
		super();
	}

	/**
	 * Gets the single instance of LoggingServiceFactory.
	 * 
	 * @return single instance of LoggingServiceFactory
	 */
	public synchronized static LoggingServiceFactory getInstance() {
		if (instance == null)
			instance = new LoggingServiceFactory();
		return instance;
	}

	/**
	 * Get an instance of the Service, if available from the available HashMap
	 * else create one and put into the HashMap for future reference avoiding
	 * loading of multiple instances.
	 * 
	 * @param clazz
	 *            the clazz
	 * @return the service
	 */

	public static Logger getService(Class<?> clazz) {

		Logger logger = null;
		synchronized (loggingServiceObject) {
			if (loggingServiceMap.containsKey(clazz)) {
				logger = loggingServiceMap.get(clazz);
			} else {
				logger = LoggerFactory.getLogger(clazz);
				loggingServiceMap.put(clazz, logger);
			}
		}
		return logger;
	}
}
