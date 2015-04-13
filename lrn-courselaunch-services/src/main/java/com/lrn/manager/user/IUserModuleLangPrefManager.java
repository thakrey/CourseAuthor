package com.lrn.manager.user;

import java.util.List;

import com.lrn.dao.user.IUserModuleLangPrefDao;
import com.lrn.manager.IGenericManager;
import com.lrn.model.hibernate.user.UserModuleLangPref;

/**
 * The Interface IUserModuleLangPrefManager
 */
public interface IUserModuleLangPrefManager extends IGenericManager<UserModuleLangPref, Long> {

	/**
	 * Returns List of UseroduleLangPref by userid, site and moduleId.
	 *
	 * @param String userId
	 * @param Long siteId
	 * @param Long moduleId
	 * 
	 * @return List<UserModuleLangPref>
	 */
	List<UserModuleLangPref> getUserModuleLangPref(String userId, Long siteId, Long moduleId);
	
	public void setUserModuleLangPrefDao(IUserModuleLangPrefDao userModuleLangPrefDao);
}