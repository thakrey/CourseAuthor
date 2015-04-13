package com.lrn.model.hibernate.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.lrn.model.hibernate.AbstractBaseEntity;

/**
 * The Class UserCustomColumnEnum
 * 
 * @author kishor.pawar
 */
@NamedQueries( {
	@NamedQuery(name = "findUserCustomColumnEnumBySiteId",
			query = "from UserCustomColumnEnum cf where cf.siteId = :siteId order by columnName, value")
})

@Entity
@SequenceGenerator(
		name 			= "GEN_SEQ",
		sequenceName 	= "CUSTOM_FIELD_ENUM_SEQ"
)
@Table(name = "CUSTOM_FIELD_ENUM")
public class UserCustomColumnEnum extends AbstractBaseEntity implements Serializable {

	private static final long serialVersionUID = -5531184375469537835L;

	@Column(name="SITE_ID")
    private Long siteId;

    @Column(name="COLUMN_NAME")
    private String columnName;
    
    @Column(name="KEY")
    private String key;
    
    @Column(name="VALUE")
    private String value;
    
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED")
	private Date created;

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
