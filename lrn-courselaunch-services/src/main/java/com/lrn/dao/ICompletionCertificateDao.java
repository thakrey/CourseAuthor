package com.lrn.dao;

import java.util.List;

import com.lrn.model.hibernate.CompletionCertificate;

/**
 * Interface ICompletionCertificateDao
 * 
 * @author kishor.pawar
 */
public interface ICompletionCertificateDao extends IGenericDao<CompletionCertificate, Long> {
	
	/**
     * Gets list of CompletionCertificate by userId and company.
     *
     * @param String userId
     * @param String company
     * 
     * @return List<CompletionCertificate>
     */
	List<CompletionCertificate> getCompletionCertificatesByUserByCompany(String userId, String company);
	
	/**
	 * Returns Open Campaigns
	 * 
	 * @param userId
	 * @param company
	 * @param moduleIds
	 * @param List<Long> curriculumIds 
	 * @param Long siteId
	 * 
	 * @return List<CompletionCertificate>
	 */
	List<CompletionCertificate> getCompletionForOpenCampaigns(
			String userId, String company, List<Long> moduleIds, List<Long> curriculumIds, Long siteId);
}
