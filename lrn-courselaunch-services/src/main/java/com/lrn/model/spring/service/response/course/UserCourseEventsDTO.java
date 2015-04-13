package com.lrn.model.spring.service.response.course;

import java.io.Serializable;
import java.util.List;

public class UserCourseEventsDTO implements Serializable {

	private static final long serialVersionUID = 8533855593484961545L;

	private String 	userId;
	
	private String 	company;
	
	private Long 	course;
	
	private List<CourseEventsActionDTO> courseEventsActionDTO;

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
	 * @return the courseEventsActionDTO
	 */
	public List<CourseEventsActionDTO> getCourseEventsActionDTO() {
		return courseEventsActionDTO;
	}

	/**
	 * @param courseEventsActionDTO the courseEventsActionDTO to set
	 */
	public void setCourseEventsActionDTO(
			List<CourseEventsActionDTO> courseEventsActionDTO) {
		this.courseEventsActionDTO = courseEventsActionDTO;
	}
}