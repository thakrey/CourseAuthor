package com.lrn.dao;

import java.util.List;

import com.lrn.model.hibernate.CompanyUsersColumn;
import com.lrn.model.hibernate.CompanyUsersColumnPK;

/**
 * The Interface ICompanyUsersColumnDao.
 *
 * @author kishor.pawar
 */
public interface ICompanyUsersColumnDao extends IGenericDao<CompanyUsersColumn, CompanyUsersColumnPK> {

	/**
     * Gets list of CompanyUsersColumn by siteId and columnName.
     *
     * @param String company
     * 
     * @return List<CompanyUsersColumn>
     */
	List<CompanyUsersColumn> getCompanyUsersColumnByCompany(String company);
}
