package com.lrn.model.course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.lrn.dto.course.CourseBulletinDTO;
import com.lrn.model.hibernate.AbstractBaseEntity;
import com.lrn.util.BeanUtils;

@Entity
@SequenceGenerator(
		name 			= "GEN_SEQ",
		sequenceName 	= "SQ_COURSE_BULLETIN"
)
@Table(name="COURSE_BULLETIN")
public class CourseBulletin extends AbstractBaseEntity {

	@Column(name = "SECTION")
	private String section;
	
	@Column(name = "SYSTEM_ID")
	private String systemId;
	
	@Column(name = "LESSON")
	private Long lesson;
	
	@Column(name = "PAGE")
	private Long page;
	
	@Column(name = "MANDATORY")
	private Long mandatory;
	
	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "TEXT")
	private String text;
	
	@Column(name = "URL")
	private String url;
	
	@Column(name = "URL_NAME")
	private String urlName;

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public Long getLesson() {
		return lesson;
	}

	public void setLesson(Long lesson) {
		this.lesson = lesson;
	}

	public Long getPage() {
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getMandatory() {
		return mandatory;
	}

	public void setMandatory(Long mandatory) {
		this.mandatory = mandatory;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrlName() {
		return urlName;
	}

	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}
	
	public CourseBulletinDTO convertModelToDTO() {
		CourseBulletinDTO dto = new CourseBulletinDTO();         
		BeanUtils.copyProperties(this,dto);
		return dto;
	}
}
