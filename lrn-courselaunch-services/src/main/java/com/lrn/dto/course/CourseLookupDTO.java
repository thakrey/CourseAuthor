/**
 * 
 */
package com.lrn.dto.course;

import java.io.Serializable;
import java.util.Date;

import com.lrn.model.hibernate.CourseLookup;

/**  
* CourseLookupDTO - data transfer object class for course lookup. 
* It stores the data for the course lookup. 
* 
*/ 
public class CourseLookupDTO implements Serializable {
	
	/** The system id. */
	private String systemId;

	/** The module id. */
	private Long moduleId;

	/** The catalog id. */
	private String catalogId;

	/** The course short name. */
	private String courseShortName;

	/** The title. */
	private String title;

	/** The description. */
	private String description;

	/** The language. */
	private String language;
	
	/** The node id. */
	private Long nodeId;
	
	/** The course. */
	private Long course;
	
	/** The app type. */
	private String appType;
	
	/** The course path. */
	private String coursePath;
	
	/** The course Image URL */
	private String courseImgURL;
	
	/** The version. */
	private String version;
	
	/** The core vendor. */
	private String coreVendor;
	
	/** The media. */
	private String media;
	
	/** The is library. */
	private Long isLibrary;
	
	/** The created. */
	private Date created;
	
	/** The templates. */
	private String templates;
	
	/** The documents. */
	private String documents;
	
	/** The record quiz. */
	private Long recordQuiz;
	
	/** The copyright year. */
	private Long copyrightYear;
	
	/** The vendor. */
	private String vendor;
	
	/** The edition id. */
	private Long editionId;
	
	/** The availability. */
	private Long availability;
	
	/** The updated. */
	private Date updated;
	
	/** The media type. */
	private String mediaType;
	
	/** The base catalog id. */
	private String baseCatalogId;
	
	/** available_in_catalog **/
	private Long availableInCatalog;

	private Long revisionNumber;
	
	/**
	 * Gets the system id.
	 *
	 * @return the systemId
	 */
	public String getSystemId() {
		return systemId;
	}

	/**
	 * Sets the system id.
	 *
	 * @param systemId the systemId to set
	 */
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	/**
	 * Gets the module id.
	 *
	 * @return the moduleId
	 */
	public Long getModuleId() {
		return moduleId;
	}

	/**
	 * Sets the module id.
	 *
	 * @param moduleId the moduleId to set
	 */
	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	/**
	 * Gets the catalog id.
	 *
	 * @return the catalogId
	 */
	public String getCatalogId() {
		return catalogId;
	}

	/**
	 * Sets the catalog id.
	 *
	 * @param catalogId the catalogId to set
	 */
	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

	/**
	 * Gets the course short name.
	 *
	 * @return the courseShortName
	 */
	public String getCourseShortName() {
		return courseShortName;
	}

	/**
	 * Sets the course short name.
	 *
	 * @param courseShortName the courseShortName to set
	 */
	public void setCourseShortName(String courseShortName) {
		this.courseShortName = courseShortName;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the language.
	 *
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Sets the language.
	 *
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * Gets the node id.
	 *
	 * @return the nodeId
	 */
	public Long getNodeId() {
		return nodeId;
	}

	/**
	 * Sets the node id.
	 *
	 * @param nodeId the nodeId to set
	 */
	public void setNodeId(Long nodeId) {
		this.nodeId = nodeId;
	}

	/**
	 * Gets the course.
	 *
	 * @return the course
	 */
	public Long getCourse() {
		return course;
	}

	/**
	 * Sets the course.
	 *
	 * @param course the course to set
	 */
	public void setCourse(Long course) {
		this.course = course;
	}

	/**
	 * Gets the app type.
	 *
	 * @return the appType
	 */
	public String getAppType() {
		return appType;
	}

	/**
	 * Sets the app type.
	 *
	 * @param appType the appType to set
	 */
	public void setAppType(String appType) {
		this.appType = appType;
	}

	/**
	 * Gets the course path.
	 *
	 * @return the coursePath
	 */
	public String getCoursePath() {
		return coursePath;
	}

	/**
	 * Sets the course path.
	 *
	 * @param coursePath the coursePath to set
	 */
	public void setCoursePath(String coursePath) {
		this.coursePath = coursePath;
	}

	/**
	 * Gets the version.
	 *
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * Sets the version.
	 *
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * Gets the core vendor.
	 *
	 * @return the coreVendor
	 */
	public String getCoreVendor() {
		return coreVendor;
	}

	/**
	 * Sets the core vendor.
	 *
	 * @param coreVendor the coreVendor to set
	 */
	public void setCoreVendor(String coreVendor) {
		this.coreVendor = coreVendor;
	}

	/**
	 * Gets the media.
	 *
	 * @return the media
	 */
	public String getMedia() {
		return media;
	}

	/**
	 * Sets the media.
	 *
	 * @param media the media to set
	 */
	public void setMedia(String media) {
		this.media = media;
	}

	/**
	 * Gets the checks if is library.
	 *
	 * @return the isLibrary
	 */
	public Long getIsLibrary() {
		return isLibrary;
	}

	/**
	 * Sets the checks if is library.
	 *
	 * @param isLibrary the isLibrary to set
	 */
	public void setIsLibrary(Long isLibrary) {
		this.isLibrary = isLibrary;
	}

	/**
	 * Gets the created.
	 *
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * Sets the created.
	 *
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * Gets the templates.
	 *
	 * @return the templates
	 */
	public String getTemplates() {
		return templates;
	}

	/**
	 * Sets the templates.
	 *
	 * @param templates the templates to set
	 */
	public void setTemplates(String templates) {
		this.templates = templates;
	}

	/**
	 * Gets the documents.
	 *
	 * @return the documents
	 */
	public String getDocuments() {
		return documents;
	}

	/**
	 * Sets the documents.
	 *
	 * @param documents the documents to set
	 */
	public void setDocuments(String documents) {
		this.documents = documents;
	}

	/**
	 * Gets the record quiz.
	 *
	 * @return the recordQuiz
	 */
	public Long getRecordQuiz() {
		return recordQuiz;
	}

	/**
	 * Sets the record quiz.
	 *
	 * @param recordQuiz the recordQuiz to set
	 */
	public void setRecordQuiz(Long recordQuiz) {
		this.recordQuiz = recordQuiz;
	}

	/**
	 * Gets the copyright year.
	 *
	 * @return the copyrightYear
	 */
	public Long getCopyrightYear() {
		return copyrightYear;
	}

	/**
	 * Sets the copyright year.
	 *
	 * @param copyrightYear the copyrightYear to set
	 */
	public void setCopyrightYear(Long copyrightYear) {
		this.copyrightYear = copyrightYear;
	}

	/**
	 * Gets the vendor.
	 *
	 * @return the vendor
	 */
	public String getVendor() {
		return vendor;
	}

	/**
	 * Sets the vendor.
	 *
	 * @param vendor the vendor to set
	 */
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	/**
	 * Gets the edition id.
	 *
	 * @return the editionId
	 */
	public Long getEditionId() {
		return editionId;
	}

	/**
	 * Sets the edition id.
	 *
	 * @param editionId the editionId to set
	 */
	public void setEditionId(Long editionId) {
		this.editionId = editionId;
	}

	/**
	 * Gets the availability.
	 *
	 * @return the availability
	 */
	public Long getAvailability() {
		return availability;
	}

	/**
	 * Sets the availability.
	 *
	 * @param availability the availability to set
	 */
	public void setAvailability(Long availability) {
		this.availability = availability;
	}

	/**
	 * Gets the updated.
	 *
	 * @return the updated
	 */
	public Date getUpdated() {
		return updated;
	}

	/**
	 * Sets the updated.
	 *
	 * @param updated the updated to set
	 */
	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	/**
	 * Gets the media type.
	 *
	 * @return the mediaType
	 */
	public String getMediaType() {
		return mediaType;
	}

	/**
	 * Sets the media type.
	 *
	 * @param mediaType the mediaType to set
	 */
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	/**
	 * Gets the base catalog id.
	 *
	 * @return the baseCatalogId
	 */
	public String getBaseCatalogId() {
		return baseCatalogId;
	}

	/**
	 * Sets the base catalog id.
	 *
	 * @param baseCatalogId the baseCatalogId to set
	 */
	public void setBaseCatalogId(String baseCatalogId) {
		this.baseCatalogId = baseCatalogId;
	}

	/**
	 * Gets the courseImageURL.
	 *
	 * @return the courseImageURL
	 */
	public String getCourseImgURL() {
		return courseImgURL;
	}

	
	/**
	 * Sets the courseImageURL
	 *
	 * @param courseImageURL the courseImageURL to set
	 */
	public void setCourseImgURL(String courseImgURL) {
		this.courseImgURL = courseImgURL;
	}

	
	public Long getAvailableInCatalog() {
		return availableInCatalog;
	}

	public void setAvailableInCatalog(Long availableInCatalog) {
		this.availableInCatalog = availableInCatalog;
	}

	public Long getRevisionNumber() {
		return revisionNumber;
	}

	public void setRevisionNumber(Long revisionNumber) {
		this.revisionNumber = revisionNumber;
	}

	/**
	 * Convert model CourseLookup {@link CourseLookup} to CourseLookupDTO. 
	 * CourseLookup is the representation of model for CourseLookup and 
	 * this method converts it to CourseLookup which is the 
	 * data object for the service to embed in {@link LRNResponse}
	 *
	 * @param courseLookup {@link CourseLookup} holds courseLookup model info 
	 * @return courseLookupDTO 
	 */
	public static final CourseLookupDTO convertModelToDTO(CourseLookup courseLookup) {
		CourseLookupDTO courseLookupDTO = new CourseLookupDTO();
		courseLookupDTO.setAppType(courseLookup.getAppType());
		courseLookupDTO.setAvailability(courseLookup.getAvailability());
		courseLookupDTO.setCatalogId(courseLookup.getCatalogId());
		courseLookupDTO.setCopyrightYear(courseLookup.getCopyrightYear());
		courseLookupDTO.setCoreVendor(courseLookup.getCoreVendor());
		courseLookupDTO.setCourse(courseLookup.getCourse());
		courseLookupDTO.setCoursePath(courseLookup.getCoursePath());
		courseLookupDTO.setCourseShortName(courseLookup.getCourseShortName());
		courseLookupDTO.setCreated(courseLookup.getCreated());
		courseLookupDTO.setDescription(courseLookup.getDescription());
		courseLookupDTO.setDocuments(courseLookupDTO.getDocuments());
		courseLookupDTO.setEditionId(courseLookup.getEditionId());
		courseLookupDTO.setIsLibrary(courseLookup.getIsLibrary());
		courseLookupDTO.setLanguage(courseLookup.getLanguage());
		courseLookupDTO.setMedia(courseLookup.getMedia());
		courseLookupDTO.setModuleId(courseLookup.getModule().getId());
		courseLookupDTO.setNodeId(courseLookup.getNodeId());
		courseLookupDTO.setRecordQuiz(courseLookup.getRecordQuiz());
		courseLookupDTO.setSystemId(courseLookup.getSystemId());
		courseLookupDTO.setTemplates(courseLookup.getTemplates());
		courseLookupDTO.setTitle(courseLookup.getTitle());
		courseLookupDTO.setUpdated(courseLookup.getUpdated());
		courseLookupDTO.setVendor(courseLookup.getVendor());
		courseLookupDTO.setVersion(courseLookup.getVersion());
		courseLookupDTO.setBaseCatalogId(courseLookup.getModule().getBaseCatalogId());
		courseLookupDTO.setCourseImgURL(courseLookup.getCourseImgUrl());
		return courseLookupDTO;
	}
}
