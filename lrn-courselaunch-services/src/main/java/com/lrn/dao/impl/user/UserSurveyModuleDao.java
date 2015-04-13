package com.lrn.dao.impl.user;

import com.lrn.dao.impl.GenericDao;
import com.lrn.dao.user.IUserSurveyModuleDao;
import com.lrn.model.hibernate.user.UserSurveyModule;

/**
 * The Class UserSurveyModuleDao.
 *
 * @author kishor.pawar
 */
public class UserSurveyModuleDao extends GenericDao<UserSurveyModule, Long> implements
		IUserSurveyModuleDao {

	public UserSurveyModuleDao(Class<UserSurveyModule> persistentClass) {
		super(persistentClass);
	}
}