package com.lrn.model.spring.service.response.course;

import java.io.Serializable;
import java.util.Date;

public class CourseEventsDTO implements Serializable {
	
	private static final long serialVersionUID = -9207854031202381957L;

	private Long 	courseEventId;

	private String 	action;
	
	private Long 	value;
	
	private Long 	nodeId;
	
	private Long 	position;
	
	private Date 	creationDate;

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
}