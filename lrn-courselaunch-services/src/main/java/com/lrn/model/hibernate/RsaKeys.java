package com.lrn.model.hibernate;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.lrn.model.spring.service.response.LRNError;


@Entity
@SequenceGenerator(
		name 			= "GEN_SEQ",
		sequenceName 	= "SQ_RSA_KEYS"
)
@NamedQueries( {
	@NamedQuery(name = "findRsaKeysBySiteId",
			query = "from RsaKeys r where r.siteId = :siteId and rsa_keys_type_id = 2")
})
@Table(name="RSA_KEYS")
public class RsaKeys implements Serializable {

	@Id
	@Column(name="SITE_ID")
    private Long siteId;
	
	@Column(name="PASS_PHRASE")
    private String passPhrase;
	
	@Column(name="PUBLIC_KEY")
    private Blob publicKey;
	
	@Column(name="PRIVATE_KEY")
    private Blob privateKey;
	
	@Column(name="CREATE_DATE")
	private Date createDate;
	
	@Column(name="CREATE_USER")
	private String createUser;
	
	@Column(name="NOTIFICATION_EMAIL")
	private String notificationEmail;
	
	@Column(name="RSA_KEYS_TYPE_ID")
	private String rsaKeysTypeId;
	
	/** The Error Obj. */
	@Transient
	private LRNError error = new LRNError();
	
	/**
	 * Instantiates a new rsa_keys.
	 */
	public RsaKeys() { }

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public Long getSiteId() {
		return siteId;
	}

	public void setPassPhrase(String passPhrase) {
		this.passPhrase = passPhrase;
	}

	public String getPassPhrase() {
		return passPhrase;
	}

	public void setPublicKey(Blob publicKey) {
		this.publicKey = publicKey;
	}

	public Blob getPublicKey() {
		return publicKey;
	}

	public void setPrivateKey(Blob privateKey) {
		this.privateKey = privateKey;
	}

	public Blob getPrivateKey() {
		return privateKey;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setNotificationEmail(String notificationEmail) {
		this.notificationEmail = notificationEmail;
	}

	public String getNotificationEmail() {
		return notificationEmail;
	}

	public void setRsaKeysTypeId(String rsaKeysTypeId) {
		this.rsaKeysTypeId = rsaKeysTypeId;
	}

	public String getRsaKeysTypeId() {
		return rsaKeysTypeId;
	}
	
	/**
	 * Sets the error code.
	 * 
	 * @param code
	 *            the new error code
	 */
	public void setErrorCode(Long code) {
		this.error.setCode(code);
	}
	
	/**
	 * Sets the error message.
	 * 
	 * @param message
	 *            the new error message
	 */
	public void setErrorMessage(String message) {
		this.error.setMessage(message);
	}
	
	/**
	 * Gets the error code.
	 * 
	 * @return the error code
	 */
	public Long getErrorCode() {
		return this.error.getCode();
	}
	
	/**
	 * Gets the error message.
	 * 
	 * @return the error message
	 */
	public String getErrorMessage() {
		return this.error.getMessage();
	}

	/**
	 * @return the error
	 */
	public LRNError getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(LRNError error) {
		this.error = error;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((siteId == null) ? 0 : siteId.hashCode());
		result = prime * result + ((passPhrase == null) ? 0 : passPhrase.hashCode());
		result = prime * result + ((publicKey == null) ? 0 : publicKey.hashCode());
		result = prime * result + ((privateKey == null) ? 0 : privateKey.hashCode());
		result = prime * result + ((notificationEmail == null) ? 0 : notificationEmail.hashCode());
		result = prime * result + ((rsaKeysTypeId == null) ? 0 : rsaKeysTypeId.hashCode());
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof RsaKeys)) {
			return false;
		}
		RsaKeys other = (RsaKeys) obj;
		if (siteId == null) {
			if (other.siteId != null) {
				return false;
			}
		} else if (!siteId.equals(other.siteId)) {
			return false;
		}
		if (passPhrase == null) {
			if (other.passPhrase != null) {
				return false;
			}
		} else if (!passPhrase.equals(other.passPhrase)) {
			return false;
		}
		
		if (publicKey == null) {
			if (other.publicKey != null) {
				return false;
			}
		} else if (!publicKey.equals(other.publicKey)) {
			return false;
		}
		
		if (privateKey == null) {
			if (other.privateKey != null) {
				return false;
			}
		} else if (!privateKey.equals(other.privateKey)) {
			return false;
		}

		if (notificationEmail == null) {
			if (other.notificationEmail != null) {
				return false;
			}
		} else if (!notificationEmail.equals(other.notificationEmail)) {
			return false;
		}
		
		if (rsaKeysTypeId == null) {
			if (other.rsaKeysTypeId != null) {
				return false;
			}
		} else if (!rsaKeysTypeId.equals(other.rsaKeysTypeId)) {
			return false;
		}
		
		if (createDate == null) {
			if (other.createDate != null) {
				return false;
			}
		} else if (!createDate.equals(other.createDate)) {
			return false;
		}
		
		if (createUser == null) {
			if (other.createUser != null) {
				return false;
			}
		} else if (!createUser.equals(other.createUser)) {
			return false;
		}
		return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StatusCode [siteId=" + siteId + ", passPhrase=" + passPhrase + ", notificationEmail=" + notificationEmail + ", notificationEmail=" + notificationEmail + ", createUser=" + createUser + "]";
	}
}