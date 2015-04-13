package com.lrn.manager;

import java.util.List;

import com.lrn.model.hibernate.EditionData;

/**
 * The Interface IEditionDataManager
 * 
 *
 */
public interface IEditionDataManager extends IGenericManager<EditionData, Long> {

	/**
	 * Returns Estimated Time
	 * @param moduleIds
	 * @return
	 */
	List<EditionData> getEstimatedTimeByModuleIds(List<Long> moduleIds);
	
}
