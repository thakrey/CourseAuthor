package com.lrn.model.lcec;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.lrn.dto.UserColumnInstructionDTO;
import com.lrn.model.hibernate.AbstractBaseEntity;


@Entity
@SequenceGenerator(name = "GEN_SEQ", sequenceName = "USER_COLUMN_INSTRUCTION_SEQ")
@Table(name = "USER_COLUMN_INSTRUCTION")
public class UserColumnInstruction extends AbstractBaseEntity {

	/** The site id. */
	@Column(name = "SITE_ID")
	private Long siteId;
	
	/** The column name. */
	@Column(name = "COLUMN_NAME")
	private String columnName;
	
	/** The language. */
	@Column(name = "LANGUAGE")
	private String language;
	
	/** The site id. */
	@Column(name = "IS_ACTIVE")
	private Long isActive;
	
	/** The column name. */
	@Column(name = "INSTRUCTION")
	private String instruction;

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
	
	public UserColumnInstructionDTO convertModelToDTO() {
		UserColumnInstructionDTO dto = new UserColumnInstructionDTO();
		
		dto.setColumnName(this.getColumnName());
		dto.setId(this.getId());
		dto.setInstruction(this.getInstruction());
		dto.setIsActive(this.getIsActive());
		dto.setLanguage(this.getLanguage());
		dto.setSiteId(this.getSiteId());
		
		return dto;
	}
	
	@Override
	public boolean equals(Object object) {
		
		if(object == this) return true;
		
		if(object == null) return false;
		
		if(object instanceof UserColumnInstruction) {
			if(((UserColumnInstruction) object).getColumnName().equals(this.getColumnName()))
				return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int hash = 7;
		hash = hash * 7 + this.getColumnName().hashCode();
		return hash;
	}
}
