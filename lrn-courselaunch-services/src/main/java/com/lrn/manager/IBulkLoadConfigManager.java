/**
 * 
 */
package com.lrn.manager;

import java.util.List;

import com.lrn.model.lcecbulk.BulkLoadConfig;
import com.lrn.model.lcecbulk.BulkLoadConfigPK;

/**
 * 
 *
 */
public interface IBulkLoadConfigManager extends IGenericManager<BulkLoadConfig, BulkLoadConfigPK> {
	
	public List<BulkLoadConfig> getCustomColumnConfigByCompany(String company);

}
