package com.lrn.model.spring.service.response.module;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.lrn.model.hibernate.curriculum.Curriculum;

/**
 * 
 * @author vmulla
 *
 */
public class CurriculumModulesDTO implements Serializable {

	private static final long serialVersionUID = -4891724806903570002L;

	private Long id;

	private String name;

	private Long siteId;

	private String isDefault;

	private Date created;

	private Date openDate;

	private Date enrolCloseDate;

	private Date closeDate;

	private Date dueDate;

	private Date exemptionDate;

	private Long driveState;

	private String description;

	private String administratorEmails;

	private Long isRuleBasedScheduled;

	private Date modified;

	private Date reviewerDueDate;

	private Integer numDaysBeforeDue;

	private Long numDaysBeforeReviewDue;
	
	private Boolean hasModuleChain = false;
	
	private Curriculum curriculum;

	private List<ModuleCoursesDTO> modules;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the dueDate
	 */
	public Date getDueDate() {
		return dueDate;
	}

	/**
	 * @param dueDate
	 *            the dueDate to set
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
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
	 * @return the isDefault
	 */
	public String getIsDefault() {
		return isDefault;
	}

	/**
	 * @param isDefault the isDefault to set
	 */
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
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

	/**
	 * @return the openDate
	 */
	public Date getOpenDate() {
		return openDate;
	}

	/**
	 * @param openDate the openDate to set
	 */
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	/**
	 * @return the enrolCloseDate
	 */
	public Date getEnrolCloseDate() {
		return enrolCloseDate;
	}

	/**
	 * @param enrolCloseDate the enrolCloseDate to set
	 */
	public void setEnrolCloseDate(Date enrolCloseDate) {
		this.enrolCloseDate = enrolCloseDate;
	}

	/**
	 * @return the closeDate
	 */
	public Date getCloseDate() {
		return closeDate;
	}

	/**
	 * @param closeDate the closeDate to set
	 */
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	/**
	 * @return the exemptionDate
	 */
	public Date getExemptionDate() {
		return exemptionDate;
	}

	/**
	 * @param exemptionDate the exemptionDate to set
	 */
	public void setExemptionDate(Date exemptionDate) {
		this.exemptionDate = exemptionDate;
	}

	/**
	 * @return the driveState
	 */
	public Long getDriveState() {
		return driveState;
	}

	/**
	 * @param driveState the driveState to set
	 */
	public void setDriveState(Long driveState) {
		this.driveState = driveState;
	}

	/**
	 * @return the administratorEmails
	 */
	public String getAdministratorEmails() {
		return administratorEmails;
	}

	/**
	 * @param administratorEmails the administratorEmails to set
	 */
	public void setAdministratorEmails(String administratorEmails) {
		this.administratorEmails = administratorEmails;
	}

	/**
	 * @return the isRuleBasedScheduled
	 */
	public Long getIsRuleBasedScheduled() {
		return isRuleBasedScheduled;
	}

	/**
	 * @param isRuleBasedScheduled the isRuleBasedScheduled to set
	 */
	public void setIsRuleBasedScheduled(Long isRuleBasedScheduled) {
		this.isRuleBasedScheduled = isRuleBasedScheduled;
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
	 * @return the reviewerDueDate
	 */
	public Date getReviewerDueDate() {
		return reviewerDueDate;
	}

	/**
	 * @param reviewerDueDate the reviewerDueDate to set
	 */
	public void setReviewerDueDate(Date reviewerDueDate) {
		this.reviewerDueDate = reviewerDueDate;
	}

	/**
	 * @return the numDaysBeforeDue
	 */
	public Integer getNumDaysBeforeDue() {
		return numDaysBeforeDue;
	}

	/**
	 * @param numDaysBeforeDue the numDaysBeforeDue to set
	 */
	public void setNumDaysBeforeDue(Integer numDaysBeforeDue) {
		this.numDaysBeforeDue = numDaysBeforeDue;
	}

	/**
	 * @return the numDaysBeforeReviewDue
	 */
	public Long getNumDaysBeforeReviewDue() {
		return numDaysBeforeReviewDue;
	}

	/**
	 * @param numDaysBeforeReviewDue the numDaysBeforeReviewDue to set
	 */
	public void setNumDaysBeforeReviewDue(Long numDaysBeforeReviewDue) {
		this.numDaysBeforeReviewDue = numDaysBeforeReviewDue;
	}

	/**
	 * @return the hasModuleChain
	 */
	public Boolean getHasModuleChain() {
		return hasModuleChain;
	}

	/**
	 * @param hasModuleChain the hasModuleChain to set
	 */
	public void setHasModuleChain(Boolean hasModuleChain) {
		this.hasModuleChain = hasModuleChain;
	}

	/**
	 * @return the modules
	 */
	public List<ModuleCoursesDTO> getModules() {
		return modules;
	}

	/**
	 * @param modules the modules to set
	 */
	public void setModules(List<ModuleCoursesDTO> modules) {
		this.modules = modules;
	}
	
	
	public Curriculum getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}

}
