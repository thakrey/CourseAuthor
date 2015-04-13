package com.lrn.model.spring.service.response.module;

import java.io.Serializable;

import com.lrn.model.spring.service.response.LRNResponse;

/**
 * The Class ModuleProgressDTO
 * @author Vmulla
 *
 */
public class ModuleProgressDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1831213833688806485L;

	boolean success = false;
	
	LRNResponse lrnResponse =  new LRNResponse();

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return the lrnResponse
	 */
	public LRNResponse getLrnResponse() {
		return lrnResponse;
	}

	/**
	 * @param lrnResponse the lrnResponse to set
	 */
	public void setLrnResponse(LRNResponse lrnResponse) {
		this.lrnResponse = lrnResponse;
	}
	

}
