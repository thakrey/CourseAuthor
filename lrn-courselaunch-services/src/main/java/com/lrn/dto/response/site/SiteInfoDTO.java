package com.lrn.dto.response.site;

import java.io.Serializable;
import java.util.Date;

import com.lrn.model.spring.service.response.LRNError;

/**  
* SiteInfoDTO - data transfer object class for site info. 
* It stores the data for the site info. 
* 
* @see LRNError
*/

public class SiteInfoDTO implements Serializable {

	private static final long serialVersionUID = 5648310598595570258L;

	private Long 		siteId;
	
	private String 		name;
    
    private String 		host;
    
    private Boolean 	isActive;
    
    private Date 		deactivatedDate;
    
    private Date 		updatedDate;
    
    private boolean 	isSuccess = false;
    
    private LRNError 	error = null;
    
	/** Gets the siteId
	 * 
	 * @return the siteId
	 */
	public Long getSiteId() {
		return siteId;
	}

	/** Sets the siteId
	 * 
	 * @param siteId the siteId to set
	 */
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	/** Gets the name
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/** Sets the name
	 * 
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** Gets the host
	 * 
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/** Sets the host
	 * 
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/** Gets the isActive flag(true or false)
	 * 
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/** Sets the isActive flag (true or false)
	 * 
	 * @param isActive the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/** Gets the deactivatedDate
	 * 
	 * @return the deactivatedDate
	 */
	public Date getDeactivatedDate() {
		return deactivatedDate;
	}

	/** Sets the deactivatedDate
	 * 
	 * @param deactivatedDate the deactivatedDate to set
	 */
	public void setDeactivatedDate(Date deactivatedDate) {
		this.deactivatedDate = deactivatedDate;
	}

	/** Gets the updatedDate
	 * 
	 * @return the updatedDate
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/** Sets the updatedDate
	 * 
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	/** Gets the isSuccess flag (true or false)
	 * 
	 * @return the isSuccess
	 */
	public boolean isSuccess() {
		return isSuccess;
	}

	/** Sets the isSuccess flag (true or false)
	 * 
	 * @param isSuccess the isSuccess to set
	 */
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	/** Gets the error
	 * 
	 * @return the error {@link LRNError}
	 */
	public LRNError getError() {
		return error;
	}

	/** Sets the error
	 * 
	 * @param error the error - {@link LRNError} to set
	 */
	public void setError(LRNError error) {
		this.error = error;
	}

}
