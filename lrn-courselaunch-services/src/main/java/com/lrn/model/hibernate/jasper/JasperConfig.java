package com.lrn.model.hibernate.jasper;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.lrn.model.hibernate.AbstractBaseEntity;

/**
 * The class JasperConfig
 * 
 * @author kishor.pawar
 */
@NamedQueries( {
	@NamedQuery(name = "findJasperConfigByTypeIdSiteIdAndModuleIds",
			query = "from JasperConfig jc where jc.moduleId in (:moduleIds) and jasperConfigTypeId = :jasperConfigTypeId and siteId = :siteId")
})

@Entity
@SequenceGenerator(
		name 			= "GEN_SEQ",
		sequenceName 	= "JASPER_CONFIGS_SEQ"
)
@Table(name="JASPER_CONFIG")
public class JasperConfig extends AbstractBaseEntity {

	private static final long serialVersionUID = 3418608633000618535L;

	@Column(name = "JASPER_CONFIG_TYPE_ID")
	private Long jasperConfigTypeId;
	
	@Column(name = "MODULE_ID")
	private Long moduleId;
	
	@Column(name = "VALUE")
	private Long value;
	
	@Column(name = "SITE_ID")
	private Long siteId;

	/**
	 * @return the jasperConfigTypeId
	 */
	public Long getJasperConfigTypeId() {
		return jasperConfigTypeId;
	}

	/**
	 * @param jasperConfigTypeId the jasperConfigTypeId to set
	 */
	public void setJasperConfigTypeId(Long jasperConfigTypeId) {
		this.jasperConfigTypeId = jasperConfigTypeId;
	}

	/**
	 * @return the moduleId
	 */
	public Long getModuleId() {
		return moduleId;
	}

	/**
	 * @param moduleId the moduleId to set
	 */
	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	/**
	 * @return the value
	 */
	public Long getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Long value) {
		this.value = value;
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
	
	
}
