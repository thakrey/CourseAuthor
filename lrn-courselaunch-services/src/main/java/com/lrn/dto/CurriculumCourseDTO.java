/**
 * 
 */
package com.lrn.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**  
* CurriculumCourseDTO - data transfer object class for Curriculum course. 
* It stores the data for the curriculum courses. 
* 
*/ 
public class CurriculumCourseDTO implements Serializable {

	private BigDecimal id;
	
	private BigDecimal curriculumId;
	
	private String systemId;
	
	private BigDecimal srcCertReqId;
	
	private Date modified;
	
	private Date created;
	
	private BigDecimal moduleId;

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

	/** Gets the curriculum Id
	 * 
	 * @return the curriculumId
	 */
	public BigDecimal getCurriculumId() {
		return curriculumId;
	}

	/** Sets the curriculum Id
	 * 
	 * @param curriculumId the curriculumId to set
	 */
	public void setCurriculumId(BigDecimal curriculumId) {
		this.curriculumId = curriculumId;
	}

	/** Gets the system Id
	 * 
	 * @return the systemId
	 */
	public String getSystemId() {
		return systemId;
	}

	/** Sets the systemId 
	 * 
	 * @param systemId the systemId to set
	 */
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	/** Gets the srcCertReqId
	 * 
	 * @return the srcCertReqId
	 */
	public BigDecimal getSrcCertReqId() {
		return srcCertReqId;
	}

	/** Sets the srcCertReqId
	 * 
	 * @param srcCertReqId the srcCertReqId to set
	 */
	public void setSrcCertReqId(BigDecimal srcCertReqId) {
		this.srcCertReqId = srcCertReqId;
	}

	/** Gets the modified
	 * 
	 * @return the modified
	 */
	public Date getModified() {
		return modified;
	}

	/** Sets the modified
	 * 
	 * @param modified the modified to set
	 */
	public void setModified(Date modified) {
		this.modified = modified;
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
	
	
}
