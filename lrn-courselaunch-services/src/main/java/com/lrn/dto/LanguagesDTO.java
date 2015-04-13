package com.lrn.dto;

import java.io.Serializable;
import java.util.List;

public class LanguagesDTO implements Serializable {

	private static final long serialVersionUID = 1915745038018202617L;
	
	private List<LanguageDTO> languagesList;

	public List<LanguageDTO> getLanguagesList() {
		return languagesList;
	}

	public void setLanguagesList(List<LanguageDTO> languagesList) {
		this.languagesList = languagesList;
	}
}
