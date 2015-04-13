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
 * The Class CurriculumCourse
 * 
 * @author kishor.pawar
 */
@NamedQueries( {
	@NamedQuery(name = "findCurriculumCourseByCurriculumIds",
			query = "from CurriculumCourse cc where cc.curriculumId IN (:curriculumIds)")
})
@Entity
@SequenceGenerator(
		name 			= "GEN_SEQ",
		sequenceName 	= "CURRICULUM_COURSE_SEQ"
)
@Table(name="CURRICULUM_COURSE")
public class CurriculumCourse extends AbstractBaseEntity {

	private static final long serialVersionUID = -562997102673540516L;

	@Column(name="CURRICULUM_ID")
    private Long curriculumId;
	
	@Column(name="SYSTEM_ID")
    private String systemId;
	
	@Column(name="SRC_CERT_REQ_ID")
    private Long srcCertReqId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFIED")
	private Date modified;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED")
	private Date created;
	
	@Column(name="MODULE_ID")
    private Long moduleId;
	
	/** UI only field **/
	//private boolean isModuleCompleted;

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
	 * @return the systemId
	 */
	public String getSystemId() {
		return systemId;
	}

	/**
	 * @param systemId the systemId to set
	 */
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	/**
	 * @return the srcCertReqId
	 */
	public Long getSrcCertReqId() {
		return srcCertReqId;
	}

	/**
	 * @param srcCertReqId the srcCertReqId to set
	 */
	public void setSrcCertReqId(Long srcCertReqId) {
		this.srcCertReqId = srcCertReqId;
	}

	/*public boolean isModuleCompleted() {
		return isModuleCompleted;
	}

	public void setModuleCompleted(boolean isModuleCompleted) {
		this.isModuleCompleted = isModuleCompleted;
	}*/

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
	 * @return the moduleId
	 */
	public Long getModuleId() {
		return moduleId;
	}

	/**
	 * @param moduleId the moduleId to set
	 */
	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}
}
