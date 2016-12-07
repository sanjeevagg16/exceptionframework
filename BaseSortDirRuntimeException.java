/******************************************************************************  
 *  Class              	:   BaseSortDirRuntimeException.java 
 @ Author               :     Sanjeev	
 @ Version              :     1.0
 @ Created On           :     Jun 20, 2016
 @ LastModified By      :     
 @ LastModified On      :     Jun 20, 2016
 @ Change               :
 * Description 		   	:	This class is designed for Base "Unchecked" exceptions, i.e. runtime 
 * System Exception only. Supposed to be extended this class for runtime exceptions only.
 * Designed as abstract to avoid direct extend. 

 *****************************************************************************/

package com.companyname.sortdirproject.common.exception;

import com.companyname.sortdirproject.common.initialization.PropertyInitializationImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseSortDirRuntimeException.
 */
public abstract class BaseSortDirRuntimeException extends RuntimeException
		implements ExceptionInterface {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 6933619586761974657L;
	
	/**
	 * The Constant COMPONENT_NAME.
	 */
	protected final static String COMPONENT_NAME = "BaseSortDirRuntimeException";
	
	/**
	 * The context.
	 */
	private Object[] context = null;
	
	/**
	 * The error code.
	 */
	private String errorCode = null;
	
	/**
	 * The error message.
	 */
	private String errorMessage = null;
	
	/**
	 * The error language.
	 */
	private String errorLanguage = null;

	/**
	 * Instantiates a new BaseSortDirRuntimeException exception.
	 * 
	 * @param errorID
	 *            the error ID
	 */
	public BaseSortDirRuntimeException(String errorID) {
		super(errorID);
		this.setErrorFields(errorID,
				PropertyInitializationImpl.getProperty("LANG_SEL"));
		ExceptionLogging.logException(COMPONENT_NAME, this);
	}

	/**
	 * Instantiates a new base sort dir runtime exception.
	 * 
	 * @param errorID
	 *            the error ID
	 * @param context
	 *            the context
	 */
	public BaseSortDirRuntimeException(String errorID, Object[] context) {
		super(errorID);
		this.setErrorFields(errorID,
				PropertyInitializationImpl.getProperty("LANG_SEL"));
		this.context = context;
		ExceptionLogging.logException(COMPONENT_NAME, this, context);
	}

	/**
	 * Instantiates a new base sort dir runtime exception.
	 * 
	 * @param errorID
	 *            the error ID
	 * @param cause
	 *            the cause
	 */
	public BaseSortDirRuntimeException(String errorID, Throwable cause) {
		super(errorID, cause);
		this.setErrorFields(errorID,
				PropertyInitializationImpl.getProperty("LANG_SEL"));
		ExceptionLogging.logException(COMPONENT_NAME, this, context);
	}

	/**
	 * Instantiates a new base sort dir runtime exception.
	 * 
	 * @param errorID
	 *            the error ID
	 * @param context
	 *            the context
	 * @param cause
	 *            the cause
	 */
	public BaseSortDirRuntimeException(String errorID, Object[] context,
			Throwable cause) {
		super(errorID, cause);
		this.setErrorFields(errorID,
				PropertyInitializationImpl.getProperty("LANG_SEL"));
		this.context = context;
		ExceptionLogging.logException(COMPONENT_NAME, this, context);
	}

	/**
	 * Gets the context.
	 * 
	 * @return Returns the contextId.
	 */
	public Object[] getContext() {
		return context;
	}

	/**
	 * Gets the error code.
	 * 
	 * @return Returns the error code
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * Gets the error message.
	 * 
	 * @return Returns the error message
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Gets the error language.
	 * 
	 * @return Returns the error language
	 */
	public String getErrorLanguage() {
		return errorLanguage;
	}

	/**
	 * This method sets different parameters of this exception instance. The
	 * user will be getting the same through respective getter methods.
	 * 
	 * @param key
	 *            the key
	 * @param language
	 *            the language
	 */
	private void setErrorFields(String key, String language) {
		if (key.length() != 0) {
			this.errorCode = key;
			this.errorLanguage = language;
			this.errorMessage = ExceptionMessageFactory.getInitializedMessages(
					key, language);
		}
	}

}
