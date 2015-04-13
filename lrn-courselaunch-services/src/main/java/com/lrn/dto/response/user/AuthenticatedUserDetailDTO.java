/**
 * 
 */
package com.lrn.dto.response.user;

import java.io.Serializable;

import com.lrn.model.hibernate.user.User;



/**  
* AuthenticatedUserDetailDTO - data transfer object class for authenticated user details. 
* It stores the data for the authenticated user details. 
* 
*/

public class AuthenticatedUserDetailDTO implements Serializable {

	private static final long serialVersionUID = 6567057762156601152L;

	private boolean	authenticated;
	
	private boolean active;
	
	private boolean showWizard;
	
	private boolean forcePasswordChange;
	
	private String 	userId;
	
	private String 	username;
	
	private String 	firstname;
	
	private String 	middlename;
	
	private String 	lastname;
	
	private String 	company;
	
	private String 	role;
	
	private boolean	isParticipant;
	
	private String language;
	
	private long lockoutTime;
	
	private long errorCode;
	
	private String errorMessage;

	/** Gets the authenticated flag (true or false)
	 * 
	 * @return the authenticated
	 */
	public boolean isAuthenticated() {
		return authenticated;
	}

	/** Sets the authenticated flag (true or false)
	 * 
	 * @param authenticated the authenticated to set
	 */
	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	/** Gets the active flag of the authenticated user(true or false)
	 * 
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/** Sets the active flag of the user (true or false)
	 * 
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/** Gets the showWizard flag (true or false)
	 * 
	 * @return the showWizard
	 */
	public boolean isShowWizard() {
		return showWizard;
	}

	/** Sets the showWizard flag (true or false)
	 * 
	 * @param showWizard the showWizard to set
	 */
	public void setShowWizard(boolean showWizard) {
		this.showWizard = showWizard;
	}

	/** Gets the forcePasswordChange flag which indicates 
	 * whether the user needs to be forced for password change
	 * This is derived based on Password Mod Date - 
	 * if it is null this flag is set to true else false
	 * 
	 * @return the forcePasswordChange
	 */
	public boolean isForcePasswordChange() {
		return forcePasswordChange;
	}

	/**  Sets the forcePasswordChange flag which indicates 
	 * whether the user needs to be forced for password change
	 * This is derived based on Password Mod Date - 
	 * if it is null this flag is set to true else false
	 * 
	 * @param forcePasswordChange the forcePasswordChange to set
	 */
	public void setForcePasswordChange(boolean forcePasswordChange) {
		this.forcePasswordChange = forcePasswordChange;
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
 
	/** Gets the username
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/** Sets the username
	 * 
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/** Gets the firstname
	 * 
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**Sets the firstname
	 * 
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/** Gets the middlename
	 * 
	 * @return the middlename
	 */
	public String getMiddlename() {
		return middlename;
	}

	/** Sets the middlename
	 * 
	 * @param middlename the middlename to set
	 */
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	/** Gets the lastname
	 * 
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/** Sets the lastname
	 * 
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	/** Gets the role
	 * 
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/** Sets the role
	 * 
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/** Gets the isParticipant flag  (true or false)
	 * 
	 * @return the isParticipant
	 */
	public boolean isParticipant() {
		return isParticipant;
	}

	/** Sets the isParticipant flag (true or false)
	 * 
	 * @param isParticipant the isParticipant to set
	 */
	public void setParticipant(boolean isParticipant) {
		this.isParticipant = isParticipant;
	}

	/** Gets the language
	 * 
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/** Sets the language
	 * 
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	
	/** Gets the lockoutTime 
	 * 
	 * @return lockoutTime the lockoutTime to set
	 */

	public long getLockoutTime() {
		return lockoutTime;
	}
	/** Sets the lockoutTime
	 * 
	 * @param lockoutTime the lockoutTime to set
	 */

	public void setLockoutTime(long lockoutTime) {
		this.lockoutTime = lockoutTime;
	}
	/** Gets the errorCode - this errorCode corresponds to error code from the DB call - 
	 * 
	 * @return errorCode the errorCode to set
	 */

	public long getErrorCode() {
		return errorCode;
	}
	/** Sets the errorCode - this errorCode is set directly
	 * from the returned error code from the DB call
	 * 
	 * @param errorCode the errorCode to set
	 */

	public void setErrorCode(long errorCode) {
		this.errorCode = errorCode;
	}
	/** Gets the errorMessage - this errorMessage corresponds to error message from the DB call
	 * 	 * 
	 * @return errorMessage the errorMessage to set
	 */

	public String getErrorMessage() {
		return errorMessage;
	}
	/** Sets the error Message - this errorMessage is set 
	 * directly from the returned error message from the DB call
	 * 
	 * @param errorMessage the errorMessage to set
	 */

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * Constructs AuthenticatedUserDetailDTO from the User model
	 * 
	 * @param User
	 *            user - {@link User}
	 * 
	 * @return AuthenticatedUserDetailDTO
	 */
	public static final AuthenticatedUserDetailDTO convertModelToDTO(User user) {
		AuthenticatedUserDetailDTO authenticatedUserDetailDTO = new AuthenticatedUserDetailDTO();
		if (user.getUserId() != null) {
			authenticatedUserDetailDTO.setAuthenticated(true);
			authenticatedUserDetailDTO.setCompany(user.getCompany());
			authenticatedUserDetailDTO.setFirstname(user.getFirstName());
			authenticatedUserDetailDTO.setActive(user.getIsActive());
			authenticatedUserDetailDTO.setLastname(user.getLastName());
			authenticatedUserDetailDTO.setMiddlename(user.getMiddleName());
			authenticatedUserDetailDTO.setUserId(user.getUserId());
			authenticatedUserDetailDTO.setUsername(user.getUsername());
			authenticatedUserDetailDTO.setLanguage(user.getLanguage());
			authenticatedUserDetailDTO.setLockoutTime(user.getLockoutTime());
			if(user.getError() != null && user.getError().getCode() != null) 
				authenticatedUserDetailDTO.setErrorCode(user.getErrorCode());
			if(user.getError() != null && user.getError().getMessage() != null) 
				authenticatedUserDetailDTO.setErrorMessage(user.getErrorMessage());
			
			if (user.getPasswordModDate() == null) {
				authenticatedUserDetailDTO.setForcePasswordChange(true);
			}
		} else {
			authenticatedUserDetailDTO.setAuthenticated(false);
			authenticatedUserDetailDTO.setLockoutTime(user.getLockoutTime());
		}
		return authenticatedUserDetailDTO;
	}
}
