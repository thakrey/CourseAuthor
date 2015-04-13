package com.lrn.dto;

import java.io.Serializable;

public class CustomSectionsDTO implements Serializable {

	private static final long serialVersionUID = -1587533857640507389L;
	
	private String company;
	private String type;
	private String location;

	private String tableType;
	private String tableBorderColor;
	private String titleText;
	private String titleTextColor;
	private String titleBgColor;
	private Long titleBorder;
	
	private String bodyBgColor;
	private Long bodyBorder;
	private String bodyTextColor;
	
	private String imageType;
	private Long imageHeight;
	private Long imageWidth;
	private String imagePosition;
	private String imageAlign;
	private String imageValign;
	private String imageCaption;
	private String imageFilename;
	private byte[] imageData;
	
	private String bodyText;
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getBodyText() {
		return bodyText;
	}
	public void setBodyText(String bodyText) {
		this.bodyText = bodyText;
	}
	
	public String getTableType() {
		return tableType;
	}
	public void setTableType(String tableType) {
		this.tableType = tableType;
	}
	public String getTableBorderColor() {
		return tableBorderColor;
	}
	public void setTableBorderColor(String tableBorderColor) {
		this.tableBorderColor = tableBorderColor;
	}
	public String getTitleText() {
		return titleText;
	}
	public void setTitleText(String titleText) {
		this.titleText = titleText;
	}
	public String getTitleTextColor() {
		return titleTextColor;
	}
	public void setTitleTextColor(String titleTextColor) {
		this.titleTextColor = titleTextColor;
	}
	public String getTitleBgColor() {
		return titleBgColor;
	}
	public void setTitleBgColor(String titleBgColor) {
		this.titleBgColor = titleBgColor;
	}
	public Long getTitleBorder() {
		return titleBorder;
	}
	public void setTitleBorder(Long titleBorder) {
		this.titleBorder = titleBorder;
	}
	public String getBodyBgColor() {
		return bodyBgColor;
	}
	public void setBodyBgColor(String bodyBgColor) {
		this.bodyBgColor = bodyBgColor;
	}
	public Long getBodyBorder() {
		return bodyBorder;
	}
	public void setBodyBorder(Long bodyBorder) {
		this.bodyBorder = bodyBorder;
	}
	public String getImageType() {
		return imageType;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
	public Long getImageHeight() {
		return imageHeight;
	}
	public void setImageHeight(Long imageHeight) {
		this.imageHeight = imageHeight;
	}
	public Long getImageWidth() {
		return imageWidth;
	}
	public void setImageWidth(Long imageWidth) {
		this.imageWidth = imageWidth;
	}
	public String getImagePosition() {
		return imagePosition;
	}
	public void setImagePosition(String imagePosition) {
		this.imagePosition = imagePosition;
	}
	public String getImageAlign() {
		return imageAlign;
	}
	public void setImageAlign(String imageAlign) {
		this.imageAlign = imageAlign;
	}
	public String getImageValign() {
		return imageValign;
	}
	public void setImageValign(String imageValign) {
		this.imageValign = imageValign;
	}
	public String getImageCaption() {
		return imageCaption;
	}
	public void setImageCaption(String imageCaption) {
		this.imageCaption = imageCaption;
	}
	public String getImageFilename() {
		return imageFilename;
	}
	public void setImageFilename(String imageFilename) {
		this.imageFilename = imageFilename;
	}
	public byte[] getImageData() {
		return imageData;
	}
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	
	public String getBodyTextColor() {
		return bodyTextColor;
	}
	public void setBodyTextColor(String bodyTextColor) {
		this.bodyTextColor = bodyTextColor;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomSectionsDTO other = (CustomSectionsDTO) obj;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		return true;
	}
}
