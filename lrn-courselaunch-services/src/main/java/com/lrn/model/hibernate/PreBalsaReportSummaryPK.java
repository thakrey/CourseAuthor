package com.lrn.model.hibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The Class PreBalsaReportSummaryPK
 */
@Embeddable
public class PreBalsaReportSummaryPK implements Serializable {

	private static final long serialVersionUID = -765157528529449481L;

	@Column(name="USER_ID")
	private String userId;
	
	@Column(name="CATALOG_ID")
	private String catalogid;
	
	@Column(name="COMPANY")
	private String company;

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the catalogid
	 */
	public String getCatalogid() {
		return catalogid;
	}

	/**
	 * @param catalogid the catalogid to set
	 */
	public void setCatalogid(String catalogid) {
		this.catalogid = catalogid;
	}

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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((catalogid == null) ? 0 : catalogid.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		PreBalsaReportSummaryPK other = (PreBalsaReportSummaryPK) obj;
		if (catalogid == null) {
			if (other.catalogid != null)
				return false;
		} else if (!catalogid.equals(other.catalogid))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PreBalsaReportSummaryPK [userId=" + userId + ", catalogid="
				+ catalogid + ", company=" + company + "]";
	}
	
	
}
