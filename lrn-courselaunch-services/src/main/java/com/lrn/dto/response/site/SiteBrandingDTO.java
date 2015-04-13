/**
 * 
 */
package com.lrn.dto.response.site;

import java.io.Serializable;

/**  
* SiteBrandingDTO - data transfer object class for site branding . 
* It stores the data for the site branding. 
* 
*/
public class SiteBrandingDTO implements Serializable {

	private String logo;
	
	private String welcomeText;

	/** Gets the logo
	 * 
	 * @return the logo
	 */
	public String getLogo() {
		return logo;
	}

	/** Sets the logo
	 * 
	 * @param logo the logo to set
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}

	/** Gets the welcomeText
	 * 
	 * @return the welcomeText
	 */
	public String getWelcomeText() {
		return welcomeText;
	}

	/** Sets the welcomeText
	 * 
	 * @param welcomeText the welcomeText to set
	 */
	public void setWelcomeText(String welcomeText) {
		this.welcomeText = welcomeText;
	}
	
	
}
