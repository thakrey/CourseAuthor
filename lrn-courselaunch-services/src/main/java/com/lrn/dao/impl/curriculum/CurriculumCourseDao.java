package com.lrn.dao.impl.curriculum;

import com.lrn.dao.curriculum.ICurriculumCourseDao;
import com.lrn.dao.impl.GenericDao;
import com.lrn.model.hibernate.curriculum.CurriculumCourse;

/**
 * The Class CurriculumCourseDao.
 *
 * @author kishor.pawar
 */
public class CurriculumCourseDao extends GenericDao<CurriculumCourse, Long> implements
		ICurriculumCourseDao {

	public CurriculumCourseDao(Class<CurriculumCourse> persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	}
}
