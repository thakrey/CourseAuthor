package com.lrn.model.spring.service.response.user.course;

import java.io.Serializable;
import java.util.List;

import com.lrn.model.spring.service.response.LRNError;
import com.lrn.model.spring.service.response.LRNResponse;

public class UserCourseInformationDTO implements Serializable {

	private static final long serialVersionUID = 8241032951804449667L;

	private String 						ntLoginId;
	
	private String 						userId;
	
	private String 						lastName;
	
	private String 						firstName;
	
	private String 						middleInitial;
	
	private String 						jobTitle;
	
	private String 						superviserEmail;
	
	private String 						superviserName;
	
	private List<CourseInformationDTO> 	courseInformationDTOs;

	private LRNResponse 				lrnResponse;

	/**
	 * @return the ntLoginId
	 */
	public String getNtLoginId() {
		return ntLoginId;
	}

	/**
	 * @param ntLoginId the ntLoginId to set
	 */
	public void setNtLoginId(String ntLoginId) {
		this.ntLoginId = ntLoginId;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the middleInitial
	 */
	public String getMiddleInitial() {
		return middleInitial;
	}

	/**
	 * @param middleInitial the middleInitial to set
	 */
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	/**
	 * @return the jobTitle
	 */
	public String getJobTitle() {
		return jobTitle;
	}

	/**
	 * @param jobTitle the jobTitle to set
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	/**
	 * @return the superviserEmail
	 */
	public String getSuperviserEmail() {
		return superviserEmail;
	}

	/**
	 * @param superviserEmail the superviserEmail to set
	 */
	public void setSuperviserEmail(String superviserEmail) {
		this.superviserEmail = superviserEmail;
	}

	/**
	 * @return the superviserName
	 */
	public String getSuperviserName() {
		return superviserName;
	}

	/**
	 * @param superviserName the superviserName to set
	 */
	public void setSuperviserName(String superviserName) {
		this.superviserName = superviserName;
	}

	/**
	 * @return the courseInformationDTOs
	 */
	public List<CourseInformationDTO> getCourseInformationDTOs() {
		return courseInformationDTOs;
	}

	/**
	 * @param courseInformationDTOs the courseInformationDTOs to set
	 */
	public void setCourseInformationDTOs(
			List<CourseInformationDTO> courseInformationDTOs) {
		this.courseInformationDTOs = courseInformationDTOs;
	}

	/**
	 * @return the lrnResponse
	 */
	public LRNResponse getLrnResponse() {
		return lrnResponse;
	}

	/**
	 * @param lrnResponse the lrnResponse to set
	 */
	public void setLrnResponse(LRNResponse lrnResponse) {
		this.lrnResponse = lrnResponse;
	} 
}