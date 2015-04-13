package com.lrn.dto;

import java.io.Serializable;
import java.sql.Date;

public class RsaKeysDTO implements Serializable {

	private static final long serialVersionUID = -5937687694198552589L;

	private Long siteId;
		
     private String passPhrase;
		
     private String publicKey;
		
	 private String privateKey;
		
	 private Date createDate;
		
     private String createUser;
		
	 private String notificationEmail;
		
	 private String rsaKeysTypeId;

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public String getPassPhrase() {
		return passPhrase;
	}

	public void setPassPhrase(String passPhrase) {
		this.passPhrase = passPhrase;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getNotificationEmail() {
		return notificationEmail;
	}

	public void setNotificationEmail(String notificationEmail) {
		this.notificationEmail = notificationEmail;
	}

	public String getRsaKeysTypeId() {
		return rsaKeysTypeId;
	}

	public void setRsaKeysTypeId(String rsaKeysTypeId) {
		this.rsaKeysTypeId = rsaKeysTypeId;
	}
	 
	 
}
