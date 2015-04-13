package com.lrn.dao.impl.curriculum;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.lrn.dao.curriculum.ICurriculumDao;
import com.lrn.dao.impl.GenericDao;
import com.lrn.dto.CurriculumCourseDTO;
import com.lrn.dto.CurriculumDTO;
import com.lrn.dto.CurriculumModuleChainDTO;
import com.lrn.dto.ModuleChainMembersDTO;
import com.lrn.dto.PendingReviewsDTO;
import com.lrn.dto.UserCurriculumDTO;
import com.lrn.dto.course.CourseLookupDTO;
import com.lrn.model.hibernate.curriculum.Curriculum;
import com.lrn.model.spring.curriculum.GetUserAssignedCoursesQueryDTO;
import com.lrn.util.StringUtil;

import java.text.ParseException;

/**
 * The Class CurriculumDao.
 *
 * @author kishor.pawar
 */
public class CurriculumDao extends GenericDao<Curriculum, Long> implements
		ICurriculumDao {
	public CurriculumDao(Class<Curriculum> persistentClass) {
		super(persistentClass);
	}

	@Override
	public Map<BigDecimal, CurriculumDTO> getAssignedCurricula(Long siteId,
			Long userId, String date) {

		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder
				.append("SELECT id, name, site_id, is_default, created, open_date, enroll_close_date, ");
		queryBuilder
				.append(" close_date, exemption_date, drive_state, administrator_emails, "
						+ " is_rule_based_scheduled, modified, reviewer_due_date, num_days_before_due, "
						+ " num_days_before_review_due, description, due_date FROM CURRICULUM");
		queryBuilder.append(" WHERE  drive_state = 2 AND site_id = ?");
		queryBuilder
				.append(" AND (open_date IS NULL OR TRUNC(open_date) <= TO_DATE(?");
		queryBuilder
				.append(" , 'YYYYMMDD')) AND (close_date IS NULL OR TO_DATE(?");
		queryBuilder
				.append(" , 'YYYYMMDD') < TRUNC(close_date)) AND TRUNC(created) <= TO_DATE(?");
		queryBuilder
				.append(" , 'YYYYMMDD')  AND (id IN (SELECT curriculum_id FROM user_curriculum WHERE user_id = ?");
		queryBuilder.append(" AND TRUNC(created) <= TO_DATE(?");
		queryBuilder.append(", 'YYYYMMDD'))  OR (is_default = 't' AND ");
		queryBuilder.append(" (enroll_close_date IS NULL OR TO_DATE(?");
		queryBuilder.append(", 'YYYYMMDD') < TRUNC(enroll_close_date)))) ");
		logger.debug(queryBuilder.toString());

		ArrayList<Object> params = new ArrayList<Object>();
		params.add(siteId);
		params.add(date);
		params.add(date);
		params.add(date);
		params.add(userId);
		params.add(date);
		params.add(date);

		List<Map<String, Object>> resultSetMapList = queryForList(
				queryBuilder.toString(), params);
		Iterator<Map<String, Object>> itr = resultSetMapList.iterator();

		Map<BigDecimal, CurriculumDTO> curriculum = new HashMap<BigDecimal, CurriculumDTO>();

		while (itr.hasNext()) {
			Map<String, Object> resultMap = itr.next();
			CurriculumDTO curriculumDTO = constructCurriculumDTOFromMap(resultMap);
			curriculum.put((BigDecimal) resultMap.get("id"), curriculumDTO);
		}
		return curriculum;
	}

	private CurriculumDTO constructCurriculumDTOFromMap(
			Map<String, Object> resultMap) {
		CurriculumDTO curriculumDTO = new CurriculumDTO();
		curriculumDTO.setId((BigDecimal) resultMap.get("id"));
		curriculumDTO.setName((String) resultMap.get("name"));
		curriculumDTO.setSiteId((BigDecimal) resultMap.get("site_id"));
		curriculumDTO.setIsDefault((String) resultMap.get("is_default"));
		curriculumDTO.setCreated((Date) resultMap.get("created"));
		curriculumDTO.setOpenDate((Date) resultMap.get("open_date"));
		curriculumDTO.setEnrolCloseDate((Date) resultMap
				.get("enroll_close_date"));
		curriculumDTO.setCloseDate((Date) resultMap.get("close_date"));
		curriculumDTO.setDueDate((Date) resultMap.get("due_date"));
		curriculumDTO.setExemptionDate((Date) resultMap.get("exemption_date"));
		curriculumDTO.setDriveState((BigDecimal) resultMap.get("drive_state"));
		curriculumDTO.setDescription((String) resultMap.get("description"));
		curriculumDTO.setAdministratorEmails((String) resultMap
				.get("administrator_emails"));
		curriculumDTO.setIsRuleBasedScheduled((BigDecimal) resultMap
				.get("is_rule_based_scheduled"));
		curriculumDTO.setModified((Date) resultMap.get("modified"));
		curriculumDTO.setReviewerDueDate((Date) resultMap
				.get("reviewer_due_date"));
		curriculumDTO.setNumDaysBeforeDue((BigDecimal) resultMap
				.get("num_days_before_due"));
		curriculumDTO.setNumDaysBeforeReviewDue((BigDecimal) resultMap
				.get("num_days_before_review_due"));
		return curriculumDTO;
	}

	@Override
	public Map<BigDecimal, UserCurriculumDTO> getUserCurricula(Long siteId,
			Long userId, String date) {

		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder
				.append("SELECT user_id, curriculum_id, created, modified, bulk_id ");
		queryBuilder.append(" FROM USER_CURRICULUM");
		queryBuilder.append(" WHERE  user_id = ?");
		queryBuilder.append(" AND TRUNC(created) <= TO_DATE(?, 'YYYYMMDD') ");

		ArrayList<Object> params = new ArrayList<Object>();
		params.add(userId);
		params.add(date);

		List<Map<String, Object>> resultSetMapList = queryForList(
				queryBuilder.toString(), params);
		Iterator<Map<String, Object>> itr = resultSetMapList.iterator();

		Map<BigDecimal, UserCurriculumDTO> userCurriculum = new HashMap<BigDecimal, UserCurriculumDTO>();

		while (itr.hasNext()) {
			Map<String, Object> resultMap = itr.next();
			UserCurriculumDTO userCurriculumDTO = constructUserCurriculumDTOFromMap(resultMap);
			userCurriculum.put((BigDecimal) resultMap.get("curriculum_id"),
					userCurriculumDTO);
		}
		return userCurriculum;
	}

	private UserCurriculumDTO constructUserCurriculumDTOFromMap(
			Map<String, Object> resultMap) {
		UserCurriculumDTO userCurriculumDTO = new UserCurriculumDTO();
		userCurriculumDTO.setCurriculumId((BigDecimal) resultMap
				.get("curriculum_id"));
		userCurriculumDTO.setModified((Date) resultMap.get("modified"));
		userCurriculumDTO.setCreated((Date) resultMap.get("created"));
		userCurriculumDTO.setUserId((String) resultMap.get("user_id"));
		userCurriculumDTO.setBulkId((BigDecimal) resultMap.get("bulk_id"));
		return userCurriculumDTO;
	}

	@Override
	public Map<BigDecimal, Map<BigDecimal, CurriculumCourseDTO>> getCurriculumCourses(
			String created, String curriculumIds) {

		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder
				.append("Select id, curriculum_id, system_id, src_cert_req_id, modified, created, module_id");
		queryBuilder
				.append(" from curriculum_course where created-1 < TO_DATE(?");
		queryBuilder.append(", 'YYYYMMDDHH24MISS') AND curriculum_id IN (")
				.append(curriculumIds).append(")");

		ArrayList<Object> params = new ArrayList<Object>();
		params.add(created);

		List<Map<String, Object>> resultSetMapList = queryForList(
				queryBuilder.toString(), params);
		Iterator<Map<String, Object>> itr = resultSetMapList.iterator();

		Map<BigDecimal, Map<BigDecimal, CurriculumCourseDTO>> curriculumCourse = new HashMap<BigDecimal, Map<BigDecimal, CurriculumCourseDTO>>();
		while (itr.hasNext()) {
			Map<String, Object> resultMap = itr.next();
			Map<BigDecimal, CurriculumCourseDTO> curriculumCourseByModuleId = new HashMap<BigDecimal, CurriculumCourseDTO>();
			CurriculumCourseDTO curriculumCourseDTO = constructCurriculumCourseDTOFromMap(resultMap);
			curriculumCourseByModuleId.put(
					(BigDecimal) resultMap.get("module_id"),
					curriculumCourseDTO);
			if (curriculumCourse.containsKey(resultMap.get("curriculum_id"))) {
				curriculumCourse.get(resultMap.get("curriculum_id")).putAll(
						curriculumCourseByModuleId);
			} else {
				curriculumCourse.put(
						(BigDecimal) resultMap.get("curriculum_id"),
						curriculumCourseByModuleId);
			}
		}
		return curriculumCourse;
	}

	private CurriculumCourseDTO constructCurriculumCourseDTOFromMap(
			Map<String, Object> resultMap) {
		CurriculumCourseDTO curriculumCourseDTO = new CurriculumCourseDTO();
		curriculumCourseDTO.setId((BigDecimal) resultMap.get("id"));
		curriculumCourseDTO.setCurriculumId((BigDecimal) resultMap
				.get("curriculum_id"));
		curriculumCourseDTO.setSystemId((String) resultMap.get("system_id"));
		curriculumCourseDTO.setSrcCertReqId((BigDecimal) resultMap
				.get("src_cert_req_id"));
		curriculumCourseDTO.setModified((Date) resultMap.get("modified"));
		curriculumCourseDTO.setCreated((Date) resultMap.get("created"));
		curriculumCourseDTO
				.setModuleId((BigDecimal) resultMap.get("module_id"));
		return curriculumCourseDTO;
	}

	@Override
	public Map<BigDecimal, Map<String, CourseLookupDTO>> getCourseLookup(
			Long siteId, String moduleIds) {

		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder
				.append("select cl.system_id, cl.node_id, cl.course, cl.catalog_id, "
						+ "cl.course_short_name, cl.title, cl.description, cl.app_type, cl.course_path, "
						+ "cl.language, cl.version, cl.core_vendor, cl.media, cl.module_id, cl.is_library, "
						+ "cl.created, cl.templates, cl.documents, cl.record_quiz, cl.copyright_year, "
						+ "cl.vendor, cl.edition_id, cl.availability, cl.updated");
		queryBuilder
				.append(" FROM course_lookup cl, site_course sc where cl.system_id = sc.system_id and sc.site_id = ?");
		queryBuilder.append(" and cl.module_id IN (").append(moduleIds)
				.append(")");

		ArrayList<Object> params = new ArrayList<Object>();
		params.add(siteId);

		List<Map<String, Object>> resultSetMapList = queryForList(
				queryBuilder.toString(), params);
		Iterator<Map<String, Object>> itr = resultSetMapList.iterator();

		Map<BigDecimal, Map<String, CourseLookupDTO>> courseLookup = new HashMap<BigDecimal, Map<String, CourseLookupDTO>>();
		while (itr.hasNext()) {
			Map<String, CourseLookupDTO> courseLookupBySystemId = new HashMap<String, CourseLookupDTO>();
			Map<String, Object> resultMap = itr.next();
			CourseLookupDTO courseLookupDTO = constructCourseLookupDTOFromMap(resultMap);
			courseLookupBySystemId.put((String) resultMap.get("system_id"),
					courseLookupDTO);
			if (courseLookup.containsKey(resultMap.get("module_id"))) {
				courseLookup.get(resultMap.get("module_id")).putAll(
						courseLookupBySystemId);
			} else {
				courseLookup.put((BigDecimal) resultMap.get("module_id"),
						courseLookupBySystemId);
			}
		}

		return courseLookup;
	}

	private CourseLookupDTO constructCourseLookupDTOFromMap(
			Map<String, Object> resultMap) {
		return null;
	}

	@Override
	public List<PendingReviewsDTO> getPendngReviews(Long siteId,
			String company, String userId, String status) {

		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder
				.append("SELECT m.base_catalog_id as base_catalog_id, u.login_name as login_name, u.firstname as firstname, u.middlename as middlename, ");
		queryBuilder
				.append("u.lastname as lastname, DECODE(ja.src_jasper_status_id, '4', 'Sent Back For Revision','1', 'Completed','3', 'Completed','2', 'Pending Review','5', 'Completed')  AS status, ");
		queryBuilder
				.append("TO_CHAR(review_due_date, 'YYYYMMDDHH24MISS') as review_due_date, ");
		queryBuilder
				.append("ja.id as jasper_attempt_id, m.id as module_id, ja.src_jasper_status_id as src_jasper_status_id, ");
		queryBuilder.append("u.email as email, ja.system_id as system_id");
		queryBuilder
				.append(" FROM users u, jasper_attempt ja, course_lookup cl, module m ");
		queryBuilder.append("WHERE ja.site_id=?");
		queryBuilder
				.append(" AND ja.user_id = u.user_id AND ja.system_id=cl.system_id");
		queryBuilder.append(" AND cl.module_id = m.id AND u.company = ?");
		queryBuilder.append(" AND ja.src_jasper_status_id IN (").append(status)
				.append(")");

		String assignmentRulesSQL = getAssignentRulesSQL(userId, siteId);
		if (!assignmentRulesSQL.isEmpty()) {
			queryBuilder.append(" AND ").append(assignmentRulesSQL);
		} else {
			return null;
		}

		queryBuilder.append(" ORDER BY m.base_catalog_id  ASC");

		ArrayList<Object> params = new ArrayList<Object>();
		params.add(siteId);
		params.add(company);

		List<Map<String, Object>> resultSetMapList = queryForList(
				queryBuilder.toString(), params);
		Iterator<Map<String, Object>> itr = resultSetMapList.iterator();

		List<PendingReviewsDTO> pendingReviewsDTOList = new ArrayList<PendingReviewsDTO>();
		while (itr.hasNext()) {
			PendingReviewsDTO pendingReviewsDTO = new PendingReviewsDTO();
			Map<String, Object> resultMap = itr.next();
			pendingReviewsDTO = constructPendingReviewsDTOFromMap(resultMap);
			pendingReviewsDTOList.add(pendingReviewsDTO);
		}
		return pendingReviewsDTOList;
	}

	private PendingReviewsDTO constructPendingReviewsDTOFromMap(
			Map<String, Object> resultMap) {
		PendingReviewsDTO pendingReviewsDTO = new PendingReviewsDTO();
		pendingReviewsDTO.setBaseCatalogId((String) resultMap
				.get("base_catalog_id"));
		pendingReviewsDTO.setLoginName((String) resultMap.get("login_name"));
		pendingReviewsDTO.setFirstname((String) resultMap.get("firstname"));
		pendingReviewsDTO.setMiddlename((String) resultMap.get("middlename"));
		pendingReviewsDTO.setLastname((String) resultMap.get("lastname"));
		pendingReviewsDTO.setStatus((String) resultMap.get("status"));
		String reviewDateStr = (String) resultMap.get("review_due_date");
		if (reviewDateStr != null) {
			try {
				Date reviewDate = StringUtil
						.getDateFromStringInStandardDateFormat(reviewDateStr);
				pendingReviewsDTO.setReviewDueDate(reviewDate);
			} catch (ParseException pe) {
			}
		}
		pendingReviewsDTO.setJasperAttemptId((BigDecimal) resultMap
				.get("jasper_attempt_id"));
		pendingReviewsDTO.setModuleId((BigDecimal) resultMap.get("module_id"));
		pendingReviewsDTO.setSrcJasperStatusId((BigDecimal) resultMap
				.get("src_jasper_status_id"));
		pendingReviewsDTO.setEmail((String) resultMap.get("email"));
		pendingReviewsDTO.setSystemId((String) resultMap.get("system_id"));
		return pendingReviewsDTO;
	}

	@Override
	public List<CurriculumModuleChainDTO> getCurriculumModuleChain(Long siteId,
			String created, String curriculumIds) {

		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder
				.append("SELECT id, curriculum_id, site_id, module_chain_id, src_req_id, created, updated");
		queryBuilder
				.append(" from curriculum_module_chain where TRUNC(created) <= TO_DATE(?");
		queryBuilder.append(", 'YYYYMMDD') AND curriculum_id IN (")
				.append(curriculumIds).append(")");
		queryBuilder.append(" AND site_id = ").append(siteId);

		ArrayList<Object> params = new ArrayList<Object>();
		params.add(created);

		List<Map<String, Object>> resultSetMapList = queryForList(
				queryBuilder.toString(), params);
		Iterator<Map<String, Object>> itr = resultSetMapList.iterator();

		List<CurriculumModuleChainDTO> curriculumModuleChainDTOList = new ArrayList<CurriculumModuleChainDTO>();
		while (itr.hasNext()) {
			Map<String, Object> resultMap = itr.next();
			CurriculumModuleChainDTO curriculumModuleChainDTO = consructCurriculumModuleChainDTOFromResultMap(resultMap);
			curriculumModuleChainDTOList.add(curriculumModuleChainDTO);
		}
		return curriculumModuleChainDTOList;
	}

	private CurriculumModuleChainDTO consructCurriculumModuleChainDTOFromResultMap(
			Map<String, Object> resultMap) {
		CurriculumModuleChainDTO curriculumModuleChainDTO = new CurriculumModuleChainDTO();
		curriculumModuleChainDTO.setId((BigDecimal) resultMap.get("id"));
		curriculumModuleChainDTO.setCurriculumId((BigDecimal) resultMap
				.get("curriculum_id"));
		curriculumModuleChainDTO.setModuleChainId((BigDecimal) resultMap
				.get("module_chain_id"));
		curriculumModuleChainDTO.setSiteId((BigDecimal) resultMap
				.get("site_id"));
		curriculumModuleChainDTO.setSrcReqId((BigDecimal) resultMap
				.get("src_req_id"));
		curriculumModuleChainDTO.setCreated((Date) resultMap.get("created"));
		curriculumModuleChainDTO.setUpdated((Date) resultMap.get("updated"));
		return curriculumModuleChainDTO;
	}

	@Override
	public Map<BigDecimal, Map<BigDecimal, ModuleChainMembersDTO>> getModuleChainMembers(
			String moduleChainIds) {

		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder
				.append("SELECT id, module_chain_id, module_id, site_id, sequence, created ");
		queryBuilder
				.append("FROM module_chain_members WHERE module_chain_id IN (")
				.append(moduleChainIds).append(")");
		Iterator<Map<String, Object>> itr = findBySqlQuery(queryBuilder
				.toString());
		Map<BigDecimal, Map<BigDecimal, ModuleChainMembersDTO>> moduleChainMembersDTOMap = new HashMap<BigDecimal, Map<BigDecimal, ModuleChainMembersDTO>>();
		while (itr.hasNext()) {
			Map<BigDecimal, ModuleChainMembersDTO> moduleChainMembersDTOMapByModuleId = new HashMap<BigDecimal, ModuleChainMembersDTO>();
			Map<String, Object> resultMap = itr.next();
			ModuleChainMembersDTO moduleChainMembersDTO = constructModuleChainMembersDTOFromMap(resultMap);
			moduleChainMembersDTOMapByModuleId.put(
					moduleChainMembersDTO.getModuleId(), moduleChainMembersDTO);
			if (moduleChainMembersDTOMap.containsKey(resultMap
					.get("module_chain_id"))) {
				moduleChainMembersDTOMap.get(resultMap.get("module_chain_id"))
						.putAll(moduleChainMembersDTOMapByModuleId);
			} else {
				moduleChainMembersDTOMap.put(
						(BigDecimal) resultMap.get("module_chain_id"),
						moduleChainMembersDTOMapByModuleId);
			}
		}
		return moduleChainMembersDTOMap;
	}

	private ModuleChainMembersDTO constructModuleChainMembersDTOFromMap(
			Map<String, Object> resultMap) {
		ModuleChainMembersDTO moduleChainMembersDTO = new ModuleChainMembersDTO();
		moduleChainMembersDTO.setId((BigDecimal) resultMap.get("id"));
		moduleChainMembersDTO.setModuleChainId((BigDecimal) resultMap
				.get("module_chain_id"));
		moduleChainMembersDTO.setModuleId((BigDecimal) resultMap
				.get("module_id"));
		moduleChainMembersDTO.setSequence((BigDecimal) resultMap
				.get("sequence"));
		moduleChainMembersDTO.setSiteId((BigDecimal) resultMap.get("site_id"));
		moduleChainMembersDTO.setCreated((Date) resultMap.get("created"));
		return moduleChainMembersDTO;
	}

	private Map<BigDecimal, Map<String, String>> getAssignmentRules(
			String userId, Long siteId) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder
				.append("SELECT a.module_id as module_id, a.custom_field_name as custom_field_name, l.custom_field_value as custom_field_value ");
		queryBuilder
				.append(" FROM jasper_reviewer_assignment a, jasper_reviewer_lookup l ");
		queryBuilder.append(" WHERE l.jasper_reviewer_assignment_id = a.id ");
		queryBuilder.append(" AND a.site_id=?");
		queryBuilder.append(" AND l.reviewers_user_id=?");

		ArrayList<Object> params = new ArrayList<Object>();
		params.add(siteId);
		params.add(userId);

		List<Map<String, Object>> resultSetMapList = queryForList(
				queryBuilder.toString(), params);
		Iterator<Map<String, Object>> itr = resultSetMapList.iterator();

		Map<BigDecimal, Map<String, String>> assinmentRulesMapByModuleId = new HashMap<BigDecimal, Map<String, String>>();
		while (itr.hasNext()) {
			Map<String, Object> resultMap = itr.next();
			Map<String, String> assinmentRulesMap = new HashMap<String, String>();
			assinmentRulesMap.put((String) resultMap.get("custom_field_name"),
					(String) resultMap.get("custom_field_value"));
			if (assinmentRulesMapByModuleId.containsKey(resultMap
					.get("module_id"))) {
				assinmentRulesMapByModuleId.get(resultMap.get("module_id"))
						.putAll(assinmentRulesMap);
			} else {
				assinmentRulesMapByModuleId.put(
						(BigDecimal) resultMap.get("module_id"),
						assinmentRulesMap);
			}
		}

		return assinmentRulesMapByModuleId;
	}

	private String getAssignentRulesSQL(String userId, Long siteId) {
		Map<BigDecimal, Map<String, String>> assignmentRulesMapByModuleId = getAssignmentRules(
				userId, siteId);
		String sql = "";
		List<String> queryByColList = new ArrayList<String>();
		for (BigDecimal moduleId : assignmentRulesMapByModuleId.keySet()) {
			String query = "";
			List<String> queryStringList = new ArrayList<String>();
			Map<String, String> assignmentRulesMap = assignmentRulesMapByModuleId
					.get(moduleId);
			for (String customFieldName : assignmentRulesMap.keySet()) {
				StringBuilder queryBuilder = new StringBuilder();
				queryBuilder.append(" (cl.module_id = ").append(moduleId);
				queryBuilder.append(" AND ja.user_id != '").append(userId)
						.append("' ");
				queryBuilder.append(" AND UPPER(u.").append(customFieldName)
						.append(") ");
				queryBuilder.append(" IN (SELECT UPPER(l.custom_field_value) ");
				queryBuilder
						.append(" FROM jasper_reviewer_assignment a, jasper_reviewer_lookup l ");
				queryBuilder
						.append(" WHERE l.jasper_reviewer_assignment_id = a.id ");
				queryBuilder.append(" AND a.module_id=").append(moduleId);
				queryBuilder.append(" AND l.reviewers_user_id = '")
						.append(userId).append("')) ");
				queryStringList.add(queryBuilder.toString());
			}

			for (String queryString : queryStringList) {
				query += (query.isEmpty()) ? " ( " : " AND ";
				query += queryString;
			}
			query += (query.isEmpty()) ? "" : " ) ";
			queryByColList.add(query);
		}

		for (String queryByCol : queryByColList) {
			sql += (sql.isEmpty()) ? " ( " : " OR ";
			sql += queryByCol;
		}
		sql += (sql.isEmpty()) ? "" : " ) ";

		return sql;
	}

	@Override
	public Curriculum getCurriculumByCurriculumIdAndUserId(Long curriculumId,
			String userId) {

		Curriculum c = new Curriculum();
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder
				.append("SELECT id, name, site_id, is_default, created, open_date, enroll_close_date, close_date,");
		queryBuilder
				.append(" case when (select created from user_curriculum where user_id =?")
				.append(" and rownum=1)");
		queryBuilder
				.append(" is not null then (select created from user_curriculum where user_id =?")
				.append(" and rownum=1)");
		queryBuilder.append(" else due_date end \"due_date\", ");
		queryBuilder
				.append(" exemption_date, drive_state, description, administrator_emails, is_rule_based_scheduled, modified, ");
		queryBuilder
				.append(" reviewer_due_date, num_days_before_due, num_days_before_review_due ");
		queryBuilder.append(" from curriculum where id=?");

		ArrayList<Object> params = new ArrayList<Object>();
		params.add(userId);
		params.add(userId);
		params.add(curriculumId);

		List<Map<String, Object>> resultSetMapList = queryForList(
				queryBuilder.toString(), params);
		Iterator<Map<String, Object>> itr = resultSetMapList.iterator();

		while (itr.hasNext()) {
			Map<String, Object> resultMap = itr.next();
			c = constructCurriculumFromCurriculumMap(resultMap);
		}
		return c;
	}

	private Curriculum constructCurriculumFromCurriculumMap(
			Map<String, Object> resultMap) {
		Curriculum c = new Curriculum();
		BigDecimal id = (BigDecimal) resultMap.get("id");
		c.setId(id.longValue());
		c.setName((String) resultMap.get("name"));
		BigDecimal siteId = (BigDecimal) resultMap.get("site_id");
		c.setSiteId(siteId != null ? siteId.longValue() : null);
		c.setIsDefault((String) resultMap.get("is_default"));
		c.setCreated((Date) resultMap.get("created"));
		c.setOpenDate((Date) resultMap.get("open_date"));
		c.setEnrollCloseDate((Date) resultMap.get("enroll_close_date"));
		c.setCloseDate((Date) resultMap.get("close_date"));
		c.setDueDate((Date) resultMap.get("due_date"));
		c.setExemptionDate((Date) resultMap.get("exemption_date"));
		BigDecimal driveState = (BigDecimal) resultMap.get("drive_state");
		c.setDriveState(driveState != null ? driveState.longValue() : null);
		c.setDescription((String) resultMap.get("description"));
		c.setAdministratorEmails((String) resultMap.get("administrator_emails"));
		BigDecimal isRuleBasedScheduled = (BigDecimal) resultMap
				.get("is_rule_based_scheduled");
		c.setIsRuleBasedScheduled(isRuleBasedScheduled != null ? isRuleBasedScheduled
				.longValue() : null);
		c.setModified((Date) resultMap.get("modified"));
		c.setReviewerDueDate((Date) resultMap.get("reviewer_due_date"));
		BigDecimal numDaysBeforeDue = (BigDecimal) resultMap
				.get("num_days_before_due");
		c.setNumDaysBeforeDue(numDaysBeforeDue != null ? numDaysBeforeDue
				.intValue() : null);
		BigDecimal numDaysBeforeReviewDue = (BigDecimal) resultMap
				.get("num_days_before_review_due");
		c.setNumDaysBeforeReviewDue(numDaysBeforeReviewDue != null ? numDaysBeforeReviewDue
				.longValue() : null);
		return c;
	}

	@Override
	public List<Curriculum> getCurriculumBySiteIdAndUserId(Long siteId,
			String userId) {

		List<Curriculum> list = new ArrayList<Curriculum>();
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder
				.append("SELECT id, name, site_id, is_default, created, open_date, enroll_close_date, close_date,");
		queryBuilder
				.append(" case when (select created from user_curriculum where user_id =?")
				.append(" and rownum=1)");
		queryBuilder
				.append(" is not null then (select created from user_curriculum where user_id =?")
				.append(" and rownum=1)");
		queryBuilder.append(" else due_date end \"due_date\", ");
		queryBuilder
				.append(" exemption_date, drive_state, description, administrator_emails, is_rule_based_scheduled, modified, ");
		queryBuilder
				.append(" reviewer_due_date, num_days_before_due, num_days_before_review_due ");
		queryBuilder.append(" from curriculum where site_id = ?");
		queryBuilder
				.append(" and drive_state = 2 and open_date < sysdate and (close_date > sysdate or close_date is null)");
		// queryBuilder.append(" and ((is_default = 't' and enroll_close_date is null) or id in (select curriculum_id from user_curriculum where user_id = '").append(userId).append("'))");
		queryBuilder.append(" and is_default = 't'");

		ArrayList<Object> params = new ArrayList<Object>();
		params.add(userId);
		params.add(userId);
		params.add(siteId);

		List<Map<String, Object>> resultSetMapList = queryForList(
				queryBuilder.toString(), params);
		Iterator<Map<String, Object>> itr = resultSetMapList.iterator();

		while (itr.hasNext()) {
			Map<String, Object> resultMap = itr.next();
			Curriculum c = constructCurriculumFromCurriculumMap(resultMap);
			list.add(c);
		}
		return list;
	}
}