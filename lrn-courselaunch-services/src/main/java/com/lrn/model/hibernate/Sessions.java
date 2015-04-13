/**
 * 
 */
package com.lrn.model.hibernate;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.lrn.model.spring.service.response.course.SessionInfoDTO;
import com.lrn.util.StringUtil;

/**

 *
 */
@NamedQueries( {
	@NamedQuery(name = "findSessionByUserCompany",
			query = "from Sessions s where s.userId = :userId and s.company = :company")
})
@Entity
@Table(name = "SESSIONS")
public class Sessions implements Serializable {

	private static final long serialVersionUID = -8217337917609149144L;

	@Id
	@Column(name="ID")
	private String id;
	
	@Column(name="SEARCH_KEY")
	private String searchkey;
	
	@Column(name="USER_ID")
	private String userId;
	
	@Column(name="COMPANY")
	private String company;
	
	@Column(name="A_SESSION")
	private String aSession;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DELETION")
	private Date deletion;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the searchkey
	 */
	public String getSearchkey() {
		return searchkey;
	}

	/**
	 * @param searchkey the searchkey to set
	 */
	public void setSearchkey(String searchkey) {
		this.searchkey = searchkey;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @return the aSession
	 */
	public String getaSession() {
		return aSession;
	}

	/**
	 * @param aSession the aSession to set
	 */
	public void setaSession(String aSession) {
		this.aSession = aSession;
	}

	/**
	 * @return the deletion
	 */
	public Date getDeletion() {
		return deletion;
	}

	/**
	 * @param deletion the deletion to set
	 */
	public void setDeletion(Date deletion) {
		this.deletion = deletion;
	}
}