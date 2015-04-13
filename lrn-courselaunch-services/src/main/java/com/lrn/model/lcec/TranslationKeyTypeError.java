/**
 * 
 */
package com.lrn.model.lcec;

/**
 *  
 *
 * Specific to error type
 */
public class TranslationKeyTypeError extends TranslationKeyType {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2724612536547391721L;
	

	public static enum CatalystErrorType {

		CATALYST_MESSAGE("C", "Catalyst Message"),
		FRONTEND("F", "Frontend"),
		SERVICES("S", "Services"),
		AUTHENTICATION("A", "Authentication"),
		IMPLEMENTATION("N", "Network"),
		DATABASE("D", "Database"),
		ERROR("E", "Error"),
		INFO("I", "Information");
		
		private String type;
		
		private String description;
		
		 private CatalystErrorType(String type, String description) 
		 {         
			 this.type = type;         
			 this.description = description;     
		 } 
		 
		 public String getType() 
		 {         
			 return type;     
		 }
		 
		 public String getDescription() 
		 {         
			 return description;     
		 }
	}

	public static enum CatalystErrorSeq {
		
		DATABASE_SYSTEM_ERR("001", "System/DB error while processing the service request"),
		REGEX_ERROR("001", "Invalid Field Format"),
		FORGOT_PWD_INVALID_PWD_FORMAT("001" , "Invalid password format"),
		REQUIRED_FIELDS_MISSING("001","Required fields missing"), 
		LOGIN_INVALID_ERR("007" ,  "Invalid credentials"),
		LOGIN_LOCKOUT_ERR("008" , "Invalid password attempt for more than specified number of times" ),
		FORGOT_PWD_INVALID_USERNM("009", "Invalid Username entered while resetting for Forgot pwd "),
		FORGOT_PWD_INVALID_EMAIL("010", "Invalid E-Mail entered while resetting for Forgot pwd "),
		FORGOT_PWD_KEY_EXPIRED("011" , "Key expired for forgot pwd link"), 
		CHANGE_PWD_INCORRECT_PWD("014", "Incorrect current password while changing password "),
		FORGOT_PWD_SEND_EMAIL_ERR("015", "Unable to send mail"), 
		FORGOT_PWD_EMAIL_NOTSET("017" , "Email not available for this user to send a mail"),
		NEW_SELF_REG_USER_SEND_EMAIL_ERR("018", "Unable to send New User Self Registration Email"),
		NEW_SELF_REG_USER_EMAIL_NOTSET("019" , "Email not available for this user to send New User Self Registration mail"),
		NEW_SELF_REG_USER_INVALID_EMAIL("020", "Invalid E-Mail entered while New Self Registration User "),
		NEW_SELF_REG_USER_INVALID_USERNM("021", "Invalid Username entered while New User Self Registration "),
		DUPLICATE_USER("CEA045", "The user name %SelfRegLoginName% already exists. Please choose a different user name.");
		
		private String code;
		
		private String description;
		
		 private CatalystErrorSeq(String code, String description) 
		 {         
			 this.code = code;         
			 this.description = description;     
		 } 
		 
		 public String getCode() 
		 {         
			 return code;     
		 }
		 
		 public String getDescription() 
		 {         
			 return description;     
		 }
	}
	
	public enum SeverityLevel{
		LOW("Low"),
		MEDIUM("Medium"),
		SEVERE("Severe");
		
		private String description;
		
		 private SeverityLevel(String description) 
		 {         
			 this.description = description;     
		 } 
		 
		 public String getDescription() 
		 {         
			 return description;     
		 }
		 
		 public String toString() {
			 String s = super.toString();    
			 return s.toUpperCase()+":"; 
		 }
	}
}
