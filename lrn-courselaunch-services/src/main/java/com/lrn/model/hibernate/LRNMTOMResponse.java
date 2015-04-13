package com.lrn.model.hibernate;

import javax.activation.DataHandler;

import com.lrn.model.spring.service.response.LRNResponse;

/**
 * The Class LRNMTOMResponse.
 *
 */
public class LRNMTOMResponse extends LRNResponse {

	public static final long serialVersionUID = 0L;
	
	DataHandler dataHandler = null;
	
	/**
	 * 
	 */
	public LRNMTOMResponse() {
	}

	/**
	 * @param errorCode
	 * @param errorMessage
	 */
	public LRNMTOMResponse(Long errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}
	
	/**
	 * @param errorCode
	 * @param errorMessage
	 * @param dataHandler
	 */
	public LRNMTOMResponse(Long errorCode, String errorMessage, DataHandler dataHandler) {
		super(errorCode, errorMessage);
		this.dataHandler = dataHandler;
	}	
	
	public DataHandler getDataHandler() {
		return dataHandler;
	}

	public void setDataHandler(DataHandler dataHandler) {
		this.dataHandler = dataHandler;
	}
	
	

}
