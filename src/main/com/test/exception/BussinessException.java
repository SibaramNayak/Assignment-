/**
 * 
 */
package com.test.exception;

import com.oraclecorp.oit.ngcc.ivr.enums.ErrorCode;


public class BussinessException extends Exception {

	private static final long serialVersionUID = 1L;
	private ErrorCode code;
	
	public BussinessException() {
		super();
	}

	public BussinessException(ErrorCode code) {
		super();
		this.code = code;
	}

	public BussinessException(String message, Throwable cause, ErrorCode code) {
		super(message, cause);
		this.code = code;
	}

	public BussinessException(String message, ErrorCode code) {
		super(message);
		this.code = code;
	}

	public BussinessException(Throwable cause, ErrorCode code) {
		super(cause);
		this.code = code;
	}
	
	public ErrorCode getCode() {
		return this.code;
	}

}
