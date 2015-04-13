package com.lrn.dto.request.user;

import java.io.Serializable;
import java.util.Date;

/**  
* InsertUserDTO - data transfer object class for Inserting User. 
* It stores the data for the Inserting User. 
* 
*/
public class InsertUserDTO implements Serializable {

	private static final long serialVersionUID = 1280290994173521739L;

	private String 		username;
	private String 		company;
	private String 		firstName;
	private String 		middleName;
	private String 		lastName;
	private String 		email;
	private Boolean 	isActive;
	private String 		password;
	private String 		userId;
	private String 		language;
	private Long 		siteId;
	private String 		accessId;
	private Date 		dob;
	private String 		empId;
	private String 		secret;
	private Date 		modDate;
	private String 		hAddress1;
	private String 		hAddress2;
	private String 		hCity;
	private String 		hState;
	private String 		hZip;
	private String 		hCountry;
	private String 		hPhone;
	private String 		title;
	private String 		address1;
	private String 		address2;
	private String 		city;
	private String 		state;
	private String 		zip;
	private String 		country;
	private String 		phone;
	private String 		fax;
	private String 		browser;
	private String 		division;
	private String 		costCenter;
	private String 		superFirstName;
	private String 		superLastName;
	private String 		superMiddleName;
	private Date 		delDate;
	private String 		lcPassword;
	private String 		lcFirstName;
	private String 		lcLastName;
	private String 		lcEmail;
	private Date 		deactivatedDate;
	private Long 		loginAttempt;
	private Date 		loginAttemptTime;
	private String 		custom22;
	private String 		custom23;
	private String 		custom24;
	private String 		custom25;
	private String 		custom26;
	private String 		custom27;
	private String 		custom28;
	private String 		custom29;
	private String 		custom30;
	private String 		custom31;
	private String 		custom32;
	private String 		custom33;
	private String 		custom34;
	private String 		custom35;
	private String 		custom36;
	private String 		custom37;
	private String 		custom38;
	private String 		custom39;
	private String 		custom40;
	private String 		custom41;
	
	/** Gets the username
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/** Sets the username
	 * 
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/** Gets the company
	 * 
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/** Sets the company
	 * 
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/** Gets the firstName
	 * 
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/** Sets the firstName
	 * 
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/** Gets the middleName
	 * 
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/** Sets the middleName
	 * 
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/** Gets the lastName
	 * 
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/** Sets the lastName
	 * 
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/** Gets the email
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/** Sets the email
	 * 
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/** Gets the isActive flag(true or false)
	 * 
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/** Sets the isActive flag(true or false)
	 * 
	 * @param isActive the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/** Gets the password
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/** Sets the password
	 * 
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

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
