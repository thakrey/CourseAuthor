package com.lrn.dto;

import java.io.Serializable;

public class CustomPublishInfoDTO implements Serializable {

	private static final long serialVersionUID = 5029378177850788544L;
	
	private String publicationDate; 
	private Long count;
	
	public String getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
}
