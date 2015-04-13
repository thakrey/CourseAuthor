package com.lrn.dao.impl.curriculum;

import com.lrn.dao.curriculum.ICurriculumModuleChainDao;
import com.lrn.dao.impl.GenericDao;
import com.lrn.model.hibernate.curriculum.CurriculumModuleChain;

/**
 * The Class CurriculumModuleChainDao.
 *
 * @author kishor.pawar
 */
public class CurriculumModuleChainDao extends GenericDao<CurriculumModuleChain, Long> implements
		ICurriculumModuleChainDao {

	public CurriculumModuleChainDao(Class<CurriculumModuleChain> persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	}

}
