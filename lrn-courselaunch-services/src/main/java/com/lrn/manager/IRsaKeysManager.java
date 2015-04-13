package com.lrn.manager;

import java.util.List;

import com.lrn.dao.IRsaKeysDao;
import com.lrn.model.hibernate.RsaKeys;

/**
 * The Interface IRsaKeysManager.

 */
public interface IRsaKeysManager extends IGenericManager<RsaKeys, Long> {

	/**
     * Gets list of RsaKeys by siteId and RsaKeys Type
     *
     * @param Long siteId
     * @param String type
     * 
     * @return List<RsaKeys>
     */
	public void setRsaKeysDao(IRsaKeysDao rsaKeysDao);
	
	public List<RsaKeys> getRsaKeysBySiteId(Long siteId);

	
	
}