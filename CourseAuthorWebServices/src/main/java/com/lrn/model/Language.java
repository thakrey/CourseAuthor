package com.lrn.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SRC_LANG")
public class Language {

	@Id
	private LanguagePK languagePK;
	
	@Column(name="LANG_CODE")
	private String langCode;
	
	@Column(name="COUNTRY_CODE")
	private String countryCode;
	
	@Column(name="EN_NAME")
	private String enName;
	
	@Column(name="LABEL")
	private String label;

	public LanguagePK getLanguagePK() {
		return languagePK;
	}

	public void setLanguagePK(LanguagePK languagePK) {
		this.languagePK = languagePK;
	}

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
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
