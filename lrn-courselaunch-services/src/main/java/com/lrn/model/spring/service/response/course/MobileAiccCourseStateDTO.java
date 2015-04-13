package com.lrn.model.spring.service.response.course;

import java.io.Serializable;
import java.util.Date;

public class MobileAiccCourseStateDTO implements Serializable {

	private static final long serialVersionUID = 7343333358996475082L;

	private Long 	aiccEventsId;
	
	private Date 	creationDate;
	
	private String 	lessonLocation;
	
	private String 	coreLesson;
	
	private Date 	lastModifiedDate;

	/**
	 * @return the aiccEventsId
	 */
	public Long getAiccEventsId() {
		return aiccEventsId;
	}

	/**
	 * @param aiccEventsId the aiccEventsId to set
	 */
	public void setAiccEventsId(Long aiccEventsId) {
		this.aiccEventsId = aiccEventsId;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the lessonLocation
	 */
	public String getLessonLocation() {
		return lessonLocation;
	}

	/**
	 * @param lessonLocation the lessonLocation to set
	 */
	public void setLessonLocation(String lessonLocation) {
		this.lessonLocation = lessonLocation;
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
	 * @return the lastModifiedDate
	 */
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	/**
	 * @param lastModifiedDate the lastModifiedDate to set
	 */
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
}