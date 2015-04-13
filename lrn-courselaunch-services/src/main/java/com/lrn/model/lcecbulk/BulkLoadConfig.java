package com.lrn.model.lcecbulk;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



/**
 * 
 *
 */

@NamedQueries( {
	@NamedQuery(name = "findBulkLoadConfigByCompany",
			query = "from BulkLoadConfig blc where blc.bulkLoadConfigPK.company = :company order by fieldPosition ")
})

@Entity
@Table(name = "BULK_LOAD_CONFIG")
public class BulkLoadConfig implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1542719292500815877L;
	
	@Id
	private BulkLoadConfigPK bulkLoadConfigPK;
	
	
	@Column(name="FIELD_POSITION", nullable=false)
	private Long fieldPosition;
	
	/** The column name. */
	@Column(name="FIELD_NAME", nullable=false)
	private String fieldName;

		
	@Column(name="REQUIRED_FIELD")
	private String requiredField;
	
	@Column(name="FIELD_LENGTH")
	private Long fieldLength;
	
	@Column(name="FIELD_MATCH")
	private String fieldMatch;
	
	@Column(name="PROTECTED_FIELD")
	private Long protectedField;
	
	@Column(name="FIELD_DISPLAY_NAME")
	private String fieldDisplayName;
	
	@Column(name="FIELD_TYPE")
	private Long fieldType;

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

	/**
	 * @return the bulkLoadConfigPK
	 */
	public BulkLoadConfigPK getBulkLoadConfigPK() {
		return bulkLoadConfigPK;
	}

	/**
	 * @param bulkLoadConfigPK the bulkLoadConfigPK to set
	 */
	public void setBulkLoadConfigPK(BulkLoadConfigPK bulkLoadConfigPK) {
		this.bulkLoadConfigPK = bulkLoadConfigPK;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) 
			return true;
		if (obj == null || !(obj instanceof BulkLoadConfig)) 
			return false;
		
		BulkLoadConfig bObj = (BulkLoadConfig) obj;
		if(this.getBulkLoadConfigPK().getCompany().equals(bObj.getBulkLoadConfigPK().getCompany())
				&& this.getBulkLoadConfigPK().getMappedFieldName().toLowerCase().equals(bObj.getBulkLoadConfigPK().getMappedFieldName().toLowerCase()))
			return true;
		
		return false;
	}
}
