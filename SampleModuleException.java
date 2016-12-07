/******************************************************************************  

 *  Class              :   SampleModuleException.java
@ Author               :     Sanjeev
@ Version              :     1.0
@ Created On           :     Jun 20, 2016
@ LastModified By      :     
@ LastModified On      :     Jun 20, 2016
@ Change               :

 * Description		   : Demonstrate how exception will be implemented in different modules
 *****************************************************************************/

package com.companyname.sortdirproject.common.exception;

import com.companyname.sortdirproject.common.logging.ReadDirLogger;

// TODO: Auto-generated Javadoc
/**
 * The Class SampleModuleException.
 */
public class SampleModuleException extends BaseSortDirException {

	/**
	 * Instantiates a new sample module exception.
	 * 
	 * @param errorID
	 *            the error ID
	 * @param language
	 *            the language
	 * @param context
	 *            the context
	 * @param cause
	 *            the cause
	 */
	public SampleModuleException(String errorID, String language,
			Object[] context, Throwable cause) {
		super(errorID, context, cause);
		if (ReadDirLogger.debug) {
			ReadDirLogger.logDebug(SampleModuleException.class,
					"SampleModuleException .. "
							+ "==SampleModuleException finished with cause==");
		}
	}

	/**
	 * Instantiates a new sample module exception.
	 * 
	 * @param errorID
	 *            the error ID
	 * @param language
	 *            the language
	 * @param context
	 *            the context
	 */
	public SampleModuleException(String errorID, String language,
			Object[] context) {
		super(errorID, context);
		if (ReadDirLogger.debug) {
			ReadDirLogger
					.logDebug(
							SampleModuleException.class,
							"SampleModuleException .. "
									+ "==SampleModuleException finished with context==");
		}
	}
}
