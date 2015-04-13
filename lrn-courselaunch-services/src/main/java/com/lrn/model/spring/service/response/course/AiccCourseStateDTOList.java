package com.lrn.model.spring.service.response.course;

import java.io.Serializable;
import java.util.List;

public class AiccCourseStateDTOList implements Serializable {
	
	private static final long serialVersionUID = 5383988483008695653L;
	
	private List<AiccCourseStateDTO> aiccCourseStateDTOList;

	/**
	 * @return the aiccCourseStateDTOList
	 */
	public List<AiccCourseStateDTO> getAiccCourseStateDTOList() {
		return aiccCourseStateDTOList;
	}

	/**
	 * @param aiccCourseStateDTOList the aiccCourseStateDTOList to set
	 */
	public void setAiccCourseStateDTOList(
			List<AiccCourseStateDTO> aiccCourseStateDTOList) {
		this.aiccCourseStateDTOList = aiccCourseStateDTOList;
	}
}