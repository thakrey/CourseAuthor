package com.lrn.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lrn.dao.IGenericDao;
import com.mchange.v2.c3p0.PooledDataSource;

/**
 * This class serves as the Base class for all other DAOs - namely to hold
 * common CRUD methods that they might all use. You should only need to extend
 * this class when your require custom CRUD logic.
 * 
 * @author kishor.pawar
 * 
 * @param <T>
 *            a type variable
 * @param <PK>
 *            the primary key for that type
 */
public class GenericDao<T, PK extends Serializable> extends HibernateDaoSupport 
		implements IGenericDao<T, PK> {
	/**
	 * Log variable for all child classes. Uses LogFactory.getLog(getClass())
	 * from Commons Logging
	 */
	protected final Log	LOG	= LogFactory.getLog(getClass());

	private Class<T>	persistentClass;

	/**
	 * Constructor that takes in a class to see which type of entity to persist
	 * 
	 * @param persistentClass
	 *            the class type you'd like to persist
	 */
	public GenericDao(final Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return super.getHibernateTemplate().loadAll(this.persistentClass);
	}

	@Override
	public List<T> getAllDistinct() {
		Collection<T> result = new LinkedHashSet<T>(getAll());
        return new ArrayList<T>(result);
	}

	@Override
	@SuppressWarnings("unchecked")
	public T get(PK primaryKey) {
		T entity = (T) super.getHibernateTemplate().get(this.persistentClass, primaryKey);
		
		if (entity == null) {
            LOG.warn("Uh oh, '" + this.persistentClass + "' object with id '" + primaryKey + "' not found...");
            throw new ObjectRetrievalFailureException(this.persistentClass, primaryKey);
        }        
		return entity;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean exists(PK primaryKey) {
		T entity = (T) super.getHibernateTemplate().get(this.persistentClass, primaryKey);
        return entity != null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public T save(T object) {
		return (T) super.getHibernateTemplate().merge(object);
	}

	@Override
	public void remove(PK primaryKey) {
		super.getHibernateTemplate().delete(this.get(primaryKey));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByNamedQuery(String queryName, Map<String, Object> queryParams) {
		String[] params = new String[queryParams.size()];
        Object[] values = new Object[queryParams.size()];
        
        int index = 0;
        for (String s : queryParams.keySet()) {
            params[index] = s;
            values[index++] = queryParams.get(s);
        }

        List<T> resultSet = getHibernateTemplate().findByNamedQueryAndNamedParam(queryName, params, values);
        
        DataSource ds = SessionFactoryUtils.getDataSource(getHibernateTemplate().getSessionFactory());
		closeConnection(ds);
		
		return resultSet;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByNamedQuery(String query, String[] paramNames, Object[] paramValues) {
		List<T> resultSet = getHibernateTemplate().findByNamedQueryAndNamedParam(query, paramNames, paramValues);
		
		DataSource ds = SessionFactoryUtils.getDataSource(getHibernateTemplate().getSessionFactory());
		closeConnection(ds);
		
		return resultSet;
	}

	@Override
	public Iterator<Map<String, Object>> findBySqlQuery(String query) {
		DataSource ds = SessionFactoryUtils.getDataSource(getSessionFactory());
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(ds);		
		Iterator<Map<String, Object>> resultSet = jdbcTemplate.queryForList(query, new HashMap<String, Object>()).iterator();
		closeConnection(ds);
		
		return resultSet;
	}
	
	public void closeConnection(DataSource ds) {
		try {
			
			ds.getConnection().close();
			logConnectionPool(ds);
			
		} catch(SQLException ex) {
			logger.error("Error when Closing Connection...");
			ex.printStackTrace();
		}
	}
	
	@Override
	public void logConnectionPool(DataSource ds) {
		try {
			// make sure it's a c3p0 PooledDataSource 
			if ( ds instanceof PooledDataSource) { 
				PooledDataSource pds = (PooledDataSource) ds; 
				if(pds.getNumBusyConnectionsAllUsers() > 50) {
					Calendar cal = Calendar.getInstance();
					logger.warn(" Total Connections: " + pds.getNumConnectionsAllUsers()); 
					logger.warn(" Busy Connections: " + pds.getNumBusyConnectionsAllUsers());
					logger.warn(" Orphaned Connections: " + pds.getNumUnclosedOrphanedConnectionsAllUsers());
					logger.warn(" Users: " + (pds.getAllUsers() != null ? pds.getAllUsers().size() : 0));
					
				}
			} 
			else 
				logger.warn("Not a c3p0 PooledDataSource!");
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
@Override
public List<Map<String, Object>> queryForList(String query, List<Object> params) {
		
		DataSource ds = SessionFactoryUtils.getDataSource(getSessionFactory());
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
		List<Map<String, Object>> resultSetMapList = jdbcTemplate.queryForList(query, params.toArray());
		
		closeConnection(ds);
		
		return resultSetMapList;
	}
}
