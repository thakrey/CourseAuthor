package com.lrn.model;

import javax.persistence.Column;

public class LanguagePK {
	@Column(name = "LANGUAGE")
	private String language;

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
