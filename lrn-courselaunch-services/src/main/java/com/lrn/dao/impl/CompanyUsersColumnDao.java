package com.lrn.dao.impl;

import java.util.List;

import com.lrn.dao.ICompanyUsersColumnDao;
import com.lrn.model.hibernate.CompanyUsersColumn;
import com.lrn.model.hibernate.CompanyUsersColumnPK;

/**
 * The Class CompanyUsersColumnDao.
 *
 * @author kishor.pawar
 */
public class CompanyUsersColumnDao extends GenericDao<CompanyUsersColumn, CompanyUsersColumnPK> implements
		ICompanyUsersColumnDao {

	/**
	 * Instantiates a new company users column dao.
	 *
	 * @param persistentClass the persistent class
	 */
	public CompanyUsersColumnDao(Class<CompanyUsersColumn> persistentClass) {
		super(persistentClass);
	}

	@Override
	public List<CompanyUsersColumn> getCompanyUsersColumnByCompany(String company) {
		String[] paramNames = { "company" };
		Object[] paramValues = { company };
		return findByNamedQuery("getCompanyUsersColumnByCompany", paramNames, paramValues);
	}
}