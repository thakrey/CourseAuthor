/**
 * 
 */
package com.lrn.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**  
* UserCurriculumDTO - data transfer object class for User Curriculum. 
* It stores the data for the User curriculum. 
* 
*/
public class UserCurriculumDTO implements Serializable {

	private String userId;
	
	private BigDecimal curriculumId;
	
	private Date created;
	
	private Date modified;
	
	private BigDecimal bulkId;

	/** Gets the userId
	 * 
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/** Sets the userId
	 * 
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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

	/** Gets the bulkId
	 * 
	 * @return the bulkId
	 */
	public BigDecimal getBulkId() {
		return bulkId;
	}

	/** Sets the bulkId
	 * 
	 * @param bulkId the bulkId to set
	 */
	public void setBulkId(BigDecimal bulkId) {
		this.bulkId = bulkId;
	}
	
	
}
