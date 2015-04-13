/**
 * 
 */
package com.lrn.manager;

import java.sql.Timestamp;
import java.util.List;

import com.lrn.dto.course.CourseLookupEditionDTO;
import com.lrn.model.course.CourseLookup;
import com.lrn.model.spring.service.response.LRNResponse;


/**
 * @author sreenivas.k
 *
 */
public interface ICourseLookupManager extends IGenericManager<CourseLookup, String> {

	List<CourseLookup> getCourseLookupByCatalogId(String catalogId);

	List<CourseLookup> getCourseLookupByModuleIds(List<Long> moduleIds);
	
	/**
	 * Check to see if the user has ever taken a course
	 * @param userId
	 * @param siteId
	 * @param systemId
	 * @return
	 */
	public boolean hasUserTakenModule(String userId, Long siteId, String systemId);
	
	/**
	 * Return the CourseLookup, Module & Edition data for the requested systemId
	 * @param systemId
	 * @return List of CourseLookupEditionDTO
	 */
	public List<CourseLookupEditionDTO> getCourseLookupAndEditionFromSystemId(String systemId);
	
	/**
	 * Return the catalogId for the requested systemId
	 * @param systemId
	 * @return CatalogId
	 */
	public String getCatalogIdFromSystemId(String systemId);
	
	/**
	 * Return the moduleId for the requested systemId
	 * @param systemId
	 * @return moduleId
	 */
	public Long getModuleIdFromSystemId(String systemId);

	/**
	 * Check if the Drives Out of range for the specified input params
	 * @param userId
	 * @param siteId
	 * @param moduleId
	 * @param exemptionDate
	 * @param startDate
	 * @param userCreationDate
	 * @return 0 or 1
	 */
	public LRNResponse hasDrivesOutOfRange(String userId, Long siteId, Long moduleId, Timestamp exemptionDate, Timestamp startDate, Timestamp
			userCreationDate);

	CourseLookup getCourseLookupByCourse(Long course);
}
