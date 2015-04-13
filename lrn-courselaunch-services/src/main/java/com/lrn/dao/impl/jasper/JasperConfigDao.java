package com.lrn.dao.impl.jasper;

import org.apache.log4j.Logger;

import com.lrn.dao.impl.GenericDao;
import com.lrn.dao.jasper.IJasperConfigDao;
import com.lrn.model.hibernate.jasper.JasperConfig;

/**
 * The Class JasperConfigDao.
 *
 * @author kishor.pawar
 */
public class JasperConfigDao extends GenericDao<JasperConfig, Long> implements
		IJasperConfigDao {

	private static final Logger logger = Logger.getLogger(JasperConfigDao.class);
	
	public JasperConfigDao(Class<JasperConfig> persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	}

}
