/**
 * 
 */
package com.lrn.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**  
* CurriculumDTO - data transfer object class for Curriculum. 
* It stores the data for the curriculum. 
* 
*/
public class CurriculumDTO implements Serializable {

	private BigDecimal id;

	private String name;

	private BigDecimal siteId;

	private String isDefault;

	private Date created;

	private Date openDate;

	private Date enrolCloseDate;

	private Date closeDate;

	private Date dueDate;

	private Date exemptionDate;

	private BigDecimal driveState;

	private String description;

	private String administratorEmails;

	private BigDecimal isRuleBasedScheduled;

	private Date modified;

	private Date reviewerDueDate;

	private BigDecimal numDaysBeforeDue;

	private BigDecimal numDaysBeforeReviewDue;

	/** Gets the id
	 * 
	 * @return the id
	 */
	public BigDecimal getId() {
		return id;
	}

	/** Sets the id
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(BigDecimal id) {
		this.id = id;
	}

	/** Gets the name
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/** Sets the name
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** Gets the description
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/** Sets the description
	 * 
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/** Gets the dueDate
	 * 
	 * @return the dueDate
	 */
	public Date getDueDate() {
		return dueDate;
	}

	/** Sets the dueDate
	 * 
	 * @param dueDate
	 *            the dueDate to set
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	/** Gets the siteId
	 * 
	 * @return the siteId
	 */
	public BigDecimal getSiteId() {
		return siteId;
	}

	/** Sets the siteId
	 * 
	 * @param siteId the siteId to set
	 */
	public void setSiteId(BigDecimal siteId) {
		this.siteId = siteId;
	}

	/** Gets isDefault
	 * 
	 * @return the isDefault
	 */
	public String getIsDefault() {
		return isDefault;
	}

	/** Sets isDefault 
	 * 
	 * @param isDefault the isDefault to set
	 */
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
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

	/** Gets the openDate
	 * 
	 * @return the openDate
	 */
	public Date getOpenDate() {
		return openDate;
	}

	/** Sets the openDate
	 * 
	 * @param openDate the openDate to set
	 */
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	/** Gets the enrolCloseDate
	 * 
	 * @return the enrolCloseDate
	 */
	public Date getEnrolCloseDate() {
		return enrolCloseDate;
	}

	/** Sets the enrolCloseDate
	 * 
	 * @param enrolCloseDate the enrolCloseDate to set
	 */
	public void setEnrolCloseDate(Date enrolCloseDate) {
		this.enrolCloseDate = enrolCloseDate;
	}

	/** Gets the closeDate
	 * 
	 * @return the closeDate
	 */
	public Date getCloseDate() {
		return closeDate;
	}

	/** Sets the closeDate
	 * 
	 * @param closeDate the closeDate to set
	 */
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	/** Gets the exemptionDate
	 * 
	 * @return the exemptionDate
	 */
	public Date getExemptionDate() {
		return exemptionDate;
	}

	/** Sets the exemptionDate
	 * 
	 * @param exemptionDate the exemptionDate to set
	 */
	public void setExemptionDate(Date exemptionDate) {
		this.exemptionDate = exemptionDate;
	}

	/** Gets the driveState
	 * 
	 * @return the driveState
	 */
	public BigDecimal getDriveState() {
		return driveState;
	}

	/** Sets the driveState
	 * 
	 * @param driveState the driveState to set
	 */
	public void setDriveState(BigDecimal driveState) {
		this.driveState = driveState;
	}

	/** Gets the administratorEmails
	 * 
	 * @return the administratorEmails
	 */
	public String getAdministratorEmails() {
		return administratorEmails;
	}

	/** Sets the administratorEmails
	 * 
	 * @param administratorEmails the administratorEmails to set
	 */
	public void setAdministratorEmails(String administratorEmails) {
		this.administratorEmails = administratorEmails;
	}

	/** Gets the isRuleBasedScheduled
	 * 
	 * @return the isRuleBasedScheduled
	 */
	public BigDecimal getIsRuleBasedScheduled() {
		return isRuleBasedScheduled;
	}

	/** Sets the isRuleBasedScheduled
	 * 
	 * @param isRuleBasedScheduled the isRuleBasedScheduled to set
	 */
	public void setIsRuleBasedScheduled(BigDecimal isRuleBasedScheduled) {
		this.isRuleBasedScheduled = isRuleBasedScheduled;
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

	/** Gets the reviewerDueDate
	 * 
	 * @return the reviewerDueDate
	 */
	public Date getReviewerDueDate() {
		return reviewerDueDate;
	}

	/** Sets the reviewerDueDate
	 * 
	 * @param reviewerDueDate the reviewerDueDate to set
	 */
	public void setReviewerDueDate(Date reviewerDueDate) {
		this.reviewerDueDate = reviewerDueDate;
	}

	/** Gets the numDaysBeforeDue
	 * 
	 * @return the numDaysBeforeDue
	 */
	public BigDecimal getNumDaysBeforeDue() {
		return numDaysBeforeDue;
	}

	/** Sets the numDaysBeforeDue
	 * 
	 * @param numDaysBeforeDue the numDaysBeforeDue to set
	 */
	public void setNumDaysBeforeDue(BigDecimal numDaysBeforeDue) {
		this.numDaysBeforeDue = numDaysBeforeDue;
	}

	/** Gets the numDaysBeforeReviewDue
	 * 
	 * @return the numDaysBeforeReviewDue
	 */
	public BigDecimal getNumDaysBeforeReviewDue() {
		return numDaysBeforeReviewDue;
	}

	/** Sets the numDaysBeforeReviewDue
	 * 
	 * @param numDaysBeforeReviewDue the numDaysBeforeReviewDue to set
	 */
	public void setNumDaysBeforeReviewDue(BigDecimal numDaysBeforeReviewDue) {
		this.numDaysBeforeReviewDue = numDaysBeforeReviewDue;
	}

}
