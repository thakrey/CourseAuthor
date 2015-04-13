package com.lrn.manager.curriculum;

import java.util.List;

import com.lrn.manager.IGenericManager;
import com.lrn.model.hibernate.curriculum.CurriculumModuleChain;

/**
 * The Interface ICurriculumModuleChainManager

 *
 */
public interface ICurriculumModuleChainManager extends IGenericManager<CurriculumModuleChain, Long> {

	/**
	 * Returns Curriculum Module Chain
	 * @param siteId
	 * @param curriculumIds
	 * @return
	 */
	List<CurriculumModuleChain> getCurriculumModuleChainByCurriculumIds(Long siteId, List<Long> curriculumIds);

}