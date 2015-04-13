package com.lrn.model.hibernate.site;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The Class SiteSecretkey.
 *
 * @author kishor.pawar
 */
@NamedQueries( {
	@NamedQuery(name = "findSiteSecretkeysByGroupId",
			query = "from SiteSecretkey ssk where ssk.siteSecretkeyPK.groupId = :groupId and (ssk.expires > SYSDATE or ssk.expires IS NULL)")
})
@Entity
@Table(name = "SITE_SECRETKEY")
public class SiteSecretkey implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5578407879992515278L;

	/** The site secretkey pk. */
	@Id
	private SiteSecretkeyPK siteSecretkeyPK;

	/** The secretkey. */
	@Column(name = "SECRETKEY")
	private String secretkey;

	/** The expires. */
	@Column(name = "EXPIRES")
	private Date expires;

	/**
	 * Gets the site secretkey pk.
	 *
	 * @return the siteSecretkeyPK
	 */
	public SiteSecretkeyPK getSiteSecretkeyPK() {
		return siteSecretkeyPK;
	}

	/**
	 * Sets the site secretkey pk.
	 *
	 * @param siteSecretkeyPK the siteSecretkeyPK to set
	 */
	public void setSiteSecretkeyPK(SiteSecretkeyPK siteSecretkeyPK) {
		this.siteSecretkeyPK = siteSecretkeyPK;
	}

	/**
	 * Gets the secretkey.
	 *
	 * @return the secretkey
	 */
	public String getSecretkey() {
		return secretkey;
	}

	/**
	 * Sets the secretkey.
	 *
	 * @param secretkey the secretkey to set
	 */
	public void setSecretkey(String secretkey) {
		this.secretkey = secretkey;
	}

	/**
	 * Gets the expires.
	 *
	 * @return the expires
	 */
	public Date getExpires() {
		return expires;
	}

	/**
	 * Sets the expires.
	 *
	 * @param expires the expires to set
	 */
	public void setExpires(Date expires) {
		this.expires = expires;
	}
}
