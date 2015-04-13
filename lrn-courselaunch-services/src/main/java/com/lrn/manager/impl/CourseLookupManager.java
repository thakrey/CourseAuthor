/**
 * 
 */
package com.lrn.manager.impl;

import java.sql.Timestamp;
import java.util.List;

import com.lrn.dao.ICourseLookupDao;
import com.lrn.dao.IGenericDao;
import com.lrn.dto.course.CourseLookupEditionDTO;
import com.lrn.manager.ICourseLookupManager;
import com.lrn.model.course.CourseLookup;
import com.lrn.model.spring.service.response.LRNResponse;



/**
 * @author sreenivas.k
 *
 */
public class CourseLookupManager extends GenericManager<CourseLookup, String> implements
		ICourseLookupManager {

	private ICourseLookupDao courseLookupDao;
	
	public CourseLookupManager(IGenericDao<CourseLookup, String> iGenericDao) {
		super(iGenericDao);
		// TODO Auto-generated constructor stub
	}
	
	public void setCourseLookupDao (ICourseLookupDao courseLookupDao) {
		this.courseLookupDao = courseLookupDao;
	}

	@Override
	public List<CourseLookup> getCourseLookupByCatalogId(String catalogId) {
		/*String[] paramNames = {"catalogId"};
		Object[] paramValues = {catalogId};
		return courseLookupDao.findByNamedQuery("findCourseLookupByCatalogId", paramNames, paramValues);*/
		return null;
	}
	
	@Override
	public List<CourseLookup> getCourseLookupByModuleIds(List<Long> moduleIds) {
		String[] paramNames = {"moduleIds"};
		Object[] paramValues = {moduleIds};
		/*return courseLookupDao.findByNamedQuery("findCourseLookupByModuleIds", paramNames, paramValues);*/
		return null;
	}

	
	/**
	 * Check to see if the user has ever taken a course
	 * @param userId
	 * @param siteId
	 * @param systemId
	 * @return
	 */
	public boolean hasUserTakenModule(String userId, Long siteId, String systemId) {
		/*return courseLookupDao.hasUserTakenModule(userId, siteId, systemId);*/
		return false;
	}

	@Override
	public List<CourseLookupEditionDTO> getCourseLookupAndEditionFromSystemId(String systemId) {
		/*return courseLookupDao.getCourseLookupAndEditionFromSystemId(systemId);*/
		return null;
	}

	@Override
	public String getCatalogIdFromSystemId(String systemId) {
		/*return courseLookupDao.getCatalogIdFromSystemId(systemId);*/
		return null;
	}

	@Override
	public Long getModuleIdFromSystemId(String systemId) {
		/*return courseLookupDao.getModuleIdFromSystemId(systemId);*/
		return null;
	}

	@Override
	public LRNResponse hasDrivesOutOfRange(String userId, Long siteId, Long moduleId,
			Timestamp exemptionDate, Timestamp startDate, Timestamp userCreationDate) {
		/*return courseLookupDao.hasDrivesOutOfRange(userId, siteId, moduleId, exemptionDate, startDate, userCreationDate);*/
		return null;
	}

	@Override
	public CourseLookup getCourseLookupByCourse(Long course) {
		/*return courseLookupDao.getCourseLookupByCourse(course);*/
		return null;
	}
	
}
