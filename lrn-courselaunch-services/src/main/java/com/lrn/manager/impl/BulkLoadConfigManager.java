/**
 * 
 */
package com.lrn.manager.impl;

import java.util.List;

import com.lrn.dao.IGenericDao;
import com.lrn.dao.impl.BulkLoadConfigDao;
import com.lrn.manager.IBulkLoadConfigManager;
import com.lrn.model.lcecbulk.BulkLoadConfig;
import com.lrn.model.lcecbulk.BulkLoadConfigPK;

/**
 * @author Bhramara.Mallavarapu
 *
 */
public class BulkLoadConfigManager extends GenericManager<BulkLoadConfig, BulkLoadConfigPK> implements
		IBulkLoadConfigManager {

	private BulkLoadConfigDao bulkLoadConfigDao;
	
	public BulkLoadConfigManager(IGenericDao<BulkLoadConfig, BulkLoadConfigPK> iGenericDao) {
		super(iGenericDao);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param bulkLoadConfigDao the bulkLoadConfigDao to set
	 */
	public void setBulkLoadConfigDao(BulkLoadConfigDao bulkLoadConfigDao) {
		this.bulkLoadConfigDao = bulkLoadConfigDao;
	}
	
	@Override
	public List<BulkLoadConfig> getCustomColumnConfigByCompany(String company) {
		String[] paramNames = { "company" };
		Object[] paramValues = { company };
		
		return iGenericDao.findByNamedQuery("findBulkLoadConfigByCompany", paramNames, paramValues);
		
	}

}
