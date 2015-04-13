package com.lrn.model.hibernate.site;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.lrn.model.hibernate.AbstractBaseEntity;

/**
 * The Class SiteLanguage.
 *
 * @author kishor.pawar
 */
@NamedQueries( {
	@NamedQuery(name = "findBySiteAndLanguage",
			query = "from SiteLanguage s where s.siteId = :siteId")
})
@Entity
@SequenceGenerator(name = "GEN_SEQ", sequenceName = "SITE_LANGUAGE_SEQ")
@Table(name = "SITE_LANGUAGE")
public class SiteLanguage extends AbstractBaseEntity implements Serializable {

	private static final long serialVersionUID = 3093102245286266425L;

	@Column(name="SITE_ID")
	private Long siteId;

	@Column(name="LANGUAGE_ID")
	private Long languageId;

	@Column(name="ENABLE")
	private Long enable;

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public Long getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}

	public Long getEnable() {
		return enable;
	}

	public void setEnable(Long enable) {
		this.enable = enable;
	}
}
