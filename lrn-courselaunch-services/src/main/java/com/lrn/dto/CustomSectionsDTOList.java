package com.lrn.dto;

import java.io.Serializable;
import java.util.List;

public class CustomSectionsDTOList implements Serializable {

	private static final long serialVersionUID = 8010163802024687220L;

	private List<CustomSectionsDTO> customSectionsDTOList;

	public List<CustomSectionsDTO> getCustomSectionsDTOList() {
		return customSectionsDTOList;
	}

	public void setCustomSectionsDTOList(
			List<CustomSectionsDTO> customSectionsDTOList) {
		this.customSectionsDTOList = customSectionsDTOList;
	}
}

