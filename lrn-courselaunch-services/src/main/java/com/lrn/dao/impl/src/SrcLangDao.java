package com.lrn.dao.impl.src;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.lrn.dao.impl.GenericDao;
import com.lrn.dao.src.ISrcLangDao;
import com.lrn.model.hibernate.src.SrcLang;

/**
 * The Class SrcLangDao.
 *
 * @author kishor.pawar
 */
public class SrcLangDao extends GenericDao<SrcLang, String> implements
		ISrcLangDao {

	public SrcLangDao(Class<SrcLang> persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public SrcLang get(String language) {
		SrcLang srcLang = null;
		
		DataSource ds = SessionFactoryUtils.getDataSource(getSessionFactory());
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(ds);
		StringBuilder queryBuilder = new StringBuilder();	
		
		queryBuilder.append("SELECT lang_code, country_code, en_name, label");
		queryBuilder.append(" from SRC_LANG where language = '").append(language).append("'");
		
		Iterator<Map<String, Object>> itr = jdbcTemplate.queryForList(queryBuilder.toString(), 
                new HashMap<String, Object>()).iterator();
        while(itr.hasNext()) {
            Map<String, Object> resultMap =itr.next();
            srcLang = getSrcLangFromResultMap(resultMap);
            srcLang.setLanguage(language);
        }
        
		closeConnection(ds);
        return srcLang;
	}
	
	private SrcLang getSrcLangFromResultMap(Map<String, Object> resultMap) {
		SrcLang srcLang = new SrcLang();
		
		srcLang.setLangCode((String)resultMap.get("lang_code"));
		srcLang.setCountryCode((String)resultMap.get("country_code"));
		srcLang.setEnName((String)resultMap.get("en_name"));
		srcLang.setLabel((String)resultMap.get("label"));
		
		return srcLang;
	}	
	
}
