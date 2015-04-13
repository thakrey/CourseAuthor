package com.lrn.model.spring.service.response.user.course;

import java.io.Serializable;
import java.util.Date;

public class CourseInformationDTO implements Serializable {

	private static final long serialVersionUID = 3566874699261122409L;

	private Date assignmentDate;
	
	private Date dueDate;
	
	private String completionStatus;
	
	private Date completionDate;
	
	private String catalogId;
	
	private String moduleTitle;
	
	private Long timeSpent;
	
	private Long score;
	
	private String languageVersion;
	
	private String courseUrl;	

	/**
	 * @return the assignmentDate
	 */
	public Date getAssignmentDate() {
		return assignmentDate;
	}

	/**
	 * @param assignmentDate the assignmentDate to set
	 */
	public void setAssignmentDate(Date assignmentDate) {
		this.assignmentDate = assignmentDate;
	}

	/**
	 * @return the dueDate
	 */
	public Date getDueDate() {
		return dueDate;
	}

	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * @return the completionStatus
	 */
	public String getCompletionStatus() {
		return completionStatus;
	}

	/**
	 * @param completionStatus the completionStatus to set
	 */
	public void setCompletionStatus(String completionStatus) {
		this.completionStatus = completionStatus;
	}

	/**
	 * @return the completionDate
	 */
	public Date getCompletionDate() {
		return completionDate;
	}

	/**
	 * @param completionDate the completionDate to set
	 */
	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	/**
	 * @return the catalogId
	 */
	public String getCatalogId() {
		return catalogId;
	}

	/**
	 * @param catalogId the catalogId to set
	 */
	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

	/**
	 * @return the moduleTitle
	 */
	public String getModuleTitle() {
		return moduleTitle;
	}

	/**
	 * @param moduleTitle the moduleTitle to set
	 */
	public void setModuleTitle(String moduleTitle) {
		this.moduleTitle = moduleTitle;
	}

	/**
	 * @return the timeSpent
	 */
	public Long getTimeSpent() {
		return timeSpent;
	}

	/**
	 * @param timeSpent the timeSpent to set
	 */
	public void setTimeSpent(Long timeSpent) {
		this.timeSpent = timeSpent;
	}

	/**
	 * @return the score
	 */
	public Long getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(Long score) {
		this.score = score;
	}

	/**
	 * @return the languageVersion
	 */
	public String getLanguageVersion() {
		return languageVersion;
	}

	/**
	 * @param languageVersion the languageVersion to set
	 */
	public void setLanguageVersion(String languageVersion) {
		this.languageVersion = languageVersion;
	}

	/**
	 * @return the courseUrl
	 */
	public String getCourseUrl() {
		return courseUrl;
	}

	/**
	 * @param courseUrl the courseUrl to set
	 */
	public void setCourseUrl(String courseUrl) {
		this.courseUrl = courseUrl;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CourseInformationDTO [assignmentDate=" + assignmentDate
				+ ", dueDate=" + dueDate + ", completionStatus="
				+ completionStatus + ", completionDate=" + completionDate
				+ ", catalogId=" + catalogId + ", moduleTitle=" + moduleTitle
				+ ", timeSpent=" + timeSpent + ", score=" + score
				+ ", languageVersion=" + languageVersion + ", courseUrl="
				+ courseUrl + "]";
	}
}