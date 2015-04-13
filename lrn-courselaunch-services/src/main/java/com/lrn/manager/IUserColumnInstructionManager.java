package com.lrn.manager;

import java.util.List;

import com.lrn.model.lcec.UserColumnInstruction;



public interface IUserColumnInstructionManager extends IGenericManager<UserColumnInstruction, Long> {

	public List<UserColumnInstruction> getPublishedUserColumnInstruction(Long siteId, String language);
	
	public List<UserColumnInstruction> getUnpublishedUserColumnInstruction(Long siteId, String language);
	
	public boolean deletePublishedSelfRegistrationProfile(Long siteId, String language);
}
