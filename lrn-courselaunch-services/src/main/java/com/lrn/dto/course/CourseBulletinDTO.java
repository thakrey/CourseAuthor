/**
 * 
 */
package com.lrn.dto.course;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.lrn.model.course.CourseBulletin;
import com.lrn.util.BeanUtils;

public class CourseBulletinDTO implements Serializable{
	
	private static final long serialVersionUID = 1191152931932054160L;
	private Long courseBulletinId;
	private String section;
	private String systemId;
	private Long lesson;
	private Long page;
	private Long mandatory;
	private String type;
	private String text;
	private String url;
	private String urlName;
	private Long sectionImageId;
	
	public Long getCourseBulletinId() {
		return courseBulletinId;
	}

	public void setCourseBulletinId(Long courseBulletinId) {
		this.courseBulletinId = courseBulletinId;
	}

	public Long getSectionImageId() {
		return sectionImageId;
	}

	public void setSectionImageId(Long sectionImageId) {
		this.sectionImageId = sectionImageId;
	}

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
	
	public CourseBulletin convertDTOToModel() {
		CourseBulletin model = new CourseBulletin();
		BeanUtils.copyProperties(this, model);  
		return model;

	}
}
