package com.lrn.model.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The Class Switch.
 *
*/
@Entity
@SequenceGenerator(name = "GEN_SEQ", sequenceName = "SWITCH_SEQ")
@Table(name = "SWITCH")
public class Switch extends AbstractBaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2574831757177411747L;
	
	/** The name. */
    @Column(name="NAME")
    private String name;
    
    /** The parent switch id. */
    @Column(name="PARENT_SWITCH_ID")
    private Long parentSwitchId;
    
    /** The description. */
    @Column(name="DESCRIPTION")
    private String description;

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

	/**
	 * Gets the parent switch id.
	 *
	 * @return the parentSwitchId
	 */
	public Long getParentSwitchId() {
		return parentSwitchId;
	}

	/**
	 * Sets the parent switch id.
	 *
	 * @param parentSwitchId the parentSwitchId to set
	 */
	public void setParentSwitchId(Long parentSwitchId) {
		this.parentSwitchId = parentSwitchId;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
