package com.lrn.courselaunch.model;

import java.util.Date;


/**
 *CourseLaunchInfo is a simple Java Bean class and we will use XML based configuration for providing it’s mapping details.
 *@author yuvraj.thakre
 *
 */
 
public class CourseLaunchInfo {

	private int catId;

	private String nameOfTheCourse;

	private String courseDescription;

	private Date creationDate;

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getNameOfTheCourse() {
		return nameOfTheCourse;
	}

	public void setNameOfTheCourse(String nameOfTheCourse) {
		this.nameOfTheCourse = nameOfTheCourse;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}
