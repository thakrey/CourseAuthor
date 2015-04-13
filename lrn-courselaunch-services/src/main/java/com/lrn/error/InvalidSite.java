package com.lrn.error;

import org.apache.log4j.Logger;

/**
 * An InvalidSite is basically thrown by saveOrUpdate() method in com.lrn.ram.dao.SiteConfigDao and insertEntity() method 
 * in com.lrn.ram.manager.RamEntityManager. This exception is basically thrown to indicate Site/siteId object is null.
 */
public class InvalidSite extends LRNException{
	
	private static final Logger logger = Logger.getLogger(InvalidSite.class);
	
	/**
	 * Instantiates a new invalid site.
	 *
	 * @param errMsg the err msg
	 */
	public InvalidSite(String errMsg){
		super("InvalidSite: " + errMsg);
	}
}
