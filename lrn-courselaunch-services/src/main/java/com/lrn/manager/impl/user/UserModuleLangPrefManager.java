package com.lrn.manager.impl.user;

import java.util.List;

import com.lrn.dao.IGenericDao;
import com.lrn.dao.user.IUserModuleLangPrefDao;
import com.lrn.manager.impl.GenericManager;
import com.lrn.manager.user.IUserModuleLangPrefManager;
import com.lrn.model.hibernate.user.UserModuleLangPref;

/**
 * The Class UserModuleLangPrefManager.
 *
 * @author kishor.pawar
 */
public class UserModuleLangPrefManager extends GenericManager<UserModuleLangPref, Long> 
				implements IUserModuleLangPrefManager {	

	private IUserModuleLangPrefDao userModuleLangPrefDao;
	
	public UserModuleLangPrefManager(IGenericDao<UserModuleLangPref, Long> iGenericDao) {
		super(iGenericDao);
	}

	/**
	 * @param userModuleLangPrefDao the userModuleLangPrefDao to set
	 */
	public void setUserModuleLangPrefDao(
			IUserModuleLangPrefDao userModuleLangPrefDao) {
		this.userModuleLangPrefDao = userModuleLangPrefDao;
	}
	
	@Override
	public List<UserModuleLangPref> getUserModuleLangPref(String userId, Long siteId, Long moduleId) {
		return userModuleLangPrefDao.getUserModuleLangPref(userId, siteId, moduleId);
	}
}