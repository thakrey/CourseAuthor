package com.lrn.courselaunch.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CourseLaunch is a java bean where fields are annotated with JPA annotations,
 * so that we don’t need to provide mapping in separate XML file.
 * 
 * @author Yuvraj
 * @version 0.1
 */
@Entity
@Table(name = "courselaunch")
public class CourseLaunch {

	@Id
	@Column(name = "CAT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int catId;

	@Column(name = "NAME_OF_THE_COURSE")
	private String nameOfTheCourse;

	@Column(name = "COURSE_DESCRIPTION")
	private String courseDescription;

	@Column(name = "CREATION_DATE")
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
