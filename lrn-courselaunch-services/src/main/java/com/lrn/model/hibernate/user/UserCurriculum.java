package com.lrn.model.hibernate.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The Class UserCurriculum
 * 
 * @author kishor.pawar
 *
 */
@NamedQueries( {
	@NamedQuery(name = "getUserCurriculumsByUserId",
			query = "from UserCurriculum uc where uc.userCurriculumPK.userId = :userId")
})
@Entity
@Table(name = "USER_CURRICULUM")
public class UserCurriculum implements Serializable {

	private static final long serialVersionUID = 6900855762227818181L;

	@Id
	private UserCurriculumPK userCurriculumPK;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED")
	private Date created;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFIED")
	private Date modified;
	
	@Column(name="BULK_ID")
	private Long bulkId;

	/**
	 * @return the userCurriculumPK
	 */
	public UserCurriculumPK getUserCurriculumPK() {
		return userCurriculumPK;
	}

	/**
	 * @param userCurriculumPK the userCurriculumPK to set
	 */
	public void setUserCurriculumPK(UserCurriculumPK userCurriculumPK) {
		this.userCurriculumPK = userCurriculumPK;
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
	 * @return the modified
	 */
	public Date getModified() {
		return modified;
	}

	/**
	 * @param modified the modified to set
	 */
	public void setModified(Date modified) {
		this.modified = modified;
	}

	/**
	 * @return the bulkId
	 */
	public Long getBulkId() {
		return bulkId;
	}

	/**
	 * @param bulkId the bulkId to set
	 */
	public void setBulkId(Long bulkId) {
		this.bulkId = bulkId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bulkId == null) ? 0 : bulkId.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result
				+ ((modified == null) ? 0 : modified.hashCode());
		result = prime
				* result
				+ ((userCurriculumPK == null) ? 0 : userCurriculumPK.hashCode());
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
		UserCurriculum other = (UserCurriculum) obj;
		if (bulkId == null) {
			if (other.bulkId != null)
				return false;
		} else if (!bulkId.equals(other.bulkId))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (modified == null) {
			if (other.modified != null)
				return false;
		} else if (!modified.equals(other.modified))
			return false;
		if (userCurriculumPK == null) {
			if (other.userCurriculumPK != null)
				return false;
		} else if (!userCurriculumPK.equals(other.userCurriculumPK))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserCurriculum [userCurriculumPK=" + userCurriculumPK
				+ ", created=" + created + ", modified=" + modified
				+ ", bulkId=" + bulkId + "]";
	}
	
}
