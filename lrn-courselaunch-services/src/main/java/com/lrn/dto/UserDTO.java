package com.lrn.dto;

import java.io.Serializable;

/**  
* UserDTO - data transfer object class for User. 
* It stores the data for the Users. 
* 
*/
public class UserDTO implements Serializable {
	
	private static final long serialVersionUID = 1838818518723509226L;

	private String 		userId;
	
	private String 		username;
	
	private String 		company;
	
	private String 		firstName;
	
	private String 		middleName;
	
	private String 		lastName;
	
	private String 		email;
	
	private Boolean 	isActive;

	private String 		password;

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

	/** Gets the firstName
	 * 
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/** Sets the firstName
	 * 
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/** Gets the middleName
	 * 
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/** Sets the middleName
	 * 
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/** Gets the lastName
	 * 
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/** Sets the lastName
	 * 
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/** Gets the email
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/** Sets the email
	 * 
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/** Gets the isActive flag(true or false)
	 * 
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/** Sets the isActive flag(true or false)
	 * 
	 * @param isActive the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/** Gets the password
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/** Sets the password
	 * 
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}