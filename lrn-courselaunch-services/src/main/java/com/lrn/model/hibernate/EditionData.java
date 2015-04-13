package com.lrn.model.hibernate;

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

/**
 * The Class EditionDate
 * 
 */

/*@NamedQueries( {
	@NamedQuery(name = "getEstimatedTimeByModuleIds",
			query = "from EditionData ed where ed.name = 'estimated_time' " +
					"and ed.edition.moduleId IN (:moduleIds) ")
})*/

@Entity
@SequenceGenerator(name = "GEN_SEQ", sequenceName = "EDITION_DATA_SEQ")
@Table(name = "EDITION_DATA")
public class EditionData extends AbstractBaseEntity {
	
	private static final long serialVersionUID = 7127184326276027496L;

	@ManyToOne(targetEntity = Edition.class, fetch = FetchType.EAGER)
	@JoinColumn(name="EDITION_ID", nullable=false)
	private Edition edition;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "VALUE")
	private String value;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED")
	private Date created;

	public EditionData() {}
	
	public EditionData(Edition edition, String name, String value, Date created) {
		setEdition(edition);
		setName(name);
		setValue(value);
		setCreated(created);
	}
	
	/**
	 * @return the edition
	 */
	public Edition getEdition() {
		return edition;
	}

	/**
	 * @param edition the edition to set
	 */
	public void setEdition(Edition edition) {
		this.edition = edition;
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
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
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
}
