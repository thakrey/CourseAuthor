package com.lrn.dao.impl;

import java.util.List;

import com.lrn.dao.ISessionsDao;
import com.lrn.model.hibernate.Sessions;

/**
 * The Class SessionsDao.
 *
 * @author kishor.pawar
 */
public class SessionsDao extends GenericDao<Sessions, String> implements ISessionsDao {

	public SessionsDao(Class<Sessions> persistentClass) {
		super(persistentClass);
	}
	
	@Override
	public Sessions getAiccSessionByUserCompany(String userId, String company) {
		String[] paramNames = {"userId", "company"};
		Object[] paramValues = {userId, company};
		List<Sessions> sessionsList = findByNamedQuery("findSessionByUserCompany", paramNames, paramValues);
		if(sessionsList != null && sessionsList.size() > 0)
			return sessionsList.get(0);
		return null;
	}
}