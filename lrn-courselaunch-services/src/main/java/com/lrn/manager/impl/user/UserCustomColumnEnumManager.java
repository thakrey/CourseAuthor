package com.lrn.manager.impl.user;

import com.lrn.dao.IGenericDao;
import com.lrn.dao.user.IUserCustomColumnEnumDao;
import com.lrn.manager.impl.GenericManager;
import com.lrn.manager.user.IUserCustomColumnEnumManager;
import com.lrn.model.hibernate.user.UserCustomColumnEnum;

/**
 * The Class UserCustomColumnEnumManager
 * 
 * @author kishor.pawar
 */
public class UserCustomColumnEnumManager extends GenericManager<UserCustomColumnEnum, Long> implements
		IUserCustomColumnEnumManager {

	private IUserCustomColumnEnumDao userCustomColumnEnumDao;
	
	/**
	 * @param UserCustomColumnEnumDao the UserCustomColumnEnumDao to set
	 */
	public void setUserCustomColumnEnumDao(IUserCustomColumnEnumDao userCustomColumnEnumDao) {
		this.userCustomColumnEnumDao = userCustomColumnEnumDao;
	}

	public UserCustomColumnEnumManager(IGenericDao<UserCustomColumnEnum, Long> iGenericDao) {
		super(iGenericDao);
	}
}