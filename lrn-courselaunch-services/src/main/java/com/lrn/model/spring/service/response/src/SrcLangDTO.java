package com.lrn.model.spring.service.response.src;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.lrn.model.hibernate.CourseLookup;
import com.lrn.model.hibernate.src.SrcLang;
import com.lrn.model.spring.service.response.LRNResponse;
import com.lrn.model.spring.service.response.module.CourseLookupDTO;

/**
 * The Class SiteBrandingDTO.
 * 

 */
public class SrcLangDTO implements Serializable {

	private static final long serialVersionUID = 9049923626648903600L;
	
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
	
	private String errorMessage;
	
	private LRNResponse lrnResponse;

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
	
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void getSrcLangParam(String language) {
		// TODO Auto-generated method stub
		
	}
	
	
	public static final SrcLangDTO convertModelToDTO(SrcLang srcLang) {
		SrcLangDTO srcLangDTO = new SrcLangDTO();
		
		srcLangDTO.setCountryCode(srcLang.getCountryCode());
		srcLangDTO.setLabel(srcLang.getLabel());
		srcLangDTO.setLangCode(srcLang.getLangCode());
		srcLangDTO.setEnName(srcLang.getEnName());
		srcLangDTO.setLanguage(srcLang.getLanguage());
		return srcLangDTO;
	}
	
	/**
	 * @return the lrnResponse
	 */
	public LRNResponse getLrnResponse() {
		return lrnResponse;
	}

	/**
	 * @param lrnResponse the lrnResponse to set
	 */
	public void setLrnResponse(LRNResponse lrnResponse) {
		this.lrnResponse = lrnResponse;
	}
	
	

	
}