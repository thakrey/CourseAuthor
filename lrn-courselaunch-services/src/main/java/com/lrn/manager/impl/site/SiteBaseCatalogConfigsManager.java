package com.lrn.manager.impl.site;

import java.util.List;

import com.lrn.dao.IGenericDao;
import com.lrn.dao.site.ISiteBaseCatalogConfigsDao;
import com.lrn.manager.impl.GenericManager;
import com.lrn.manager.site.ISiteBaseCatalogConfigsManager;
import com.lrn.model.hibernate.site.SiteBaseCatalogConfigs;

/**
 * The Class SiteBaseCatalogConfigsManager
 * 
 * @author kishor.pawar
 */
public class SiteBaseCatalogConfigsManager extends 
		GenericManager<SiteBaseCatalogConfigs, Long> implements 
		ISiteBaseCatalogConfigsManager {

	private ISiteBaseCatalogConfigsDao siteBaseCatalogConfigsDao;
	
	public SiteBaseCatalogConfigsManager(
			IGenericDao<SiteBaseCatalogConfigs, Long> iGenericDao) {
		super(iGenericDao);
	}

	/**
	 * @param siteBaseCatalogConfigsDao the siteBaseCatalogConfigsDao to set
	 */
	public void setSiteBaseCatalogConfigsDao(
			ISiteBaseCatalogConfigsDao siteBaseCatalogConfigsDao) {
		this.siteBaseCatalogConfigsDao = siteBaseCatalogConfigsDao;
	}

	@Override
	public List<SiteBaseCatalogConfigs> getConfigsByBaseCatalogIdAndSiteIdAndKey(
			Long siteId, String baseCatalogId, String key) {
		return siteBaseCatalogConfigsDao.getConfigsByBaseCatalogIdAndSiteIdAndKey(
				siteId, baseCatalogId, key);
	}
}