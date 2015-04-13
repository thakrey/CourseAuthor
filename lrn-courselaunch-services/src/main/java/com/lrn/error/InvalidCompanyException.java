package com.lrn.error;

import org.apache.log4j.Logger;

public class InvalidCompanyException extends LRNException{
	
	private static final Logger logger = Logger.getLogger(InvalidCompanyException.class);
	
	public InvalidCompanyException(String errMsg){
		super("InvalidCompanyException: " + errMsg);
	}
}
