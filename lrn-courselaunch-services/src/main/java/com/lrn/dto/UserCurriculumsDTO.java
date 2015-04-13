/**
 * 
 */
package com.lrn.dto;

import java.io.Serializable;
import java.util.List;

/**  
* UserCurriculumsDTO - data transfer object class for list of User Curriculum. 
* It stores the data for the list of User curriculum. 
* 
*/
public class UserCurriculumsDTO implements Serializable {
	
	private Long userId;
	
	private List<CurriculumDTO> curriculums;

	/** Gets the userId
	 * 
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/** Sets the userId
	 * 
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/** Gets the list of curriculums
	 * 
	 * @return the curriculums, holds list of {@link CurriculumDTO}
	 */
	public List<CurriculumDTO> getCurriculums() {
		return curriculums;
	}

	/** Sets the list of curriculums
	 * 
	 * @param curriculums the curriculums - list of {@link CurriculumDTO} to set
	 */
	public void setCurriculums(List<CurriculumDTO> curriculums) {
		this.curriculums = curriculums;
	}

}
