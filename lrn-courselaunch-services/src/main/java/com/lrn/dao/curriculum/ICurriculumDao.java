package com.lrn.dao.curriculum;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.lrn.dao.IGenericDao;
import com.lrn.dto.CurriculumCourseDTO;
import com.lrn.dto.CurriculumDTO;
import com.lrn.dto.CurriculumModuleChainDTO;
import com.lrn.dto.ModuleChainMembersDTO;
import com.lrn.dto.PendingReviewsDTO;
import com.lrn.dto.UserCurriculumDTO;
import com.lrn.dto.course.CourseLookupDTO;
import com.lrn.model.hibernate.curriculum.Curriculum;
/**
 * @author sreenivas.k
 *
 */
public interface ICurriculumDao extends IGenericDao<Curriculum, Long> {
	Map<BigDecimal, CurriculumDTO> getAssignedCurricula(Long siteId,
			Long userId, String date);

	Map<BigDecimal, UserCurriculumDTO> getUserCurricula(Long siteId,
			Long userId, String date);

	Map<BigDecimal, Map<BigDecimal, CurriculumCourseDTO>> getCurriculumCourses(
			String created, String curriculumIds);

	Map<BigDecimal, Map<String, CourseLookupDTO>> getCourseLookup(Long siteId,
			String moduleIds);

	List<PendingReviewsDTO> getPendngReviews(Long siteId, String company,
			String userId, String status);

	List<CurriculumModuleChainDTO> getCurriculumModuleChain(Long siteId,
			String created, String curriculumIds);

	Map<BigDecimal, Map<BigDecimal, ModuleChainMembersDTO>> getModuleChainMembers(
			String moduleChainIds);

	Curriculum getCurriculumByCurriculumIdAndUserId(Long curriculumId,
			String userId);

	List<Curriculum> getCurriculumBySiteIdAndUserId(Long siteId, String userId);

}
