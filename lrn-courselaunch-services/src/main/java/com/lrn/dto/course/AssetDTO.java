/**
 * 
 */
package com.lrn.dto.course;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.lrn.model.course.Asset;
import com.lrn.model.course.CourseBulletin;
import com.lrn.model.course.CourseFeedbackRec;
import com.lrn.util.BeanUtils;

/**
 * @author kishore.ohal
 *
 */
public class AssetDTO implements Serializable{
	
	private Long id;
	private Long siteId;
	private String fileName;
	private String urlFile;
	private String urlThumbnail;
	private String uri;
	private String uriThumnail;
	private long dataSize;
	private String mmeType;
	private String properties;
	private Long authProperties;
	private String uploadedBy;
	private Date created;

	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public Long getSiteId() {
		return siteId;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setUrlFile(String urlFile) {
		this.urlFile = urlFile;
	}

	public String getUrlFile() {
		return urlFile;
	}

	public void setUrlThumbnail(String urlThumbnail) {
		this.urlThumbnail = urlThumbnail;
	}

	public String getUrlThumbnail() {
		return urlThumbnail;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getUri() {
		return uri;
	}

	public void setUriThumnail(String uriThumnail) {
		this.uriThumnail = uriThumnail;
	}

	public String getUriThumnail() {
		return uriThumnail;
	}

	public void setDataSize(long dataSize) {
		this.dataSize = dataSize;
	}

	public long getDataSize() {
		return dataSize;
	}

	public void setMmeType(String mmeType) {
		this.mmeType = mmeType;
	}

	public String getMmeType() {
		return mmeType;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}

	public String getProperties() {
		return properties;
	}

	public void setAuthProperties(Long authProperties) {
		this.authProperties = authProperties;
	}

	public Long getAuthProperties() {
		return authProperties;
	}

	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	public String getUploadedBy() {
		return uploadedBy;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getCreated() {
		return created;
	}
	
	public Asset convertDTOToModel() {
		Asset model = new Asset();
		BeanUtils.copyProperties(this, model);  
		return model;

	}
}
