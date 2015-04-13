package com.lrn.model.spring.service.response.site;

import java.io.Serializable;

import com.lrn.model.spring.service.response.LRNResponse;

/**
 * The Class SiteBrandingDTO.
 * 
 */
public class SiteBrandingDTO implements Serializable {

	private static final long serialVersionUID = 9049923626648803600L;

	private Long 				siteId;
	
	private String 				logo;
	
	private String 				welcomeText;
    
	private LRNResponse 		lrnResponse;
	
	/**
	 * @return the siteId
	 */
	public Long getSiteId() {
		return siteId;
	}

	/**
	 * @param siteId the siteId to set
	 */
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	/**
	 * @return the logo
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * @param logo the logo to set
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}

	/**
	 * @return the welcomeText
	 */
	public String getWelcomeText() {
		return welcomeText;
	}

	/**
	 * @param welcomeText the welcomeText to set
	 */
	public void setWelcomeText(String welcomeText) {
		this.welcomeText = welcomeText;
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