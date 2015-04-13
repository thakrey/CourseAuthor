package com.lrn.manager.jasper;

import java.util.List;

import com.lrn.manager.IGenericManager;
import com.lrn.model.hibernate.jasper.JasperAttempt;

/**
 * The Interface IJasperAttemptManager
 * 
 * @author kishor.pawar
 *
 */
public interface IJasperAttemptManager extends IGenericManager<JasperAttempt, Long> {

	/**
	 * Returns Japser Attempt
	 * @param userId
	 * @param completionCertificateIds
	 * @return
	 */
	List<JasperAttempt> getJasperAttemptByUserIdAndCompletionCertificateIds(
			String userId, List<Long> completionCertificateIds);

}
