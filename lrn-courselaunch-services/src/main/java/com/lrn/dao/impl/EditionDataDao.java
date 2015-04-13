package com.lrn.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.lrn.dao.IEditionDataDao;
import com.lrn.model.hibernate.Edition;
import com.lrn.model.hibernate.EditionData;

/**
 * The Class EditionDataDao.
 *
 * @author kishor.pawar
 */
public class EditionDataDao extends GenericDao<EditionData, Long> implements IEditionDataDao {

	public EditionDataDao(Class<EditionData> persistentClass) {
		super(persistentClass);
	}

	@Override
	public List<EditionData> getEstimatedTimeByModuleIds(List<Long> moduleIds) {
		final StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select e.id as e_id, e.edition_code as e_edition_code, e.title_en as e_title_en, e.description_en as e_description_en,");
		queryBuilder.append(" e.module_id as e_module_id, e.type as e_type, e.topic as e_topic, e.secondary_topic as e_secondary_topic, e.created as e_created,");
		queryBuilder.append(" e.unit_weight as e_unit_weight, ed.id as ed_id, ed.edition_id as ed_edition_id, ed.name as ed_name, ");
		queryBuilder.append(" ed.value as ed_value, ed.created as ed_created");
		queryBuilder.append(" from edition e, edition_data ed where e.id = ed.edition_id and ed.name = 'estimated_time' ");
		String moduleIdsList = getInParamLong(moduleIds); 
		queryBuilder.append(" and e.module_id in (").append(moduleIdsList).append(")");

		Iterator<Map<String, Object>> itr = findBySqlQuery(queryBuilder.toString());
		List<EditionData> list = new ArrayList<EditionData>();
		while (itr.hasNext()) {
			Map<String, Object> resultMap = itr.next();
			EditionData ed = constructEditionFromMap(resultMap);
			list.add(ed);
		}
		return list;
	}
	
	/**
	 * 
	 * @param resultMap
	 * @return
	 */
	private EditionData constructEditionFromMap(Map<String, Object> resultMap) {	EditionData ed = new EditionData();
	ed.setId(((BigDecimal) resultMap.get("ed_id")).longValue());
	ed.setName((String) resultMap.get("ed_name"));
	ed.setValue((String) resultMap.get("ed_value"));
	ed.setCreated((Date) resultMap.get("ed_created"));
	
	Edition e = new Edition();
	e.setId(((BigDecimal) resultMap.get("e_id")).longValue());
	e.setEditionCode((String) resultMap.get("e_edition_code"));
	e.setTitleEn((String) resultMap.get("e_title_en"));
	e.setDescriptionEn((String) resultMap.get("e_description_en"));
	e.setModuleId(((BigDecimal) resultMap.get("e_module_id")).longValue());
	e.setType((String) resultMap.get("e_type"));
	e.setTopic((String) resultMap.get("e_topic"));
	e.setSecondaryTopic((String) resultMap.get("e_secondary_topic"));
	e.setCreated((Date) resultMap.get("e_created"));
	e.setUnitWeight(((BigDecimal) resultMap.get("e_unit_weight")).longValue());
	
	ed.setEdition(e);
	
	return ed;}

	/**
	 * Constructs comma separated string used at query from list
	 *
	 * @param List<Long> ids
	 * 
	 * @return String
	 */
	private String getInParamLong(List<Long> ids) {
		StringBuilder queryBuilder = new StringBuilder();
		int counter = 0;
		for(Long id : ids) {
			if(counter == 0) {
				queryBuilder.append(id);
			} else {
				queryBuilder.append(", ").append(id);
			}
			counter++;
		}
		return queryBuilder.toString();
	}
}
