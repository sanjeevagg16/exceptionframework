/******************************************************************************  
 *  Class              	:   ExceptionMessageFactory.java
 @ Author               :     Sanjeev
 @ Version              :     1.0
 @ Created On           :     Jun 20, 2016
 @ LastModified By      :     
 @ LastModified On      :     Jun 20, 2016
 @ Change               :
 * Description		 	: This class will be source for fetching all exception messages.
 *****************************************************************************/

package com.companyname.sortdirproject.common.exception;

import com.companyname.sortdirproject.common.initialization.PropertyInitializationImpl;
import com.companyname.sortdirproject.common.logging.ReadDirLogger;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating ExceptionMessage objects.
 */
public class ExceptionMessageFactory {

	/**
	 * The initilized error msg.
	 */
	private static String initilized_error_msg = null;

	/**
	 * Instantiates a new exception message factory.
	 */
	public ExceptionMessageFactory() {
		super();
	}

	/**
	 * Gets the initialised messages.
	 * 
	 * @param key
	 *            the key
	 * @param language
	 *            the language
	 * @return the initialised messages
	 */
	// to get the error message with different language
	public static String getInitializedMessages(String key, String language) {
		try {
			if (ReadDirLogger.info) {
				ReadDirLogger.logInfo(ExceptionMessageFactory.class,
						"getInitializedMessages .. "
								+ "ExceptionMessageFactory1==" + key
								+ "==lang==" + language);
			}
			// initilized_error_msg = proprtyfile.getMessage(key, language);
			initilized_error_msg = PropertyInitializationImpl.getProperty(key);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return initilized_error_msg;
	}

	/**
	 * This method splits the error Id into its components. To associate input
	 * related information with errorid itself. Separate input parameters
	 * Object[] can be used for appending more information.
	 * 
	 * @param context
	 *            the context
	 * @return the context string
	 */
	public static String getContextString(Object[] context) {
		StringBuffer contextString = new StringBuffer();
		if (context != null) {
			for (int i = 0; i < context.length; i++) {
				contextString.append(context[i].toString() + " ");
			}
		}
		return contextString.toString();
	}
}
