package com.lrn.manager.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import com.lrn.dao.IGenericDao;
import com.lrn.dao.IPasswordRecoverDao;
import com.lrn.manager.IPasswordRecoverManager;
import com.lrn.model.hibernate.PasswordRecover;
import com.lrn.util.StringUtil;

/**
 * The Class PasswordRecoverManager
 * 
 * @author kishor.pawar
 */
public class PasswordRecoverManager extends GenericManager<PasswordRecover, String> implements
		IPasswordRecoverManager {
	
	private IPasswordRecoverDao passwordRecoverDao;
	
	public void setPasswordRecoverDao(IPasswordRecoverDao passwordRecoverDao) {
		this.passwordRecoverDao = passwordRecoverDao;
	}

	public PasswordRecoverManager(
			IGenericDao<PasswordRecover, String> iGenericDao) {
		super(iGenericDao);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String setPasswordRecoverKey(String userId) {
		String key = null;
		StringBuilder md5Hash = new StringBuilder();
		md5Hash.append(userId).append(new Long(System.currentTimeMillis()).toString());
		md5Hash.append(userId);
		try {
			key = StringUtil.generateMD5Hash(md5Hash.toString());
			PasswordRecover passwordRecover = new PasswordRecover();
			passwordRecover.setKey(key);
			passwordRecover.setCreationDate(new Date());
			passwordRecover.setUserId(userId);
			passwordRecoverDao.save(passwordRecover);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return key;
	}

	@Override
	public List<PasswordRecover> checkPasswordRecoverKey(String key) {
		String[] paramNames = {"key"};
		Object[] paramValues = {key};
		return passwordRecoverDao.findByNamedQuery("checkPasswordRecoverKey", paramNames, paramValues);
	}
}