package com.lrn.model.hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The Class Edition
 * 
 */

@Entity
@SequenceGenerator(name = "GEN_SEQ", sequenceName = "EDITION_SEQ")
@Table(name = "EDITION")
public class Edition extends AbstractBaseEntity {

	private static final long serialVersionUID = 3115601552713966600L;

	@Column(name = "EDITION_CODE")
	private String editionCode;
	
	@Column(name = "TITLE_EN")
	private String titleEn;
	
	@Column(name = "DESCRIPTION_EN")
	private String descriptionEn;
	
	@Column(name = "MODULE_ID")
	private Long moduleId;
	
	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "TOPIC")
	private String topic;
	
	@Column(name = "SECONDARY_TOPIC")
	private String secondaryTopic;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED")
	private Date created;
	
	@Column(name = "UNIT_WEIGHT")
	private Long unitWeight;

	public Edition() {}
	
	public Edition(String editionCode, String titleEn, String descriptionEn, Long moduleId, String type, String topic, String secondaryTopic, Date created, Long unitWeight) {
		setEditionCode(editionCode);
		setTitleEn(titleEn);
		setDescriptionEn(descriptionEn);
		setModuleId(moduleId);
		setType(type);
		setTopic(topic);
		setSecondaryTopic(secondaryTopic);
		setCreated(created);
		setUnitWeight(unitWeight);
	}
	/**
	 * @return the editionCode
	 */
	public String getEditionCode() {
		return editionCode;
	}

	/**
	 * @param editionCode the editionCode to set
	 */
	public void setEditionCode(String editionCode) {
		this.editionCode = editionCode;
	}

	/**
	 * @return the titleEn
	 */
	public String getTitleEn() {
		return titleEn;
	}

	/**
	 * @param titleEn the titleEn to set
	 */
	public void setTitleEn(String titleEn) {
		this.titleEn = titleEn;
	}

	/**
	 * @return the descriptionEn
	 */
	public String getDescriptionEn() {
		return descriptionEn;
	}

	/**
	 * @param descriptionEn the descriptionEn to set
	 */
	public void setDescriptionEn(String descriptionEn) {
		this.descriptionEn = descriptionEn;
	}

	/**
	 * @return the moduleId
	 */
	public Long getModuleId() {
		return moduleId;
	}

	/**
	 * @param moduleId the moduleId to set
	 */
	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the topic
	 */
	public String getTopic() {
		return topic;
	}

	/**
	 * @param topic the topic to set
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}

	/**
	 * @return the secondaryTopic
	 */
	public String getSecondaryTopic() {
		return secondaryTopic;
	}

	/**
	 * @param secondaryTopic the secondaryTopic to set
	 */
	public void setSecondaryTopic(String secondaryTopic) {
		this.secondaryTopic = secondaryTopic;
	}

	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * @return the unitWeight
	 */
	public Long getUnitWeight() {
		return unitWeight;
	}

	/**
	 * @param unitWeight the unitWeight to set
	 */
	public void setUnitWeight(Long unitWeight) {
		this.unitWeight = unitWeight;
	}
}
