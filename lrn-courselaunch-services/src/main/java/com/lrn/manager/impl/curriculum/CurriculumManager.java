package com.lrn.manager.impl.curriculum;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.lrn.dao.IGenericDao;
import com.lrn.dao.curriculum.ICurriculumDao;
import com.lrn.dto.CurriculumCourseDTO;
import com.lrn.dto.CurriculumDTO;
import com.lrn.dto.CurriculumModuleChainDTO;
import com.lrn.dto.ModuleChainMembersDTO;
import com.lrn.dto.PendingReviewsDTO;
import com.lrn.dto.UserCurriculumDTO;
import com.lrn.dto.course.CourseLookupDTO;
import com.lrn.manager.curriculum.ICurriculumManager;
import com.lrn.manager.impl.GenericManager;
import com.lrn.model.hibernate.curriculum.Curriculum;
import com.lrn.model.spring.curriculum.GetUserAssignedCoursesQueryDTO;



/**
 * @author sreenivas.k
 * 
 */
public class CurriculumManager extends GenericManager<Curriculum, Long>
		implements ICurriculumManager {

	private ICurriculumDao curriculumDao;

	public CurriculumManager(IGenericDao<Curriculum, Long> iGenericDao) {
		super(iGenericDao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setCurriculumDao(ICurriculumDao curriculumDao) {
		this.curriculumDao = curriculumDao;
	}
	
	@Override
	public List<Curriculum> getCurriculumBySiteId(Long siteId, Date currDate) {
		String[] paramNames = { "siteId", "currDate" };
		Object[] paramValues = { siteId, currDate };
		return (List<Curriculum>) curriculumDao.findByNamedQuery(
				"getCurriculumsBySiteId", paramNames, paramValues);
	}
	
	@Override
	public Map<BigDecimal, CurriculumDTO> getAssignedCurricula (Long siteId, Long userId, String date) {
		return curriculumDao.getAssignedCurricula(siteId, userId, date);
	}
	
	@Override
	public Map<BigDecimal, UserCurriculumDTO> getUserCurricula (Long siteId, Long userId, String date) {
		return curriculumDao.getUserCurricula(siteId, userId, date);
	}

	@Override
	public Map<BigDecimal, Map<BigDecimal, CurriculumCourseDTO>> getCurriculumCourses (String created, String curriculumIds) {
		return curriculumDao.getCurriculumCourses(created, curriculumIds);
	}

	
	@Override
	public Map<BigDecimal, Map<String, CourseLookupDTO>> getCourseLookup (Long siteId, String moduleIds) {
		return curriculumDao.getCourseLookup(siteId, moduleIds);
	}


	@Override
	public List<PendingReviewsDTO> getPendngReviews(Long siteId, String company, String userId, String status) {
		return curriculumDao.getPendngReviews(siteId, company, userId, status);
	}


	@Override
	public List<CurriculumModuleChainDTO> getCurriculumModuleChain(Long siteId, String created, String curriculumIds) {
		return curriculumDao.getCurriculumModuleChain(siteId, created, curriculumIds);
	}


	@Override
	public Map<BigDecimal, Map<BigDecimal, ModuleChainMembersDTO>> getModuleChainMembers(
			String moduleChainIds) {
		return curriculumDao.getModuleChainMembers(moduleChainIds);
	}

	@Override
	public Curriculum getCurriculumByCurriculumIdAndUserId(Long curriculumId, String userId) {
		return curriculumDao.getCurriculumByCurriculumIdAndUserId(curriculumId, userId);
	}

	@Override
	public List<Curriculum> getCurriculumBySiteIdAndUserId(Long siteId, String userId) {
		return curriculumDao.getCurriculumBySiteIdAndUserId(siteId, userId);
	}

}
