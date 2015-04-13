package com.lrn.manager.impl.custom;

import java.util.List;

import com.lrn.dao.IGenericDao;
import com.lrn.dao.custom.ICustomStringDao;
import com.lrn.manager.custom.ICustomStringManager;
import com.lrn.manager.impl.GenericManager;
import com.lrn.model.hibernate.custom.CustomString;

/**
 * The Class CustomStringManager
 * 
 * @author kishor.pawar
 */
public class CustomStringManager extends GenericManager<CustomString, Long> implements
		ICustomStringManager {
	
	private ICustomStringDao customStringDao;
	
	public CustomStringManager(IGenericDao<CustomString, Long> iGenericDao) {
		super(iGenericDao);
	}

	/**
	 * @param customStringDao the customStringDao to set
	 */
	public void setCustomStringDao(ICustomStringDao customStringDao) {
		this.customStringDao = customStringDao;
	}

	@Override
	public List<CustomString> getCustomStringByCompanyAndProfileValue(String company, 
			String profileValue) {
		return customStringDao.getCustomStringByCompanyAndProfileValue(company, 
				profileValue);
	}
}