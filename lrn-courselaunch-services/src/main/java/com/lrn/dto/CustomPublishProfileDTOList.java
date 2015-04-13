package com.lrn.dto;

import java.io.Serializable;
import java.util.List;

public class CustomPublishProfileDTOList implements Serializable {

	private static final long serialVersionUID = -2039326824365440857L;
	
	private List<CustomPublishProfileDTO> customPublishProfileDTOList;

	public List<CustomPublishProfileDTO> getCustomPublishProfileDTOList() {
		return customPublishProfileDTOList;
	}

	public void setCustomPublishProfileDTOList(
			List<CustomPublishProfileDTO> customPublishProfileDTOList) {
		this.customPublishProfileDTOList = customPublishProfileDTOList;
	}
}
