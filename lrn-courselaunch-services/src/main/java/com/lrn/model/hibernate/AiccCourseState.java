package com.lrn.model.hibernate;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The Class AiccCourseState.
 *
 *
 */
@NamedQueries( {
	@NamedQuery(name = "findAiccCourseStateByCompanyUserIdCourseList",
			query = "from AiccCourseState acs where acs.company = :company and acs.userId = :userId and acs.course IN ( :courseList )"),
	@NamedQuery(name = "findAiccCourseStateByCompanyUserIdCourse",
			query = "from AiccCourseState acs where acs.company = :company and acs.userId = :userId and acs.course IN ( :courseList )")
})
@Entity
@Table(name = "AICC_COURSE_STATE")
public class AiccCourseState implements Serializable {

	private static final long serialVersionUID = -8063053831990097150L;

	/** The aicc events id. */
	@Id
	@Column(name="AICC_EVENTS_ID")
	private Long aiccEventsId;
	
	/** The company. */
	@Column(name="COMPANY")
	private String company;
	
	/** The user id. */
	@Column(name="USER_ID")
	private String userId;
	
	/** The creation. */
	@Column(name="CREATION")
	private Date creation;
	
	/** The course. */
	@Column(name="COURSE")
	private Long course;
	
	/** The lesson location. */
	@Column(name="LESSON_LOCATION")
	private String lessonLocation;
	
	/** The core lesson. */
	@Column(name="CORE_LESSON")
	private String coreLesson;
	
	/** The last modified. */
	@Column(name="LAST_MODIFIED")
	private Date lastModified;

	/**
	 * Gets the aicc events id.
	 *
	 * @return the aiccEventsId
	 */
	public Long getAiccEventsId() {
		return aiccEventsId;
	}

	/**
	 * Sets the aicc events id.
	 *
	 * @param aiccEventsId the aiccEventsId to set
	 */
	public void setAiccEventsId(Long aiccEventsId) {
		this.aiccEventsId = aiccEventsId;
	}

	/**
	 * Gets the company.
	 *
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * Sets the company.
	 *
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Gets the creation.
	 *
	 * @return the creation
	 */
	public Date getCreation() {
		return creation;
	}

	/**
	 * Sets the creation.
	 *
	 * @param creation the creation to set
	 */
	public void setCreation(Date creation) {
		this.creation = creation;
	}

	/**
	 * Gets the course.
	 *
	 * @return the course
	 */
	public Long getCourse() {
		return course;
	}

	/**
	 * Sets the course.
	 *
	 * @param course the course to set
	 */
	public void setCourse(Long course) {
		this.course = course;
	}

	/**
	 * Gets the lesson location.
	 *
	 * @return the lessonLocation
	 */
	public String getLessonLocation() {
		return lessonLocation;
	}

	/**
	 * Sets the lesson location.
	 *
	 * @param lessonLocation the lessonLocation to set
	 */
	public void setLessonLocation(String lessonLocation) {
		this.lessonLocation = lessonLocation;
	}

	/**
	 * Gets the core lesson.
	 *
	 * @return the coreLesson
	 */
	public String getCoreLesson() {
		return coreLesson;
	}

	/**
	 * Sets the core lesson.
	 *
	 * @param coreLesson the coreLesson to set
	 */
	public void setCoreLesson(String coreLesson) {
		this.coreLesson = coreLesson;
	}

	/**
	 * Gets the last modified.
	 *
	 * @return the lastModified
	 */
	public Date getLastModified() {
		return lastModified;
	}

	/**
	 * Sets the last modified.
	 *
	 * @param lastModified the lastModified to set
	 */
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
}