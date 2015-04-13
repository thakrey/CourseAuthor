package com.lrn.dao.src;

import java.util.List;

import com.lrn.dao.IGenericDao;
import com.lrn.model.hibernate.CourseLookup;
import com.lrn.model.hibernate.src.SrcLang;
import com.lrn.model.hibernate.user.User;

/**
 * 
 * Interface ISrcLangDao
 * 
 * @author kishore.ohal
 */
public interface ISrcLangDao extends IGenericDao<SrcLang, String> {
		
	/**
	 * Get the SrcLang object.
	 *
	 * @param language
	 */
	SrcLang get(String language);
}