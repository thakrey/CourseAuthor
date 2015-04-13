package com.lrn.dao.impl;

import com.lrn.dao.IRsaKeysTypeDao;
import com.lrn.model.hibernate.RsaKeysType;

/**
 * The Class RsaKeysDao.
 *
 * @author kishor.pawar
 */
public class RsaKeysTypeDao extends GenericDao<RsaKeysType, Long> implements IRsaKeysTypeDao {
	
	public RsaKeysTypeDao(Class<RsaKeysType> persistentClass) {
		super(persistentClass);
	}
}