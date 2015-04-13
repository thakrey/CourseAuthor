package com.lrn.error;

import org.apache.log4j.Logger;

public class UnknownUserException extends LRNException{

	private static final Logger logger = Logger.getLogger(UnknownUserException.class);
	
	public UnknownUserException(String errMsg){
		super("UnknownUser: " + errMsg);
	}
	
}
