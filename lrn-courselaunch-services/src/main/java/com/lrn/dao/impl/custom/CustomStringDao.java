package com.lrn.dao.impl.custom;

import java.util.List;

import com.lrn.dao.custom.ICustomStringDao;
import com.lrn.dao.impl.GenericDao;
import com.lrn.model.hibernate.custom.CustomString;

/**
 * The Class CustomFieldEnumDao.
 *
 * @author kishor.pawar
 */
public class CustomStringDao extends GenericDao<CustomString, Long> implements
		ICustomStringDao {

	public CustomStringDao(Class<CustomString> persistentClass) {
		super(persistentClass);
	}

	@Override
	public List<CustomString> getCustomStringByCompanyAndProfileValue(
			String company, String profileValue) {
		String[] paramNames = { "company", "profileValue" };
		Object[] paramValues = { company, profileValue };
		return findByNamedQuery("getCustomStringByCompanyAndlanguage", paramNames, paramValues);
	}
}