package com.lrn.dao.impl;

import java.util.List;

import com.lrn.dao.IRsaKeysDao;
import com.lrn.model.hibernate.RsaKeys;

/**
 * The Class RsaKeysDao.
 *
 * @author kishor.pawar
 */
public class RsaKeysDao extends GenericDao<RsaKeys, Long> implements IRsaKeysDao {
	
	public RsaKeysDao(Class<RsaKeys> persistentClass) {
		super(persistentClass);
	}

	@Override
	public List<RsaKeys> getRsaKeysBySiteIdAndType(Long siteId,
			String type) {
		String[] paramNames = { "siteId", "type" };
		Object[] paramValues = { siteId, type };
		return findByNamedQuery("getRsaKeyBySiteIdAndType", paramNames, paramValues);
	}
}