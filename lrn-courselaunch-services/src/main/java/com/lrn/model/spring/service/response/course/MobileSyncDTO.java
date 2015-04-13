package com.lrn.model.spring.service.response.course;

import java.io.Serializable;
import java.util.List;

import com.lrn.model.spring.service.response.LRNResponse;

/**
 * The class MobileSyncDTO
 */
public class MobileSyncDTO implements Serializable {
	
	private static final long serialVersionUID = 3364120697481651228L;

	private String 			userId;
	
	private String 			company;
	
	private Long 			course;
	
	private SessionInfoDTO 	sessionInfo;

	private List<MobileCourseEventDTO> 	mobileCourseEventDTOList;
	
	private MobileAiccCourseStateDTO 	mobileAiccCourseStateDTO;

	private LRNResponse 	lrnResponse;

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
	 * @return the course
	 */
	public Long getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(Long course) {
		this.course = course;
	}

	/**
	 * @return the sessionInfo
	 */
	public SessionInfoDTO getSessionInfo() {
		return sessionInfo;
	}

	/**
	 * @param sessionInfo the sessionInfo to set
	 */
	public void setSessionInfo(SessionInfoDTO sessionInfo) {
		this.sessionInfo = sessionInfo;
	}

	/**
	 * @return the mobileCourseEventDTOList
	 */
	public List<MobileCourseEventDTO> getMobileCourseEventDTOList() {
		return mobileCourseEventDTOList;
	}

	/**
	 * @param mobileCourseEventDTOList the mobileCourseEventDTOList to set
	 */
	public void setMobileCourseEventDTOList(
			List<MobileCourseEventDTO> mobileCourseEventDTOList) {
		this.mobileCourseEventDTOList = mobileCourseEventDTOList;
	}

	/**
	 * @return the mobileAiccCourseStateDTO
	 */
	public MobileAiccCourseStateDTO getMobileAiccCourseStateDTO() {
		return mobileAiccCourseStateDTO;
	}

	/**
	 * @param mobileAiccCourseStateDTO the mobileAiccCourseStateDTO to set
	 */
	public void setMobileAiccCourseStateDTO(
			MobileAiccCourseStateDTO mobileAiccCourseStateDTO) {
		this.mobileAiccCourseStateDTO = mobileAiccCourseStateDTO;
	}

	/**
	 * @return the lrnResponse
	 */
	public LRNResponse getLrnResponse() {
		return lrnResponse;
	}

	/**
	 * @param lrnResponse the lrnResponse to set
	 */
	public void setLrnResponse(LRNResponse lrnResponse) {
		this.lrnResponse = lrnResponse;
	}
}