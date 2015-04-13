package com.lrn.adapter;

import java.util.List;

import com.lrn.dto.BulkLoadConfigDTO;
import com.lrn.dto.UserColumnInstructionDTO;
import com.lrn.dto.UserModuleLangPrefDTO;
import com.lrn.dto.request.dto.SelfRegUserDTO;
import com.lrn.dto.request.user.InsertUserDTO;
import com.lrn.dto.request.user.UpdateUserDTO;
import com.lrn.dto.request.user.UserDTOsListDTO;
import com.lrn.dto.response.user.AuthenticatedUserDetailDTO;
import com.lrn.error.LRNException;
import com.lrn.model.hibernate.user.User;
import com.lrn.model.spring.user.UserLabelsDTO;


/**
 * The Interface IUserAdapter.
 */
public interface IUserAdapter {

	/**
	 * Retrieves list of User by email and company
	 * 
	 * @param String
	 *            email
	 * @param String
	 *            company
	 * 
	 * @return List<User>
	 */
	List<User> getUsersByEmailAndCompany(String email, String company);

	/**
	 * Retrieves list of User by email
	 * 
	 * @param String
	 *            email
	 * 
	 * @return List<User>
	 */
	List<User> getUsersByEmail(String email);

	/**
	 * Adds user by insertUserDTO
	 * 
	 * @param InsertUserDTO
	 *            insertUserDTO
	 * 
	 * @return User
	 */
	User insertUser(InsertUserDTO insertUserDTO);

	/**
	 * Removes user by userId
	 * 
	 * @param String
	 *            userId
	 * 
	 * @return boolean
	 */
	boolean removeUser(String userId);

	/**
	 * Retrieves list of User by userids
	 * 
	 * @param List
	 *            <String> userIds
	 * 
	 * @return UserDTOsListDTO
	 */
	UserDTOsListDTO getUsersByUserIds(List<String> userIds);

	/**
	 * Call Authenticate user stored procedure.
	 * 
	 * @param username
	 *            the username used to login
	 * @param password
	 *            the password
	 * @param company
	 *            the company name this user belongs to
	 * @return isAuthenticated true if auth, false if failed
	 */
	AuthenticatedUserDetailDTO authenticate(String username,
			String password, String company);
	
	/**
	 * Call Authenticate user stored procedure.
	 * 
	 * @param username
	 *            the username used to login
	 * @param password
	 *            the password
	 * @param company
	 *            the company name this user belongs to
	 * @return isAuthenticated true if auth, false if failed
	 */
	AuthenticatedUserDetailDTO authenticateLockout(String username,
			String password, String company, String ipAddress) throws LRNException;

	
	/**
     * Checks if he user has permission to access admin tools in LCEC
     * 
     * @param String userId
     * @param String company
     * 
     * @return boolean
     */
	boolean canAccessLCECAdminTools(String userId, String company);
	
	/**
     * Checks if he user has permission to access Site Customizer in LCEC
     * 
     * @param String userId
     * @param String company
     * 
     * @return boolean
     */
	boolean hasSiteCustomizerAccess(String userId, String company);
	
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
	 * Retrieves list of User by username and company
	 * 
	 * @param String
	 *            username
	 * @param String
	 *            company
	 * 
	 * @return user
	 */
	User getUsersByUsernameCompany(String username, String company);

	void forgotPasswordEmail(String email, String username, String company,	String url, String translatedUsernameLabel, String translatedPasswordLabel) throws Exception;
	
	boolean changePassword(String userName, String company, String key, String password) throws LRNException;

	String getUserIdFromPasswordRecoverKey(String key);
	
	boolean updatePassword(String userId, String oldPassword,
			String newPassword) throws LRNException;
	
    
    /**
     * Updates user for first name, middle name, last name and email.
     * 
     * @param UpdateUserDTO updateUserDTO
     * 
     * @return User
     */
    User updateUser(UpdateUserDTO updateUserDTO);
    
    /**
     * Retrieves list of User by email and siteId
     * 
     * @param String email
     * @param Long siteId
     * 
     * @return UserDTOsListDTO
     */
    UserDTOsListDTO getUsersByEmailAndSiteId(String email, Long siteId);
	
    /**
     * Get the custom labels by userId and company
     * @param userId
     * @param company
     * @return
     */
    UserLabelsDTO getCustomLabelsByUserIdAndCompany(String userId, String company);
    
    public BulkLoadConfigDTO getRegexForPassword(String company);
    
    public UserModuleLangPrefDTO getUserModuleLangPref(String userId, Long siteId, Long moduleId);
    
    public UserModuleLangPrefDTO setUserModuleLangPref(UserModuleLangPrefDTO dto);
    
    public User insertSelfRegistrationUser(List<UserColumnInstructionDTO> dtoList) throws LRNException;

	boolean checkLCECAdminToolsAccess(String userId, String company);

	void insertUserEmailWithLabels(String email, String userName,
			String company, String url, String translatedUsernameLabel,
			String translatedPasswordLabel) throws Exception;

	User insertSelfRegUser(SelfRegUserDTO insertUserDTO);
}
