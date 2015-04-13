package com.lrn.manager.custom;

import java.util.List;

import com.lrn.manager.IGenericManager;
import com.lrn.model.hibernate.custom.CustomSections;

/**
 * The Interface ICustomSectionsManager
 */
public interface ICustomSectionsManager extends IGenericManager<CustomSections, Long> {
	
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