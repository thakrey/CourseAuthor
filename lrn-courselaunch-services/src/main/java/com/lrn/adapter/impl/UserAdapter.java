package com.lrn.adapter.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.lrn.adapter.IUserAdapter;
import com.lrn.dto.BulkLoadConfigDTO;
import com.lrn.dto.InUsersQueryResponseDTO;
import com.lrn.dto.UserColumnInstructionDTO;
import com.lrn.dto.UserDTO;
import com.lrn.model.spring.user.UserLabelsDTO;
import com.lrn.dto.UserModuleLangPrefDTO;
import com.lrn.dto.UsersByEmailAndSiteIdQueryResponseDTO;
import com.lrn.dto.request.dto.SelfRegUserDTO;
import com.lrn.dto.request.user.InsertUserDTO;
import com.lrn.dto.request.user.UpdateUserDTO;
import com.lrn.dto.request.user.UserDTOsListDTO;
import com.lrn.dto.response.user.AuthenticatedUserDetailDTO;
import com.lrn.email.Message;
import com.lrn.email.MessageFactory;
import com.lrn.error.LRNException;
import com.lrn.manager.IBulkLoadConfigManager;
import com.lrn.manager.IPasswordRecoverManager;
import com.lrn.manager.IUserColumnInstructionManager;
import com.lrn.manager.site.ISiteManager;
import com.lrn.manager.user.IUserManager;
import com.lrn.manager.user.IUserModuleLangPrefManager;
import com.lrn.model.hibernate.PasswordRecover;
import com.lrn.model.hibernate.site.Site;
import com.lrn.model.hibernate.user.User;
import com.lrn.model.hibernate.user.UserCustomColumns;
import com.lrn.model.hibernate.user.UserModuleLangPref;
import com.lrn.model.lcec.TranslationKeyTypeError;
import com.lrn.model.lcecbulk.BulkLoadConfig;
import com.lrn.model.lcecbulk.BulkLoadConfigPK;
import com.lrn.model.spring.service.response.LRNError;
import com.lrn.util.ErrorUtils;
import com.lrn.util.RegExValidator;
import com.lrn.util.StringUtil;

/**
 * The Class UserAdapter.
 */
public class UserAdapter implements IUserAdapter {

	private static final Logger logger = Logger.getLogger(UserAdapter.class);
	
	private IUserManager userManager;

	private IPasswordRecoverManager passwordRecoverManager;

	private MessageFactory emailMessageFactory;

	private VelocityEngine templateEngine;
	
	private IBulkLoadConfigManager bulkLoadConfigManager;

	private IUserModuleLangPrefManager userModuleLangPrefManager;
	
	private IUserColumnInstructionManager userColumnInstructionManager;
	
	private ISiteManager siteManager;
	
	private String 						environmentName;
	
	/**
	 * @param userManager
	 *            the userManager to set
	 */
	public void setUserManager(IUserManager userManager) {
		this.userManager = userManager;
	}

	/**
	 * @param bulkLoadConfigManager the bulkLoadConfigManager to set
	 */
	public void setBulkLoadConfigManager(IBulkLoadConfigManager bulkLoadConfigManager) {
		this.bulkLoadConfigManager = bulkLoadConfigManager;
	}

	public void setSiteManager(ISiteManager siteManager) {
		this.siteManager = siteManager;
	}

	/**
	 * @param passwordRecoverManager
	 *            the passwordRecoverManager to set
	 */
	public void setPasswordRecoverManager(
			IPasswordRecoverManager passwordRecoverManager) {
		this.passwordRecoverManager = passwordRecoverManager;
	}

	/**
	 * @param emailMessageFactory
	 *            the emailMessageFactory to set
	 */
	public void setEmailMessageFactory(MessageFactory emailMessageFactory) {
		this.emailMessageFactory = emailMessageFactory;
	}

	public void setUserModuleLangPrefManager(IUserModuleLangPrefManager userModuleLangPrefManager) {
		this.userModuleLangPrefManager = userModuleLangPrefManager;
	}

	/**
	 * @param templateEngine
	 *            the templateEngine to set
	 */
	public void setTemplateEngine(VelocityEngine templateEngine) {
		this.templateEngine = templateEngine;
	}

	public void setUserColumnInstructionManager(
			IUserColumnInstructionManager userColumnInstructionManager) {
		this.userColumnInstructionManager = userColumnInstructionManager;
	}

	@Override
	public List<User> getUsersByEmailAndCompany(String email, String company) {
		// TODO : Need to work on Exception throwing
		return userManager.getUsersByEmailAndCompany(email, company);
	}

	@Override
	public UserDTOsListDTO getUsersByEmailAndSiteId(String email, Long siteId) {
		// TODO : Need to work on Exception throwing
		UserDTOsListDTO userDTOsListDTO = new UserDTOsListDTO();
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		List<UsersByEmailAndSiteIdQueryResponseDTO> queryResponses = userManager
				.getUsersByEmailAndSiteIdQueryResponseDTO(email, siteId);
		for (UsersByEmailAndSiteIdQueryResponseDTO queryResponse : queryResponses) {
			userDTOs.add(getUserDTOFromUsersByEmailQueryResponseDTO(queryResponse));
		}
		userDTOsListDTO.setUsers(userDTOs);
		return userDTOsListDTO;
	}

	@Override
	public User insertUser(InsertUserDTO insertUserDTO) {
		
		// TODO : Need to work on Exception throwing
		User user = getUser(insertUserDTO);
		return userManager.save(user);
	}
	
	@Override
	public User insertSelfRegUser(SelfRegUserDTO insertUserDTO) {
		
		// TODO : Need to work on Exception throwing
		User user = getSelfRegUser(insertUserDTO);
		user.setActive("t");
		user.setIsActive(true);
		
		return userManager.saveSelfRegUser(user);
	}

	@Override
	public boolean removeUser(String userId) {
		// TODO : Need to work on Exception throwing
		userManager.remove(userId);
		return true;
	}

	@Override
	public UserDTOsListDTO getUsersByUserIds(List<String> userIds) {
		// TODO : Need to work on Exception throwing
		UserDTOsListDTO userDTOsListDTO = new UserDTOsListDTO();
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		List<InUsersQueryResponseDTO> queryResponses = userManager
				.getInUsersQueryResponseDTO(userIds);
		for (InUsersQueryResponseDTO queryResponse : queryResponses) {
			userDTOs.add(getUserDTO(queryResponse));
		}
		userDTOsListDTO.setUsers(userDTOs);
		return userDTOsListDTO;
	}

	@Override
	public User updateUser(UpdateUserDTO updateUserDTO) {
		User user = userManager.get(updateUserDTO.getUserId());
		if (null != updateUserDTO.getEmail()) {
			user.setEmail(updateUserDTO.getEmail());
		}
		if (null != updateUserDTO.getFirstName()) {
			user.setFirstName(updateUserDTO.getFirstName());
		}
		if (null != updateUserDTO.getMiddleName()) {
			user.setMiddleName(updateUserDTO.getMiddleName());
		}
		if (null != updateUserDTO.getLastName()) {
			user.setLastName(updateUserDTO.getLastName());
		}
		return userManager.updateUser(user);
	}

	/**
	 * Constructs UserDTO model by InUsersQueryResponseDTO
	 * 
	 * @param User
	 *            user
	 * 
	 * @return UserDTO
	 */
	private UserDTO getUserDTO(InUsersQueryResponseDTO queryResponse) {
		UserDTO userDTO = new UserDTO();
		userDTO.setCompany(queryResponse.getCompany());
		userDTO.setEmail(queryResponse.getEmail());
		userDTO.setFirstName(queryResponse.getFirstName());
		userDTO.setIsActive(queryResponse.getIsActive());
		userDTO.setLastName(queryResponse.getLastName());
		userDTO.setMiddleName(queryResponse.getMiddleName());
		userDTO.setPassword(queryResponse.getPassword());
		userDTO.setUserId(queryResponse.getUserId());
		userDTO.setUsername(queryResponse.getUsername());
		return userDTO;
	}

	/**
	 * Constructs UserDTO model by UsersByEmailQueryResponseDTO
	 * 
	 * @param UsersByEmailAndSiteIdQueryResponseDTO
	 *            queryResponse
	 * 
	 * @return UserDTO
	 */
	private UserDTO getUserDTOFromUsersByEmailQueryResponseDTO(
			UsersByEmailAndSiteIdQueryResponseDTO queryResponse) {
		UserDTO userDTO = new UserDTO();
		userDTO.setCompany(queryResponse.getCompany());
		userDTO.setEmail(queryResponse.getEmail());
		userDTO.setFirstName(queryResponse.getFirstName());
		userDTO.setIsActive(queryResponse.getIsActive());
		userDTO.setLastName(queryResponse.getLastName());
		userDTO.setMiddleName(queryResponse.getMiddleName());
		userDTO.setPassword(queryResponse.getPassword());
		userDTO.setUserId(queryResponse.getUserId());
		userDTO.setUsername(queryResponse.getUsername());
		return userDTO;
	}

	private User getUser(InsertUserDTO insertUserDTO) {
		User user = new User();
		user.setCompany(insertUserDTO.getCompany());
		user.setEmail(insertUserDTO.getEmail());
		user.setUsername(insertUserDTO.getUsername());
		user.setFirstName(insertUserDTO.getFirstName());
		user.setMiddleName(insertUserDTO.getMiddleName());
		user.setLastName(insertUserDTO.getLastName());
		user.setEmail(insertUserDTO.getEmail());
		user.setPassword(insertUserDTO.getPassword());
		user.setLanguage(insertUserDTO.getLanguage());
		return user;
	}
	
	/**
	 * Constructs User from InsertUserDTO
	 * 
	 * @param InsertUserDTO
	 *            insertUserDTO
	 * 
	 * @return User
	 */
	private User getSelfRegUser(SelfRegUserDTO insertUserDTO) {
		User user = new User();
		user.setCompany(insertUserDTO.getCompany());
		user.setEmail(insertUserDTO.getEmail());
		user.setUsername(insertUserDTO.getLogin_name());
		user.setFirstName(insertUserDTO.getFirstname());
		user.setMiddleName(insertUserDTO.getMiddlename());
		user.setLastName(insertUserDTO.getLastname());
		user.setEmail(insertUserDTO.getEmail());
		user.setPassword(insertUserDTO.getPassword());
		user.setLanguage(insertUserDTO.getLanguage());
		UserCustomColumns uc = new UserCustomColumns();
			uc.setAccessId(insertUserDTO.getAccess_id());
			uc.setAddress1(insertUserDTO.getAddress_1());
			uc.setAddress2(insertUserDTO.getAddress_2());
			uc.setBrowser(insertUserDTO.getBrowser());
			uc.setCity(insertUserDTO.getCity());
			uc.setCostCenter(insertUserDTO.getCostcenter());
			uc.setCountry(insertUserDTO.getCountry());
			uc.setCustom22(insertUserDTO.getCustom_22());
			uc.setCustom23(insertUserDTO.getCustom_23());
			uc.setCustom24(insertUserDTO.getCustom_24());
			uc.setCustom25(insertUserDTO.getCustom_25());
			uc.setCustom26(insertUserDTO.getCustom_26());
			uc.setCustom27(insertUserDTO.getCustom_27());
			uc.setCustom28(insertUserDTO.getCustom_28());
			uc.setCustom29(insertUserDTO.getCustom_29());
			uc.setCustom30(insertUserDTO.getCustom_30());
			uc.setCustom31(insertUserDTO.getCustom_31());
			uc.setCustom32(insertUserDTO.getCustom_32());
			uc.setCustom33(insertUserDTO.getCustom_33());
			uc.setCustom34(insertUserDTO.getCustom_34());
			uc.setCustom35(insertUserDTO.getCustom_35());
			uc.setCustom36(insertUserDTO.getCustom_36());
			uc.setCustom37(insertUserDTO.getCustom_37());
			uc.setCustom38(insertUserDTO.getCustom_38());
			uc.setCustom39(insertUserDTO.getCustom_39());
			uc.setCustom40(insertUserDTO.getCustom_40());
			uc.setCustom41(insertUserDTO.getCustom_41());
			uc.setDivision(insertUserDTO.getDivision());
			try {
				if(insertUserDTO.getDob() != null)
					uc.setDob(StringUtil.getDateFromStringInStandardDateFormat(insertUserDTO.getDob()));
			} catch(ParseException pe) {}
			uc.setEmpId(insertUserDTO.getEmpid());
			uc.setFax(insertUserDTO.getFax());
			uc.sethAddress1(insertUserDTO.getHaddress_1());
			uc.sethAddress2(insertUserDTO.getHaddress_2());
			uc.sethCity(insertUserDTO.getHcity());
			uc.sethCountry(insertUserDTO.getHcountry());
			uc.sethPhone(insertUserDTO.getHphone());
			uc.sethState(insertUserDTO.getHstate());
			uc.sethZip(insertUserDTO.getHzip());
			uc.setLcEmail(insertUserDTO.getLc_email());
			uc.setLcFirstName(insertUserDTO.getLc_firstname());
			uc.setLcLastName(insertUserDTO.getLc_lastname());
			uc.setLcPassword(insertUserDTO.getLc_password());
			uc.setPhone(insertUserDTO.getPhone());
			uc.setSecret(insertUserDTO.getSecret());
			uc.setState(insertUserDTO.getState());
			uc.setSuperFirstName(insertUserDTO.getSuperfirstname());
			uc.setSuperLastName(insertUserDTO.getSuperlastname());
			uc.setSuperMiddleName(insertUserDTO.getSupermiddlename());
			uc.setTitle(insertUserDTO.getTitle());
			uc.setZip(insertUserDTO.getZip());
		user.setUserCustomColumns(uc);
		return user;
	}

	@Override
	public AuthenticatedUserDetailDTO authenticate(String username,
			String password, String company) {
		User authenticatedUser = this.userManager.authenticateUser(username,
				password, company);
		AuthenticatedUserDetailDTO authenticatedUserDetailDTO = getAuthenticatedUserDetailDTO(authenticatedUser);
		return authenticatedUserDetailDTO;
	}
	
	@Override
	public AuthenticatedUserDetailDTO authenticateLockout(String username,
			String password, String company, String ipAddress) throws LRNException {
		User authenticatedUser = this.userManager.authenticateUserLockout(username,
				password, company, ipAddress);
		AuthenticatedUserDetailDTO authenticatedUserDetailDTO = getAuthenticatedUserDetailDTO(authenticatedUser);
		if (authenticatedUserDetailDTO != null && authenticatedUserDetailDTO.getErrorCode() != 0)
		{
			LRNError error = new LRNError();
			error.setMessage(authenticatedUserDetailDTO.getErrorMessage());
			error.setCode(authenticatedUserDetailDTO.getErrorCode());
			if(authenticatedUserDetailDTO.getLockoutTime() > 0) {
				ErrorUtils.formCatalystLoginError(error,
        				TranslationKeyTypeError.CatalystErrorSeq.LOGIN_LOCKOUT_ERR.getCode(),
        				TranslationKeyTypeError.SeverityLevel.MEDIUM);
			} else {
				ErrorUtils.formCatalystLoginError(error,
        				TranslationKeyTypeError.CatalystErrorSeq.LOGIN_INVALID_ERR.getCode(),
        				TranslationKeyTypeError.SeverityLevel.MEDIUM);
			}
			throw new LRNException(error);
		}
		return authenticatedUserDetailDTO;
	}

	/**
	 * Constructs AuthenticatedUserDetailDTO by User model
	 * 
	 * @param User
	 *            user
	 * 
	 * @return AuthenticatedUserDetailDTO
	 */
	private AuthenticatedUserDetailDTO getAuthenticatedUserDetailDTO(User user) {
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
			if (user.getPasswordModDate() == null) {
				authenticatedUserDetailDTO.setForcePasswordChange(true);
			}
		} else {
			authenticatedUserDetailDTO.setAuthenticated(false);
			authenticatedUserDetailDTO.setLockoutTime(user.getLockoutTime());
			authenticatedUserDetailDTO.setErrorCode(user.getErrorCode());
			authenticatedUserDetailDTO.setErrorMessage(user.getErrorMessage());
			
		}
		return authenticatedUserDetailDTO;
	}

	/**
	 * Checks if he user has permission to access admin tools in LCEC
	 * 
	 * @param Long
	 *            userId
	 * @param String
	 *            company
	 * 
	 * @return boolean
	 */
	@Override
	public boolean canAccessLCECAdminTools(String userId, String company) {
		if (userManager.canUseApp(userId, company, "ReportManager", "")
				|| userManager.canUseApp(userId, company, "AskAnExpert", "")
				|| userManager.canUseApp(userId, company, "FindAnExpert", "")
				|| userManager.canUseApp(userId, company,
						"VirtualContractGenerator", "")
				|| userManager.canUseApp(userId, company, "AICCManager", "")
				|| userManager
						.canUseApp(userId, company, "BulkloadManager", "")
				|| userManager.canUseApp(userId, company,
						"CertificationManager", "")
				|| userManager.canUseApp(userId, company, "JasperManager", "")
				|| userManager.canUseApp(userId, company, "CurriculumManager",
						"")
				|| userManager.canUseApp(userId, company, "CustomFileManager",
						"")
				|| userManager.canUseApp(userId, company,
						"QuestionnaireManager", "")
				|| userManager.canUseApp(userId, company, "SiteCustomizer", "")
				|| userManager.canUseApp(userId, company, "UserToolAdmin", "")
				|| userManager.canUseApp(userId, company, "NemoManager", "")
				|| userManager.canUseApp(userId, company, "ModuleManager", "")
				|| userManager.canUseApp(userId, company, "ChainManager", "")) {
			return true;
		}

		return false;
	}

	/**
	 * Checks if he user has permission to access Site Customizer in LCEC
	 * 
	 * @param Long
	 *            userId
	 * @param String
	 *            company
	 * 
	 * @return boolean
	 */
	@Override
	public boolean hasSiteCustomizerAccess(String userId, String company) {
		if (userManager.hasSiteCustomizerEditPermission(userId, company)) {
			return true;
		}

		return false;
	}
	
	@Override
	public List<User> getUsersByUserIdAndCompany(String userId, String company) {
		return userManager.getUsersByUserIdAndCompany(userId, company);
	}

	@Override
	public User getUsersByUsernameCompany(String username, String company) {
		return userManager.getUserByUsernameCompany(username, company);
	}

	@Override
	public void insertUserEmailWithLabels(String email, String userName, String company, String url, String translatedUsernameLabel, 
			String translatedPasswordLabel) throws Exception {
		LRNError error = new LRNError();
		List<User> userList = new ArrayList<User>();
		if (!email.isEmpty()) {
			userList = getUsersByEmailAndCompany(email, company);
		} else if (!userName.isEmpty()) {
			User user = getUsersByUsernameCompany(userName, company);
			if (user != null)
				userList.add(user);
		}
		logger.debug(userList.size());
		if (userList.size() > 0) {
			User user = userList.get(0);
			if (user.getEmail() != null) {
				if (!prepareAndSendInsertUserEmail(user, url, translatedUsernameLabel, translatedPasswordLabel)) {
					error.setCode(-1L);
					ErrorUtils.formCatalystLoginError(error, 
							TranslationKeyTypeError.CatalystErrorSeq.NEW_SELF_REG_USER_SEND_EMAIL_ERR.getCode(),
							TranslationKeyTypeError.SeverityLevel.SEVERE);
					error.setMessage("Unable to send New User Self Registration Email.");
					throw new LRNException(error);
				}
			} else {
				error.setCode(-1L);
				ErrorUtils.formCatalystLoginError(error, 
						TranslationKeyTypeError.CatalystErrorSeq.NEW_SELF_REG_USER_EMAIL_NOTSET.getCode(),
						TranslationKeyTypeError.SeverityLevel.MEDIUM);
				error.setMessage("email_id not found");
				throw new LRNException(error);
			}
		} else {
			logger.debug("Cannot find user record for " + email	+ userName);
			
		
			if (!email.isEmpty()) {
				error.setCode(-1L);
				ErrorUtils.formCatalystLoginError(error, 
						TranslationKeyTypeError.CatalystErrorSeq.NEW_SELF_REG_USER_INVALID_EMAIL.getCode(),
						TranslationKeyTypeError.SeverityLevel.LOW);
				error.setMessage("Cannot find new self registration user record " + email);
				throw new LRNException(error);
			} else {
				error.setMessage("Cannot find new self registration user record " + userName);
				ErrorUtils.formCatalystLoginError(error, 
						TranslationKeyTypeError.CatalystErrorSeq.NEW_SELF_REG_USER_INVALID_USERNM.getCode(),
						TranslationKeyTypeError.SeverityLevel.LOW);
				error.setCode(-1L);
				throw new LRNException(error);
			}
		}
	}
	
	@Override
	public void forgotPasswordEmail(String email, String username, String company, String url,
			String translatedUsernameLabel, String translatedPasswordLabel) throws Exception {
		LRNError error = new LRNError();
		List<User> userList = new ArrayList<User>();
		if (!email.isEmpty()) {
			userList = getUsersByEmailAndCompany(email, company);
		} else if (!username.isEmpty()) {
			User user = getUsersByUsernameCompany(username, company);
			if (user != null)
				userList.add(user);
		}
		logger.debug(userList.size());
		if (userList.size() > 0) {
			User user = userList.get(0);
			if (user.getEmail() != null) {
				String key = passwordRecoverManager.setPasswordRecoverKey(user.getUserId());
				if (!prepareAndSendEmail(user, key, url, translatedUsernameLabel, translatedPasswordLabel)) {
					error.setCode(-1L);
					ErrorUtils.formCatalystLoginError(error, 
							TranslationKeyTypeError.CatalystErrorSeq.FORGOT_PWD_SEND_EMAIL_ERR.getCode(),
							TranslationKeyTypeError.SeverityLevel.SEVERE);
					error.setMessage("Unable to send email.");
					throw new LRNException(error);
				}
			} else {
				error.setCode(-1L);
				ErrorUtils.formCatalystLoginError(error, 
						TranslationKeyTypeError.CatalystErrorSeq.FORGOT_PWD_EMAIL_NOTSET.getCode(),
						TranslationKeyTypeError.SeverityLevel.MEDIUM);
				error.setMessage("email_id not found");
				throw new LRNException(error);
			}
		} else {
			logger.debug("Cannot find user record for " + email
					+ username);
			
		
			if (!email.isEmpty()) {
				error.setCode(-1L);
				ErrorUtils.formCatalystLoginError(error, 
						TranslationKeyTypeError.CatalystErrorSeq.FORGOT_PWD_INVALID_EMAIL.getCode(),
						TranslationKeyTypeError.SeverityLevel.LOW);
				error.setMessage("Cannot find user record " + email);
				throw new LRNException(error);
			} else {
				error.setMessage("Cannot find user record " + username);
				ErrorUtils.formCatalystLoginError(error, 
						TranslationKeyTypeError.CatalystErrorSeq.FORGOT_PWD_INVALID_USERNM.getCode(),
						TranslationKeyTypeError.SeverityLevel.LOW);
				error.setCode(-1L);
			// throw new UnknownUserException("Cannot find user record for "
					// + email + username);
				throw new LRNException(error);
			}
		}

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Boolean prepareAndSendInsertUserEmail(User user, String url, String translatedUsernameLabel, String translatedPasswordLabel) {
		Message emailMessage = this.emailMessageFactory.getMessageInstance();
		emailMessage.addRecepient(user.getEmail());
		emailMessage.setTitle("New User Registration");
		String message = null;
		Map templateVars = new HashMap();
		templateVars.put("user", user);
		templateVars.put("url", url);
		
		//check to see if the translatedUsernameLabel and translatedPasswordLabel are null, if they are, then use the default values
		if(translatedUsernameLabel == null || "".equals(translatedUsernameLabel))
			translatedUsernameLabel = "Username";
		if(translatedPasswordLabel == null || "".equals(translatedPasswordLabel))
			translatedPasswordLabel = "Password";
		
		templateVars.put("usernameLabel", translatedUsernameLabel);
		templateVars.put("passwordLabel", translatedPasswordLabel);

		try {
			message = VelocityEngineUtils.mergeTemplateIntoString(
					this.templateEngine, "forgot_password.html", templateVars);
		} catch (VelocityException e) {
			logger.debug("velocity exception in prepareSendMail - " + ErrorUtils.getCurrentTime());
			e.printStackTrace();
		}
		emailMessage.setBody(message);

		Boolean response = true;
		try {
			emailMessage.sendEmail();
		} catch (Exception e) {
			logger.debug("exception while sending mail in prepareSendMail - " + ErrorUtils.getCurrentTime());
			e.printStackTrace();
			response = false;
		}
		return response;

	}
	
	/**
	 * Prepares and sends email
	 * 
	 * @param User
	 *            user
	 * @param String
	 *            md5
	 * @param String
	 *            url
	 * 
	 * @return List<User>
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Boolean prepareAndSendEmail(User user, String key, String url, String translatedUsernameLabel, String translatedPasswordLabel) {
		Message emailMessage = this.emailMessageFactory.getMessageInstance();
		emailMessage.addRecepient(user.getEmail());
		emailMessage.setTitle("LRN Catalyst Password Change Request");
		String message = null;
		Map templateVars = new HashMap();
		templateVars.put("user", user);
		templateVars.put("key", key);
		templateVars.put("url", url);
		
		//check to see if the translatedUsernameLabel and translatedPasswordLabel are null, if they are, then use the default values
		if(translatedUsernameLabel == null || "".equals(translatedUsernameLabel))
			translatedUsernameLabel = "user name";
		if(translatedPasswordLabel == null || "".equals(translatedPasswordLabel))
			translatedPasswordLabel = "password";
		
		templateVars.put("usernameLabel", translatedUsernameLabel);
		templateVars.put("passwordLabel", translatedPasswordLabel);

		try {
			message = VelocityEngineUtils.mergeTemplateIntoString(
					this.templateEngine, "forgot_password.html", templateVars);
		} catch (VelocityException e) {
			logger.debug("velocity exception in prepareSendMail - " + ErrorUtils.getCurrentTime());
			e.printStackTrace();
		}
		emailMessage.setBody(message);

		Boolean response = true;
		try {
			emailMessage.sendEmail();
		} catch (Exception e) {
			logger.debug("exception while sending mail in prepareSendMail - " + ErrorUtils.getCurrentTime());
			e.printStackTrace();
			response = false;
		}
		return response;

	}

	@Override
	public boolean changePassword(String userName, String company, String key,
			String password) throws LRNException {
		//retrive the userId from password recover key
		String userId = getUserIdFromPasswordRecoverKey(key);
		
		//get the user object from username and company
		User user = getUsersByUsernameCompany(userName.toUpperCase(), company);
		LRNError error = null;
		if (userId == null) {
			error = new LRNError();
			error.setMessage("password recover key invalid. ");
			ErrorUtils.formCatalystLoginError(error, 
					TranslationKeyTypeError.CatalystErrorSeq.FORGOT_PWD_KEY_EXPIRED.getCode(),
					TranslationKeyTypeError.SeverityLevel.LOW);
			error.setCode(-1L);
			throw new LRNException(error);
		}
		if (user == null || !user.getUserId().equals(userId)) {
			error = new LRNError();
			error.setMessage("Your username does not match our records" + user);
			ErrorUtils.formCatalystLoginError(error, 
					TranslationKeyTypeError.CatalystErrorSeq.FORGOT_PWD_INVALID_USERNM.getCode(),
					TranslationKeyTypeError.SeverityLevel.LOW);
			error.setCode(-1L);
			throw new LRNException(error);
		}
	//	validatePasswordFormat(password, company);
		// Save the new password.
		setUserPassword(userId, password);

		// remove the password recover key from the database.
		passwordRecoverManager.remove(key);

		return true;
	}

	public BulkLoadConfigDTO getRegexForPassword(String company) {
		
		return BulkLoadConfigDTO.convertModelToDTO(getConfigForPassword(company));
		
	}
	
	private BulkLoadConfig getConfigForPassword (String company) {
	
		// get the regex for the company for password field
		BulkLoadConfigPK bulkLoadPK = new BulkLoadConfigPK();
		bulkLoadPK.setCompany(company);
		bulkLoadPK.setMappedFieldName("Password");
		BulkLoadConfig bulkLoadConfig = bulkLoadConfigManager.get(bulkLoadPK);
		return bulkLoadConfig;
	
	}
	private User setUserPassword(String userId, String newPassword) {
		User user = userManager.get(userId);
		user = userManager.setPassword(user, newPassword);
		// TO FIX bug to make sure whenever the password is set, password mod date is also set.
		// we also need to update the password mod date
		user.setPasswordModDate(new Date());
		this.userManager.updatePasswordModDate(user);
		return user;
	}

	@Override
	public String getUserIdFromPasswordRecoverKey(String key) {
		List<PasswordRecover> passwordRecoverList = passwordRecoverManager
				.checkPasswordRecoverKey(key);
		if (passwordRecoverList.size() > 0) {
			return passwordRecoverList.get(0).getUserId();
		} else {
			return null;
		}
	}

	@Override
	public boolean updatePassword(String userId, String oldPassword,
			String newPassword) throws LRNException {
	
		User user = userManager.get(userId);
		AuthenticatedUserDetailDTO authenticatedUser = authenticate(user
				.getUsername().toUpperCase(), oldPassword, user.getCompany());
		if (!authenticatedUser.isAuthenticated()) {
			LRNError error = new LRNError();
			error.setCode(-1L);
			ErrorUtils.formCatalystLoginError(error, 
					TranslationKeyTypeError.CatalystErrorSeq.CHANGE_PWD_INCORRECT_PWD.getCode(),
					TranslationKeyTypeError.SeverityLevel.LOW);
			error.setMessage("Invalid old password.");
			throw new LRNException(error);
		}
		// validatePasswordFormat(newPassword, user.getCompany());
		User user1 = setUserPassword(userId, newPassword);
		if (user1 == null) {
			return false;
		}
		return true;
	}

	@Override
	public List<User> getUsersByEmail(String email) {
		// TODO : Need to work on Exception throwing
		return userManager.getUsersByEmail(email);
	}

	@Override
	public UserLabelsDTO getCustomLabelsByUserIdAndCompany(String userId, String company) {
		return userManager.getCustomLabelsByUserIdAndCompany(userId, company);
	}

	@Override
	public UserModuleLangPrefDTO getUserModuleLangPref(String userId, Long siteId, Long moduleId) {
		List<UserModuleLangPref> model = userModuleLangPrefManager.getUserModuleLangPref(userId, siteId, moduleId);
		
		if(model.size() > 0)
			return convertModelToDTO(model.get(0));
		
		return null;
	}
	
	@Override
	public UserModuleLangPrefDTO setUserModuleLangPref(UserModuleLangPrefDTO dto) {
		UserModuleLangPref pref = dto.convertDTOToModel();
		pref = userModuleLangPrefManager.save(pref);
		
		return convertModelToDTO(pref);
	}
	
	@Override
	public User insertSelfRegistrationUser(List<UserColumnInstructionDTO> dtoList) throws LRNException {

		//get all the relevent fields from the UserInstructionDTO
		SelfRegUserDTO insertUserDTO = getInsertUserDTOFromUserColumnInstructionDTOList(dtoList);

		//check to see if the user already exists in the DB
		User userExists = userManager.getUserByUsernameCompany(insertUserDTO.getLogin_name(), insertUserDTO.getCompany());
		if(userExists != null && !StringUtils.isEmpty(userExists.getUserId())) {
			LRNError error = new LRNError();
			error.setMessage(TranslationKeyTypeError.CatalystErrorSeq.DUPLICATE_USER.getDescription());
			ErrorUtils.formCatalystLoginError(error, 
					TranslationKeyTypeError.CatalystErrorSeq.DUPLICATE_USER.getCode(),
					TranslationKeyTypeError.SeverityLevel.SEVERE);
			error.setCode(-1L);
			error.setCatalystErrCd(TranslationKeyTypeError.CatalystErrorSeq.DUPLICATE_USER.getCode());
			throw new LRNException(error);
		}
			
		//then insert the new user in the User table
		User user = insertSelfRegUser(insertUserDTO);
		
		
		return user;
	}
	
	/*******************************************************************************/
	
	private SelfRegUserDTO getInsertUserDTOFromUserColumnInstructionDTOList(List<UserColumnInstructionDTO> dtoList) {
		SelfRegUserDTO insertUserDTO = new SelfRegUserDTO();

		for(UserColumnInstructionDTO dto : dtoList) {
			String dtoColName = dto.getColumnName();
			if(dto.getColumnName().equalsIgnoreCase("login_name")) {
				Site site = siteManager.get(dto.getSiteId());
				insertUserDTO.setCompany(site.getName());
				insertUserDTO.setLogin_name(dto.getInstruction());
			}
			
			try {
				String methodName = "set" + dtoColName.substring(0, 1).toUpperCase() + dtoColName.substring(1).toLowerCase(); 
				System.out.println("****************** " + methodName);
				Method method = null;
				if(dtoColName.equalsIgnoreCase("dob"))
					method = SelfRegUserDTO.class.getMethod(methodName, Date.class);
				else
					method = SelfRegUserDTO.class.getMethod(methodName, String.class);
				method.invoke(insertUserDTO, dto.getInstruction());
			} catch(NoSuchMethodException ex) {
				System.err.println("No such Method Exception for column .... " + dtoColName);
			} catch(InvocationTargetException ex) {
				System.err.println("Error when invoking method for column : " + dtoColName);
			} catch(IllegalAccessException ex) {
				System.err.println("Error when invoking method for column : " + dtoColName);
			}
		} 
		
		return insertUserDTO;
	}
	
	private UserModuleLangPrefDTO convertModelToDTO(UserModuleLangPref model) {
		UserModuleLangPrefDTO dto = new UserModuleLangPrefDTO();
		dto.setId(model.getId());
		dto.setLanguage(model.getLanguage());
		dto.setModuleId(model.getModuleId());
		dto.setSiteId(model.getSiteId());
		dto.setUserId(model.getUserId());
		return dto;
	}
	
	private Boolean validatePasswordFormat(String password, String company) throws LRNException {
		// get the regex for the company for password field
		LRNError lrnError = null;
		BulkLoadConfig bulkLoadConfig = getConfigForPassword(company);
		if (bulkLoadConfig.getFieldLength() != null && password.length() > bulkLoadConfig.getFieldLength()) {
			lrnError = new LRNError();
			lrnError.setMessage("Password Length exceeded the limit");
			ErrorUtils.formCatalystFrontEndError(lrnError,
    				TranslationKeyTypeError.CatalystErrorSeq.FORGOT_PWD_INVALID_PWD_FORMAT.getCode(),
    				TranslationKeyTypeError.SeverityLevel.MEDIUM);
			lrnError.setCode(-1L);
			throw new LRNException(lrnError);
		}
		if (bulkLoadConfig.getFieldMatch() != null ) {
			String error = RegExValidator.validateRegEx(bulkLoadConfig.getFieldMatch(), password, false);
				if (error != null) {
				// get the error and return
					lrnError = new LRNError();
					lrnError.setMessage(error);
					ErrorUtils.formCatalystFrontEndError(lrnError,
		    				TranslationKeyTypeError.CatalystErrorSeq.FORGOT_PWD_INVALID_PWD_FORMAT.getCode(),
		    				TranslationKeyTypeError.SeverityLevel.MEDIUM);
					lrnError.setCode(-1L);
					throw new LRNException(lrnError);
				
				}
			}
		return true;
	}

	@Override
	public boolean checkLCECAdminToolsAccess(String userId, String company) {
		String lcecAdminTools = "'ReportManager', 'AskAnExpert', 'FindAnExpert', 'VirtualContractGenerator', " +
				"'AICCManager', 'BulkloadManager', 'CertificationManager', 'JasperManager'," + 
				"'CurriculumManager', 'CustomFileManager', 'QuestionnaireManager', 'SiteCustomizer'," + 
				"'UserToolAdmin', 'NemoManager', 'ModuleManager', 'ChainManager'";

		return userManager.checkLCECAdminToolsAccess(userId, company, lcecAdminTools, "");
	}
	/**
	 * @param environmentName the environmentName to set
	 */
	public void setEnvironmentName(String environmentName) {
		this.environmentName = environmentName;
	}
}
