package com.lrn.model.hibernate.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.lrn.model.hibernate.site.Site;
import com.lrn.model.spring.service.response.LRNError;

/**
 * The Class User.
 *  * 
 */
@Entity
@SequenceGenerator(
		name 			= "GEN_SEQ",
		sequenceName 	= "USERS_SEQ"
)
@Table(name = "USERS")
public class User implements Serializable {
	
	private static final long serialVersionUID = -3388145092085424898L;

	/** The user id. */
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GEN_SEQ")
	@Column(name="USER_ID")
	private String userId;
	
	/** The password. */
	@Column(name="PASSWORD")
	private String password;
	
	/** The first name. */
	@Column(name="FIRSTNAME")
	private String firstName;
	
	/** The middle name. */
	@Column(name="MIDDLENAME")
	private String middleName;
	
	/** The last name. */
	@Column(name="LASTNAME")
	private String lastName;
	
	/** The username. */
	@Column(name="LOGIN_NAME")
	private String username;
	
	/** The Email. */
	@Column(name="EMAIL")
	private String email;
	
	/** The company. */
	@Column(name="COMPANY")
	private String company;
	
	/** The language. */
	@Column(name="LANGUAGE")
	private String language;
	
	/** The active flag. */
	@Column(name="ACTIVE", nullable=false)
	private String active = new String("t");
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="PASSWORD_MOD_DATE")
	private Date passwordModDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATION_DATE")
	private Date creationDate;
	
	/** The Error Obj. */
	@Transient
	private LRNError error = new LRNError();
	
	/** The Site. */
	@ManyToOne(targetEntity=Site.class, fetch=FetchType.LAZY, cascade={CascadeType.PERSIST})
	@JoinTable(name="site_user",
	    joinColumns = @JoinColumn(name="user_id"),
	    inverseJoinColumns = @JoinColumn(name="site_id")
	)
	private Site site;
	
	//for UI only
	private long lockoutTime;
	
	//All the rest of columns in the DB for user including the custom columns are in UserCustomColumns
	private UserCustomColumns userCustomColumns;
	
	
	/**
	 * Instantiates a new user.
	 */
	public User() { }

	/**
	 * Gets the user id.
	 * 
	 * @return the user id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 * 
	 * @param userId
	 *            the new user id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Gets the password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 * 
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the first name.
	 * 
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 * 
	 * @param firstName
	 *            the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the middle name.
	 * 
	 * @return the middle name
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * Sets the middle name.
	 * 
	 * @param middleName
	 *            the new middle name
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * Gets the last name.
	 * 
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 * 
	 * @param lastName
	 *            the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the username.
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return (username == null) ? null : username.toLowerCase();
	}

	/**
	 * Sets the username.
	 * 
	 * @param username
	 *            the new username
	 */
	public void setUsername(String username) {
		this.username = (username!= null) ? username.toUpperCase() : null;
	}
	
	
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get the site this user belongs to.
	 * 
	 * @return the site model
	 */
	public Site getSite() {
		return this.site;
	}
	
	/**
	 * Set the site this user belongs to.
	 * 
	 * @param site
	 *            the site this user belongs to.
	 */
	public void setSite(Site site) {
		this.site = site;
	}

	
    /**
	 * Get the active flag for this user.
	 * 
	 * @return True if active, false if not
	 */
	public Boolean getIsActive() {
		if ( this.active.equals(new String("t")) ) {
			return true;
		} 
		return false;
	}

	/**
	 * Set the active flag for this user.
	 * 
	 * @param isActive
	 *            the active flag
	 */
	public void setIsActive(Boolean isActive) {
		if (isActive!=null && isActive) {
			this.active = new String("t");
		} else {
			this.active = new String("f");
		}
	}

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
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((error == null) ? 0 : error.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((middleName == null) ? 0 : middleName.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((site == null) ? 0 : site.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
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

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	public long getLockoutTime() {
		return lockoutTime;
	}

	public void setLockoutTime(long lockoutTime) {
		this.lockoutTime = lockoutTime;
	}

	/**
	 * @return the passwordModDate
	 */
	public Date getPasswordModDate() {
		return passwordModDate;
	}

	/**
	 * @param passwordModDate the passwordModDate to set
	 */
	public void setPasswordModDate(Date passwordModDate) {
		this.passwordModDate = passwordModDate;
	}
	
	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public UserCustomColumns getUserCustomColumns() {
		return userCustomColumns;
	}

	public void setUserCustomColumns(UserCustomColumns userCustomColumns) {
		this.userCustomColumns = userCustomColumns;
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
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		if (active == null) {
			if (other.active != null) {
				return false;
			}
		} else if (!active.equals(other.active)) {
			return false;
		}
		if (company == null) {
			if (other.company != null) {
				return false;
			}
		} else if (!company.equals(other.company)) {
			return false;
		}
/*		if (error == null) {
			if (other.error != null) {
				return false;
			}
		} else if (!error.equals(other.error)) {
			return false;
		}*/
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		if (middleName == null) {
			if (other.middleName != null) {
				return false;
			}
		} else if (!middleName.equals(other.middleName)) {
			return false;
		}
		if (site == null) {
			if (other.site != null) {
				return false;
			}
		} else if (!site.equals(other.site)) {
			return false;
		}
		if (userId == null) {
			if (other.userId != null) {
				return false;
			}
		} else if (!userId.equals(other.userId)) {
			return false;
		}
		if (username == null) {
			if (other.username != null) {
				return false;
			}
		} else if (!username.equals(other.username)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName
				+ ", username=" + username + ", company=" + company
				+ ", active=" + getIsActive() + ", site=" + site + "]";
	}
}
