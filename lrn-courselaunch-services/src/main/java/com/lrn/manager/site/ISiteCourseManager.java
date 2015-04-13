package com.lrn.manager.site;

import java.util.List;

import com.lrn.manager.IGenericManager;
import com.lrn.model.hibernate.site.SiteCourse;

/**
 * The Interface ISiteCourseManager
 * 
 * @author kishor.pawar
 */
public interface ISiteCourseManager extends IGenericManager<SiteCourse, Long> {

	/**
	 * Returns SiteCourse
	 * @param siteId
	 * @param catalogIds
	 * @return
	 */
	List<SiteCourse> getCourseLookupByCatalogIds(Long siteId,
			List<String> catalogIds);

	/**
	 * Returns Site Course
	 * @param siteId
	 * @param systemId
	 * @return
	 */
	List<SiteCourse> getSiteCourseBySiteIdAndSystemId(Long siteId,String systemId);

	/**
	 * Returns Course Lookup
	 * @param siteId
	 * @param moduleIds
	 * @return
	 */
	List<SiteCourse> getCourseLookupByModuleIds(Long siteId,List<Long> moduleIds);

}