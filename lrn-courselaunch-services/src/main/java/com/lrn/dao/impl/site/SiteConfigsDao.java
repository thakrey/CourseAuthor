package com.lrn.dao.impl.site;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.math.BigDecimal;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.lrn.dao.impl.GenericDao;
import com.lrn.dao.rowmapper.CustomPublishesDTORowMapper;
import com.lrn.dao.site.ISiteConfigsDao;
import com.lrn.dto.CustomPublishInfoDTO;
import com.lrn.dto.CustomPublishProfileDTO;
import com.lrn.dto.CustomPublishProfileDTOList;
import com.lrn.dto.CustomPublishesDTO;
import com.lrn.dto.CustomPublishesDTOList;
import com.lrn.dto.CustomSectionsDTO;
import com.lrn.dto.CustomSectionsDTOList;
import com.lrn.dto.SiteConfigsDTO;
import com.lrn.model.hibernate.site.SiteConfigs;
import com.lrn.model.hibernate.site.SiteConfigsPK;
import com.lrn.util.StringUtil;

/**
 * The Class SiteConfigsDao.
 *
 * @author kishor.pawar
 */
public class SiteConfigsDao extends GenericDao<SiteConfigs, SiteConfigsPK> implements ISiteConfigsDao {

	public SiteConfigsDao(Class<SiteConfigs> persistentClass) {
		super(persistentClass);
	}

	
	@Override
	public SiteConfigsDTO getLanguagesAvaiable(Long siteId) {
		
		SiteConfigsDTO dto = new SiteConfigsDTO();
		
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select key from custom_field_enum where column_name = 'Language' and site_id = ?");

		ArrayList<Object> params = new ArrayList<Object> ();
		params.add(siteId);

		List<Map<String, Object>> resultSetMapList = queryForList(queryBuilder.toString(), params);
		Iterator<Map<String, Object>> itr = resultSetMapList.iterator();
		
		StringBuffer buf = new StringBuffer();
		while (itr.hasNext()) {
			Map<String, Object> resultMap = itr.next();
			if(buf.length() == 0)
				buf.append((String) resultMap.get("key"));
			else
				buf.append(",").append((String) resultMap.get("key"));
		}
		
		dto = new SiteConfigsDTO("LanguagesAvailable", buf.toString());
		return dto;
	}

	@Override
	public List<String> getSloSiteCompanyNames() {
		List<String> companyNamesThatUseSlo = new ArrayList<String>();
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("SELECT company FROM site_configs WHERE config_name = 'SSOEnabled'  " +
				" AND config_value in  ('t', 'only') " );
		Iterator<Map<String, Object>> itr = findBySqlQuery(queryBuilder.toString());
		while (itr.hasNext()) {
			Map<String, Object> resultMap = itr.next();
			companyNamesThatUseSlo.add((String)resultMap.get("company"));
		}
		return companyNamesThatUseSlo;
	}  		
	
	@Override
	public List<String> getSloSiteCompanyNamesThatSupportAutomaticCreationOfUserIds() {
		List<String> sloSiteCompanyNamesThatSupportAutomaticCreationOfUserIds = new ArrayList<String>();
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("SELECT company FROM site_configs WHERE config_name = 'SSOUserCreation'  AND " +
				" config_value = 't' " );
		Iterator<Map<String, Object>> itr = findBySqlQuery(queryBuilder.toString());
		while (itr.hasNext()) {
			Map<String, Object> resultMap = itr.next();
			sloSiteCompanyNamesThatSupportAutomaticCreationOfUserIds.add((String)resultMap.get("company"));
		}
		return sloSiteCompanyNamesThatSupportAutomaticCreationOfUserIds;
	}


	@Override
	public String getSiteConfigValue(String configName, String company) {
		StringBuilder queryBuilder = new StringBuilder();

		queryBuilder.append("SELECT config_value as configValue");
		queryBuilder.append(" FROM site_configs WHERE");
		queryBuilder.append(" config_name = ?");
		queryBuilder.append(" AND company = ?");
		
		ArrayList<Object> params = new ArrayList<Object> ();
		params.add(configName);
		params.add(company);

		List<Map<String, Object>> resultSetMapList = queryForList(queryBuilder.toString(), params);
		Iterator<Map<String, Object>> itr = resultSetMapList.iterator();
		
		String configValue = null;
		while (itr.hasNext()) {
			Map<String, Object> resultMap = itr.next();
			configValue = (String) resultMap.get("configValue");
		}
		return configValue;
		
		
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public CustomPublishesDTOList getCustomPublishesForLocation(String company, List<String> locationList) {
		
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("SELECT  id, company, name, TO_CHAR(creation,'YYYYMMDDHH24MISS') creation,");
		queryBuilder.append(" TO_CHAR(updation,'YYYYMMDDHH24MISS') updation, updation_user_id,");
		queryBuilder.append(" TO_CHAR(publication,'YYYYMMDDHH24MISS') publication,");
		queryBuilder.append("publication_user_id, is_active, profile_value, publish_type, ");
		queryBuilder.append("TO_CHAR(deactivation,'YYYYMMDDHH24MISS') deactivation, deactivation_user_id ");
		queryBuilder.append("FROM custom_publishes WHERE company = '").append(company).append("'");
		
		if(locationList.size() > 0) {
			String locationListStr = StringUtil.getStringListAsAsString(locationList);

			queryBuilder.append(" and id in (select custom_publish_id  from custom_sections where location in ");
			queryBuilder.append("(").append(locationListStr).append("))");
		}
		queryBuilder.append(" and is_active=1 ");
		
		DataSource ds = SessionFactoryUtils.getDataSource(getSessionFactory());
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
		
		List<CustomPublishesDTO> dtoList = jdbcTemplate.query(queryBuilder.toString(), new CustomPublishesDTORowMapper());
		
		CustomPublishesDTOList dto = new CustomPublishesDTOList();
		dto.setCustomPublishesDTOList(dtoList);
		return dto;
	}
	
	@Override
	public CustomPublishProfileDTOList getCustomPublishProfileList(String company) {
		
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("SELECT id, profile_value, publish_type");
		queryBuilder.append(" FROM custom_publishes where is_active = 1 ");
		queryBuilder.append(" and company = ?");
		
		ArrayList<Object> params = new ArrayList<Object> ();
		params.add(company);

		List<Map<String, Object>> resultSetMapList = queryForList(queryBuilder.toString(), params);
		Iterator<Map<String, Object>> itr = resultSetMapList.iterator();
		
		CustomPublishProfileDTOList dto = new CustomPublishProfileDTOList();
		ArrayList<CustomPublishProfileDTO> dtoList = new ArrayList<CustomPublishProfileDTO>();

		while (itr.hasNext()) {
			Map<String, Object> resultMap = itr.next();

			CustomPublishProfileDTO cpp = new CustomPublishProfileDTO();
			cpp.setId(((BigDecimal) resultMap.get("id")).longValue());
			cpp.setPublishType((String) resultMap.get("publish_type"));
			cpp.setPublishType((String) resultMap.get("profile_value"));
			
			dtoList.add(cpp);
		}
		
		dto.setCustomPublishProfileDTOList(dtoList);
		return dto;
	}
	
	@Override
	public CustomPublishInfoDTO getCustomPublishInfo() {
		
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("SELECT TO_CHAR(publication, 'Mon dd, yyyy hh24:mi') as publishDate, count(*) as count");
		queryBuilder.append("  FROM custom_publishes WHERE publication = ( SELECT MAX(publication) ");
		queryBuilder.append(" FROM custom_publishes WHERE publication IS NOT NULL) ");
		queryBuilder.append(" GROUP BY TO_CHAR(publication, 'Mon dd, yyyy hh24:mi')");
		
		Iterator<Map<String, Object>> itr = findBySqlQuery(queryBuilder.toString());
		
		CustomPublishInfoDTO publishInfo = new CustomPublishInfoDTO();
		while (itr.hasNext()) {
			Map<String, Object> resultMap = itr.next();
			publishInfo.setCount(((BigDecimal) resultMap.get("count")).longValue());
			publishInfo.setPublicationDate((String) resultMap.get("publishDate"));
		}
		
		return publishInfo;
	}
	
	/* (non-Javadoc)
	 * @see com.lrn.dao.ISiteConfigsDao#getCustomSectionsInfo(java.lang.String, java.util.List)
	 */
	@Override
	public CustomSectionsDTOList getCustomSectionsInfo(String company, List<String> locationList) {
		
		String locationListStr = StringUtil.getStringListAsAsString(locationList);
		List<CustomSectionsDTO> list = new ArrayList<CustomSectionsDTO>();
		
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("SELECT cp.company as company, cs.type as type, cs.location as location, body_text,");
		queryBuilder.append(" Table_Type, Table_Bordercolor, Title_Text, Title_Textcolor, Title_Bgcolor, Title_Border,");
		queryBuilder.append(" Body_Textcolor, Body_Bgcolor, Body_Border, Image_Type, Image_Height, Image_Width,");
		queryBuilder.append(" image_position, image_align, image_valign, image_caption, image_filename, image_data");
		queryBuilder.append(" from custom_sections cs, custom_publishes cp");
		queryBuilder.append(" where cs.custom_publish_id = cp.id");
		queryBuilder.append(" and cp.is_active = 1");
		queryBuilder.append(" and Cp.Company = ?");
		queryBuilder.append(" and cs.location in  (").append(locationListStr).append(")");

		ArrayList<Object> params = new ArrayList<Object> ();
		params.add(company);
		
		List<Map<String, Object>> resultSetMapList = queryForList(queryBuilder.toString(), params);
		Iterator<Map<String, Object>> itr = resultSetMapList.iterator();
		
		while (itr.hasNext()) {
			Map<String, Object> resultMap = itr.next();
			CustomSectionsDTO dto = new CustomSectionsDTO();
				dto.setCompany(company);
				dto.setType((String) resultMap.get("type"));
				dto.setLocation((String) resultMap.get("location"));
				dto.setBodyText((String) resultMap.get("body_text"));
				
				dto.setTableType((String) resultMap.get("table_text"));
				dto.setTableBorderColor((String) resultMap.get("table_bordercolor"));
				
				dto.setTitleBgColor((String) resultMap.get("title_bgcolor"));
				BigDecimal bd = (BigDecimal) resultMap.get("title_border");
				if(bd != null)
					dto.setTitleBorder(bd.longValue());
				dto.setTitleText((String) resultMap.get("title_text"));
				dto.setTitleTextColor((String) resultMap.get("title_textcolor"));
				
				dto.setBodyBgColor((String) resultMap.get("body_bgcolor"));
				bd = (BigDecimal) resultMap.get("body_border");
				if(bd != null)
					dto.setBodyBorder(bd.longValue());
				dto.setBodyTextColor((String) resultMap.get("body_textcolor"));
				
				dto.setImageAlign((String) resultMap.get("image_align"));
				dto.setImageCaption((String) resultMap.get("image_caption"));
				Blob imgData = (Blob) resultMap.get("image_data");
				if(imgData != null) {
					try {
						dto.setImageData(imgData.getBytes(1L, Long.valueOf(imgData.length()).intValue()));
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				dto.setImageFilename((String) resultMap.get("image_filename"));
				bd = (BigDecimal) resultMap.get("image_height");
				if(bd != null)
					dto.setImageHeight(bd.longValue());
				bd = (BigDecimal) resultMap.get("image_width");
				if(bd != null)
					dto.setImageWidth(bd.longValue());
				dto.setImagePosition((String) resultMap.get("image_position"));
				dto.setImageType((String) resultMap.get("image_type"));
				dto.setImageValign((String) resultMap.get("image_valign"));
				
			list.add(dto); 
		}
		
		CustomSectionsDTOList customSectionsList = new CustomSectionsDTOList();
			customSectionsList.setCustomSectionsDTOList(list);
		return customSectionsList;
	}
}