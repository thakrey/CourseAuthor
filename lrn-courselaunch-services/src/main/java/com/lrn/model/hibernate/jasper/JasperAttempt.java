package com.lrn.model.hibernate.jasper;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.lrn.model.hibernate.AbstractBaseEntity;

/**
 * The class JasperAttempt
 * 
 * @author kishor.pawar
 */
@NamedQueries( {
	@NamedQuery(name = "findByUserIdAndCompletionCertificateIds",
			query = "from JasperAttempt ja where ja.completionCertificateId in (:completionCertificateIds) and ja.userId = :userId")
})
@Entity
@SequenceGenerator(
		name 			= "GEN_SEQ",
		sequenceName 	= "JASPER_ATTEMPT_SEQ"
)
@Table(name="JASPER_ATTEMPT")
public class JasperAttempt extends AbstractBaseEntity {

	private static final long serialVersionUID = -309342922884294604L;

	@Column(name="SYSTEM_ID")
    private String systemId;
	
	@Column(name="USER_ID")
    private String userId;
	
	@Column(name="COMPLETION_CERTIFICATE_ID")
    private Long completionCertificateId;
	
	@Column(name="SITE_ID")
    private Long siteId;
	
	@Column(name="SRC_JASPER_STATUS_ID")
    private Long srcJasperStatusId;
	
	@Column(name="RISK_LEVEL")
    private Long riskLevel;
	
	@Column(name="START_DATE")
    private Date startDate;
	
	@Column(name="LAST_REVIEWED_BY")
    private String lastReviewedBy;
	
	@Column(name="MODIFIED")
    private Date modified;
	
	@Column(name="REVIEW_DUE_DATE")
    private Date reviewDueDate;

	/**
	 * @return the systemId
	 */
	public String getSystemId() {
		return systemId;
	}

	/**
	 * @param systemId the systemId to set
	 */
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

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
	 * @return the completionCertificateId
	 */
	public Long getCompletionCertificateId() {
		return completionCertificateId;
	}

	/**
	 * @param completionCertificateId the completionCertificateId to set
	 */
	public void setCompletionCertificateId(Long completionCertificateId) {
		this.completionCertificateId = completionCertificateId;
	}

	/**
	 * @return the siteId
	 */
	public Long getSiteId() {
		return siteId;
	}

	/**
	 * @param siteId the siteId to set
	 */
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	/**
	 * @return the srcJasperStatusId
	 */
	public Long getSrcJasperStatusId() {
		return srcJasperStatusId;
	}

	/**
	 * @param srcJasperStatusId the srcJasperStatusId to set
	 */
	public void setSrcJasperStatusId(Long srcJasperStatusId) {
		this.srcJasperStatusId = srcJasperStatusId;
	}

	/**
	 * @return the riskLevel
	 */
	public Long getRiskLevel() {
		return riskLevel;
	}

	/**
	 * @param riskLevel the riskLevel to set
	 */
	public void setRiskLevel(Long riskLevel) {
		this.riskLevel = riskLevel;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the lastReviewedBy
	 */
	public String getLastReviewedBy() {
		return lastReviewedBy;
	}

	/**
	 * @param lastReviewedBy the lastReviewedBy to set
	 */
	public void setLastReviewedBy(String lastReviewedBy) {
		this.lastReviewedBy = lastReviewedBy;
	}

	/**
	 * @return the modified
	 */
	public Date getModified() {
		return modified;
	}

	/**
	 * @param modified the modified to set
	 */
	public void setModified(Date modified) {
		this.modified = modified;
	}

	/**
	 * @return the reviewDueDate
	 */
	public Date getReviewDueDate() {
		return reviewDueDate;
	}

	/**
	 * @param reviewDueDate the reviewDueDate to set
	 */
	public void setReviewDueDate(Date reviewDueDate) {
		this.reviewDueDate = reviewDueDate;
	}
}
