package com.lrn.adapter;

import java.util.List;

import com.lrn.dto.LanguagesDTO;
import com.lrn.dto.RsaKeysDTO;
import com.lrn.dto.SiteConfigsDTO;
import com.lrn.dto.UserLabelsDTO;
import com.lrn.dto.course.CourseLookupsDTO;
import com.lrn.dto.response.site.SiteBrandingDTO;
import com.lrn.dto.response.site.SiteInfoDTO;
import com.lrn.dto.response.site.SiteSettingsDTO;
import com.lrn.dto.response.site.SiteUsersDTO;


/**
 * The Interface ISiteAdapter.
 */
public interface ISiteAdapter {
	
	/**
     * Get site information by siteId.
     *
     * @param Long siteId
     * 
     * @return SiteInfoDTO
     */
	SiteInfoDTO getInfo(Long siteId);
	
	/**
     * Gets Long siteId by siteId.
     *
     * @param String name
     * 
     * @return Long siteId
     */
	Long getSite(String name);
	
	/**
     * Returns the list of User by siteId.
     *
     * @param Long siteId
     * 
     * @return SiteUsersDTO
     */
	SiteUsersDTO getSiteUsers(Long siteId);
	
	/**
     * Returns the list of User by siteId and list of userIds.
     *
     * @param Long siteId
     * @param List<String> userIds
     * 
     * @return SiteUsersDTO
     */
	SiteUsersDTO getSiteUsersByUserIds(Long siteId, List<String> userIds);
	
	/**
     * Returns the setting_value from Site_settings table
     *
     * @param String company
     * @param String settingName
     * 
     * @return String settingValue
     */
	SiteSettingsDTO getSiteSettingByCompanyAndSettingName(String company, 
			String settingName);
	
	/**
     * Returns the site welcometext and logo
     *
     * @param Long siteId
     * 
     * @return SiteBrandingDTO
     */
	SiteBrandingDTO getWelcometextAndBranding(Long siteId);

	/**
     * Returns the siteConfigs
     *
     * @param Long siteId
     * 
     * @return List<SiteConfigsDTO>
     */
	List<SiteConfigsDTO> getSiteConfigs(Long siteId);
	
	/**
     * Get the list of custom labels for company and language
     * @param company
     * @param language
     * @param international
     * @return UserLabelsDTO
     */
	UserLabelsDTO getCustomLabelsByCompanyAndLanguage(String company, String language);
	
	/** 
     * Get the course catalog list
     * @param siteId
     * @return CourseLookupsDTO
     */
	CourseLookupsDTO getCourseCatalogList(Long siteId);
	
	/** 
     * Get all the courses for the site
     * @param siteId
     * @return CourseLookupsDTO
     */
	CourseLookupsDTO getAllCoursesBySiteId(Long siteId);
	
	/** 
     * Get the partner name
     * 
     * @param siteId
     * 
     * @return	partner name 
     */
	String getPartnerNameBySiteId(Long siteId);
	
	LanguagesDTO getAvailableLanguagesBySiteId(Long siteId);
	
	String getSitePassword(String company);

	RsaKeysDTO getRsaKeysBySiteId(Long siteId);

	Long getRevisionNumber();
}
