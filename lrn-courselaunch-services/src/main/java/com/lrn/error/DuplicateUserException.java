package com.lrn.error;

import org.apache.log4j.Logger;

public class DuplicateUserException extends LRNException{

	private static final Logger logger = Logger.getLogger(DuplicateUserException.class);
	
	public DuplicateUserException(String username, String company){
		super("DuplicateUser: Cannot create user with username='"
				+ username + "' and company='" + company + "'. A user with given details already exists!");
	}
	
	public DuplicateUserException(String errMsg){
		super("DuplicateUser: " + errMsg);
	}
}
