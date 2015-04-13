package com.lrn.dao.impl.site;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.lrn.dao.impl.GenericDao;
import com.lrn.dao.site.ISiteDao;
import com.lrn.dto.SiteUserQueryResponseDTO;
import com.lrn.dto.UserLabelsDTO;
import com.lrn.dto.course.CourseLookupDTO;
import com.lrn.dto.course.CourseLookupsDTO;
import com.lrn.model.hibernate.site.Site;
import com.lrn.model.hibernate.user.User;
import com.lrn.model.lcec.Language;
import com.lrn.model.lcec.LanguagePK;
import com.lrn.model.spring.user.UserLabelDTO;


public class SiteDao extends GenericDao<Site, Long> implements ISiteDao {
	
	public SiteDao(Class<Site> persistentClass){
		super(persistentClass);
	}

	@Override
	public List<User> getAllUsersBySite(Site site) {
		if (site == null)
			return null;
		
		Session currSession = this.getSession();
		currSession.refresh(site);
		ArrayList<User> allUsers = new ArrayList<User>(site.getUsers());
		this.releaseSession(currSession);
		return allUsers;
	}

	@Override
	public List<User> getAllUsersBySiteId(Long Id) {
		if (Id == null)
			return null;
		Site site = this.get(Id);
		if (site == null)
		    return null;
		this.getHibernateTemplate().refresh(site);
		return new ArrayList<User>(site.getUsers());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Site getSiteByName(String siteName) {
		List<Site> sites = this.getHibernateTemplate().findByNamedQueryAndNamedParam("findByName", "siteName", siteName);
		if (sites.size() > 0 )
			return sites.get(0);
		
		return null;
	}

	@Override
	public Long getUserCountBySiteId(Long siteId) {
        List<User> userList = this.getAllUsersBySiteId(siteId);
		
		if (userList == null) 
			return new Long(0);
		
		return new Long(userList.size());
	}

	@Override 
	public String getSitePassword(String company) {
		String sitePassword = null;
		DataSource ds = SessionFactoryUtils.getDataSource(getSessionFactory());
		
		StringBuilder queryBuilder = new StringBuilder();			
		queryBuilder.append("select PASSWORD from GROUPS where GROUPID = ?");
		
		ArrayList<Object> params = new ArrayList<Object> ();
		params.add(company);

		List<Map<String, Object>> resultSetMapList = queryForList(queryBuilder.toString(), params);
		Iterator<Map<String, Object>> itr = resultSetMapList.iterator();
		
		while(itr.hasNext()) {
            Map<String, Object> resultMap =itr.next();
            sitePassword = (String) resultMap.get("PASSWORD");
        }
		closeConnection(ds);

		return sitePassword;
	}
	
	@Override
	public List<SiteUserQueryResponseDTO> getSiteUserQueryResponseDTO(Long siteId) {
		List<SiteUserQueryResponseDTO> queryResponses = new ArrayList<SiteUserQueryResponseDTO>();
		DataSource ds = SessionFactoryUtils.getDataSource(getSessionFactory());
		
		StringBuilder queryBuilder = new StringBuilder();			
		queryBuilder.append("select users.user_id as userid, users.firstname as firstname, users.lastname ");
		queryBuilder.append("as lastname, users.middlename as middlename, users.company as company, ");
		queryBuilder.append("users.login_name as username, users.email as email, users.active as active, ");
		queryBuilder.append("users.password as password from users, site_user where site_user.user_id = ");
		queryBuilder.append("users.user_id and site_user.site_id = ?");
		
		ArrayList<Object> params = new ArrayList<Object> ();
		params.add(siteId);

		List<Map<String, Object>> resultSetMapList = queryForList(queryBuilder.toString(), params);
		Iterator<Map<String, Object>> itr = resultSetMapList.iterator();
		
        while(itr.hasNext()) {
            Map<String, Object> resultMap =itr.next();
            queryResponses.add(constructSiteUserQueryResponseDTOFromMap(resultMap));
        }
		closeConnection(ds);

		return queryResponses;
	}

	@Override
	public UserLabelsDTO getCustomLabelsByCompanyAndLanguage(String company, String language, boolean international) {
		List<UserLabelDTO> list = new ArrayList<UserLabelDTO> ();
		//if internatinoal then get it from custom string
		
		if(international) {
			StringBuilder queryBuilder = new StringBuilder();			
			queryBuilder.append("select cs.key as custom_key,cs.string  as custom_value from custom_string cs, custom_publishes cp ");
			queryBuilder.append(" where cp.id = cs.custom_publish_id and cp.is_active = 1 and publication is not null");
			queryBuilder.append(" and cp.publish_type = 'string' and lower(cp.profile_value) = lower(?)");
			queryBuilder.append(" and company = ?");

			ArrayList<Object> params = new ArrayList<Object> ();
			params.add(language);
			params.add(company);

			List<Map<String, Object>> resultSetMapList = queryForList(queryBuilder.toString(), params);
			Iterator<Map<String, Object>> itr = resultSetMapList.iterator();
			
	        while(itr.hasNext()) {
	            Map<String, Object> resultMap = itr.next();
	            UserLabelDTO labelDTO = new UserLabelDTO();
	            labelDTO.setColumnName((String)resultMap.get("custom_key"));
	            labelDTO.setDisplayName((String)resultMap.get("custom_value"));
	            list.add(labelDTO);
	        }
		} 
		if(!international || list.size() == 0) { //if not international or if the custom string list is empty, then get it from company_users_column
			StringBuilder queryBuilder = new StringBuilder();			
			queryBuilder.append("select * from company_users_column where company = ?");
			queryBuilder.append(" and ((lower(column_name) = 'login_name') or (protected_field = '0' and privilege_visibility_level = '0')) order by report_position");
			
			ArrayList<Object> params = new ArrayList<Object> ();
			params.add(company);

			List<Map<String, Object>> resultSetMapList = queryForList(queryBuilder.toString(), params);
			Iterator<Map<String, Object>> itr = resultSetMapList.iterator();
			
	        while(itr.hasNext()) {
	            Map<String, Object> resultMap = itr.next();
	            UserLabelDTO ul = getUserLabel(resultMap);
	            list.add(ul);
	        }

		}

		UserLabelsDTO dto = new UserLabelsDTO();
        dto.setUserLabelList(list);
        
		return dto;
	}
	
	@Override
	public Long getRevisionNumber() {
		Long revisionNumber = null;
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select max(serial) as revision from pub_serial");
		Iterator<Map<String, Object>> itr = findBySqlQuery(queryBuilder.toString());
        while(itr.hasNext()) {
            Map<String, Object> resultMap = itr.next();
            BigDecimal revisionNumberBigDecimal = (BigDecimal)resultMap.get("revision");
            revisionNumber = revisionNumberBigDecimal.longValue();
        }
		return revisionNumber;
	}
	
	/** 
     * Get all the courses by siteId
     * @param siteId
     * @return CourseLookupsDTO
     */
	@Override
	public CourseLookupsDTO getAllCoursesBySiteId(Long siteId) {
		
		//get the revision id
		Long revisionNumber = this.getRevisionNumber();
				
		List<CourseLookupDTO> dtoList = new ArrayList<CourseLookupDTO>();

		StringBuilder queryBuilder = new StringBuilder();			
		queryBuilder.append("SELECT cl.system_id as system_id, cl.node_id as node_id, cl.course as course, cl.catalog_id as catalog_id, cl.course_short_name as course_short_name, ");
		queryBuilder.append("cl.title as title, cl.description as description, cl.app_type as app_type, cl.course_path as course_path, cl.language as language, cl.version as version, ");
		queryBuilder.append("cl.core_vendor as core_vendor, cl.media as media, cl.is_library as is_library, cl.created as cl_created, cl.templates as templates, ");
		queryBuilder.append("cl.documents as documents, cl.record_quiz as record_quiz, cl.copyright_year as copyright_year, cl.vendor as vendor, cl.edition_id as edition_id, ");
		queryBuilder.append("cl.availability as availability, cl.updated as updated, cl.course_category_id as course_category_id, sc.site_id as site_id, ");
		queryBuilder.append("sc.created as created, sc.available_to_learners as available_to_learners, ");
		queryBuilder.append("(case when (cl.course_img_url is not null) then (cl.course_img_url) else (select image_url from course_category cc where cc.id = cl.course_category_id) end) as cl_course_img_url, ");
		queryBuilder.append("sc.available_in_catalog as available_in_catalog, sc.id as site_course_id, m.id as module_id, m.base_catalog_id as base_catalog_id, m.created as m_created ");
		queryBuilder.append("FROM COURSE_LOOKUP CL,SITE_COURSE SC, MODULE M WHERE CL.AVAILABILITY = 3   and sc.available_to_learners = 1 AND SC.SYSTEM_ID = CL.SYSTEM_ID AND ");
		queryBuilder.append("M.ID = CL.MODULE_ID AND SITE_ID = ?").append(" order by base_catalog_id");
		
		ArrayList<Object> params = new ArrayList<Object> ();
		params.add(siteId);

		List<Map<String, Object>> resultSetMapList = queryForList(queryBuilder.toString(), params);
		Iterator<Map<String, Object>> itr = resultSetMapList.iterator();
		
        while(itr.hasNext()) {
            Map<String, Object> resultMap =itr.next();
            dtoList.add(constructCourseLookupDTOFromMap(resultMap, revisionNumber));
        }
        
        CourseLookupsDTO dto = new CourseLookupsDTO();
        dto.setCourseLookupDTOList(dtoList);

		return dto;
	}
	
	/** 
     * Get the course catalog list
     * @param siteId
     * @return CourseLookupsDTO
     */
	@Override
	public CourseLookupsDTO getCourseCatalogList(Long siteId) {
		
		//get the revision id
		Long revisionNumber = this.getRevisionNumber();
				
		List<CourseLookupDTO> dtoList = new ArrayList<CourseLookupDTO>();
		
		StringBuilder queryBuilder = new StringBuilder();			
		queryBuilder.append("SELECT cl.system_id as system_id, cl.node_id as node_id, cl.course as course, cl.catalog_id as catalog_id, cl.course_short_name as course_short_name, ");
		queryBuilder.append("cl.title as title, cl.description as description, cl.app_type as app_type, cl.course_path as course_path, cl.language as language, cl.version as version, ");
		queryBuilder.append("cl.core_vendor as core_vendor, cl.media as media, cl.is_library as is_library, cl.created as cl_created, cl.templates as templates, ");
		queryBuilder.append("cl.documents as documents, cl.record_quiz as record_quiz, cl.copyright_year as copyright_year, cl.vendor as vendor, cl.edition_id as edition_id, ");
		queryBuilder.append("cl.availability as availability, cl.updated as updated, cl.course_category_id as course_category_id, sc.site_id as site_id, ");
		queryBuilder.append("sc.created as created, sc.available_to_learners as available_to_learners, ");
		queryBuilder.append("(case when (cl.course_img_url is not null) then (cl.course_img_url) else (select image_url from course_category cc where cc.id = cl.course_category_id) end) as cl_course_img_url, ");
		queryBuilder.append("sc.available_in_catalog as available_in_catalog, sc.id as site_course_id, m.id as module_id, m.base_catalog_id as base_catalog_id, m.created as m_created ");
		queryBuilder.append("FROM COURSE_LOOKUP CL,SITE_COURSE SC, MODULE M WHERE CL.AVAILABILITY = 3 AND SC.SYSTEM_ID = CL.SYSTEM_ID AND ");
		queryBuilder.append("M.ID = CL.MODULE_ID AND AVAILABLE_IN_CATALOG = 1 AND AVAILABLE_TO_LEARNERS = 1 AND SITE_ID = ?");
		
		ArrayList<Object> params = new ArrayList<Object> ();
		params.add(siteId);

		List<Map<String, Object>> resultSetMapList = queryForList(queryBuilder.toString(), params);
		Iterator<Map<String, Object>> itr = resultSetMapList.iterator();
		
        while(itr.hasNext()) {
            Map<String, Object> resultMap =itr.next();
            dtoList.add(constructCourseLookupDTOFromMap(resultMap, revisionNumber));
        }
        
        CourseLookupsDTO dto = new CourseLookupsDTO();
        dto.setCourseLookupDTOList(dtoList);

		return dto;
	}
	
	public String getPartnerNameBySiteId(Long siteId) {
		DataSource ds = SessionFactoryUtils.getDataSource(getSessionFactory());	
		SimpleJdbcTemplate jdbcTemplate = new SimpleJdbcTemplate(ds);
		Object partnerName = jdbcTemplate.queryForObject("select p.name from site s, partner p where s.partner_id = p.id and s.id = ?",
				java.lang.String.class,
				siteId );
		
		return (String)partnerName;
	}
	
	@Override 
	public List<Language> getAvailableLanguagesBySiteId(Long siteId) {

		//get the list of languages for the siteId, this will only return hte string, and not hte whole language object. so we have to get hte whole lang
		//detail from the language table
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select key from custom_field_enum where column_name = 'Language' and site_id = ?");
		
		ArrayList<Object> params = new ArrayList<Object> ();
		params.add(siteId);

		List<Map<String, Object>> resultSetMapList = queryForList(queryBuilder.toString(), params);
		Iterator<Map<String, Object>> itr = resultSetMapList.iterator();
		
		StringBuffer langBuf = new StringBuffer();
		langBuf.append("'");
		List<String> langList = new ArrayList<String> ();
		while (itr.hasNext()) {
			Map<String, Object> resultMap = itr.next();
			if(langBuf.length() == 1)
				langBuf.append((String) resultMap.get("key"));
			else
				langBuf.append("','").append((String) resultMap.get("key"));
			
			langList.add((String) resultMap.get("key"));
		}
		langBuf.append("'");
		
		//get all the languages from the language table
		queryBuilder = new StringBuilder();
		queryBuilder.append("select * from src_lang where language in (").append(langBuf).append(")");
		
		itr = findBySqlQuery(queryBuilder.toString());
		
		List<Language> allLanguages = new ArrayList<Language> ();
		while (itr.hasNext()) {
			Map<String, Object> resultMap = itr.next();
			Language lang = constructLanguageFromResultMap(resultMap);
			allLanguages.add(lang);
		}
		
		//now fill in the whole language object
		List<Language> availableLanguages = new ArrayList<Language> ();
		for(Language lang : allLanguages) {
			if(langList.contains(lang.getLanguagePK().getLanguage())) {
				availableLanguages.add(lang);
			}
		}
		
		return availableLanguages;
	}
	
	private Language constructLanguageFromResultMap(Map<String, Object> map) {
		Language lang = new Language();
			lang.setCountryCode((String) map.get("country_code")); 
			lang.setEnName((String) map.get("en_name"));
			lang.setLabel((String) map.get("label"));
			lang.setLangCode((String) map.get("lang_code"));
			LanguagePK pk = new LanguagePK();
			pk.setLanguage(((String) map.get("language")));
			lang.setLanguagePK(pk);
			
		return lang;
	}
	
	private CourseLookupDTO constructCourseLookupDTOFromMap(Map<String, Object> rs, Long revisionNumber) {
		CourseLookupDTO dto = new CourseLookupDTO();
		
		dto.setAppType((String)rs.get("app_type"));
		dto.setAvailability(((BigDecimal)rs.get("availability")).longValue());
		dto.setBaseCatalogId((String)rs.get("base_catalog_id"));
		dto.setCatalogId((String)rs.get("catalog_id"));
		BigDecimal dec = (BigDecimal)rs.get("copyright_year");
		if(dec != null)
			dto.setCopyrightYear(dec.longValue());
		dto.setCoreVendor((String)rs.get("core_vendor"));
		dec = (BigDecimal)rs.get("course");
		if(dec != null)
			dto.setCourse(dec.longValue());
		
		if(rs.get("cl_course_img_url") != null && !"".equals(rs.get("cl_course_img_url")))
			dto.setCourseImgURL("/rev" + revisionNumber + (String)rs.get("cl_course_img_url"));
		dto.setCoursePath((String)rs.get("course_path"));
		dto.setCourseShortName((String)rs.get("course_short_name"));
		dto.setCreated((Date)rs.get("created"));
		dto.setDescription((String)rs.get("description"));
		dto.setDocuments((String)rs.get("documents"));
		dec = (BigDecimal)rs.get("edition_id");
		if(dec != null)
			dto.setEditionId(dec.longValue());
		dec = (BigDecimal)rs.get("is_library");
		if(dec != null)
			dto.setIsLibrary(dec.longValue());
		dto.setLanguage((String)rs.get("language"));
		dto.setMedia((String)rs.get("media"));
		dto.setMediaType((String)rs.get("column_name"));
		dto.setModuleId(((BigDecimal)rs.get("module_id")).longValue());
		dec = (BigDecimal)rs.get("is_library");
		if(dec != null)
			dto.setNodeId(dec.longValue());
		dec = (BigDecimal)rs.get("record_quiz");
		if(dec != null)
			dto.setRecordQuiz(dec.longValue());
		dto.setSystemId((String)rs.get("system_id"));
		dto.setTemplates((String)rs.get("templates"));
		dto.setTitle((String)rs.get("title"));
		dto.setUpdated((Date)rs.get("updated"));
		dto.setVendor((String)rs.get("vendor"));
		dto.setVersion((String)rs.get("version"));
		dec = (BigDecimal)rs.get("available_in_catalog");
		if(dec != null)
			dto.setAvailableInCatalog(dec.longValue());
		
		return dto;
	}
	
	private UserLabelDTO getUserLabel(Map<String, Object> rs) {
		UserLabelDTO dto = new UserLabelDTO();
		
		dto.setColumnName((String)rs.get("column_name"));
		dto.setCompany((String)rs.get("company"));
		dto.setDisplayName((String)rs.get("display_name"));
		
		BigDecimal reportPosition = (BigDecimal)rs.get("report_position");
		if(reportPosition != null)
			dto.setReportPosition(reportPosition.longValue());
		
		BigDecimal searchCriteria = (BigDecimal)rs.get("search_criteria");
		if(searchCriteria != null)
			dto.setSearchCriteria(searchCriteria.longValue());
		
		dto.setSourceOfData((String)rs.get("source_of_data"));
		
		BigDecimal editAllowed = (BigDecimal)rs.get("edit_allowed");
		if(editAllowed != null)
			dto.setEditAllowed(editAllowed.longValue());
		
		BigDecimal privilegeVisibilityLevel = (BigDecimal)rs.get("privilege_visibility_level");
		if(privilegeVisibilityLevel != null)
			dto.setPrivilegeVisibilityLevel(privilegeVisibilityLevel.longValue());
		
		BigDecimal requiredField = (BigDecimal)rs.get("required_field");
		if(requiredField != null)
			dto.setRequiredField(requiredField.longValue());
		
		BigDecimal fieldType = (BigDecimal)rs.get("field_type");
		if(fieldType != null)
			dto.setFieldType(fieldType.longValue());
		
		dto.setInstructionText((String)rs.get("instruction_text"));
		dto.setFieldFormat((String)rs.get("field_format"));
		
		BigDecimal protectedField= (BigDecimal)rs.get("protected_field");
		if(protectedField != null)
			dto.setProtectedField(protectedField.longValue());
		
		return dto;
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
