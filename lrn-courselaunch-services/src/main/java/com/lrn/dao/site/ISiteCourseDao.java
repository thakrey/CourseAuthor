package com.lrn.dao.site;

import java.util.List;

import com.lrn.dao.IGenericDao;
import com.lrn.model.hibernate.site.SiteCourse;

/**
 * Interface ISiteCourseDao
 *
 * @author kishor.pawar
 */
public interface ISiteCourseDao extends IGenericDao<SiteCourse, Long> {

	/**
	 * Return CourseLookup
	 * @param siteId
	 * @param catalogIds
	 * @return
	 */
	List<SiteCourse> getCourseLookupByCatalogIds(Long siteId, List<String> catalogIds);

	/**
	 * Get Site Course
	 * @param siteId
	 * @param systemId
	 * @return
	 */
	List<SiteCourse> getSiteCourseBySiteIdAndSystemId(Long siteId, String systemId);

	/**
	 * Get Course Lookup By Module
	 * @param siteId
	 * @param moduleIds
	 * @return
	 */
	List<SiteCourse> getCourseLookupByModuleIds(Long siteId,List<Long> moduleIds);
	
}
