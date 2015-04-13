package com.lrn.model.spring.service.response.module;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.lrn.model.hibernate.curriculum.CurriculumCourse;
import com.lrn.model.hibernate.curriculum.CurriculumModuleChain;
import com.lrn.model.hibernate.module.ModuleChainMembers;

/**
 *@author vmulla
 * 
 */

public class AssignedModulesDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1135354323199329700L;

	private String userId;

	private Long siteId;

	private List<CurriculumModulesDTO> curriculums = new ArrayList<CurriculumModulesDTO>();
	
	//just for java use only start ***********/
	List<CurriculumModuleChain> curriculumModuleChainList;
	List<ModuleChainMembers> moduleChainMembersList;
	List<CurriculumCourse> curriculumCourseList;

	//just for java use only end ************************/
	
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
	public List<CurriculumModulesDTO> getCurriculums() {
		return curriculums;
	}

	/**
	 * @param curriculums
	 *            the curriculums to set
	 */
	public void setCurriculums(List<CurriculumModulesDTO> curriculums) {
		this.curriculums = curriculums;
	}

	public List<CurriculumModuleChain> getCurriculumModuleChainList() {
		return curriculumModuleChainList;
	}

	public void setCurriculumModuleChainList(
			List<CurriculumModuleChain> curriculumModuleChainList) {
		this.curriculumModuleChainList = curriculumModuleChainList;
	}

	public List<ModuleChainMembers> getModuleChainMembersList() {
		return moduleChainMembersList;
	}

	public void setModuleChainMembersList(
			List<ModuleChainMembers> moduleChainMembersList) {
		this.moduleChainMembersList = moduleChainMembersList;
	}

	public List<CurriculumCourse> getCurriculumCourseList() {
		return curriculumCourseList;
	}

	public void setCurriculumCourseList(List<CurriculumCourse> curriculumCourseList) {
		this.curriculumCourseList = curriculumCourseList;
	}
}
