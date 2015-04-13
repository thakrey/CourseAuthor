package com.lrn.model.spring.service.response.module;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.lrn.model.spring.service.response.LRNResponse;
import com.lrn.model.spring.service.response.module.ModuleCoursesDTO;

/**
 * The UserModuleDTO class
 * @author vmulla
 *
 */
public class UserModulesDTO implements Serializable {

	private String userId;

	private Long siteId;

	private List<ModuleCoursesDTO> modules;

	private LRNResponse lrnResponse;

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the siteId
	 */
	public Long getSiteId() {
		return siteId;
	}

	/**
	 * @param siteId
	 *            the siteId to set
	 */
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	/**
	 * @return the curriculums
	 */
	public List<ModuleCoursesDTO> getModules() {
		return modules;
	}

	/**
	 * @param curriculums
	 *            the curriculums to set
	 */
	public void setModules(List<ModuleCoursesDTO> modules) {
		this.modules = modules;
	}

	public void setLrnResponse(LRNResponse lrnResponse) {
		// TODO Auto-generated method stub
		this.lrnResponse = lrnResponse;
	}

	/**
	 * @return the lrnResponse
	 */
	public LRNResponse getLrnResponse() {
		return lrnResponse;
	}

}
