package com.lrn.dto.response.site;

import java.io.Serializable;
import java.util.List;

import com.lrn.dto.UserDTO;
import com.lrn.model.spring.service.response.LRNError;


/**  
* SiteUsersDTO - data transfer object class for site users. 
* It stores the data for the site users. 
* 
* @see LRNError
* @see UserDTO
*/
public class SiteUsersDTO implements Serializable {

	private static final long serialVersionUID = 4927681438922888074L;

	private Long 			siteId;
	
	private List<UserDTO> 	users;

	private boolean 		isSuccess = false;
    
    private LRNError 		error = null;
    
	/** Gets the siteId
	 *  
	 * @return the siteId
	 */
	public Long getSiteId() {
		return siteId;
	}

	/** Sets the siteId
	 * 
	 * @param siteId the siteId to set
	 */
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	/** Gets the list of users
	 * 
	 * @return the users, holds the list of {@link UserDTO}
	 */
	public List<UserDTO> getUsers() {
		return users;
	}

	/** Sets the list of users
	 * 
	 * @param users the users - list of {@link UserDTO} to set
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

	/** Sets the isSuccess flag (true or false)
	 * 
	 * @param isSuccess the isSuccess to set
	 */
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	/** Gets the error
	 * 
	 * @return the error - {@link LRNError}
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