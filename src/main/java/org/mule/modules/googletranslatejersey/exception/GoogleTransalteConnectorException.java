/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.googletranslatejersey.exception;

public class GoogleTransalteConnectorException extends Exception {

	private static final long serialVersionUID = 1L;

	public GoogleTransalteConnectorException() {
	}

	public GoogleTransalteConnectorException(String message) {
		super(message);
	}

	public GoogleTransalteConnectorException(Throwable cause) {
		super(cause);
	}

	public GoogleTransalteConnectorException(String message, Throwable cause) {
		super(message, cause);
	}
}
