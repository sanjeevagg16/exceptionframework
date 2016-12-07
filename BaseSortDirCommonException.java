/******************************************************************************
 *  Class              	:   BaseSortDirCommonException.java 
 @ Author               :     Sanjeev
 @ Version              :     1.0
 @ Created On           :     Jun 20, 2016
 @ LastModified By      :     
 @ LastModified On      :     Jun 20, 2016
 @ Change               :
 * Description 		   	:	This class is designed for Base common "checked" exceptions System Exception only. Supposed to be used for common exceptions only.
 *****************************************************************************/

package com.companyname.sortdirproject.common.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseSortDirCommonException.
 */
public class BaseSortDirCommonException extends BaseSortDirException {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = -6787351201318120717L;

	/**
	 * Instantiates a new base sort dir common exception.
	 * 
	 * @param errorID
	 *            the error ID
	 */
	public BaseSortDirCommonException(String errorID) {
		super(errorID);
	}

	/**
	 * Instantiates a new base sort dir common exception.
	 * 
	 * @param erroCode
	 *            the erro code
	 * @param cause
	 *            the cause
	 */
	public BaseSortDirCommonException(String erroCode, Throwable cause) {
		super(erroCode, cause);
	}
}
