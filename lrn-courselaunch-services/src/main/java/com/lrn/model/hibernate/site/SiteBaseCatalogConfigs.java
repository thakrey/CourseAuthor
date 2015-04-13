package com.lrn.model.hibernate.site;

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
 * The Class SiteBaseCatalogConfigs.
 *
 * @author kishor.pawar
 */
@NamedQueries( {
	@NamedQuery(name = "getConfigsByBaseCatalogIdAndSiteIdAndKey",
		query = "from SiteBaseCatalogConfigs configs where configs.siteId = :siteId " +
				"and configs.baseCatalogId = :baseCatalogId and configs.configKey " +
				"= :key ")
})
@Entity
@SequenceGenerator(
		name 			= "GEN_SEQ",
		sequenceName 	= "SITE_BASE_CATALOG_CONFIGS_SEQ"
)
@Table(name="SITE_BASE_CATALOG_CONFIGS")
public class SiteBaseCatalogConfigs extends AbstractBaseEntity {
	
    private static final long serialVersionUID = -5586570086124279772L;

	@Column(name="CUSTOM_PUBLISH_ID", nullable=false)
    private Long customPublishId;
        
    @Column(name="SITE_ID", nullable=false)
    private Long siteId;
    
    @Column(name="BASE_CATALOG_ID", nullable=true)
    private String baseCatalogId;
    
    @Column(name="CONFIG_KEY", nullable=false)
    private String configKey;
    
    @Column(name="CONFIG_VALUE", nullable=true)
    private String configValue;
    
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED", nullable=false)
    private Date createDate;

	/**
	 * @return the customPublishId
	 */
	public Long getCustomPublishId() {
		return customPublishId;
	}

	/**
	 * @param customPublishId the customPublishId to set
	 */
	public void setCustomPublishId(Long customPublishId) {
		this.customPublishId = customPublishId;
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
	 * @return the baseCatalogId
	 */
	public String getBaseCatalogId() {
		return baseCatalogId;
	}

	/**
	 * @param baseCatalogId the baseCatalogId to set
	 */
	public void setBaseCatalogId(String baseCatalogId) {
		this.baseCatalogId = baseCatalogId;
	}

	/**
	 * @return the configKey
	 */
	public String getConfigKey() {
		return configKey;
	}

	/**
	 * @param configKey the configKey to set
	 */
	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}

	/**
	 * @return the configValue
	 */
	public String getConfigValue() {
		return configValue;
	}

	/**
	 * @param configValue the configValue to set
	 */
	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}