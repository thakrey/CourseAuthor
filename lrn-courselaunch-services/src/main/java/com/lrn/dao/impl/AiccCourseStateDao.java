package com.lrn.dao.impl;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.lrn.dao.IAiccCourseStateDao;
import com.lrn.model.hibernate.AiccCourseState;

/**
 * The Class AiccCourseStateDao.
 *
 * @author kishor.pawar
 */
public class AiccCourseStateDao extends GenericDao<AiccCourseState, Long> implements
		IAiccCourseStateDao {

	public AiccCourseStateDao(Class<AiccCourseState> persistentClass) {
		super(persistentClass);
	}
	
	@Override
	public List<AiccCourseState> getAiccCourseStateByCompanyUserIdCourseList(
			String company, String userId, Long[] courseList) {
		String[] paramNames = { "company", "userId", "courseList" };
		Object[] paramValues = { company, userId, courseList };
		
		return findByNamedQuery("findAiccCourseStateByCompanyUserIdCourseList", paramNames, paramValues);
	}
	
	@Override
	public Long getMaxAiccEventsId() {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("SELECT max(aicc_events_id) as max_id FROM AICC_COURSE_STATE");
		
		Iterator<Map<String, Object>> itr = findBySqlQuery(queryBuilder
				.toString());
				
		while (itr.hasNext()) {
			Map<String, Object> resultMap = itr.next();
			return ((BigDecimal) resultMap.get("max_id")).longValue();
		}
		
		return null;
	}
}