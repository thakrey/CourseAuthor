package com.lrn.model.hibernate.site;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.lrn.model.hibernate.AbstractBaseEntity;
import com.lrn.model.hibernate.Switch;

/**
 * The Model for SiteSwitch table.
 * 
 * @author kishor.pawar
 */
@Entity
@SequenceGenerator(name = "GEN_SEQ", sequenceName = "SITE_SWITCH_SEQ")
@Table(name = "SITE_SWITCH")
public class SiteSwitch extends AbstractBaseEntity {
    
    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5589422795715515694L;

	/** The site id. */
    @Column(name="SITE_ID")
    private Long siteId;
    
    /** The value. */
    @Column(name="VALUE")
    private Long value;
    
    /** The switch obj. */
    @ManyToOne(targetEntity=Switch.class, fetch=FetchType.EAGER)
    @JoinColumn(name="SWITCH_ID", nullable=false)
    private Switch switchObj;

	/**
	 * Gets the site id.
	 *
	 * @return the site id
	 */
	public Long getSiteId() {
		return siteId;
	}

	/**
	 * Sets the site id.
	 *
	 * @param siteId the new site id
	 */
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public Long getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(Long value) {
		this.value = value;
	}

	/**
	 * Gets the switch obj.
	 *
	 * @return the switchObj
	 */
	public Switch getSwitchObj() {
		return switchObj;
	}

	/**
	 * Sets the switch obj.
	 *
	 * @param switchObj the switchObj to set
	 */
	public void setSwitchObj(Switch switchObj) {
		this.switchObj = switchObj;
	}
}
