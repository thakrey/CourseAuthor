package com.lrn.dao.impl.jasper;

import com.lrn.dao.impl.GenericDao;
import com.lrn.dao.jasper.IJasperAttemptDao;
import com.lrn.model.hibernate.jasper.JasperAttempt;

/**
 * The Class JasperAttemptDao.
 *
 * @author kishor.pawar
 */
public class JasperAttemptDao extends GenericDao<JasperAttempt, Long> implements
		IJasperAttemptDao {

	public JasperAttemptDao(Class<JasperAttempt> persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	}

}
