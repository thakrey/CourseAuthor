/**
 * 
 */
package com.lrn.manager.site;

import java.util.List;






import com.lrn.dao.site.ISiteDao;
import com.lrn.dto.SiteUserQueryResponseDTO;
import com.lrn.dto.UserLabelsDTO;
import com.lrn.dto.course.CourseLookupsDTO;
import com.lrn.manager.IGenericManager;
import com.lrn.model.lcec.Language;
import com.lrn.model.lcec.SiteCompanyDomain;
import com.lrn.model.hibernate.site.Site;
import com.lrn.model.hibernate.user.User;

/**
 * The Interface ISiteManager
 *
 */
public interface ISiteManager extends IGenericManager<Site, Long> {
	
	/**
	 * Convenience method for testing - allows you to mock the DAO and set it on
	 * an interface.
	 * 
	 * @param ISiteDao
	 *            the siteDao implementation to use
	 */
	public void setSiteDao(ISiteDao siteDao);
	
    /**
     * Gets the site by site name.
     *
     * @param siteName the site name
     * @return the site by site name
     */
    Site getSiteByName(String siteName);
    
    /**
	 * Gets all users by site id.
	 * 
	 * @param Long siteId
	 * 
	 * @return List of users
	 */
    List<User> getSiteUsers(Long siteId);

    /**
	 * Gets all users by site id.
	 * 
	 * @param Long siteId
	 * 
	 * @return List<SiteUserQueryResponseDTO> queryRespones
	 */
    List<SiteUserQueryResponseDTO> getSiteUserQueryResponseDTO(Long siteId);  

    /**
     * Retrieves list of User by userids and siteId
     * 
     * @param Long siteId
     * @param List<String> userIds
     * 
     * @return List<SiteUserQueryResponseDTO>
     */
    List<SiteUserQueryResponseDTO> getSiteInUsersQueryResponseDTO(Long siteId, List<String> userIds);
    
    /**
     * Get the latest revision number from PUB_SERIAL table
     * @return
     */
    Long getRevisionNumber();
    
    /**
     * Get the list of custom labels for company and language
     * @param company
     * @param language
     * @param international
     * @return
     */
    UserLabelsDTO getCustomLabelsByCompanyAndLanguage(String company, String language, boolean international);
    
    /** 
     * Get the course catalog list
     * @param siteId
     * @return
     */
    CourseLookupsDTO getCourseCatalogList(Long siteId);
    
    /** 
     * Get all the courses for the site
     * @param siteId
     * @return
     */
    CourseLookupsDTO getAllCoursesBySiteId(Long siteId);
    
    /** 
     * Get the course catalog list
     * @param siteId
     * @return partner name
     */
    String getPartnerNameBySiteId(Long siteId);
    
    List<Language> getAvailableLanguagesBySiteId(Long siteId);
    
   SiteCompanyDomain getSiteCompanyDomainByCompanyGroupId(String companyGroupId);
   
   String getSitePassword(String company);
}