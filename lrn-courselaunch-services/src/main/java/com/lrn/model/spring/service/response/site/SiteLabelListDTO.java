package com.lrn.model.spring.service.response.site;

import java.io.Serializable;
import java.util.List;

import com.lrn.model.spring.service.response.LRNResponse;

/**
 * The Class SiteLabelListDTO.
 * 
 */
public class SiteLabelListDTO implements Serializable {

	private static final long serialVersionUID = -8721905591106693721L;

	private Long 				siteId;
	
	private List<SiteLabelDTO> 	labels;
    
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
	 * @return the labels
	 */
	public List<SiteLabelDTO> getLabels() {
		return labels;
	}

	/**
	 * @param labels the labels to set
	 */
	public void setLabels(List<SiteLabelDTO> labels) {
		this.labels = labels;
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