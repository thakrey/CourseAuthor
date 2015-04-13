package com.lrn.manager.impl.curriculum;

import java.util.List;

import com.lrn.dao.IGenericDao;
import com.lrn.dao.curriculum.ICurriculumModuleChainDao;
import com.lrn.manager.curriculum.ICurriculumModuleChainManager;
import com.lrn.manager.impl.GenericManager;
import com.lrn.model.hibernate.curriculum.CurriculumModuleChain;

/**
 * The Class CurriculumModuleChainManager
 * 
 * @author kishor.pawar
 */
public class CurriculumModuleChainManager extends GenericManager<CurriculumModuleChain, Long>
		implements ICurriculumModuleChainManager {
	
	private ICurriculumModuleChainDao curriculumModuleChainDao;
	
	public CurriculumModuleChainManager(
			IGenericDao<CurriculumModuleChain, Long> iGenericDao) {
		super(iGenericDao);
	}

	/**
	 * @param curriculumModuleChainDao the curriculumModuleChainDao to set
	 */
	public void setCurriculumModuleChainDao(
			ICurriculumModuleChainDao curriculumModuleChainDao) {
		this.curriculumModuleChainDao = curriculumModuleChainDao;
	}

	@Override
	public List<CurriculumModuleChain> getCurriculumModuleChainByCurriculumIds(
			Long siteId, List<Long> curriculumIds) {
		String[] paramNames = { "siteId", "curriculumIds" };
		Object[] paramValues = { siteId, curriculumIds };
		return curriculumModuleChainDao.findByNamedQuery("findCurriculumModuleChainByCurriculumIds", paramNames, paramValues);
	}
}