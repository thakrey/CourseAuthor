/**
 * 
 */
package com.lrn.dto;


/**  
* SiteConfigsDTO - data transfer object class for site configs. 
* It stores the data for the site configs. 
* 
* 
*/ 
public class SiteConfigsDTO {

	private String configName;
	
	private String configValue;

	public SiteConfigsDTO() {}
	
	/**
	 * constructor for SiteConfigsDTO 
	 * 
	 * @param configName
	 * @param configValue
	 *  
	 * 
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
