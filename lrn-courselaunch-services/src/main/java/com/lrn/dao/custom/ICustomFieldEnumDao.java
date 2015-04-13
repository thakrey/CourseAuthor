package com.lrn.dao.custom;

import java.util.List;

import com.lrn.dao.IGenericDao;
import com.lrn.model.hibernate.custom.CustomFieldEnum;

/**
 * The Interface ICustomFieldEnumDao.
 *
 * @author kishor.pawar
 */
public interface ICustomFieldEnumDao extends IGenericDao<CustomFieldEnum, Long> {
	
	/**
     * Gets list of CustomFieldEnum by siteId and columnName.
     *
     * @param Long siteId
     * @param String columnName
     * 
     * @return List<CustomFieldEnum>
     */
	List<CustomFieldEnum> getCustomFieldEnumBySiteIdAndColumnName(Long siteId, String columnName);
}