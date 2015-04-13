package com.lrn.dao.impl.user;

import java.util.List;

import com.lrn.dao.impl.GenericDao;
import com.lrn.dao.user.IUserCurriculumDao;
import com.lrn.model.hibernate.user.UserCurriculum;
import com.lrn.model.hibernate.user.UserCurriculumPK;

/**
 * The Class UserCurriculumDao.
 *
 * @author kishor.pawar
 */
public class UserCurriculumDao extends GenericDao<UserCurriculum, UserCurriculumPK> implements
		IUserCurriculumDao {

	public UserCurriculumDao(Class<UserCurriculum> persistentClass) {
		super(persistentClass);
	}

	@Override
	public List<UserCurriculum> getUserCurriculumsByUserId(String userId) {
		String[] paramNames = { "userId" };
		Object[] paramValues = { userId };
		return findByNamedQuery("getUserCurriculumsByUserId", paramNames, paramValues);
	}
}