package com.lrn.manager.impl.user;

import com.lrn.dao.IGenericDao;
import com.lrn.dao.user.IUserSurveyModuleDao;
import com.lrn.manager.impl.GenericManager;
import com.lrn.manager.user.IUserSurveyModuleManager;
import com.lrn.model.hibernate.user.UserSurveyModule;

/**
 * The Class UserSurveyModuleManager
 * 
 * @author kishor.pawar
 */
public class UserSurveyModuleManager extends GenericManager<UserSurveyModule, Long> implements
		IUserSurveyModuleManager {
	
	private IUserSurveyModuleDao userSurveyModuleDao;

	public UserSurveyModuleManager(
			IGenericDao<UserSurveyModule, Long> iGenericDao) {
		super(iGenericDao);
	}

	/**
	 * @param userSurveyModuleDao the userSurveyModuleDao to set
	 */
	public void setUserSurveyModuleDao(IUserSurveyModuleDao userSurveyModuleDao) {
		this.userSurveyModuleDao = userSurveyModuleDao;
	}
}