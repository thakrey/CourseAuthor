package com.lrn.manager.impl.jasper;

import java.util.List;

import com.lrn.dao.IGenericDao;
import com.lrn.dao.jasper.IJasperAttemptDao;
import com.lrn.manager.impl.GenericManager;
import com.lrn.manager.jasper.IJasperAttemptManager;
import com.lrn.model.hibernate.jasper.JasperAttempt;

/**
 * The Class JasperAttemptManager
 * 
 * @author kishor.pawar
 */
public class JasperAttemptManager extends GenericManager<JasperAttempt, Long> implements
		IJasperAttemptManager {
	
	private IJasperAttemptDao jasperAttemptDao;

	public JasperAttemptManager(IGenericDao<JasperAttempt, Long> iGenericDao) {
		super(iGenericDao);
	}

	/**
	 * @param jasperAttemptDao the jasperAttemptDao to set
	 */
	public void setJasperAttemptDao(IJasperAttemptDao jasperAttemptDao) {
		this.jasperAttemptDao = jasperAttemptDao;
	}
	
	@Override
	public List<JasperAttempt> getJasperAttemptByUserIdAndCompletionCertificateIds(
			String userId, List<Long> completionCertificateIds) {
		String[] paramNames = {"userId", "completionCertificateIds"};
		Object[] paramValues = {userId, completionCertificateIds};
		return jasperAttemptDao.findByNamedQuery("findByUserIdAndCompletionCertificateIds", paramNames, paramValues);
	}
}