package com.lrn.manager;

import java.util.List;

import com.lrn.model.hibernate.PreBalsaReportSummary;
import com.lrn.model.hibernate.PreBalsaReportSummaryPK;

/**
 * The Interface IPreBalsaReportSummaryManager

 */
public interface IPreBalsaReportSummaryManager extends IGenericManager<PreBalsaReportSummary, PreBalsaReportSummaryPK> {

	/**
	 * Get PreBalsaReportSummary of User
	 * @param userId
	 * @param company
	 * @return
	 */
	List<PreBalsaReportSummary> getPreBalsaReportSummaryByUserIdAndCompany(
			String userId, String company);
}