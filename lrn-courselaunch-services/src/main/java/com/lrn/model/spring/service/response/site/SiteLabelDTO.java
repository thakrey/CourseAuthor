package com.lrn.model.spring.service.response.site;

import java.io.Serializable;

/**
 * The Class SiteLabelDTO.
 * 

 */
public class SiteLabelDTO implements Serializable {

	private static final long serialVersionUID = -995511083109868585L;

	private String 	company;
	
	private String 	columnName;
	
	private String 	displayName;
	
	private String 	userValue;
	
	private Long 	reportPosition;
	
	private Long 	searchCriteria;
	
	private String 	sourceOfData;
	
	private Long 	editAllowed;
	
	private Long 	privilegeVisibilityLevel;
	
	private Long 	requiredField;
	
	private Long 	fieldType;
	
	private String 	instructionText;
	
	private Long 	protectedField;
	
	private String 	fieldFormat;

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @return the columnName
	 */
	public String getColumnName() {
		return columnName;
	}

	/**
	 * @param columnName the columnName to set
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * @return the userValue
	 */
	public String getUserValue() {
		return userValue;
	}

	/**
	 * @param userValue the userValue to set
	 */
	public void setUserValue(String userValue) {
		this.userValue = userValue;
	}

	/**
	 * @return the reportPosition
	 */
	public Long getReportPosition() {
		return reportPosition;
	}

	/**
	 * @param reportPosition the reportPosition to set
	 */
	public void setReportPosition(Long reportPosition) {
		this.reportPosition = reportPosition;
	}

	/**
	 * @return the searchCriteria
	 */
	public Long getSearchCriteria() {
		return searchCriteria;
	}

	/**
	 * @param searchCriteria the searchCriteria to set
	 */
	public void setSearchCriteria(Long searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

	/**
	 * @return the sourceOfData
	 */
	public String getSourceOfData() {
		return sourceOfData;
	}

	/**
	 * @param sourceOfData the sourceOfData to set
	 */
	public void setSourceOfData(String sourceOfData) {
		this.sourceOfData = sourceOfData;
	}

	/**
	 * @return the editAllowed
	 */
	public Long getEditAllowed() {
		return editAllowed;
	}

	/**
	 * @param editAllowed the editAllowed to set
	 */
	public void setEditAllowed(Long editAllowed) {
		this.editAllowed = editAllowed;
	}

	/**
	 * @return the privilegeVisibilityLevel
	 */
	public Long getPrivilegeVisibilityLevel() {
		return privilegeVisibilityLevel;
	}

	/**
	 * @param privilegeVisibilityLevel the privilegeVisibilityLevel to set
	 */
	public void setPrivilegeVisibilityLevel(Long privilegeVisibilityLevel) {
		this.privilegeVisibilityLevel = privilegeVisibilityLevel;
	}

	/**
	 * @return the requiredField
	 */
	public Long getRequiredField() {
		return requiredField;
	}

	/**
	 * @param requiredField the requiredField to set
	 */
	public void setRequiredField(Long requiredField) {
		this.requiredField = requiredField;
	}

	/**
	 * @return the fieldType
	 */
	public Long getFieldType() {
		return fieldType;
	}

	/**
	 * @param fieldType the fieldType to set
	 */
	public void setFieldType(Long fieldType) {
		this.fieldType = fieldType;
	}

	/**
	 * @return the instructionText
	 */
	public String getInstructionText() {
		return instructionText;
	}

	/**
	 * @param instructionText the instructionText to set
	 */
	public void setInstructionText(String instructionText) {
		this.instructionText = instructionText;
	}

	/**
	 * @return the protectedField
	 */
	public Long getProtectedField() {
		return protectedField;
	}

	/**
	 * @param protectedField the protectedField to set
	 */
	public void setProtectedField(Long protectedField) {
		this.protectedField = protectedField;
	}

	/**
	 * @return the fieldFormat
	 */
	public String getFieldFormat() {
		return fieldFormat;
	}

	/**
	 * @param fieldFormat the fieldFormat to set
	 */
	public void setFieldFormat(String fieldFormat) {
		this.fieldFormat = fieldFormat;
	}
}