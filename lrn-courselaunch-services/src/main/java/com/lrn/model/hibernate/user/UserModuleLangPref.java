package com.lrn.model.hibernate.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.lrn.model.hibernate.AbstractBaseEntity;

/**
 * The Class UserModuleLangPref
 * 
 * @author kishor.pawar
 *
 */
@NamedQueries( {
	@NamedQuery(name = "findUserModuleLangPrefByUserIdSiteIdModuleId",
			query = "from UserModuleLangPref u where u.userId = :userId and u.siteId = :siteId and u.moduleId = :moduleId")
})
@Entity
@SequenceGenerator(name = "GEN_SEQ", sequenceName = "USER_MODULE_LANG_PREF_SEQ")
@Table(name = "USER_MODULE_LANG_PREF")
public class UserModuleLangPref extends AbstractBaseEntity implements Serializable {

	private static final long serialVersionUID = -6624427644627355906L;

	@Column(name = "USER_ID")
	private String userId;

	@Column(name = "SITE_ID")
	private Long siteId;
	
	@Column(name = "MODULE_ID")
	private Long moduleId;
	
	@Column(name = "LANGUAGE")
	private String language;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED")
	private Date created;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED")
	private Date updated;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public Long getModuleId() {
		return moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}
}
