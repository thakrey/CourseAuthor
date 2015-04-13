package com.lrn.model.spring.service.response.saml;

import java.io.Serializable;

import com.lrn.model.spring.service.response.LRNResponse;

/**
 * The Class SiteInfoDTO.
 */
public class SamlTokenDTO implements Serializable {

	private static final long serialVersionUID = 7336145765270956099L;

	private String 		samlToken;
    
    private LRNResponse lrnResponse;

	/**
	 * @return the samlToken
	 */
	public String getSamlToken() {
		return samlToken;
	}

	/**
	 * @param samlToken the samlToken to set
	 */
	public void setSamlToken(String samlToken) {
		this.samlToken = samlToken;
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