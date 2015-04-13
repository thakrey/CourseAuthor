package com.lrn.manager.impl;

import java.util.List;

import com.lrn.dao.IGenericDao;
import com.lrn.dao.IRsaKeysDao;
import com.lrn.manager.IRsaKeysManager;
import com.lrn.model.hibernate.RsaKeys;

/**
 * The Class RsaKeysManager.
 *
 * @author kishor.pawar
 */
public class RsaKeysManager extends GenericManager<RsaKeys, Long> implements
		IRsaKeysManager {

private IRsaKeysDao rsaKeysDao;
	
	public RsaKeysManager(IGenericDao<RsaKeys, Long> iGenericDao) {
		super(iGenericDao);
	}

	@Override
	public void setRsaKeysDao(IRsaKeysDao rsaKeysDao) {
		this.rsaKeysDao = rsaKeysDao;
	}

	@Override
	public List<RsaKeys> getRsaKeysBySiteId(Long siteId) {
		String[] paramNames = { "siteId" };
		Object[] paramValues = { siteId }; 
		List<RsaKeys> list = rsaKeysDao.findByNamedQuery("findRsaKeysBySiteId", paramNames, paramValues);
		return list;
	}


}