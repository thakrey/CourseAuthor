package com.lrn.model.hibernate.custom;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.lrn.model.hibernate.AbstractBaseEntity;

/**
 * The Class CustomFieldEnum.
 *
 * @author kishor.pawar
 */
@NamedQueries( {
	@NamedQuery(name = "getCustomFieldEnumBySiteIdAndColumnName",
			query = "from CustomFieldEnum customFieldEnum where customFieldEnum.siteId = :siteId " +
					"and customFieldEnum.columnName = :columnName ")
})
@Entity
@SequenceGenerator(
		name 			= "GEN_SEQ",
		sequenceName 	= "CUSTOM_FIELD_ENUM_SEQ"
)
@Table(name="CUSTOM_FIELD_ENUM")
public class CustomFieldEnum extends AbstractBaseEntity {
	
    private static final long serialVersionUID = 2706260766200440405L;

	@Column(name="SITE_ID")
	private Long siteId;
    
	@Column(name="COLUMN_NAME")
    private String columnName;
    
    @Column(name="KEY")
    private String key;
    
    @Column(name="VALUE")
    private String value;
    
    @Column(name="CREATED")
    private Date created;

	/**
	 * @return the siteId
	 */
	public Long getSiteId() {
		return siteId;
	}

	/**
	 * @param siteId the siteId to set
	 */
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	/**
	 * @return the columnName
	 */
	public String getColumnName() {
		return columnName;
	}

	/**
	 * @param columnName the columnName to set
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
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

	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}
}