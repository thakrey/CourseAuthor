package com.lrn.dao.user;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import com.lrn.dao.IGenericDao;
import com.lrn.dto.InUsersQueryResponseDTO;
import com.lrn.model.spring.user.UserLabelsDTO;
import com.lrn.dto.UsersByEmailAndSiteIdQueryResponseDTO;
import com.lrn.model.hibernate.user.User;


// TODO: Auto-generated Javadoc
/**
 * The User Dao to interact with User LCEC table.
 * Because this table uses mostly stored procedures, we will not
 * use the generic dao.
 * 
 * @author smadenian
 *
 */
public interface IUserDao extends IGenericDao<User, String> {
	
	/**
	 * Get the user object.
	 *
	 * @param userId
	 */
	public User get(String userId);
	
	/**
	 * Delete by user object.
	 *
	 * @param user the user to delete
	 */
	public void remove(User user);
	
    /**
     * Find by username.
     *
     * @param username the username
     * @param company the company
     * @return the user
     */
    public User findByUsername(String username, String company);
    
    /**
     * Find by email.
     *
     * @param email the email
     * @param company the company
     * @return the user
     */
    List<User> findByEmailAndCompany(String email, String company);
    
    /**
     * Find by email.
     *
     * @param email the email
     * 
     * @return List of user
     */
    List<User> findByEmail(String email);
        
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
     * Update the Username.
     *
     * @param newUsername the new user name
     * @param oldUsername the old user name
     * @param company the company
     * @return the user
     */
    public User updateUsername(String newUsername, String oldUsername, String company);

    /**
     * Retrieves list of User by userids.
     *
     * @param userIds the user ids
     * @return List<User>
     */
    List<User> getUsersByUserIds(List<String> userIds);    

    /**
     * Retrieves list of User by userids.
     *
     * @param userIds the user ids
     * @return List<InUsersQueryResponseDTO>
     */
    List<InUsersQueryResponseDTO> getInUsersQueryResponseDTO(List<String> userIds);
    
    /**
     * Find by userId and company.
     *
     * @param userId the userId
     * @param company the company
     * @return the user
     */
    List<User> findByUserIdAndCompany(String userId, String company);
    
    /**
     * Find by username and company.
     *
     * @param username the username
     * @param company the company
     * @return the user
     */
    public InUsersQueryResponseDTO findByUsernameCompany(String username, String company);
	
	/**
	 * Update the User.
	 *
	 * @param user the user
	 * @return User
	 */
    User updateUser(User user);

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
	
	public Object getLcecPropertyValueByColumnName(String entityName, Object entity, String propertyName);
	
	public HashMap<String, String> getLcecColumnsForEntity(String entityName);	

	public void setLcecPropertyValueByPropertyName(String entityName, Object entity, String propertyName, String columnName, Object value, String userId);

	User saveSelfRegUser(User user);

	public boolean canUseApp(String userId, String company, String appName,
			String appActsOn);

	public boolean checkLCECAdminToolsAccess(String userId, String company,
			String appNameList, String appActsOn);

	public boolean hasSiteCustomizerEditPermission(String userId, String company);

	public List<UsersByEmailAndSiteIdQueryResponseDTO> getUsersByEmailAndSiteIdQueryResponseDTO(
			String email, Long siteId);
}
