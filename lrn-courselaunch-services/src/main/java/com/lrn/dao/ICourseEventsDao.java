package com.lrn.dao;

import com.lrn.model.hibernate.CourseEvents;
import com.lrn.model.spring.service.response.course.UserCourseEventsDTO;

public interface ICourseEventsDao extends IGenericDao<CourseEvents, Long> {

	/**
	 * Gets UserCourseEventsDTO. This code is copied from catalyst project written by SUJA RAVI.
	 * This is written using SQL which is not ideal as this can be written without using SQL 
	 * and date formating should be done at business layer.
	 * 
	 * @param String userId
	 * @param String company
	 * @param Long course
	 * 
	 * @return UserCourseEventsDTO
	 */
	UserCourseEventsDTO getUserCourseEvents(String userId, String company, Long course);
}
