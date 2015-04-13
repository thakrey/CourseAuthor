package com.lrn.model.hibernate;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The Class PreBalsaReportSummary
 */
@NamedQueries( {
	@NamedQuery(name = "findSummaryByUserIdAndCompany",
			query = "from PreBalsaReportSummary s where s.id.userId = :userId and s.id.company = :company")
})
@Entity
@Table(name = "PRE_BALSA_REPORT_SUMMARY")
public class PreBalsaReportSummary implements Serializable {
	
	private static final long serialVersionUID = -5400902163054373366L;

	@Id
	private PreBalsaReportSummaryPK id;

	@Column(name="TIME_SPENT_MIN")
	private Long timeSpentMin;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED")
	private Date created;

	/**
	 * @return the id
	 */
	public PreBalsaReportSummaryPK getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(PreBalsaReportSummaryPK id) {
		this.id = id;
	}

	/**
	 * @return the timeSpentMin
	 */
	public Long getTimeSpentMin() {
		return timeSpentMin;
	}

	/**
	 * @param timeSpentMin the timeSpentMin to set
	 */
	public void setTimeSpentMin(Long timeSpentMin) {
		this.timeSpentMin = timeSpentMin;
	}

	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((timeSpentMin == null) ? 0 : timeSpentMin.hashCode());
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
		PreBalsaReportSummary other = (PreBalsaReportSummary) obj;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (timeSpentMin == null) {
			if (other.timeSpentMin != null)
				return false;
		} else if (!timeSpentMin.equals(other.timeSpentMin))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PreBalsaReportSummary [id=" + id + ", timeSpentMin="
				+ timeSpentMin + ", created=" + created + "]";
	}
	
	
}
