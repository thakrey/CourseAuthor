package com.lrn.model.hibernate;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * The Class CompletionCertificate
 * 
 */
@NamedQueries({
		@NamedQuery(name = "findCompletionByUserIdAndCompany", query = "from CompletionCertificate cc where cc.userId = :userId and cc.company = :company"),
		@NamedQuery(name = "findCompletionByUserIdCompanyModuleId", query = "from CompletionCertificate cc where cc.userId = :userId and cc.company = :company and cc.moduleId = :moduleId"),
		@NamedQuery(name = "findCompletionByUserIdCompanyModuleIds", query = "from CompletionCertificate cc where cc.userId = :userId and cc.company = :company and cc.moduleId IN (:moduleIds)")})
		
@Entity
@SequenceGenerator(name = "GEN_SEQ", sequenceName = "SQ_COMPLETION_CERT")
@Table(name = "COMPLETION_CERTIFICATE")
public class CompletionCertificate implements Serializable {

	private static final long serialVersionUID = 6737627922607824018L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_SEQ")
	@Column(name = "CERTIFICATE_ID")
	private Long certificateId;

	@Column(name = "USER_ID")
	private String userId;

	@Column(name = "COMPANY")
	private String company;

	@Column(name = "CATALOG_ID")
	private String catalogId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "COMPLETION_DATE")
	private Date completionDate;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "SCORE")
	private Long score;

	@Column(name = "COURSE_SHORT_NAME")
	private String courseShortName;

	@Column(name = "VERSION")
	private String version;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "START_DATE")
	private Date startDate;

	@Column(name = "TIME_SPENT")
	private Long timeSpent;

	@Column(name = "SESSIONS")
	private Long sessions;

	@Column(name = "CREDIT_REASON_ID")
	private String creditReasonId;

	@Column(name = "CREDIT_COMMENT")
	private String creditComment;

	@Column(name = "MODULE_ID")
	private Long moduleId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFIED")
	private Date modified;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED")
	private Date created;

	@Column(name = "COURSE_XML_ID")
	private Long courseXmlId;

	@Column(name = "COURSE_VERSION_ID")
	private Long courseVersionId;

	/** curriculum id. */
	@Transient
	private Long curriculumId;
	/**
	 * @return the certificateId
	 */
	public Long getCertificateId() {
		return certificateId;
	}

	/**
	 * @param certificateId
	 *            the certificateId to set
	 */
	public void setCertificateId(Long certificateId) {
		this.certificateId = certificateId;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company
	 *            the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @return the catalogId
	 */
	public String getCatalogId() {
		return catalogId;
	}

	/**
	 * @param catalogId
	 *            the catalogId to set
	 */
	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

	/**
	 * @return the completionDate
	 */
	public Date getCompletionDate() {
		return completionDate;
	}

	/**
	 * @param completionDate
	 *            the completionDate to set
	 */
	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the score
	 */
	public Long getScore() {
		return score;
	}

	/**
	 * @param score
	 *            the score to set
	 */
	public void setScore(Long score) {
		this.score = score;
	}

	/**
	 * @return the courseShortName
	 */
	public String getCourseShortName() {
		return courseShortName;
	}

	/**
	 * @param courseShortName
	 *            the courseShortName to set
	 */
	public void setCourseShortName(String courseShortName) {
		this.courseShortName = courseShortName;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the timeSpent
	 */
	public Long getTimeSpent() {
		return timeSpent;
	}

	/**
	 * @param timeSpent
	 *            the timeSpent to set
	 */
	public void setTimeSpent(Long timeSpent) {
		this.timeSpent = timeSpent;
	}

	/**
	 * @return the sessions
	 */
	public Long getSessions() {
		return sessions;
	}

	/**
	 * @param sessions
	 *            the sessions to set
	 */
	public void setSessions(Long sessions) {
		this.sessions = sessions;
	}

	/**
	 * @return the creditReasonId
	 */
	public String getCreditReasonId() {
		return creditReasonId;
	}

	/**
	 * @param creditReasonId
	 *            the creditReasonId to set
	 */
	public void setCreditReasonId(String creditReasonId) {
		this.creditReasonId = creditReasonId;
	}

	/**
	 * @return the creditComment
	 */
	public String getCreditComment() {
		return creditComment;
	}

	/**
	 * @param creditComment
	 *            the creditComment to set
	 */
	public void setCreditComment(String creditComment) {
		this.creditComment = creditComment;
	}

	/**
	 * @return the moduleId
	 */
	public Long getModuleId() {
		return moduleId;
	}

	/**
	 * @param moduleId
	 *            the moduleId to set
	 */
	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	/**
	 * @return the modified
	 */
	public Date getModified() {
		return modified;
	}

	/**
	 * @param modified
	 *            the modified to set
	 */
	public void setModified(Date modified) {
		this.modified = modified;
	}

	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created
	 *            the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * @return the courseXmlId
	 */
	public Long getCourseXmlId() {
		return courseXmlId;
	}

	/**
	 * @param courseXmlId
	 *            the courseXmlId to set
	 */
	public void setCourseXmlId(Long courseXmlId) {
		this.courseXmlId = courseXmlId;
	}

	/**
	 * @return the courseVersionId
	 */
	public Long getCourseVersionId() {
		return courseVersionId;
	}

	/**
	 * @param courseVersionId
	 *            the courseVersionId to set
	 */
	public void setCourseVersionId(Long courseVersionId) {
		this.courseVersionId = courseVersionId;
	}

	/**
	 * @return the curriculumId
	 */
	public Long getCurriculumId() {
		return curriculumId;
	}

	/**
	 * @param curriculumId the curriculumId to set
	 */
	public void setCurriculumId(Long curriculumId) {
		this.curriculumId = curriculumId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((catalogId == null) ? 0 : catalogId.hashCode());
		result = prime * result
				+ ((certificateId == null) ? 0 : certificateId.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result
				+ ((completionDate == null) ? 0 : completionDate.hashCode());
		result = prime * result
				+ ((courseShortName == null) ? 0 : courseShortName.hashCode());
		result = prime * result
				+ ((courseVersionId == null) ? 0 : courseVersionId.hashCode());
		result = prime * result
				+ ((courseXmlId == null) ? 0 : courseXmlId.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result
				+ ((creditComment == null) ? 0 : creditComment.hashCode());
		result = prime * result
				+ ((creditReasonId == null) ? 0 : creditReasonId.hashCode());
		result = prime * result
				+ ((modified == null) ? 0 : modified.hashCode());
		result = prime * result
				+ ((moduleId == null) ? 0 : moduleId.hashCode());
		result = prime * result + ((score == null) ? 0 : score.hashCode());
		result = prime * result
				+ ((sessions == null) ? 0 : sessions.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((timeSpent == null) ? 0 : timeSpent.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		CompletionCertificate other = (CompletionCertificate) obj;
		if (catalogId == null) {
			if (other.catalogId != null)
				return false;
		} else if (!catalogId.equals(other.catalogId))
			return false;
		if (certificateId == null) {
			if (other.certificateId != null)
				return false;
		} else if (!certificateId.equals(other.certificateId))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (completionDate == null) {
			if (other.completionDate != null)
				return false;
		} else if (!completionDate.equals(other.completionDate))
			return false;
		if (courseShortName == null) {
			if (other.courseShortName != null)
				return false;
		} else if (!courseShortName.equals(other.courseShortName))
			return false;
		if (courseVersionId == null) {
			if (other.courseVersionId != null)
				return false;
		} else if (!courseVersionId.equals(other.courseVersionId))
			return false;
		if (courseXmlId == null) {
			if (other.courseXmlId != null)
				return false;
		} else if (!courseXmlId.equals(other.courseXmlId))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (creditComment == null) {
			if (other.creditComment != null)
				return false;
		} else if (!creditComment.equals(other.creditComment))
			return false;
		if (creditReasonId == null) {
			if (other.creditReasonId != null)
				return false;
		} else if (!creditReasonId.equals(other.creditReasonId))
			return false;
		if (modified == null) {
			if (other.modified != null)
				return false;
		} else if (!modified.equals(other.modified))
			return false;
		if (moduleId == null) {
			if (other.moduleId != null)
				return false;
		} else if (!moduleId.equals(other.moduleId))
			return false;
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
		if (sessions == null) {
			if (other.sessions != null)
				return false;
		} else if (!sessions.equals(other.sessions))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (timeSpent == null) {
			if (other.timeSpent != null)
				return false;
		} else if (!timeSpent.equals(other.timeSpent))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompletionCertificate [certificateId=" + certificateId
				+ ", userId=" + userId + ", company=" + company
				+ ", catalogId=" + catalogId + ", completionDate="
				+ completionDate + ", status=" + status + ", score=" + score
				+ ", courseShortName=" + courseShortName + ", version="
				+ version + ", startDate=" + startDate + ", timeSpent="
				+ timeSpent + ", sessions=" + sessions + ", creditReasonId="
				+ creditReasonId + ", creditComment=" + creditComment
				+ ", moduleId=" + moduleId + ", modified=" + modified
				+ ", created=" + created + ", courseXmlId=" + courseXmlId
				+ ", courseVersionId=" + courseVersionId + "]";
	}

}
