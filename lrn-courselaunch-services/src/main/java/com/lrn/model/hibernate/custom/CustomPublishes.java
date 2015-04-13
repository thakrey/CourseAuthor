package com.lrn.model.hibernate.custom;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.lrn.model.hibernate.AbstractBaseEntity;

/**
 * @author sreenivas.k
 *
 */
@Entity
@SequenceGenerator(name = "GEN_SEQ", sequenceName = "CUSTOM_PUBLISHES_SEQ")
@Table(name = "CUSTOM_PUBLISHES")
public class CustomPublishes extends AbstractBaseEntity {
	
	private static final long serialVersionUID = -3703278003743083328L;

	@Column(name = "COMPANY")
	private String company;
	
	@Column(name = "NAME")
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATION")
	private Date creation;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATION")
	private Date updation;
	
	@Column(name = "UPDATION_USER_ID")
	private String updationUserId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PUBLICATION")
	private Date publication;
	
	@Column(name = "PUBLICATION_USER_ID")
	private String publicationUserId;
	
	@Column(name = "IS_ACTIVE")
	private Long isActive;
	
	@Column(name = "PROFILE_VALUE")
	private String profileValue;
	
	@Column(name = "PUBLISH_TYPE")
	private String publishType;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DEACTIVATION")
	private Date deactivation;
	
	@Column(name = "DEACTIVATION_USER_ID")
	private String deactivationUserId;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the creation
	 */
	public Date getCreation() {
		return creation;
	}

	/**
	 * @param creation the creation to set
	 */
	public void setCreation(Date creation) {
		this.creation = creation;
	}

	/**
	 * @return the updation
	 */
	public Date getUpdation() {
		return updation;
	}

	/**
	 * @param updation the updation to set
	 */
	public void setUpdation(Date updation) {
		this.updation = updation;
	}

	/**
	 * @return the updationUserId
	 */
	public String getUpdationUserId() {
		return updationUserId;
	}

	/**
	 * @param updationUserId the updationUserId to set
	 */
	public void setUpdationUserId(String updationUserId) {
		this.updationUserId = updationUserId;
	}

	/**
	 * @return the publication
	 */
	public Date getPublication() {
		return publication;
	}

	/**
	 * @param publication the publication to set
	 */
	public void setPublication(Date publication) {
		this.publication = publication;
	}

	/**
	 * @return the publicationUserId
	 */
	public String getPublicationUserId() {
		return publicationUserId;
	}

	/**
	 * @param publicationUserId the publicationUserId to set
	 */
	public void setPublicationUserId(String publicationUserId) {
		this.publicationUserId = publicationUserId;
	}

	/**
	 * @return the isActive
	 */
	public Long getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(Long isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the profileValue
	 */
	public String getProfileValue() {
		return profileValue;
	}

	/**
	 * @param profileValue the profileValue to set
	 */
	public void setProfileValue(String profileValue) {
		this.profileValue = profileValue;
	}

	/**
	 * @return the publishType
	 */
	public String getPublishType() {
		return publishType;
	}

	/**
	 * @param publishType the publishType to set
	 */
	public void setPublishType(String publishType) {
		this.publishType = publishType;
	}

	/**
	 * @return the deactivation
	 */
	public Date getDeactivation() {
		return deactivation;
	}

	/**
	 * @param deactivation the deactivation to set
	 */
	public void setDeactivation(Date deactivation) {
		this.deactivation = deactivation;
	}

	/**
	 * @return the deactivationUserId
	 */
	public String getDeactivationUserId() {
		return deactivationUserId;
	}

	/**
	 * @param deactivationUserId the deactivationUserId to set
	 */
	public void setDeactivationUserId(String deactivationUserId) {
		this.deactivationUserId = deactivationUserId;
	}
	
	
}
