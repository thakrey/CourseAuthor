package com.lrn.manager.impl.custom;

import java.util.List;

import com.lrn.dao.IGenericDao;
import com.lrn.dao.custom.ICustomSectionsDao;
import com.lrn.manager.custom.ICustomSectionsManager;
import com.lrn.manager.impl.GenericManager;
import com.lrn.model.hibernate.custom.CustomSections;

/**
 * The Class CustomSectionsManager
 * 
 * @author kishor.pawar
 */
public class CustomSectionsManager extends GenericManager<CustomSections, Long> implements
		ICustomSectionsManager {
	
	private ICustomSectionsDao customSectionsDao;
	
	public CustomSectionsManager(IGenericDao<CustomSections, Long> iGenericDao) {
		super(iGenericDao);
	}

	/**
	 * @param customSectionsDao the customSectionsDao to set
	 */
	public void setCustomSectionsDao(ICustomSectionsDao customSectionsDao) {
		this.customSectionsDao = customSectionsDao;
	}

	@Override
	public List<CustomSections> getCustomSection(String company,
			String customSectionLocation, String customSectionName,
			String customPublishesProfileValue) {
		return customSectionsDao.getCustomSection(company, customSectionLocation, 
				customSectionName, customPublishesProfileValue);
	}
}