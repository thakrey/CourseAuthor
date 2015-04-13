package com.lrn.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CustomPublishesDTOList implements Serializable {

	private static final long serialVersionUID = -2970545756726842672L;
	
	private List<CustomPublishesDTO> customPublishesDTOList = new ArrayList<CustomPublishesDTO> ();

	public List<CustomPublishesDTO> getCustomPublishesDTOList() {
		return customPublishesDTOList;
	}

	public void setCustomPublishesDTOList(
			List<CustomPublishesDTO> customPublishesDTOList) {
		this.customPublishesDTOList = customPublishesDTOList;
	}
}
