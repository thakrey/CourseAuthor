package com.lrn.manager.jasper;

import java.util.List;

import com.lrn.manager.IGenericManager;
import com.lrn.model.hibernate.jasper.JasperConfig;

/**
 * The Interface IJasperConfigManager
 * 
 * @author kishor.pawar
 *
 */
public interface IJasperConfigManager extends IGenericManager<JasperConfig, Long> {

	/**
	 * Get Jasper Configs
	 * @param moduleIds
	 * @param l
	 * @param siteId
	 * @return
	 */
	List<JasperConfig> getJasperConfigsByTypeIdSiteIdAndModuleIds(
			List<Long> moduleIds, Long l, Long siteId);

}
