package com.lrn.model.spring.service.response.course;

import java.io.Serializable;
import java.util.Date;

public class AiccCourseStateDTO implements Serializable {

	private static final long serialVersionUID = 8333544267000076466L;

	private Long 	aiccEventsId;
	
	private String 	lessonLocation;
	
	private String 	coreLesson;

	private Date 	creationDate;
	
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