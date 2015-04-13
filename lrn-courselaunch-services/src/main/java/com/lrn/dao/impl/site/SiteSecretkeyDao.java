package com.lrn.dao.impl.site;

import com.lrn.dao.impl.GenericDao;
import com.lrn.dao.site.ISiteSecretkeyDao;
import com.lrn.model.hibernate.site.SiteSecretkey;
import com.lrn.model.hibernate.site.SiteSecretkeyPK;

/**
 * The Class SiteSecretkeyDao.
 *
 * @author kishor.pawar
 */
public class SiteSecretkeyDao extends GenericDao<SiteSecretkey, SiteSecretkeyPK> implements
		ISiteSecretkeyDao {

	public SiteSecretkeyDao(Class<SiteSecretkey> persistentClass) {
		super(persistentClass);
	}
}