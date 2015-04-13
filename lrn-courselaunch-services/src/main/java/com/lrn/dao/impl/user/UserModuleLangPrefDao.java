package com.lrn.dao.impl.user;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.lrn.dao.impl.GenericDao;
import com.lrn.dao.user.IUserModuleLangPrefDao;
import com.lrn.model.hibernate.user.UserModuleLangPref;
import com.lrn.model.spring.service.response.site.SiteConfigsDTO;

/**
 * The Class UserSurveyModuleDao.
 *
 * @author kishor.pawar
 */
public class UserModuleLangPrefDao extends GenericDao<UserModuleLangPref, Long> implements IUserModuleLangPrefDao {

	public UserModuleLangPrefDao(Class<UserModuleLangPref> persistentClass) {
		super(persistentClass);
	}
	
	@Override
	public List<UserModuleLangPref> getUserModuleLangPref(String userId, Long siteId, Long moduleId) {
		SiteConfigsDTO dto = new SiteConfigsDTO();
		
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select * from USER_MODULE_LANG_PREF where site_id = ").append(siteId);
		queryBuilder.append(" and user_id = '").append(userId).append("'");
		queryBuilder.append(" and module_id = ").append(moduleId);
		
		Iterator<Map<String, Object>> itr = findBySqlQuery(queryBuilder.toString());
		List<UserModuleLangPref> list = new ArrayList<UserModuleLangPref> ();
		while (itr.hasNext()) {
			Map<String, Object> resultMap = itr.next();
			UserModuleLangPref pref = getUserModuleLangPrefData(resultMap);
			list.add(pref);
		}
		
		return list;
	}
	
	/**
	 * Constructs UserModuleLangPref.
	 *
	 * @param Map<String, Object> resultMap
	 * 
	 * @return UserModuleLangPref
	 */
	private UserModuleLangPref getUserModuleLangPrefData(Map<String, Object> resultMap) {
		UserModuleLangPref pref = new UserModuleLangPref();
		pref.setId(((BigDecimal) resultMap.get("id")).longValue());
		pref.setLanguage((String) resultMap.get("language"));
		pref.setModuleId(((BigDecimal) resultMap.get("module_id")).longValue());
		pref.setSiteId(((BigDecimal) resultMap.get("site_id")).longValue());
		pref.setUserId((String) resultMap.get("user_id"));
		pref.setCreated((Date)resultMap.get("created"));
		pref.setUpdated((Date)resultMap.get("updated"));
		return pref;
	}
}