package com.lrn.dto.course;

import java.io.Serializable;
import java.util.Date;


import com.lrn.util.BeanUtils;

/**
 * @author kishore.ohal
 *
 */
public class CourseFeedbackReqDTO implements Serializable{
	
	private Long courseVersionId;
	private String requestedBy;
	private Long siteId;
	private Date created;

	public Long getCourseVersionId() {
		return courseVersionId;
	}

	public void setCourseVersionId(Long courseVersionId) {
		this.courseVersionId = courseVersionId;
	}

	public String getRequestedBy() {
		return requestedBy;
	}

	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
	}

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

/*	public CourseFeedbackReq convertDTOToModel() {
		CourseFeedbackReq model = new CourseFeedbackReq();
		BeanUtils.copyProperties(this, model);  
		return model;

	}*/
}
