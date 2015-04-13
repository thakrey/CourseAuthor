package com.lrn.model.hibernate.site;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The Class SiteSettingsPK.
 *
 * @author kishor.pawar
 */
@Embeddable
public class SiteSettingsPK implements Serializable {

	private static final long serialVersionUID = 29577517049991700L;

	@Column(name="COMPANY")
	private String company;
	
	@Column(name="SETTING_NAME")
	private String settingName;

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @return the settingName
	 */
	public String getSettingName() {
		return settingName;
	}

	/**
	 * @param settingName the settingName to set
	 */
	public void setSettingName(String settingName) {
		this.settingName = settingName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result
				+ ((settingName == null) ? 0 : settingName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SiteSettingsPK other = (SiteSettingsPK) obj;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (settingName == null) {
			if (other.settingName != null)
				return false;
		} else if (!settingName.equals(other.settingName))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SiteSettingsPK [company=" + company + ", settingName="
				+ settingName + "]";
	}
	
	
}
