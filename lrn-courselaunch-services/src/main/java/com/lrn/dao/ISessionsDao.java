package com.lrn.dao;

import com.lrn.model.hibernate.Sessions;

/**
 * Interface ISessionsDao
 * 
 * @author kishor.pawar
 */
public interface ISessionsDao extends IGenericDao<Sessions, String> {

	/**
	 * Returns Session by userId and company
	 * 
	 * @param String userId
	 * @param String company
	 *
	 * @return Sessions
	 */
	Sessions getAiccSessionByUserCompany(String userId, String company);
}
