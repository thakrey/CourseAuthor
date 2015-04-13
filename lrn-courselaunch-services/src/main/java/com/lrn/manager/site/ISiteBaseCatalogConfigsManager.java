package com.lrn.manager.site;

import java.util.List;

import com.lrn.manager.IGenericManager;
import com.lrn.model.hibernate.site.SiteBaseCatalogConfigs;

/**
 * The Interface ISiteBaseCatalogConfigsManager
 * 
 * @author kishor.pawar
 */
public interface ISiteBaseCatalogConfigsManager extends 
		IGenericManager<SiteBaseCatalogConfigs, Long> {

	/**
	 * Returns List of SiteBaseCatalogConfigs by siteId, baseCatalogId and key
	 * 
	 * @param Long siteId
	 * @param String baseCatalogId
	 * @param String key
	 * 
	 * @return List<SiteBaseCatalogConfigs>
	 */
	List<SiteBaseCatalogConfigs> getConfigsByBaseCatalogIdAndSiteIdAndKey(Long siteId,
			String baseCatalogId, String key);
}