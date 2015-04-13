package com.lrn.error;

import org.apache.log4j.Logger;

public class InvalidSiteConfiguration extends LRNException {

	private static final Logger logger = Logger.getLogger(InvalidSiteConfiguration.class);
	
	public InvalidSiteConfiguration(String errMsg){
		super("InvalidSiteConfiguration: " + errMsg);
	}
}
