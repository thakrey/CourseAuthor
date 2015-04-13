package com.lrn.dto.request.user;

import java.io.Serializable;
import java.util.List;

import com.lrn.dto.UserDTO;
import com.lrn.model.spring.service.response.LRNError;

/**  
* UserDTOsListDTO - data transfer object class for list of Users. 
* It stores the data for the list of User. 
*
*  @see UserDTO
*  @see LRNError
*/

public class UserDTOsListDTO implements Serializable {

	private static final long serialVersionUID = -7866557036872632219L;
	
	private List<UserDTO> 	users;

	private boolean 		isSuccess = false;
    
    private LRNError 		error = null;
    
	/** Gets the list of users 
	 * 
	 * @return the users, holds the list of {@link UserDTO}
	 */
	public List<UserDTO> getUsers() {
		return users;
	}

	/** Sets the list of users
	 * 
	 * @param users the users - the list of {@link UserDTO} to set
	 */
	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}

	/** Gets the isSuccess flag (true or false)
	 * 
	 * @return the isSuccess
	 */
	public boolean isSuccess() {
		return isSuccess;
	}

	/** Sets the isSuccessFlag (true or false)
	 * 
	 * @param isSuccess the isSuccess to set
	 */
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	/** Gets the error 
	 * 
	 * @return the error, {@link LRNError}
	 * 
	 */
	public LRNError getError() {
		return error;
	}

	/** Sets the error 
	 * 
	 * @param error the error - {@link LRNError} to set
	 */
	public void setError(LRNError error) {
		this.error = error;
	}
}