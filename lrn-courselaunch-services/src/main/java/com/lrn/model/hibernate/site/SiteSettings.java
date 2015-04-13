package com.lrn.model.hibernate.site;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class SiteSettings.
 *
 * @author kishor.pawar
 */
@Entity
@Table(name="SITE_SETTINGS")
public class SiteSettings implements Serializable {

	private static final long serialVersionUID = 7555190221681309063L;

	@Id
	private SiteSettingsPK siteSettingsPK;
	
	@Column(name="SETTING_VALUE")
    private String settingValue;

	/**
	 * @return the siteSettingsPK
	 */
	public SiteSettingsPK getSiteSettingsPK() {
		return siteSettingsPK;
	}

	/**
	 * @param siteSettingsPK the siteSettingsPK to set
	 */
	public void setSiteSettingsPK(SiteSettingsPK siteSettingsPK) {
		this.siteSettingsPK = siteSettingsPK;
	}

	/**
	 * @return the settingValue
	 */
	public String getSettingValue() {
		return settingValue;
	}

	/**
	 * @param settingValue the settingValue to set
	 */
	public void setSettingValue(String settingValue) {
		this.settingValue = settingValue;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((settingValue == null) ? 0 : settingValue.hashCode());
		result = prime * result
				+ ((siteSettingsPK == null) ? 0 : siteSettingsPK.hashCode());
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
		SiteSettings other = (SiteSettings) obj;
		if (settingValue == null) {
			if (other.settingValue != null)
				return false;
		} else if (!settingValue.equals(other.settingValue))
			return false;
		if (siteSettingsPK == null) {
			if (other.siteSettingsPK != null)
				return false;
		} else if (!siteSettingsPK.equals(other.siteSettingsPK))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SiteSettings [siteSettingsPK=" + siteSettingsPK
				+ ", settingValue=" + settingValue + "]";
	}	
}