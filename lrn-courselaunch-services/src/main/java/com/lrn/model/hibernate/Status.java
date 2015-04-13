package com.lrn.model.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The Class Status.
 *
 */
@Entity
@SequenceGenerator(name = "GEN_SEQ", sequenceName = "STATUS_SEQ")
@Table(name = "STATUS")
public class Status extends AbstractBaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7614013063555707354L;
	
	/** The name. */
	@Column(name = "NAME")
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
