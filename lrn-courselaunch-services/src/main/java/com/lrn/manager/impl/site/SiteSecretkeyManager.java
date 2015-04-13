package com.lrn.manager.impl.site;

import com.lrn.dao.IGenericDao;
import com.lrn.dao.site.ISiteSecretkeyDao;
import com.lrn.manager.impl.GenericManager;
import com.lrn.manager.site.ISiteSecretkeyManager;
import com.lrn.model.hibernate.site.SiteSecretkey;
import com.lrn.model.hibernate.site.SiteSecretkeyPK;

/**
 * The Class SiteSecretkeyManager.
 *
 * @author kishor.pawar
 */
public class SiteSecretkeyManager extends GenericManager<SiteSecretkey, SiteSecretkeyPK> implements
		ISiteSecretkeyManager {

	private ISiteSecretkeyDao secretkeyDao;
	
	/**
	 * Instantiates a new site secretkey manager.
	 *
	 * @param iGenericDao the i generic dao
	 */
	public SiteSecretkeyManager(
			IGenericDao<SiteSecretkey, SiteSecretkeyPK> iGenericDao) {
		super(iGenericDao);
	}

	/**
	 * @param secretkeyDao the secretkeyDao to set
	 */
	public void setSecretkeyDao(ISiteSecretkeyDao secretkeyDao) {
		this.secretkeyDao = secretkeyDao;
	}
}