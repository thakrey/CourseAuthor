package com.lrn.manager.impl;

import com.lrn.dao.IGenericDao;
import com.lrn.dao.IRsaKeysTypeDao;
import com.lrn.manager.IRsaKeysTypeManager;
import com.lrn.model.hibernate.RsaKeysType;

/**
 * The Class RsaKeysTypeManager.
 *
 * @author kishor.pawar
 */
public class RsaKeysTypeManager extends GenericManager<RsaKeysType, Long> implements
		IRsaKeysTypeManager {

	private IRsaKeysTypeDao rsaKeysTypeDao;
	
	public RsaKeysTypeManager(IGenericDao<RsaKeysType, Long> iGenericDao) {
		super(iGenericDao);
	}
	
	/**
	 * @param rsaKeysTypeDao the rsaKeysTypeDao to set
	 */
	public void setRsaKeysTypeDao(IRsaKeysTypeDao rsaKeysTypeDao) {
		this.rsaKeysTypeDao = rsaKeysTypeDao;
	}
}