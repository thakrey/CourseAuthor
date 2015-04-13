package com.lrn.manager.custom;

import java.util.List;

import com.lrn.manager.IGenericManager;
import com.lrn.model.hibernate.custom.CustomString;

/**
 * The Interface ICustomStringManager
 */
public interface ICustomStringManager extends IGenericManager<CustomString, Long> {
	
	/**
     * Gets list of CustomString by company and profileValue.
     *
     * @param String company
     * @param String profileValue
     * 
     * @return List<CustomString>
     */
	List<CustomString> getCustomStringByCompanyAndProfileValue(String company, String profileValue);
}