package com.lrn.dao.impl.site;

import com.lrn.dao.impl.GenericDao;
import com.lrn.dao.site.ISiteSettingsDao;
import com.lrn.model.hibernate.site.SiteSettings;
import com.lrn.model.hibernate.site.SiteSettingsPK;

/**
 * The Class SiteSettingsDao.
 *
 * @author kishor.pawar
 */
public class SiteSettingsDao extends GenericDao<SiteSettings, SiteSettingsPK>  implements ISiteSettingsDao {

	public SiteSettingsDao(Class<SiteSettings> persistentClass) {
		super(persistentClass);
	}
}