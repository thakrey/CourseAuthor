/*package com.lrn.service.impl;
import org.apache.log4j.Logger;

import com.lrn.dto.response.accessControl.LegacyApplicationDTO;
import com.lrn.dto.response.site.SiteInfoDTO;
import com.lrn.model.LRNError;
import com.lrn.model.LRNResponse;
import com.lrn.service.IAccessControlService;

public class AccessControlService implements IAccessControlService  {
private static final Logger logger = Logger.getLogger(AccessControlService.class);
*//**
 * Get the legacy applications for the specified userId and siteId
 *
 * @param String userId the userId of the legacy applications
 * @param Long siteId the siteId of the legacy applications
 * 
 * @return {@link LRNResponse}, holds {@link LegacyApplicationDTO} in the DataObject
 *//*

public LRNResponse getLegacyApplications(String userId,	Long siteId) {
	LRNResponse response = new LRNResponse();
	LRNError error = new LRNError();
	LegacyApplicationDTO legacyApplicationsDTO = new LegacyApplicationDTO();
	try {
		SiteInfoDTO siteInfo = siteAdapter.getInfo(siteId);
		long begin = System.currentTimeMillis();
		List<User> users = userAdapter.getUsersByUserIdAndCompany(userId, siteInfo.getName());
		long end = System.currentTimeMillis();
		System.out.println("getUsersByUserIdAndCompany " + (end - begin) + " ms");
		if(users.size() > 0) {
			legacyApplicationsDTO.setLcec(true);
		}
		begin = System.currentTimeMillis();
		if(userAdapter.canAccessLCECAdminTools(userId, siteInfo.getName())){
			legacyApplicationsDTO.setLcecAdmin(true);
		}
		end = System.currentTimeMillis();
		System.out.println("canAccessLCECAdminTools " + (end - begin) + " ms");
		response.setDataObject(legacyApplicationsDTO);
		response.setSuccess(true);
	} catch (Exception exception) {
		error.setMessage(exception.getMessage());
        error.setCode(-1L);
        response.setError(error);
        response.setSuccess(false);
	}
	return response;
}


public LRNResponse getLegacyApplicationsByUserCompany(String userId, String company) {
	LRNResponse response = new LRNResponse();
	LRNError error = new LRNError();
	LegacyApplicationDTO legacyApplicationsDTO = new LegacyApplicationDTO();
	try {
		List<User> users = userAdapter.getUsersByUserIdAndCompany(userId, company);
		if(users.size() > 0) {
			legacyApplicationsDTO.setLcec(true);
		}
		if(userAdapter.checkLCECAdminToolsAccess(userId, company)){
			legacyApplicationsDTO.setLcecAdmin(true);
		}
		response.setDataObject(legacyApplicationsDTO);
		response.setSuccess(true);
	} catch (Exception exception) {
		error.setMessage(exception.getMessage());
        error.setCode(-1L);
        response.setError(error);
        response.setSuccess(false);
	}
	return response;
}
}
*/