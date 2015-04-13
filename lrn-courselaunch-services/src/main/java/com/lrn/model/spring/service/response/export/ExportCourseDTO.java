package com.lrn.model.spring.service.response.export;

import java.io.Serializable;

import com.lrn.model.spring.service.response.LRNResponse;

/**
 * The class ExportCourseDTO
 */
public class ExportCourseDTO implements Serializable {
	
	private static final long serialVersionUID = 5586302910960924214L;

	private String 		courseUrl;
	
	private Double 		courseSize;
	
	private LRNResponse lrnResponse;

	/**
	 * @return the courseUrl
	 */
	public String getCourseUrl() {
		return courseUrl;
	}

	/**
	 * @param courseUrl the courseUrl to set
	 */
	public void setCourseUrl(String courseUrl) {
		this.courseUrl = courseUrl;
	}

	/**
	 * @return the courseSize
	 */
	public Double getCourseSize() {
		return courseSize;
	}

	/**
	 * @param courseSize the courseSize to set
	 */
	public void setCourseSize(Double courseSize) {
		this.courseSize = courseSize;
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