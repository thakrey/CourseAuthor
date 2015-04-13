package com.lrn.model.lcec;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.lrn.model.hibernate.AbstractBaseEntity;



@Entity
@SequenceGenerator(name = "GEN_SEQ", sequenceName = "TRANSLATION_KEY_TYPE_SEQ")
@Table(name = "TRANSLATION_KEY_TYPE")
public class TranslationKeyType extends AbstractBaseEntity implements Serializable {

	private static final long serialVersionUID = -8363590940008939879L;

	@Column(name="NAME")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static final String LABEL 			= "Label";
	public static final String ERROR			= "Error";
	
	public static enum DEFAULTS{
		LABEL(TranslationKeyType.LABEL),
		ERRORS(TranslationKeyType.ERROR);
		
		private final String name;
		
		DEFAULTS(String name){ this.name = name; }
		
		public String getName(){ return name; }
	}
}
