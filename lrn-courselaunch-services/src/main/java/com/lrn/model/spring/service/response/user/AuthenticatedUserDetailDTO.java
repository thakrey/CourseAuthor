package com.lrn.model.spring.service.response.user;

import java.io.Serializable;

import com.lrn.model.spring.service.response.LRNResponse;

/**
 * The Class AuthenticatedUserDetailDTO
 * 
 *
 */
public class AuthenticatedUserDetailDTO implements Serializable {

	private static final long serialVersionUID = -650751809521072574L;

	private boolean		authenticated;
	
	private boolean 	active;
	
	private boolean 	showWizard;
	
	private boolean 	forcePasswordChange;
	
	private String 		userId;
	
	private String 		username;
	
	private String 		firstname;
	
	private String 		middlename;
	
	private String 		lastname;
	
	private String 		company;
	
	private String 		role;
	
	private boolean		isParticipant;
	
	private String 		language;
	
	private long 		lockoutTime;
	
	private long 		errorCode;
	
	private String 		errorMessage;
	
	private LRNResponse lrnResponse;

	/**
	 * @return the authenticated
	 */
	public boolean isAuthenticated() {
		return authenticated;
	}

	/**
	 * @param authenticated the authenticated to set
	 */
	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the showWizard
	 */
	public boolean isShowWizard() {
		return showWizard;
	}

	/**
	 * @param showWizard the showWizard to set
	 */
	public void setShowWizard(boolean showWizard) {
		this.showWizard = showWizard;
	}

	/**
	 * @return the forcePasswordChange
	 */
	public boolean isForcePasswordChange() {
		return forcePasswordChange;
	}

	/**
	 * @param forcePasswordChange the forcePasswordChange to set
	 */
	public void setForcePasswordChange(boolean forcePasswordChange) {
		this.forcePasswordChange = forcePasswordChange;
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the middlename
	 */
	public String getMiddlename() {
		return middlename;
	}

	/**
	 * @param middlename the middlename to set
	 */
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the isParticipant
	 */
	public boolean isParticipant() {
		return isParticipant;
	}

	/**
	 * @param isParticipant the isParticipant to set
	 */
	public void setParticipant(boolean isParticipant) {
		this.isParticipant = isParticipant;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the lockoutTime
	 */
	public long getLockoutTime() {
		return lockoutTime;
	}

	/**
	 * @param lockoutTime the lockoutTime to set
	 */
	public void setLockoutTime(long lockoutTime) {
		this.lockoutTime = lockoutTime;
	}

	/**
	 * @return the errorCode
	 */
	public long getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(long errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the lrnResponse
	 */
	public LRNResponse getLrnResponse() {
		return lrnResponse;
	}

	/**
	 * @param lrnResponse the lrnResponse to set
	 */
	public void setLrnResponse(LRNResponse lrnResponse) {
		this.lrnResponse = lrnResponse;
	}
}