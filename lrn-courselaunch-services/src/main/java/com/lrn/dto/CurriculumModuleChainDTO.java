/**
 * 
 */
package com.lrn.dto;

import java.math.BigDecimal;
import java.util.Date;

/**  
* CurriculumModuleChainDTO - data transfer object class for Curriculum module chain. 
* It stores the data for the curriculum module chain. 
* 
*/ 
public class CurriculumModuleChainDTO {
	
	private BigDecimal id;

	private BigDecimal curriculumId;
	
	private BigDecimal siteId;
	
	private BigDecimal moduleChainId;
	
	private BigDecimal srcReqId;
	
	private Date created;
	
	private Date updated;

	/** Gets the id
	 * 
	 * @return the id
	 */
	public BigDecimal getId() {
		return id;
	}

	/** Sets the id
	 * 
	 * @param id the id to set
	 */
	public void setId(BigDecimal id) {
		this.id = id;
	}

	/** Gets the curriculumId
	 * 
	 * @return the curriculumId
	 */
	public BigDecimal getCurriculumId() {
		return curriculumId;
	}

	/** Sets the curriculumId
	 * 
	 * @param curriculumId the curriculumId to set
	 */
	public void setCurriculumId(BigDecimal curriculumId) {
		this.curriculumId = curriculumId;
	}

	/** Gets the siteId
	 * 
	 * @return the siteId
	 */
	public BigDecimal getSiteId() {
		return siteId;
	}

	/** Sets the siteId
	 * 
	 * @param siteId the siteId to set
	 */
	public void setSiteId(BigDecimal siteId) {
		this.siteId = siteId;
	}

	/** Gets the moduleChainId
	 * 
	 * @return the moduleChainId
	 */
	public BigDecimal getModuleChainId() {
		return moduleChainId;
	}

	/** Sets the moduleChainId
	 * 
	 * @param moduleChainId the moduleChainId to set
	 */
	public void setModuleChainId(BigDecimal moduleChainId) {
		this.moduleChainId = moduleChainId;
	}
 
	/** Gets the srcReqId
	 * 
	 * @return the srcReqId
	 */
	public BigDecimal getSrcReqId() {
		return srcReqId;
	}

	/** Sets the srcReqId
	 * 
	 * @param srcReqId the srcReqId to set
	 */
	public void setSrcReqId(BigDecimal srcReqId) {
		this.srcReqId = srcReqId;
	}

	/** Gets the created
	 * 
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/** Sets the created
	 * 
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/** Gets the updated
	 * 
	 * @return the updated
	 */
	public Date getUpdated() {
		return updated;
	}

	/** Sets the updated
	 * 
	 * @param updated the updated to set
	 */
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
}
