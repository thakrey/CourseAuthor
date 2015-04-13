package com.lrn.dao.rowmapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lrn.model.hibernate.curriculum.CurriculumCourse;

/**
 * The Class CurriculumCourseRowMapper.
 *
 * @author kishor.pawar
 */
public class CurriculumCourseRowMapper implements RowMapper {

	public CurriculumCourse mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CurriculumCourse cc = new CurriculumCourse();
		cc.setCreated(rs.getDate("created"));
		cc.setCurriculumId(((BigDecimal) rs.getBigDecimal("curriculum_id")).longValue());
		cc.setId(((BigDecimal) rs.getBigDecimal("id")).longValue());
		cc.setModified(rs.getDate("modified"));
		//cc.setModuleCompleted(false);
		cc.setModuleId(((BigDecimal) rs.getBigDecimal("module_id")).longValue());
		cc.setSrcCertReqId(((BigDecimal) rs.getBigDecimal("src_cert_req_id")).longValue());
		cc.setSystemId(rs.getString("system_id"));
		
		
		return cc;
	}
}

