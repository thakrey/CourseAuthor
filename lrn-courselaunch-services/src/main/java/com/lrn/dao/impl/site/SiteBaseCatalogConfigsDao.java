package com.lrn.dao.impl.site;

import java.util.List;

import com.lrn.dao.impl.GenericDao;
import com.lrn.dao.site.ISiteBaseCatalogConfigsDao;
import com.lrn.model.hibernate.site.SiteBaseCatalogConfigs;

/**
 * The Class SiteBaseCatalogConfigsDao.
 *
 * @author kishor.pawar
 */
public class SiteBaseCatalogConfigsDao extends GenericDao<SiteBaseCatalogConfigs, Long> 
		implements ISiteBaseCatalogConfigsDao {
	
	public SiteBaseCatalogConfigsDao(Class<SiteBaseCatalogConfigs> persistentClass){
		super(persistentClass);
	}

	@Override
	public List<SiteBaseCatalogConfigs> getConfigsByBaseCatalogIdAndSiteIdAndKey(
			Long siteId, String baseCatalogId, String key) {
		String[] paramNames = {"siteId", "baseCatalogId", "key"};
		Object[] paramValues = {siteId, baseCatalogId, key};
		return findByNamedQuery("getConfigsByBaseCatalogIdAndSiteIdAndKey", paramNames, 
				paramValues);
	}
}