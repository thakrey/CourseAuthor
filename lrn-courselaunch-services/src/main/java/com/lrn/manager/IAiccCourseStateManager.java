package com.lrn.manager;

import java.util.Date;
import java.util.List;

import com.lrn.model.hibernate.AiccCourseState;

/**
 * The Interface IAiccCourseStateManager.

 */
public interface IAiccCourseStateManager extends IGenericManager<AiccCourseState, Long> {

	/**
	 * Returns Aicc course State 
	 * @param company
	 * @param userId
	 * @param courseList
	 * @return
	 */
	List<AiccCourseState> getAiccCourseStateByCompanyUserIdCourse(String company, String userId, Long[] courseList);

	/**
	 * Gets the aicc course state by company userid systemid.
	 *
	 * @param company the company
	 * @param userId the user id
	 * @param systemId the system id
	 * @param curriculumId 
	 * @param siteId 
	 * @return a boolean value if the course is inProgress
	 */
	Boolean getAiccCourseStateByCompanyUserIdSystemId(String company,
			String userId, String systemId, Date curOpenDate);
	

	/**
	 * Returns list of AiccCourseState.
	 *
	 * @param String company
	 * @param String userId
	 * @param Long[] courseList
	 * 
	 * @return List<AiccCourseState>
	 */
	List<AiccCourseState> getAiccCourseStateByCompanyUserIdCourseList(
			String company, String userId, Long[] courseList);
	
	/**
	 * Returns Maximum aiccEventId.
	 */
	Long getMaxAiccEventsId();
}