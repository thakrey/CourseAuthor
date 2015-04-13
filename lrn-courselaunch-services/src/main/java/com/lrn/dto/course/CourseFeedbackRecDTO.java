/**
 * 
 */
package com.lrn.dto.course;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;



import com.lrn.model.course.CourseFeedbackRec;
import com.lrn.util.BeanUtils;

/**
 * @author kishore.ohal
 *
 */
public class CourseFeedbackRecDTO implements Serializable{
	
	private Long reqId;
	private String recipientUserId;
	private String recipientFirstName;
	private String recipientLastName;
	private String recipientEmail;
	private Long sent;
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
	
	public CourseFeedbackRec convertDTOToModel() {
		CourseFeedbackRec model = new CourseFeedbackRec();
		BeanUtils.copyProperties(this, model);  
		return model;

	}
}
