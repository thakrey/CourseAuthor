package com.lrn.courselaunch.dao.imp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.lrn.courselaunch.dao.CourseLaunchAbstractDao;
import com.lrn.courselaunch.dao.CourseLaunchDao;
import com.lrn.courselaunch.model.CourseLaunch;

/**
 * Dao Implementation class
 *
 * @author yuvraj.thakre
 * */

@Repository("CourseLaunchDao")
public class CourseLaunchDaoImp extends CourseLaunchAbstractDao implements
		CourseLaunchDao {

	private SessionFactory sessionFactory;

	public void save(CourseLaunch courseLaunch) {

	}

	public List<CourseLaunch> listCourseLaunch() {
		return null;
	}

	public List<CourseLaunch> getcourse(int catId) {

		Session session = this.sessionFactory.openSession();

		List<CourseLaunch> courseList = session.createQuery("from CourseLaunch")
				.list();
		session.close();
		return courseList;

	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
