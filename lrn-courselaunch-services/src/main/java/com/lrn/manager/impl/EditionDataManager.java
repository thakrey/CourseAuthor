package com.lrn.manager.impl;

import java.util.List;

import com.lrn.dao.IEditionDataDao;
import com.lrn.dao.IGenericDao;
import com.lrn.manager.IEditionDataManager;
import com.lrn.model.hibernate.EditionData;

/**
 * The Class EditionDataManager
 *
 * @author kishor.pawar
 */
public class EditionDataManager extends GenericManager<EditionData, Long> implements
		IEditionDataManager {
	
	private IEditionDataDao editionDataDao;

	public EditionDataManager(IGenericDao<EditionData, Long> iGenericDao) {
		super(iGenericDao);
	}

	/**
	 * @param editionDataDao the editionDataDao to set
	 */
	public void setEditionDataDao(IEditionDataDao editionDataDao) {
		this.editionDataDao = editionDataDao;
	}

	@Override
	public List<EditionData> getEstimatedTimeByModuleIds(List<Long> moduleIds) {
		
		return editionDataDao.getEstimatedTimeByModuleIds(moduleIds);
	}
}