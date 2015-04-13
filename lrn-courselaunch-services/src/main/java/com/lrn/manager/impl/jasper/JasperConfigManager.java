package com.lrn.manager.impl.jasper;

import java.util.List;

import com.lrn.dao.IGenericDao;
import com.lrn.dao.jasper.IJasperConfigDao;
import com.lrn.manager.impl.GenericManager;
import com.lrn.manager.jasper.IJasperConfigManager;
import com.lrn.model.hibernate.jasper.JasperConfig;

/**
 * The Class JasperConfigManager
 * 
 * @author kishor.pawar
 *
 */
public class JasperConfigManager extends GenericManager<JasperConfig, Long> implements
		IJasperConfigManager {
	
	private IJasperConfigDao jasperConfigDao;
	
	public JasperConfigManager(IGenericDao<JasperConfig, Long> iGenericDao) {
		super(iGenericDao);
	}

	/**
	 * @param jasperConfigDao the jasperConfigDao to set
	 */
	public void setJasperConfigDao(IJasperConfigDao jasperConfigDao) {
		this.jasperConfigDao = jasperConfigDao;
	}
	
	@Override
	public List<JasperConfig> getJasperConfigsByTypeIdSiteIdAndModuleIds(List<Long> moduleIds, Long typeId, Long siteId) {
		String[] paramNames = {"moduleIds", "jasperConfigTypeId", "siteId"};
		Object[] paramValues = {moduleIds, typeId, siteId};
		return jasperConfigDao.findByNamedQuery("findJasperConfigByTypeIdSiteIdAndModuleIds", paramNames, paramValues);		
	}

}