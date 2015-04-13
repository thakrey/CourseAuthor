package com.lrn.model.hibernate;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(
		name 			= "GEN_SEQ",
		sequenceName 	= "SQ_COURSEEVENTS"
)
@NamedQueries( {
	@NamedQuery(name = "findCourseEventsByUserCompanyCourseAction",
			query = "from CourseEvents ce where ce.userId = :userId and ce.company = :company" +
					" and ce.course = :course and ce.action = :action")
})
@Table(name = "COURSEEVENTS")
public class CourseEvents implements Serializable {

	private static final long serialVersionUID = 257344209813977592L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GEN_SEQ")
	@Column(name="COURSEEVENTID")
	private Long courseEventId;
	
	@Column(name="COMPANY")
	private String company;
	
	@Column(name="USER_ID")
	private String userId;

	/** The created. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATION")
	private Date creation;
	
	@Column(name="COURSE")
	private Long course;
	
	@Column(name="ACTION")
	private String action;
	
	@Column(name="VALUE")
	private Long value;
	
	@Column(name="NODEID")
	private Long nodeId;
	
	@Column(name="POSITION")
	private Long position;

	/**
	 * @return the courseEventId
	 */
	public Long getCourseEventId() {
		return courseEventId;
	}

	/**
	 * @param courseEventId the courseEventId to set
	 */
	public void setCourseEventId(Long courseEventId) {
		this.courseEventId = courseEventId;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the creation
	 */
	public Date getCreation() {
		return creation;
	}

	/**
	 * @param creation the creation to set
	 */
	public void setCreation(Date creation) {
		this.creation = creation;
	}

	/**
	 * @return the course
	 */
	public Long getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(Long course) {
		this.course = course;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * @return the value
	 */
	public Long getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Long value) {
		this.value = value;
	}

	/**
	 * @return the nodeId
	 */
	public Long getNodeId() {
		return nodeId;
	}

	/**
	 * @param nodeId the nodeId to set
	 */
	public void setNodeId(Long nodeId) {
		this.nodeId = nodeId;
	}

	/**
	 * @return the position
	 */
	public Long getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(Long position) {
		this.position = position;
	}
}
