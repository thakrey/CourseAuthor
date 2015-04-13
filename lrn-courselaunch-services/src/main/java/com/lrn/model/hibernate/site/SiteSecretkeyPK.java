package com.lrn.model.hibernate.site;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The Class SiteSecretkeyPK.
 *
 * @author sreenivas.k
 */
@Embeddable
public class SiteSecretkeyPK implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5837122414677459755L;

	/** The group id. */
	@Column(name="GROUP_ID", nullable=false)
	private String groupId;
	
	/** The creation. */
	@Column(name="CREATION")
	private Date creation;

	/**
	 * Gets the group id.
	 *
	 * @return the groupId
	 */
	public String getGroupId() {
		return groupId;
	}

	/**
	 * Sets the group id.
	 *
	 * @param groupId the groupId to set
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	/**
	 * Gets the creation.
	 *
	 * @return the creation
	 */
	public Date getCreation() {
		return creation;
	}

	/**
	 * Sets the creation.
	 *
	 * @param creation the creation to set
	 */
	public void setCreation(Date creation) {
		this.creation = creation;
	}
	
}
