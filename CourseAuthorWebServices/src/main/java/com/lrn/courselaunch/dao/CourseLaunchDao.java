package com.lrn.courselaunch.dao;

import java.util.List;

import com.lrn.courselaunch.model.CourseLaunch;

/**
 * 
 * */
public interface CourseLaunchDao {

	public void save(CourseLaunch courseLaunch);

	public List<CourseLaunch> listCourseLaunch();

	public List<CourseLaunch> getcourse(int catId);

}
