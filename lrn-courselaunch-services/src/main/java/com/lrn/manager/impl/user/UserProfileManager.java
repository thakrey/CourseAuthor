package com.lrn.manager.impl.user;

import com.lrn.dao.IGenericDao;
import com.lrn.dao.user.IUserDao;
import com.lrn.manager.impl.GenericManager;
import com.lrn.manager.user.IUserProfileManager;
import com.lrn.model.hibernate.user.User;

/**
 * The Class UserProfileManager
 * 
 * @author kishor.pawar
 */
public class UserProfileManager extends GenericManager<User, String> implements
		IUserProfileManager {

	private IUserDao userDao; 
	
	/**
	 * @param userDao the userDao to set
	 */
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	
	public UserProfileManager(IGenericDao<User, String> iGenericDao) {
		super(iGenericDao);
	}
}