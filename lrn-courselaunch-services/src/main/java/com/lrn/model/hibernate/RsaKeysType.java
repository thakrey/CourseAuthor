package com.lrn.model.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The Class RsaKeys.

 */
@Entity
@SequenceGenerator(
		name		 = "GEN_SEQ",
		sequenceName = "RSA_KEYS_TYPE_SEQ"
)
@Table(name = "RSA_KEYS_TYPE")
public class RsaKeysType extends AbstractBaseEntity {

	private static final long serialVersionUID = -4532344590540576637L;
	
	public static final String PGP 		= "PGP";

	public static final String SAML		= "SAML";

	public static final String WSS_KEY	= "WSS_KEY";
	
	public static enum DEFAULTS{
		PGP(RsaKeysType.PGP),
		SAML(RsaKeysType.SAML),
		WSS_KEY(RsaKeysType.WSS_KEY);
		
		private final String name;
		
		DEFAULTS(String name){
			this.name = name;
		}
		
		public String getName(){ return name; }
	}
	
	/** The name. */
	@Column(name = "NAME")
	private String name;

	/**
	 * Gets the name.
	 *
	 * @return the status name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 * 		 the status name
	 */
	public void setName(String name) {
		this.name = name;
	}
}
