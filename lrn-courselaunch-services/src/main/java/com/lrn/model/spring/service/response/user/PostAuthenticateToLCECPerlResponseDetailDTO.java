package com.lrn.model.spring.service.response.user;

import java.io.Serializable;

import com.lrn.model.spring.service.response.LRNResponse;

/**
 * The Class PostAuthenticateToLCECPerlResponseDetailDTO
 * 
 *
 */
public class PostAuthenticateToLCECPerlResponseDetailDTO implements Serializable {

	private static final long serialVersionUID = 2216524602428412368L;
	
	private String		responseHeader;
	
	private LRNResponse lrnResponse;

	/**
	 * @return the responseHeader
	 */
	public String getResponseHeader() {
		return responseHeader;
	}

	/**
	 * @param responseHeader the responseHeader to set
	 */
	public void setResponseHeader(String responseHeader) {
		this.responseHeader = responseHeader;
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