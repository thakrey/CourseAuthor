package com.lrn.service;
import javax.jws.WebService;
import com.lrn.model.spring.service.response.LRNResponse;

@WebService
public interface IAccessControlService{
	/**
     * Get the legacy applications for the specified userId and siteId
     *
     * @param String userId the userId of the legacy applications
     * @param Long siteId the siteId of the legacy applications
     * 
     * @return {@link LRNResponse}, holds {@link LegacyApplicationDTO} in the DataObject
     */

	LRNResponse getLegacyApplications(String userId, Long siteId);

	LRNResponse getLegacyApplicationsByUserCompany(String userId, String company);
}
