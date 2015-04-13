package com.lrn.dao.impl.site;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.lrn.dao.impl.GenericDao;
import com.lrn.dao.site.ISiteCourseDao;
import com.lrn.model.hibernate.CourseLookup;
import com.lrn.model.hibernate.module.Module;
import com.lrn.model.hibernate.site.SiteCourse;

/**
 * The Class SiteCourseDao.
 *
 * @author kishor.pawar
 */
public class SiteCourseDao extends GenericDao<SiteCourse, Long> implements ISiteCourseDao {

	public SiteCourseDao(Class<SiteCourse> persistentClass) {
		super(persistentClass);
	}

	@Override
	public List<SiteCourse> getCourseLookupByCatalogIds(Long siteId, List<String> catalogIds) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select sc.site_id as sc_site_id, sc.system_id as sc_system_id, sc.created as sc_created, sc.module_id as sc_module_id, sc.language as sc_language,");
		queryBuilder.append("sc.available_to_learners as sc_available_to_learners, sc.available_in_catalog as sc_available_in_catalog, sc.id as sc_id,");
		queryBuilder.append("cl.system_id as cl_system_id, cl.node_id as cl_node_id, cl.course as cl_course, cl.catalog_id as cl_catalog_id, cl.course_short_name as cl_course_short_name,");
		queryBuilder.append("cl.title as cl_title, cl.description as cl_description, cl.app_type as cl_app_type, cl.course_path as cl_course_path, cl.language as cl_language,");
		queryBuilder.append("cl.version as cl_version, cl.core_vendor as cl_core_vendor, cl.media as cl_media, cl.module_id as cl_module_id, cl.is_library as cl_is_library, cl.created as cl_created,");
		queryBuilder.append("cl.templates as cl_templates, cl.documents as cl_documents, cl.record_quiz as cl_record_quiz, cl.copyright_year as cl_copyright_year, cl.vendor as cl_vendor, cl.edition_id as cl_edition_id,");
		queryBuilder.append("cl.availability as cl_availability, cl.updated as cl_updated, cl.content_size as content_size, ");
		queryBuilder.append("(case when (cl.course_img_url is not null) then (cl.course_img_url) else (select image_url from course_category cc where cc.id = cl.course_category_id) end) as cl_course_img_url, ");
		queryBuilder.append("m.id as m_id, m.base_catalog_id as m_base_catalog_id, m.created as m_created");
		queryBuilder.append(" from site_course sc, course_lookup cl, module m where sc.system_id = cl.system_id and cl.module_id = m.id");
		queryBuilder.append(" and site_id = ").append(siteId);
		String catalogIdsList = getInParamString(catalogIds); 
		queryBuilder.append(" and cl.catalog_id in (").append(catalogIdsList).append(")");

		Iterator<Map<String, Object>> itr = findBySqlQuery(queryBuilder.toString());
		
		List<SiteCourse> list = new ArrayList<SiteCourse>();
		while (itr.hasNext()) {
			Map<String, Object> resultMap = itr.next();
			SiteCourse sc = constructSiteCourseFromMap(resultMap);
			list.add(sc);
		}
		return list;
	}
	
	private SiteCourse constructSiteCourseFromMap(Map <String, Object> resultMap) {
		SiteCourse sc = new SiteCourse();
		sc.setId(((BigDecimal) resultMap.get("sc_id")).longValue());
		sc.setSiteId(((BigDecimal) resultMap.get("sc_site_id")).longValue());
		sc.setModuleId(((BigDecimal) resultMap.get("sc_module_id")).longValue());
		sc.setAvailableInCatalog(((BigDecimal) resultMap.get("sc_available_in_catalog")).longValue());
		sc.setAvailableToLearners(((BigDecimal) resultMap.get("sc_available_to_learners")).longValue());
		sc.setCreated((Date) resultMap.get("sc_created"));
		sc.setLanguage((String) resultMap.get("sc_language"));
		
		CourseLookup cl = new CourseLookup();
		cl.setSystemId((String) resultMap.get("cl_system_id"));
		BigDecimal nodeId = (BigDecimal) resultMap.get("cl_node_id");
		if(nodeId != null)
			cl.setNodeId(nodeId.longValue());
		BigDecimal course = (BigDecimal) resultMap.get("cl_course");
		if(course != null)
			cl.setCourse(course.longValue());
		cl.setCatalogId((String) resultMap.get("cl_catalog_id"));
		cl.setCourseShortName((String) resultMap.get("cl_course_short_name"));
		cl.setTitle((String) resultMap.get("cl_title"));
		cl.setDescription((String) resultMap.get("cl_description"));
		cl.setAppType((String) resultMap.get("cl_app_type"));
		cl.setCoursePath((String) resultMap.get("cl_course_path"));
		cl.setLanguage((String) resultMap.get("cl_language"));
		cl.setVersion((String) resultMap.get("cl_version"));
		cl.setMedia((String) resultMap.get("cl_media"));
		cl.setCoreVendor((String) resultMap.get("cl_core_vendor"));
		BigDecimal isLibrary = (BigDecimal) resultMap.get("cl_is_library");
		if(isLibrary != null)
			cl.setIsLibrary(isLibrary.longValue());
		cl.setCreated((Date) resultMap.get("cl_created"));
		cl.setTemplates((String) resultMap.get("cl_templates"));
		cl.setDocuments((String) resultMap.get("cl_documents"));
		cl.setRecordQuiz(((BigDecimal) resultMap.get("cl_record_quiz")).longValue());
		BigDecimal copyrightYear = (BigDecimal) resultMap.get("cl_copyright_year");
		if(copyrightYear != null)
			cl.setCopyrightYear(copyrightYear.longValue());

		cl.setVendor((String) resultMap.get("cl_vendor"));
		cl.setEditionId(((BigDecimal) resultMap.get("cl_edition_id")).longValue());
		cl.setAvailability(((BigDecimal) resultMap.get("cl_availability")).longValue());
		cl.setUpdated((Date) resultMap.get("cl_updated"));
		cl.setCourseImgUrl((String) resultMap.get("cl_course_img_url"));
		BigDecimal contentSize = (BigDecimal) resultMap.get("content_size");
		if(contentSize != null) {
			cl.setContentSize(contentSize.longValue());
		}		
		Module m = new Module();
		m.setId(((BigDecimal) resultMap.get("m_id")).longValue());
		m.setBaseCatalogId((String) resultMap.get("m_base_catalog_id"));
		m.setCreated((Date) resultMap.get("m_created"));
		cl.setModule(m);
		
		sc.setCourseLookup(cl);

		return sc;
	}
	
	/**
	 * Constructs comma separated string used at query from list
	 *
	 * @param List<Long> ids
	 * 
	 * @return String
	 */
	private String getInParamString(List<String> ids) {
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

	@Override
	public List<SiteCourse> getSiteCourseBySiteIdAndSystemId(Long siteId,
			String systemId) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select sc.site_id as sc_site_id, sc.system_id as sc_system_id, sc.created as sc_created, sc.module_id as sc_module_id, sc.language as sc_language,");
		queryBuilder.append("sc.available_to_learners as sc_available_to_learners, sc.available_in_catalog as sc_available_in_catalog, sc.id as sc_id,");
		queryBuilder.append("cl.system_id as cl_system_id, cl.node_id as cl_node_id, cl.course as cl_course, cl.catalog_id as cl_catalog_id, cl.course_short_name as cl_course_short_name,");
		queryBuilder.append("cl.title as cl_title, cl.description as cl_description, cl.app_type as cl_app_type, cl.course_path as cl_course_path, cl.language as cl_language,");
		queryBuilder.append("cl.version as cl_version, cl.core_vendor as cl_core_vendor, cl.media as cl_media, cl.module_id as cl_module_id, cl.is_library as cl_is_library, cl.created as cl_created,");
		queryBuilder.append("cl.templates as cl_templates, cl.documents as cl_documents, cl.record_quiz as cl_record_quiz, cl.copyright_year as cl_copyright_year, cl.vendor as cl_vendor, cl.edition_id as cl_edition_id,");
		queryBuilder.append("cl.availability as cl_availability, cl.updated as cl_updated, cl.content_size as content_size, ");
		queryBuilder.append("(case when (cl.course_img_url is not null) then (cl.course_img_url) else (select image_url from course_category cc where cc.id = cl.course_category_id) end) as cl_course_img_url, ");
		queryBuilder.append("m.id as m_id, m.base_catalog_id as m_base_catalog_id, m.created as m_created");
		queryBuilder.append(" from site_course sc, course_lookup cl, module m where sc.system_id = cl.system_id and cl.module_id = m.id");
		queryBuilder.append(" and site_id = ").append(siteId);
		queryBuilder.append(" and cl.system_id = '").append(systemId).append("'");

		Iterator<Map<String, Object>> itr = findBySqlQuery(queryBuilder.toString());
		
		List<SiteCourse> list = new ArrayList<SiteCourse>();
		while (itr.hasNext()) {
			Map<String, Object> resultMap = itr.next();
			SiteCourse sc = constructSiteCourseFromMap(resultMap);
			list.add(sc);
		}
		return list;
	}

	@Override
	public List<SiteCourse> getCourseLookupByModuleIds(Long siteId,
			List<Long> moduleIds) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select sc.site_id as sc_site_id, sc.system_id as sc_system_id, sc.created as sc_created, sc.module_id as sc_module_id, sc.language as sc_language,");
		queryBuilder.append("sc.available_to_learners as sc_available_to_learners, sc.available_in_catalog as sc_available_in_catalog, sc.id as sc_id,");
		queryBuilder.append("cl.system_id as cl_system_id, cl.node_id as cl_node_id, cl.course as cl_course, cl.catalog_id as cl_catalog_id, cl.course_short_name as cl_course_short_name,");
		queryBuilder.append("cl.title as cl_title, cl.description as cl_description, cl.app_type as cl_app_type, cl.course_path as cl_course_path, cl.language as cl_language,");
		queryBuilder.append("cl.version as cl_version, cl.core_vendor as cl_core_vendor, cl.media as cl_media, cl.module_id as cl_module_id, cl.is_library as cl_is_library, cl.created as cl_created,");
		queryBuilder.append("cl.templates as cl_templates, cl.documents as cl_documents, cl.record_quiz as cl_record_quiz, cl.copyright_year as cl_copyright_year, cl.vendor as cl_vendor, cl.edition_id as cl_edition_id,");
		queryBuilder.append("cl.availability as cl_availability, cl.updated as cl_updated, cl.content_size as content_size, ");
		queryBuilder.append("(case when (cl.course_img_url is not null) then (cl.course_img_url) else (select image_url from course_category cc where cc.id = cl.course_category_id) end) as cl_course_img_url, ");
		queryBuilder.append("m.id as m_id, m.base_catalog_id as m_base_catalog_id, m.created as m_created");
		queryBuilder.append(" from site_course sc, course_lookup cl, module m where sc.system_id = cl.system_id and cl.module_id = m.id");
		queryBuilder.append(" and site_id = ").append(siteId);
		String moduleIdsList = getInParamLong(moduleIds); 
		queryBuilder.append(" and cl.module_id in (").append(moduleIdsList).append(")");

		Iterator<Map<String, Object>> itr = findBySqlQuery(queryBuilder.toString());
		
		List<SiteCourse> list = new ArrayList<SiteCourse>();
		while (itr.hasNext()) {
			Map<String, Object> resultMap = itr.next();
			SiteCourse sc = constructSiteCourseFromMap(resultMap);
			list.add(sc);
		}
		return list;
	}
	
	/**
	 * Constructs comma separated string used at query from list
	 *
	 * @param List<Long> ids
	 * 
	 * @return String
	 */
	private String getInParamLong(List<Long> ids) {
		StringBuilder queryBuilder = new StringBuilder();
		int counter = 0;
		for(Long id : ids) {
			if(counter == 0) {
				queryBuilder.append(id);
			} else {
				queryBuilder.append(", ").append(id);
			}
			counter++;
		}
		return queryBuilder.toString();
	}
}