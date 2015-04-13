package com.lrn.dao.impl;

import java.util.List;

import com.lrn.dao.ICourseLookupDao;
import com.lrn.model.hibernate.CourseLookup;

/**
 * The Class CourseLookupDao.
 *
 * @author kishor.pawar
 */
public class CourseLookupDao extends GenericDao<CourseLookup, String> implements
		ICourseLookupDao {

	public CourseLookupDao(Class<CourseLookup> persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<CourseLookup> getCourseLookupByCatalogId(String catalogId) {
		String[] paramNames = { "catalogId" };
		Object[] paramValues = { catalogId };
		return findByNamedQuery("findCourseLookupByCatalogId", 
				paramNames, paramValues);
	}
}
