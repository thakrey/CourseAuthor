package com.lrn.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.lrn.dao.ICompletionCertificateDao;
import com.lrn.model.hibernate.CompletionCertificate;

/**
 * The Class CompletionCertificateDao.
 *
 * @author kishor.pawar
 */
public class CompletionCertificateDao extends GenericDao<CompletionCertificate, Long> implements
		ICompletionCertificateDao {

	public CompletionCertificateDao(Class<CompletionCertificate> persistentClass) {
		super(persistentClass);
	}

	@Override
	public List<CompletionCertificate> getCompletionCertificatesByUserByCompany(String userId, String company) {
		String[] paramNames = { "userId", "company" };
		Object[] paramValues = { userId, company };
		return findByNamedQuery("findCompletionByUserIdAndCompany", paramNames, paramValues);
	}
	
	@Override
	public List<CompletionCertificate> getCompletionForOpenCampaigns(
			String userId, String company, List<Long> moduleIds, List<Long> curriculumIds, Long siteId) {
		StringBuilder queryBuilder = new StringBuilder();
		// get curriculumId string with comma separated
		String curIds = getCommaSeparatedList(curriculumIds);
		String modIds = getCommaSeparatedList(moduleIds);
		
		queryBuilder.append("select cc.certificate_id as cc_certificate_id, cc.user_id as cc_user_id, cc.company as cc_company, catalog_id as cc_catalog_id, completion_date as cc_completion_date, cc.status as cc_status, cc.start_date as cc_start_date,cc.module_id as cc_module_id, cur_details.curriculum_id as cc_curriculum_id from completion_certificate cc inner join (");
		queryBuilder.append("select c.id as curriculum_id, cu.module_id, nvl(c.exemption_date,nvl(c.open_date, to_date('00010101','YYYYMMDD'))) as open_date, c.site_id, nvl(c.close_date, to_date('99990101','YYYYMMDD')) as close_date, s.name as company from curriculum c ");
		queryBuilder.append("inner join  curriculum_course cu on  cu.curriculum_id = c.id inner join site s on s.id = c.site_id where  c.site_id = ").append(siteId);
		queryBuilder.append(" and c.id in (").append(curIds); 
		queryBuilder.append(" ) union  ");
		queryBuilder.append("select cmc.curriculum_id, mcm.module_id,  nvl(c.exemption_date,nvl(c.open_date, to_date('00010101','YYYYMMDD'))) as open_date ,cmc.site_id, nvl(c.close_date, to_date('99990101','YYYYMMDD')) as close_date, s.name as company from curriculum c ");
		queryBuilder.append("  inner join curriculum_module_chain cmc on c.id = cmc.curriculum_id and c.site_id = cmc.site_id   inner join module_chain_members mcm on cmc.module_chain_id = mcm.module_chain_id ");
		queryBuilder.append("  inner join site s on s.id = c.site_id where  c.site_id = ").append(siteId);
		queryBuilder.append(" and c.id in (").append(curIds).append(")"); 
		queryBuilder.append(" ) cur_details on cur_details.module_id = cc.module_id and cc.company = cur_details.company ");
		queryBuilder.append(" where cc.company = '").append(company).append("'");
		queryBuilder.append(" and cc.user_id = '").append(userId).append("' and cc.status is not null");
		queryBuilder.append(" and cur_details.open_date <= cc.completion_date and cur_details.close_date >= cc.completion_date ");
		if(moduleIds != null && moduleIds.size() > 0)
			queryBuilder.append(" and cc.module_id in (").append(modIds).append(")");
		

		Iterator<Map<String, Object>> itr = findBySqlQuery(queryBuilder.toString());
		
		List<CompletionCertificate> list = new ArrayList<CompletionCertificate>();
		while (itr.hasNext()) {
			Map<String, Object> resultMap = itr.next();
			CompletionCertificate cc = constructCompleteCertificateFromMap(resultMap);
			list.add(cc);
		}
		return list;
	}
	
	/**
	 * Constructs CompletionCertificate.
	 *
	 * @param Map <String, Object> resultMap
	 * 
	 * @return CompletionCertificate
	 */
	private CompletionCertificate constructCompleteCertificateFromMap(Map <String, Object> resultMap) {
		CompletionCertificate cc = new CompletionCertificate ();
		cc.setCertificateId(((BigDecimal) resultMap.get("cc_certificate_id")).longValue());
		cc.setUserId((String)resultMap.get("cc_user_id"));
		cc.setModuleId(((BigDecimal) resultMap.get("cc_module_id")).longValue());
		cc.setCatalogId((String) resultMap.get("cc_catalog_id"));
		cc.setCompletionDate((Date) resultMap.get("cc_completion_date"));
		cc.setStartDate((Date) resultMap.get("cc_start_date"));
		cc.setCompany((String) resultMap.get("cc_company"));
		cc.setStatus((String) resultMap.get("cc_status"));
		BigDecimal bg = (BigDecimal) resultMap.get("cc_curriculum_id");
		if(bg != null)
			cc.setCurriculumId(bg.longValue());
		
		return cc;
	}
	
	/**
	 * Return comma separated string from list of ids.
	 *
	 * @param List<Long> ids
	 * 
	 * @return String
	 */
	private String getCommaSeparatedList(List<Long> ids) {
		StringBuilder commaSepList = new StringBuilder();
		boolean flag = false;
		if (ids != null) {
			for (Long id:ids) {
				if (flag) 
					commaSepList.append(",");
				flag = true;
				commaSepList.append(id);
			}
		}
		return commaSepList.toString();
	}
}