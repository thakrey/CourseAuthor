package com.lrn.dao.custom;

import java.util.List;

import com.lrn.dao.IGenericDao;
import com.lrn.model.hibernate.custom.CustomString;

/**
 * The Interface ICustomStringDao.
 *
 * @author kishor.pawar
 */
public interface ICustomStringDao extends IGenericDao<CustomString, Long> {
	
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