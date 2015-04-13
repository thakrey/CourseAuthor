package com.lrn.dto;

import java.io.Serializable;
import java.text.ParseException;



import com.lrn.model.hibernate.custom.CustomPublishes;
import com.lrn.util.StringUtil;

public class CustomPublishesDTO implements Serializable {

	private static final long serialVersionUID = -9060493436263747344L;

	private Long id;
	private String company;
	private String name;
	private String creationDate;
	private String updationDate;
	private String publicationDate;
	private String deactivationDate;
	private String updationUserId;
	private String publicationUserId;
	private String deactivationUserId;
	private Long isActive;
	private String profileValue;
	private String publishType;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getUpdationDate() {
		return updationDate;
	}
	public void setUpdationDate(String updationDate) {
		this.updationDate = updationDate;
	}
	public String getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}
	public String getDeactivationDate() {
		return deactivationDate;
	}
	public void setDeactivationDate(String deactivationDate) {
		this.deactivationDate = deactivationDate;
	}
	public String getUpdationUserId() {
		return updationUserId;
	}
	public void setUpdationUserId(String updationUserId) {
		this.updationUserId = updationUserId;
	}
	public String getPublicationUserId() {
		return publicationUserId;
	}
	public void setPublicationUserId(String publicationUserId) {
		this.publicationUserId = publicationUserId;
	}
	public String getDeactivationUserId() {
		return deactivationUserId;
	}
	public void setDeactivationUserId(String deactivationUserId) {
		this.deactivationUserId = deactivationUserId;
	}
	public Long getIsActive() {
		return isActive;
	}
	public void setIsActive(Long isActive) {
		this.isActive = isActive;
	}
	public String getProfileValue() {
		return profileValue;
	}
	public void setProfileValue(String profileValue) {
		this.profileValue = profileValue;
	}
	
	public String getPublishType() {
		return publishType;
	}
	public void setPublishType(String publishType) {
		this.publishType = publishType;
	}
	
	public CustomPublishesDTO getDTOFromModel(CustomPublishes cp) throws ParseException {
		
		CustomPublishesDTO dto = new CustomPublishesDTO();
			dto.setCompany(cp.getCompany());
			dto.setCreationDate(StringUtil.getDateStringFromJavaDateInLCECDateFormat(cp.getCreation()));
			dto.setDeactivationDate(StringUtil.getDateStringFromJavaDateInLCECDateFormat(cp.getDeactivation()));
			dto.setDeactivationUserId(cp.getDeactivationUserId());
			dto.setId(cp.getId());
			dto.setIsActive(cp.getIsActive());
			dto.setName(cp.getName());
			dto.setProfileValue(cp.getProfileValue());
			dto.setPublicationDate(StringUtil.getDateStringFromJavaDateInLCECDateFormat(cp.getPublication()));
			dto.setPublicationUserId(cp.getPublicationUserId());
			dto.setPublishType(cp.getPublishType());
			dto.setUpdationDate(StringUtil.getDateStringFromJavaDateInLCECDateFormat(cp.getUpdation()));
			dto.setUpdationUserId(cp.getUpdationUserId());
		return dto;
	}
}
