package com.lrn.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.lrn.dao.IAiccCourseStateDao;
import com.lrn.dao.IGenericDao;
import com.lrn.manager.IAiccCourseStateManager;
import com.lrn.model.hibernate.AiccCourseState;

/**
 * The Class AiccCourseStateManager.
 */
public class AiccCourseStateManager extends GenericManager<AiccCourseState, Long> implements
		IAiccCourseStateManager {

	private IAiccCourseStateDao aiccCourseStateDao;
	
	public AiccCourseStateManager(IGenericDao<AiccCourseState, Long> iGenericDao) {
		super(iGenericDao);
	}

	/**
	 * @param aiccCourseStateDao the aiccCourseStateDao to set
	 */
	public void setAiccCourseStateDao(IAiccCourseStateDao aiccCourseStateDao) {
		this.aiccCourseStateDao = aiccCourseStateDao;
	}

	@Override
	public List<AiccCourseState> getAiccCourseStateByCompanyUserIdCourse(
			String company, String userId, Long[] courseList) {
		String[] paramNames = { "company", "userId", "courseList" };
		Object[] paramValues = { company, userId, courseList };
		
		return iGenericDao.findByNamedQuery("findAiccCourseStateByCompanyUserIdCourse", paramNames, paramValues);
	}
	
	@Override
	public Boolean getAiccCourseStateByCompanyUserIdSystemId(
			String company, String userId, String systemId, Date curOpenDate) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("SELECT core_lesson, last_modified ");
		queryBuilder.append("FROM aicc_course_state acs, course_lookup cl where acs.company = '").append(company).append("'");
		queryBuilder.append(" AND acs.user_id = '").append(userId).append("'");
		queryBuilder.append(" AND cl.system_id = '").append(systemId).append("'");
		queryBuilder.append(" AND acs.course = cl.course ");
		
		Iterator<Map<String, Object>> itr = findBySqlQuery(queryBuilder
				.toString());
		List<Map<String, Object>> acsList = new ArrayList<Map<String,Object>>();
				
		while (itr.hasNext()) {
			Map<String, Object> resultMap = itr.next();
			acsList.add(resultMap);
		}
		
		// if this person has never started a course and the query returns null
		// then just return or else it'll fail on the acsList.get(0).get (null pointer)
		if (acsList.size() == 0) {
			return false;
		}
		
		Date lastModified = (Date)acsList.get(0).get("last_modified");
		if (lastModified != null && (curOpenDate == null || curOpenDate.before(lastModified))) {
			String coreLesson = (String)acsList.get(0).get("core_lesson");
			return (coreLesson == null || coreLesson.equals("null")) ? false : true; 
				 
		} else {
			return false;
		}
		
	}
	
	@Override
	public List<AiccCourseState> getAiccCourseStateByCompanyUserIdCourseList(
			String company, String userId, Long[] courseList) {
		return aiccCourseStateDao.getAiccCourseStateByCompanyUserIdCourseList(company, userId, courseList);
	}
	
	@Override
	public Long getMaxAiccEventsId() {
		return aiccCourseStateDao.getMaxAiccEventsId();
	}
}