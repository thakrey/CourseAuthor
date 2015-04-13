package com.lrn.model.spring.curriculum;

import java.io.Serializable;
import java.util.Date;

public class GetUserAssignedCoursesQueryDTO implements Serializable {

	private static final long serialVersionUID = 6969514181086325991L;

	private Long moduleId;
	
	private Long curriculumId;
	
	private String curriculumnIsDefault;
	
	private Date curriculumnCreateDate;
	
	private Date curriculumnOpenDate;
	
	private Date curriculumnDueDate;
	
	private Integer curriculumnDaysBeforeDue;
	
	private Date curriculumnCloseDate;
	
	private Date curriculumnEnrollCloseDate;
	
	private String courseSystemId;
	
	private String courseCatalogId;
	
	private String courseTitle;
	
	private String courseLanguage;

	/**
	 * @return the moduleId
	 */
	public Long getModuleId() {
		return moduleId;
	}

	/**
	 * @param moduleId the moduleId to set
	 */
	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
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

	/**
	 * @return the curriculumnIsDefault
	 */
	public String getCurriculumnIsDefault() {
		return curriculumnIsDefault;
	}

	/**
	 * @param curriculumnIsDefault the curriculumnIsDefault to set
	 */
	public void setCurriculumnIsDefault(String curriculumnIsDefault) {
		this.curriculumnIsDefault = curriculumnIsDefault;
	}

	/**
	 * @return the curriculumnCreateDate
	 */
	public Date getCurriculumnCreateDate() {
		return curriculumnCreateDate;
	}

	/**
	 * @param curriculumnCreateDate the curriculumnCreateDate to set
	 */
	public void setCurriculumnCreateDate(Date curriculumnCreateDate) {
		this.curriculumnCreateDate = curriculumnCreateDate;
	}

	/**
	 * @return the curriculumnOpenDate
	 */
	public Date getCurriculumnOpenDate() {
		return curriculumnOpenDate;
	}

	/**
	 * @param curriculumnOpenDate the curriculumnOpenDate to set
	 */
	public void setCurriculumnOpenDate(Date curriculumnOpenDate) {
		this.curriculumnOpenDate = curriculumnOpenDate;
	}

	/**
	 * @return the curriculumnDueDate
	 */
	public Date getCurriculumnDueDate() {
		return curriculumnDueDate;
	}

	/**
	 * @param curriculumnDueDate the curriculumnDueDate to set
	 */
	public void setCurriculumnDueDate(Date curriculumnDueDate) {
		this.curriculumnDueDate = curriculumnDueDate;
	}

	/**
	 * @return the curriculumnDaysBeforeDue
	 */
	public Integer getCurriculumnDaysBeforeDue() {
		return curriculumnDaysBeforeDue;
	}

	/**
	 * @param curriculumnDaysBeforeDue the curriculumnDaysBeforeDue to set
	 */
	public void setCurriculumnDaysBeforeDue(Integer curriculumnDaysBeforeDue) {
		this.curriculumnDaysBeforeDue = curriculumnDaysBeforeDue;
	}

	/**
	 * @return the curriculumnCloseDate
	 */
	public Date getCurriculumnCloseDate() {
		return curriculumnCloseDate;
	}

	/**
	 * @param curriculumnCloseDate the curriculumnCloseDate to set
	 */
	public void setCurriculumnCloseDate(Date curriculumnCloseDate) {
		this.curriculumnCloseDate = curriculumnCloseDate;
	}

	/**
	 * @return the curriculumnEnrollCloseDate
	 */
	public Date getCurriculumnEnrollCloseDate() {
		return curriculumnEnrollCloseDate;
	}

	/**
	 * @param curriculumnEnrollCloseDate the curriculumnEnrollCloseDate to set
	 */
	public void setCurriculumnEnrollCloseDate(Date curriculumnEnrollCloseDate) {
		this.curriculumnEnrollCloseDate = curriculumnEnrollCloseDate;
	}

	/**
	 * @return the courseSystemId
	 */
	public String getCourseSystemId() {
		return courseSystemId;
	}

	/**
	 * @param courseSystemId the courseSystemId to set
	 */
	public void setCourseSystemId(String courseSystemId) {
		this.courseSystemId = courseSystemId;
	}

	/**
	 * @return the courseCatalogId
	 */
	public String getCourseCatalogId() {
		return courseCatalogId;
	}

	/**
	 * @param courseCatalogId the courseCatalogId to set
	 */
	public void setCourseCatalogId(String courseCatalogId) {
		this.courseCatalogId = courseCatalogId;
	}

	/**
	 * @return the courseTitle
	 */
	public String getCourseTitle() {
		return courseTitle;
	}

	/**
	 * @param courseTitle the courseTitle to set
	 */
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	/**
	 * @return the courseLanguage
	 */
	public String getCourseLanguage() {
		return courseLanguage;
	}

	/**
	 * @param courseLanguage the courseLanguage to set
	 */
	public void setCourseLanguage(String courseLanguage) {
		this.courseLanguage = courseLanguage;
	}
}