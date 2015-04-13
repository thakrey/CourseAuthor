package com.lrn.model.hibernate.custom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.lrn.model.hibernate.AbstractBaseEntity;

/**
 * The Class CustomString
 * 
 * @author kishor.pawar
 */
@NamedQueries( {
	@NamedQuery(name = "getCustomStringByCompanyAndlanguage",
			query = "from CustomString cs where cs.customPublishes.company = :company " +
					"and cs.customPublishes.profileValue = :profileValue ")
})
@Entity
@SequenceGenerator(name = "GEN_SEQ", sequenceName = "CUSTOM_STRING_SEQ")
@Table(name = "CUSTOM_STRING")
public class CustomString extends AbstractBaseEntity {

	private static final long serialVersionUID = -6556422858771546824L;

	/** The custom publish id. */
	@ManyToOne(targetEntity = CustomPublishes.class, fetch = FetchType.EAGER)
	@JoinColumn(name="CUSTOM_PUBLISH_ID", nullable=false)
	private CustomPublishes customPublishes;

	@Column(name="KEY")
    private String key;
    
    @Column(name="STRING")
    private String value;

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
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
}