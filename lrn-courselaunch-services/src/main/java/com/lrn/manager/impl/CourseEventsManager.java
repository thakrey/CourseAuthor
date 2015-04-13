package com.lrn.manager.impl;

import com.lrn.dao.ICourseEventsDao;
import com.lrn.dao.IGenericDao;
import com.lrn.manager.ICourseEventsManager;
import com.lrn.model.hibernate.CourseEvents;
import com.lrn.model.spring.service.response.course.UserCourseEventsDTO;

public class CourseEventsManager extends GenericManager<CourseEvents, Long> implements ICourseEventsManager {

	private ICourseEventsDao courseEventsDao;
	
	public CourseEventsManager(IGenericDao<CourseEvents, Long> iGenericDao) {
		super(iGenericDao);
	}
	
	/**
	 * @param courseEventsDao the courseEventsDao to set
	 */
	public void setCourseEventsDao(ICourseEventsDao courseEventsDao) {
		this.courseEventsDao = courseEventsDao;
	}

	@Override
	public UserCourseEventsDTO getUserCourseEvents(String userId, String company, Long course) {
		return courseEventsDao.getUserCourseEvents(userId, company, course);
	}
}