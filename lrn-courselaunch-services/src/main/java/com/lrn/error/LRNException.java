package com.lrn.error;

import com.lrn.model.spring.service.response.LRNError;

/**
 * The Class LRNException. 
 */
public class LRNException extends Exception{

	/** The lrn error. */
	private LRNError lrnError;
	
	/**
	 * Instantiates a new lRN exception from LRNError object. Adds error code to error message. 
	 *
	 * @param err the err
	 */
	public LRNException(LRNError err){
		super("LRNException: " + " ErrorCode: " + err.getCode() + " ErrorMsg: " + err.getMessage());
	}
	
	/**
	 * Instantiates a new lRN exception.
	 *
	 * @param errorMsg the error msg
	 */
	public LRNException(String errorMsg){
		super("LRNException: " + errorMsg);
	}
}
