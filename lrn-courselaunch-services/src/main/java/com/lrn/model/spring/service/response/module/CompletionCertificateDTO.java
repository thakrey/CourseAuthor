package com.lrn.model.spring.service.response.module;

import java.io.Serializable;
import java.util.Date;

public class CompletionCertificateDTO implements Serializable {

	private static final long serialVersionUID = 9189447762507488132L;

	private Long certificateId;
	
	private String userId;
	
	private String company;
	
	private String catalogId;
	
	private String completionDate;
	
	private String status;
	
	private Long score;
	
	private String courseShortName;
	
	private String courseDescription;
	
	private String courseImgUrl;
	
	private String version;
	
	private Date startDate;
	
	private Long timeSpent;
	
	private Long sessions;
	
	private String creditReasonId;
	
	private String creditComment;
	
	private Long moduleId;
	
	private Date modified;
	
	private Date created;
	
	private Long courseXmlId;
	
	private Long courseVersionId;
	
	private String hasCert;
	
	private String preBalsaReportSummary;
	
	private String appType;
	
	private String systemId;
	
	private Boolean isAvailable = false;
	
	private Boolean allowRetake = false;
	
	private Long curriculumId;

	/** Gets the certificateId
	 * 
	 * @return the certificateId
	 */
	public Long getCertificateId() {
		return certificateId;
	}

	/** Sets the certificateId
	 * 
	 * @param certificateId the certificateId to set
	 */
	public void setCertificateId(Long certificateId) {
		this.certificateId = certificateId;
	}

	/** Gets the userId
	 * 
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	
	public Long getCurriculumId() {
		return curriculumId;
	}

	public void setCurriculumId(Long curriculumId) {
		this.curriculumId = curriculumId;
	}

	/** Sets the userId
	 * 
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

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

	/** Gets the catalogId
	 * 
	 * @return the catalogId
	 */
	public String getCatalogId() {
		return catalogId;
	}

	/** Sets the catalogId 
	 * 
	 * @param catalogId the catalogId to set
	 */
	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

	/** Gets the completionDate
	 * 
	 * @return the completionDate
	 */
	public String getCompletionDate() {
		return completionDate;
	}

	/** Sets the completionDate
	 * 
	 * @param completionDate the completionDate to set
	 */
	public void setCompletionDate(String completionDate) {
		this.completionDate = completionDate;
	}

	/** Gets the status
	 * 
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/** Sets the status
	 * 
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/** Gets the score
	 * 
	 * @return the score
	 */
	public Long getScore() {
		return score;
	}

	/** Sets the score
	 * 
	 * @param score the score to set
	 */
	public void setScore(Long score) {
		this.score = score;
	}

	/** Gets the courseShortName
	 * 
	 * @return the courseShortName
	 */
	public String getCourseShortName() {
		return courseShortName;
	}

	/** Sets the courseShortName
	 * 
	 * @param courseShortName the courseShortName to set
	 */
	public void setCourseShortName(String courseShortName) {
		this.courseShortName = courseShortName;
	}

	
	/** Gets the courseDescription
	 * 
	 * @return the courseDescription
	 */
	public String getCourseDescription() {
		return courseDescription;
	}

	/** Sets the courseDescription
	 * 
	 * @param courseDescription the courseDescription to set
	 */
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	/** Gets the courseImageUrl
	 * 
	 * @return the courseImageUrl
	 */
	public String getCourseImgUrl() {
		return courseImgUrl;
	}

	/** Sets the courseImageUrl
	 * 
	 * @param courseImageUrl the courseImageUrl to set
	 */
	public void setCourseImgUrl(String courseImgUrl) {
		this.courseImgUrl = courseImgUrl;
	}

	/** Gets the version
	 * 
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/** Sets the version
	 * 
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/** Gets the startDate
	 * 
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/** Sets the startDate
	 * 
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/** Gets the timeSpent
	 * 
	 * @return the timeSpent
	 */
	public Long getTimeSpent() {
		return timeSpent;
	}

	/** Sets the timeSpent
	 * 
	 * @param timeSpent the timeSpent to set
	 */
	public void setTimeSpent(Long timeSpent) {
		this.timeSpent = timeSpent;
	}

	/** Gets the sessions
	 * 
	 * @return the sessions
	 */
	public Long getSessions() {
		return sessions;
	}

	/** Sets the sessions
	 * 
	 * @param sessions the sessions to set
	 */
	public void setSessions(Long sessions) {
		this.sessions = sessions;
	}

	/** Gets the creditReasonId
	 * 
	 * @return the creditReasonId
	 */
	public String getCreditReasonId() {
		return creditReasonId;
	}

	/** Sets the creditReasonId
	 * 
	 * @param creditReasonId the creditReasonId to set
	 */
	public void setCreditReasonId(String creditReasonId) {
		this.creditReasonId = creditReasonId;
	}

	/** Gets the creditComment
	 * 
	 * @return the creditComment
	 */
	public String getCreditComment() {
		return creditComment;
	}

	/** Sets the creditComment
	 * 
	 * @param creditComment the creditComment to set
	 */
	public void setCreditComment(String creditComment) {
		this.creditComment = creditComment;
	}

	/** Gets the moduleId
	 * 
	 * @return the moduleId
	 */
	public Long getModuleId() {
		return moduleId;
	}

	/** Sets the moduleId
	 * 
	 * @param moduleId the moduleId to set
	 */
	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	/** Gets the modified
	 * 
	 * @return the modified
	 */
	public Date getModified() {
		return modified;
	}

	/** Sets the modified
	 * 
	 * @param modified the modified to set
	 */
	public void setModified(Date modified) {
		this.modified = modified;
	}

	/** Gets the created
	 * 
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/** Sets the created
	 * 
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/** Gets the courseXmlId
	 * 
	 * @return the courseXmlId
	 */
	public Long getCourseXmlId() {
		return courseXmlId;
	}

	/** Sets the courseXmlId
	 * 
	 * @param courseXmlId the courseXmlId to set
	 */
	public void setCourseXmlId(Long courseXmlId) {
		this.courseXmlId = courseXmlId;
	}

	/** Gets the courseVersionId
	 * 
	 * @return the courseVersionId
	 */
	public Long getCourseVersionId() {
		return courseVersionId;
	}

	/** Sets the courseVersionId
	 * 
	 * @param courseVersionId the courseVersionId to set
	 */
	public void setCourseVersionId(Long courseVersionId) {
		this.courseVersionId = courseVersionId;
	}

	/** Gets the hasCert
	 * 
	 * @return the hasCert
	 */
	public String getHasCert() {
		return hasCert;
	}

	/** Sets the hasCert
	 * 
	 * @param hasCert the hasCert to set
	 */
	public void setHasCert(String hasCert) {
		this.hasCert = hasCert;
	}

	/** Gets the preBalsaReportSummary 
	 * 
	 * @return the preBalsaReportSummary
	 */
	public String getPreBalsaReportSummary() {
		return preBalsaReportSummary;
	}

	/** Sets the preBalsaReportsummary
	 * 
	 * @param preBalsaReportSummary the preBalsaReportSummary to set
	 */
	public void setPreBalsaReportSummary(String preBalsaReportSummary) {
		this.preBalsaReportSummary = preBalsaReportSummary;
	}

	/**Gets the appType 
	 * 
	 * @return the appType
	 */
	public String getAppType() {
		return appType;
	}

	/** Sets the appType
	 * 
	 * @param appType the appType to set
	 */
	public void setAppType(String appType) {
		this.appType = appType;
	}

	/** Gets the systemId
	 * 
	 * @return the systemId
	 */
	public String getSystemId() {
		return systemId;
	}

	/** Sets the systemId
	 * 
	 * @param systemId the systemId to set
	 */
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	/** Gets the isAvailable flag (true or false)
	 * 
	 * @return the isAvailable
	 */
	public Boolean getIsAvailable() {
		return isAvailable;
	}

	/** Sets the isAvailable flag(true or false)
	 * 
	 * @param isAvailable the isAvailable to set
	 */
	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	/** Gets the allowRetake
	 * 
	 * @return the allowRetake
	 */
	public Boolean getAllowRetake() {
		return allowRetake;
	}

	/** Sets the allowRetake
	 * 
	 * @param allowRetake the allowRetake to set
	 */
	public void setAllowRetake(Boolean allowRetake) {
		this.allowRetake = allowRetake;
	}
}
