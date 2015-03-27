package com.lrn.courselaunch.service;

import java.util.List;

import javax.jws.WebService;

import com.lrn.courselaunch.model.CourseLaunch;

@WebService
public interface CourseLaunchService {
	
public List<CourseLaunch> findCourseLaunch(int catId);

}
