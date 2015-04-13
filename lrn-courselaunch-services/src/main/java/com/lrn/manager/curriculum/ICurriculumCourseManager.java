package com.lrn.manager.curriculum;

import java.util.List;

import com.lrn.manager.IGenericManager;
import com.lrn.model.hibernate.curriculum.CurriculumCourse;

/**
 * The Interface ICurriculumCourseManager
 * 
 *
 */
public interface ICurriculumCourseManager extends IGenericManager<CurriculumCourse, Long> {

	/**
	 * 
	 * @param curriculumIds
	 * @return
	 */
	List<CurriculumCourse> getCurriculumCourseByCurriculumIds(List<Long> curriculumIds);
	
}
