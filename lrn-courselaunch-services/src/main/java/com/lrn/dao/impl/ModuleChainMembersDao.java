package com.lrn.dao.impl;

import com.lrn.dao.IModuleChainMembersDao;
import com.lrn.model.hibernate.module.ModuleChainMembers;

/**
 * The Class ModuleChainMembersDao.
 *
 * @author kishor.pawar
 */
public class ModuleChainMembersDao extends GenericDao<ModuleChainMembers, Long> implements
		IModuleChainMembersDao {
	
	public ModuleChainMembersDao(Class<ModuleChainMembers> persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	}
}