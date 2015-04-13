/**
 * 
 */
package com.lrn.util;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.log4j.Logger;

import com.lrn.model.lcec.TranslationKeyTypeError;
import com.lrn.model.lcec.TranslationKeyTypeError.SeverityLevel;
import com.lrn.model.spring.service.response.LRNError;



/**
 * @author 
 *
 */
public class ErrorUtils {
	
	private static final Logger logger = Logger.getLogger(ErrorUtils.class);
	
	public static String formCatystErrorCode(String applicationLevel, 
						String serverLevel, String errorType, String seqNum){
		StringBuffer sb = new StringBuffer();
		sb.append(applicationLevel);
		sb.append(serverLevel);
		sb.append(errorType);
		sb.append(seqNum);
		
		return sb.toString();
	}

	public static String formCatystLoginErrType() {
	
		StringBuffer sb = new StringBuffer();
		sb.append(TranslationKeyTypeError.CatalystErrorType.CATALYST_MESSAGE.getType()); 
		sb.append(TranslationKeyTypeError.CatalystErrorType.ERROR.getType());
		sb.append(TranslationKeyTypeError.CatalystErrorType.AUTHENTICATION.getType());
		
		return sb.toString();
	}
	
	public static String formCatystImplementationErrType() {
		
		StringBuffer sb = new StringBuffer();
		sb.append(TranslationKeyTypeError.CatalystErrorType.CATALYST_MESSAGE.getType()); 
		sb.append(TranslationKeyTypeError.CatalystErrorType.ERROR.getType());
		sb.append(TranslationKeyTypeError.CatalystErrorType.SERVICES.getType());
		
		return sb.toString();
	}
	
	public static String formCatystDatabaseErrType() {
		
		StringBuffer sb = new StringBuffer();
		sb.append(TranslationKeyTypeError.CatalystErrorType.CATALYST_MESSAGE.getType()); 
		sb.append(TranslationKeyTypeError.CatalystErrorType.ERROR.getType());
		sb.append(TranslationKeyTypeError.CatalystErrorType.DATABASE.getType());
		
		return sb.toString();
	}

	public static String formCatystFrontEndErrType() {
		
		StringBuffer sb = new StringBuffer();
		sb.append(TranslationKeyTypeError.CatalystErrorType.CATALYST_MESSAGE.getType()); 
		sb.append(TranslationKeyTypeError.CatalystErrorType.ERROR.getType());
		sb.append(TranslationKeyTypeError.CatalystErrorType.FRONTEND.getType());
		
		return sb.toString();
	}
	
	public static String formCatystErrorCode(String errorType, String seqNum){
			
		StringBuffer sb = new StringBuffer();
		sb.append(errorType);
		sb.append(seqNum);
		
		return sb.toString();
	}
	
	public static void formCatalystLoginError(LRNError lrnError, String errorCode, SeverityLevel severityLevel) {
		
		lrnError.setCatalystErrCd(
				ErrorUtils.formCatystErrorCode(
						ErrorUtils.formCatystLoginErrType(),errorCode));
		ErrorUtils.printCatalystError(severityLevel, errorCode,
				lrnError.getMessage());
	}
	
	public static void formCatalystSystemError(LRNError lrnError) {
		
		lrnError.setCatalystErrCd(ErrorUtils.formCatystErrorCode(
				ErrorUtils.formCatystDatabaseErrType(),
				TranslationKeyTypeError.CatalystErrorSeq.DATABASE_SYSTEM_ERR.getCode()));
		ErrorUtils.printCatalystError(TranslationKeyTypeError.SeverityLevel.SEVERE, 
						TranslationKeyTypeError.CatalystErrorSeq.DATABASE_SYSTEM_ERR.getCode(), 
						lrnError.getMessage());
	}
	
	public static void formCatalystServicesError(LRNError lrnError, String errorCode, SeverityLevel severityLevel) {
		
		lrnError.setCatalystErrCd(
				ErrorUtils.formCatystErrorCode(
				ErrorUtils.formCatystImplementationErrType(),errorCode));
		ErrorUtils.printCatalystError(severityLevel, errorCode, lrnError.getMessage());
	
	}
	
	public static void formCatalystFrontEndError(LRNError lrnError, String errorCode, SeverityLevel severityLevel) {
		
		lrnError.setCatalystErrCd(
				ErrorUtils.formCatystErrorCode(
				ErrorUtils.formCatystFrontEndErrType(),errorCode));
		ErrorUtils.printCatalystError(severityLevel, errorCode, lrnError.getMessage());
	
	}

	public static void printCatalystError( SeverityLevel severityLevel, String errorCode, String errorMessage) {
		StringBuffer sb = new StringBuffer();
		sb.append(ErrorUtils.getCurrentTime());
		sb.append(" - ");
		sb.append(severityLevel);
		sb.append(errorCode);
		sb.append(" - ");
		sb.append(errorMessage);
		logger.error(sb.toString());
	}
	
	public static Timestamp getCurrentTime() {
		 Date date= new Date();
		 return new Timestamp(date.getTime());
	}

}
