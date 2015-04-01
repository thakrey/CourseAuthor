package com.lrn.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class UserCustomColumns {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2274683499081509559L;

	/** The user id. */
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GEN_SEQ")
	@Column(name="USER_ID")
	private String userId;
	
	/** The accessId. */
	@Column(name="ACCESS_ID")
	private String accessId;
	
	/** The dob. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DOB")
	private Date dob;
	
	/** The empId. */
	@Column(name="EMPID")
	private String empId;
	
	/** The secret. */
	@Column(name="SECRET")
	private String secret;
	
	/** modDate **/
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="MODDATE")
	private Date modDate;

	/** The hAddress1. */
	@Column(name="HADDRESS_1")
	private String hAddress1;
	
	/** The hAddress2. */
	@Column(name="HADDRESS_2")
	private String hAddress2;

	/** The hCity. */
	@Column(name="HCITY")
	private String hCity;
	
	/** The hState. */
	@Column(name="HSTATE")
	private String hState;
	
	/** The hZip. */
	@Column(name="HZIP")
	private String hZip;
	
	/** The hCountry. */
	@Column(name="HCOUNTRY")
	private String hCountry;
	
	/** The hPhone. */
	@Column(name="HPHONE")
	private String hPhone;
	
	/** The title. */
	@Column(name="TITLE")
	private String title;
	
	/** The address1. */
	@Column(name="ADDRESS_1")
	private String address1;

	/** The address2. */
	@Column(name="ADDRESS_2")
	private String address2;

	/** The city. */
	@Column(name="CITY")
	private String city;
	
	/** The state. */
	@Column(name="STATE")
	private String state;
	
	/** The zip. */
	@Column(name="ZIP")
	private String zip;

	/** The country. */
	@Column(name="COUNTRY")
	private String country;

	
	/** The phone. */
	@Column(name="PHONE")
	private String phone;

	/** The fax. */
	@Column(name="FAX")
	private String fax;

	
	/** The browser. */
	@Column(name="BROWSER")
	private String browser;

	/** The division. */
	@Column(name="DIVISION")
	private String division;

	
	/** The costCenter. */
	@Column(name="COSTCENTER")
	private String costCenter;

	/** The superFirstName. */
	@Column(name="SUPERFIRSTNAME")
	private String superFirstName;

	/** The superLastName. */
	@Column(name="SUPERLASTNAME")
	private String superLastName;
	
	/** The superMiddleName. */
	@Column(name="SUPERMIDDLENAME")
	private String superMiddleName;
	
	/** delDate **/
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DEL_DATE")
	private Date delDate;
	
	/** The lcPassword. */
	@Column(name="LC_PASSWORD")
	private String lcPassword;

	/** The lcFirstName. */
	@Column(name="LC_FIRSTNAME")
	private String lcFirstName;
	
	/** The lcLastName. */
	@Column(name="LC_LASTNAME")
	private String lcLastName;
	
	/** The lcEmail. */
	@Column(name="LC_EMAIL")
	private String lcEmail;
	
	/** deactivatedDate **/
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DEACTIVATED_DATE")
	private Date deactivatedDate;
	
	/** The loginAttempt. */
	@Column(name="LOGIN_ATTEMPT")
	private Long loginAttempt;
	
	/** loginAttemptTime **/
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LOGIN_ATTEMPT_TIME")
	private Date loginAttemptTime;
	
	/** The custom22. */
	@Column(name="CUSTOM_22")
	private String custom22;
	
	/** The custom23. */
	@Column(name="CUSTOM_23")
	private String custom23;
	
	/** The custom24. */
	@Column(name="CUSTOM_24")
	private String custom24;
	
	/** The custom25. */
	@Column(name="CUSTOM_25")
	private String custom25;
	
	/** The custom26. */
	@Column(name="CUSTOM_26")
	private String custom26;
	
	/** The custom27. */
	@Column(name="CUSTOM_27")
	private String custom27;
	
	/** The custom82. */
	@Column(name="CUSTOM_28")
	private String custom28;
	
	/** The custom29. */
	@Column(name="CUSTOM_29")
	private String custom29;
	
	/** The custom30. */
	@Column(name="CUSTOM_30")
	private String custom30;
	
	/** The custom31. */
	@Column(name="CUSTOM_31")
	private String custom31;

	/** The custom32. */
	@Column(name="CUSTOM_32")
	private String custom32;

	/** The custom33. */
	@Column(name="CUSTOM_33")
	private String custom33;

	/** The custom34. */
	@Column(name="CUSTOM_34")
	private String custom34;

	/** The custom35. */
	@Column(name="CUSTOM_35")
	private String custom35;

	/** The custom36. */
	@Column(name="CUSTOM_36")
	private String custom36;

	/** The custom37. */
	@Column(name="CUSTOM_37")
	private String custom37;

	/** The custom38. */
	@Column(name="CUSTOM_38")
	private String custom38;

	/** The custom39. */
	@Column(name="CUSTOM_39")
	private String custom39;

	/** The custom40. */
	@Column(name="CUSTOM_40")
	private String custom40;

	/** The custom41. */
	@Column(name="CUSTOM_41")
	private String custom41;

	public String getAccessId() {
		return accessId;
	}

	public void setAccessId(String accessId) {
		this.accessId = accessId;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public Date getModDate() {
		return modDate;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}

	public String gethAddress1() {
		return hAddress1;
	}

	public void sethAddress1(String hAddress1) {
		this.hAddress1 = hAddress1;
	}

	public String gethAddress2() {
		return hAddress2;
	}

	public void sethAddress2(String hAddress2) {
		this.hAddress2 = hAddress2;
	}

	public String gethCity() {
		return hCity;
	}

	public void sethCity(String hCity) {
		this.hCity = hCity;
	}

	public String gethState() {
		return hState;
	}

	public void sethState(String hState) {
		this.hState = hState;
	}

	public String gethZip() {
		return hZip;
	}

	public void sethZip(String hZip) {
		this.hZip = hZip;
	}

	public String gethCountry() {
		return hCountry;
	}

	public void sethCountry(String hCountry) {
		this.hCountry = hCountry;
	}

	public String gethPhone() {
		return hPhone;
	}

	public void sethPhone(String hPhone) {
		this.hPhone = hPhone;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public String getSuperFirstName() {
		return superFirstName;
	}

	public void setSuperFirstName(String superFirstName) {
		this.superFirstName = superFirstName;
	}

	public String getSuperLastName() {
		return superLastName;
	}

	public void setSuperLastName(String superLastName) {
		this.superLastName = superLastName;
	}

	public String getSuperMiddleName() {
		return superMiddleName;
	}

	public void setSuperMiddleName(String superMiddleName) {
		this.superMiddleName = superMiddleName;
	}

	public Date getDelDate() {
		return delDate;
	}

	public void setDelDate(Date delDate) {
		this.delDate = delDate;
	}

	public String getLcPassword() {
		return lcPassword;
	}

	public void setLcPassword(String lcPassword) {
		this.lcPassword = lcPassword;
	}

	public String getLcFirstName() {
		return lcFirstName;
	}

	public void setLcFirstName(String lcFirstName) {
		this.lcFirstName = lcFirstName;
	}

	public String getLcLastName() {
		return lcLastName;
	}

	public void setLcLastName(String lcLastName) {
		this.lcLastName = lcLastName;
	}

	public String getLcEmail() {
		return lcEmail;
	}

	public void setLcEmail(String lcEmail) {
		this.lcEmail = lcEmail;
	}

	public Date getDeactivatedDate() {
		return deactivatedDate;
	}

	public void setDeactivatedDate(Date deactivatedDate) {
		this.deactivatedDate = deactivatedDate;
	}

	public Long getLoginAttempt() {
		return loginAttempt;
	}

	public void setLoginAttempt(Long loginAttempt) {
		this.loginAttempt = loginAttempt;
	}

	public Date getLoginAttemptTime() {
		return loginAttemptTime;
	}

	public void setLoginAttemptTime(Date loginAttemptTime) {
		this.loginAttemptTime = loginAttemptTime;
	}

	public String getCustom22() {
		return custom22;
	}

	public void setCustom22(String custom22) {
		this.custom22 = custom22;
	}

	public String getCustom23() {
		return custom23;
	}

	public void setCustom23(String custom23) {
		this.custom23 = custom23;
	}

	public String getCustom24() {
		return custom24;
	}

	public void setCustom24(String custom24) {
		this.custom24 = custom24;
	}

	public String getCustom25() {
		return custom25;
	}

	public void setCustom25(String custom25) {
		this.custom25 = custom25;
	}

	public String getCustom26() {
		return custom26;
	}

	public void setCustom26(String custom26) {
		this.custom26 = custom26;
	}

	public String getCustom27() {
		return custom27;
	}

	public void setCustom27(String custom27) {
		this.custom27 = custom27;
	}

	public String getCustom28() {
		return custom28;
	}

	public void setCustom28(String custom28) {
		this.custom28 = custom28;
	}

	public String getCustom29() {
		return custom29;
	}

	public void setCustom29(String custom29) {
		this.custom29 = custom29;
	}

	public String getCustom30() {
		return custom30;
	}

	public void setCustom30(String custom30) {
		this.custom30 = custom30;
	}

	public String getCustom31() {
		return custom31;
	}

	public void setCustom31(String custom31) {
		this.custom31 = custom31;
	}

	public String getCustom32() {
		return custom32;
	}

	public void setCustom32(String custom32) {
		this.custom32 = custom32;
	}

	public String getCustom33() {
		return custom33;
	}

	public void setCustom33(String custom33) {
		this.custom33 = custom33;
	}

	public String getCustom34() {
		return custom34;
	}

	public void setCustom34(String custom34) {
		this.custom34 = custom34;
	}

	public String getCustom35() {
		return custom35;
	}

	public void setCustom35(String custom35) {
		this.custom35 = custom35;
	}

	public String getCustom36() {
		return custom36;
	}

	public void setCustom36(String custom36) {
		this.custom36 = custom36;
	}

	public String getCustom37() {
		return custom37;
	}

	public void setCustom37(String custom37) {
		this.custom37 = custom37;
	}

	public String getCustom38() {
		return custom38;
	}

	public void setCustom38(String custom38) {
		this.custom38 = custom38;
	}

	public String getCustom39() {
		return custom39;
	}

	public void setCustom39(String custom39) {
		this.custom39 = custom39;
	}

	public String getCustom40() {
		return custom40;
	}

	public void setCustom40(String custom40) {
		this.custom40 = custom40;
	}

	public String getCustom41() {
		return custom41;
	}

	public void setCustom41(String custom41) {
		this.custom41 = custom41;
	}

}
