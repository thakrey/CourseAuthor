/**
 * 
 */
package com.lrn.dao.impl;


import com.lrn.dao.IBulkLoadConfigDao;
import com.lrn.model.lcecbulk.BulkLoadConfig;
import com.lrn.model.lcecbulk.BulkLoadConfigPK;

/**
 * @author Bhramara.Mallavarapu
 *
 */
public class BulkLoadConfigDao extends GenericDao<BulkLoadConfig, BulkLoadConfigPK> implements
		IBulkLoadConfigDao {

	public BulkLoadConfigDao(Class<BulkLoadConfig> persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	}

}
