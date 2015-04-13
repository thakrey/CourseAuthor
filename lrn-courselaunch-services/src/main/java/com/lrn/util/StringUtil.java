package com.lrn.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

/**
 * The Class StringUtil for all LRN related String Utilities.
 */
public class StringUtil {
    
	private static final Logger logger = Logger.getLogger(StringUtil.class);
	
    /** The Constant charset for randomized passwords. */
    private static final String charset = "!_@$+0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    /**
     * Gets the randomly generated password.
     *
     * @param length the length
     * @return the random password
     */
    public static String getRandomPassword(int length) {
    	Random rand = new Random(System.currentTimeMillis());
    	StringBuffer sb = new StringBuffer();
    	for (int i=0; i < length; i++) {
    		int pos = rand.nextInt(charset.length());
    		sb.append(charset.charAt(pos));
    	}
    	
    	return sb.toString();
    }
    
    public static String generateMD5Hash(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
    	MessageDigest md = MessageDigest.getInstance("MD5");
    	byte[] md5Hash = new byte[32];
    	md.update(input.getBytes("iso-8859-1"), 0, input.length());
    	md5Hash = md.digest();
    	return convertToHex(md5Hash);
    }
    
    public static String convertToHex(byte[] data) {
    	StringBuffer buf = new StringBuffer();
    	for(int i=0; i <data.length; i++) {
    		int halfbyte = (data[i] >>> 4) & 0x0F;
    		int two_halfs = 0;
    		do {
    			if ((0 <= halfbyte) && (halfbyte <= 9)) 
    				buf.append((char) ('0' + halfbyte));
    			else
    				buf.append((char) ('a' + (halfbyte - 10)));
    				halfbyte = data[i] & 0x0F;
    		} while (two_halfs++ < 1);
    	}
    	return buf.toString();
    }
    
    /**
	 * Constructs comma separated string used at query from list
	 *
	 * @param List<Long> ids
	 * 
	 * @return String
	 */
	public static String getLongListAsString(List<Long> ids) {
		StringBuilder queryBuilder = new StringBuilder();
		int counter = 0;
		for(Long id : ids) {
			if(counter == 0) {
				queryBuilder.append(id);
			} else {
				queryBuilder.append(", ").append(id);
			}
			counter++;
		}
		return queryBuilder.toString();
	}
	
	/**
	 * Constructs comma separated string used at query from list
	 *
	 * @param List<Long> ids
	 * 
	 * @return String
	 */
	public static String getStringListAsAsString(List<String> ids) {
		StringBuilder queryBuilder = new StringBuilder();
		int counter = 0;
		for(String id : ids) {
			if(counter == 0) {
				queryBuilder.append("'").append(id).append("'");
			} else {
				queryBuilder.append(", '").append(id).append("'");
			}
			counter++;
		}
		return queryBuilder.toString();
	}
	
	public static java.sql.Timestamp getSqlTimeStampFromDateStringInLCECDateFormat(String dateString) throws ParseException {
		
		SimpleDateFormat df = getLCECDateFormat();
		Date creationDate = df.parse(dateString);
		java.sql.Timestamp sqlTime = new java.sql.Timestamp(creationDate.getTime());
		
		return sqlTime;
	}
	
	public static String getDateStringFromJavaDateInLCECDateFormat(java.util.Date javaDate) throws ParseException {
		SimpleDateFormat df = getLCECDateFormat();
		return df.format(javaDate);
	}
	
	public static java.util.Date getJavaDateFromDateStringInLCECDateFormat(String dateString) throws ParseException {
		SimpleDateFormat df = getLCECDateFormat();
		return df.parse(dateString);
	}
	
	public static SimpleDateFormat getLCECDateFormat() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		return df;
	}
	
	public static Date getDateFromStringInStandardDateFormat(String dateString) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		return df.parse(dateString);
	}
	
	public static String getStringFromDateInStandardDateFormat(Date date) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		return df.format(date);
	}
}
