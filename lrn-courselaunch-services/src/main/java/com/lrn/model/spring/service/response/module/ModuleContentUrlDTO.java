package com.lrn.model.spring.service.response.module;

import com.lrn.model.spring.service.response.LRNResponse;

/**
 * The class ModuleContentUrlDTO
 * @author vmulla
 *
 */
public class ModuleContentUrlDTO {
	
	String moduleContentUrl = "";
	
	LRNResponse lrnResponse =  new LRNResponse();


	/**
	 * @return the lrnResponse
	 */
	public LRNResponse getLrnResponse() {
		return lrnResponse;
	}

	/**
	 * @return the moduleContentUrl
	 */
	public String getModuleContentUrl() {
		return moduleContentUrl;
	}

	/**
	 * @param moduleContentUrl the moduleContentUrl to set
	 */
	public void setModuleContentUrl(String moduleContentUrl) {
		this.moduleContentUrl = moduleContentUrl;
	}

	/**
	 * @param lrnResponse the lrnResponse to set
	 */
	public void setLrnResponse(LRNResponse lrnResponse) {
		this.lrnResponse = lrnResponse;
	}

}
