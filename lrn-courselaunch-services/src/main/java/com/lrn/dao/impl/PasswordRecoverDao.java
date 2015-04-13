package com.lrn.dao.impl;

import com.lrn.dao.IPasswordRecoverDao;
import com.lrn.model.hibernate.PasswordRecover;

/**
 * The Class PasswordRecoverDao.
 *
 * @author kishor.pawar
 */
public class PasswordRecoverDao extends GenericDao<PasswordRecover, String> implements
		IPasswordRecoverDao {

	public PasswordRecoverDao(Class<PasswordRecover> persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	}

}
