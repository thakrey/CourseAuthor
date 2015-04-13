package com.lrn.manager.impl;

import com.lrn.dao.IGenericDao;
import com.lrn.dao.ISessionsDao;
import com.lrn.manager.ISessionsManager;
import com.lrn.model.hibernate.Sessions;

/**
 * The Class SessionsManager
 */
public class SessionsManager extends GenericManager<Sessions, String> implements
		ISessionsManager {
	
	private ISessionsDao sessionsDao;
	
	public SessionsManager(IGenericDao<Sessions, String> iGenericDao) {
		super(iGenericDao);
	}

	/**
	 * @param sessionsDao the sessionsDao to set
	 */
	public void setSessionsDao(ISessionsDao sessionsDao) {
		this.sessionsDao = sessionsDao;
	}

	@Override
	public Sessions getAiccSessionByUserCompany(String userId, String company) {
		return sessionsDao.getAiccSessionByUserCompany(userId, company);
	}
}