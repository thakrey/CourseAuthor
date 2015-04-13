package com.lrn.manager;

import com.lrn.model.hibernate.Sessions;

/**
 * The Interface ISessionsManager
 * 

 *
 */
public interface ISessionsManager extends IGenericManager<Sessions, String> {

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
