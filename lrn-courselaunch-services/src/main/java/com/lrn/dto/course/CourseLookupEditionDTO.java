package com.lrn.dto.course;

import java.io.Serializable;


public class CourseLookupEditionDTO extends CourseLookupDTO implements Serializable {

	private static final long serialVersionUID = -4105744909424629777L;

	private String editionCode;
	
	private String editionTopic;
	
	private String editionSecondaryTopic;
	
	private String editionType;
	
	private Long editionUnitWeight;

	public String getEditionCode() {
		return editionCode;
	}

	public void setEditionCode(String editionCode) {
		this.editionCode = editionCode;
	}

	public String getEditionTopic() {
		return editionTopic;
	}

	public void setEditionTopic(String editionTopic) {
		this.editionTopic = editionTopic;
	}

	public String getEditionSecondaryTopic() {
		return editionSecondaryTopic;
	}

	public void setEditionSecondaryTopic(String editionSecondaryTopic) {
		this.editionSecondaryTopic = editionSecondaryTopic;
	}

	public String getEditionType() {
		return editionType;
	}

	public void setEditionType(String editionType) {
		this.editionType = editionType;
	}

	public Long getEditionUnitWeight() {
		return editionUnitWeight;
	}

	public void setEditionUnitWeight(Long editionUnitWeight) {
		this.editionUnitWeight = editionUnitWeight;
	}
}
