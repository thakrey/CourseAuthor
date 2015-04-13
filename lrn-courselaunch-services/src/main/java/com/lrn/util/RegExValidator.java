package com.lrn.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class RegExValidator {
	
	private static final Logger logger = Logger.getLogger(RegExValidator.class);

	public static String validateRegEx(String regEx, String value, boolean checkRequired) {
		
		String error = null;
		
		value.replaceAll("\\s+$", "");
		if(value != null ) {
			//check required field
			if(value.trim().length() == 0 && checkRequired) {
				error = "Field is Required";
			} if (value.trim().length() == 0){
				return error;
			} else {
				//java regex does not support \x. moreover utf-8 encoding is being checked already.
				if(regEx.equals("^[\\S\\ \\x{3000}]*$")) {
					regEx = "^[\\S\\ ]*$";
				}
				
				Pattern pattern = Pattern.compile(regEx);
				Matcher matcher = pattern.matcher(value);
				
				if(!matcher.matches()) {
					error = "Invalid Field Format.";
				}
			}
		}
		
		return error;
	}
	
	/*public static void main(String args[]) {
		
		String error = validateRegEx("^[\\S\\ ]*$", "  ", true);
		System.out.println("Error  ::: ^[\\S\\ ]*$        : " + error);
		
		error = validateRegEx("^[a-z]{2}([A-Z]{2})*$", "en", true);
		System.out.println("Error  ::: ^[a-z]{2}([A-Z]{2})*$        : " + error);
		
		error = validateRegEx("^[a-zA-Z]*$", "test", true);
		System.out.println("Error  ::: ^[a-zA-Z]*$        : " + error);
		
		error = validateRegEx("^[\\w!#$%&*'+\\-\\/=?^_`|~{}\\.]+@[\\w!#$%&*'+\\-\\/=?^_`|~{}]+(\\.[\\w!#$%&*'+\\-\\/=?^_`|~{}]+)+$", "suja.ravi@lrn.com", true);
		System.out.println("Error   ::: ^[\\w!#$%&*'+\\-\\/=?^_`|~{}\\.]+@[\\w!#$%&*'+\\-\\/=?^_`|~{}]+(\\.[\\w!#$%&*'+\\-\\/=?^_`|~{}]+)+$       : " + error);
	}*/
}
