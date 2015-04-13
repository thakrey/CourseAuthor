package com.lrn.model.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The Class Contact.
 *
 */
@Entity
@SequenceGenerator(name = "GEN_SEQ", sequenceName = "CONTACT_SEQ")
@Table(name = "CONTACT")
public class Contact extends AbstractBaseEntity {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7132437776896632518L;

	/** The contact type. */
	@ManyToOne(targetEntity = ContactType.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "CONTACT_TYPE_ID", nullable = false)
	private ContactType contactType;

	/** The site id. */
	@Column(name="SITE_ID")
	private Long siteId;
	
	/** The title. */
	@Column(name="TITLE")
	private String title;
	
	/** The value. */
	@Column(name="VALUE")
	private String value;
	
	/** The position. */
	@Column(name="POSITION")
	private Long position;

	/**
	 * Gets the contact type.
	 *
	 * @return the contactType
	 */
	public ContactType getContactType() {
		return contactType;
	}

	/**
	 * Sets the contact type.
	 *
	 * @param contactType the contactType to set
	 */
	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
	}

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
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	public Long getPosition() {
		return position;
	}

	/**
	 * Sets the position.
	 *
	 * @param position the position to set
	 */
	public void setPosition(Long position) {
		this.position = position;
	}
}
