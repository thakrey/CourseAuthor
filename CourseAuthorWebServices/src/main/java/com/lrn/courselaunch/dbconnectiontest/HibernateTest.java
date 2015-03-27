package com.lrn.courselaunch.dbconnectiontest;

import java.util.Date;

import org.hibernate.Session;

import com.lrn.courselaunch.model.CourseLaunchInfo;
import com.lrn.courselaunch.util.HibernateUtil;

public class HibernateTest {
	public static void main(String[] args) {
	CourseLaunchInfo courseLaunchInfo=new CourseLaunchInfo();	
	courseLaunchInfo.setNameOfTheCourse("complisary");
	courseLaunchInfo.setCourseDescription("HEllo I am trying connect with databases");
	courseLaunchInfo.setCreationDate(new Date());
	//Get Session
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    //start transaction
    session.beginTransaction();
    //Save the Model object
    session.save(courseLaunchInfo);
    //Commit transaction
    session.getTransaction().commit();
    System.out.println("Cat ID="+courseLaunchInfo.getCatId());
     
    //terminate session factory, otherwise program won't end
    HibernateUtil.getSessionFactory().close();		
	}


}
