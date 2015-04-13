package com.lrn.model.spring.service.response.course;

import java.io.Serializable;
import java.util.List;

public class CourseEventsDTOList implements Serializable {

	private static final long serialVersionUID = -4051790199519978588L;
	
	private List<CourseEventsDTO> courseEventsDTOList;

	/**
	 * @return the courseEventsDTOList
	 */
	public List<CourseEventsDTO> getCourseEventsDTOList() {
		return courseEventsDTOList;
	}

	/**
	 * @param courseEventsDTOList the courseEventsDTOList to set
	 */
	public void setCourseEventsDTOList(List<CourseEventsDTO> courseEventsDTOList) {
		this.courseEventsDTOList = courseEventsDTOList;
	}
}