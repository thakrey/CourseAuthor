package com.lrn.doa;

import java.util.List;

import com.lrn.dto.SiteUserQueryResponseDTO;
import com.lrn.dto.UserLabelsDTO;
import com.lrn.dto.course.CourseLookupsDTO;
import com.lrn.model.Language;
import com.lrn.model.Site;
import com.lrn.model.User;

public interface ISiteDao  extends IGenericDao<Site, Long> {
	/**
     * Gets all the users belonging to a site by site class.
     *
     * @param site the site
     * @return all users
     */
    public List<User> getAllUsersBySite(Site site);
    
    /**
	 * Gets all users by site id.
	 * 
	 * @param Id
	 *            the id
	 * @return all users by site id
	 */
    public List<User> getAllUsersBySiteId(Long Id);
    
    /**
     * Gets the site by site name.
     *
     * @param siteName the site name
     * @return the site by site name
     */
    public Site getSiteByName(String siteName);
    
    /**
     * Gets the user count by site id.
     *
     * @param siteId the site id
     * @return the user count by site id
     */
    public Long getUserCountBySiteId(Long siteId);

    Long getRevisionNumber();
    
    /**
	 * Gets all users by site id.
	 * 
	 * @param Long siteId
	 * 
	 * @return List<SiteUserQueryResponseDTO> queryRespones
	 */
    List<SiteUserQueryResponseDTO> getSiteUserQueryResponseDTO(Long siteId);
    
    /**
     * Get the list of custom labels for company and language
     * @param company
     * @param language
     * @param international
     * @return UserLabelsDTO
     */
    UserLabelsDTO getCustomLabelsByCompanyAndLanguage(String company, String language, boolean international);
    
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
     * @param siteId
     * @return partner name string
     */
	String getPartnerNameBySiteId(Long siteId);
	
	/** 
	 * Get the list of available languages by site id
	 * 
	 * @param siteId
	 * @return List of Language
	 */
	List<Language> getAvailableLanguagesBySiteId(Long siteId);
	
	String getSitePassword(String company);
}