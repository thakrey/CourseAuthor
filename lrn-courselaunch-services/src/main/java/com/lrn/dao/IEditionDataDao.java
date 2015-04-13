package com.lrn.dao;

import java.util.List;

import com.lrn.model.hibernate.EditionData;

/**
 * Interface IEditionDataDao
 * 
 * @author kishor.pawar
 */
public interface IEditionDataDao extends IGenericDao<EditionData, Long> {

	/**
	 * Retursn Estimated Time for Modules
	 * @param moduleIds
	 * @return
	 */
	List<EditionData> getEstimatedTimeByModuleIds(List<Long> moduleIds);
	
}
