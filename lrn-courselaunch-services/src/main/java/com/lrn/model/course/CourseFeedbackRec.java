package com.lrn.model.course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.lrn.dto.course.CourseFeedbackRecDTO;
import com.lrn.dto.course.CourseFeedbackReqDTO;
import com.lrn.model.hibernate.AbstractBaseEntity;
import com.lrn.util.BeanUtils;

@Entity
@Table(name="COURSE_FEEDBACK_REC")
public class CourseFeedbackRec extends AbstractBaseEntity {

	@Column(name = "REQ_ID")
	private Long reqId;
	
	@Column(name = "RECIPIENT_USER_ID")
	private String recipientUserId;
	
	@Column(name = "RECIPIENT_FIRSTNAME")
	private String recipientFirstName;
	
	@Column(name = "RECIPIENT_LASTNAME")
	private String recipientLastName;
	
	@Column(name = "RECIPIENT_EMAIL")
	private String recipientEmail;
	
	@Column(name = "SENT")
	private Long sent;
	
	@Column(name = "VISITED")
	private Long visited;

	public Long getReqId() {
		return reqId;
	}

	public void setReqId(Long reqId) {
		this.reqId = reqId;
	}

	public String getRecipientUserId() {
		return recipientUserId;
	}

	public void setRecipientUserId(String recipientUserId) {
		this.recipientUserId = recipientUserId;
	}

	public String getRecipientFirstName() {
		return recipientFirstName;
	}

	public void setRecipientFirstName(String recipientFirstName) {
		this.recipientFirstName = recipientFirstName;
	}

	public String getRecipientLastName() {
		return recipientLastName;
	}

	public void setRecipientLastName(String recipientLastName) {
		this.recipientLastName = recipientLastName;
	}

	public String getRecipientEmail() {
		return recipientEmail;
	}

	public void setRecipientEmail(String recipientEmail) {
		this.recipientEmail = recipientEmail;
	}

	public Long getSent() {
		return sent;
	}

	public void setSent(Long sent) {
		this.sent = sent;
	}

	public Long getVisited() {
		return visited;
	}

	public void setVisited(Long visited) {
		this.visited = visited;
	}
	
	public CourseFeedbackRecDTO convertModelToDTO() {
		CourseFeedbackRecDTO dto = new CourseFeedbackRecDTO();         
		BeanUtils.copyProperties(this,dto);
		return dto;
	}
}
