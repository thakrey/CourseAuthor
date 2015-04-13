package com.lrn.manager;

import java.util.List;

import com.lrn.model.hibernate.PasswordRecover;

/**
 * The Interface IPasswordRecoverManager
 * 
 */
public interface IPasswordRecoverManager extends IGenericManager<PasswordRecover, String> {
	
	String setPasswordRecoverKey(String userId);
	
	List<PasswordRecover> checkPasswordRecoverKey(String key);
	
}
