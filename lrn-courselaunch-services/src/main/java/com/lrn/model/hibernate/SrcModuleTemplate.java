/**
 * 
 */
package com.lrn.model.hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author 
 *
 */
@Entity
@SequenceGenerator(
		name		 = "GEN_SEQ",
		sequenceName = "SRC_MODULE_TEMPLATE_SEQ"
)
@Table(name = "SRC_MODULE_TEMPLATE")
public class SrcModuleTemplate extends AbstractBaseEntity {
	
	public static final int SRC_APP_ID_TEMPLATE = 8;
	/**
	 * 
	 */
	private static final long serialVersionUID = -510216523385218457L;

	@Id
	private Long id;
	
	@Column(name="NAME")
    private String name;
	
	@Column(name="SRC_COURSE_APP_ID")
    private Long srcCourseAppId;
	
	@Column(name="PRECEDENCE")
    private Long precedence;
	
	@Column(name="WINDOW_HEIGHT")
    private Long windowHeight;
	
	@Column(name="WINDOW_WIDTH")
    private Long windowWidth;

	@Column(name="STATUS_BAR")
    private int statusBar;
	
	@Column(name="CREATED")
    private Date created;
	
	@Column(name="MODIFIED")
    private Date modified;

	/**
	 * Instantiates a new object.
	 */
	public SrcModuleTemplate() { }
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the srcCourseAppId
	 */
	public Long getSrcCourseAppId() {
		return srcCourseAppId;
	}

	/**
	 * @param srcCourseAppId the srcCourseAppId to set
	 */
	public void setSrcCourseAppId(Long srcCourseAppId) {
		this.srcCourseAppId = srcCourseAppId;
	}

	/**
	 * @return the precedence
	 */
	public Long getPrecedence() {
		return precedence;
	}

	/**
	 * @param precedence the precedence to set
	 */
	public void setPrecedence(Long precedence) {
		this.precedence = precedence;
	}

	/**
	 * @return the windowHeight
	 */
	public Long getWindowHeight() {
		return windowHeight;
	}

	/**
	 * @param windowHeight the windowHeight to set
	 */
	public void setWindowHeight(Long windowHeight) {
		this.windowHeight = windowHeight;
	}

	/**
	 * @return the windowWidth
	 */
	public Long getWindowWidth() {
		return windowWidth;
	}

	/**
	 * @param windowWidth the windowWidth to set
	 */
	public void setWindowWidth(Long windowWidth) {
		this.windowWidth = windowWidth;
	}

	/**
	 * @return the statusBar
	 */
	public int getStatusBar() {
		return statusBar;
	}

	/**
	 * @param statusBar the statusBar to set
	 */
	public void setStatusBar(int statusBar) {
		this.statusBar = statusBar;
	}

	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * @return the modified
	 */
	public Date getModified() {
		return modified;
	}

	/**
	 * @param modified the modified to set
	 */
	public void setModified(Date modified) {
		this.modified = modified;
	}
	
	
}
