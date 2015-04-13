package com.lrn.manager;

import java.util.List;

import com.lrn.model.hibernate.CompanyUsersColumn;
import com.lrn.model.hibernate.CompanyUsersColumnPK;

/**
 * The Interface ICompanyUsersColumnManager.
 */
public interface ICompanyUsersColumnManager extends IGenericManager<CompanyUsersColumn, CompanyUsersColumnPK> {

	/**
     * Gets list of CompanyUsersColumn by siteId and columnName.
     *
     * @param String company
     * 
     * @return List<CompanyUsersColumn>
     */
	List<CompanyUsersColumn> getCompanyUsersColumnByCompany(String company);
}