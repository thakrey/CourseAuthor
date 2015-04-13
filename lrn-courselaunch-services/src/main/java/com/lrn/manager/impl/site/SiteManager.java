package com.lrn.manager.impl.site;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.lrn.dao.IGenericDao;
import com.lrn.dao.ISiteCompanyDomainDao;
import com.lrn.dao.site.ISiteDao;
import com.lrn.dto.SiteUserQueryResponseDTO;
import com.lrn.dto.UserLabelsDTO;
import com.lrn.dto.course.CourseLookupsDTO;
import com.lrn.manager.impl.GenericManager;
import com.lrn.manager.site.ISiteManager;
import com.lrn.model.hibernate.site.Site;
import com.lrn.model.hibernate.user.User;
import com.lrn.model.lcec.Language;
import com.lrn.model.lcec.SiteCompanyDomain;


public class SiteManager extends GenericManager<Site, Long> implements
		ISiteManager {

	public SiteManager(IGenericDao<Site, Long> genericDao) {
		super(genericDao);
		if(genericDao instanceof ISiteDao)
			setSiteDao((ISiteDao) genericDao);
	}

	private ISiteDao siteDao;
	private ISiteCompanyDomainDao siteCompanyDomainDao;
	
	@Override
	public void setSiteDao(ISiteDao siteDao) {
		this.siteDao = siteDao;
	}
	
	public ISiteDao getSiteDao() {
		return (ISiteDao)this.iGenericDao;
	}
	
	public void setSiteCompanyDomainDao(ISiteCompanyDomainDao siteCompanyDomainDao) {
		this.siteCompanyDomainDao = siteCompanyDomainDao;
	}

	@Override
	public Site getSiteByName(String siteName) {
		return getSiteDao().getSiteByName(siteName);
	}

	@Override
	public String getSitePassword(String company) {
		return getSiteDao().getSitePassword(company);
	}
	@Override
	public List<User> getSiteUsers(Long siteId) {
		return getSiteDao().getAllUsersBySite(get(siteId));
	}

	@Override
	public List<SiteUserQueryResponseDTO> getSiteUserQueryResponseDTO(Long siteId) {
		return getSiteDao().getSiteUserQueryResponseDTO(siteId);
	}
	
	@Override
	public Long getRevisionNumber() {
		return getSiteDao().getRevisionNumber();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List getSiteInUsersQueryResponseDTO(Long siteId, List userIds) {
		List<SiteUserQueryResponseDTO> queryResponseDTOs = new ArrayList<SiteUserQueryResponseDTO>();
		StringBuilder queryBuilder = new StringBuilder();
		String userIdsInparam = getInParam(userIds);
		
		queryBuilder.append("select users.user_id as userid, users.firstname as firstname, users.lastname ");
		queryBuilder.append("as lastname, users.middlename as middlename, users.company as company, ");
		queryBuilder.append("users.login_name as username, users.email as email, users.active as active, ");
		queryBuilder.append("users.password as password from users, site_user where users.user_id = ");
		queryBuilder.append("site_user.user_id and site_user.site_id = ").append(siteId).append(" ");
		queryBuilder.append("and site_user.user_id in (").append(userIdsInparam).append(")");
		Iterator<Map<String, Object>> itr = getSiteDao().findBySqlQuery(queryBuilder.toString());
        while(itr.hasNext()) {
            Map<String, Object> resultMap = itr.next();
            queryResponseDTOs.add(constructSiteUserQueryResponseDTOFromMap(resultMap));
        }
		return queryResponseDTOs;
	}
	
	@Override
	public UserLabelsDTO getCustomLabelsByCompanyAndLanguage(String company, String language, boolean international) {
		return siteDao.getCustomLabelsByCompanyAndLanguage(company, language, international); 
	}

	@Override
	public CourseLookupsDTO getCourseCatalogList(Long siteId) {
		return getSiteDao().getCourseCatalogList(siteId);
	}
	
	@Override
	public CourseLookupsDTO getAllCoursesBySiteId(Long siteId) {
		return getSiteDao().getAllCoursesBySiteId(siteId);
	}
	
	@Override
	public String getPartnerNameBySiteId(Long siteId) {
		return getSiteDao().getPartnerNameBySiteId(siteId);
	}


	@Override
	public List<Language> getAvailableLanguagesBySiteId(Long siteId) {
		return getSiteDao().getAvailableLanguagesBySiteId(siteId);
	}

	@Override
	public SiteCompanyDomain getSiteCompanyDomainByCompanyGroupId(String companyGroupId) {
		return this.siteCompanyDomainDao.getCompanyDomainByCompanyGroupId(companyGroupId);
	}

	/**
	 * Constructs comma separated string used at query from list
	 *
	 * @param List<Long> ids9
	 * 
	 * @return String
	 */
	private String getInParam(List<String> ids) {
		StringBuilder queryBuilder = new StringBuilder();
		int counter = 0;
		for(String id : ids) {
			if(counter == 0) {
				queryBuilder.append("'").append(id).append("'");
			} else {
				queryBuilder.append(", '").append(id).append("'");
			}
			counter++;
		}
		return queryBuilder.toString();
	}

	/**
	 * Constructs SiteUserQueryResponseDTO from query result map.
	 *
	 * @param Map<String, Object> resultMap
	 * 
	 * @return SiteUserQueryResponseDTO
	 */
	private SiteUserQueryResponseDTO constructSiteUserQueryResponseDTOFromMap(
			Map<String, Object> resultMap) {
		SiteUserQueryResponseDTO queryResponseDTO = new SiteUserQueryResponseDTO();
		queryResponseDTO.setCompany((String)resultMap.get("company"));
		queryResponseDTO.setEmail((String)resultMap.get("email"));
		queryResponseDTO.setFirstName((String)resultMap.get("firstname"));
		queryResponseDTO.setIsActive(false);
		String active = (String)resultMap.get("active"); 
		if(null != active && active.equalsIgnoreCase("t")) {
			queryResponseDTO.setIsActive(true);
		}		
		queryResponseDTO.setLastName((String)resultMap.get("lastname"));
		queryResponseDTO.setMiddleName((String)resultMap.get("middlename"));
		queryResponseDTO.setPassword((String)resultMap.get("password"));
		queryResponseDTO.setUserId((String)resultMap.get("userid"));
		queryResponseDTO.setUsername((String)resultMap.get("username"));
		return queryResponseDTO;
	}

	
}