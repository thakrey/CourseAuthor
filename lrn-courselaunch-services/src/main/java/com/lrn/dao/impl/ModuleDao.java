package com.lrn.dao.impl;

import com.lrn.dao.IModuleDao;
import com.lrn.model.hibernate.module.Module;

/**
 * The Class ModuleDao.
 *
 * @author kishor.pawar
 */
public class ModuleDao extends GenericDao<Module, Long> implements IModuleDao {
	
	public ModuleDao(Class<Module> persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	}
}