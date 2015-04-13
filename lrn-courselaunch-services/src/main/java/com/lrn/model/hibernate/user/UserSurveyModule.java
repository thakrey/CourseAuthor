package com.lrn.model.hibernate.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.lrn.model.hibernate.AbstractBaseEntity;

/**
 * The Class UserSurveyModule
 * 
 * @author kishor.pawar
 *
 */
@Entity
@SequenceGenerator(name = "GEN_SEQ", sequenceName = "USER_SURVEY_MODULE_SEQ")
@Table(name = "USER_SURVEY_MODULE")
public class UserSurveyModule extends AbstractBaseEntity {

	private static final long serialVersionUID = 6040563122305585097L;

	@Column(name = "USER_SURVEY_ID")
	private Long userSurveyId;
	
	@Column(name = "SITE_ID")
	private Long siteId;
	
	@Column(name = "CATALOG_ID")
	private String catalogId;

	/**
	 * @return the userSurveyId
	 */
	public Long getUserSurveyId() {
		return userSurveyId;
	}

	/**
	 * @param userSurveyId the userSurveyId to set
	 */
	public void setUserSurveyId(Long userSurveyId) {
		this.userSurveyId = userSurveyId;
	}

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
	 * @return the catalogId
	 */
	public String getCatalogId() {
		return catalogId;
	}

	/**
	 * @param catalogId the catalogId to set
	 */
	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}
}
