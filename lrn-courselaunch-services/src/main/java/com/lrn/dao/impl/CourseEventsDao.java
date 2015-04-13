package com.lrn.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.lrn.dao.ICourseEventsDao;
import com.lrn.model.hibernate.CourseEvents;
import com.lrn.model.spring.service.response.course.CourseEventsActionDTO;
import com.lrn.model.spring.service.response.course.UserCourseEventsDTO;

public class CourseEventsDao extends GenericDao<CourseEvents, Long> implements ICourseEventsDao {

	public CourseEventsDao(Class<CourseEvents> persistentClass) {
		super(persistentClass);
	}

	@Override
	public UserCourseEventsDTO getUserCourseEvents(String userId, String company, Long course) {
		/*
		 This code is copied from catalyst project written by SUJA RAVI.
		 This is written using SQL which is not ideal as this can be written without using SQL 
		 and date formating should be done at business layer.
		 */
		UserCourseEventsDTO dto = null;

		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("SELECT courseEventId, action, value, TO_CHAR(creation, 'YYYYMMDDHH24MISS') as creationDate, position, nodeID  from COURSEEVENTS where ");
		queryBuilder.append(" user_id = '").append(userId).append("'");
		queryBuilder.append(" and company = '").append(company).append("'");
		queryBuilder.append(" and course = ").append(course);
		queryBuilder.append(" order by Position");
		Iterator<Map<String, Object>> itr = findBySqlQuery(queryBuilder.toString());
		
		if(dto == null) {
			dto = new UserCourseEventsDTO();
			
			dto.setUserId(userId);
			dto.setCompany(company);
			dto.setCourse(course);
			
			List<CourseEventsActionDTO> courseEventsActionDTO = new ArrayList<CourseEventsActionDTO> ();
			
			while (itr.hasNext()) {
				Map<String, Object> resultMap = itr.next();
				CourseEventsActionDTO ceaDTO = new CourseEventsActionDTO();
				ceaDTO.setAction((String) resultMap.get("action"));
				ceaDTO.setValue( ((BigDecimal) resultMap.get("value")).longValue() );
				ceaDTO.setCourseEventId(((BigDecimal) resultMap.get("courseEventId")).longValue());
				ceaDTO.setCreationDate((String) resultMap.get("creationDate"));
				Object ob = resultMap.get("position");
				if(ob != null)
					ceaDTO.setPosition(((BigDecimal) resultMap.get("position")).longValue());
				ob = resultMap.get("nodeID");
				if(ob != null)
					ceaDTO.setNodeId(((BigDecimal) resultMap.get("nodeID")).longValue());
				
				courseEventsActionDTO.add(ceaDTO);
			}		
			dto.setCourseEventsActionDTO(courseEventsActionDTO);
		}
		return dto;
	}
}	
