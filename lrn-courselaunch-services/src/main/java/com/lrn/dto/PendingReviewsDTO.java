/**
 * 
 */
package com.lrn.dto;

import java.math.BigDecimal;
import java.util.Date;

/**  
* PendingReviewsDTO - data transfer object class for pending reviews. 
* It stores the data for the pending reviews. 
*
* 
*/
public class PendingReviewsDTO {

	private String baseCatalogId;
	
	private String loginName;
	
	private String firstname;
	
	private String middlename;
	
	private String lastname;
	
	private String status;
	
	private Date reviewDueDate;
	
	private BigDecimal jasperAttemptId;
	
	private BigDecimal moduleId;
	
	private BigDecimal srcJasperStatusId;
	
	private String email;
	
	private String systemId;

	/** Gets the baseCatalogId
	 * 
	 * @return the baseCatalogId
	 */
	public String getBaseCatalogId() {
		return baseCatalogId;
	}

	/** Sets the baseCatalogId
	 * 
	 * @param baseCatalogId the baseCatalogId to set
	 */
	public void setBaseCatalogId(String baseCatalogId) {
		this.baseCatalogId = baseCatalogId;
	}

	/** Gets the loginName
	 * 
	 * @return the loginName
	 */
	public String getLoginName() {
		return loginName;
	}

	/** Sets the loginName
	 * 
	 * @param loginName the loginName to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/** Gets the firstname
	 * 
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/** Sets the firstname
	 * 
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/** Gets the middlename
	 * 
	 * @return the middlename
	 */
	public String getMiddlename() {
		return middlename;
	}

	/** Sets the middlename
	 * 
	 * @param middlename the middlename to set
	 */
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	/** Gets the lastname
	 * 
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/** Sets the lastname
	 * 
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/** Gets the status
	 * 
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/** Sets the status
	 * 
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/** Gets the reviewDueDate
	 * 
	 * @return the reviewDueDate
	 */
	public Date getReviewDueDate() {
		return reviewDueDate;
	}

	/** Sets the reviewDueDate
	 * 
	 * @param reviewDueDate the reviewDueDate to set
	 */
	public void setReviewDueDate(Date reviewDueDate) {
		this.reviewDueDate = reviewDueDate;
	}

	/** Gets the jasperAttemptId
	 * 
	 * @return the jasperAttemptId
	 */
	public BigDecimal getJasperAttemptId() {
		return jasperAttemptId;
	}

	/** Sets the jasperAttemptId
	 * 
	 * @param jasperAttemptId the jasperAttemptId to set
	 */
	public void setJasperAttemptId(BigDecimal jasperAttemptId) {
		this.jasperAttemptId = jasperAttemptId;
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

	/** Gets the srcJasperStatusId
	 * 
	 * @return the srcJasperStatusId
	 */
	public BigDecimal getSrcJasperStatusId() {
		return srcJasperStatusId;
	}

	/** Sets the srcJasperStatusId
	 * 
	 * @param srcJasperStatusId the srcJasperStatusId to set
	 */
	public void setSrcJasperStatusId(BigDecimal srcJasperStatusId) {
		this.srcJasperStatusId = srcJasperStatusId;
	}

	/** Gets the email
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/** Sets the email
	 * 
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/** Gets the systemId
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
	
}
