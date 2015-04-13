package com.lrn.model.hibernate.site;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.lrn.model.hibernate.AbstractBaseEntity;
import com.lrn.model.hibernate.CourseLookup;

/**
 * The Class SiteCourse.
 *
 * @author kishor.pawar
 */
@Entity
@SequenceGenerator(name = "GEN_SEQ", sequenceName = "SITE_COURSE_SEQ")
@Table(name = "SITE_COURSE")
public class SiteCourse extends AbstractBaseEntity {

	private static final long serialVersionUID = 1576573201926333071L;

	/** The site id. */
	@Column(name = "SITE_ID")
	private Long siteId;
	
	/** The module id. */
	@Column(name = "MODULE_ID")
	private Long moduleId;
	
	/** The language. */
	@Column(name = "LANGUAGE")
	private String language;
	
	/** The available to learners. */
	@Column(name = "AVAILABLE_TO_LEARNERS")
	private Long availableToLearners;
	
	/** The available in catalog. */
	@Column(name = "AVAILABLE_IN_CATALOG")
	private Long availableInCatalog;
	
	/** The created. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED")
	private Date created;
	
	/** The course lookup. */
	@ManyToOne(targetEntity=CourseLookup.class, fetch = FetchType.EAGER)
	@JoinColumn(name="SYSTEM_ID", nullable=false)
	private CourseLookup courseLookup;


	/**
	 * Gets the site id.
	 *
	 * @return the siteId
	 */
	public Long getSiteId() {
		return siteId;
	}

	/**
	 * Sets the site id.
	 *
	 * @param siteId the siteId to set
	 */
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	/**
	 * Gets the module id.
	 *
	 * @return the moduleId
	 */
	public Long getModuleId() {
		return moduleId;
	}

	/**
	 * Sets the module id.
	 *
	 * @param moduleId the moduleId to set
	 */
	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	/**
	 * Gets the language.
	 *
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Sets the language.
	 *
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * Gets the available to learners.
	 *
	 * @return the availableToLearners
	 */
	public Long getAvailableToLearners() {
		return availableToLearners;
	}

	/**
	 * Sets the available to learners.
	 *
	 * @param availableToLearners the availableToLearners to set
	 */
	public void setAvailableToLearners(Long availableToLearners) {
		this.availableToLearners = availableToLearners;
	}

	/**
	 * Gets the available in catalog.
	 *
	 * @return the availableInCatalog
	 */
	public Long getAvailableInCatalog() {
		return availableInCatalog;
	}

	/**
	 * Sets the available in catalog.
	 *
	 * @param availableInCatalog the availableInCatalog to set
	 */
	public void setAvailableInCatalog(Long availableInCatalog) {
		this.availableInCatalog = availableInCatalog;
	}

	/**
	 * Gets the created.
	 *
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * Sets the created.
	 *
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * Gets the course lookup.
	 *
	 * @return the courseLookup
	 */
	public CourseLookup getCourseLookup() {
		return courseLookup;
	}

	/**
	 * Sets the course lookup.
	 *
	 * @param courseLookup the courseLookup to set
	 */
	public void setCourseLookup(CourseLookup courseLookup) {
		this.courseLookup = courseLookup;
	}
	
	
}
