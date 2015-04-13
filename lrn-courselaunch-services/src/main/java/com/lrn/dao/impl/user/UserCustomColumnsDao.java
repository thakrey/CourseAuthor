package com.lrn.dao.impl.user;

import com.lrn.dao.impl.GenericDao;
import com.lrn.dao.user.IUserCustomColumnsDao;
import com.lrn.model.hibernate.user.UserCustomColumns;

/**
 * The Class UserCustomColumnsDao.
 *
 * @author kishor.pawar
 */
public class UserCustomColumnsDao extends GenericDao<UserCustomColumns, String> implements
		IUserCustomColumnsDao {

	public UserCustomColumnsDao(Class<UserCustomColumns> persistentClass) {
		super(persistentClass);
	}
}