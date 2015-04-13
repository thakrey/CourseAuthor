package com.lrn.dao;

import java.util.List;

import com.lrn.model.hibernate.CourseLookup;

/**
 * 
 * Interface ICourseLookupDao
 * 
 * @author kishor.pawar
 */
public interface ICourseLookupDao extends IGenericDao<CourseLookup, String> {
		
	/**
     * Gets CourseLookup by catalogId
     *
     * @param String catalogId
     * 
     * @return List<CourseLookup>
     */
	List<CourseLookup> getCourseLookupByCatalogId(String catalogId);
}