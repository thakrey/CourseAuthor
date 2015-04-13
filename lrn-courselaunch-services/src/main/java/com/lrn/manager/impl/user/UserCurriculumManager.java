package com.lrn.manager.impl.user;

import java.util.List;

import com.lrn.dao.IGenericDao;
import com.lrn.dao.user.IUserCurriculumDao;
import com.lrn.manager.impl.GenericManager;
import com.lrn.manager.user.IUserCurriculumManager;
import com.lrn.model.hibernate.user.UserCurriculum;
import com.lrn.model.hibernate.user.UserCurriculumPK;

/**
 * The Class UserCurriculumManager
 * 
 * 
 */
public class UserCurriculumManager extends GenericManager<UserCurriculum, UserCurriculumPK> implements
		IUserCurriculumManager {

	private IUserCurriculumDao userCurriculumDao;

	public void setUserCurriculumDao(IUserCurriculumDao userCurriculumDao) {
		this.userCurriculumDao = userCurriculumDao;
	}

	public UserCurriculumManager(
			IGenericDao<UserCurriculum, UserCurriculumPK> iGenericDao) {
		super(iGenericDao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<UserCurriculum> getUserCurriculumsByUserId(String userId) {
		String[] paramNames = { "userId" };
		Object[] paramValues = { userId };
		return (List<UserCurriculum>) userCurriculumDao.findByNamedQuery(
				"getUserCurriculumsByUserId", paramNames, paramValues);
	}
}