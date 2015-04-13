package com.lrn.manager.impl;

import java.util.List;

import com.lrn.dao.ICompanyUsersColumnDao;
import com.lrn.dao.IGenericDao;
import com.lrn.manager.ICompanyUsersColumnManager;
import com.lrn.model.hibernate.CompanyUsersColumn;
import com.lrn.model.hibernate.CompanyUsersColumnPK;

/**
 * The Class CompanyUsersColumnManager.

 */
public class CompanyUsersColumnManager extends GenericManager<CompanyUsersColumn, CompanyUsersColumnPK> 
		implements ICompanyUsersColumnManager {

	private ICompanyUsersColumnDao companyUsersColumnDao;
	
	/**
	 * Instantiates a new company users column manager.
	 *
	 * @param iGenericDao the i generic dao
	 */
	public CompanyUsersColumnManager(
			IGenericDao<CompanyUsersColumn, CompanyUsersColumnPK> iGenericDao) {
		super(iGenericDao);
	}

	/**
	 * @param companyUsersColumnDao the companyUsersColumnDao to set
	 */
	public void setCompanyUsersColumnDao(
			ICompanyUsersColumnDao companyUsersColumnDao) {
		this.companyUsersColumnDao = companyUsersColumnDao;
	}

	@Override
	public List<CompanyUsersColumn> getCompanyUsersColumnByCompany(String company) {
		return companyUsersColumnDao.getCompanyUsersColumnByCompany(company);
	}
}