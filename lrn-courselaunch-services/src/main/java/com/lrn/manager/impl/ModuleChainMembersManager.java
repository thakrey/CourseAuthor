package com.lrn.manager.impl;

import java.util.List;

import com.lrn.dao.IGenericDao;
import com.lrn.dao.IModuleChainMembersDao;
import com.lrn.manager.IModuleChainMembersManager;
import com.lrn.model.hibernate.module.ModuleChainMembers;

/**
 * The Class ModuleChainMembersManager
 * 
 * @author kishor.pawar
 */
public class ModuleChainMembersManager extends GenericManager<ModuleChainMembers, Long> implements
		IModuleChainMembersManager {
	
	private IModuleChainMembersDao moduleChainMembersDao;

	public ModuleChainMembersManager(
			IGenericDao<ModuleChainMembers, Long> iGenericDao) {
		super(iGenericDao);
	}

	/**
	 * @param moduleChainMembersDao the moduleChainMembersDao to set
	 */
	public void setModuleChainMembersDao(
			IModuleChainMembersDao moduleChainMembersDao) {
		this.moduleChainMembersDao = moduleChainMembersDao;
	}

	@Override
	public List<ModuleChainMembers> getModuleChainMembersByModuleChainIds(
			List<Long> moduleChainIds) {
		String[] paramNames = { "moduleChainIds" };
		Object[] paramValues = { moduleChainIds };
		return moduleChainMembersDao.findByNamedQuery("findModuleChainMembersByModuleChainIds", paramNames, paramValues);
	}
}