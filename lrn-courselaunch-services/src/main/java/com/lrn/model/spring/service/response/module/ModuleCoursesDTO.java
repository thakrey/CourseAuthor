package com.lrn.model.spring.service.response.module;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author vmulla
 *
 */
public class ModuleCoursesDTO implements Serializable {
	
	private static final long serialVersionUID = 6386369048696276858L;

	/** The module id. */
	private Long moduleId;
	
	/** The src cert req id. */
	private Long srcCertReqId;
	
	/** The module chain id. */
	private Long moduleChainId;
	
	/** The sequence. */
	private Long sequence;
	
	/** The sent back for revision. */
	private Boolean sentBackForRevision = false;
	
	/** The estimated time. */
	private String estimatedTime;
	
	/** The num days before due. */
	private Integer numDaysBeforeDue;

	/** The num days before review due. */
	private Long numDaysBeforeReviewDue;
	
	/** The due date. */
	private String dueDate;
	
	/** The curriculum id. */
	private Long curriculumId;
	
	private Boolean inProgress = false;
	
	/** The course lookup. */
	private List<CourseLookupDTO> courseLookup;
	
	/** user module preferred languages **/
	private String userModulePrefLang;
	
	private boolean isModuleCompleted;
	
	private String completionDate;
	
	public String getUserModulePrefLang() {
		return userModulePrefLang;
	}

	public void setUserModulePrefLang(String userModulePrefLang) {
		this.userModulePrefLang = userModulePrefLang;
	}

	/**
	 * Gets the module id.
	 *
	 * @return the moduleId
	 */
	public Long getModuleId() {
		return moduleId;
	}

	/**
	 * Sets the module id.
	 *
	 * @param moduleId the moduleId to set
	 */
	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}
	
	/**
	 * Gets the src cert req id.
	 *
	 * @return the srcCertReqId
	 */
	public Long getSrcCertReqId() {
		return srcCertReqId;
	}

	/**
	 * Sets the src cert req id.
	 *
	 * @param srcCertReqId the srcCertReqId to set
	 */
	public void setSrcCertReqId(Long srcCertReqId) {
		this.srcCertReqId = srcCertReqId;
	}

	/**
	 * Gets the module chain id.
	 *
	 * @return the moduleChainId
	 */
	public Long getModuleChainId() {
		return moduleChainId;
	}

	/**
	 * Sets the module chain id.
	 *
	 * @param moduleChainId the moduleChainId to set
	 */
	public void setModuleChainId(Long moduleChainId) {
		this.moduleChainId = moduleChainId;
	}

	/**
	 * Gets the sequence.
	 *
	 * @return the sequence
	 */
	public Long getSequence() {
		return sequence;
	}

	/**
	 * Sets the sequence.
	 *
	 * @param sequence the sequence to set
	 */
	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}

	/**
	 * Gets the sent back for revision.
	 *
	 * @return the sentBackForRevision
	 */
	public Boolean getSentBackForRevision() {
		return sentBackForRevision;
	}

	/**
	 * Sets the sent back for revision.
	 *
	 * @param sentBackForRevision the sentBackForRevision to set
	 */
	public void setSentBackForRevision(Boolean sentBackForRevision) {
		this.sentBackForRevision = sentBackForRevision;
	}

	/**
	 * Gets the estimated time.
	 *
	 * @return the estimatedTime
	 */
	public String getEstimatedTime() {
		return estimatedTime;
	}

	/**
	 * Sets the estimated time.
	 *
	 * @param estimatedTime the estimatedTime to set
	 */
	public void setEstimatedTime(String estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	/**
	 * Gets the course lookup.
	 *
	 * @return the courseLookup, holds list of {@link CourseLookupDTO}
	 */
	public List<CourseLookupDTO> getCourseLookup() {
		return courseLookup;
	}

	/**
	 * Sets the course lookup.
	 *
	 * @param courseLookup the courseLookup - list of {@link CourseLookupDTO} to set
	 */
	public void setCourseLookup(List<CourseLookupDTO> courseLookup) {
		this.courseLookup = courseLookup;
	}

	/**
	 * Gets the num days before due.
	 *
	 * @return the num days before due
	 */
	public Integer getNumDaysBeforeDue() {
		return numDaysBeforeDue;
	}

	/**
	 * Sets the num days before due.
	 *
	 * @param numDaysBeforeDue the new num days before due
	 */
	public void setNumDaysBeforeDue(Integer numDaysBeforeDue) {
		this.numDaysBeforeDue = numDaysBeforeDue;
	}

	/**
	 * Gets the num days before review due.
	 *
	 * @return the num days before review due
	 */
	public Long getNumDaysBeforeReviewDue() {
		return numDaysBeforeReviewDue;
	}

	/**
	 * Sets the num days before review due.
	 *
	 * @param numDaysBeforeReviewDue the new num days before review due
	 */
	public void setNumDaysBeforeReviewDue(Long numDaysBeforeReviewDue) {
		this.numDaysBeforeReviewDue = numDaysBeforeReviewDue;
	}

	/**
	 * Gets the curriculum id.
	 *
	 * @return the curriculumId
	 */
	public Long getCurriculumId() {
		return curriculumId;
	}

	/**
	 * Sets the curriculum id.
	 *
	 * @param curriculumId the curriculumId to set
	 */
	public void setCurriculumId(Long curriculumId) {
		this.curriculumId = curriculumId;
	}

	/** Gets the inProgress Flag (true or false)
	 * 
	 * @return the inProgress
	 */
	public Boolean getInProgress() {
		return inProgress;
	}

	/** Sets the inProgress flag (true or false)
	 * 
	 * @param inProgress the inProgress to set
	 */
	public void setInProgress(Boolean inProgress) {
		this.inProgress = inProgress;
	}

	/** 
	 * Gets the due date.
	 *
	 * @return the due date
	 */
	public String getDueDate() {
		return dueDate;
	}

	/**
	 * Sets the due date.
	 *
	 * @param dueDate the new due date
	 */
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	
	public boolean isModuleCompleted() {
		return isModuleCompleted;
	}

	public void setModuleCompleted(boolean isModuleCompleted) {
		this.isModuleCompleted = isModuleCompleted;
	}

	
	public String getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(String completionDate) {
		this.completionDate = completionDate;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		if(obj instanceof ModuleCoursesDTO) {
			ModuleCoursesDTO mc = (ModuleCoursesDTO) obj;
			if(this.getModuleId().equals(mc.getModuleId()))
				return true;
		}
		return false;
    }
}
