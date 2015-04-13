package com.lrn.model.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The Class ContactType.
 */
@Entity
@SequenceGenerator(name = "GEN_SEQ", sequenceName = "CONTACT_TYPE_SEQ")
@Table(name = "CONTACT_TYPE")
public class ContactType extends AbstractBaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3763283074887739493L;
	
	/** The name. */
	@Column(name="NAME")
	private String name;

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
