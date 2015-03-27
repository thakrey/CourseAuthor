package com.lrn.courselaunch.service.imp;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lrn.courselaunch.dao.CourseLaunchDao;
import com.lrn.courselaunch.model.CourseLaunch;
import com.lrn.courselaunch.service.CourseLaunchService;

@Service("employeeService")
@Transactional
@WebService(endpointInterface ="com.lrn.courselaunch.service.CourseLaunchService")
public class CourseLaunchServiceImp implements CourseLaunchService {

	@Autowired
	private CourseLaunchDao courseLaunchDao;

	public List<CourseLaunch> findCourseLaunch(int catID) {

		return courseLaunchDao.getcourse(catID);
	}

	public void setCourseLaunchDao(CourseLaunchDao courseLaunchDao) {
		this.courseLaunchDao = courseLaunchDao;
	}

}
