package com.lrn.error;

import org.apache.log4j.Logger;

import com.lrn.model.spring.service.response.LRNError;

// TODO: Auto-generated Javadoc
/**
 * The Class InvalidUsernameException.
 */
public class InvalidUsernameException extends LRNException{
	
	private static final Logger logger = Logger.getLogger(InvalidUsernameException.class);
	
	/**
	 * Instantiates a new invalid username exception.
	 *
	 * @param errMsg the err msg
	 */
	public InvalidUsernameException(String errMsg){
		super("InvalidUsernameException: " + errMsg);
	}
	
	/**
	 * Instantiates a new invalid username exception.
	 *
	 * @param lrnErr the lrn err
	 */
	public InvalidUsernameException(LRNError lrnErr){
		super("InvalidUsernameException: errorCode: " + lrnErr.getCode() + ": errorMsg: " + lrnErr.getMessage());
	}
//TODO: override trace method
}
