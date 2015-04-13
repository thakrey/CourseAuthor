package com.lrn.dto;

import java.io.Serializable;

public class CustomPublishProfileDTO implements Serializable {

	private static final long serialVersionUID = -8216767780431857672L;

	private Long id;
	private String publishType;
	private String profileValue;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPublishType() {
		return publishType;
	}
	public void setPublishType(String publishType) {
		this.publishType = publishType;
	}
	public String getProfileValue() {
		return profileValue;
	}
	public void setProfileValue(String profileValue) {
		this.profileValue = profileValue;
	}
}
