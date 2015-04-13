package com.lrn.model.hibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.lrn.model.hibernate.custom.CustomPublishes;

/**
 * The Class RsaKeysPK.
 *
*/
@Embeddable
public class RsaKeysPK implements Serializable {

	private static final long serialVersionUID = -2455565365196584813L;

	@Column(name="SITE_ID")
    private Long siteId;
	
	@ManyToOne(targetEntity = RsaKeysType.class, fetch = FetchType.EAGER)
	@JoinColumn(name="RSA_KEYS_TYPE_ID", nullable=false)
	private RsaKeysType rsaKeysType;

	/**
	 * @return the siteId
	 */
	public Long getSiteId() {
		return siteId;
	}

	/**
	 * @param siteId the siteId to set
	 */
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	/**
	 * @return the rsaKeysType
	 */
	public RsaKeysType getRsaKeysType() {
		return rsaKeysType;
	}

	/**
	 * @param rsaKeysType the rsaKeysType to set
	 */
	public void setRsaKeysType(RsaKeysType rsaKeysType) {
		this.rsaKeysType = rsaKeysType;
	}
}