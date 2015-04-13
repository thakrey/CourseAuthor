package com.lrn.dao.custom;

import java.util.List;

import com.lrn.dao.IGenericDao;
import com.lrn.model.hibernate.custom.CustomSections;

/**
 * Interface ICustomSectionsDao
 * 
 * @author kishor.pawar
 */
public interface ICustomSectionsDao extends IGenericDao<CustomSections, Long> {
	
	/**
     * Gets list of CustomSections by company, customSectionLocation, customSectionName
     * and customPublishesProfileValue.
     *
     * @param String company
     * @param String customSectionLocation
     * @param String customSectionName
     * @param String customPublishesProfileValue
     * 
     * @return List<CustomSections>
     */
	List<CustomSections> getCustomSection(String company, String customSectionLocation, 
			String customSectionName, String customPublishesProfileValue);
}