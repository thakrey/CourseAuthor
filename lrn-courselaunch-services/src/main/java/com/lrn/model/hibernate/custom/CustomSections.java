package com.lrn.model.hibernate.custom;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.lrn.model.hibernate.AbstractBaseEntity;

/**
 * The Class CustomSections
 * 
 * @author kishor.pawar
 */
@NamedQueries( {
	@NamedQuery(name = "getCustomSection",
			query = "from CustomSections cs where cs.customPublishes.company = :company " +
					"and cs.customPublishes.isActive = 1 and cs.location = :location " +
					"and cs.name = :name and cs.customPublishes.profileValue = :profileValue")
})
@Entity
@SequenceGenerator(name = "GEN_SEQ", sequenceName = "CUSTOM_SECTIONS_SEQ")
@Table(name = "CUSTOM_SECTIONS")
public class CustomSections extends AbstractBaseEntity {

	private static final long serialVersionUID = 6278430448845650474L;

	/** The custom publish id. */
	@ManyToOne(targetEntity = CustomPublishes.class, fetch = FetchType.EAGER)
	@JoinColumn(name="CUSTOM_PUBLISH_ID", nullable=false)
	private CustomPublishes customPublishes;

	@Column(name = "LOCATION")
	private String location;

	@Column(name = "NAME")
	private String name;

	@Column(name = "IS_HIDDEN")
	private Long isHidden;

	@Column(name = "TYPE")
	private String type;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATION")
	private Date updation;

	@Column(name = "UPDATION_USER_ID")
	private String updationUserId;

	@Column(name = "TABLE_TYPE")
	private String tableType;

	@Column(name = "TABLE_BORDERCOLOR")
	private String tableBordercolor;

	@Column(name = "TITLE_TEXT")
	private String titleText;

	@Column(name = "TITLE_TEXTCOLOR")
	private String titleTextcolor;

	@Column(name = "TITLE_BGCOLOR")
	private String titleBgcolor;

	@Column(name = "TITLE_BORDER")
	private Long titleBorder;

	@Column(name = "BODY_TEXTCOLOR")
	private String bodyTextcolor;

	@Column(name = "BODY_BGCOLOR")
	private String bodyBgcolor;

	@Column(name = "BODY_BORDER")
	private Long bodyBorder;

	@Column(name = "IMAGE_TYPE")
	private String imageType;

	@Column(name = "IMAGE_HEIGHT")
	private Long imageHeight;

	@Column(name = "IMAGE_WIDTH")
	private Long imageWidth;

	@Column(name = "IMAGE_POSITION")
	private String imagePosition;

	@Column(name = "IMAGE_ALIGN")
	private String imageAlign;

	@Column(name = "IMAGE_VALIGN")
	private String imageValign;

	@Column(name = "IMAGE_CAPTION")
	private String imageCaption;

	@Column(name = "IMAGE_FILENAME")
	private String imageFilename;
	
	@Column(name = "IMAGE_DATA")
	@Lob
	private String imageData;
	
	@Column(name = "BODY_TEXT")
	@Lob
	private String bodyText;

	/**
	 * @return the customPublishes
	 */
	public CustomPublishes getCustomPublishes() {
		return customPublishes;
	}

	/**
	 * @param customPublishes the customPublishes to set
	 */
	public void setCustomPublishes(CustomPublishes customPublishes) {
		this.customPublishes = customPublishes;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
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
	 * @return the isHidden
	 */
	public Long getIsHidden() {
		return isHidden;
	}

	/**
	 * @param isHidden the isHidden to set
	 */
	public void setIsHidden(Long isHidden) {
		this.isHidden = isHidden;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the updation
	 */
	public Date getUpdation() {
		return updation;
	}

	/**
	 * @param updation the updation to set
	 */
	public void setUpdation(Date updation) {
		this.updation = updation;
	}

	/**
	 * @return the updationUserId
	 */
	public String getUpdationUserId() {
		return updationUserId;
	}

	/**
	 * @param updationUserId the updationUserId to set
	 */
	public void setUpdationUserId(String updationUserId) {
		this.updationUserId = updationUserId;
	}

	/**
	 * @return the tableType
	 */
	public String getTableType() {
		return tableType;
	}

	/**
	 * @param tableType the tableType to set
	 */
	public void setTableType(String tableType) {
		this.tableType = tableType;
	}

	/**
	 * @return the tableBordercolor
	 */
	public String getTableBordercolor() {
		return tableBordercolor;
	}

	/**
	 * @param tableBordercolor the tableBordercolor to set
	 */
	public void setTableBordercolor(String tableBordercolor) {
		this.tableBordercolor = tableBordercolor;
	}

	/**
	 * @return the titleText
	 */
	public String getTitleText() {
		return titleText;
	}

	/**
	 * @param titleText the titleText to set
	 */
	public void setTitleText(String titleText) {
		this.titleText = titleText;
	}

	/**
	 * @return the titleTextcolor
	 */
	public String getTitleTextcolor() {
		return titleTextcolor;
	}

	/**
	 * @param titleTextcolor the titleTextcolor to set
	 */
	public void setTitleTextcolor(String titleTextcolor) {
		this.titleTextcolor = titleTextcolor;
	}

	/**
	 * @return the titleBgcolor
	 */
	public String getTitleBgcolor() {
		return titleBgcolor;
	}

	/**
	 * @param titleBgcolor the titleBgcolor to set
	 */
	public void setTitleBgcolor(String titleBgcolor) {
		this.titleBgcolor = titleBgcolor;
	}

	/**
	 * @return the titleBorder
	 */
	public Long getTitleBorder() {
		return titleBorder;
	}

	/**
	 * @param titleBorder the titleBorder to set
	 */
	public void setTitleBorder(Long titleBorder) {
		this.titleBorder = titleBorder;
	}

	/**
	 * @return the bodyTextcolor
	 */
	public String getBodyTextcolor() {
		return bodyTextcolor;
	}

	/**
	 * @param bodyTextcolor the bodyTextcolor to set
	 */
	public void setBodyTextcolor(String bodyTextcolor) {
		this.bodyTextcolor = bodyTextcolor;
	}

	/**
	 * @return the bodyBgcolor
	 */
	public String getBodyBgcolor() {
		return bodyBgcolor;
	}

	/**
	 * @param bodyBgcolor the bodyBgcolor to set
	 */
	public void setBodyBgcolor(String bodyBgcolor) {
		this.bodyBgcolor = bodyBgcolor;
	}

	/**
	 * @return the bodyBorder
	 */
	public Long getBodyBorder() {
		return bodyBorder;
	}

	/**
	 * @param bodyBorder the bodyBorder to set
	 */
	public void setBodyBorder(Long bodyBorder) {
		this.bodyBorder = bodyBorder;
	}

	/**
	 * @return the imageType
	 */
	public String getImageType() {
		return imageType;
	}

	/**
	 * @param imageType the imageType to set
	 */
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	/**
	 * @return the imageHeight
	 */
	public Long getImageHeight() {
		return imageHeight;
	}

	/**
	 * @param imageHeight the imageHeight to set
	 */
	public void setImageHeight(Long imageHeight) {
		this.imageHeight = imageHeight;
	}

	/**
	 * @return the imageWidth
	 */
	public Long getImageWidth() {
		return imageWidth;
	}

	/**
	 * @param imageWidth the imageWidth to set
	 */
	public void setImageWidth(Long imageWidth) {
		this.imageWidth = imageWidth;
	}

	/**
	 * @return the imagePosition
	 */
	public String getImagePosition() {
		return imagePosition;
	}

	/**
	 * @param imagePosition the imagePosition to set
	 */
	public void setImagePosition(String imagePosition) {
		this.imagePosition = imagePosition;
	}

	/**
	 * @return the imageAlign
	 */
	public String getImageAlign() {
		return imageAlign;
	}

	/**
	 * @param imageAlign the imageAlign to set
	 */
	public void setImageAlign(String imageAlign) {
		this.imageAlign = imageAlign;
	}

	/**
	 * @return the imageValign
	 */
	public String getImageValign() {
		return imageValign;
	}

	/**
	 * @param imageValign the imageValign to set
	 */
	public void setImageValign(String imageValign) {
		this.imageValign = imageValign;
	}

	/**
	 * @return the imageCaption
	 */
	public String getImageCaption() {
		return imageCaption;
	}

	/**
	 * @param imageCaption the imageCaption to set
	 */
	public void setImageCaption(String imageCaption) {
		this.imageCaption = imageCaption;
	}

	/**
	 * @return the imageFilename
	 */
	public String getImageFilename() {
		return imageFilename;
	}

	/**
	 * @param imageFilename the imageFilename to set
	 */
	public void setImageFilename(String imageFilename) {
		this.imageFilename = imageFilename;
	}

	/**
	 * @return the imageData
	 */
	public String getImageData() {
		return imageData;
	}

	/**
	 * @param imageData the imageData to set
	 */
	public void setImageData(String imageData) {
		this.imageData = imageData;
	}

	/**
	 * @return the bodyText
	 */
	public String getBodyText() {
		return bodyText;
	}

	/**
	 * @param bodyText the bodyText to set
	 */
	public void setBodyText(String bodyText) {
		this.bodyText = bodyText;
	}
}
