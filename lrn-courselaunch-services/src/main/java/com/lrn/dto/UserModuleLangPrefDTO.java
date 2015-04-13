package com.lrn.dto;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.lrn.model.hibernate.user.UserModuleLangPref;

public class UserModuleLangPrefDTO implements Serializable {

	private static final long serialVersionUID = 6917277995598532801L;
	
	private Long id;
	private String userId;
	private Long siteId;
	private Long moduleId;
	private String language;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Long getSiteId() {
		return siteId;
	}
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
	public Long getModuleId() {
		return moduleId;
	}
	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public UserModuleLangPref convertDTOToModel() {
		UserModuleLangPref model = new UserModuleLangPref();
		model.setId(this.getId());
		model.setLanguage(this.getLanguage());
		model.setModuleId(this.getModuleId());
		model.setSiteId(this.getSiteId());
		model.setUserId(this.getUserId());
		
		model.setCreated(new Date());
		model.setUpdated(new Date());
		return model;
	}
}
