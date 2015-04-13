package com.lrn.dto;

import java.io.Serializable;

public class LanguageDTO implements Serializable {

	private static final long serialVersionUID = 4936752117973224979L;
	
	private String language;
	
	private String code;
	
	private String countryCode;
	
	private String enName;
	
	private String label;

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
