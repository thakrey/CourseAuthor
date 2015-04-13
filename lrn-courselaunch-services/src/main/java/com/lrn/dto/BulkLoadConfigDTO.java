package com.lrn.dto;

import java.io.Serializable;

import com.lrn.model.lcecbulk.BulkLoadConfig;

public class BulkLoadConfigDTO implements Serializable {

	private static final long serialVersionUID = -4082362867920286286L;

	private String company; 
	
	private String fieldName;

	private Long fieldPosition;
	
	private String mappedFieldName;
		
	private String requiredField;
	
	private Long fieldLength;
	
	private String fieldMatch;
	
	private Long protectedField;
	
	private String fieldDisplayName;
	
	private Long fieldType;

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
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * @param fieldName the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * @return the fieldPosition
	 */
	public Long getFieldPosition() {
		return fieldPosition;
	}

	/**
	 * @param fieldPosition the fieldPosition to set
	 */
	public void setFieldPosition(Long fieldPosition) {
		this.fieldPosition = fieldPosition;
	}

	/**
	 * @return the mappedFieldName
	 */
	public String getMappedFieldName() {
		return mappedFieldName;
	}

	/**
	 * @param mappedFieldName the mappedFieldName to set
	 */
	public void setMappedFieldName(String mappedFieldName) {
		this.mappedFieldName = mappedFieldName;
	}

	/**
	 * @return the requiredField
	 */
	public String getRequiredField() {
		return requiredField;
	}

	/**
	 * @param requiredField the requiredField to set
	 */
	public void setRequiredField(String requiredField) {
		this.requiredField = requiredField;
	}

	/**
	 * @return the fieldLength
	 */
	public Long getFieldLength() {
		return fieldLength;
	}

	/**
	 * @param fieldLength the fieldLength to set
	 */
	public void setFieldLength(Long fieldLength) {
		this.fieldLength = fieldLength;
	}

	/**
	 * @return the fieldMatch
	 */
	public String getFieldMatch() {
		return fieldMatch;
	}

	/**
	 * @param fieldMatch the fieldMatch to set
	 */
	public void setFieldMatch(String fieldMatch) {
		this.fieldMatch = fieldMatch;
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
	 * @return the fieldDisplayName
	 */
	public String getFieldDisplayName() {
		return fieldDisplayName;
	}

	/**
	 * @param fieldDisplayName the fieldDisplayName to set
	 */
	public void setFieldDisplayName(String fieldDisplayName) {
		this.fieldDisplayName = fieldDisplayName;
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

	public static final BulkLoadConfigDTO convertModelToDTO(BulkLoadConfig bulkLoadConfig){
		BulkLoadConfigDTO bulkLoadConfigDTO = new BulkLoadConfigDTO();
		
		bulkLoadConfigDTO.setCompany(bulkLoadConfig.getBulkLoadConfigPK().getCompany());
		bulkLoadConfigDTO.setFieldDisplayName(bulkLoadConfig.getFieldDisplayName());
		bulkLoadConfigDTO.setFieldLength(bulkLoadConfig.getFieldLength());
		bulkLoadConfigDTO.setFieldMatch(bulkLoadConfig.getFieldMatch());
		bulkLoadConfigDTO.setMappedFieldName(bulkLoadConfig.getBulkLoadConfigPK().getMappedFieldName());
		bulkLoadConfigDTO.setFieldPosition(bulkLoadConfig.getFieldPosition());
		bulkLoadConfigDTO.setFieldType(bulkLoadConfig.getFieldType());
		bulkLoadConfigDTO.setFieldName(bulkLoadConfig.getFieldName());
		bulkLoadConfigDTO.setProtectedField(bulkLoadConfig.getProtectedField());
		bulkLoadConfigDTO.setRequiredField(bulkLoadConfig.getRequiredField());
		
		return bulkLoadConfigDTO;
	}

}
