package com.lrn.manager.impl.curriculum;

import java.util.List;

import com.lrn.dao.IGenericDao;
import com.lrn.dao.curriculum.ICurriculumCourseDao;
import com.lrn.manager.curriculum.ICurriculumCourseManager;
import com.lrn.manager.impl.GenericManager;
import com.lrn.model.hibernate.curriculum.CurriculumCourse;

/**
 * The Class CurriculumCourseManager.
 *
 * @author kishor.pawar
 */
public class CurriculumCourseManager extends GenericManager<CurriculumCourse, Long> implements
		ICurriculumCourseManager {
	
	private ICurriculumCourseDao curriculumCourseDao;
	
	public CurriculumCourseManager(
			IGenericDao<CurriculumCourse, Long> iGenericDao) {
		super(iGenericDao);
	}

	/**
	 * @param curriculumCourseDao the curriculumCourseDao to set
	 */
	public void setCurriculumCourseDao(ICurriculumCourseDao curriculumCourseDao) {
		this.curriculumCourseDao = curriculumCourseDao;
	}

	@Override
	public List<CurriculumCourse> getCurriculumCourseByCurriculumIds(
			List<Long> curriculumIds) {
		String[] paramNames = { "curriculumIds" };
		Object[] paramValues = { curriculumIds };
		return curriculumCourseDao.findByNamedQuery("findCurriculumCourseByCurriculumIds", paramNames, paramValues);
	}
}