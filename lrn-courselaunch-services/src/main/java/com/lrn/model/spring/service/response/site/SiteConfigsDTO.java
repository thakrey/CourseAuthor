package com.lrn.model.spring.service.response.site;

import java.io.Serializable;

/**  
* The Class SiteConfigsDTO
* 
*/ 
public class SiteConfigsDTO implements Serializable {

	private static final long serialVersionUID = -2681994804452351157L;

	private String configName;
	
	private String configValue;

	public SiteConfigsDTO() {}
	
	/**
	 * constructor for SiteConfigsDTO 
	 * 
	 * @param configName
	 * @param configValue
	 */
	public SiteConfigsDTO(String configName, String configValue) {
		this.configName = configName;
		this.configValue = configValue;
	}
	
	/** Gets the configName
	 * 
	 * @return the configName
	 */
	public String getConfigName() {
		return configName;
	}

	/** Sets the configName
	 * 
	 * @param configName the configName to set
	 */
	public void setConfigName(String configName) {
		this.configName = configName;
	}

	/** Gets the configValue
	 * 
	 * @return the configValue
	 */
	public String getConfigValue() {
		return configValue;
	}

	/** Sets the configValue
	 * 
	 * @param configValue the configValue to set
	 */
	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}	
}