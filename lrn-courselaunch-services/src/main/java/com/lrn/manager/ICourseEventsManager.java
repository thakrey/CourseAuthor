package com.lrn.manager;

import com.lrn.model.hibernate.CourseEvents;
import com.lrn.model.spring.service.response.course.UserCourseEventsDTO;

public interface ICourseEventsManager extends IGenericManager<CourseEvents, Long> {

	/**
	 * Gets UserCourseEventsDTO. 
	 * 
	 * @param String userId
	 * @param String company
	 * @param Long course
	 * 
	 * @return UserCourseEventsDTO
	 */
	UserCourseEventsDTO getUserCourseEvents(String userId, String company, Long course);
}