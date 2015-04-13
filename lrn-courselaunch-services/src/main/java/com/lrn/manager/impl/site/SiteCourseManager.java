package com.lrn.manager.impl.site;

import java.util.List;

import com.lrn.dao.IGenericDao;
import com.lrn.dao.site.ISiteCourseDao;
import com.lrn.manager.impl.GenericManager;
import com.lrn.manager.site.ISiteCourseManager;
import com.lrn.model.hibernate.site.SiteCourse;

/**
 * The Class SiteCourseManager
 * 
 * @author kishor.pawar
 */
public class SiteCourseManager extends GenericManager<SiteCourse, Long> implements
		ISiteCourseManager {

	private ISiteCourseDao siteCourseDao;
	
	public SiteCourseManager(IGenericDao<SiteCourse, Long> iGenericDao) {
		super(iGenericDao);
	}

	/**
	 * @param siteCourseDao the siteCourseDao to set
	 */
	public void setSiteCourseDao(ISiteCourseDao siteCourseDao) {
		this.siteCourseDao = siteCourseDao;
	}

	@Override
	public List<SiteCourse> getCourseLookupByCatalogIds(Long siteId,
			List<String> catalogIds) {
		// TODO Auto-generated method stub
		return siteCourseDao.getCourseLookupByCatalogIds(siteId, catalogIds);
	}

	@Override
	public List<SiteCourse> getSiteCourseBySiteIdAndSystemId(Long siteId,
			String systemId) {
		return siteCourseDao.getSiteCourseBySiteIdAndSystemId(siteId, systemId);
	}

	@Override
	public List<SiteCourse> getCourseLookupByModuleIds(Long siteId,
			List<Long> moduleIds) {
		// TODO Auto-generated method stub
		return siteCourseDao.getCourseLookupByModuleIds(siteId, moduleIds);
	}
}