package com.lrn.model.spring.service.response.module;

import java.io.Serializable;
import java.util.List;

import com.lrn.model.spring.service.response.LRNResponse;
import com.lrn.model.spring.service.response.module.CompletionCertificateDTO;

public class ModulesTakenDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6838417957200002772L;

	private String userId;
	
	private String company;
	
	private List<CompletionCertificateDTO> completionCertificates;

	private LRNResponse lrnResponse;

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
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @return the completionCertificates
	 */
	public List<CompletionCertificateDTO> getCompletionCertificates() {
		return completionCertificates;
	}

	/**
	 * @param completionCertificates the completionCertificates to set
	 */
	public void setCompletionCertificates(
			List<CompletionCertificateDTO> completionCertificates) {
		this.completionCertificates = completionCertificates;
	}

	public void setLrnResponse(LRNResponse lrnresponse) {
		// TODO Auto-generated method stub
		this.lrnResponse = lrnresponse;  
	}
	
	/**
	 * @return the lrnResponse
	 */
	public LRNResponse getLrnResponse() {
		return lrnResponse;
	}

}
