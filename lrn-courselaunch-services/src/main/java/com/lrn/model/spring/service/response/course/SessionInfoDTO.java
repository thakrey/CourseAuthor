/**
 * 
 */
package com.lrn.model.spring.service.response.course;

import java.io.Serializable;
import java.text.ParseException;

import com.lrn.model.hibernate.Sessions;
import com.lrn.util.StringUtil;

/** 
 * 
 * Class SessionInfoDTO - data transfer object class for session info. 
 * It stores the data for the session info. 
 *  
*/
public class SessionInfoDTO implements Serializable {

	private static final long serialVersionUID = -4491709573018111321L;

	private String id;
	
	private String searchkey;
	
	private String userId;
	
	private String company;
	
	private String aSession;
	
	private String deletion;

	/** Gets the id
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/** Sets the id
	 * 
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/** Gets the searchKey
	 * 
	 * @return the searchkey
	 */
	public String getSearchkey() {
		return searchkey;
	}

	/** Sets the searchKey
	 * 
	 * @param searchkey the searchkey to set
	 */
	public void setSearchkey(String searchkey) {
		this.searchkey = searchkey;
	}

	/** Gets the userId
	 * 
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/** Sets the userId
	 * 
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/** Gets the company
	 * 
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/** Sets the company
	 * 
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/** Gets the aSession
	 * 
	 * @return the aSession
	 */
	public String getaSession() {
		return aSession;
	}

	/** Sets the aSession
	 * 
	 * @param aSession the aSession to set
	 */
	public void setaSession(String aSession) {
		this.aSession = aSession;
	}

	/** Gets the deletion
	 * 
	 * @return the deletion
	 */
	public String getDeletion() {
		return deletion;
	}

	/** Sets the deletion
	 * 
	 * @param deletion the deletion to set
	 */
	public void setDeletion(String deletion) {
		this.deletion = deletion;
	}
	
	/** Gets Sessions
	 * 
	 * @param SessionInfoDTO dto
	 * 
	 * @return Sessions
	 * @throws ParseException 
	 */
	public static Sessions getModelFromDTO(SessionInfoDTO dto) throws ParseException  {
		Sessions sessions = new Sessions();
		sessions.setaSession(dto.getaSession());
		sessions.setCompany(dto.getCompany());
		if(dto.getDeletion() != null) {
			sessions.setDeletion(StringUtil.getDateFromStringInStandardDateFormat(dto.getDeletion())); 
		}
		sessions.setId(dto.getId());
		sessions.setSearchkey(dto.getSearchkey());
		sessions.setUserId(dto.getUserId());
		return sessions;
	}
}
