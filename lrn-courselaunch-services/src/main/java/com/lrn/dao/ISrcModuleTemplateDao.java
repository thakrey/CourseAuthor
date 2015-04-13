/**
 * 
 */
package com.lrn.dao;

import com.lrn.model.hibernate.SrcModuleTemplate;



/**
 * @author 
 *
 */
public interface ISrcModuleTemplateDao extends IGenericDao<SrcModuleTemplate, Long> {
	
	String getTemplateByPrecedence(String template) ;

}
