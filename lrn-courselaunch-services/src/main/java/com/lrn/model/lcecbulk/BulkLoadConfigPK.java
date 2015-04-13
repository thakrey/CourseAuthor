package com.lrn.model.lcecbulk;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 
 *
 */
@Embeddable
public class BulkLoadConfigPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5458240309763162235L;


	/** The company. */
	@Column(name="COMPANY", nullable=false)
	private String company; 
	
	@Column(name="MAPPED_FIELD_NAME")
	private String mappedFieldName;


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
	

}
