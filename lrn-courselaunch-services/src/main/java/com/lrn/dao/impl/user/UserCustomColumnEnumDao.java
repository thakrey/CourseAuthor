package com.lrn.dao.impl.user;

import com.lrn.dao.impl.GenericDao;
import com.lrn.dao.user.IUserCustomColumnEnumDao;
import com.lrn.model.hibernate.user.UserCustomColumnEnum;

/**
 * The Class UserCustomColumnEnumDao.
 *
 * @author kishor.pawar
 */
public class UserCustomColumnEnumDao extends GenericDao<UserCustomColumnEnum, Long> implements
		IUserCustomColumnEnumDao {

	public UserCustomColumnEnumDao(Class<UserCustomColumnEnum> persistentClass) {
		super(persistentClass);
	}
}