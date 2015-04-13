package com.lrn.dao.site;

import java.util.List;

import com.lrn.dao.IGenericDao;
import com.lrn.model.hibernate.site.SiteBaseCatalogConfigs;

/**
 * Interface ISiteBaseCatalogConfigsDao
 *
 * @author kishor.pawar
 */
public interface ISiteBaseCatalogConfigsDao  extends 
		IGenericDao<SiteBaseCatalogConfigs, Long> {
	
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