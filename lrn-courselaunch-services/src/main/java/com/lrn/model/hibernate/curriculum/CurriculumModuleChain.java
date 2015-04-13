package com.lrn.model.hibernate.curriculum;

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
 * The Class CurriculumModuleChain
 * 
 * @author kishor.pawar
 */
@NamedQueries( {
	@NamedQuery(name = "findCurriculumModuleChainByCurriculumIds",
			query = "from CurriculumModuleChain cmc where cmc.siteId = :siteId and cmc.curriculumId IN (:curriculumIds) )")
})
@Entity
@SequenceGenerator(name = "GEN_SEQ", sequenceName = "CURRICULUM_MODULE_CHAIN_SEQ")
@Table(name = "CURRICULUM_MODULE_CHAIN")
public class CurriculumModuleChain extends AbstractBaseEntity {

	private static final long serialVersionUID = -6013181787254882338L;

	@Column(name = "CURRICULUM_ID")
	private Long curriculumId;
	
	@Column(name = "SITE_ID")
	private Long siteId;
	
	@Column(name = "MODULE_CHAIN_ID")
	private Long moduleChainId;
	
	@Column(name = "SRC_REQ_ID")
	private Long srcReqId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED")
	private Date created;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED")
	private Date updated;

	/**
	 * @return the curriculumId
	 */
	public Long getCurriculumId() {
		return curriculumId;
	}

	/**
	 * @param curriculumId the curriculumId to set
	 */
	public void setCurriculumId(Long curriculumId) {
		this.curriculumId = curriculumId;
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
	 * @return the srcReqId
	 */
	public Long getSrcReqId() {
		return srcReqId;
	}

	/**
	 * @param srcReqId the srcReqId to set
	 */
	public void setSrcReqId(Long srcReqId) {
		this.srcReqId = srcReqId;
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

	/**
	 * @return the updated
	 */
	public Date getUpdated() {
		return updated;
	}

	/**
	 * @param updated the updated to set
	 */
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	
	
}
