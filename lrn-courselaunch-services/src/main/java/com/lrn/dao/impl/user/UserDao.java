package com.lrn.dao.impl.user;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.sql.DataSource;

import oracle.jdbc.OracleTypes;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.EntityMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.Work;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.Property;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import com.lrn.dao.impl.GenericDao;
import com.lrn.dao.user.IUserDao;
import com.lrn.dto.InUsersQueryResponseDTO;
import com.lrn.model.spring.user.UserLabelsDTO;
import com.lrn.dto.UsersByEmailAndSiteIdQueryResponseDTO;
import com.lrn.model.hibernate.site.Site;
import com.lrn.model.hibernate.user.User;
import com.lrn.model.spring.service.response.LRNError;
import com.lrn.model.spring.user.UserLabelDTO;
import com.lrn.util.ApplicationContextProvider;

public class UserDao extends GenericDao<User, String> implements IUserDao {

	private static final Logger logger = Logger.getLogger(UserDao.class);

//	private static ApplicationContext context = new FileSystemXmlApplicationContext("webapps\\lrnservice\\WEB-INF\\classes\\lrnservice-data.xml");
	
	public UserDao(Class<User> persistentClass){
		super(persistentClass);
	}
	
	@Override
	public User get(String userId) {
		User user = null;

		StringBuilder queryBuilder = new StringBuilder();	
		
		queryBuilder.append("select u.user_id as user_id, u.password as password, u.firstname as firstname, u.middlename as middlename, u.lastname as lastname,");
		queryBuilder.append(" u.login_name as login_name, u.email as email, u.company as company, u.language as language, u.active as user_active, ");
		queryBuilder.append(" u.password_mod_date as password_mod_date, u.creation_date as user_creation_date, s.id as site_id, s.name as site_name, s.host as site_host,");
		queryBuilder.append(" s.active as site_active, s.deactivated as site_deactivated, s.updated as site_updated");
		queryBuilder.append(" from users u, site s, site_user su where u.user_id = su.user_id ");
		queryBuilder.append(" and s.id = su.site_id and u.user_id = ?");

		ArrayList<Object> params = new ArrayList<Object> ();
		params.add(userId);

		List<Map<String, Object>> resultSetMapList = queryForList(queryBuilder.toString(), params);
		Iterator<Map<String, Object>> itr = resultSetMapList.iterator();
		
        while(itr.hasNext()) {
            Map<String, Object> resultMap =itr.next();
            user = getUserFromResultMap(resultMap);
        }
        
        return user;
	}
	
	private User getUserFromResultMap(Map<String, Object> resultMap) {
		User user = new User();
		
		user.setUserId((String)resultMap.get("user_id"));
		user.setPassword((String)resultMap.get("password"));
		String active = (String)resultMap.get("user_active"); 
		if(null != active && active.equalsIgnoreCase("t")) 
			user.setIsActive(true);
		else 
			user.setIsActive(false);
		user.setFirstName((String)resultMap.get("firstname"));
		user.setMiddleName((String)resultMap.get("middlename"));
		user.setLastName((String)resultMap.get("lastname"));
		user.setUsername((String)resultMap.get("login_name"));
		user.setEmail((String)resultMap.get("email"));
		user.setCompany((String)resultMap.get("company"));
		user.setLanguage((String)resultMap.get("language"));
		user.setPasswordModDate((Date)resultMap.get("password_mod_date"));
		user.setCreationDate((Date)resultMap.get("user_creation_date"));
		
		Site site = new Site();
		site.setId(((BigDecimal)resultMap.get("site_id")).longValue());
		site.setName((String)resultMap.get("site_name"));
		site.setHost((String)resultMap.get("site_host"));
		site.setActive(((BigDecimal)resultMap.get("site_active")).longValue() == 1 ? true : false); 
		
		site.setDeactivatedDate((Date)resultMap.get("site_deactivated"));
		site.setUpdatedDate((Date)resultMap.get("site_updated"));
		user.setSite(site);
		
		return user;
	}
	
	@Override
	public User save(final User user) {
		Session currentSession = this.getSession();
		Work createUser = new Work(){
			public void execute(Connection connection) throws SQLException {
				StringBuilder procedure = new StringBuilder(); 
				procedure.append("{ call LCEC_USER.NEW(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ");
				procedure.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ");
				procedure.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ");
				procedure.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
				CallableStatement call = connection.prepareCall(procedure.toString());
				call.setString(1, user.getPassword());
				call.setString(2, user.getFirstName());
				call.setString(3, user.getMiddleName());
				call.setString(4, user.getLastName());
				call.setString(5, null);							// empid
				call.setString(6, user.getEmail());					// email
				call.setString(7, user.getCompany());
				call.setString(8, null);							// city
				call.setString(9, null);							// division
				call.setString(10, null);							// superfirstname
				call.setString(11, null);							// supermiddlename
				call.setString(12, null);							// superlastname
				call.setString(13, user.getUsername());
				call.setInt(14, (user.getIsActive() ? 1 : 0));
				call.setString(15, null);							// access_id
				call.setString(16, null);							// DOB
				call.setString(17, null);							// secret
				call.setString(18, null);							// haddress_1
				call.setString(19, null);							// haddress_2
				call.setString(20, null);							// hcity
				call.setString(21, null);							// hstate
				call.setString(22, null);							// hzip
				call.setString(23, null);							// hcountry
				call.setString(24, null);							// hphone
				call.setString(25, null);							// title
				call.setString(26, null);							// address_1
				call.setString(27, null);							// address_2
				call.setString(28, null);							// state
				call.setString(29, null);							// zip
				call.setString(30, null);							// country
				call.setString(31, null);							// phone
				call.setString(32, null);							// fax
				call.setString(33, null);							// costcenter
				call.setString(34, null);							// permissions
				call.setString(35, null);							// language
				call.setString(36, null);							// browser
				call.setString(37, null);
				call.setString(38, null);
				call.setString(39, null);
				call.setString(40, null);
				call.setString(41, null);							
				call.setString(42, null);							
				call.setString(43, null);							
				call.setString(44, null);							
				call.setString(45, null);							
				call.setString(46, null);							
				call.setString(47, null);
				call.setString(48, null);
				call.setString(49, null);
				call.setString(50, null);
				call.setString(51, null);							
				call.setString(52, null);							
				call.setString(53, null);							
				call.setString(54, null);							
				call.setString(55, null);							
				call.setString(56, null);
				call.setInt(57, 0);									// expire_password
				call.registerOutParameter(58, OracleTypes.VARCHAR);
				call.registerOutParameter(59, OracleTypes.NUMBER);
				call.registerOutParameter(60, OracleTypes.VARCHAR);
				call.execute();

				user.setUserId( String.valueOf(call.getLong(58)) );
				user.setErrorCode( (call.getLong(59) == 0) ? null : call.getLong(59));
				user.setErrorMessage(call.getString(60));
			}
		};
		currentSession.doWork(createUser);
		// user with newly created user_id
		User insertedUser = this.get(user.getUserId());
		user.setSite(insertedUser.getSite());
		user.setUserId(insertedUser.getUserId());
		this.releaseSession(currentSession);
		
		return user;
	}

	@Override
	public User saveSelfRegUser(final User user) {
		Session currentSession = this.getSession();
		Work createUser = new Work(){
			public void execute(Connection connection) throws SQLException {
				StringBuilder procedure = new StringBuilder(); 
				procedure.append("{ call LCEC_USER.NEW(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ");
				procedure.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ");
				procedure.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ");
				procedure.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
				CallableStatement call = connection.prepareCall(procedure.toString());
				call.setString(1, user.getPassword());
				call.setString(2, user.getFirstName());
				call.setString(3, user.getMiddleName());
				call.setString(4, user.getLastName());
				call.setString(5, user.getUserCustomColumns().getEmpId());							// empid
				call.setString(6, user.getEmail());					// email
				call.setString(7, user.getCompany());
				call.setString(8, user.getUserCustomColumns().getCity());							// city
				call.setString(9, user.getUserCustomColumns().getDivision());							// division
				call.setString(10, user.getUserCustomColumns().getSuperFirstName());							// superfirstname
				call.setString(11, user.getUserCustomColumns().getSuperMiddleName());							// supermiddlename
				call.setString(12, user.getUserCustomColumns().getSuperLastName());							// superlastname
				call.setString(13, user.getUsername());
				call.setInt(14, (user.getIsActive() ? 1 : 0));
				call.setString(15, user.getUserCustomColumns().getAccessId());							// access_id
				call.setString(16, user.getUserCustomColumns().getDob() == null ? null : user.getUserCustomColumns().getDob().toString());							// DOB
				call.setString(17, user.getUserCustomColumns().getSecret());							// secret
				call.setString(18, user.getUserCustomColumns().gethAddress1());							// haddress_1
				call.setString(19, user.getUserCustomColumns().gethAddress2());							// haddress_2
				call.setString(20, user.getUserCustomColumns().gethCity());							// hcity
				call.setString(21, user.getUserCustomColumns().gethState());							// hstate
				call.setString(22, user.getUserCustomColumns().gethZip());							// hzip
				call.setString(23, user.getUserCustomColumns().gethCountry());							// hcountry
				call.setString(24, user.getUserCustomColumns().gethPhone());							// hphone
				call.setString(25, user.getUserCustomColumns().getTitle());							// title
				call.setString(26, user.getUserCustomColumns().getAddress1());							// address_1
				call.setString(27, user.getUserCustomColumns().getAddress2());							// address_2
				call.setString(28, user.getUserCustomColumns().getState());							// state
				call.setString(29, user.getUserCustomColumns().getZip());							// zip
				call.setString(30, user.getUserCustomColumns().getCountry());							// country
				call.setString(31, user.getUserCustomColumns().getPhone());							// phone
				call.setString(32, user.getUserCustomColumns().getFax());							// fax
				call.setString(33, user.getUserCustomColumns().getCostCenter());							// costcenter
				call.setString(34, null);							// permissions
				call.setString(35, user.getLanguage());							// language
				call.setString(36, user.getUserCustomColumns().getBrowser());							// browser
				call.setString(37, user.getUserCustomColumns().getCustom22());					//custom_22
				call.setString(38, user.getUserCustomColumns().getCustom23());
				call.setString(39, user.getUserCustomColumns().getCustom24());
				call.setString(40, user.getUserCustomColumns().getCustom25());
				call.setString(41, user.getUserCustomColumns().getCustom26());							
				call.setString(42, user.getUserCustomColumns().getCustom27());							
				call.setString(43, user.getUserCustomColumns().getCustom28());							
				call.setString(44, user.getUserCustomColumns().getCustom29());							
				call.setString(45, user.getUserCustomColumns().getCustom30());							
				call.setString(46, user.getUserCustomColumns().getCustom31());							
				call.setString(47, user.getUserCustomColumns().getCustom32());
				call.setString(48, user.getUserCustomColumns().getCustom33());
				call.setString(49, user.getUserCustomColumns().getCustom34());
				call.setString(50, user.getUserCustomColumns().getCustom35());
				call.setString(51, user.getUserCustomColumns().getCustom36());							
				call.setString(52, user.getUserCustomColumns().getCustom37());							
				call.setString(53, user.getUserCustomColumns().getCustom38());							
				call.setString(54, user.getUserCustomColumns().getCustom39());							
				call.setString(55, user.getUserCustomColumns().getCustom40());							
				call.setString(56, user.getUserCustomColumns().getCustom41());					//custom_41
				call.setInt(57, 0);									// expire_password
				call.registerOutParameter(58, OracleTypes.VARCHAR);
				call.registerOutParameter(59, OracleTypes.NUMBER);
				call.registerOutParameter(60, OracleTypes.VARCHAR);
				call.execute();

				user.setUserId( String.valueOf(call.getLong(58)) );
				user.setErrorCode( (call.getLong(59) == 0) ? null : call.getLong(59));
				user.setErrorMessage(call.getString(60));
			}
		};
		currentSession.doWork(createUser);
		// user with newly created user_id
		User insertedUser = this.get(user.getUserId());
		user.setSite(insertedUser.getSite());
		user.setUserId(insertedUser.getUserId());
		this.releaseSession(currentSession);
		
		return user;
	}
	
	@Override
	public void remove(String userId) {
		User user = this.get(userId);
		this.remove(user);
	}
	
	@Override
    public void remove(final User user) {
		Session currentSession = this.getSession();
		Work deleteUser = new Work(){
			public void execute(Connection connection) throws SQLException{
				CallableStatement call  = connection.prepareCall("{ call LCEC_USER.DELETE(?, ?, ?, ?, ?, ?) }");
				call.setString(1, user.getUserId());
				call.setString(2, null);
				call.setInt(3, 0);
				call.setInt(4, 0);
				call.registerOutParameter(5, OracleTypes.NUMBER);
				call.registerOutParameter(6, OracleTypes.VARCHAR);
				
				call.execute();
				user.setErrorCode( (call.getLong(5) == 0) ? null : call.getLong(5));
				user.setErrorMessage(call.getString(6));
			}
		};
		
		currentSession.doWork(deleteUser);
		this.releaseSession(currentSession);
	}

	@Override
	public User findByUsername(String username, String company){
		User user = null;

		StringBuilder queryBuilder = new StringBuilder();	
		queryBuilder.append("select u.user_id as user_id, u.password as password, u.firstname as firstname, u.middlename as middlename, u.lastname as lastname,");
		queryBuilder.append(" u.login_name as login_name, u.email as email, u.company as company, u.language as language, u.active as user_active, ");
		queryBuilder.append(" u.password_mod_date as password_mod_date, u.creation_date as user_creation_date, s.id as site_id, s.name as site_name, s.host as site_host,");
		queryBuilder.append(" s.active as site_active, s.deactivated as site_deactivated, s.updated as site_updated");
		queryBuilder.append(" from users u, site s, site_user su where u.user_id = su.user_id ");
		queryBuilder.append(" and s.id = su.site_id and u.login_name = ?");
		queryBuilder.append(" and u.active = 't' and u.company = ?");
		
		ArrayList<Object> params = new ArrayList<Object> ();
		params.add(username.toUpperCase());
		params.add(company);

		List<Map<String, Object>> resultSetMapList = queryForList(queryBuilder.toString(), params);
		Iterator<Map<String, Object>> itr = resultSetMapList.iterator();
		
        while(itr.hasNext()) {
            Map<String, Object> resultMap =itr.next();
            user = getUserFromResultMap(resultMap);
        }
        
        return user;
	}

	@Override
	public List<User> findByEmailAndCompany(String email, String company) {
		List<User> userList = new ArrayList<User>();
		
		StringBuilder queryBuilder = new StringBuilder();	
		queryBuilder.append("select u.user_id as user_id, u.password as password, u.firstname as firstname, u.middlename as middlename, u.lastname as lastname,");
		queryBuilder.append(" u.login_name as login_name, u.email as email, u.company as company, u.language as language, u.active as user_active, ");
		queryBuilder.append(" u.password_mod_date as password_mod_date, u.creation_date as user_creation_date, s.id as site_id, s.name as site_name, s.host as site_host,");
		queryBuilder.append(" s.active as site_active, s.deactivated as site_deactivated, s.updated as site_updated");
		queryBuilder.append(" from users u, site s, site_user su where u.user_id = su.user_id ");
		queryBuilder.append(" and s.id = su.site_id and u.lc_email = ?");
		queryBuilder.append(" and u.active = 't' and u.company = ?");
		
		ArrayList<Object> params = new ArrayList<Object> ();
		params.add(email.toLowerCase());
		params.add(company);

		List<Map<String, Object>> resultSetMapList = queryForList(queryBuilder.toString(), params);
		Iterator<Map<String, Object>> itr = resultSetMapList.iterator();
		
        while(itr.hasNext()) {
            Map<String, Object> resultMap =itr.next();
            User user = getUserFromResultMap(resultMap);
            userList.add(user);
        }
        
        return userList;
    }

	@Override
	public List<User> findByEmail(String email) {
		List<User> userList = new ArrayList<User>();
		
		StringBuilder queryBuilder = new StringBuilder();	
		queryBuilder.append("select u.user_id as user_id, u.password as password, u.firstname as firstname, u.middlename as middlename, u.lastname as lastname,");
		queryBuilder.append(" u.login_name as login_name, u.email as email, u.company as company, u.language as language, u.active as user_active, ");
		queryBuilder.append(" u.password_mod_date as password_mod_date, u.creation_date as user_creation_date, s.id as site_id, s.name as site_name, s.host as site_host,");
		queryBuilder.append(" s.active as site_active, s.deactivated as site_deactivated, s.updated as site_updated");
		queryBuilder.append(" from users u, site s, site_user su where u.user_id = su.user_id ");
		queryBuilder.append(" and s.id = su.site_id and u.lc_email = ?");
		
		ArrayList<Object> params = new ArrayList<Object> ();
		params.add(email);

		List<Map<String, Object>> resultSetMapList = queryForList(queryBuilder.toString(), params);
		Iterator<Map<String, Object>> itr = resultSetMapList.iterator();
		
        while(itr.hasNext()) {
            Map<String, Object> resultMap =itr.next();
            User user = getUserFromResultMap(resultMap);
            userList.add(user);
        }

        return userList;
    }

	/**
     * Find by userId and company.
     *
     * @param userId the userId
     * @param company the company
     * @return the user
     */
	@Override
	public List<User> findByUserIdAndCompany(String userId, String company) {
		List<User> userList = new ArrayList<User>();
		
		StringBuilder queryBuilder = new StringBuilder();	
		queryBuilder.append("select u.user_id as user_id, u.password as password, u.firstname as firstname, u.middlename as middlename, u.lastname as lastname,");
		queryBuilder.append(" u.login_name as login_name, u.email as email, u.company as company, u.language as language, u.active as user_active, ");
		queryBuilder.append(" u.password_mod_date as password_mod_date, u.creation_date as user_creation_date, s.id as site_id, s.name as site_name, s.host as site_host,");
		queryBuilder.append(" s.active as site_active, s.deactivated as site_deactivated, s.updated as site_updated");
		queryBuilder.append(" from users u, site s, site_user su where u.user_id = su.user_id ");
		queryBuilder.append(" and s.id = su.site_id and u.user_id = ?");
		queryBuilder.append(" and u.company = ?");
		
		ArrayList<Object> params = new ArrayList<Object> ();
		params.add(userId);
		params.add(company);

		List<Map<String, Object>> resultSetMapList = queryForList(queryBuilder.toString(), params);
		Iterator<Map<String, Object>> itr = resultSetMapList.iterator();
		
        while(itr.hasNext()) {
            Map<String, Object> resultMap =itr.next();
            User user = getUserFromResultMap(resultMap);
            userList.add(user);
        }

        return userList;
        
	}

	@Override
	public User authenticateUser(final String username, final String password,
			final String company) {
		final User loggedInUser = new User();
		Session currSession = this.getSession();
		currSession.doWork( new Work() {
			public void execute(Connection connection) throws SQLException {
				CallableStatement call = connection.prepareCall("{ call LCEC_USER.AUTHENTICATE(?, ?, ?, ?, ?, ?) }");
				call.setString(1, username);
				call.setString(2, company);
				call.setString(3, password);
				call.registerOutParameter(4, OracleTypes.VARCHAR);
				call.registerOutParameter(5, OracleTypes.NUMBER);
				call.registerOutParameter(6, OracleTypes.VARCHAR);
				call.execute();

				loggedInUser.setUserId(call.getString(4));
				loggedInUser.setErrorCode(call.getLong(5));
				loggedInUser.setErrorMessage(call.getString(6));
				logger.debug("1. LOGGED IN USER ID " + loggedInUser.getUserId());
			}
	    });
		
		if (loggedInUser.getUserId() != null) {
			logger.debug("2. LOGGED IN USER ID " + loggedInUser.getUserId());
			return this.get(loggedInUser.getUserId());
		}
		this.releaseSession(currSession);
		
		// TODO: have logger log this attempt
		return loggedInUser;
	}

	@Override
	public User authenticateUserLockout(final String username, final String password,
			final String company, final String ipAddress) {
		final User loggedInUser = new User();
		Session currSession = this.getSession();
		currSession.doWork( new Work() {
			public void execute(Connection connection) throws SQLException {
				CallableStatement call = connection.prepareCall("{ call LCEC_USER.AUTHENTICATE_LOCKOUT(?, ?, ?, ?, ?, ?, ?, ?) }");
				call.setString(1, username);
				call.setString(2, company);
				call.setString(3, password);
				call.setString(4, ipAddress);
				call.registerOutParameter(5, OracleTypes.VARCHAR);
				call.registerOutParameter(6, OracleTypes.NUMBER);
				call.registerOutParameter(7, OracleTypes.NUMBER);
				call.registerOutParameter(8, OracleTypes.VARCHAR);
				call.execute();

				loggedInUser.setUserId(call.getString(5));
				loggedInUser.setLockoutTime(call.getLong(6));
				loggedInUser.setErrorCode(call.getLong(7));
				loggedInUser.setErrorMessage(call.getString(8));
				logger.debug("1. LOGGED IN USER ID " + loggedInUser.getUserId());
			}
	    });
		
		if (loggedInUser.getUserId() != null) {
			logger.debug("2. LOGGED IN USER ID " + loggedInUser.getUserId());
			return this.get(loggedInUser.getUserId());
		}
		this.releaseSession(currSession);
		
		// TODO: have logger log this attempt
		return loggedInUser;
	}
	
	@Override
	public User setPassword(final User user, final String newPassword) {
		Session currentSession = this.getSession();
		Work setPasswordSP = new Work(){
			public void execute(Connection connection) throws SQLException {
				CallableStatement call = connection.prepareCall("{ call LCEC_USER.SET_PASSWORD(?, ?, ?, ?) }");
				call.setString(1, user.getUserId());
				call.setString(2, newPassword);
				call.registerOutParameter(3, OracleTypes.NUMBER);
				call.registerOutParameter(4, OracleTypes.VARCHAR);
				
				call.execute();
				
				user.setErrorCode(call.getLong(3));
				user.setErrorMessage(call.getString(4));
			}
		};
		
		currentSession.doWork(setPasswordSP);
		// return updated user record
		User foundUser = this.get(user.getUserId());
		this.releaseSession(currentSession);
		return foundUser;
	}

	@Override
	public User updateUsername(final String newUsername, final String oldUsername, final String company){
		Session currentSession = this.getSession();
		final LRNError error = new LRNError();
		Work updateUsername = new Work(){
			public void execute(Connection connection) throws SQLException{
				CallableStatement call = connection.prepareCall("{ call LCEC_USER.UPD_LOGIN_NAME(?, ?, ?, ?, ?) }");
				call.setString(1, newUsername);
				call.setString(2, oldUsername);
				call.setString(3, company);
				call.registerOutParameter(4, OracleTypes.NUMBER);
				call.registerOutParameter(5, OracleTypes.VARCHAR);
				
				call.execute();
				
				error.setCode(call.getLong(4));
				error.setMessage(call.getString(5));
			}
		};
		
		currentSession.doWork(updateUsername);
		
		User user = findByUsername(newUsername, company);
		user.setError(error);
		this.releaseSession(currentSession);
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsersByUserIds(List<String> userIds) {
		Session currSession = this.getSession();
		Criteria userCriteria = currSession.createCriteria(User.class);
		userCriteria.add(Restrictions.in("userId", userIds));
		return userCriteria.list();
	}

	@Override
	public List<InUsersQueryResponseDTO> getInUsersQueryResponseDTO(List<String> userIds) {
		List<InUsersQueryResponseDTO> queryResponses = new ArrayList<InUsersQueryResponseDTO>();
		DataSource ds = SessionFactoryUtils.getDataSource(getSessionFactory());
		SimpleJdbcTemplate jdbcTemplate = new SimpleJdbcTemplate(ds);
				
		StringBuilder queryBuilder = new StringBuilder();		
		String userIdInParam = getInParam(userIds); 
		queryBuilder.append("select users.user_id as userid, users.firstname as firstname, users.lastname ");
		queryBuilder.append("as lastname, users.middlename as middlename, users.company as company, ");
		queryBuilder.append("users.login_name as username, users.email as email, users.active as active, ");
		queryBuilder.append("users.password as password from users where user_id in (");
		queryBuilder.append(userIdInParam).append(")");
		Iterator<Map<String, Object>> itr = jdbcTemplate.queryForList(queryBuilder.toString(), 
                new HashMap<String, Object>()).iterator();
        while(itr.hasNext()) {
            Map<String, Object> resultMap =itr.next();
            queryResponses.add(constructInUsersQueryResponseDTOFromMap(resultMap));
        }
		closeConnection(ds);

		return queryResponses;
	}

	@Override
	public User updateUser(User user) {
		return super.save(user);
	}

	/**
	 * Constructs comma separated string used at query from list
	 *
	 * @param List<Long> ids
	 * 
	 * @return String
	 */
	private String getInParam(List<String> ids) {
		StringBuilder queryBuilder = new StringBuilder();
		int counter = 0;
		for(String id : ids) {
			if(counter == 0) {
				queryBuilder.append("'").append(id).append("'");
			} else {
				queryBuilder.append(", '").append(id).append("'");
			}
			counter++;
		}
		return queryBuilder.toString();
	}

	/**
	 * Constructs InUsersQueryResponseDTO from query result map.
	 *
	 * @param Map<String, Object> resultMap
	 * 
	 * @return InUsersQueryResponseDTO
	 */
	private InUsersQueryResponseDTO constructInUsersQueryResponseDTOFromMap(
			Map<String, Object> resultMap) {
		InUsersQueryResponseDTO queryResponseDTO = new InUsersQueryResponseDTO();
		queryResponseDTO.setCompany((String)resultMap.get("company"));
		queryResponseDTO.setEmail((String)resultMap.get("email"));
		queryResponseDTO.setFirstName((String)resultMap.get("firstname"));
		queryResponseDTO.setIsActive(false);
		String active = (String)resultMap.get("active"); 
		if(null != active && active.equalsIgnoreCase("t")) {
			queryResponseDTO.setIsActive(true);
		}		
		queryResponseDTO.setLastName((String)resultMap.get("lastname"));
		queryResponseDTO.setMiddleName((String)resultMap.get("middlename"));
		queryResponseDTO.setPassword((String)resultMap.get("password"));
		queryResponseDTO.setUserId((String)resultMap.get("userid"));
		queryResponseDTO.setUsername((String)resultMap.get("username"));
		return queryResponseDTO;
	}
	
	/**
	 * Constructs InUsersQueryResponseDTO from query result map.
	 *
	 * @param Map<String, Object> resultMap
	 * 
	 * @return InUsersQueryResponseDTO
	 */
	private InUsersQueryResponseDTO constructInUsersQueryResponseDTOFromUserModel(
			User user) {
		InUsersQueryResponseDTO queryResponseDTO = new InUsersQueryResponseDTO();
		queryResponseDTO.setCompany(user.getCompany());
		queryResponseDTO.setEmail(user.getEmail());
		queryResponseDTO.setFirstName(user.getFirstName());
		queryResponseDTO.setIsActive(user.getIsActive());
		queryResponseDTO.setLastName(user.getLastName());
		queryResponseDTO.setMiddleName(user.getMiddleName());
		queryResponseDTO.setPassword(user.getPassword());
		queryResponseDTO.setUserId(user.getUserId());
		queryResponseDTO.setUsername(user.getUsername());
		return queryResponseDTO;
	}
	
	@Override
	public InUsersQueryResponseDTO findByUsernameCompany(String username, String company){
		String[] paramNames = {"username", "company"};
		Object[] paramValues = {username, company};
		List<User> users = findByNamedQuery("findByUsername", paramNames, paramValues);
		if ( users.size() > 0 ) {
			InUsersQueryResponseDTO inUsersQueryResponseDTO = constructInUsersQueryResponseDTOFromUserModel(users.get(0));
			return inUsersQueryResponseDTO;
		}
		return null;
	}
	
	@Override
	public User updatePasswordModDate(User user) {
		DataSource ds = SessionFactoryUtils.getDataSource(getSessionFactory());
		SimpleJdbcTemplate jdbcTemplate = new SimpleJdbcTemplate(ds);
		StringBuilder queryBuilder = new StringBuilder();
		
		queryBuilder.append("UPDATE users SET password_mod_date = ? WHERE user_id = ? ");
		jdbcTemplate.update(queryBuilder.toString(), new Object[]{user.getPasswordModDate(), user.getUserId()});
		
		closeConnection(ds);

		return user;
	}
	
	/* (non-Javadoc)
	 * @see com.lrn.dao.IUserDao#newUser(java.util.TreeMap)
	 */
	@Override
	public User newUser(final TreeMap<String, String> user) {
		Session currentSession = this.getSession();
		Work createUser = new Work(){
			public void execute(Connection connection) throws SQLException {
				StringBuilder procedure = new StringBuilder(); 
				procedure.append("{ call LCEC_USER.NEW(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ");
				procedure.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ");
				procedure.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ");
				procedure.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
				CallableStatement call = connection.prepareCall(procedure.toString());
				call.setString(1, user.get("Password"));			//password
				call.setString(2, user.get("FirstName"));			//firstname
				call.setString(3, user.get("MiddleName"));			//middlename
				call.setString(4, user.get("LastName"));			//lastname
				call.setString(5, user.get("EmpId"));				// empid
				call.setString(6, user.get("Email"));				// email
				call.setString(7, user.get("Company"));				//company
				call.setString(8, user.get("City"));				// city
				call.setString(9, user.get("Division"));			// division
				call.setString(10, user.get("SuperFirstName"));		// superfirstname
				call.setString(11, user.get("SuperMiddleName"));	// supermiddlename
				call.setString(12, user.get("SuperLastName"));		// superlastname
				call.setString(13, user.get("Login_name"));			// login_name
				call.setInt(14, (user.get("Active").equals("t") ? 1:0));				// active
				call.setString(15, null);							// access_id
				call.setString(16, null);							// DOB
				call.setString(17, null);							// secret
				call.setString(18, user.get("HAddress_1"));			// haddress_1
				call.setString(19, user.get("HAddress_2"));			// haddress_2
				call.setString(20, user.get("HCity"));				// hcity
				call.setString(21, user.get("HState"));				// hstate
				call.setString(22, user.get("HZip"));				// hzip
				call.setString(23, user.get("HCountry"));			// hcountry
				call.setString(24, user.get("HPhone"));				// hphone
				call.setString(25, user.get("Title"));				// title
				call.setString(26, user.get("Address_1"));			// address_1
				call.setString(27, user.get("Address_2"));			// address_2
				call.setString(28, user.get("State"));				// state
				call.setString(29, user.get("Zip"));				// zip
				call.setString(30, user.get("Country"));			// country
				call.setString(31, user.get("Phone"));				// phone
				call.setString(32, user.get("Fax"));				// fax
				call.setString(33, user.get("CostCenter"));			// costcenter
				call.setString(34, null);							// permissions
				call.setString(35, user.get("Language"));			// language
				call.setString(36, user.get("Browser"));			// browser
				call.setString(37, user.get("Custom_22"));
				call.setString(38, user.get("Custom_23"));
				call.setString(39, user.get("Custom_24"));
				call.setString(40, user.get("Custom_25"));
				call.setString(41, user.get("Custom_26"));							
				call.setString(42, user.get("Custom_27"));							
				call.setString(43, user.get("Custom_28"));							
				call.setString(44, user.get("Custom_29"));							
				call.setString(45, user.get("Custom_30"));							
				call.setString(46, user.get("Custom_31"));							
				call.setString(47, user.get("Custom_32"));
				call.setString(48, user.get("Custom_33"));
				call.setString(49, user.get("Custom_34"));
				call.setString(50, user.get("Custom_35"));
				call.setString(51, user.get("Custom_36"));				
				call.setString(52, user.get("Custom_37"));							
				call.setString(53, user.get("Custom_38"));							
				call.setString(54, user.get("Custom_39"));							
				call.setString(55, user.get("Custom_40"));							
				call.setString(56, user.get("Custom_41"));
				call.setInt(57, 0);									// expire_password
				call.registerOutParameter(58, OracleTypes.VARCHAR);
				call.registerOutParameter(59, OracleTypes.NUMBER);
				call.registerOutParameter(60, OracleTypes.VARCHAR);
				call.execute();

				user.put("UserId", String.valueOf(call.getLong(58)));
				user.put("ErrorCode", (call.getLong(59) == 0) ? null : String.valueOf(call.getLong(59)));
				user.put("ErrorMessage", call.getString(60));
				logger.debug(call.getString(60));
			}
		};
		currentSession.doWork(createUser);
		// user with newly created user_id
		User insertedUser = this.get(user.get("UserId"));
		this.releaseSession(currentSession);
		
		return insertedUser;
	}

	/* (non-Javadoc)
	 * @see com.lrn.dao.IUserDao#updateUserDetail(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Boolean updateUserDetail(String userId, String columnName,
			String value) {
		DataSource ds = SessionFactoryUtils.getDataSource(getSessionFactory());
		SimpleJdbcTemplate jdbcTemplate = new SimpleJdbcTemplate(ds);
		
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("UPDATE users SET ").append(columnName).append(" = ? WHERE user_id = ? ");
		jdbcTemplate.update(queryBuilder.toString(), new Object[]{value, userId});
		
		closeConnection(ds);

		return true;
	}

	@Override
	public UserLabelsDTO getCustomLabelsByUserIdAndCompany(String userId, String company) {
		
		DataSource ds = SessionFactoryUtils.getDataSource(getSessionFactory());
		SimpleJdbcTemplate jdbcTemplate = new SimpleJdbcTemplate(ds);
		
		StringBuilder queryBuilder = new StringBuilder();			
		queryBuilder.append("select * from company_users_column where company = ?");
		
		ArrayList<Object> params = new ArrayList<Object> ();
		params.add(company);

		List<Map<String, Object>> resultSetMapList = queryForList(queryBuilder.toString(), params);
		Iterator<Map<String, Object>> itr = resultSetMapList.iterator();
		
		List<UserLabelDTO> userLabelsList = new ArrayList<UserLabelDTO> ();
        while(itr.hasNext()) {
            Map<String, Object> resultMap = itr.next();
            UserLabelDTO ul = getUserLabel(resultMap);
            userLabelsList.add(ul);
        }
        
        //update the userValue field in UserLabelDTO with the value from DB
        String columnNameParam = getColumnNameInParam(userLabelsList);
        queryBuilder = new StringBuilder();
        queryBuilder.append("select ").append(columnNameParam).append(" from users");
        queryBuilder.append(" where company = '").append(company);
        queryBuilder.append("' and user_id = '").append(userId).append("'");
       
        itr = jdbcTemplate.queryForList(queryBuilder.toString(), new HashMap<String, Object>()).iterator();
        while(itr.hasNext()) {
	        Map<String, Object> resultMap = itr.next();
	        for(UserLabelDTO dto : userLabelsList) {
	        	dto.setUserValue((String) resultMap.get(dto.getColumnName()));
	        }
        }
        
        UserLabelsDTO dto = new UserLabelsDTO();
        dto.setUserLabelList(userLabelsList);
		closeConnection(ds);

		return dto;
	}
	
	@Override
	public HashMap<String, String> getLcecColumnsForEntity(String entityName){

		HashMap<String, String> columnMap = new HashMap<String, String>();
		ApplicationContext context = ApplicationContextProvider.getApplicationContext();
		AnnotationSessionFactoryBean factoryBean = (AnnotationSessionFactoryBean)context.getBean("&lcecSessionFactory");
				
		PersistentClass pClass = factoryBean.getConfiguration().getClassMapping(entityName);
		
		Iterator it = pClass.getPropertyIterator();
		while(it.hasNext()){
			
			Property pProperty = (Property)it.next(); 
			Column column = null; 
			if (pProperty.getColumnSpan() <= 1) { 
				column = (Column) pProperty.getColumnIterator().next();
				columnMap.put(column.getName(), pProperty.getName());
			}
		}
		
		return columnMap;
	
	}

	
	public Object getLcecPropertyValueByColumnName(String entityName, Object entity, String propertyName) {
		
		return getSessionFactory().getClassMetadata(entityName).getPropertyValue(entity, propertyName, EntityMode.POJO);
			
	}
	
	public void setLcecPropertyValueByPropertyName(String entityName, Object entity, String propertyName, String columnName, Object value, String userId) {
		
		getSessionFactory().getClassMetadata(entityName).setPropertyValue(entity, propertyName, value, EntityMode.POJO);
		
		updateUserDetail(userId, columnName, (value != null ? value.toString() : null));
	}
	

	public String getPropertyNameForEntity(String entityName, String columnName) {		
	
		ApplicationContext context = ApplicationContextProvider.getApplicationContext();
		AnnotationSessionFactoryBean factoryBean = (AnnotationSessionFactoryBean)context.getBean("&lcecSessionFactory");
		PersistentClass pClass = factoryBean.getConfiguration().getClassMapping(entityName); 
		String propertyName = null;
		
		Iterator it = pClass.getPropertyIterator();
		while(it.hasNext()){
			
			Property pProperty = (Property)it.next(); 
			Column column = null; 
			if (pProperty.getColumnSpan() <= 1) { 
				column = (Column) pProperty.getColumnIterator().next();
				if (column.getName().equalsIgnoreCase(columnName)) {
					propertyName = pProperty.getName(); 
					break;
				}
			}
		}
		return propertyName;
		
	}

	private UserLabelDTO getUserLabel(Map<String, Object> rs) {
		UserLabelDTO dto = new UserLabelDTO();
		
		dto.setColumnName((String)rs.get("column_name"));
		dto.setCompany((String)rs.get("company"));
		dto.setDisplayName((String)rs.get("display_name"));
		
		BigDecimal reportPosition = (BigDecimal)rs.get("report_position");
		if(reportPosition != null)
			dto.setReportPosition(reportPosition.longValue());
		
		BigDecimal searchCriteria = (BigDecimal)rs.get("search_criteria");
		if(searchCriteria != null)
			dto.setSearchCriteria(searchCriteria.longValue());
		
		dto.setSourceOfData((String)rs.get("source_of_data"));
		
		BigDecimal editAllowed = (BigDecimal)rs.get("edit_allowed");
		if(editAllowed != null)
			dto.setEditAllowed(editAllowed.longValue());
		
		BigDecimal privilegeVisibilityLevel = (BigDecimal)rs.get("privilege_visibility_level");
		if(privilegeVisibilityLevel != null)
			dto.setPrivilegeVisibilityLevel(privilegeVisibilityLevel.longValue());
		
		BigDecimal requiredField = (BigDecimal)rs.get("required_field");
		if(requiredField != null)
			dto.setRequiredField(requiredField.longValue());
		
		BigDecimal fieldType = (BigDecimal)rs.get("field_type");
		if(fieldType != null)
			dto.setFieldType(fieldType.longValue());
		
		dto.setInstructionText((String)rs.get("instruction_text"));
		dto.setFieldFormat((String)rs.get("field_format"));
		
		BigDecimal protectedField= (BigDecimal)rs.get("protected_field");
		if(protectedField != null)
			dto.setProtectedField(protectedField.longValue());
		
		return dto;
	}
	
	/**
	 * Constructs comma separated string used at query from list
	 *
	 * @param List<Long> ids
	 * 
	 * @return String
	 */
	private String getColumnNameInParam(List<UserLabelDTO> list) {
		StringBuilder queryBuilder = new StringBuilder();
		int counter = 0;
		for(UserLabelDTO dto : list) {
			if(counter == 0) {
				queryBuilder.append("").append(dto.getColumnName()).append("");
			} else {
				queryBuilder.append(", ").append(dto.getColumnName()).append("");
			}
			counter++;
		}
		return queryBuilder.toString();
	}

	@Override
	public boolean canUseApp(String userId, String company, String appName,
			String appActsOn) {
		
		BigDecimal count = null;
		appActsOn = (appActsOn.equals("")) ? "Group" : appActsOn;
		
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("SELECT count(app.object_flags) as count FROM permissions_app app ");
		queryBuilder.append(" WHERE app.object_type = 'App' AND app.object = ?");
		queryBuilder.append(" AND group_id IN ( SELECT group_id FROM permissions usr WHERE usr.object_type = 'User' ");
		queryBuilder.append(" AND usr.object = ?");
		queryBuilder.append(" AND usr.group_id IN (SELECT group_id FROM permissions_group_section grp ");
		queryBuilder.append(" WHERE grp.object_type = ?");
		queryBuilder.append(" AND grp.object = ?").append("))");
		logger.debug(queryBuilder.toString());

		ArrayList<Object> params = new ArrayList<Object> ();
		params.add(appName);
		params.add(userId);
		params.add(appActsOn);
		params.add(company);
		
		List<Map<String, Object>> resultSetMapList = queryForList(queryBuilder.toString(), params);
		Iterator<Map<String, Object>> itr = resultSetMapList.iterator();
		
		while (itr.hasNext()) {
			Map<String, Object> resultMap = itr.next();
			count = (BigDecimal) resultMap.get("count");
		}
		logger.debug(count);
		logger.debug(count.intValue());
		if(count.intValue() > 0) return true;
		
		return false;
	}

	@Override
	public boolean checkLCECAdminToolsAccess(String userId, String company,
			String appNameList, String appActsOn) {
		
		appActsOn = (appActsOn.equals("")) ? "Group" : appActsOn;
		
		StringBuilder queryBuilder = new StringBuilder();
		
		queryBuilder.append("select app.object, count(app.object) as count from permissions usr, permissions_group_section grp, permissions_app app");
		queryBuilder.append(" where usr.group_id = grp.group_id and usr.group_id = app.group_id and");
		queryBuilder.append(" usr.object_type = 'User' AND usr.object = ?");
		queryBuilder.append(" and grp.object_type = ?");
		queryBuilder.append(" AND grp.object = ?");
		queryBuilder.append(" and app.object_type = 'App' AND app.object in (").append(appNameList).append(")");
		queryBuilder.append(" group by app.object");
		
//		logger.debug(queryBuilder.toString());
		
		ArrayList<Object> params = new ArrayList<Object> ();
		params.add(userId);
		params.add(appActsOn);
		params.add(company);
		

		List<Map<String, Object>> resultSetMapList = queryForList(queryBuilder.toString(), params);
		Iterator<Map<String, Object>> itr = resultSetMapList.iterator();
		
		while (itr.hasNext()) {
			Map<String, Object> resultMap = itr.next();
			BigDecimal count = (BigDecimal) resultMap.get("count");
			if(count != null && count.longValue() > 0)
				return true;
		}
		
		return false;
	}

	@Override
	public boolean hasSiteCustomizerEditPermission(String userId, String company) {
		
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("SELECT u.login_name, u.COMPANY, pu.OBJECT as User_id, g.groupid, g.NAME as GroupName, p.OBJECT as APP_Permission, af.feature  ");
		queryBuilder.append("FROM GROUPS g , PERMISSIONS p , APPLICATION_FEATURE af, GROUPS gu , PERMISSIONS pu, USERS u  ");
		queryBuilder.append("WHERE g.groupid = p.group_id AND af.application = p.OBJECT AND p.object_type = 'App' AND g.groupid = gu.groupid AND gu.groupid = pu.group_id ");
		queryBuilder.append("AND u.user_id = pu.OBJECT AND SUBSTR(p.object_flags, INSTR(p.object_flags, ';')+1) <> '0x0' AND af.BIT_VALUE  = BITAND( af.BIT_VALUE, hexstr2num( SUBSTR(p.object_flags, INSTR(p.object_flags, ';')+1) ) )  ");
		queryBuilder.append("and p.OBJECT = 'SiteCustomizer' and af.feature = 'edit' ");
		queryBuilder.append(" AND u.COMPANY = ?");
		queryBuilder.append(" AND u.user_id = ?");
		logger.debug(queryBuilder.toString());
		
		ArrayList<Object> params = new ArrayList<Object> ();
		params.add(company);
		params.add(userId);

		List<Map<String, Object>> resultSetMapList = queryForList(queryBuilder.toString(), params);
		Iterator<Map<String, Object>> itr = resultSetMapList.iterator();
		
		if(itr.hasNext()) 
			return true;
		
		return false;
	}

	@Override
	public List<UsersByEmailAndSiteIdQueryResponseDTO> getUsersByEmailAndSiteIdQueryResponseDTO(
			String email, Long siteId) {
		
		List<UsersByEmailAndSiteIdQueryResponseDTO> queryResponses = new ArrayList<UsersByEmailAndSiteIdQueryResponseDTO>();
		StringBuilder queryBuilder = new StringBuilder();		
		queryBuilder.append("select users.user_id as userid, users.firstname as firstname, users.lastname ");
		queryBuilder.append("as lastname, users.middlename as middlename, users.company as company, ");
		queryBuilder.append("users.login_name as username, users.email as email, users.active as active, ");
		queryBuilder.append("users.password as password from users, site_user where users.user_id = ");
		queryBuilder.append("site_user.user_id and site_user.site_id = ?");
		queryBuilder.append(" and upper(users.email) = upper(?)");
		
		ArrayList<Object> params = new ArrayList<Object> ();
		params.add(siteId);
		params.add(email);

		List<Map<String, Object>> resultSetMapList = queryForList(queryBuilder.toString(), params);
		Iterator<Map<String, Object>> itr = resultSetMapList.iterator();
		
        while(itr.hasNext()) {
            Map<String, Object> resultMap =itr.next();
            queryResponses.add(constructUsersByEmailAndSiteIdQueryResponseDTOFromMap(resultMap));
        }
		return queryResponses;
	}
	
	/**
	 * Constructs UsersByEmailQueryResponseDTO from query result map.
	 *
	 * @param Map<String, Object> resultMap
	 * 
	 * @return UsersByEmailQueryResponseDTO
	 */
	private UsersByEmailAndSiteIdQueryResponseDTO constructUsersByEmailAndSiteIdQueryResponseDTOFromMap(
			Map<String, Object> resultMap) {
		UsersByEmailAndSiteIdQueryResponseDTO queryResponseDTO = new UsersByEmailAndSiteIdQueryResponseDTO();
		queryResponseDTO.setCompany((String)resultMap.get("company"));
		queryResponseDTO.setEmail((String)resultMap.get("email"));
		queryResponseDTO.setFirstName((String)resultMap.get("firstname"));
		queryResponseDTO.setIsActive(false);
		String active = (String)resultMap.get("active"); 
		if(null != active && active.equalsIgnoreCase("t")) {
			queryResponseDTO.setIsActive(true);
		}		
		queryResponseDTO.setLastName((String)resultMap.get("lastname"));
		queryResponseDTO.setMiddleName((String)resultMap.get("middlename"));
		queryResponseDTO.setPassword((String)resultMap.get("password"));
		queryResponseDTO.setUserId((String)resultMap.get("userid"));
		queryResponseDTO.setUsername((String)resultMap.get("username"));
		return queryResponseDTO;
	}
	
	
}
