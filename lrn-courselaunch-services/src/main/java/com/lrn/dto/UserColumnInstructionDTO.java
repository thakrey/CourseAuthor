package com.lrn.dto;

import java.io.Serializable;

import com.lrn.model.lcec.UserColumnInstruction;

public class UserColumnInstructionDTO implements Serializable {
	
	private static final long serialVersionUID = 5312873398638471001L;

	private Long id;
	private Long siteId;
	private String columnName;
	private String language;
	private Long isActive;
	private String instruction;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSiteId() {
		return siteId;
	}
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Long getIsActive() {
		return isActive;
	}
	public void setIsActive(Long isActive) {
		this.isActive = isActive;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	
	public UserColumnInstruction convertDTOToModel() {
		UserColumnInstruction model = new UserColumnInstruction();
		
		model.setColumnName(this.getColumnName());
		model.setId(this.getId());
		model.setInstruction(this.getInstruction());
		model.setIsActive(this.getIsActive());
		model.setLanguage(this.getLanguage());
		model.setSiteId(this.getSiteId());
		
		return model;
	}
}
