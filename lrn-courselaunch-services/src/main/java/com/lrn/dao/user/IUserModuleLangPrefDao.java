package com.lrn.dao.user;

import java.util.List;

import com.lrn.dao.IGenericDao;
import com.lrn.model.hibernate.user.UserModuleLangPref;

/**
 * The Interface IUserModuleLangPrefDao.
 *
 * @author kishor.pawar
 */
public interface IUserModuleLangPrefDao extends IGenericDao<UserModuleLangPref, Long>  {

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
}
