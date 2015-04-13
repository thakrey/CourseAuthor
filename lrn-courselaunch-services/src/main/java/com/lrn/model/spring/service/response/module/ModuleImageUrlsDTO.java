package com.lrn.model.spring.service.response.module;

import java.util.List;

import com.lrn.model.spring.service.response.LRNResponse;

/**
 * The class ModuleImageUrlsDTO
 * @author vmulla
 *
 */
public class ModuleImageUrlsDTO {
	
	private static final long serialVersionUID = -5293389671138459313L;

	private List<ModuleImageUrlDTO> moduleImageUrl;

    private LRNResponse lrnResponse = null;

    
	/**
	 * @return the moduleImageUrl
	 */
	public List<ModuleImageUrlDTO> getModuleImageUrl() {
		return moduleImageUrl;
	}

	/**
	 * @param moduleImageUrl the moduleImageUrl to set
	 */
	public void setModuleImageUrl(List<ModuleImageUrlDTO> moduleImageUrl) {
		this.moduleImageUrl = moduleImageUrl;
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
