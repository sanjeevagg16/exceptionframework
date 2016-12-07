/******************************************************************************  

 *  Class              	:   TestException.java

 @ Author               :     Sanjeev
 @ Version              :     1.0

 @ Created On           :     Jun 28, 2016
  @ LastModified By     :
 @ LastModified On      :     Jun 28, 2016
 @ Change               :
 * Description			:  Test Exception class

 *****************************************************************************/

package com.companyname.sortdirproject.common.exception;

import com.companyname.sortdirproject.common.logging.ReadDirLogger;

// TODO: Auto-generated Javadoc
/**
 * The Class TestException.
 */
public class TestException {

	/**
	 * Instantiates a new test exception.
	 */
	public TestException() {
		super();
	}

	/**
	 * The main method.
	 * 
	 * @param arg
	 *            the arguments
	 * @throws Exception
	 *             the exception
	 */
	public static void main(String arg[]) throws Exception {

		try {

			TestException test = new TestException();
			test.testException();

		} catch (SampleModuleException exp) {
			if (ReadDirLogger.info) {
				ReadDirLogger.logInfo(TestException.class,
						"ExceptionLogging logException.. " + exp.getErrorCode()
								+ "=errorLan=" + exp.getErrorLanguage());
			}
		}
	}

	/**
	 * Test exception.
	 * 
	 * @throws SampleModuleException
	 *             the sample module exception
	 */
	public void testException() throws SampleModuleException {
		Object[] context = { "Account1=", "Account2==", "Account3==" };
		throw new SampleModuleException("ERROR.GENERAL", "EN", context);
	}
}
