package com.lrn.manager;

import java.util.List;

import com.lrn.model.hibernate.module.ModuleChainMembers;

/**
 * The Interface IModuleChainMembersManager
 * 
 *
 */
public interface IModuleChainMembersManager extends IGenericManager<ModuleChainMembers, Long> {

	/**
	 * Returns Module Chain Members
	 * @param moduleChainIds
	 * @return
	 */
	List<ModuleChainMembers> getModuleChainMembersByModuleChainIds(List<Long> moduleChainIds);

}