/**
 * 
 */
package com.lrn.dto.response.site;

import java.io.Serializable;

/**  
* SiteSettingsDTO - data transfer object class for site settings. 
* It stores the data for the site settings. 
* 
*/

public class SiteSettingsDTO implements Serializable {

	private String company;
	
	private String settingName;
	
	private String settingValue;

	/** Gets the company
	 * 
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/** Sets the company
	 * 
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/** Gets the settingName
	 * 
	 * @return the settingName
	 */
	public String getSettingName() {
		return settingName;
	}

	/** Sets the settingName
	 * 
	 * @param settingName the settingName to set
	 */
	public void setSettingName(String settingName) {
		this.settingName = settingName;
	}

	/** Gets the settingValue
	 * 
	 * @return the settingValue
	 */
	public String getSettingValue() {
		return settingValue;
	}

	/** Sets the settingValue
	 * 
	 * @param settingValue the settingValue to set
	 */
	public void setSettingValue(String settingValue) {
		this.settingValue = settingValue;
	}
}
