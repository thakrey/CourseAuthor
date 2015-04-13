package com.lrn.manager.impl;

import java.util.List;

import com.lrn.dao.IGenericDao;
import com.lrn.dao.IPreBalsaReportSummaryDao;
import com.lrn.manager.IPreBalsaReportSummaryManager;
import com.lrn.model.hibernate.PreBalsaReportSummary;
import com.lrn.model.hibernate.PreBalsaReportSummaryPK;

/**
 * The Class PreBalsaReportSummaryManager
 * 
 * @author kishor.pawar
 */
public class PreBalsaReportSummaryManager extends GenericManager<PreBalsaReportSummary, PreBalsaReportSummaryPK>
		implements IPreBalsaReportSummaryManager {
	
	private IPreBalsaReportSummaryDao preBalsaReportSummaryDao;
	
	public PreBalsaReportSummaryManager(
			IGenericDao<PreBalsaReportSummary, PreBalsaReportSummaryPK> iGenericDao) {
		super(iGenericDao);
	}

	/**
	 * @param preBalsaReportSummaryDao the preBalsaReportSummaryDao to set
	 */
	public void setPreBalsaReportSummaryDao(
			IPreBalsaReportSummaryDao preBalsaReportSummaryDao) {
		this.preBalsaReportSummaryDao = preBalsaReportSummaryDao;
	}
	
	@Override
	public List<PreBalsaReportSummary> getPreBalsaReportSummaryByUserIdAndCompany(String userId,
			String company) {
		String[] paramNames = {"userId", "company"};
		Object[] paramValues = {userId, company};
		return preBalsaReportSummaryDao.findByNamedQuery("findSummaryByUserIdAndCompany", paramNames, paramValues);
	}
}