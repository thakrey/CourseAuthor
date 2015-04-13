package com.lrn.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lrn.dto.CustomPublishesDTO;

public class CustomPublishesDTORowMapper implements RowMapper {

	@Override
	public CustomPublishesDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CustomPublishesDTO dto = new CustomPublishesDTO();
			dto.setCompany(rs.getString("company"));
			dto.setCreationDate(rs.getString("creation"));
			dto.setDeactivationDate(rs.getString("deactivation"));
			dto.setDeactivationUserId(rs.getString("deactivation_user_id"));
			dto.setId(rs.getLong("id"));
			dto.setIsActive(rs.getLong("is_active"));
			dto.setName(rs.getString("name"));
			dto.setProfileValue(rs.getString("profile_value"));
			dto.setPublicationDate(rs.getString("publication"));
			dto.setPublicationUserId(rs.getString("publication_user_id"));
			dto.setPublishType(rs.getString("publish_type"));
			dto.setUpdationDate(rs.getString("updation"));
			dto.setUpdationUserId(rs.getString("updation_user_id"));
			
		return dto;
	}
}
