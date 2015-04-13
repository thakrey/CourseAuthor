/**
 * 
 */
package com.lrn.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**  
* ModuleChainMembersDTO - data transfer object class for module chain members. 
* It stores the data for the module chain members. 
* 
*/ 
public class ModuleChainMembersDTO  implements Serializable {
	
	private BigDecimal id;

	private BigDecimal moduleChainId;
	
	private BigDecimal moduleId;
	
	private BigDecimal siteId;
	
	private BigDecimal sequence;
	
	private Date created;

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

	/** Gets the moduleId
	 * 
	 * @return the moduleId
	 */
	public BigDecimal getModuleId() {
		return moduleId;
	}

	/** Sets the moduleId
	 * 
	 * @param moduleId the moduleId to set
	 */
	public void setModuleId(BigDecimal moduleId) {
		this.moduleId = moduleId;
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

	/** Gets the sequence
	 * 
	 * @return the sequence
	 */
	public BigDecimal getSequence() {
		return sequence;
	}

	/** Sets the sequence
	 * 
	 * @param sequence the sequence to set
	 */
	public void setSequence(BigDecimal sequence) {
		this.sequence = sequence;
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
}
