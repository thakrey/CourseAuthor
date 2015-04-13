package com.lrn.error;

import org.apache.log4j.Logger;

import com.lrn.model.spring.service.response.LRNError;

// TODO: Auto-generated Javadoc
/**
 * The Class InvalidPasswordException.
 */
public class InvalidPasswordException extends LRNException{
	
	private static final Logger logger = Logger.getLogger(InvalidPasswordException.class);
	
	/**
	 * Instantiates a new invalid password exception.
	 *
	 * @param errMsg the err msg
	 */
	public InvalidPasswordException(String errMsg){
		super("InvalidPasswordException: " + errMsg);
	}
	
	/**
	 * Instantiates a new invalid password exception.
	 *
	 * @param lrnErr the lrn err
	 */
	public InvalidPasswordException(LRNError lrnErr){
		super("InvalidPasswordException: errorCode: " + lrnErr.getCode() + ": errorMsg: " + lrnErr.getMessage());
	}
//TODO: override trace method
}
