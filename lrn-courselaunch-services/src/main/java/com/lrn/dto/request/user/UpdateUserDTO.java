package com.lrn.dto.request.user;

import java.io.Serializable;

/**  
* UpdateUserDTO - data transfer object class for Updating User. 
* It stores the data for the Updating User. 
* 
*/

public class UpdateUserDTO implements Serializable {

	private static final long serialVersionUID = 9069725688558427583L;

	private String 		userId;
	
	private String 		firstName;
	
	private String 		middleName;
	
	private String 		lastName;
	
	private String 		email;

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
}