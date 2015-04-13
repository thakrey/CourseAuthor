package com.lrn.manager.site;

import com.lrn.dao.site.ISiteSettingsDao;
import com.lrn.manager.IGenericManager;
import com.lrn.model.hibernate.site.SiteSettings;
import com.lrn.model.hibernate.site.SiteSettingsPK;

/**
 * The Interface ISiteSettingsManager
 * 
 * @author kishor.pawar
 */
public interface ISiteSettingsManager extends IGenericManager<SiteSettings, SiteSettingsPK> {
	/**
	 * Sets the siteSettings dao.
	 *
	 * @param siteSettingsDao the new siteSettings dao
	 */
	public void setSiteSettingsDao(ISiteSettingsDao siteSettingsDao);
	
	/**
     * Gets SiteSettings by company and setting name.
     *
     * @param String company
     * @param String settingName
     * 
     * @return SiteSettings
     */
	SiteSettings getByCompanyNameSettingName(String company, String settingName);	
}