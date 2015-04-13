/**
 * 
 */
package com.lrn.dao.impl;



import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;

import com.lrn.dao.ISrcModuleTemplateDao;
import com.lrn.model.hibernate.SrcModuleTemplate;

/**
 * @author 
 *
 */
public class SrcModuleTemplateDao extends GenericDao<SrcModuleTemplate, Long> implements ISrcModuleTemplateDao {

	private static final Logger logger = Logger.getLogger(SrcModuleTemplateDao.class);
	
	public SrcModuleTemplateDao(Class<SrcModuleTemplate> persistentClass){
		super(persistentClass);
	}
	
	
	/**
	 * gets the template for app id 8 with the lowest precedence -(high priority)
	 * @param template
	 * @return template
	 */
	public String getTemplateByPrecedence(String template) {
		
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select name from SRC_MODULE_TEMPLATE smt where smt.src_course_app_id = ").append(SrcModuleTemplate.SRC_APP_ID_TEMPLATE);
		queryBuilder.append("  and precedence = (select min(precedence) from SRC_MODULE_TEMPLATE "); 
		queryBuilder.append(" where src_course_app_id = ");
		queryBuilder.append(SrcModuleTemplate.SRC_APP_ID_TEMPLATE);
		queryBuilder.append(" and name in ( ").append(template).append(" ) ) ");		
		Iterator<Map<String, Object>> itr = findBySqlQuery(queryBuilder.toString());
		
		String finalTemplate = "";
		boolean hasMore = false;
		if(!itr.hasNext()) {
			// return empty finalTemplate
		}
		while (itr.hasNext()) {
			finalTemplate = (String) itr.next().get("name");
			break;
		}
		return finalTemplate;
	}
	

}
