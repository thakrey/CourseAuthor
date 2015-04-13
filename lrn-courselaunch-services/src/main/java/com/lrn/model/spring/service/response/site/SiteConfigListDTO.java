package com.lrn.model.spring.service.response.site;

import java.io.Serializable;
import java.util.List;

import com.lrn.model.spring.service.response.LRNResponse;

/**
 * The Class SiteConfigListDTO.
 * 
 */
public class SiteConfigListDTO implements Serializable {

	private static final long serialVersionUID = 951740560933434659L;

	private Long 				siteId;
	
	private List<SiteConfigDTO> configs;
    
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
	 * @return the configs
	 */
	public List<SiteConfigDTO> getConfigs() {
		return configs;
	}

	/**
	 * @param configs the configs to set
	 */
	public void setConfigs(List<SiteConfigDTO> configs) {
		this.configs = configs;
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