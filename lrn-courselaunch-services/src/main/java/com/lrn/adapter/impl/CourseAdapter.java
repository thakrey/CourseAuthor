package com.lrn.adapter.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.lrn.adapter.ICourseAdapter;
import com.lrn.manager.IAiccCourseStateManager;
import com.lrn.manager.ICourseEventsManager;
import com.lrn.manager.ISessionsManager;
import com.lrn.model.hibernate.AiccCourseState;
import com.lrn.model.hibernate.CourseEvents;
import com.lrn.model.hibernate.Sessions;
import com.lrn.model.spring.service.response.course.AiccCourseStateDTO;
import com.lrn.model.spring.service.response.course.CourseEventsActionDTO;
import com.lrn.model.spring.service.response.course.MobileAiccCourseStateDTO;
import com.lrn.model.spring.service.response.course.MobileCourseEventDTO;
import com.lrn.model.spring.service.response.course.MobileSyncDTO;
import com.lrn.model.spring.service.response.course.SessionInfoDTO;
import com.lrn.model.spring.service.response.course.UserCourseEventsDTO;
import com.lrn.util.StringUtil;

/**
 * The Class ExportAdapter.
 * 
 * @author yuvraj.thakre
 */
public class CourseAdapter implements ICourseAdapter {

	private static final Logger logger = Logger.getLogger(CourseAdapter.class);

	private ISessionsManager 		sessionsManager;
	
	private ICourseEventsManager 	courseEventsManager;
	
	private IAiccCourseStateManager aiccCourseStateManager;
	
	/**
	 * @param sessionsManager the sessionsManager to set
	 */
	public void setSessionsManager(ISessionsManager sessionsManager) {
		this.sessionsManager = sessionsManager;
	}

	/**
	 * @param courseEventsManager the courseEventsManager to set
	 */
	public void setCourseEventsManager(ICourseEventsManager courseEventsManager) {
		this.courseEventsManager = courseEventsManager;
	}

	/**
	 * @param aiccCourseStateManager the aiccCourseStateManager to set
	 */
	public void setAiccCourseStateManager(
			IAiccCourseStateManager aiccCourseStateManager) {
		this.aiccCourseStateManager = aiccCourseStateManager;
	}

	@Override
	public MobileSyncDTO getMobileSyncGetParam(String userId, String company, Long course) 
			throws ParseException {
		MobileSyncDTO mobileSyncDTO = new MobileSyncDTO();
		mobileSyncDTO.setCompany(company);
		mobileSyncDTO.setUserId(userId);
		mobileSyncDTO.setCourse(course);
		
		//Gets AICC Course State Detail
		mobileSyncDTO.setMobileAiccCourseStateDTO(getMobileAiccCourseStateDTO(userId, company, course));
		
		//Gets Course Events detail
		mobileSyncDTO.setMobileCourseEventDTOList(getMobileCourseEventDTOList(userId, company, course));
		
		//get the AiccSession
		mobileSyncDTO.setSessionInfo(getSessionInfoDTO(userId, company));
		return mobileSyncDTO;
	}

	@Override
	public MobileSyncDTO saveMobileSyncPutParam(MobileSyncDTO mobileSyncDTO) throws ParseException {
		String userId = mobileSyncDTO.getUserId();
		String company = mobileSyncDTO.getCompany();
		Long course = mobileSyncDTO.getCourse();
				
		//first check to see if the AiccSession exist if not then save the session
		Sessions session = sessionsManager.getAiccSessionByUserCompany(userId, company);
		if(session == null) {
			session = sessionsManager.save(SessionInfoDTO.getModelFromDTO(mobileSyncDTO.getSessionInfo()));	
		}
		mobileSyncDTO.setSessionInfo(getSessionInfoDTO(session));
		
		//save the couseEvent List
		List<MobileCourseEventDTO> savedMobileCourseEventDTOs = new ArrayList<MobileCourseEventDTO>();
		List<MobileCourseEventDTO> mobileCourseEventDTOs = mobileSyncDTO.getMobileCourseEventDTOList();
		if(mobileCourseEventDTOs != null && mobileCourseEventDTOs.size() > 0) {
			for (MobileCourseEventDTO mobileCourseEventDTO : mobileCourseEventDTOs) {
				CourseEvents courseEvents = getCourseEvents(userId, company, course, mobileCourseEventDTO); 
				courseEvents = courseEventsManager.save(courseEvents);
				mobileCourseEventDTO.setCourseEventId(courseEvents.getCourseEventId());
				savedMobileCourseEventDTOs.add(mobileCourseEventDTO);
			}
		}
		mobileSyncDTO.setMobileCourseEventDTOList(savedMobileCourseEventDTOs);
		
		//save the AiccCourseState
		MobileAiccCourseStateDTO mobileAiccCourseStateDTO = mobileSyncDTO.getMobileAiccCourseStateDTO();
		if(mobileAiccCourseStateDTO != null) {
			AiccCourseState aiccCourseState = getAiccCourseState(userId, company, course, 
					mobileAiccCourseStateDTO);
			aiccCourseState = aiccCourseStateManager.save(aiccCourseState);
			mobileAiccCourseStateDTO.setAiccEventsId(aiccCourseState.getAiccEventsId());
			mobileSyncDTO.setMobileAiccCourseStateDTO(mobileAiccCourseStateDTO);
		}
		return mobileSyncDTO;
	}
	
	/**
	 * Gets AiccCourseState. 
	 * 
	 * @param String userId
	 * @param String company
	 * @param Long course
	 * @param MobileAiccCourseStateDTO mobileAiccCourseStateDTO
	 * 
	 * @return AiccCourseState
	 * @throws ParseException 
	 */
	private AiccCourseState getAiccCourseState(String userId, String company, Long course, 
			MobileAiccCourseStateDTO mobileAiccCourseStateDTO) throws ParseException {
		AiccCourseState aiccCourseState = new AiccCourseState();
		aiccCourseState.setUserId(userId);
		aiccCourseState.setCompany(company);
		aiccCourseState.setCourse(course);
		aiccCourseState.setLastModified(new Date());
		aiccCourseState.setLessonLocation(mobileAiccCourseStateDTO.getLessonLocation());
		aiccCourseState.setCoreLesson(mobileAiccCourseStateDTO.getCoreLesson());
		Long aiccEventsId = mobileAiccCourseStateDTO.getAiccEventsId();
		if(aiccEventsId == null || aiccEventsId.equals(-1L)) {
			aiccEventsId = aiccCourseStateManager.getMaxAiccEventsId() + 1;
			logger.debug("Max Event Id +1 is " + aiccEventsId);
			aiccCourseState.setCreation(new Date());
		}
		aiccCourseState.setAiccEventsId(aiccEventsId);		
		return aiccCourseState;
	}

	/**
	 * Gets CourseEvents. 
	 * 
	 * @param String userId
	 * @param String company
	 * @param Long course
	 * @param MobileCourseEventDTO mobileCourseEventDTO
	 * 
	 * @return CourseEvents
	 * @throws ParseException 
	 */
	private CourseEvents getCourseEvents(String userId, String company,
			Long course, MobileCourseEventDTO mobileCourseEventDTO) throws ParseException {
		CourseEvents courseEvents = new CourseEvents();
		courseEvents.setUserId(userId);
		courseEvents.setCompany(company);
		courseEvents.setCourse(course);
		courseEvents.setAction(mobileCourseEventDTO.getAction());
		if(mobileCourseEventDTO.getCreationDate() != null) {
			courseEvents.setCreation(StringUtil.getDateFromStringInStandardDateFormat(
					mobileCourseEventDTO.getCreationDate()));
		}
		courseEvents.setCourseEventId(mobileCourseEventDTO.getCourseEventId());
		courseEvents.setNodeId(mobileCourseEventDTO.getNodeId());
		courseEvents.setPosition(mobileCourseEventDTO.getPosition());
		courseEvents.setValue(mobileCourseEventDTO.getValue());
		return courseEvents;
	}

	/**
	 * Gets SessionInfoDTO. 
	 * 
	 * @param String userId
	 * @param String company
	 * 
	 * @return SessionInfoDTO
	 * @throws ParseException 
	 */
	private SessionInfoDTO getSessionInfoDTO(String userId, String company) 
			throws ParseException {
		SessionInfoDTO sessionInfoDTO = null;
		Sessions session = sessionsManager.getAiccSessionByUserCompany(userId, company);
		if(session != null) {
			sessionInfoDTO = getSessionInfoDTO(session);
		}
		return sessionInfoDTO;
	}
	
	/**
	 * Gets SessionInfoDTO. 
	 * 
	 * @param Sessions session
	 * 
	 * @return SessionInfoDTO
	 * @throws ParseException 
	 */
	private SessionInfoDTO getSessionInfoDTO(Sessions session) throws ParseException {
		SessionInfoDTO sessionInfoDTO = new SessionInfoDTO();
		sessionInfoDTO.setId(session.getId());
		sessionInfoDTO.setaSession(session.getaSession());
		sessionInfoDTO.setCompany(session.getCompany());
		if(session.getDeletion() != null) {
			sessionInfoDTO.setDeletion(StringUtil.getStringFromDateInStandardDateFormat(
					session.getDeletion())); 
		}
		sessionInfoDTO.setSearchkey(session.getSearchkey());
		sessionInfoDTO.setUserId(session.getUserId());
		return sessionInfoDTO;
	}
	
	/**
	 * Gets User Course Events detail. 
	 * 
	 * @param String userId
	 * @param String company
	 * @param Long course
	 * 
	 * @return List<MobileCourseEventDTO>
	 */
	private List<MobileCourseEventDTO> getMobileCourseEventDTOList(String userId, 
			String company, Long course) {
		List<MobileCourseEventDTO> mobleCourseEventDTOList = new ArrayList<MobileCourseEventDTO>();
		UserCourseEventsDTO userCourseEvents = 
				courseEventsManager.getUserCourseEvents(userId, company, course);
		if(userCourseEvents != null) {
			List<CourseEventsActionDTO> courseEventActionDtos = userCourseEvents.getCourseEventsActionDTO();
			if(courseEventActionDtos != null && courseEventActionDtos.size() > 0) {
				for(CourseEventsActionDTO courseEventsActionDTO : courseEventActionDtos) {
					mobleCourseEventDTOList.add(getMobileCourseEventDTO(courseEventsActionDTO));
				}
			}
		}
		return mobleCourseEventDTOList;
	}
	
	/**
	 * Constructs MobileCourseEventDTO. 
	 * 
	 * @param CourseEventsActionDTO courseEventsActionDTO
	 * 
	 * @return MobileCourseEventDTO
	 */
	private MobileCourseEventDTO getMobileCourseEventDTO(
			CourseEventsActionDTO courseEventsActionDTO) {
		MobileCourseEventDTO mobileCourseEventDTO = new MobileCourseEventDTO();
		mobileCourseEventDTO.setAction(courseEventsActionDTO.getAction());
		mobileCourseEventDTO.setCourseEventId(courseEventsActionDTO.getCourseEventId());
		mobileCourseEventDTO.setCreationDate(courseEventsActionDTO.getCreationDate());
		mobileCourseEventDTO.setNodeId(courseEventsActionDTO.getNodeId());
		mobileCourseEventDTO.setPosition(courseEventsActionDTO.getPosition());
		mobileCourseEventDTO.setValue(courseEventsActionDTO.getValue());
		return mobileCourseEventDTO;
	}
	
	/**
	 * Gets AICC Course State Detail by userId, company and course. 
	 * 
	 * @param String userId
	 * @param String company
	 * @param Long course
	 * 
	 * @return MobileAiccCourseStateDTO
	 */
	private MobileAiccCourseStateDTO getMobileAiccCourseStateDTO(String userId, String company, Long course) {
		MobileAiccCourseStateDTO mobileAiccCourseStateDTO = new MobileAiccCourseStateDTO();
		Long[] courseList = { course };
		List<AiccCourseState> aiccCourseStates = 
				aiccCourseStateManager.getAiccCourseStateByCompanyUserIdCourseList(company, userId, courseList);
		if(aiccCourseStates != null && aiccCourseStates.size() > 0) {
			AiccCourseState aiccCourseState = aiccCourseStates.get(0);
			mobileAiccCourseStateDTO = getMobileAiccCourseStateDTO(getDTOFromModel(aiccCourseState));
		}
		
		return mobileAiccCourseStateDTO;
	}
	
	/**
	 * Constructs AiccCourseStateDTO. 
	 * 
	 * @param AiccCourseState aiccCourseState
	 * 
	 * @return AiccCourseStateDTO
	 */
	public AiccCourseStateDTO getDTOFromModel(AiccCourseState aiccCourseState) {
		AiccCourseStateDTO aiccCourseStateDTO = new AiccCourseStateDTO();
		aiccCourseStateDTO.setAiccEventsId(aiccCourseState.getAiccEventsId());
		aiccCourseStateDTO.setCoreLesson(aiccCourseState.getCoreLesson());
		aiccCourseStateDTO.setCreationDate(aiccCourseState.getCreation());
		aiccCourseStateDTO.setLastModifiedDate(aiccCourseState.getLastModified());
		aiccCourseStateDTO.setLessonLocation(aiccCourseState.getLessonLocation());
		return aiccCourseStateDTO;
	}
	
	/**
	 * Constructs MobileAiccCourseStateDTO. 
	 * 
	 * @param AiccCourseStateDTO aiccCourseStateDTO
	 * 
	 * @return MobileAiccCourseStateDTO
	 */
	private MobileAiccCourseStateDTO getMobileAiccCourseStateDTO(
			AiccCourseStateDTO aiccCourseStateDTO) {
		MobileAiccCourseStateDTO mobileAiccCourseStateDTO = new MobileAiccCourseStateDTO();
		mobileAiccCourseStateDTO.setAiccEventsId(aiccCourseStateDTO.getAiccEventsId());
		mobileAiccCourseStateDTO.setCoreLesson(aiccCourseStateDTO.getCoreLesson());
		mobileAiccCourseStateDTO.setCreationDate(aiccCourseStateDTO.getCreationDate());
		mobileAiccCourseStateDTO.setLastModifiedDate(aiccCourseStateDTO.getLastModifiedDate());
		mobileAiccCourseStateDTO.setLessonLocation(aiccCourseStateDTO.getLessonLocation());
		return mobileAiccCourseStateDTO;
	}	
}