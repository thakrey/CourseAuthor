package com.lrn.model.course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.lrn.model.Module;

import java.io.Serializable;
import java.util.Date;

	@NamedQueries( {
		@NamedQuery(name = "findCourseLookupByCatalogId",
				query = "from CourseLookup cl where cl.catalogId = :catalogId"),
		@NamedQuery(name = "findCourseLookupByModuleIds",
				query = "from CourseLookup cl where cl.module.id IN (:moduleIds)")
	})

	@Entity
	@Table(name = "COURSE_LOOKUP")
	public class CourseLookup implements Serializable {
		
		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1238440441424453771L;

		/** The system id. */
		@Id
		@Column(name="SYSTEM_ID")
		private String systemId;
		
		/** The node id. */
		@Column(name="NODE_ID")
		private Long nodeId;
		
		/** The course. */
		@Column(name="COURSE")
		private Long course;
		
		/** The catalog id. */
		@Column(name="CATALOG_ID")
		private String catalogId;
		
		/** The course short name. */
		@Column(name="COURSE_SHORT_NAME")
		private String courseShortName;
		
		/** The title. */
		@Column(name="TITLE")
		private String title;
		
		/** The description. */
		@Column(name="DESCRIPTION")
		private String description;
		
		/** The app type. */
		@Column(name="APP_TYPE")
		private String appType;
		
		/** The course path. */
		@Column(name="COURSE_PATH")
		private String coursePath;
		
		/** The language. */
		@Column(name="LANGUAGE")
		private String language;
		
		/** The version. */
		@Column(name="VERSION")
		private String version;
		
		/** The core vendor. */
		@Column(name="CORE_VENDOR")
		private String coreVendor;
		
		/** The media. */
		@Column(name="MEDIA")
		private String media;
		
		/** The module. */
		@ManyToOne(targetEntity = Module.class, fetch = FetchType.EAGER)
		@JoinColumn(name="MODULE_ID", nullable=false)
		private Module module;
		
		/** The is library. */
		@Column(name="IS_LIBRARY")
		private Long isLibrary;
		
		/** The created. */
		@Temporal(TemporalType.TIMESTAMP)
		@Column(name = "CREATED")
		private Date created;
		
		/** The templates. */
		@Column(name="TEMPLATES")
		private String templates;
		
		/** The documents. */
		@Column(name="DOCUMENTS")
		private String documents;
		
		/** The record quiz. */
		@Column(name="RECORD_QUIZ")
		private Long recordQuiz;
		
		/** The copyright year. */
		@Column(name="COPYRIGHT_YEAR")
		private Long copyrightYear;
		
		/** The vendor. */
		@Column(name="VENDOR")
		private String vendor;
		
		/** The edition id. */
		@Column(name="EDITION_ID")
		private Long editionId;
		
		/** The availability. */
		@Column(name="AVAILABILITY")
		private Long availability;
		
		/** The updated. */
		@Temporal(TemporalType.TIMESTAMP)
		@Column(name = "UPDATED")
		private Date updated;
		
		@Column(name="COURSE_CATEGORY_ID")
		private Long courseCategoryId;
		
		@Column(name="CONTENT_SIZE")
		private Long contentSize;

		/** The vendor. */
		@Column(name="COURSE_IMG_URL")
		private String courseImgUrl;
		
		public String getCourseImgUrl() {
			return courseImgUrl;
		}

		public void setCourseImgUrl(String courseImgUrl) {
			this.courseImgUrl = courseImgUrl;
		}

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
		 * Gets the module.
		 *
		 * @return the module
		 */
		public Module getModule() {
			return module;
		}

		/**
		 * Sets the module.
		 *
		 * @param module the module to set
		 */
		public void setModule(Module module) {
			this.module = module;
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
		
		public Long getCourseCategoryId() {
			return courseCategoryId;
		}

		public void setCourseCategoryId(Long courseCategoryId) {
			this.courseCategoryId = courseCategoryId;
		}

		public Long getContentSize() {
			return contentSize;
		}

		public void setContentSize(Long contentSize) {
			this.contentSize = contentSize;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((appType == null) ? 0 : appType.hashCode());
			result = prime * result
					+ ((availability == null) ? 0 : availability.hashCode());
			result = prime * result
					+ ((catalogId == null) ? 0 : catalogId.hashCode());
			result = prime * result
					+ ((copyrightYear == null) ? 0 : copyrightYear.hashCode());
			result = prime * result
					+ ((coreVendor == null) ? 0 : coreVendor.hashCode());
			result = prime * result + ((course == null) ? 0 : course.hashCode());
			result = prime * result
					+ ((coursePath == null) ? 0 : coursePath.hashCode());
			result = prime * result
					+ ((courseShortName == null) ? 0 : courseShortName.hashCode());
			result = prime * result + ((created == null) ? 0 : created.hashCode());
			result = prime * result
					+ ((description == null) ? 0 : description.hashCode());
			result = prime * result
					+ ((documents == null) ? 0 : documents.hashCode());
			result = prime * result
					+ ((editionId == null) ? 0 : editionId.hashCode());
			result = prime * result
					+ ((isLibrary == null) ? 0 : isLibrary.hashCode());
			result = prime * result
					+ ((language == null) ? 0 : language.hashCode());
			result = prime * result + ((media == null) ? 0 : media.hashCode());
			result = prime * result + ((nodeId == null) ? 0 : nodeId.hashCode());
			result = prime * result
					+ ((recordQuiz == null) ? 0 : recordQuiz.hashCode());
			result = prime * result
					+ ((systemId == null) ? 0 : systemId.hashCode());
			result = prime * result
					+ ((templates == null) ? 0 : templates.hashCode());
			result = prime * result + ((title == null) ? 0 : title.hashCode());
			result = prime * result + ((updated == null) ? 0 : updated.hashCode());
			result = prime * result + ((vendor == null) ? 0 : vendor.hashCode());
			result = prime * result + ((version == null) ? 0 : version.hashCode());
			return result;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CourseLookup other = (CourseLookup) obj;
			if (appType == null) {
				if (other.appType != null)
					return false;
			} else if (!appType.equals(other.appType))
				return false;
			if (availability == null) {
				if (other.availability != null)
					return false;
			} else if (!availability.equals(other.availability))
				return false;
			if (catalogId == null) {
				if (other.catalogId != null)
					return false;
			} else if (!catalogId.equals(other.catalogId))
				return false;
			if (copyrightYear == null) {
				if (other.copyrightYear != null)
					return false;
			} else if (!copyrightYear.equals(other.copyrightYear))
				return false;
			if (coreVendor == null) {
				if (other.coreVendor != null)
					return false;
			} else if (!coreVendor.equals(other.coreVendor))
				return false;
			if (course == null) {
				if (other.course != null)
					return false;
			} else if (!course.equals(other.course))
				return false;
			if (coursePath == null) {
				if (other.coursePath != null)
					return false;
			} else if (!coursePath.equals(other.coursePath))
				return false;
			if (courseShortName == null) {
				if (other.courseShortName != null)
					return false;
			} else if (!courseShortName.equals(other.courseShortName))
				return false;
			if (created == null) {
				if (other.created != null)
					return false;
			} else if (!created.equals(other.created))
				return false;
			if (description == null) {
				if (other.description != null)
					return false;
			} else if (!description.equals(other.description))
				return false;
			if (documents == null) {
				if (other.documents != null)
					return false;
			} else if (!documents.equals(other.documents))
				return false;
			if (editionId == null) {
				if (other.editionId != null)
					return false;
			} else if (!editionId.equals(other.editionId))
				return false;
			if (isLibrary == null) {
				if (other.isLibrary != null)
					return false;
			} else if (!isLibrary.equals(other.isLibrary))
				return false;
			if (language == null) {
				if (other.language != null)
					return false;
			} else if (!language.equals(other.language))
				return false;
			if (media == null) {
				if (other.media != null)
					return false;
			} else if (!media.equals(other.media))
				return false;
			if (nodeId == null) {
				if (other.nodeId != null)
					return false;
			} else if (!nodeId.equals(other.nodeId))
				return false;
			if (recordQuiz == null) {
				if (other.recordQuiz != null)
					return false;
			} else if (!recordQuiz.equals(other.recordQuiz))
				return false;
			if (systemId == null) {
				if (other.systemId != null)
					return false;
			} else if (!systemId.equals(other.systemId))
				return false;
			if (templates == null) {
				if (other.templates != null)
					return false;
			} else if (!templates.equals(other.templates))
				return false;
			if (title == null) {
				if (other.title != null)
					return false;
			} else if (!title.equals(other.title))
				return false;
			if (updated == null) {
				if (other.updated != null)
					return false;
			} else if (!updated.equals(other.updated))
				return false;
			if (vendor == null) {
				if (other.vendor != null)
					return false;
			} else if (!vendor.equals(other.vendor))
				return false;
			if (version == null) {
				if (other.version != null)
					return false;
			} else if (!version.equals(other.version))
				return false;
			return true;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "CourseLookup [systemId=" + systemId + ", nodeId=" + nodeId
					+ ", course=" + course + ", catalogId=" + catalogId
					+ ", courseShortName=" + courseShortName + ", title=" + title
					+ ", description=" + description + ", appType=" + appType
					+ ", coursePath=" + coursePath + ", language=" + language
					+ ", version=" + version + ", coreVendor=" + coreVendor
					+ ", media=" + media 
					+ ", isLibrary=" + isLibrary + ", created=" + created
					+ ", templates=" + templates + ", documents=" + documents
					+ ", recordQuiz=" + recordQuiz + ", copyrightYear="
					+ copyrightYear + ", vendor=" + vendor + ", editionId="
					+ editionId + ", availability=" + availability + ", updated="
					+ updated + "]";
		}

}
