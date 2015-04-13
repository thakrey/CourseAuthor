package com.lrn.dao.site;

import java.util.List;

import com.lrn.dao.IGenericDao;
import com.lrn.dto.CustomPublishInfoDTO;
import com.lrn.dto.CustomPublishProfileDTOList;
import com.lrn.dto.CustomPublishesDTOList;
import com.lrn.dto.CustomSectionsDTOList;
import com.lrn.dto.SiteConfigsDTO;
import com.lrn.model.hibernate.site.SiteConfigs;
import com.lrn.model.hibernate.site.SiteConfigsPK;

/**
 * Interface ISiteConfigsDao
 *
 * @author kishor.pawar
 */
public interface ISiteConfigsDao extends IGenericDao<SiteConfigs, SiteConfigsPK> {
	
     SiteConfigsDTO getLanguagesAvaiable(Long siteId);
	
	List<String> getSloSiteCompanyNames( );
	
	List<String> getSloSiteCompanyNamesThatSupportAutomaticCreationOfUserIds();
	
	String  getSiteConfigValue(String configName, String company);

	CustomPublishProfileDTOList getCustomPublishProfileList(String company);

	CustomPublishesDTOList getCustomPublishesForLocation(String company, List<String> locationList);

	CustomPublishInfoDTO getCustomPublishInfo();

	CustomSectionsDTOList getCustomSectionsInfo(String company,
			List<String> locationList);
}