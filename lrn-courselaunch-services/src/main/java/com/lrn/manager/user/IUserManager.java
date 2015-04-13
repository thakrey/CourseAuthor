package com.lrn.manager.user;

import java.util.List;
import java.util.TreeMap;

import com.lrn.dao.user.IUserDao;
import com.lrn.dto.InUsersQueryResponseDTO;
import com.lrn.dto.UsersByEmailAndSiteIdQueryResponseDTO;
import com.lrn.manager.IGenericManager;
import com.lrn.model.hibernate.user.User;
import com.lrn.model.spring.user.UserLabelsDTO;

/**
 * The Interface IUserManager
 */
public interface IUserManager extends IGenericManager<User, String> {
	
	/**
	 * Sets the user dao.
	 *
	 * @param userDao the new user dao
	 */
	public void setUserDao(IUserDao userDao);
	
	/**
	 * Get the user object
	 * @param userID
	 */
	public User get(String userId);
	
	/**
	 * Delete by user object
	 * @param user the user to delete
	 */
	public void remove(User user);
	
	/**
     * Call Authenticate user stored procedure.
     * 
     * @param username the username used to login
     * @param password the password
     * @param company the company name this user belongs to
     * @return isAuthenticated true if auth, false if failed
     */
    public User authenticateUser(String username, String password, String company);
    
    /**
     * Call Authenticate user stored procedure.
     * 
     * @param username the username used to login
     * @param password the password
     * @param company the company name this user belongs to
     * @return isAuthenticated true if auth, false if failed
     */
    public User authenticateUserLockout(String username, String password, String company, String ipAddress);

    
    /**
     * Sets the password.
     *
     * @param user the user id
     * @param newPassword the new password
     * @return the user
     */
    public User setPassword(User user, String newPassword);
    
    /**
     * Update the Username
     * 
     * @param newUsername the new user name
     * @param oldUsername the old user name
     * @param company the company
     * @return the user
     */
    public User updateUsername(String newUsername, String oldUsername, String company);
    
    /**
     * Gets the user by username company.
     *
     * @param username the username
     * @param company the company
     * @return the user
     */
    public User getUserByUsernameCompany(String username, String company);
    
    /**
     * Retrieves list of User by userids
     * 
     * @param List<String> userIds
     * 
     * @return List<User>
     */
    List<User> getUsersByUserIds(List<String> userIds);

    /**
     * Retrieves list of User by email and company
     * 
     * @param String email
     * @param String company
     * 
     * @return List<User>
     */
    List<User> getUsersByEmailAndCompany(String email, String company);   

    /**
     * Retrieves list of User by email
     * 
     * @param String email
     * 
     * @return List<User>
     */
    List<User> getUsersByEmail(String email);   

    /**
     * Retrieves list of User by userids
     * 
     * @param List<String> userIds
     * 
     * @return List<InUsersQueryResponseDTO>
     */
    List<InUsersQueryResponseDTO> getInUsersQueryResponseDTO(List<String> userIds);
    
    /**
     * Checks if the user has permission to access the app
     * 
     * @param String userId
     * @param String company
     * @param String appName
     * @param String appActsOn
     * 
     * @return boolean
     */
    boolean canUseApp(String userId, String company, String appName, String appActsOn);
    
    /**
     * Retrieves list of User by userId and company
     * 
     * @param String userId
     * @param String company
     * 
     * @return List<User>
     */
    List<User> getUsersByUserIdAndCompany(String userId, String company);
	
	/**
     * Updates user.
     * 
     * @param User user
     * 
     * @return User
     */
    User updateUser(User user);  

    /**
     * Retrieves list of User by email and siteId
     * 
     * @param String email
     * @param Long siteId
     * 
     * @return List<UsersByEmailAndSiteIdQueryResponseDTO>
     */
    List<UsersByEmailAndSiteIdQueryResponseDTO> getUsersByEmailAndSiteIdQueryResponseDTO(
    		String email, Long siteId);

    /**
     * Update the password_mod_date.
     *
     * @param user the user
     * @return User
     */
	User updatePasswordModDate(User user);

	/**
	 * New user.
	 *
	 * @param user TreeMap<String, String>
	 * @return the user model
	 */
	User newUser(TreeMap<String, String> user);

	/**
	 * Gets the user by id.
	 *
	 * @param userId the user id
	 * @return the user as TreeMap<String, Object>
	 */
	TreeMap<String, Object> getUserById(String userId);

	/**
	 * Update user detail.
	 *
	 * @param userId the user id
	 * @param columnName the column name
	 * @param value the value
	 * @return the boolean
	 */
	public Boolean updateUserDetail(String userId, String columnName, String value);
	
	/**
	 * Get the custom labels by userId and company
	 * @param userId
	 * @param company
	 * @return
	 */
	public UserLabelsDTO getCustomLabelsByUserIdAndCompany(String userId, String company);
	
	/**
	 * Check to see if the user has site customizer edit permissions
	 * @param userId
	 * @param company
	 * @return
	 */
	public boolean hasSiteCustomizerEditPermission(String userId, String company);

	boolean checkLCECAdminToolsAccess(String userId, String company,
			String appNameList, String appActsOn);

	User saveSelfRegUser(User user);

}
