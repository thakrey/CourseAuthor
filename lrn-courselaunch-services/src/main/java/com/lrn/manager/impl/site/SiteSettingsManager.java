package com.lrn.manager.impl.site;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.lrn.dao.IGenericDao;
import com.lrn.dao.site.ISiteSettingsDao;
import com.lrn.manager.impl.GenericManager;
import com.lrn.manager.site.ISiteSettingsManager;
import com.lrn.model.hibernate.site.SiteSettings;
import com.lrn.model.hibernate.site.SiteSettingsPK;

/**
 * The Class SiteSettingsManager
 * 
 * @author kishor.pawar
 */
public class SiteSettingsManager extends GenericManager<SiteSettings, SiteSettingsPK>
		implements ISiteSettingsManager {
	private ISiteSettingsDao siteSettingsDao;

	public SiteSettingsManager(IGenericDao<SiteSettings, SiteSettingsPK> iGenericDao) {
		super(iGenericDao);
	}

	@Override
	public void setSiteSettingsDao(ISiteSettingsDao siteSettingsDao) {
		this.siteSettingsDao = siteSettingsDao;
	}

	@Override
	public SiteSettings getByCompanyNameSettingName(String company,
			String settingName) {
		
		SiteSettingsPK siteSettingsPK = new SiteSettingsPK();
		siteSettingsPK.setCompany(company);
		siteSettingsPK.setSettingName(settingName);
		
		try {
			return this.siteSettingsDao.get(siteSettingsPK);
			
		} catch(ObjectRetrievalFailureException ob) {
			System.out.println("SiteSettings " + settingName + " NOT available for " + company);
			return null;
		}
	}
}