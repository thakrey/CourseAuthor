package com.lrn.dao;

import java.util.List;

import com.lrn.model.hibernate.AiccCourseState;

/**
 * The Interface IAiccCourseState.
 *
 * @author kishor.pawar
 */
public interface IAiccCourseStateDao extends IGenericDao<AiccCourseState, Long> {

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
