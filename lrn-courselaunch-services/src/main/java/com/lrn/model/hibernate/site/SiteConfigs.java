package com.lrn.model.hibernate.site;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The Class SiteConfigs.
 *
 * @author kishor.pawar
 */
@NamedQueries( {
	@NamedQuery(name = "findSiteConfigsByCompany",
			query = "from SiteConfigs sc where sc.siteConfigsPK.company = :company")
})
@Entity
@Table(name = "SITE_CONFIGS")
public class SiteConfigs implements Serializable {

	private static final long serialVersionUID = -6325151632833635878L;

	@Id
	private SiteConfigsPK siteConfigsPK;
	
	@Column(name="CONFIG_VALUE")
	private String configValue;

	/**
	 * @return the siteConfigsPK
	 */
	public SiteConfigsPK getSiteConfigsPK() {
		return siteConfigsPK;
	}

	/**
	 * @param siteConfigsPK the siteConfigsPK to set
	 */
	public void setSiteConfigsPK(SiteConfigsPK siteConfigsPK) {
		this.siteConfigsPK = siteConfigsPK;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((configValue == null) ? 0 : configValue.hashCode());
		result = prime * result
				+ ((siteConfigsPK == null) ? 0 : siteConfigsPK.hashCode());
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
		SiteConfigs other = (SiteConfigs) obj;
		if (configValue == null) {
			if (other.configValue != null)
				return false;
		} else if (!configValue.equals(other.configValue))
			return false;
		if (siteConfigsPK == null) {
			if (other.siteConfigsPK != null)
				return false;
		} else if (!siteConfigsPK.equals(other.siteConfigsPK))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SiteConfigs [siteConfigsPK=" + siteConfigsPK + ", configValue="
				+ configValue + "]";
	}
}
