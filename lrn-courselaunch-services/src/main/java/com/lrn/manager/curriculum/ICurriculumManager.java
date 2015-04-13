package com.lrn.manager.curriculum;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.lrn.dao.curriculum.ICurriculumDao;
import com.lrn.dto.CurriculumCourseDTO;
import com.lrn.dto.CurriculumDTO;
import com.lrn.dto.CurriculumModuleChainDTO;
import com.lrn.dto.ModuleChainMembersDTO;
import com.lrn.dto.PendingReviewsDTO;
import com.lrn.dto.UserCurriculumDTO;
import com.lrn.dto.course.CourseLookupDTO;
import com.lrn.manager.IGenericManager;
import com.lrn.model.hibernate.curriculum.Curriculum;
import com.lrn.model.spring.curriculum.GetUserAssignedCoursesQueryDTO;

/**
 * The Interface ICurriculumManager
 * 
 * 
 */
public interface ICurriculumManager extends IGenericManager<Curriculum, Long> {
	
	public void setCurriculumDao(ICurriculumDao curriculumDao);

	Map<BigDecimal, CurriculumDTO> getAssignedCurricula(Long siteId,
			Long userId, String date);

	Map<BigDecimal, UserCurriculumDTO> getUserCurricula(Long siteId,
			Long userId, String date);

	Map<BigDecimal, Map<BigDecimal, CurriculumCourseDTO>> getCurriculumCourses(
			String created, String curriculumIds);

	Map<BigDecimal, Map<String, CourseLookupDTO>> getCourseLookup( Long siteId, 
			String moduleIds);

	List<PendingReviewsDTO> getPendngReviews(Long siteId, String company,
			String userId, String status);

	List<CurriculumModuleChainDTO> getCurriculumModuleChain(Long siteId, String created,
			String curriculumIds);

	Map<BigDecimal, Map<BigDecimal, ModuleChainMembersDTO>> getModuleChainMembers(
			String moduleChainIds);

	List<Curriculum> getCurriculumBySiteId(Long siteId, Date currDate);
	
	Curriculum getCurriculumByCurriculumIdAndUserId(Long curriculumId, String userId);
	
	List<Curriculum> getCurriculumBySiteIdAndUserId(Long siteId, String userId);

}