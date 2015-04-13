package com.lrn.manager.impl.user;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.log4j.Logger;
import com.lrn.dao.IGenericDao;
import com.lrn.dao.user.IUserDao;
import com.lrn.dto.InUsersQueryResponseDTO;
import com.lrn.dto.UsersByEmailAndSiteIdQueryResponseDTO;
import com.lrn.manager.impl.GenericManager;
import com.lrn.manager.user.IUserManager;
import com.lrn.model.hibernate.user.User;
import com.lrn.model.spring.user.UserLabelsDTO;

/**

 */
public class UserManager extends GenericManager<User, String> implements IUserManager {
	
	private static final Logger logger = Logger.getLogger(UserManager.class);
	
	private IUserDao userDao;
	
	public UserManager(IGenericDao<User, String> iGenericDao){
		super(iGenericDao);
	}
	
	@Override
	public User get(String userId) {
		return this.userDao.get(userId);
	}
	
	@Override
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void remove(User user) {
		this.userDao.remove(user);
	}

	@Override
	public User authenticateUser(String username, String password,
			String company) {
		return this.userDao.authenticateUser(username, password, company);
	}
	
	@Override
	public User authenticateUserLockout(String username, String password,
			String company, String ipAddress) {
		return this.userDao.authenticateUserLockout(username, password, company, ipAddress);
	}

	@Override
	public User setPassword(User user, String newPassword) {
		return this.userDao.setPassword(user, newPassword);
	}

	@Override
	public User updateUsername(String newUsername, String oldUsername,
			String company) {
		return this.userDao.updateUsername(newUsername, oldUsername, company);
	}

	@Override
	public User getUserByUsernameCompany(String username, String company) {
		return this.userDao.findByUsername(username, company);
	}

	@Override
	public List<User> getUsersByUserIds(List<String> userIds) {
		return this.userDao.getUsersByUserIds(userIds);
	}

	@Override
	public List<User> getUsersByEmailAndCompany(String email, String company) {
		return userDao.findByEmailAndCompany(email, company);		
	}

	@Override
	public List<User> getUsersByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public List<InUsersQueryResponseDTO> getInUsersQueryResponseDTO(List<String> userIds) {
		return userDao.getInUsersQueryResponseDTO(userIds);
	}

	/**
     * Checks if the user has permission to access the app
     * 
     * @param Long userId
     * @param String company
     * @param String appName
     * @param String appActsOn
     * 
     * @return boolean
     */
	@Override
	public boolean canUseApp(String userId, String company, String appName,
			String appActsOn) {
		//userDao.canUseApp(userId, company, appName, appActsOn);
		
		return userDao.canUseApp(userId, company, appName, appActsOn);
	}

	@Override
	public boolean checkLCECAdminToolsAccess(String userId, String company, String appNameList,
			String appActsOn) {

		return userDao.checkLCECAdminToolsAccess(userId, company, appNameList, appActsOn);
	}
	
	@Override
	public boolean hasSiteCustomizerEditPermission(String userId, String company) {
		return userDao.hasSiteCustomizerEditPermission(userId, company);
	}
	
	@Override
	public List<User> getUsersByUserIdAndCompany(String userId, String company) {
		return userDao.findByUserIdAndCompany(userId, company);
	}
	
	@Override
	public User updateUser(User user) {
		return userDao.updateUser(user);
	}
	
	@Override
	public List<UsersByEmailAndSiteIdQueryResponseDTO> getUsersByEmailAndSiteIdQueryResponseDTO(
			String email, Long siteId) {
		
		return userDao.getUsersByEmailAndSiteIdQueryResponseDTO(email, siteId);
	}
	

	@Override
	public User updatePasswordModDate(User user) {
		return userDao.updatePasswordModDate(user);
	}
	
	@Override
	public User newUser(TreeMap<String, String> user) {
		return userDao.newUser(user);
	}
	
	/* (non-Javadoc)
	 * @see com.lrn.manager.IUserManager#getUserById(java.lang.String)
	 */
	@Override
	public TreeMap<String, Object> getUserById(String userId) {
		StringBuilder queryBuilder = new StringBuilder();		
		queryBuilder.append("select * from users where user_id = '").append(userId).append("'");
		Iterator<Map<String, Object>> itr = userDao.findBySqlQuery(queryBuilder.toString());
		TreeMap<String, Object> resultMap = new TreeMap<String, Object>();
		while (itr.hasNext()) {
			resultMap.putAll(itr.next());			
		}
		return resultMap;
	}

	/* (non-Javadoc)
	 * @see com.lrn.manager.IUserManager#updateUserDetail(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Boolean updateUserDetail(String userId, String columnName,
			String value) {
		return userDao.updateUserDetail(userId, columnName, value);
	}

	@Override
	public UserLabelsDTO getCustomLabelsByUserIdAndCompany(String userId,	String company) {
		return userDao.getCustomLabelsByUserIdAndCompany(userId, company);
	}
	
	@Override
	public User saveSelfRegUser(User user) {
		return userDao.saveSelfRegUser(user);
	}
}