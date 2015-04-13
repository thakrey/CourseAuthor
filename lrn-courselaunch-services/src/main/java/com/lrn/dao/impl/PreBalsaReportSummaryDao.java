package com.lrn.dao.impl;

import com.lrn.dao.IPreBalsaReportSummaryDao;
import com.lrn.model.hibernate.PreBalsaReportSummary;
import com.lrn.model.hibernate.PreBalsaReportSummaryPK;

/**
 * The Class PreBalsaReportSummaryDao.
 *
 * @author kishor.pawar
 */
public class PreBalsaReportSummaryDao extends GenericDao<PreBalsaReportSummary, PreBalsaReportSummaryPK> implements
		IPreBalsaReportSummaryDao {

	public PreBalsaReportSummaryDao(Class<PreBalsaReportSummary> persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	}

}
