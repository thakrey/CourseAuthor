package com.lrn.manager.impl;

import java.util.List;

import com.lrn.dao.ICompletionCertificateDao;
import com.lrn.dao.IGenericDao;
import com.lrn.manager.ICompletionCertificateManager;
import com.lrn.model.hibernate.CompletionCertificate;

/**
 * The Class CompletionCertificateManager.
 *
 * @author kishor.pawar
 */
public class CompletionCertificateManager extends GenericManager<CompletionCertificate, Long>
		implements ICompletionCertificateManager {

	private ICompletionCertificateDao completionCertificateDao;
	
	public CompletionCertificateManager(
			IGenericDao<CompletionCertificate, Long> iGenericDao) {
		super(iGenericDao);
	}

	/**
	 * @param completionCertificateDao the completionCertificateDao to set
	 */
	public void setCompletionCertificateDao(
			ICompletionCertificateDao completionCertificateDao) {
		this.completionCertificateDao = completionCertificateDao;
	}

	@Override 
	public List<CompletionCertificate> getCompletionCertificatesByUserByCompany(String userId, 
			String company) {
		return completionCertificateDao.getCompletionCertificatesByUserByCompany(userId, company);
	}

	@Override
	public List<CompletionCertificate> getCompletionCertificatesByUserIdCompanyModuleIds(String userId, String company, List<Long> moduleIds) {
		String[] paramNames = { "userId", "company", "moduleIds" };
		Object[] paramValues = { userId, company, moduleIds };
		return completionCertificateDao.findByNamedQuery("findCompletionByUserIdCompanyModuleIds", paramNames, paramValues);
	}

	@Override
	public List<CompletionCertificate> getCompletionForOpenCampaigns(
			String userId, String company, List<Long> moduleIds, List<Long> curriculumIds, Long siteId) {
		return completionCertificateDao.getCompletionForOpenCampaigns(userId, company, moduleIds, curriculumIds, siteId);
	}
}