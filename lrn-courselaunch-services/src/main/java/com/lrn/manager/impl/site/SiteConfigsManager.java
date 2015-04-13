package com.lrn.manager.impl.site;

import java.util.List;

import com.lrn.dao.IGenericDao;
import com.lrn.dao.site.ISiteConfigsDao;
import com.lrn.dto.CustomPublishInfoDTO;
import com.lrn.dto.CustomPublishProfileDTOList;
import com.lrn.dto.CustomPublishesDTOList;
import com.lrn.dto.CustomSectionsDTOList;
import com.lrn.dto.SiteConfigsDTO;
import com.lrn.manager.impl.GenericManager;
import com.lrn.manager.site.ISiteConfigsManager;
import com.lrn.model.hibernate.site.SiteConfigs;
import com.lrn.model.hibernate.site.SiteConfigsPK;

/**
 * The Class SiteConfigsManager
 * 
 * @author kishor.pawar
 */
public class SiteConfigsManager extends
		GenericManager<SiteConfigs, SiteConfigsPK> implements
		ISiteConfigsManager {

	private ISiteConfigsDao siteConfigsDao;

	public void setSiteConfigsDao(ISiteConfigsDao siteConfigsDao) {
		this.siteConfigsDao = siteConfigsDao;
	}

	public SiteConfigsManager(
			IGenericDao<SiteConfigs, SiteConfigsPK> iGenericDao) {
		super(iGenericDao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<SiteConfigs> getSiteConfigsByCompany(String company) {
		String[] paramNames = { "company" };
		Object[] paramValues = { company };
		return siteConfigsDao.findByNamedQuery("findSiteConfigsByCompany",
				paramNames, paramValues);
	}

	@Override
	public SiteConfigsDTO getLanguagesAvaiable(Long siteId) {
		return siteConfigsDao.getLanguagesAvaiable(siteId);
	}

	@Override
	public List<String> getSloSiteCompanyNames() {
		return siteConfigsDao.getSloSiteCompanyNames();
	}

	@Override
	public List<String> getSloSiteCompanyNamesThatSupportAutomaticCreationOfUserIds() {
		return siteConfigsDao
				.getSloSiteCompanyNamesThatSupportAutomaticCreationOfUserIds();

	}

	@Override
	public String getSiteConfigValue(String configName, String company) {
		return siteConfigsDao.getSiteConfigValue(configName, company);
	}

	@Override
	public CustomPublishesDTOList getCustomPublishesForLocation(String company,
			List<String> locationList) {
		return siteConfigsDao.getCustomPublishesForLocation(company,
				locationList);
	}

	@Override
	public CustomPublishProfileDTOList getCustomPublishProfileList(
			String company) {
		return siteConfigsDao.getCustomPublishProfileList(company);
	}

	@Override
	public CustomPublishInfoDTO getCustomPublishInfo() {
		return siteConfigsDao.getCustomPublishInfo();
	}

	@Override
	public CustomSectionsDTOList getCustomSectionsInfo(String company,
			List<String> locationList) {
		return siteConfigsDao.getCustomSectionsInfo(company, locationList);
	}
}