package com.lrn.model.spring.service.response.module;

import com.lrn.model.spring.service.response.LRNResponse;
import com.lrn.model.spring.service.response.module.CourseLookupDTO;

/**
 * The ModulePreviewDTO class
 * @author vmulla
 *
 */
public class ModulePreviewDTO {

	/** The course lookup dto. */
	private CourseLookupDTO courseLookupDTO;
	
	/** The due date. */
	private String dueDate;
	
	/** The estimated time. */
	private String estimatedTime;
	
	/** The num days before due. */
	private Integer numDaysBeforeDue;

	/** The num days before review due. */
	private Long numDaysBeforeReviewDue;
	
	/** The module id. */
	private Long moduleId;
	
	/** The src cert req id. */
	private Long srcCertReqId;
	
	/** The module chain id. */
	private Long moduleChainId;
	
	/** The sent back for revision. */
	private Boolean sentBackForRevision = false;
	
	/** The sequence. */
	private Long sequence;
	
	/** The in progress. */
	private Boolean inProgress = false;
	
	private String coreLesson;

	private LRNResponse lrnResponse;

	/**
	 * Gets the course lookup dto.
	 *
	 * @return the courseLookupDTO
	 */
	public CourseLookupDTO getCourseLookupDTO() {
		return courseLookupDTO;
	}

	/**
	 * Sets the course lookup dto.
	 *
	 * @param courseLookupDTO the courseLookupDTO to set
	 */
	public void setCourseLookupDTO(CourseLookupDTO courseLookupDTO) {
		this.courseLookupDTO = courseLookupDTO;
	}

	/**
	 * Gets the due date.
	 *
	 * @return the dueDate
	 */
	public String getDueDate() {
		return dueDate;
	}

	/**
	 * Sets the due date.
	 *
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
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
	 * Gets the num days before due.
	 *
	 * @return the numDaysBeforeDue
	 */
	public Integer getNumDaysBeforeDue() {
		return numDaysBeforeDue;
	}

	/**
	 * Sets the num days before due.
	 *
	 * @param numDaysBeforeDue the numDaysBeforeDue to set
	 */
	public void setNumDaysBeforeDue(Integer numDaysBeforeDue) {
		this.numDaysBeforeDue = numDaysBeforeDue;
	}

	/**
	 * Gets the num days before review due.
	 *
	 * @return the numDaysBeforeReviewDue
	 */
	public Long getNumDaysBeforeReviewDue() {
		return numDaysBeforeReviewDue;
	}

	/**
	 * Sets the num days before review due.
	 *
	 * @param numDaysBeforeReviewDue the numDaysBeforeReviewDue to set
	 */
	public void setNumDaysBeforeReviewDue(Long numDaysBeforeReviewDue) {
		this.numDaysBeforeReviewDue = numDaysBeforeReviewDue;
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
	 * Gets the in progress.
	 *
	 * @return the inProgress
	 */
	public Boolean getInProgress() {
		return inProgress;
	}

	/**
	 * Sets the in progress.
	 *
	 * @param inProgress the inProgress to set
	 */
	public void setInProgress(Boolean inProgress) {
		this.inProgress = inProgress;
	}

	/**
	 * @return the coreLesson
	 */
	public String getCoreLesson() {
		return coreLesson;
	}

	/**
	 * @param coreLesson the coreLesson to set
	 */
	public void setCoreLesson(String coreLesson) {
		this.coreLesson = coreLesson;
	}

	/**
	 * @param lrnResponse
	 */
	public void setLrnResponse(LRNResponse lrnResponse) {
		this.lrnResponse = lrnResponse;
	}

	/**
	 * @return the lrnResponse
	 */
	public LRNResponse getLrnResponse() {
		return lrnResponse;
	}
}
