package com.lrn.model.hibernate.src;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * The Class SrcLang.
 *
 * @author kishore.Ohal
 */
@Embeddable
public class SrcLang implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5696809891342411493L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_SEQ")
	@Column(name = "LANGUAGE")
	private String language;
	
	/** The LANG CODE. */
	@Column(name="LANG_CODE")
	private String langCode;
	
	/** The COUNTRY CODE. */
	@Column(name="COUNTRY_CODE")
	private String countryCode;
	
	/** The EN NAME. */
	@Column(name="EN_NAME")
	private String enName;
	
	/** The LABEL. */
	@Column(name="LABEL")
	private String label;

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the langCode
	 */
	public String getLangCode() {
		return langCode;
	}

	/**
	 * @param langCode the langCode to set
	 */
	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @return the enName
	 */
	public String getEnName() {
		return enName;
	}

	/**
	 * @param enName the enName to set
	 */
	public void setEnName(String enName) {
		this.enName = enName;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param labelCode the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}	
	 
	
}
