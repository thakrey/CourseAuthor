package com.lrn.dao.impl.custom;

import java.util.List;

import com.lrn.dao.custom.ICustomFieldEnumDao;
import com.lrn.dao.impl.GenericDao;
import com.lrn.model.hibernate.custom.CustomFieldEnum;

/**
 * The Class CustomFieldEnumDao.
 *
 * @author kishor.pawar
 */
public class CustomFieldEnumDao extends GenericDao<CustomFieldEnum, Long> implements
		ICustomFieldEnumDao {

	public CustomFieldEnumDao(Class<CustomFieldEnum> persistentClass) {
		super(persistentClass);
	}

	@Override
	public List<CustomFieldEnum> getCustomFieldEnumBySiteIdAndColumnName(Long siteId, 
			String columnName) {
		String[] paramNames = { "siteId", "columnName" };
		Object[] paramValues = { siteId, columnName };
		return findByNamedQuery("getCustomFieldEnumBySiteIdAndColumnName", paramNames, paramValues);
	}
}