package com.lrn.dao.impl.custom;

import java.util.List;

import com.lrn.dao.custom.ICustomSectionsDao;
import com.lrn.dao.impl.GenericDao;
import com.lrn.model.hibernate.custom.CustomSections;

/**
 * The Class CustomSectionsDao.
 *
 * @author kishor.pawar
 */
public class CustomSectionsDao extends GenericDao<CustomSections, Long> implements
		ICustomSectionsDao {

	public CustomSectionsDao(Class<CustomSections> persistentClass) {
		super(persistentClass);
	}
	
	@Override
	public List<CustomSections> getCustomSection(String company, String customSectionLocation, 
			String customSectionName, String customPublishesProfileValue) {
		String[] paramNames = {"company", "location", "name", "profileValue"};
		Object[] paramValues = {company, customSectionLocation, customSectionName, 
				customPublishesProfileValue};
		return findByNamedQuery("getCustomSection", paramNames, paramValues);
	}
}