package com.lrn.model.spring.service.response.site;

import java.io.Serializable;

/**
 * The Class SiteConfigDTO.
 * 
*/
public class SiteConfigDTO implements Serializable {

	private static final long serialVersionUID = 3418158130361172117L;

	private String 	configName;
	
	private String 	configValue;

	/**
	 * @return the configName
	 */
	public String getConfigName() {
		return configName;
	}

	/**
	 * @param configName the configName to set
	 */
	public void setConfigName(String configName) {
		this.configName = configName;
	}

	/**
	 * @return the configValue
	 */
	public String getConfigValue() {
		return configValue;
	}

	/**
	 * @param configValue the configValue to set
	 */
	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}
}