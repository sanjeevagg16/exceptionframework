/******************************************************************************  
 *  Class              :   ExceptionLogging.java
 @ Author               :     Sanjeev
 @ Version              :     1.0
 @ Created On           :     Jun 20, 2016
 @ LastModified By      :     
 @ LastModified On      :     Jun 20, 2016 
 @ Change               :
 * Description			: For logging Exception for different inputs from  Checked & runtime exception classes
 *****************************************************************************/

package com.companyname.sortdirproject.common.exception;

import com.companyname.sortdirproject.common.logging.ReadDirLogger;

// TODO: Auto-generated Javadoc
/**
 * The Class ExceptionLogging.
 */
public class ExceptionLogging {

	/**
	 * Constructor for ExceptionLogger.
	 */
	private ExceptionLogging() {
		super();
	}

	/**
	 * Write exception information to the log.
	 * 
	 * @param componentName
	 *            The name of the component that generated the exception.
	 * @param theException
	 *            The exception whose message and stack trace should be logged.
	 */
	public static void logException(String componentName, Throwable theException) {
		logException(componentName, theException, null);
	}

	/**
	 * Write exception information to the log.
	 * 
	 * @param componentName
	 *            The name of the component that generated the exception.
	 * @param theException
	 *            The exception whose message and stack trace should be logged.
	 * @param context
	 *            An array of context information to be included in the log.
	 */
	public static void logException(String componentName,
			Throwable theException, Object[] context) {

		StringBuffer exceptionInfo = new StringBuffer();
		if (ReadDirLogger.info) {
			ReadDirLogger.logInfo(ExceptionLogging.class,
					"ExceptionLogging logException.. " + "componentName=="
							+ componentName + "==Throwable==" + theException
							+ "=cause=" + "==context==" + context);
		}
		exceptionInfo.append(getStackTraceString(theException));
		if (context != null) {
			exceptionInfo.append(ExceptionMessageFactory
					.getContextString(context));
		}
		System.err.println(exceptionInfo.toString());
	}

	/**
	 * Convert the stack trace into a String for printing purposes.
	 * 
	 * @param throwable
	 *            The Throwable whose stack trace needs to be string field.
	 * @return the stack trace string
	 */
	public static String getStackTraceString(Throwable throwable) {

		StringBuffer stackTrace = new StringBuffer(throwable.getClass()
				.getName() + " at ");
		StackTraceElement[] elements = throwable.getStackTrace();
		for (int i = 0; i < elements.length; i++) {
			stackTrace.append(elements[i].toString() + "\n");
		}
		return stackTrace.toString();

	}

}
