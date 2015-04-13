package com.lrn.manager.impl.user;

import com.lrn.dao.IGenericDao;
import com.lrn.dao.impl.user.UserCustomColumnsDao;
import com.lrn.manager.impl.GenericManager;
import com.lrn.manager.user.IUserCustomColumnsManager;
import com.lrn.model.hibernate.user.UserCustomColumns;

/**
 * The Class UserCustomColumnsManager
 * 
 * @author kishor.pawar
 */
public class UserCustomColumnsManager extends GenericManager<UserCustomColumns, String> implements
		IUserCustomColumnsManager {

	private UserCustomColumnsDao userCustomColumnsDao;
		
	public UserCustomColumnsManager(
			IGenericDao<UserCustomColumns, String> iGenericDao) {
		super(iGenericDao);
	}

	/**
	 * @param userCustomColumnsDao the userCustomColumnsDao to set
	 */
	public void setUserCustomColumnsDao(UserCustomColumnsDao userCustomColumnsDao) {
		this.userCustomColumnsDao = userCustomColumnsDao;
	}
}