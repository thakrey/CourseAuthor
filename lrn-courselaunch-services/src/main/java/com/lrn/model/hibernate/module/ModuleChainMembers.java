/**
 * 
 */
package com.lrn.model.hibernate.module;

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
 * The Class ModuleChainMembers
 * 
 * @author kishor.pawar
 */
@NamedQueries( {
	@NamedQuery(name = "findModuleChainMembersByModuleChainIds",
			query = "from ModuleChainMembers mcm where mcm.moduleChainId IN (:moduleChainIds) )")
})
@Entity
@SequenceGenerator(name = "GEN_SEQ", sequenceName = "MODULE_CHAIN_MEMBERS_SEQ")
@Table(name = "MODULE_CHAIN_MEMBERS")
public class ModuleChainMembers extends AbstractBaseEntity {

	private static final long serialVersionUID = -4292721119076166837L;

	@Column(name = "MODULE_CHAIN_ID")
	private Long moduleChainId;
	
	@Column(name = "MODULE_ID")
	private Long modulId;
	
	@Column(name = "SITE_ID")
	private Long siteId;
	
	@Column(name = "SEQUENCE")
	private Long sequence;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED")
	private Date created;

	/**
	 * @return the moduleChainId
	 */
	public Long getModuleChainId() {
		return moduleChainId;
	}

	/**
	 * @param moduleChainId the moduleChainId to set
	 */
	public void setModuleChainId(Long moduleChainId) {
		this.moduleChainId = moduleChainId;
	}

	/**
	 * @return the modulId
	 */
	public Long getModulId() {
		return modulId;
	}

	/**
	 * @param modulId the modulId to set
	 */
	public void setModulId(Long modulId) {
		this.modulId = modulId;
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
	 * @return the sequence
	 */
	public Long getSequence() {
		return sequence;
	}

	/**
	 * @param sequence the sequence to set
	 */
	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}

	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}
	
}
