/**
 * 
 */
package com.lrn.manager.impl;

import org.apache.log4j.Logger;

import com.lrn.dao.IGenericDao;
import com.lrn.dao.ISrcModuleTemplateDao;
import com.lrn.manager.ISrcModuleTemplateManager;
import com.lrn.model.hibernate.SrcModuleTemplate;

/**
 * @author 
 *
 */
public class SrcModuleTemplateManager extends GenericManager<SrcModuleTemplate, Long> 
				implements ISrcModuleTemplateManager {

	private static final Logger logger = Logger.getLogger(SrcModuleTemplateManager.class);
	
	private ISrcModuleTemplateDao srcModuleTemplateDao;
	
	public SrcModuleTemplateManager(IGenericDao<SrcModuleTemplate, Long> iGenericDao) {
		super(iGenericDao);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param srcModuleTemplateDao the srcModuleTemplateDao to set
	 */
	public void setSrcModuleTemplateDao(ISrcModuleTemplateDao srcModuleTemplateDao) {
		this.srcModuleTemplateDao = srcModuleTemplateDao;
	}

	/**
	 * get the high priority template
	 * @param userId
	 * @param siteId
	 * @param systemId
	 * @return
	 */
	public String getTemplateByPrecedence(String template)  {
		return srcModuleTemplateDao.getTemplateByPrecedence(template);
	}
}
