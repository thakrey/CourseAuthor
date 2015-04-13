package com.lrn.model.hibernate.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The Class UserCurriculumPK
 * 
 * @author kishor.pawar
 */
@Embeddable
public class UserCurriculumPK implements Serializable {

	@Column(name="USER_ID")
	private String userId;
	
	@Column(name="CURRICULUM_ID")
	private Long curriculumId;

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((curriculumId == null) ? 0 : curriculumId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserCurriculumPK other = (UserCurriculumPK) obj;
		if (curriculumId == null) {
			if (other.curriculumId != null)
				return false;
		} else if (!curriculumId.equals(other.curriculumId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserCurriculumPK [userId=" + userId + ", curriculumId="
				+ curriculumId + "]";
	}
	
	
}
